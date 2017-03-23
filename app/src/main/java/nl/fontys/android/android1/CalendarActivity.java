package nl.fontys.android.android1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;

/**
 * Created by Korben on 16.2.2017.
 */

public class CalendarActivity extends BaseActivity implements TokenFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(R.string.title_calendar);

        ViewStub stub = (ViewStub) findViewById(R.id.content);
        stub.setLayoutResource(R.layout.content_calendar);
        View inflated = stub.inflate();
    }

    @Override
    public void onFragmentInteraction(String token) {
        Log.d("Token:", token);
    }
}
