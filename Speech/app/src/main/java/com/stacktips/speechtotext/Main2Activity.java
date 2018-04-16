package com.stacktips.speechtotext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

public class Main2Activity extends AppCompatActivity {
    private EditText inputValue;
    private Button typeBtn;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        final HashMap<String, String> hashMap = (HashMap<String, String>)intent.getSerializableExtra("map");

        inputValue = (EditText) findViewById(R.id.eta1);
        typeBtn = (Button) findViewById(R.id.btna1);
        textView = (TextView) findViewById(R.id.textView);

        typeBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String value = inputValue.getText().toString();
                // use hash map from previous activity
                if(hashMap.get(value) !=  null){
                    textView.setText("\n"+ value + "\n" + hashMap.get(value).toString());
                }
            }
        });
    }

}

