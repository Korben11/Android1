package nl.fontys.android.android1;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;


/**
 * Created by Korben on 16.2.2017.
 */

public class DrawActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(R.string.title_draw);

        ViewStub stub = (ViewStub) findViewById(R.id.content);
        stub.setLayoutResource(R.layout.content_draw);
        View inflated = stub.inflate();
    }
}
