package com.example.handball_project;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class Tore9mActivity extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("match");

    private static final String TAG = "Tore9mActivity";

    private TextView textViewName;
    private TextView textViewNumber;

    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_match);

        player = (Player) getIntent().getSerializableExtra("match");
        db = FirebaseFirestore.getInstance();

        textViewName = findViewById(R.id.name);
        textViewNumber = findViewById(R.id.number);
        textViewName.setText(player.getName());
        textViewNumber.setText(player.getNumber());

        getPlayer();

    }


    public void getPlayer() {
        notebookRef.addSnapshotListener(this, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot queryDocumentSnapshots, FirebaseFirestoreException e) {
                if (e != null) {
                    return;
                }
                String data = "";
                String data2 = "";


                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                    Player note = documentSnapshot.toObject(Player.class);
                    note.setDocumentId(documentSnapshot.getId());

                    String name = note.getName();
                    String number=note.getNumber();


                    data +=  name + "\n";
                    data2 += number + "\n";

                }

                textViewName.setText(data);
                textViewNumber.setText(data2);

            }
        });

    }



}
