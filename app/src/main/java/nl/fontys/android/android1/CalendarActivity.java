package nl.fontys.android.android1;

import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

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
 * Created by Korben on 16.2.2017.
 */

public class CalendarActivity extends BaseActivity implements TokenFragment.OnFragmentInteractionListener{
//public class CalendarActivity extends BaseActivity{
    private String token;
    private ListView lv;
    private List<Calendar> calendars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(R.string.title_calendar);

        ViewStub stub = (ViewStub) findViewById(R.id.content);
        stub.setLayoutResource(R.layout.content_calendar);
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) stub.getLayoutParams();
        params.topMargin = 120;
        View inflated = stub.inflate();

//        try {
//            URL url = new URL("https://api.fhict.nl/schedule/me");
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestProperty("Accept", "application/json");
//            connection.setRequestProperty("Authorization", "Bearer " + token);
//            connection.connect();
//            InputStream is = connection.getInputStream();
//            InputStreamReader isr = new InputStreamReader(is);
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



//        calendars.add(new Calendar("Peter", "idk", "12", "ab-12"));
//        calendars.add(new Calendar("Ivana", "idk", "12", "ab-12"));
//        calendars.add(new Calendar("Natalia", "idk", "12", "ab-12"));
//        calendars.add(new Calendar("Daniel", "idk", "12", "ab-12"));
//        calendars.add(new Calendar("Veva", "idk", "12", "ab-12"));
//        calendars.add(new Calendar("Vlad", "idk", "14", "ab-12"));
//        calendars.add(new Calendar("Vasil", "idk", "12", "ab-12"));
//        calendars.add(new Calendar("Stefan", "jlk", "12", "ab-12"));
//        calendars.add(new Calendar("Juraj", "jkl", "12", "ab-12"));
//        calendars.add(new Calendar("hola", "jkl", "12", "ab-12"));
//        calendars.add(new Calendar("Peter", "idk", "12", "ab-12"));
//        calendars.add(new Calendar("Ivana", "idk", "12", "ab-12"));
//        calendars.add(new Calendar("Natalia", "idk", "12", "ab-12"));
//        calendars.add(new Calendar("Daniel", "idk", "12", "ab-12"));
//        calendars.add(new Calendar("Veva", "idk", "12", "ab-12"));
//        calendars.add(new Calendar("Vlad", "idk", "14", "ab-12"));
//        calendars.add(new Calendar("Vasil", "idk", "12", "ab-12"));
//        calendars.add(new Calendar("Stefan", "jlk", "12", "ab-12"));
//        calendars.add(new Calendar("Juraj", "jkl", "12", "ab-12"));
//        calendars.add(new Calendar("hola", "jkl", "12", "ab-12"));
//        calendars.add(new Calendar("Peter", "idk", "12", "ab-12"));
//        calendars.add(new Calendar("Ivana", "idk", "12", "ab-12"));
//        calendars.add(new Calendar("Natalia", "idk", "12", "ab-12"));
//        calendars.add(new Calendar("Daniel", "idk", "12", "ab-12"));
//        calendars.add(new Calendar("Veva", "idk", "12", "ab-12"));
//        calendars.add(new Calendar("Vlad", "idk", "14", "ab-12"));
//        calendars.add(new Calendar("Vasil", "idk", "12", "ab-12"));
//        calendars.add(new Calendar("Stefan", "jlk", "12", "ab-12"));
//        calendars.add(new Calendar("Juraj", "jkl", "12", "ab-12"));
//        calendars.add(new Calendar("hola", "jkl", "12", "ab-12"));
//        calendars.add(new Calendar("Peter", "idk", "12", "ab-12"));
//        calendars.add(new Calendar("Ivana", "idk", "12", "ab-12"));
//        calendars.add(new Calendar("Natalia", "idk", "12", "ab-12"));
//        calendars.add(new Calendar("Daniel", "idk", "12", "ab-12"));
//        calendars.add(new Calendar("Veva", "idk", "12", "ab-12"));
//        calendars.add(new Calendar("Vlad", "idk", "14", "ab-12"));
//        calendars.add(new Calendar("Vasil", "idk", "12", "ab-12"));
//        calendars.add(new Calendar("Stefan", "jlk", "12", "ab-12"));
//        calendars.add(new Calendar("Juraj", "jkl", "12", "ab-12"));
//        calendars.add(new Calendar("hola", "jkl", "12", "ab-12"));

//        CalendarAdapter calendarAdapter = new CalendarAdapter(getApplicationContext(), calendars);
//
//        lv.setAdapter(calendarAdapter);
    }

    @Override
    public void onFragmentInteraction(String token) {
        this.token = token;
        Log.d("Token", "Token: " + token);
        lv = (ListView) findViewById(R.id.listView);
        new JSONTask(this, lv).execute(token);
    }
}
