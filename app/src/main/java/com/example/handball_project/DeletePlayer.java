package com.example.handball_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class DeletePlayer extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextName;
    private EditText editTextSurname;
    private EditText editTextNumber;
    private EditText editTextDate;

    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_player);

        db = FirebaseFirestore.getInstance();

        editTextName = findViewById(R.id.edittext_name);
        editTextSurname = findViewById(R.id.edittext_surname);
        editTextNumber = findViewById(R.id.edittext_number);
        editTextDate = findViewById(R.id.edittext_date);


        findViewById(R.id.button_save).setOnClickListener(this);
        findViewById(R.id.textview_view_persons).setOnClickListener(this);
    }

    private boolean hasValidationErrors(String name, String surname, String number, String date) {
        if (name.isEmpty()) {
            editTextName.setError("Name required");
            editTextName.requestFocus();
            return true;
        }

        if (surname.isEmpty()) {
            editTextSurname.setError("Surname required");
            editTextSurname.requestFocus();
            return true;
        }

        if (number.isEmpty()) {
            editTextNumber.setError("Number required");
            editTextNumber.requestFocus();
            return true;
        }

        if (date.isEmpty()) {
            editTextDate.setError("Date required");
            editTextDate.requestFocus();
            return true;
        }

        return false;
    }


    private void saveProduct(){
        String name = editTextName.getText().toString().trim();
        String surname = editTextSurname.getText().toString().trim();
        String number = editTextNumber.getText().toString().trim();
        String date = editTextDate.getText().toString().trim();


        if (!hasValidationErrors(name, surname, number, date)) {

            CollectionReference dbProducts = db.collection("eyll");

            Person person = new Person(
                    name,
                    surname,
                    number,
                    date
            );

            dbProducts.add(person)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(DeletePlayer.this, "Person Added", Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(DeletePlayer.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

        }
        finish();
        startActivity(getIntent()); //save butonundan sonra sayfa yenilenir
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.button_save:
                saveProduct();
                break;

            case R.id.textview_view_persons:
                startActivity(new Intent(this, PersonsActivity.class));
                break;
        }



    }
}
