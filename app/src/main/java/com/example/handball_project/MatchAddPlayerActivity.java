package com.example.handball_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MatchAddPlayerActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("eyll");
    private Spinner who; // tanımmlıyoruz



    private EditText editTextGoalkeeper1;
    private EditText editTextGNumber1;


    private ArrayList player;
    private  ArrayAdapter adapter;

    //private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_add_player);


        findViewById(R.id.button_saveplayer).setOnClickListener(this);

        db = FirebaseFirestore.getInstance(); //database bağlantısını kuruyoruz.
        who=(Spinner) findViewById(R.id.deneme);


        editTextGoalkeeper1 = findViewById(R.id.Goalkeeper1);
        editTextGNumber1 = findViewById(R.id.GNumber1);



    }

    @Override
    protected void onStart() {
        super.onStart();

        player = new ArrayList<>();
        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, player);
        Query query = db.collection("eyll");

        db.collection("eyll")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        QuerySnapshot doc = task.getResult();
                        for (DocumentSnapshot documentSnapshot : doc.getDocuments()){
                            String tower_name = documentSnapshot.get("name").toString();
                            player.add(tower_name);
                        }
                    }
                });
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        who.setAdapter(adapter);
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
    private boolean hasValidationErrors(String Goalkeeper1, String GNumber1) {
        if (Goalkeeper1.isEmpty()) {
            editTextGoalkeeper1.setError("Opponent required");
            editTextGoalkeeper1.requestFocus();
            return true;
        }

        if (GNumber1.isEmpty()) {
            editTextGNumber1.setError("Place required");
            editTextGNumber1.requestFocus();
            return true;
        }


        return false;
    }

    private void savePlayer(){
        String Goalkeeper1 = editTextGoalkeeper1.getText().toString().trim();
        String GNumber1 = editTextGNumber1.getText().toString().trim();

        String whoo = who.getSelectedItem().toString().trim();

        Map<String, Object> player = new HashMap<>();
        player.put("name", Goalkeeper1);
        player.put("number", GNumber1);
        player.put("deneme", whoo);

        db.collection("matchkaleci").document("a")
                .set(player)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MatchAddPlayerActivity.this, "Added", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MatchAddPlayerActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });



    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.button_saveplayer:
                savePlayer();
                startActivity(new Intent(this, MatchCreateActivity.class));
                break;

        }

    }
}
