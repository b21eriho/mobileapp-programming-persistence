package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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

        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ContentValues values = new ContentValues();
                values.put(DataBaseHelper.COLLUMN_NAME, String.valueOf(nameInput.getText()));
                values.put(DataBaseHelper.COLLUMN_BRAND, String.valueOf(brandInput.getText()));
                values.put(DataBaseHelper.COLLUMN_NR_WHEELS, String.valueOf(nrWheelsInput.getText()));
                db.getWritableDatabase().insert(DataBaseHelper.TABLE_BIKE, null, values);

            }
        });

        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cursor = db.getReadableDatabase().rawQuery("SELECT * FROM " + DataBaseHelper.TABLE_BIKE + " ORDER BY " + DataBaseHelper.COLLUMN_ID, null, null);

                String output = "";

                while (cursor.moveToNext()) {
                    output += "Bike. Name:" + cursor.getString(cursor.getColumnIndexOrThrow(DataBaseHelper.COLLUMN_NAME)) + " Brand:" +
                    cursor.getString(cursor.getColumnIndexOrThrow(DataBaseHelper.COLLUMN_BRAND)) + " Number of wheels:" +
                    cursor.getString(cursor.getColumnIndexOrThrow(DataBaseHelper.COLLUMN_NR_WHEELS)) + "\n";
                }
                cursor.close();
                outputField.setText(output);

            }
        });

    }
}
