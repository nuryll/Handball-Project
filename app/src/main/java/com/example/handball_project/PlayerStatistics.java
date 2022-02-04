package com.example.handball_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class PlayerStatistics extends AppCompatActivity {


    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("eyll");

    private static final String TAG = "PlayerStatistics";

    private TextView textViewData;
    private TextView textViewSurname;
    private TextView textViewNumber;
    private TextView textViewDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_statistics);

        textViewData = findViewById(R.id.text_view_data);
        textViewSurname = findViewById(R.id.text_view_surname);
        textViewNumber = findViewById(R.id.text_view_number);
        textViewDate = findViewById(R.id.text_view_date);

    }

    @Override
    protected void onStart() {
        super.onStart();
        notebookRef.addSnapshotListener(this, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot queryDocumentSnapshots, FirebaseFirestoreException e) {
                if (e != null) {
                    return;
                }
                String data = "";
                String data2 = "";
                String data3 = "";
                String data4 = "";

                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                    Person note = documentSnapshot.toObject(Person.class);
                    note.setDocumentId(documentSnapshot.getId());

                    String name = note.getName();
                    String surname = note.getSurname();
                    String number=note.getNumber();
                    String date=note.getDate();

                    data +=  name + "\n\n";
                    data2 += surname + "\n\n";
                    data3 += number + "\n\n";
                    data4 += date + "\n\n";
                }
                textViewData.setText(data);
                textViewSurname.setText(data2);
                textViewNumber.setText(data3);
                textViewDate.setText(data4);
            }
        });
    }

}
