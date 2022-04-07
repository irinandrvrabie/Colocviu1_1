package ro.pub.cs.systems.eim.colocviu1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Colocviu1_1SecondaryActivity extends AppCompatActivity {

    private EditText secondEditText;
    private Button registerButton, cancelButton;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Toast toast;
            switch (view.getId()) {
                case R.id.register_button:
                    setResult(RESULT_OK, null);
                    toast = Toast.makeText(getApplicationContext(), "Register", Toast.LENGTH_SHORT);
                    toast.show();
                    break;
                case R.id.cancel_button:
                    setResult(RESULT_CANCELED, null);
                    toast = Toast.makeText(getApplicationContext(), "Cancel", Toast.LENGTH_SHORT);
                    toast.show();
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu1_1_secondary);
        secondEditText = (EditText)findViewById(R.id.second_edit_text);
        registerButton = (Button)findViewById(R.id.register_button);
        cancelButton = (Button)findViewById(R.id.cancel_button);

        registerButton.setOnClickListener(buttonClickListener);
        cancelButton.setOnClickListener(buttonClickListener);

        secondEditText.setText(getIntent().getExtras().getString(Constants.info));
    }
}