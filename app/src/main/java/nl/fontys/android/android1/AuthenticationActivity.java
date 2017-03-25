package nl.fontys.android.android1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;

/**
 * Created by Korben on 23.3.2017.
 */

public class AuthenticationActivity extends BaseActivity implements TokenFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle("Authentication");

        ViewStub stub = (ViewStub) findViewById(R.id.content);
        stub.setLayoutResource(R.layout.content_authentication);
        View inflated = stub.inflate();
    }

    @Override
    public void onFragmentInteraction(String token) {

        Log.d("Token", "Token: " + token);
    }
}
