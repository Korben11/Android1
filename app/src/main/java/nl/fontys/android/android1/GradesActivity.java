package nl.fontys.android.android1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;

public class GradesActivity extends BaseActivity implements TokenFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(R.string.title_grades);

        ViewStub stub = (ViewStub) findViewById(R.id.content);
        stub.setLayoutResource(R.layout.content_grades);
        View inflated = stub.inflate();
    }

    @Override
    public void onFragmentInteraction(String token) {
        Log.d("Token:", token);
    }
}
