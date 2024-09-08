package com.princemaurya.pillbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SetMedicineCount extends AppCompatActivity {

    EditText medName,medCount;
    TextView heading;

    Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_medicine_count);
        Intent i=getIntent();
        String MedType=i.getStringExtra("medType");


        medName=findViewById(R.id.editText);
        medCount=findViewById(R.id.editText2);
        heading=findViewById(R.id.textView8);

        String a="Enter The details for Medicine" + MedType;

        heading.setText(a);
    }
}