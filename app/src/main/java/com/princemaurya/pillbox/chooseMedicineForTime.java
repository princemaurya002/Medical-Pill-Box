package com.princemaurya.pillbox;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class chooseMedicineForTime extends AppCompatActivity implements View.OnClickListener{

    Button btna,btnb,btnc,btnd;
    TextView meda,medb,medc,medd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicine);

        Intent i=getIntent();
y
        btna=findViewById(R.id.appCompatButton8);
        btnb=findViewById(R.id.appCompatButton3);
        btnc=findViewById(R.id.appCompatButton5);
        btnd=findViewById(R.id.appCompatButton6);

        meda=findViewById(R.id.textView9);
        medb=findViewById(R.id.textView12);
        medc=findViewById(R.id.textView13);
        medd=findViewById(R.id.textView14);

        btna.setOnClickListener(this);
        btnb.setOnClickListener(this);
        btnc.setOnClickListener(this);
        btnd.setOnClickListener(this);

    }

    public void onClick(View v){
        int btnid=v.getId();

        if(btnid==R.id.appCompatButton8){
            String medA="A";
            Intent i= new Intent(getApplicationContext(), AddMedicineTime.class);
            i.putExtra("medType",medA);
            startActivity(i);

        }
        else if (btnid==R.id.appCompatButton3) {
            String medB="B";
            Intent i= new Intent(getApplicationContext(), AddMedicineTime.class);
            i.putExtra("medType",medB);
            startActivity(i);

        }
        else if (btnid==R.id.appCompatButton5) {
            String medC="C";
            Intent i= new Intent(getApplicationContext(), AddMedicineTime.class);
            i.putExtra("medType",medC);
            startActivity(i);
        }
        else if (btnid==R.id.appCompatButton6) {
            String medD="D";
            Intent i= new Intent(getApplicationContext(), AddMedicineTime.class);
            i.putExtra("medType",medD);
            startActivity(i);
        }

    }
}