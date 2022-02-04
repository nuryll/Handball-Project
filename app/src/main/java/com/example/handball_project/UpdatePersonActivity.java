package com.example.handball_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

public class UpdatePersonActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextName;
    private EditText editTextSurname;
    private EditText editTextNumber;
    private EditText editTextDate;


    private FirebaseFirestore db;

    private Person person;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_person);

        person = (Person) getIntent().getSerializableExtra("eyll");
        db = FirebaseFirestore.getInstance();

        editTextName = findViewById(R.id.edittext_name);
        editTextSurname = findViewById(R.id.edittext_surname);
        editTextNumber = findViewById(R.id.edittext_number);
        editTextDate = findViewById(R.id.edittext_date);


        editTextName.setText(person.getName());
        editTextSurname.setText(person.getSurname());
        editTextNumber.setText(person.getNumber());
        editTextDate.setText(String.valueOf(person.getDate()));



        findViewById(R.id.button_update).setOnClickListener(this);
        findViewById(R.id.button_delete).setOnClickListener(this);
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


    private void updateProduct() {
        String name = editTextName.getText().toString().trim();
        String surname = editTextSurname.getText().toString().trim();
        String number = editTextNumber.getText().toString().trim();
        String date = editTextDate.getText().toString().trim();


        if (!hasValidationErrors(name, surname, number, date)) {

            Person p = new Person(
                    name, surname, number,
                    date

            );


            db.collection("eyll").document(person.getId())
                    .update(
                            "name", p.getName(),
                            "surname", p.getSurname(),
                            "number", p.getNumber(),
                            "date", p.getDate()
                    )
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(UpdatePersonActivity.this, "Person Updated", Toast.LENGTH_LONG).show();
                            finish();
                            startActivity(new Intent(UpdatePersonActivity.this, PersonsActivity.class));
                        }
                    });
        }
    }

    private void deleteProduct() {
        db.collection("eyll").document(person.getId()).delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(UpdatePersonActivity.this, "Person deleted", Toast.LENGTH_LONG).show();
                            finish();
                            startActivity(new Intent(UpdatePersonActivity.this, PersonsActivity.class));
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_update:
                updateProduct();
                break;
            case R.id.button_delete:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Are you sure about this?");
                builder.setMessage("Deletion is permanent...");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deleteProduct();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog ad = builder.create();
                ad.show();

                break;
        }
    }
}
