package com.example.fit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class Create extends AppCompatActivity {
    ChipNavigationBar chipNavigationBar;
    Button btn1;
    Spinner spi1,spi2;
    EditText edit1,edit2;
    TextView nmee;

    int  bloodlevel,oxylevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_create);
        chipNavigationBar = findViewById(R.id.bottom_menu1);
        chipNavigationBar.setItemSelected(R.id.orders,true);

        spi1 = findViewById(R.id.spin1);
        spi2 = findViewById(R.id.spin2);
        edit1 = findViewById(R.id.blood);
        edit2 = findViewById(R.id.oxygen);
        nmee = findViewById(R.id.namemain);

        bottomMenu();

        btn1 = findViewById(R.id.viewres);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcu();
            }
        });
    }

    private void calcu() {
        bloodlevel = Integer.parseInt(edit1.getText().toString());
        oxylevel = Integer.parseInt(edit2.getText().toString());
        String sp1 = spi1.getSelectedItem().toString();
        String sp2 = spi2.getSelectedItem().toString();
        String nmmmmme = nmee.getText().toString();

            Intent blo = new Intent(this, Profile.class);
            blo.putExtra("Blood_level", bloodlevel);
            blo.putExtra("Oxy_level", oxylevel);
            blo.putExtra("getData",sp1);
            blo.putExtra("getData1",sp2);
            blo.putExtra("getData2",nmmmmme);
            this.startActivity(blo);

    }
    private void bottomMenu() {
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch(i)
                {
                    case R.id.home:
                        Intent intent = new Intent(Create.this,
                                MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.orders:
                        Intent intent1 = new Intent(Create.this,
                                Create.class);
                        startActivity(intent1);
                        break;
                    case R.id.profile:
                        Intent intent2 = new Intent(Create.this,
                                Profile.class);
                        startActivity(intent2);
                        break;
                }
            }
        });

    }
}