package com.example.fit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class Profile extends AppCompatActivity {
    ChipNavigationBar chipNavigationBar;
    TextView t1,t2,t3,t4,t5;
    DatabaseReference db1;
    TextView nmee;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_profile);
        //database hooks
        db1 = FirebaseDatabase.getInstance().getReference("Users");

        chipNavigationBar = findViewById(R.id.bottom_menu2);
        chipNavigationBar.setItemSelected(R.id.profile,true);
        t1 = findViewById(R.id.res1);
        t2 = findViewById(R.id.res2);
        t3 = findViewById(R.id.res3);
        t4 = findViewById(R.id.res4);
        t5 = findViewById(R.id.res5);

        nmee = findViewById(R.id.Nameview);
        bottomMenu();
        Retrive();
        addarists();




    }
    private void Retrive() {
//        activity one to activity two
        int blo1 = getIntent().getIntExtra("Blood_level",0);
        int oxy = getIntent().getIntExtra("Oxy_level",0);
        String value= getIntent().getStringExtra("getData");
        String value1= getIntent().getStringExtra("getData1");
        String valll = getIntent().getStringExtra("getData2");
        nmee.setText(valll);
        //asthma Prediction
        if((oxy ==92) || (oxy == 96))
        {
            t5.setText("Asthma consult your doctor");
        }
        else if(value.equals("20 - 30 breaths"))
        {
            t5.setText("Asthma consult your doctor");
        }

        //oxygen saturation
        if(oxy <=96){
            t2.setText("Caution : danger | Hypoxemia");
        }
        else if((oxy>=97) || (oxy<=98))
        {
            t2.setText("Normal");
        }
        else if(oxy>=101)
        {
            t2.setText(" Enter Percentage between 1 - 100");
        }

        //Heart  Rate
        if(value1.equals("less than 120")){
            t4.setText("Normal");
        }
        else if(value1.equals("120 - 129"))
        {

            t4.setText("Elevated Level");
        }
        else if(value1.equals("130 - 139"))
        {
            t4.setText("High Blood pressure | Hyper Tension");
        }
        else if(value1.equals("140 and Above"))
        {
            t4.setText("High Blood pressure Consult your doctor immediately");
        }


        //Respiration
        if(value.equals("New Born")){
            t3.setText("30 - 60 Breaths Per Minute");
        }
        else if(value.equals("6 months"))
        {
            t3.setText("24 - 30 Breaths Per Minute");
        }
        else if(value.equals("12 months"))
        {
            t3.setText("24 - 30 Breaths Per Minute");
        }
        else if(value.equals("1-4 years"))
        {
            t3.setText("20 - 30 Breaths Per Minute");
        }
        else if(value.equals("12 and Above"))
        {
            t3.setText("12 - 20 Breaths Per Minute");
        }
        //Blood level
        if ((blo1 <= 140))
        {
            // t1.setText(Integer.valueOf(blo1));
            t1.setText("7.8 mmol/L is normal");
        }
        else if((blo1 >= 200))
        {
//            t1.setText(Integer.valueOf(blo1));
            t1.setText("11.1 mmol/L Sorry diabetes");
        }
        else if((blo1 >= 141)  || (blo1 <=199))
        {
//          t1.setText(Integer.valueOf(blo1));
            t1.setText("17.8 mmol/L prediabetes ");
        }

    }

    private void addarists() {
        String j1 = t1.getText().toString();
        String j2 = t2.getText().toString();
        String sp111 = t3.getText().toString();
        String sp112 = t4.getText().toString();
        String name = nmee.getText().toString();
        String asthma = t5.getText().toString();
//        database
        String id = db1.push().getKey();
        //object creation
        John artist  = new John(id,sp111,j1,sp112,j2,asthma,name);
        //Artistsaving
        db1.child(id).setValue(artist);
        Toast.makeText(this,"Successfully added", Toast.LENGTH_LONG).show();
    }

    private void bottomMenu() {
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch(i)
                {
                    case R.id.home:
                        Intent intent = new Intent(Profile.this,
                                MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.orders:
                        Intent intent1 = new Intent(Profile.this,
                                Create.class);
                        startActivity(intent1);
                        break;
                    case R.id.profile:
                        Intent intent2 = new Intent(Profile.this,
                                Profile.class);
                        startActivity(intent2);
                        break;
                }
            }
        });
    }
}