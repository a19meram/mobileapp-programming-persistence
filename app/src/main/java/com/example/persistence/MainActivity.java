package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                Integer integerAge = Integer.valueOf(age.getText().toString());
                String stringProgram = program.getText().toString();

                DatabaseHelper helperClass = new DatabaseHelper(MainActivity.this);
                Student studentClass = new Student(stringName, stringProgram, integerAge);
                helperClass.addStudent(studentClass);
                Toast.makeText(MainActivity.this, "grattis den är addad", Toast.LENGTH_LONG).show();

                finish();
                startActivity(getIntent());


            }
        });

        //Starting the read button
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StudentRead.class);
                startActivity(intent);
            }
        });

    }
}
