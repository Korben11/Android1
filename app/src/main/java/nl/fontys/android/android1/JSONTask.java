package nl.fontys.android.android1;

import android.os.AsyncTask;
import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import static android.util.JsonToken.BEGIN_ARRAY;
import static android.util.JsonToken.BEGIN_OBJECT;
import static android.util.JsonToken.STRING;

/**
 * Created by Stefan on 23-Mar-17.
 */

public class JSONTask extends AsyncTask<String, Void, String[]> {

    private String[] calendarValues = new String[4];
    private List<Calendar> calendars = new LinkedList<Calendar>();
    private String start,end;

    @Override
    protected String[] doInBackground(String... params) {
        //retrieve data from the json file


        try{
            URL url = new URL("https://api.fhict.nl/schedule/me");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + params[0]);
            connection.connect();

            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            JsonReader jsonReader = new JsonReader(isr);

            if(jsonReader.peek() == BEGIN_OBJECT){
                jsonReader.beginObject();
                while(jsonReader.hasNext()){
                    if(jsonReader.nextName().equals("data")){
                        if(jsonReader.peek() == BEGIN_ARRAY){
                            if (jsonReader.peek() == BEGIN_OBJECT){
                                jsonReader.beginObject();
                                while(jsonReader.hasNext()){
                                    String name = jsonReader.nextName();
                                    if(name.equals("room") && jsonReader.peek() == STRING){
                                        String subName = jsonReader.nextString();
                                        calendarValues[0] = subName;
                                    }else if(name.equals("subject") && jsonReader.peek() == STRING){
                                        String subName = jsonReader.nextString();
                                        calendarValues[1] = subName;
                                    }else if(name.equals("teacherAbbreviation") && jsonReader.peek() == STRING){
                                        String subName = jsonReader.nextString();
                                        calendarValues[2] = subName;
                                    }else if(name.equals("start") && jsonReader.peek() == STRING){
                                        String subName = jsonReader.nextString();
                                        start = subName;
                                    }else if(name.equals("end") && jsonReader.peek() == STRING){
                                        String subName = jsonReader.nextString();
                                        end = subName;
                                    } else jsonReader.skipValue();
                                }
                                jsonReader.endObject();
                                jsonReader.endArray();
                            }
                        }
                    } else{
                        jsonReader.skipValue();
                    }
                    jsonReader.endObject();
                }
            }

        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return new String[0];
    }

    protected void onPostExecute(String[] result) {
        //update the ui
        //pass info to the adapter
        //ctreate adapter , set adapter to listview
    }
}