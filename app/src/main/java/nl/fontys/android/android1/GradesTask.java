package nl.fontys.android.android1;

import android.content.Context;
import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static android.util.JsonToken.BEGIN_ARRAY;
import static android.util.JsonToken.BEGIN_OBJECT;
import static android.util.JsonToken.BOOLEAN;
import static android.util.JsonToken.NUMBER;
import static android.util.JsonToken.STRING;

/**
 * Created by Stefan on 30-Mar-17.
 */

public class GradesTask  extends AsyncTask<String,Void,ArrayList<Grades>>{
    Context context;
    ListView lv;

    public GradesTask(Context context, ListView lv) {
        this.context = context;
        this.lv = lv;
    }

    @Override
    protected ArrayList<Grades> doInBackground(String... params) {
        ArrayList<Grades> grades = new ArrayList<Grades>();

        try{
            URL url = new URL("https://api.fhict.nl/grades/me");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + params[0]);
            connection.connect();
            Log.d("Token", "Got connection");

            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            JsonReader jsonReader = new JsonReader(isr);

            if(jsonReader.peek() == BEGIN_ARRAY){
                jsonReader.beginArray();
                while(jsonReader.hasNext()){
                    if(jsonReader.peek() == BEGIN_OBJECT){
                        jsonReader.beginObject();
                        String date="",item="";
                        int grade=0; boolean passed = false;
                        while(jsonReader.hasNext()){
                          String name = jsonReader.nextName();
                            if(name.equals("date")&& jsonReader.peek()==STRING){
                             date = jsonReader.nextString();
                            } else if (name.equals("item")&& jsonReader.peek()==STRING){
                                item = jsonReader.nextString();
                            } else if (name.equals("grade") && jsonReader.peek()==NUMBER){
                                grade = jsonReader.nextInt();
                            } else if (name.equals("passed") && jsonReader.peek()==BOOLEAN){
                                passed = jsonReader.nextBoolean();
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        grades.add(new Grades(item,date,grade,passed));
                        jsonReader.endObject();
                    }
                }
                jsonReader.endArray();
            }
        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        Log.d("Token", "Returning calendars");
        return grades;
    }

    @Override
    protected void onPostExecute(ArrayList<Grades> grades) {
        //update the ui
        //pass info to the adapter
        //ctreate adapter , set adapter to listview
        GradesAdapter gradesAdapter = new GradesAdapter(context, grades);
        lv.setAdapter(gradesAdapter);
    }
}
