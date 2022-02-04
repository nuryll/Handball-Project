package com.example.handball_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // btnDegisken Adında bir degişken oluşturduk...
    Button btnDegisken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  // Üst sınıf metodunu çağırma
        setContentView(R.layout.activity_main);  // Ana aktivite .xml dosyası çağırma

        // edit_team butonunu btnDegisken isimli değişkene atadık.
        btnDegisken    =   (Button) findViewById(R.id.edit_team);
        // btnDegisken isimli elemena tıklanma işlemini gerçekleştiren kod alanı
        btnDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Butona tıklandığında ne yapmasını gerektiğini belirttik
                Intent gecisYap = new Intent(MainActivity.this, EditTeam.class);
                startActivity(gecisYap);
            }
        });


        // player_statistics butonunu btnDegisken isimli değişkene atadık.
        btnDegisken    =   (Button) findViewById(R.id.player_statistics);
        // btnDegisken isimli elemena tıklanma işlemini gerçekleştiren kod alanı
        btnDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Butona tıklandığında ne yapmasını gerektiğini belirttik
                Intent gecisYap = new Intent(MainActivity.this, PlayerStatistics.class);
                startActivity(gecisYap);
            }
        });


        // start_match butonunu btnDegisken isimli değişkene atadık.
        btnDegisken    =   (Button) findViewById(R.id.start_match);
        // btnDegisken isimli elemena tıklanma işlemini gerçekleştiren kod alanı
        btnDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Butona tıklandığında ne yapmasını gerektiğini belirttik
                Intent gecisYap = new Intent(MainActivity.this, MatchCreateActivity.class);
                startActivity(gecisYap);
            }
        });


        // settings butonunu btnDegisken isimli değişkene atadık.
        btnDegisken    =   (Button) findViewById(R.id.settings);
        // btnDegisken isimli elemena tıklanma işlemini gerçekleştiren kod alanı
        btnDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Butona tıklandığında ne yapmasını gerektiğini belirttik
                Intent gecisYap = new Intent(MainActivity.this, Settings.class);
                startActivity(gecisYap);
            }
        });








    }

}
