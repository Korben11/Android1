package nl.fontys.android.android1;

import android.content.Context;
import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static android.util.JsonToken.BEGIN_ARRAY;
import static android.util.JsonToken.BEGIN_OBJECT;
import static android.util.JsonToken.STRING;

/**
 * Created by Stefan on 23-Mar-17.
 */

public class JSONTask extends AsyncTask<String, Void, ArrayList<Calendar>> {
    Context context;
    ListView lv;

    public JSONTask(Context context, ListView lv) {
        this.context = context;
        this.lv = lv;
    }

    @Override
    protected ArrayList<Calendar> doInBackground(String... params) {
        ArrayList<Calendar> calendars = new ArrayList<Calendar>();

        try{
            URL url = new URL("https://api.fhict.nl/schedule/me");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + params[0]);
            connection.connect();
            Log.d("Token", "Got connection");

            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            JsonReader jsonReader = new JsonReader(isr);

            if(jsonReader.peek() == BEGIN_OBJECT){
                jsonReader.beginObject();
                while(jsonReader.hasNext()){
                    if(jsonReader.nextName().equals("data")){
                        Log.d("Token", "Line 59");
                        if(jsonReader.peek() == BEGIN_ARRAY){
                            jsonReader.beginArray();
                            while (jsonReader.hasNext()){
                                if (jsonReader.peek() == BEGIN_OBJECT){
                                    String room = "", subject = "", teacherAbbreviation = "", start = "", end = "";
                                    jsonReader.beginObject();
                                    while(jsonReader.hasNext()){
                                        String name = jsonReader.nextName();
                                        if(name.equals("room") && jsonReader.peek() == STRING){
                                            room = jsonReader.nextString();
                                        }else if(name.equals("subject") && jsonReader.peek() == STRING){
                                            subject = jsonReader.nextString();
                                        }else if(name.equals("teacherAbbreviation") && jsonReader.peek() == STRING){
                                            teacherAbbreviation = jsonReader.nextString();
                                        }else if(name.equals("start") && jsonReader.peek() == STRING){
                                            start = jsonReader.nextString();
                                        }else if(name.equals("end") && jsonReader.peek() == STRING){
                                            end = jsonReader.nextString();
                                        }else {
                                            jsonReader.skipValue();
                                        }
                                    }
                                    String duration = start;
                                    // TODO: take look on some Time class and calculate duration
                                    calendars.add(new Calendar(teacherAbbreviation, subject, start, end, room));
                                    jsonReader.endObject();
                                }
                            }
                            jsonReader.endArray();
                        }
                    } else{
                        Log.d("Token", "Skip value");
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
            }
        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        Log.d("Token", "Returning calendars");
        return calendars;
    }

    @Override
    protected void onPostExecute(ArrayList<Calendar> calendars) {
        //update the ui
        //pass info to the adapter
        //ctreate adapter , set adapter to listview
        CalendarAdapter calendarAdapter = new CalendarAdapter(context, calendars);
        lv.setAdapter(calendarAdapter);
    }
}