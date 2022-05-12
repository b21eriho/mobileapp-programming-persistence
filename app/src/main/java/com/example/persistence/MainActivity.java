package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button writeButton;
    private Button readButton;

    private TextView outputField;

    private EditText nameInput;
    private EditText brandInput;
    private EditText nrWheelsInput;

    private DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writeButton = findViewById(R.id.writeButton);
        readButton = findViewById(R.id.readButton);

        outputField = findViewById(R.id.output);

        nameInput = findViewById(R.id.nameInput);
        brandInput = findViewById(R.id.brandInput);
        nrWheelsInput = findViewById(R.id.wheelInput);

        db = new DataBaseHelper(this);


    }
}
