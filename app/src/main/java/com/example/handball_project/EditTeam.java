package com.example.handball_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EditTeam extends AppCompatActivity {

    // btnDegisken Adında bir degişken oluşturduk...
    Button btnDegisken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_team);


        // addplayer butonunu btnDegisken isimli değişkene atadık.
        btnDegisken    =   (Button) findViewById(R.id.add_player);
        // btnDegisken isimli elemena tıklanma işlemini gerçekleştiren kod alanı
        btnDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Butona tıklandığında ne yapmasını gerektiğini belirttik
                Intent gecisYap = new Intent(EditTeam.this, AddPlayer.class);
                startActivity(gecisYap);
            }
        });


       /* // deleteplayer butonunu btnDegisken isimli değişkene atadık.
        btnDegisken    =   (Button) findViewById(R.id.delete_player);
        // btnDegisken isimli elemena tıklanma işlemini gerçekleştiren kod alanı
        btnDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Butona tıklandığında ne yapmasını gerektiğini belirttik
                Intent gecisYap = new Intent(EditTeam.this, PersonsActivity.class);
                startActivity(gecisYap);
            }
        });*/


        // updateplayer butonunu btnDegisken isimli değişkene atadık.
        btnDegisken    =   (Button) findViewById(R.id.update_player);
        // btnDegisken isimli elemena tıklanma işlemini gerçekleştiren kod alanı
        btnDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Butona tıklandığında ne yapmasını gerektiğini belirttik
                Intent gecisYap = new Intent(EditTeam.this, PersonsActivity.class);
                startActivity(gecisYap);
            }
        });
    }

}
