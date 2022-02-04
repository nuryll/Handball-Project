package com.example.handball_project;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;

public class MatchCreateActivity extends AppCompatActivity implements View.OnClickListener {

    //Bu sayfaya anasayfadan startmatch butonu ile geçiş yapılır. Maça ait bilgiler girilecektir.


    private EditText editTextOpponent; //Karşı takım
    private EditText editTextPlace;  //Maçın yapıldığı yer
    private EditText editTextDate;   //Maçın yapıldığı tarıh
    private EditText editTextReferee;  //Hakem

    //Takvim ile ilgili veriler
    private Button selectDate;
    private DatePickerDialog datePickerDialog;
    private TextView dateTxt;
    private Calendar calendar;
    private int year, month, dayOfMonth;

    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_create);

       // findViewById(R.id.textview_view_letsgo).setEnabled(false);

        db = FirebaseFirestore.getInstance();

        editTextOpponent = findViewById(R.id.edittext_opponent);
        editTextPlace = findViewById(R.id.edittext_place);
        editTextDate = findViewById(R.id.edittext_date);
        editTextReferee = findViewById(R.id.edittext_referee);

        findViewById(R.id.button_save).setOnClickListener(this);
       findViewById(R.id.button_addplayer).setOnClickListener(this);


        //TAKVİM
        selectDate = findViewById(R.id.selectDate);
        dateTxt = findViewById(R.id.dateTxt);
        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(MatchCreateActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                dateTxt.setText(day + "/" + (month+1) + "/" + year);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.show();
            }
        });


    }

    private boolean hasValidationErrors(String opponent, String place, String date, String referee) {
        if (opponent.isEmpty()) {
            editTextOpponent.setError("Opponent required");
            editTextOpponent.requestFocus();
            return true;
        }

        if (place.isEmpty()) {
            editTextPlace.setError("Place required");
            editTextPlace.requestFocus();
            return true;
        }

        if (date.isEmpty()) {
            dateTxt.setError("Date required");
            dateTxt.requestFocus();
            return true;
        }

        if (referee.isEmpty()) {
            editTextReferee.setError("Referee required");
            editTextReferee.requestFocus();
            return true;
        }

        return false;
    }

    private void saveProduct(){
        String opponent = editTextOpponent.getText().toString().trim();
        String place = editTextPlace.getText().toString().trim();
        String date = dateTxt.getText().toString().trim();
        String referee = editTextReferee.getText().toString().trim();

        if (!hasValidationErrors(opponent, place, date, referee)) {

            CollectionReference dbCreateMatch = db.collection("creatematch");

            Creatematch creatematch = new Creatematch(
                    opponent,
                    place,
                    date,
                    referee

            );

            dbCreateMatch.add(creatematch)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(MatchCreateActivity.this, "Added", Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(MatchCreateActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

        }



    }


    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.button_save:
                saveProduct();
               // findViewById(R.id.textview_view_letsgo).setEnabled(true);
                startActivity(new Intent(this, StartMatch.class));
                break;
           case R.id.button_addplayer:
                startActivity(new Intent(this, MatchAddPlayerActivity.class));
                break;
        }

    }

}
