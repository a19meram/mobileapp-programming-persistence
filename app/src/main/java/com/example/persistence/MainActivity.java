package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Start creating variables
    EditText name, age, program;
    Button read, write;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //giving references to use them later
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        program = findViewById(R.id.program);
        read = findViewById(R.id.read);
        write =findViewById(R.id.write);

        //after a click on write button get EditText value in string and integer
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringName = name.getText().toString();
                String integerAge = age.getText().toString();
                String stringProgram = program.getText().toString();
            }
        });


    }
}
