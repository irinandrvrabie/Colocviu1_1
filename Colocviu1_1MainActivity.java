package ro.pub.cs.systems.eim.colocviu1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Colocviu1_1MainActivity extends AppCompatActivity {
    private Button south, north, east, west, navigate;
    private EditText textbox, clicksBox;
    private int clicks = 0;
    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.west:
                    clicks++;
                    textbox.setText(textbox.getText().append("West, "));
                    clicksBox.setText(String.valueOf(clicks));
                    break;
                case R.id.south:
                    clicks++;
                    textbox.setText(textbox.getText().append("South, "));
                    clicksBox.setText(String.valueOf(clicks));
                    break;
                case R.id.east:
                    clicks++;
                    textbox.setText(textbox.getText().append("East, "));
                    clicksBox.setText(String.valueOf(clicks));
                    break;
                case R.id.north:
                    clicks++;
                    textbox.setText(textbox.getText().append("North, "));
                    clicksBox.setText(String.valueOf(clicks));
                    break;
                case R.id.go_to_secondary_button:
                    Intent intent = new Intent(getApplicationContext(), Colocviu1_1SecondaryActivity.class);
                    intent.putExtra(Constants.info, textbox.getText());
                    textbox.setText("");
                    clicksBox.setText("0");
                    Constants.allClicks = String.valueOf(clicks);
                    startActivityForResult(intent, Constants.requestCode);
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        south = (Button)findViewById(R.id.south);
        north = (Button)findViewById(R.id.north);
        east = (Button)findViewById(R.id.east);
        west = (Button)findViewById(R.id.west);
        navigate = (Button)findViewById(R.id.go_to_secondary_button);
        textbox = (EditText) findViewById(R.id.edit_text);
        clicksBox = (EditText) findViewById(R.id.clicks);
        textbox.setText(" ");

        south.setOnClickListener(buttonClickListener);
        north.setOnClickListener(buttonClickListener);
        east.setOnClickListener(buttonClickListener);
        west.setOnClickListener(buttonClickListener);
        navigate.setOnClickListener(buttonClickListener);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(Constants.allClicks,String.valueOf(clicks));
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(Constants.allClicks)) {
            clicks = Integer.parseInt(Constants.allClicks);
            clicksBox.setText(String.valueOf(clicks));
        } else {
            clicks = 0;
            clicksBox.setText(String.valueOf(clicks));
        }
    }
}