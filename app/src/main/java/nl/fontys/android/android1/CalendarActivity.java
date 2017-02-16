package nl.fontys.android.android1;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;

/**
 * Created by Korben on 16.2.2017.
 */

public class CalendarActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewStub stub = (ViewStub) findViewById(R.id.content);
        stub.setLayoutResource(R.layout.content_calendar);
        View inflated = stub.inflate();
    }
}
