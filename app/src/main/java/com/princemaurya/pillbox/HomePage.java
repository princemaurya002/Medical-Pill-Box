package com.princemaurya.pillbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class HomePage extends AppCompatActivity implements View.OnClickListener {

    Button addMedicine,setMedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Intent i=getIntent();

        addMedicine=findViewById(R.id.appCompatButton2);
        setMedTime=findViewById(R.id.appCompatButton7);

        setMedTime.setOnClickListener(this);
        addMedicine.setOnClickListener(this);

    }
    public void onClick(View v) {
        int clickedbtnid = v.getId();

        if (clickedbtnid == R.id.appCompatButton7) {
            //String Med="To ";
            Intent intent = new Intent(getApplicationContext(), chooseMedicineForTime.class);
            //i.putExtra("MedType",Med);
            startActivity(intent);
            //Toast.makeText(getApplicationContext(),Med, Toast.LENGTH_SHORT).show();
        } else if (clickedbtnid == R.id.appCompatButton2) {
            // String Med="Med B";
            Intent i = new Intent(getApplicationContext(), AddMedicine.class);
            // i.putExtra("MedType",Med);
            startActivity(i);
            // Toast.makeText(getApplicationContext(),"B", Toast.LENGTH_SHORT).show();

        }

    }

}