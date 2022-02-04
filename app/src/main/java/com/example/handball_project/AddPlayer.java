package com.example.handball_project;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class AddPlayer extends AppCompatActivity implements View.OnClickListener {


    private static final String TAG = "AddPlayer";  //Sayfada uyarı mesajı için

    //EditText alanından kaydedilecek veriler
    private EditText editTextName;
    private EditText editTextSurname;
    private EditText editTextNumber;

    private Spinner who; //kaleci mi oyuncu mu tanımmlıyoruz


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
        setContentView(R.layout.activity_add_player);


        db = FirebaseFirestore.getInstance(); //database bağlantısını kuruyoruz.

        //editText verilerinin idlerini alıyoruz
        editTextName=findViewById(R.id.editName);
        editTextSurname=findViewById(R.id.editSurname);
        editTextNumber=findViewById(R.id.editNumber);
        who=(Spinner) findViewById(R.id.spinner1); //kaleci,oyuncu seçimi

        findViewById(R.id.button_save).setOnClickListener(this); //bilgiler girildikten sonra kaydet butonu

        FirebaseFirestore db = FirebaseFirestore.getInstance();


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
                datePickerDialog = new DatePickerDialog(AddPlayer.this,
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


    private boolean validateInputs(String name, String surname, String number){
//girilen bilgiler boş bırakılamaz uyarısı
        if(name.isEmpty()){
            editTextName.setError("Name required");
            editTextName.requestFocus();
            return true;
        }

        if(surname.isEmpty()){
            editTextSurname.setError("Surname required");
            editTextSurname.requestFocus();
            return true;
        }

        if(number.isEmpty()){
            editTextNumber.setError("Number required");
            editTextNumber.requestFocus();
            return true;
        }

        return false;

    }



    //database kaydedilir.
    @Override
    public void onClick(View v) {

        String name = editTextName.getText().toString().trim();
        String surname = editTextSurname.getText().toString().trim();
        String number = editTextNumber.getText().toString().trim();
        String date = dateTxt.getText().toString().trim();
        String whoo = who.getSelectedItem().toString().trim();

        if (!validateInputs(name, surname, number)) {
            // Add a new document with a generated id.
            Map<String, Object> data = new HashMap<>();
            data.put("name", name);
            data.put("surname", surname);
            data.put("number", number);
            data.put("date", date);
            data.put("who", whoo);

            db.collection("eyll")
                    .add(data)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Log.d(TAG, "DocumentSnapshot written with ID: " + documentReference.getId());
                            Toast.makeText(AddPlayer.this, "Player Added", Toast.LENGTH_LONG).show();
                            //bilgiler kaydedildi uyarısı verir.
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Error adding document", e);
                        }
                    });


            finish();
            startActivity(getIntent()); //save butonundan sonra sayfa yenilenir

        }




    }

}
