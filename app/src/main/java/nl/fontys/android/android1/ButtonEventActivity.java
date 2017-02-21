package nl.fontys.android.android1;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Korben on 21.2.2017.
 */

public class ButtonEventActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(R.string.title_button_event);

        ViewStub stub = (ViewStub) findViewById(R.id.content);
        stub.setLayoutResource(R.layout.content_on_click);
        View inflated = stub.inflate();

        final Button button = (Button) findViewById(R.id.btn_on_click);

        button.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View v){
                TextView textView = (TextView) findViewById(R.id.textViewOnClick);
                textView.setText("Long click event occured!");
                return true;
            }
        });

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText editText = (EditText) findViewById(R.id.editTextOnClickString);
                TextView textView = (TextView) findViewById(R.id.textViewOnClick);
                textView.setText(editText.getText().toString());
            }
        });
    }
}
