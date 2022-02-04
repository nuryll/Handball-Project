package com.example.handball_project;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.HashMap;
import java.util.Map;

public class StartMatch extends AppCompatActivity implements View.OnClickListener{


    // SCREENSHOT
    private AppCompatActivity activity = StartMatch.this;
    private RelativeLayout parentView;
    private Button buttonScreenshotActivity;
    private Button buttonScreenshotView;
    private Button buttonSaveScreenshot;
    private Button buttonReset;
    private ImageView imageViewShowScreenshot;
    private Bitmap bitmap;
    // SCREENSHOT
    //-------------------------------------------------------------------------------
    //SAVEALL
    private Button saveAll;

    //-------------------------------------------------------------------------------
    //Database bağlantısı
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("match");
    //-------------------------------------------------------------------------------
    private static final String TAG = "StartMatch"; //Sayfada uyarı mesajlarını görüntüler
    //-------------------------------------------------------------------------------
    //Create Match sayfasındaki verileri veritabanından alır.
    private TextView textViewData;
    private TextView textViewNumber;
    private TextView textViewOpponent;
    private TextView textViewPlace;
    private TextView textViewDate;
    private TextView textViewReferee;

    //-------------------------------------------------------------------------------
    //index değerlerini arttır azalt
    public int sayit9m1 = 1;//arttır azalt
    public int sayit9m2 = 1;//arttır azalt
    public int sayit9m3 = 1;//arttır azalt
    public int sayit9m4 = 1;//arttır azalt
    public int sayit9m5 = 1;//arttır azalt
    public int sayit9m6 = 1;//arttır azalt
    public int sayit9m7 = 1;//arttır azalt
    public int sayit9m8 = 1;//arttır azalt
    public int sayit9m9 = 1;//arttır azalt
    public int sayit9m10 = 1;//arttır azalt
    public int sayit9m11 = 1;//arttır azalt
    public int sayit9m12 = 1;//arttır azalt
    public int sayit9m13 = 1;//arttır azalt
    public int sayit9m14 = 1;//arttır azalt
    public int sayit9m15 = 1;//arttır azalt
    public int sayit9m16 = 1;//arttır azalt
    public int sayit9m17 = 1;//arttır azalt


    public int sayit6m1 = 1;//arttır azalt
    public int sayit6m2 = 1;//arttır azalt
    public int sayit6m3 = 1;//arttır azalt
    public int sayit6m4 = 1;//arttır azalt
    public int sayit6m5 = 1;//arttır azalt
    public int sayit6m6 = 1;//arttır azalt
    public int sayit6m7 = 1;//arttır azalt
    public int sayit6m8 = 1;//arttır azalt
    public int sayit6m9 = 1;//arttır azalt
    public int sayit6m10 = 1;//arttır azalt
    public int sayit6m11 = 1;//arttır azalt
    public int sayit6m12 = 1;//arttır azalt
    public int sayit6m13 = 1;//arttır azalt
    public int sayit6m14 = 1;//arttır azalt
    public int sayit6m15 = 1;//arttır azalt
    public int sayit6m16 = 1;//arttır azalt
    public int sayit6m17 = 1;//arttır azalt

    public int sayitWelle1 = 1;//arttır azalt
    public int sayitWelle2 = 1;//arttır azalt
    public int sayitWelle3 = 1;//arttır azalt
    public int sayitWelle4 = 1;//arttır azalt
    public int sayitWelle5 = 1;//arttır azalt
    public int sayitWelle6 = 1;//arttır azalt
    public int sayitWelle7 = 1;//arttır azalt
    public int sayitWelle8 = 1;//arttır azalt
    public int sayitWelle9 = 1;//arttır azalt
    public int sayitWelle10 = 1;//arttır azalt
    public int sayitWelle11 = 1;//arttır azalt
    public int sayitWelle12 = 1;//arttır azalt
    public int sayitWelle13 = 1;//arttır azalt
    public int sayitWelle14 = 1;//arttır azalt
    public int sayitWelle15 = 1;//arttır azalt
    public int sayitWelle16 = 1;//arttır azalt
    public int sayitWelle17 = 1;//arttır azalt


    public int sayitartı1 = 1;//arttır azalt
    public int sayitartı2 = 1;//arttır azalt
    public int sayitartı3 = 1;//arttır azalt
    public int sayitartı4 = 1;//arttır azalt
    public int sayitartı5 = 1;//arttır azalt
    public int sayitartı6 = 1;//arttır azalt
    public int sayitartı7 = 1;//arttır azalt
    public int sayitartı8 = 1;//arttır azalt
    public int sayitartı9 = 1;//arttır azalt
    public int sayitartı10 = 1;//arttır azalt
    public int sayitartı11 = 1;//arttır azalt
    public int sayitartı12 = 1;//arttır azalt
    public int sayitartı13 = 1;//arttır azalt
    public int sayitartı14 = 1;//arttır azalt
    public int sayitartı15 = 1;//arttır azalt
    public int sayitartı16 = 1;//arttır azalt
    public int sayitartı17 = 1;//arttır azalt

    public int sayiteksi1 = 1;//arttır azalt
    public int sayiteksi2 = 1;//arttır azalt
    public int sayiteksi3 = 1;//arttır azalt
    public int sayiteksi4 = 1;//arttır azalt
    public int sayiteksi5 = 1;//arttır azalt
    public int sayiteksi6 = 1;//arttır azalt
    public int sayiteksi7 = 1;//arttır azalt
    public int sayiteksi8 = 1;//arttır azalt
    public int sayiteksi9 = 1;//arttır azalt
    public int sayiteksi10 = 1;//arttır azalt
    public int sayiteksi11 = 1;//arttır azalt
    public int sayiteksi12 = 1;//arttır azalt
    public int sayiteksi13 = 1;//arttır azalt
    public int sayiteksi14 = 1;//arttır azalt
    public int sayiteksi15 = 1;//arttır azalt
    public int sayiteksi16 = 1;//arttır azalt
    public int sayiteksi17 = 1;//arttır azalt

    public int sayitdm1 = 1;//arttır azalt
    public int sayitdm2 = 1;//arttır azalt
    public int sayitdm3 = 1;//arttır azalt
    public int sayitdm4 = 1;//arttır azalt
    public int sayitdm5 = 1;//arttır azalt
    public int sayitdm6 = 1;//arttır azalt
    public int sayitdm7 = 1;//arttır azalt
    public int sayitdm8 = 1;//arttır azalt
    public int sayitdm9 = 1;//arttır azalt
    public int sayitdm10 = 1;//arttır azalt
    public int sayitdm11 = 1;//arttır azalt
    public int sayitdm12 = 1;//arttır azalt
    public int sayitdm13 = 1;//arttır azalt
    public int sayitdm14 = 1;//arttır azalt
    public int sayitdm15 = 1;//arttır azalt
    public int sayitdm16 = 1;//arttır azalt
    public int sayitdm17 = 1;//arttır azalt

    public int sayitam1 = 1;//arttır azalt
    public int sayitam2 = 1;//arttır azalt
    public int sayitam3 = 1;//arttır azalt
    public int sayitam4 = 1;//arttır azalt
    public int sayitam5 = 1;//arttır azalt
    public int sayitam6 = 1;//arttır azalt
    public int sayitam7 = 1;//arttır azalt
    public int sayitam8 = 1;//arttır azalt
    public int sayitam9 = 1;//arttır azalt
    public int sayitam10 = 1;//arttır azalt
    public int sayitam11 = 1;//arttır azalt
    public int sayitam12 = 1;//arttır azalt
    public int sayitam13 = 1;//arttır azalt
    public int sayitam14 = 1;//arttır azalt
    public int sayitam15 = 1;//arttır azalt
    public int sayitam16 = 1;//arttır azalt
    public int sayitam17 = 1;//arttır azalt

    public int sayitkonter1 = 1;//arttır azalt
    public int sayitkonter2 = 1;//arttır azalt
    public int sayitkonter3 = 1;//arttır azalt
    public int sayitkonter4 = 1;//arttır azalt
    public int sayitkonter5 = 1;//arttır azalt
    public int sayitkonter6 = 1;//arttır azalt
    public int sayitkonter7 = 1;//arttır azalt
    public int sayitkonter8 = 1;//arttır azalt
    public int sayitkonter9 = 1;//arttır azalt
    public int sayitkonter10 = 1;//arttır azalt
    public int sayitkonter11 = 1;//arttır azalt
    public int sayitkonter12 = 1;//arttır azalt
    public int sayitkonter13 = 1;//arttır azalt
    public int sayitkonter14 = 1;//arttır azalt
    public int sayitkonter15 = 1;//arttır azalt
    public int sayitkonter16 = 1;//arttır azalt
    public int sayitkonter17 = 1;//arttır azalt


    public int sayitdp1 = 1;//arttır azalt
    public int sayitdp2 = 1;//arttır azalt
    public int sayitdp3 = 1;//arttır azalt
    public int sayitdp4 = 1;//arttır azalt
    public int sayitdp5 = 1;//arttır azalt
    public int sayitdp6 = 1;//arttır azalt
    public int sayitdp7 = 1;//arttır azalt
    public int sayitdp8 = 1;//arttır azalt
    public int sayitdp9 = 1;//arttır azalt
    public int sayitdp10 = 1;//arttır azalt
    public int sayitdp11 = 1;//arttır azalt
    public int sayitdp12 = 1;//arttır azalt
    public int sayitdp13 = 1;//arttır azalt
    public int sayitdp14 = 1;//arttır azalt
    public int sayitdp15 = 1;//arttır azalt
    public int sayitdp16 = 1;//arttır azalt
    public int sayitdp17 = 1;//arttır azalt

    public int sayitff1 = 1;//arttır azalt
    public int sayitff2 = 1;//arttır azalt
    public int sayitff3 = 1;//arttır azalt
    public int sayitff4 = 1;//arttır azalt
    public int sayitff5 = 1;//arttır azalt
    public int sayitff6 = 1;//arttır azalt
    public int sayitff7 = 1;//arttır azalt
    public int sayitff8 = 1;//arttır azalt
    public int sayitff9 = 1;//arttır azalt
    public int sayitff10 = 1;//arttır azalt
    public int sayitff11 = 1;//arttır azalt
    public int sayitff12 = 1;//arttır azalt
    public int sayitff13 = 1;//arttır azalt
    public int sayitff14 = 1;//arttır azalt
    public int sayitff15 = 1;//arttır azalt
    public int sayitff16 = 1;//arttır azalt
    public int sayitff17 = 1;//arttır azalt

    public int sayitfp1 = 1;//arttır azalt
    public int sayitfp2 = 1;//arttır azalt
    public int sayitfp3 = 1;//arttır azalt
    public int sayitfp4 = 1;//arttır azalt
    public int sayitfp5 = 1;//arttır azalt
    public int sayitfp6 = 1;//arttır azalt
    public int sayitfp7 = 1;//arttır azalt
    public int sayitfp8 = 1;//arttır azalt
    public int sayitfp9 = 1;//arttır azalt
    public int sayitfp10 = 1;//arttır azalt
    public int sayitfp11 = 1;//arttır azalt
    public int sayitfp12 = 1;//arttır azalt
    public int sayitfp13 = 1;//arttır azalt
    public int sayitfp14 = 1;//arttır azalt
    public int sayitfp15 = 1;//arttır azalt
    public int sayitfp16 = 1;//arttır azalt
    public int sayitfp17 = 1;//arttır azalt

    public int sayitsr1 = 1;//arttır azalt
    public int sayitsr2 = 1;//arttır azalt
    public int sayitsr3 = 1;//arttır azalt
    public int sayitsr4 = 1;//arttır azalt
    public int sayitsr5 = 1;//arttır azalt
    public int sayitsr6 = 1;//arttır azalt
    public int sayitsr7 = 1;//arttır azalt
    public int sayitsr8 = 1;//arttır azalt
    public int sayitsr9 = 1;//arttır azalt
    public int sayitsr10 = 1;//arttır azalt
    public int sayitsr11 = 1;//arttır azalt
    public int sayitsr12 = 1;//arttır azalt
    public int sayitsr13 = 1;//arttır azalt
    public int sayitsr14 = 1;//arttır azalt
    public int sayitsr15 = 1;//arttır azalt
    public int sayitsr16 = 1;//arttır azalt
    public int sayitsr17 = 1;//arttır azalt

    public int sayitsf1 = 1;//arttır azalt
    public int sayitsf2 = 1;//arttır azalt
    public int sayitsf3 = 1;//arttır azalt
    public int sayitsf4 = 1;//arttır azalt
    public int sayitsf5 = 1;//arttır azalt
    public int sayitsf6 = 1;//arttır azalt
    public int sayitsf7 = 1;//arttır azalt
    public int sayitsf8 = 1;//arttır azalt
    public int sayitsf9 = 1;//arttır azalt
    public int sayitsf10 = 1;//arttır azalt
    public int sayitsf11 = 1;//arttır azalt
    public int sayitsf12 = 1;//arttır azalt
    public int sayitsf13 = 1;//arttır azalt
    public int sayitsf14 = 1;//arttır azalt
    public int sayitsf15 = 1;//arttır azalt
    public int sayitsf16 = 1;//arttır azalt
    public int sayitsf17 = 1;//arttır azalt

    public int sayitbeo1 = 1;//arttır azalt
    public int sayitbeo2 = 1;//arttır azalt
    public int sayitbeo3 = 1;//arttır azalt
    public int sayitbeo4 = 1;//arttır azalt
    public int sayitbeo5 = 1;//arttır azalt
    public int sayitbeo6 = 1;//arttır azalt
    public int sayitbeo7 = 1;//arttır azalt
    public int sayitbeo8 = 1;//arttır azalt
    public int sayitbeo9 = 1;//arttır azalt
    public int sayitbeo10 = 1;//arttır azalt
    public int sayitbeo11 = 1;//arttır azalt
    public int sayitbeo12 = 1;//arttır azalt
    public int sayitbeo13 = 1;//arttır azalt
    public int sayitbeo14 = 1;//arttır azalt
    public int sayitbeo15 = 1;//arttır azalt
    public int sayitbeo16 = 1;//arttır azalt
    public int sayitbeo17 = 1;//arttır azalt

    public int sayitfoul1 = 1;//arttır azalt
    public int sayitfoul2 = 1;//arttır azalt
    public int sayitfoul3 = 1;//arttır azalt
    public int sayitfoul4 = 1;//arttır azalt
    public int sayitfoul5 = 1;//arttır azalt
    public int sayitfoul6 = 1;//arttır azalt
    public int sayitfoul7 = 1;//arttır azalt
    public int sayitfoul8 = 1;//arttır azalt
    public int sayitfoul9 = 1;//arttır azalt
    public int sayitfoul10 = 1;//arttır azalt
    public int sayitfoul11 = 1;//arttır azalt
    public int sayitfoul12 = 1;//arttır azalt
    public int sayitfoul13 = 1;//arttır azalt
    public int sayitfoul14 = 1;//arttır azalt
    public int sayitfoul15 = 1;//arttır azalt
    public int sayitfoul16 = 1;//arttır azalt
    public int sayitfoul17 = 1;//arttır azalt

    public int sayitrausy1 = 1;//arttır azalt
    public int sayitrausy2 = 1;//arttır azalt
    public int sayitrausy3 = 1;//arttır azalt
    public int sayitrausy4 = 1;//arttır azalt
    public int sayitrausy5 = 1;//arttır azalt
    public int sayitrausy6 = 1;//arttır azalt
    public int sayitrausy7 = 1;//arttır azalt
    public int sayitrausy8 = 1;//arttır azalt
    public int sayitrausy9 = 1;//arttır azalt
    public int sayitrausy10 = 1;//arttır azalt
    public int sayitrausy11 = 1;//arttır azalt
    public int sayitrausy12 = 1;//arttır azalt
    public int sayitrausy13 = 1;//arttır azalt
    public int sayitrausy14 = 1;//arttır azalt
    public int sayitrausy15 = 1;//arttır azalt
    public int sayitrausy16 = 1;//arttır azalt
    public int sayitrausy17 = 1;//arttır azalt

    public int sayitrausi1 = 1;//arttır azalt
    public int sayitrausi2 = 1;//arttır azalt
    public int sayitrausi3 = 1;//arttır azalt
    public int sayitrausi4 = 1;//arttır azalt
    public int sayitrausi5 = 1;//arttır azalt
    public int sayitrausi6 = 1;//arttır azalt
    public int sayitrausi7 = 1;//arttır azalt
    public int sayitrausi8 = 1;//arttır azalt
    public int sayitrausi9 = 1;//arttır azalt
    public int sayitrausi10 = 1;//arttır azalt
    public int sayitrausi11 = 1;//arttır azalt
    public int sayitrausi12 = 1;//arttır azalt
    public int sayitrausi13 = 1;//arttır azalt
    public int sayitrausi14 = 1;//arttır azalt
    public int sayitrausi15 = 1;//arttır azalt
    public int sayitrausi16 = 1;//arttır azalt
    public int sayitrausi17 = 1;//arttır azalt

    public int sayitbecom1 = 1;//arttır azalt
    public int sayitbecom2 = 1;//arttır azalt
    public int sayitbecom3 = 1;//arttır azalt
    public int sayitbecom4 = 1;//arttır azalt
    public int sayitbecom5 = 1;//arttır azalt
    public int sayitbecom6 = 1;//arttır azalt
    public int sayitbecom7 = 1;//arttır azalt
    public int sayitbecom8 = 1;//arttır azalt
    public int sayitbecom9 = 1;//arttır azalt
    public int sayitbecom10 = 1;//arttır azalt
    public int sayitbecom11 = 1;//arttır azalt
    public int sayitbecom12 = 1;//arttır azalt
    public int sayitbecom13 = 1;//arttır azalt
    public int sayitbecom14 = 1;//arttır azalt
    public int sayitbecom15 = 1;//arttır azalt
    public int sayitbecom16 = 1;//arttır azalt
    public int sayitbecom17 = 1;//arttır azalt

    public int sayitred1 = 1;//arttır azalt
    public int sayitred2 = 1;//arttır azalt
    public int sayitred3 = 1;//arttır azalt
    public int sayitred4 = 1;//arttır azalt
    public int sayitred5 = 1;//arttır azalt
    public int sayitred6 = 1;//arttır azalt
    public int sayitred7 = 1;//arttır azalt
    public int sayitred8 = 1;//arttır azalt
    public int sayitred9 = 1;//arttır azalt
    public int sayitred10 = 1;//arttır azalt
    public int sayitred11 = 1;//arttır azalt
    public int sayitred12 = 1;//arttır azalt
    public int sayitred13 = 1;//arttır azalt
    public int sayitred14 = 1;//arttır azalt
    public int sayitred15 = 1;//arttır azalt
    public int sayitred16 = 1;//arttır azalt
    public int sayitred17 = 1;//arttır azalt


    private Button btnarttır;
    private Button btnazalt;

    private TextView t9m1;
    private TextView t9m2;
    private TextView t9m3;
    private TextView t9m4;
    private TextView t9m5;
    private TextView t9m6;
    private TextView t9m7;
    private TextView t9m8;
    private TextView t9m9;
    private TextView t9m10;
    private TextView t9m11;
    private TextView t9m12;
    private TextView t9m13;
    private TextView t9m14;
    private TextView t9m15;
    private TextView t9m16;
    private TextView t9m17;


    private TextView t6m1;
    private TextView t6m2;
    private TextView t6m3;
    private TextView t6m4;
    private TextView t6m5;
    private TextView t6m6;
    private TextView t6m7;
    private TextView t6m8;
    private TextView t6m9;
    private TextView t6m10;
    private TextView t6m11;
    private TextView t6m12;
    private TextView t6m13;
    private TextView t6m14;
    private TextView t6m15;
    private TextView t6m16;
    private TextView t6m17;

    private TextView tWelle1;
    private TextView tWelle2;
    private TextView tWelle3;
    private TextView tWelle4;
    private TextView tWelle5;
    private TextView tWelle6;
    private TextView tWelle7;
    private TextView tWelle8;
    private TextView tWelle9;
    private TextView tWelle10;
    private TextView tWelle11;
    private TextView tWelle12;
    private TextView tWelle13;
    private TextView tWelle14;
    private TextView tWelle15;
    private TextView tWelle16;
    private TextView tWelle17;


    private TextView tartı1;
    private TextView tartı2;
    private TextView tartı3;
    private TextView tartı4;
    private TextView tartı5;
    private TextView tartı6;
    private TextView tartı7;
    private TextView tartı8;
    private TextView tartı9;
    private TextView tartı10;
    private TextView tartı11;
    private TextView tartı12;
    private TextView tartı13;
    private TextView tartı14;
    private TextView tartı15;
    private TextView tartı16;
    private TextView tartı17;

    private TextView teksi1;
    private TextView teksi2;
    private TextView teksi3;
    private TextView teksi4;
    private TextView teksi5;
    private TextView teksi6;
    private TextView teksi7;
    private TextView teksi8;
    private TextView teksi9;
    private TextView teksi10;
    private TextView teksi11;
    private TextView teksi12;
    private TextView teksi13;
    private TextView teksi14;
    private TextView teksi15;
    private TextView teksi16;
    private TextView teksi17;

    private TextView tdm1;
    private TextView tdm2;
    private TextView tdm3;
    private TextView tdm4;
    private TextView tdm5;
    private TextView tdm6;
    private TextView tdm7;
    private TextView tdm8;
    private TextView tdm9;
    private TextView tdm10;
    private TextView tdm11;
    private TextView tdm12;
    private TextView tdm13;
    private TextView tdm14;
    private TextView tdm15;
    private TextView tdm16;
    private TextView tdm17;

    private TextView tam1;
    private TextView tam2;
    private TextView tam3;
    private TextView tam4;
    private TextView tam5;
    private TextView tam6;
    private TextView tam7;
    private TextView tam8;
    private TextView tam9;
    private TextView tam10;
    private TextView tam11;
    private TextView tam12;
    private TextView tam13;
    private TextView tam14;
    private TextView tam15;
    private TextView tam16;
    private TextView tam17;

    private TextView tkonter1;
    private TextView tkonter2;
    private TextView tkonter3;
    private TextView tkonter4;
    private TextView tkonter5;
    private TextView tkonter6;
    private TextView tkonter7;
    private TextView tkonter8;
    private TextView tkonter9;
    private TextView tkonter10;
    private TextView tkonter11;
    private TextView tkonter12;
    private TextView tkonter13;
    private TextView tkonter14;
    private TextView tkonter15;
    private TextView tkonter16;
    private TextView tkonter17;

    private TextView tdp1;
    private TextView tdp2;
    private TextView tdp3;
    private TextView tdp4;
    private TextView tdp5;
    private TextView tdp6;
    private TextView tdp7;
    private TextView tdp8;
    private TextView tdp9;
    private TextView tdp10;
    private TextView tdp11;
    private TextView tdp12;
    private TextView tdp13;
    private TextView tdp14;
    private TextView tdp15;
    private TextView tdp16;
    private TextView tdp17;

    private TextView tff1;
    private TextView tff2;
    private TextView tff3;
    private TextView tff4;
    private TextView tff5;
    private TextView tff6;
    private TextView tff7;
    private TextView tff8;
    private TextView tff9;
    private TextView tff10;
    private TextView tff11;
    private TextView tff12;
    private TextView tff13;
    private TextView tff14;
    private TextView tff15;
    private TextView tff16;
    private TextView tff17;

    private TextView tfp1;
    private TextView tfp2;
    private TextView tfp3;
    private TextView tfp4;
    private TextView tfp5;
    private TextView tfp6;
    private TextView tfp7;
    private TextView tfp8;
    private TextView tfp9;
    private TextView tfp10;
    private TextView tfp11;
    private TextView tfp12;
    private TextView tfp13;
    private TextView tfp14;
    private TextView tfp15;
    private TextView tfp16;
    private TextView tfp17;

    private TextView tsr1;
    private TextView tsr2;
    private TextView tsr3;
    private TextView tsr4;
    private TextView tsr5;
    private TextView tsr6;
    private TextView tsr7;
    private TextView tsr8;
    private TextView tsr9;
    private TextView tsr10;
    private TextView tsr11;
    private TextView tsr12;
    private TextView tsr13;
    private TextView tsr14;
    private TextView tsr15;
    private TextView tsr16;
    private TextView tsr17;

    private TextView tsf1;
    private TextView tsf2;
    private TextView tsf3;
    private TextView tsf4;
    private TextView tsf5;
    private TextView tsf6;
    private TextView tsf7;
    private TextView tsf8;
    private TextView tsf9;
    private TextView tsf10;
    private TextView tsf11;
    private TextView tsf12;
    private TextView tsf13;
    private TextView tsf14;
    private TextView tsf15;
    private TextView tsf16;
    private TextView tsf17;

    private TextView tbeo1;
    private TextView tbeo2;
    private TextView tbeo3;
    private TextView tbeo4;
    private TextView tbeo5;
    private TextView tbeo6;
    private TextView tbeo7;
    private TextView tbeo8;
    private TextView tbeo9;
    private TextView tbeo10;
    private TextView tbeo11;
    private TextView tbeo12;
    private TextView tbeo13;
    private TextView tbeo14;
    private TextView tbeo15;
    private TextView tbeo16;
    private TextView tbeo17;

    private TextView tfoul1;
    private TextView tfoul2;
    private TextView tfoul3;
    private TextView tfoul4;
    private TextView tfoul5;
    private TextView tfoul6;
    private TextView tfoul7;
    private TextView tfoul8;
    private TextView tfoul9;
    private TextView tfoul10;
    private TextView tfoul11;
    private TextView tfoul12;
    private TextView tfoul13;
    private TextView tfoul14;
    private TextView tfoul15;
    private TextView tfoul16;
    private TextView tfoul17;

    private TextView trausy1;
    private TextView trausy2;
    private TextView trausy3;
    private TextView trausy4;
    private TextView trausy5;
    private TextView trausy6;
    private TextView trausy7;
    private TextView trausy8;
    private TextView trausy9;
    private TextView trausy10;
    private TextView trausy11;
    private TextView trausy12;
    private TextView trausy13;
    private TextView trausy14;
    private TextView trausy15;
    private TextView trausy16;
    private TextView trausy17;

    private TextView trausi1;
    private TextView trausi2;
    private TextView trausi3;
    private TextView trausi4;
    private TextView trausi5;
    private TextView trausi6;
    private TextView trausi7;
    private TextView trausi8;
    private TextView trausi9;
    private TextView trausi10;
    private TextView trausi11;
    private TextView trausi12;
    private TextView trausi13;
    private TextView trausi14;
    private TextView trausi15;
    private TextView trausi16;
    private TextView trausi17;

    private TextView tbecom1;
    private TextView tbecom2;
    private TextView tbecom3;
    private TextView tbecom4;
    private TextView tbecom5;
    private TextView tbecom6;
    private TextView tbecom7;
    private TextView tbecom8;
    private TextView tbecom9;
    private TextView tbecom10;
    private TextView tbecom11;
    private TextView tbecom12;
    private TextView tbecom13;
    private TextView tbecom14;
    private TextView tbecom15;
    private TextView tbecom16;
    private TextView tbecom17;

    private TextView tred1;
    private TextView tred2;
    private TextView tred3;
    private TextView tred4;
    private TextView tred5;
    private TextView tred6;
    private TextView tred7;
    private TextView tred8;
    private TextView tred9;
    private TextView tred10;
    private TextView tred11;
    private TextView tred12;
    private TextView tred13;
    private TextView tred14;
    private TextView tred15;
    private TextView tred16;
    private TextView tred17;


    //-------------------------------------------------------------------------------
    //Kaleci kısmına dokundukca işaret bırakma
    //IMG1
    boolean isPressed = true;
    boolean isPressed2 = true;
    boolean isPressed3 = true;
    boolean isPressed4 = true;
    boolean isPressed5 = true;
    boolean isPressed6 = true;
    boolean isPressed7 = true;
    boolean isPressed8 = true;
    boolean isPressed9 = true;
    boolean isPressed10 = true;
    boolean isPressed11 = true;
    boolean isPressed12 = true;
    boolean isPressed13 = true;
    boolean isPressed14 = true;
    boolean isPressed15 = true;
    boolean isPressed16 = true;

    //IMG2
    boolean isPressedik = true;
    boolean isPressedik2 = true;
    boolean isPressedik3 = true;
    boolean isPressedik4 = true;
    boolean isPressedik5 = true;
    boolean isPressedik6 = true;
    boolean isPressedik7 = true;
    boolean isPressedik8 = true;
    boolean isPressedik9 = true;
    boolean isPressedik10 = true;
    boolean isPressedik11 = true;
    boolean isPressedik12 = true;
    boolean isPressedik13 = true;
    boolean isPressedik14 = true;
    boolean isPressedik15 = true;
    boolean isPressedik16 = true;

    //IMG3
    boolean isPressedük = true;
    boolean isPressedük2 = true;
    boolean isPressedük3 = true;
    boolean isPressedük4 = true;
    boolean isPressedük5 = true;
    boolean isPressedük6 = true;
    boolean isPressedük7 = true;
    boolean isPressedük8 = true;
    boolean isPressedük9 = true;
    boolean isPressedük10 = true;
    boolean isPressedük11 = true;
    boolean isPressedük12 = true;
    boolean isPressedük13 = true;
    boolean isPressedük14 = true;
    boolean isPressedük15 = true;
    boolean isPressedük16 = true;

    //IMG4
    boolean isPresseddk = true;
    boolean isPresseddk2 = true;
    boolean isPresseddk3 = true;
    boolean isPresseddk4 = true;
    boolean isPresseddk5 = true;
    boolean isPresseddk6 = true;
    boolean isPresseddk7 = true;
    boolean isPresseddk8 = true;
    boolean isPresseddk9 = true;
    boolean isPresseddk10 = true;
    boolean isPresseddk11 = true;
    boolean isPresseddk12 = true;
    boolean isPresseddk13 = true;
    boolean isPresseddk14 = true;
    boolean isPresseddk15 = true;
    boolean isPresseddk16 = true;

    //IMG5
    boolean isPressedbk = true;
    boolean isPressedbk2 = true;
    boolean isPressedbk3 = true;
    boolean isPressedbk4 = true;
    boolean isPressedbk5 = true;
    boolean isPressedbk6 = true;
    boolean isPressedbk7 = true;
    boolean isPressedbk8 = true;
    boolean isPressedbk9 = true;
    boolean isPressedbk10 = true;
    boolean isPressedbk11 = true;
    boolean isPressedbk12 = true;
    boolean isPressedbk13 = true;
    boolean isPressedbk14 = true;
    boolean isPressedbk15 = true;
    boolean isPressedbk16 = true;

    //IMG6
    boolean isPressedak = true;
    boolean isPressedak2 = true;
    boolean isPressedak3 = true;
    boolean isPressedak4 = true;
    boolean isPressedak5 = true;
    boolean isPressedak6 = true;
    boolean isPressedak7 = true;
    boolean isPressedak8 = true;
    boolean isPressedak9 = true;
    boolean isPressedak10 = true;
    boolean isPressedak11 = true;
    boolean isPressedak12 = true;
    boolean isPressedak13 = true;
    boolean isPressedak14 = true;
    boolean isPressedak15 = true;
    boolean isPressedak16 = true;

    //IMG7
    boolean isPressedyk = true;
    boolean isPressedyk2 = true;
    boolean isPressedyk3 = true;
    boolean isPressedyk4 = true;
    boolean isPressedyk5 = true;
    boolean isPressedyk6 = true;
    boolean isPressedyk7 = true;
    boolean isPressedyk8 = true;
    boolean isPressedyk9 = true;
    boolean isPressedyk10 = true;
    boolean isPressedyk11 = true;
    boolean isPressedyk12 = true;
    boolean isPressedyk13 = true;
    boolean isPressedyk14 = true;
    boolean isPressedyk15 = true;
    boolean isPressedyk16 = true;

    //IMG8
    boolean isPressedsk = true;
    boolean isPressedsk2 = true;
    boolean isPressedsk3 = true;
    boolean isPressedsk4 = true;
    boolean isPressedsk5 = true;
    boolean isPressedsk6 = true;
    boolean isPressedsk7 = true;
    boolean isPressedsk8 = true;
    boolean isPressedsk9 = true;
    boolean isPressedsk10 = true;
    boolean isPressedsk11 = true;
    boolean isPressedsk12 = true;
    boolean isPressedsk13 = true;
    boolean isPressedsk14 = true;
    boolean isPressedsk15 = true;
    boolean isPressedsk16 = true;

    //-------------------------------------------------------------------------------
    //POP UP
    private Context mContext;
    private Activity mActivity;

    private RelativeLayout mRelativeLayout;
    private Button mButton;

    private PopupWindow mPopupWindow;
    //-------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_match);
        //-------------------------------------------------------------------------------
        textViewData = findViewById(R.id.text_view_data); //oyuncular name alanı
        textViewNumber = findViewById(R.id.text_view_number); //oyuncular number alanı
        //-------------------------------------------------------------------------------
        //tüm sayfa verilerini kaydeder
        saveAll=findViewById(R.id.buttonSaveALL);
        findViewById(R.id.buttonSaveALL).setOnClickListener(this);

        //Tore verilerini açılır pencereye yansıtmak için kullanılır
        mButton=findViewById(R.id.buttonTore9m);
        findViewById(R.id.buttonTore9m).setOnClickListener(this);
        //-------------------------------------------------------------------------------
        //Create match sayfasında girilen veriler
        textViewOpponent=findViewById(R.id.edittext_opponent);
        textViewPlace=findViewById(R.id.edittext_place);
        textViewReferee=findViewById(R.id.edittext_referee);
        textViewDate=findViewById(R.id.edittext_date);
        //-------------------------------------------------------------------------------
        //POP UP Oyuncu verilerinin sıralama


        mContext = getApplicationContext();
        mActivity = StartMatch.this;
        mRelativeLayout = (RelativeLayout) findViewById(R.id.parentView); //StartMatch relative layout
        mButton = (Button) findViewById(R.id.buttonTore9m); //Tore 9m buttonu


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);

                View customView = inflater.inflate(R.layout.activity_tore9m,null);
                mPopupWindow = new PopupWindow(
                        customView,
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );


                if(Build.VERSION.SDK_INT>=21){
                    mPopupWindow.setElevation(5.0f);
                }



                ImageButton closeButton = (ImageButton) customView.findViewById(R.id.ib_close);
                //TextView ViewName = (TextView) customView.findViewById(R.id.name);
                //TextView ViewNumber = (TextView) customView.findViewById(R.id.number);





                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss the popup window
                        mPopupWindow.dismiss();
                    }
                });

                mPopupWindow.showAtLocation(mRelativeLayout, Gravity.CENTER,0,0);
                savePlayer();
            }
        });


        //-------------------------------------------------------------------------------

        // SCREENSHOT
        initViews();
        // initializing the listeners
        initListeners();
        // SCREENSHOT

        //-------------------------------------------------------------------------------------
        //KALECİ IMG1

        final Button button01 = (Button) findViewById(R.id.btn01);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btn01
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressed) {
                    button01.setBackgroundResource(R.drawable.ic_bos);
                    isPressed = true;
                }
                else if(isPressed==true){
                    button01.setBackgroundResource(R.drawable.ic_clear);
                    isPressed=false;
                }
            }
        });

        final Button button02 = (Button) findViewById(R.id.btn02);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btn02
        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressed2) {
                    button02.setBackgroundResource(R.drawable.ic_bos);
                    isPressed2 = true;
                }
                else if(isPressed2==true){
                    button02.setBackgroundResource(R.drawable.ic_clear);
                    isPressed2=false;
                }
            }
        });

        final Button button03 = (Button) findViewById(R.id.btn03);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btn03
        button03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressed3) {
                    button03.setBackgroundResource(R.drawable.ic_bos);
                    isPressed3 = true;
                }
                else if(isPressed3==true){
                    button03.setBackgroundResource(R.drawable.ic_clear);
                    isPressed3=false;
                }
            }
        });

        final Button button04 = (Button) findViewById(R.id.btn04);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btn04
        button04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressed4) {
                    button04.setBackgroundResource(R.drawable.ic_bos);
                    isPressed4 = true;
                }
                else if(isPressed4==true){
                    button04.setBackgroundResource(R.drawable.ic_clear);
                    isPressed4=false;
                }
            }
        });

        final Button button05 = (Button) findViewById(R.id.btn05);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btn05
        button05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressed5) {
                    button05.setBackgroundResource(R.drawable.ic_bos);
                    isPressed5 = true;
                }
                else if(isPressed5==true){
                    button05.setBackgroundResource(R.drawable.ic_clear);
                    isPressed5=false;
                }
            }
        });

        final Button button06 = (Button) findViewById(R.id.btn06);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btn06
        button06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressed6) {
                    button06.setBackgroundResource(R.drawable.ic_bos);
                    isPressed6 = true;
                }
                else if(isPressed6==true){
                    button06.setBackgroundResource(R.drawable.ic_clear);
                    isPressed6=false;
                }
            }
        });

        final Button button07 = (Button) findViewById(R.id.btn07);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btn07
        button07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressed7) {
                    button07.setBackgroundResource(R.drawable.ic_bos);
                    isPressed7 = true;
                }
                else if(isPressed7==true){
                    button07.setBackgroundResource(R.drawable.ic_clear);
                    isPressed7=false;
                }
            }
        });

        final Button button08 = (Button) findViewById(R.id.btn08);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btn08
        button08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressed8) {
                    button08.setBackgroundResource(R.drawable.ic_bos);
                    isPressed8 = true;
                }
                else if(isPressed8==true){
                    button08.setBackgroundResource(R.drawable.ic_clear);
                    isPressed8=false;
                }
            }
        });

        final Button button09 = (Button) findViewById(R.id.btn09);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btn09
        button09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressed9) {
                    button09.setBackgroundResource(R.drawable.ic_bos);
                    isPressed9 = true;
                }
                else if(isPressed9==true){
                    button09.setBackgroundResource(R.drawable.ic_clear);
                    isPressed9=false;
                }
            }
        });

        final Button button010 = (Button) findViewById(R.id.btn010);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btn010
        button010.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressed10) {
                    button010.setBackgroundResource(R.drawable.ic_bos);
                    isPressed10 = true;
                }
                else if(isPressed10==true){
                    button010.setBackgroundResource(R.drawable.ic_clear);
                    isPressed10=false;
                }
            }
        });

        final Button button011 = (Button) findViewById(R.id.btn011);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btn011
        button011.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressed11) {
                    button011.setBackgroundResource(R.drawable.ic_bos);
                    isPressed11 = true;
                }
                else if(isPressed11==true){
                    button011.setBackgroundResource(R.drawable.ic_clear);
                    isPressed11=false;
                }
            }
        });

        final Button button012 = (Button) findViewById(R.id.btn012);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btn012
        button012.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressed12) {
                    button012.setBackgroundResource(R.drawable.ic_bos);
                    isPressed12 = true;
                }
                else if(isPressed12==true){
                    button012.setBackgroundResource(R.drawable.ic_clear);
                    isPressed12=false;
                }
            }
        });

        final Button button013 = (Button) findViewById(R.id.btn013);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btn013
        button013.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressed13) {
                    button013.setBackgroundResource(R.drawable.ic_bos);
                    isPressed13 = true;
                }
                else if(isPressed13==true){
                    button013.setBackgroundResource(R.drawable.ic_clear);
                    isPressed13=false;
                }
            }
        });

        final Button button014 = (Button) findViewById(R.id.btn014);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btn014
        button014.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressed14) {
                    button014.setBackgroundResource(R.drawable.ic_bos);
                    isPressed14 = true;
                }
                else if(isPressed14==true){
                    button014.setBackgroundResource(R.drawable.ic_clear);
                    isPressed14=false;
                }
            }
        });

        final Button button015 = (Button) findViewById(R.id.btn015);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btn015
        button015.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressed15) {
                    button015.setBackgroundResource(R.drawable.ic_bos);
                    isPressed15 = true;
                }
                else if(isPressed15==true){
                    button015.setBackgroundResource(R.drawable.ic_clear);
                    isPressed15=false;
                }
            }
        });

        final Button button016 = (Button) findViewById(R.id.btn016);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btn016
        button016.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressed16) {
                    button016.setBackgroundResource(R.drawable.ic_bos);
                    isPressed16 = true;
                }
                else if(isPressed16==true){
                    button016.setBackgroundResource(R.drawable.ic_clear);
                    isPressed16=false;
                }
            }
        });
        //-------------------------------------------------------------------------

        //KALECİ IMG2

        final Button buttonik1 = (Button) findViewById(R.id.btnik1);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnik1
        buttonik1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedik) {
                    buttonik1.setBackgroundResource(R.drawable.ic_bos);
                    isPressedik = true;
                }
                else if(isPressedik==true){
                    buttonik1.setBackgroundResource(R.drawable.ic_clear);
                    isPressedik=false;
                }
            }
        });

        final Button buttonik2 = (Button) findViewById(R.id.btnik2);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnik2
        buttonik2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedik2) {
                    buttonik2.setBackgroundResource(R.drawable.ic_bos);
                    isPressedik2 = true;
                }
                else if(isPressedik2==true){
                    buttonik2.setBackgroundResource(R.drawable.ic_clear);
                    isPressedik2=false;
                }
            }
        });

        final Button buttonik3 = (Button) findViewById(R.id.btnik3);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnik3
        buttonik3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedik3) {
                    buttonik3.setBackgroundResource(R.drawable.ic_bos);
                    isPressedik3 = true;
                }
                else if(isPressedik3==true){
                    buttonik3.setBackgroundResource(R.drawable.ic_clear);
                    isPressedik3=false;
                }
            }
        });

        final Button buttonik4 = (Button) findViewById(R.id.btnik4);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnik4
        buttonik4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedik4) {
                    buttonik4.setBackgroundResource(R.drawable.ic_bos);
                    isPressedik4 = true;
                }
                else if(isPressedik4==true){
                    buttonik4.setBackgroundResource(R.drawable.ic_clear);
                    isPressedik4=false;
                }
            }
        });

        final Button buttonik5 = (Button) findViewById(R.id.btnik5);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnik5
        buttonik5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedik5) {
                    buttonik5.setBackgroundResource(R.drawable.ic_bos);
                    isPressedik5 = true;
                }
                else if(isPressedik5==true){
                    buttonik5.setBackgroundResource(R.drawable.ic_clear);
                    isPressedik5=false;
                }
            }
        });

        final Button buttonik6 = (Button) findViewById(R.id.btnik6);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnik6
        buttonik6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedik6) {
                    buttonik6.setBackgroundResource(R.drawable.ic_bos);
                    isPressedik6 = true;
                }
                else if(isPressedik6==true){
                    buttonik6.setBackgroundResource(R.drawable.ic_clear);
                    isPressedik6=false;
                }
            }
        });

        final Button buttonik7 = (Button) findViewById(R.id.btnik7);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnik7
        buttonik7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedik7) {
                    buttonik7.setBackgroundResource(R.drawable.ic_bos);
                    isPressedik7 = true;
                }
                else if(isPressedik7==true){
                    buttonik7.setBackgroundResource(R.drawable.ic_clear);
                    isPressedik7=false;
                }
            }
        });

        final Button buttonik8 = (Button) findViewById(R.id.btnik8);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnik8
        buttonik8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedik8) {
                    buttonik8.setBackgroundResource(R.drawable.ic_bos);
                    isPressedik8 = true;
                }
                else if(isPressedik8==true){
                    buttonik8.setBackgroundResource(R.drawable.ic_clear);
                    isPressedik8=false;
                }
            }
        });

        final Button buttonik9 = (Button) findViewById(R.id.btnik9);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnik9
        buttonik9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedik9) {
                    buttonik9.setBackgroundResource(R.drawable.ic_bos);
                    isPressedik9 = true;
                }
                else if(isPressedik9==true){
                    buttonik9.setBackgroundResource(R.drawable.ic_clear);
                    isPressedik9=false;
                }
            }
        });

        final Button buttonik10 = (Button) findViewById(R.id.btnik10);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnik10
        buttonik10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedik10) {
                    buttonik10.setBackgroundResource(R.drawable.ic_bos);
                    isPressedik10 = true;
                }
                else if(isPressedik10==true){
                    buttonik10.setBackgroundResource(R.drawable.ic_clear);
                    isPressedik10=false;
                }
            }
        });

        final Button buttonik11 = (Button) findViewById(R.id.btnik11);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnik11
        buttonik11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedik11) {
                    buttonik11.setBackgroundResource(R.drawable.ic_bos);
                    isPressedik11 = true;
                }
                else if(isPressedik11==true){
                    buttonik11.setBackgroundResource(R.drawable.ic_clear);
                    isPressedik11=false;
                }
            }
        });

        final Button buttonik12 = (Button) findViewById(R.id.btnik12);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnik12
        buttonik12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedik12) {
                    buttonik12.setBackgroundResource(R.drawable.ic_bos);
                    isPressedik12 = true;
                }
                else if(isPressedik12==true){
                    buttonik12.setBackgroundResource(R.drawable.ic_clear);
                    isPressedik12=false;
                }
            }
        });

        final Button buttonik13 = (Button) findViewById(R.id.btnik13);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnik13
        buttonik13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedik13) {
                    buttonik13.setBackgroundResource(R.drawable.ic_bos);
                    isPressedik13 = true;
                }
                else if(isPressedik13==true){
                    buttonik13.setBackgroundResource(R.drawable.ic_clear);
                    isPressedik13=false;
                }
            }
        });

        final Button buttonik14 = (Button) findViewById(R.id.btnik14);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnik14
        buttonik14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedik14) {
                    buttonik14.setBackgroundResource(R.drawable.ic_bos);
                    isPressedik14 = true;
                }
                else if(isPressedik14==true){
                    buttonik14.setBackgroundResource(R.drawable.ic_clear);
                    isPressedik14=false;
                }
            }
        });

        final Button buttonik15 = (Button) findViewById(R.id.btnik15);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnik15
        buttonik15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedik15) {
                    buttonik15.setBackgroundResource(R.drawable.ic_bos);
                    isPressedik15 = true;
                }
                else if(isPressedik15==true){
                    buttonik15.setBackgroundResource(R.drawable.ic_clear);
                    isPressedik15=false;
                }
            }
        });

        final Button buttonik16 = (Button) findViewById(R.id.btnik16);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnik16
        buttonik16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedik16) {
                    buttonik16.setBackgroundResource(R.drawable.ic_bos);
                    isPressedik16 = true;
                }
                else if(isPressedik16==true){
                    buttonik16.setBackgroundResource(R.drawable.ic_clear);
                    isPressedik16=false;
                }
            }
        });
        //-------------------------------------------------------------------------

        //-------------------------------------------------------------------------

        //KALECİ IMG3

        final Button buttonük1 = (Button) findViewById(R.id.btnük1);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnük1
        buttonük1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedük) {
                    buttonük1.setBackgroundResource(R.drawable.ic_bos);
                    isPressedük = true;
                }
                else if(isPressedük==true){
                    buttonük1.setBackgroundResource(R.drawable.ic_clear);
                    isPressedük=false;
                }
            }
        });

        final Button buttonük2 = (Button) findViewById(R.id.btnük2);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnük2
        buttonük2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedük2) {
                    buttonük2.setBackgroundResource(R.drawable.ic_bos);
                    isPressedük2 = true;
                }
                else if(isPressedük2==true){
                    buttonük2.setBackgroundResource(R.drawable.ic_clear);
                    isPressedük2=false;
                }
            }
        });

        final Button buttonük3 = (Button) findViewById(R.id.btnük3);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnük3
        buttonük3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedük3) {
                    buttonük3.setBackgroundResource(R.drawable.ic_bos);
                    isPressedük3 = true;
                }
                else if(isPressedük3==true){
                    buttonük3.setBackgroundResource(R.drawable.ic_clear);
                    isPressedük3=false;
                }
            }
        });

        final Button buttonük4 = (Button) findViewById(R.id.btnük4);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnük4
        buttonük4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedük4) {
                    buttonük4.setBackgroundResource(R.drawable.ic_bos);
                    isPressedük4 = true;
                }
                else if(isPressedük4==true){
                    buttonük4.setBackgroundResource(R.drawable.ic_clear);
                    isPressedük4=false;
                }
            }
        });

        final Button buttonük5 = (Button) findViewById(R.id.btnük5);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnük5
        buttonük5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedük5) {
                    buttonük5.setBackgroundResource(R.drawable.ic_bos);
                    isPressedük5 = true;
                }
                else if(isPressedük5==true){
                    buttonük5.setBackgroundResource(R.drawable.ic_clear);
                    isPressedük5=false;
                }
            }
        });

        final Button buttonük6 = (Button) findViewById(R.id.btnük6);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnük6
        buttonük6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedük6) {
                    buttonük6.setBackgroundResource(R.drawable.ic_bos);
                    isPressedük6 = true;
                }
                else if(isPressedük6==true){
                    buttonük6.setBackgroundResource(R.drawable.ic_clear);
                    isPressedük6=false;
                }
            }
        });

        final Button buttonük7 = (Button) findViewById(R.id.btnük7);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnük7
        buttonük7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedük7) {
                    buttonük7.setBackgroundResource(R.drawable.ic_bos);
                    isPressedük7 = true;
                }
                else if(isPressedük7==true){
                    buttonük7.setBackgroundResource(R.drawable.ic_clear);
                    isPressedük7=false;
                }
            }
        });

        final Button buttonük8 = (Button) findViewById(R.id.btnük8);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnük8
        buttonük8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedük8) {
                    buttonük8.setBackgroundResource(R.drawable.ic_bos);
                    isPressedük8 = true;
                }
                else if(isPressedük8==true){
                    buttonük8.setBackgroundResource(R.drawable.ic_clear);
                    isPressedük8=false;
                }
            }
        });

        final Button buttonük9 = (Button) findViewById(R.id.btnük9);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnük9
        buttonük9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedük9) {
                    buttonük9.setBackgroundResource(R.drawable.ic_bos);
                    isPressedük9 = true;
                }
                else if(isPressedük9==true){
                    buttonük9.setBackgroundResource(R.drawable.ic_clear);
                    isPressedük9=false;
                }
            }
        });

        final Button buttonük10 = (Button) findViewById(R.id.btnük10);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnük10
        buttonük10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedük10) {
                    buttonük10.setBackgroundResource(R.drawable.ic_bos);
                    isPressedük10 = true;
                }
                else if(isPressedük10==true){
                    buttonük10.setBackgroundResource(R.drawable.ic_clear);
                    isPressedük10=false;
                }
            }
        });

        final Button buttonük11 = (Button) findViewById(R.id.btnük11);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnük11
        buttonük11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedük11) {
                    buttonük11.setBackgroundResource(R.drawable.ic_bos);
                    isPressedük11 = true;
                }
                else if(isPressedük11==true){
                    buttonük11.setBackgroundResource(R.drawable.ic_clear);
                    isPressedük11=false;
                }
            }
        });

        final Button buttonük12 = (Button) findViewById(R.id.btnük12);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnük12
        buttonük12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedük12) {
                    buttonük12.setBackgroundResource(R.drawable.ic_bos);
                    isPressedük12 = true;
                }
                else if(isPressedük12==true){
                    buttonük12.setBackgroundResource(R.drawable.ic_clear);
                    isPressedük12=false;
                }
            }
        });

        final Button buttonük13 = (Button) findViewById(R.id.btnük13);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnük13
        buttonük13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedük13) {
                    buttonük13.setBackgroundResource(R.drawable.ic_bos);
                    isPressedük13 = true;
                }
                else if(isPressedük13==true){
                    buttonük13.setBackgroundResource(R.drawable.ic_clear);
                    isPressedük13=false;
                }
            }
        });

        final Button buttonük14 = (Button) findViewById(R.id.btnük14);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnük14
        buttonük14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedük14) {
                    buttonük14.setBackgroundResource(R.drawable.ic_bos);
                    isPressedük14 = true;
                }
                else if(isPressedük14==true){
                    buttonük14.setBackgroundResource(R.drawable.ic_clear);
                    isPressedük14=false;
                }
            }
        });

        final Button buttonük15 = (Button) findViewById(R.id.btnük15);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnük15
        buttonük15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedük15) {
                    buttonük15.setBackgroundResource(R.drawable.ic_bos);
                    isPressedük15 = true;
                }
                else if(isPressedük15==true){
                    buttonük15.setBackgroundResource(R.drawable.ic_clear);
                    isPressedük15=false;
                }
            }
        });

        final Button buttonük16 = (Button) findViewById(R.id.btnük16);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnük16
        buttonük16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedük16) {
                    buttonük16.setBackgroundResource(R.drawable.ic_bos);
                    isPressedük16 = true;
                }
                else if(isPressedük16==true){
                    buttonük16.setBackgroundResource(R.drawable.ic_clear);
                    isPressedük16=false;
                }
            }
        });
        //-------------------------------------------------------------------------

        //-------------------------------------------------------------------------

        //KALECİ IMG4

        final Button buttondk1 = (Button) findViewById(R.id.btndk1);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btndk1
        buttondk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPresseddk) {
                    buttondk1.setBackgroundResource(R.drawable.ic_bos);
                    isPresseddk = true;
                }
                else if(isPresseddk==true){
                    buttondk1.setBackgroundResource(R.drawable.ic_clear);
                    isPresseddk=false;
                }
            }
        });

        final Button buttondk2 = (Button) findViewById(R.id.btndk2);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btndk2
        buttondk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPresseddk2) {
                    buttondk2.setBackgroundResource(R.drawable.ic_bos);
                    isPresseddk2 = true;
                }
                else if(isPresseddk2==true){
                    buttondk2.setBackgroundResource(R.drawable.ic_clear);
                    isPresseddk2=false;
                }
            }
        });

        final Button buttondk3 = (Button) findViewById(R.id.btndk3);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btndk3
        buttondk3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPresseddk3) {
                    buttondk3.setBackgroundResource(R.drawable.ic_bos);
                    isPresseddk3 = true;
                }
                else if(isPresseddk3==true){
                    buttondk3.setBackgroundResource(R.drawable.ic_clear);
                    isPresseddk3=false;
                }
            }
        });

        final Button buttondk4 = (Button) findViewById(R.id.btndk4);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btndk4
        buttondk4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPresseddk4) {
                    buttondk4.setBackgroundResource(R.drawable.ic_bos);
                    isPresseddk4 = true;
                }
                else if(isPresseddk4==true){
                    buttondk4.setBackgroundResource(R.drawable.ic_clear);
                    isPresseddk4=false;
                }
            }
        });

        final Button buttondk5 = (Button) findViewById(R.id.btndk5);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btndk5
        buttondk5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPresseddk5) {
                    buttondk5.setBackgroundResource(R.drawable.ic_bos);
                    isPresseddk5 = true;
                }
                else if(isPresseddk5==true){
                    buttondk5.setBackgroundResource(R.drawable.ic_clear);
                    isPresseddk5=false;
                }
            }
        });

        final Button buttondk6 = (Button) findViewById(R.id.btndk6);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btndk6
        buttondk6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPresseddk6) {
                    buttondk6.setBackgroundResource(R.drawable.ic_bos);
                    isPresseddk6 = true;
                }
                else if(isPresseddk6==true){
                    buttondk6.setBackgroundResource(R.drawable.ic_clear);
                    isPresseddk6=false;
                }
            }
        });

        final Button buttondk7 = (Button) findViewById(R.id.btndk7);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btndk7
        buttondk7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPresseddk7) {
                    buttondk7.setBackgroundResource(R.drawable.ic_bos);
                    isPresseddk7 = true;
                }
                else if(isPresseddk7==true){
                    buttondk7.setBackgroundResource(R.drawable.ic_clear);
                    isPresseddk7=false;
                }
            }
        });

        final Button buttondk8 = (Button) findViewById(R.id.btndk8);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btndk8
        buttondk8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPresseddk8) {
                    buttondk8.setBackgroundResource(R.drawable.ic_bos);
                    isPresseddk8 = true;
                }
                else if(isPresseddk8==true){
                    buttondk8.setBackgroundResource(R.drawable.ic_clear);
                    isPresseddk8=false;
                }
            }
        });

        final Button buttondk9 = (Button) findViewById(R.id.btndk9);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btndk9
        buttondk9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPresseddk9) {
                    buttondk9.setBackgroundResource(R.drawable.ic_bos);
                    isPresseddk9 = true;
                }
                else if(isPresseddk9==true){
                    buttondk9.setBackgroundResource(R.drawable.ic_clear);
                    isPresseddk9=false;
                }
            }
        });

        final Button buttondk10 = (Button) findViewById(R.id.btndk10);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btndk10
        buttondk10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPresseddk10) {
                    buttondk10.setBackgroundResource(R.drawable.ic_bos);
                    isPresseddk10 = true;
                }
                else if(isPresseddk10==true){
                    buttondk10.setBackgroundResource(R.drawable.ic_clear);
                    isPresseddk10=false;
                }
            }
        });

        final Button buttondk11 = (Button) findViewById(R.id.btndk11);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btndk11
        buttondk11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPresseddk11) {
                    buttondk11.setBackgroundResource(R.drawable.ic_bos);
                    isPresseddk11 = true;
                }
                else if(isPresseddk11==true){
                    buttondk11.setBackgroundResource(R.drawable.ic_clear);
                    isPresseddk11=false;
                }
            }
        });

        final Button buttondk12 = (Button) findViewById(R.id.btndk12);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btndk12
        buttondk12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPresseddk12) {
                    buttondk12.setBackgroundResource(R.drawable.ic_bos);
                    isPresseddk12 = true;
                }
                else if(isPresseddk12==true){
                    buttondk12.setBackgroundResource(R.drawable.ic_clear);
                    isPresseddk12=false;
                }
            }
        });

        final Button buttondk13 = (Button) findViewById(R.id.btndk13);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btndk13
        buttondk13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPresseddk13) {
                    buttondk13.setBackgroundResource(R.drawable.ic_bos);
                    isPresseddk13 = true;
                }
                else if(isPresseddk13==true){
                    buttondk13.setBackgroundResource(R.drawable.ic_clear);
                    isPresseddk13=false;
                }
            }
        });

        final Button buttondk14 = (Button) findViewById(R.id.btndk14);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btndk14
        buttondk14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPresseddk14) {
                    buttondk14.setBackgroundResource(R.drawable.ic_bos);
                    isPresseddk14 = true;
                }
                else if(isPresseddk14==true){
                    buttondk14.setBackgroundResource(R.drawable.ic_clear);
                    isPresseddk14=false;
                }
            }
        });

        final Button buttondk15 = (Button) findViewById(R.id.btndk15);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btndk15
        buttondk15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPresseddk15) {
                    buttondk15.setBackgroundResource(R.drawable.ic_bos);
                    isPresseddk15 = true;
                }
                else if(isPresseddk15==true){
                    buttondk15.setBackgroundResource(R.drawable.ic_clear);
                    isPresseddk15=false;
                }
            }
        });

        final Button buttondk16 = (Button) findViewById(R.id.btndk16);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btndk16
        buttonük16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPresseddk16) {
                    buttondk16.setBackgroundResource(R.drawable.ic_bos);
                    isPresseddk16 = true;
                }
                else if(isPresseddk16==true){
                    buttondk16.setBackgroundResource(R.drawable.ic_clear);
                    isPresseddk16=false;
                }
            }
        });
        //-------------------------------------------------------------------------

        //-------------------------------------------------------------------------

        //KALECİ IMG5

        final Button buttonbk1 = (Button) findViewById(R.id.btnbk1);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnbk1
        buttonbk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedbk) {
                    buttonbk1.setBackgroundResource(R.drawable.ic_bos);
                    isPressedbk = true;
                }
                else if(isPressedbk==true){
                    buttonbk1.setBackgroundResource(R.drawable.ic_clear);
                    isPressedbk=false;
                }
            }
        });

        final Button buttonbk2 = (Button) findViewById(R.id.btnbk2);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnbk2
        buttonbk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedbk2) {
                    buttonbk2.setBackgroundResource(R.drawable.ic_bos);
                    isPressedbk2 = true;
                }
                else if(isPressedbk2==true){
                    buttonbk2.setBackgroundResource(R.drawable.ic_clear);
                    isPressedbk2=false;
                }
            }
        });

        final Button buttonbk3 = (Button) findViewById(R.id.btnbk3);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnbk3
        buttonbk3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedbk3) {
                    buttonbk3.setBackgroundResource(R.drawable.ic_bos);
                    isPressedbk3 = true;
                }
                else if(isPressedbk3==true){
                    buttonbk3.setBackgroundResource(R.drawable.ic_clear);
                    isPressedbk3=false;
                }
            }
        });

        final Button buttonbk4 = (Button) findViewById(R.id.btnbk4);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnbk4
        buttonbk4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedbk4) {
                    buttonbk4.setBackgroundResource(R.drawable.ic_bos);
                    isPressedbk4 = true;
                }
                else if(isPressedbk4==true){
                    buttonbk4.setBackgroundResource(R.drawable.ic_clear);
                    isPressedbk4=false;
                }
            }
        });

        final Button buttonbk5 = (Button) findViewById(R.id.btnbk5);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnbk5
        buttonbk5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedbk5) {
                    buttonbk5.setBackgroundResource(R.drawable.ic_bos);
                    isPressedbk5 = true;
                }
                else if(isPressedbk5==true){
                    buttonbk5.setBackgroundResource(R.drawable.ic_clear);
                    isPressedbk5=false;
                }
            }
        });

        final Button buttonbk6 = (Button) findViewById(R.id.btnbk6);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnbk6
        buttonbk6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedbk6) {
                    buttonbk6.setBackgroundResource(R.drawable.ic_bos);
                    isPressedbk6 = true;
                }
                else if(isPressedbk6==true){
                    buttonbk6.setBackgroundResource(R.drawable.ic_clear);
                    isPressedbk6=false;
                }
            }
        });

        final Button buttonbk7 = (Button) findViewById(R.id.btnbk7);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnbk7
        buttonbk7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedbk7) {
                    buttonbk7.setBackgroundResource(R.drawable.ic_bos);
                    isPressedbk7 = true;
                }
                else if(isPressedbk7==true){
                    buttonbk7.setBackgroundResource(R.drawable.ic_clear);
                    isPressedbk7=false;
                }
            }
        });

        final Button buttonbk8 = (Button) findViewById(R.id.btnbk8);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnbk8
        buttonbk8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedbk8) {
                    buttonbk8.setBackgroundResource(R.drawable.ic_bos);
                    isPressedbk8 = true;
                }
                else if(isPressedbk8==true){
                    buttonbk8.setBackgroundResource(R.drawable.ic_clear);
                    isPressedbk8=false;
                }
            }
        });

        final Button buttonbk9 = (Button) findViewById(R.id.btnbk9);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnbk9
        buttonbk9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedbk9) {
                    buttonbk9.setBackgroundResource(R.drawable.ic_bos);
                    isPressedbk9 = true;
                }
                else if(isPressedbk9==true){
                    buttonbk9.setBackgroundResource(R.drawable.ic_clear);
                    isPressedbk9=false;
                }
            }
        });

        final Button buttonbk10 = (Button) findViewById(R.id.btnbk10);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnbk10
        buttonbk10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedbk10) {
                    buttonbk10.setBackgroundResource(R.drawable.ic_bos);
                    isPressedbk10 = true;
                }
                else if(isPressedbk10==true){
                    buttonbk10.setBackgroundResource(R.drawable.ic_clear);
                    isPressedbk10=false;
                }
            }
        });

        final Button buttonbk11 = (Button) findViewById(R.id.btnbk11);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnbk11
        buttonbk11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedbk11) {
                    buttonbk11.setBackgroundResource(R.drawable.ic_bos);
                    isPressedbk11 = true;
                }
                else if(isPressedbk11==true){
                    buttonbk11.setBackgroundResource(R.drawable.ic_clear);
                    isPressedbk11=false;
                }
            }
        });

        final Button buttonbk12 = (Button) findViewById(R.id.btnbk12);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnbk12
        buttonbk12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedbk12) {
                    buttonbk12.setBackgroundResource(R.drawable.ic_bos);
                    isPressedbk12 = true;
                }
                else if(isPressedbk12==true){
                    buttonbk12.setBackgroundResource(R.drawable.ic_clear);
                    isPressedbk12=false;
                }
            }
        });

        final Button buttonbk13 = (Button) findViewById(R.id.btnbk13);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnbk13
        buttonbk13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedbk13) {
                    buttonbk13.setBackgroundResource(R.drawable.ic_bos);
                    isPressedbk13 = true;
                }
                else if(isPressedbk13==true){
                    buttonbk13.setBackgroundResource(R.drawable.ic_clear);
                    isPressedbk13=false;
                }
            }
        });

        final Button buttonbk14 = (Button) findViewById(R.id.btnbk14);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnbk14
        buttonbk14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedbk14) {
                    buttonbk14.setBackgroundResource(R.drawable.ic_bos);
                    isPressedbk14 = true;
                }
                else if(isPressedbk14==true){
                    buttonbk14.setBackgroundResource(R.drawable.ic_clear);
                    isPressedbk14=false;
                }
            }
        });

        final Button buttonbk15 = (Button) findViewById(R.id.btnbk15);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnbk15
        buttonbk15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedbk15) {
                    buttonbk15.setBackgroundResource(R.drawable.ic_bos);
                    isPressedbk15 = true;
                }
                else if(isPressedbk15==true){
                    buttonbk15.setBackgroundResource(R.drawable.ic_clear);
                    isPressedbk15=false;
                }
            }
        });

        final Button buttonbk16 = (Button) findViewById(R.id.btnbk16);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnbk16
        buttonbk16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedbk16) {
                    buttonbk16.setBackgroundResource(R.drawable.ic_bos);
                    isPressedbk16 = true;
                }
                else if(isPressedbk16==true){
                    buttonbk16.setBackgroundResource(R.drawable.ic_clear);
                    isPressedbk16=false;
                }
            }
        });
        //-------------------------------------------------------------------------
        //-------------------------------------------------------------------------

        //KALECİ IMG6

        final Button buttonak1 = (Button) findViewById(R.id.btnak1);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnak1
        buttonak1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedak) {
                    buttonak1.setBackgroundResource(R.drawable.ic_bos);
                    isPressedak = true;
                }
                else if(isPressedak==true){
                    buttonak1.setBackgroundResource(R.drawable.ic_clear);
                    isPressedak=false;
                }
            }
        });

        final Button buttonak2 = (Button) findViewById(R.id.btnak2);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnak2
        buttonak2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedak2) {
                    buttonak2.setBackgroundResource(R.drawable.ic_bos);
                    isPressedak2 = true;
                }
                else if(isPressedak2==true){
                    buttonak2.setBackgroundResource(R.drawable.ic_clear);
                    isPressedak2=false;
                }
            }
        });

        final Button buttonak3 = (Button) findViewById(R.id.btnak3);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnak3
        buttonak3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedak3) {
                    buttonak3.setBackgroundResource(R.drawable.ic_bos);
                    isPressedak3 = true;
                }
                else if(isPressedak3==true){
                    buttonak3.setBackgroundResource(R.drawable.ic_clear);
                    isPressedak3=false;
                }
            }
        });

        final Button buttonak4 = (Button) findViewById(R.id.btnak4);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnak4
        buttonak4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedak4) {
                    buttonak4.setBackgroundResource(R.drawable.ic_bos);
                    isPressedak4 = true;
                }
                else if(isPressedak4==true){
                    buttonak4.setBackgroundResource(R.drawable.ic_clear);
                    isPressedak4=false;
                }
            }
        });

        final Button buttonak5 = (Button) findViewById(R.id.btnak5);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnak5
        buttonak5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedak5) {
                    buttonak5.setBackgroundResource(R.drawable.ic_bos);
                    isPressedak5 = true;
                }
                else if(isPressedak5==true){
                    buttonak5.setBackgroundResource(R.drawable.ic_clear);
                    isPressedak5=false;
                }
            }
        });

        final Button buttonak6 = (Button) findViewById(R.id.btnak6);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnak6
        buttonak6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedak6) {
                    buttonak6.setBackgroundResource(R.drawable.ic_bos);
                    isPressedak6 = true;
                }
                else if(isPressedak6==true){
                    buttonak6.setBackgroundResource(R.drawable.ic_clear);
                    isPressedak6=false;
                }
            }
        });

        final Button buttonak7 = (Button) findViewById(R.id.btnak7);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnak7
        buttonak7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedak7) {
                    buttonak7.setBackgroundResource(R.drawable.ic_bos);
                    isPressedak7 = true;
                }
                else if(isPressedak7==true){
                    buttonak7.setBackgroundResource(R.drawable.ic_clear);
                    isPressedak7=false;
                }
            }
        });

        final Button buttonak8 = (Button) findViewById(R.id.btnak8);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnak8
        buttonak8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedak8) {
                    buttonak8.setBackgroundResource(R.drawable.ic_bos);
                    isPressedak8 = true;
                }
                else if(isPressedak8==true){
                    buttonak8.setBackgroundResource(R.drawable.ic_clear);
                    isPressedak8=false;
                }
            }
        });

        final Button buttonak9 = (Button) findViewById(R.id.btnak9);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnak9
        buttonak9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedak9) {
                    buttonak9.setBackgroundResource(R.drawable.ic_bos);
                    isPressedak9 = true;
                }
                else if(isPressedak9==true){
                    buttonak9.setBackgroundResource(R.drawable.ic_clear);
                    isPressedak9=false;
                }
            }
        });

        final Button buttonak10 = (Button) findViewById(R.id.btnak10);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnak10
        buttonak10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedak10) {
                    buttonak10.setBackgroundResource(R.drawable.ic_bos);
                    isPressedak10 = true;
                }
                else if(isPressedak10==true){
                    buttonak10.setBackgroundResource(R.drawable.ic_clear);
                    isPressedak10=false;
                }
            }
        });

        final Button buttonak11 = (Button) findViewById(R.id.btnak11);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnak11
        buttonak11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedak11) {
                    buttonak11.setBackgroundResource(R.drawable.ic_bos);
                    isPressedak11 = true;
                }
                else if(isPressedak11==true){
                    buttonak11.setBackgroundResource(R.drawable.ic_clear);
                    isPressedak11=false;
                }
            }
        });

        final Button buttonak12 = (Button) findViewById(R.id.btnak12);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnak12
        buttonak12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedak12) {
                    buttonak12.setBackgroundResource(R.drawable.ic_bos);
                    isPressedak12 = true;
                }
                else if(isPressedak12==true){
                    buttonak12.setBackgroundResource(R.drawable.ic_clear);
                    isPressedak12=false;
                }
            }
        });

        final Button buttonak13 = (Button) findViewById(R.id.btnak13);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnak13
        buttonak13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedak13) {
                    buttonak13.setBackgroundResource(R.drawable.ic_bos);
                    isPressedak13 = true;
                }
                else if(isPressedak13==true){
                    buttonak13.setBackgroundResource(R.drawable.ic_clear);
                    isPressedak13=false;
                }
            }
        });

        final Button buttonak14 = (Button) findViewById(R.id.btnak14);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnak14
        buttonak14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedak14) {
                    buttonak14.setBackgroundResource(R.drawable.ic_bos);
                    isPressedak14 = true;
                }
                else if(isPressedak14==true){
                    buttonak14.setBackgroundResource(R.drawable.ic_clear);
                    isPressedak14=false;
                }
            }
        });

        final Button buttonak15 = (Button) findViewById(R.id.btnak15);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnak15
        buttonak15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedak15) {
                    buttonak15.setBackgroundResource(R.drawable.ic_bos);
                    isPressedak15 = true;
                }
                else if(isPressedak15==true){
                    buttonak15.setBackgroundResource(R.drawable.ic_clear);
                    isPressedak15=false;
                }
            }
        });

        final Button buttonak16 = (Button) findViewById(R.id.btnak16);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnak16
        buttonak16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedak16) {
                    buttonak16.setBackgroundResource(R.drawable.ic_bos);
                    isPressedak16 = true;
                }
                else if(isPressedak16==true){
                    buttonak16.setBackgroundResource(R.drawable.ic_clear);
                    isPressedak16=false;
                }
            }
        });
        //-------------------------------------------------------------------------

        //-------------------------------------------------------------------------

        //KALECİ IMG7

        final Button buttonyk1 = (Button) findViewById(R.id.btnyk1);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnyk1
        buttonyk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedyk) {
                    buttonyk1.setBackgroundResource(R.drawable.ic_bos);
                    isPressedyk = true;
                }
                else if(isPressedyk==true){
                    buttonyk1.setBackgroundResource(R.drawable.ic_clear);
                    isPressedyk=false;
                }
            }
        });

        final Button buttonyk2 = (Button) findViewById(R.id.btnyk2);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnyk2
        buttonyk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedyk2) {
                    buttonyk2.setBackgroundResource(R.drawable.ic_bos);
                    isPressedyk2 = true;
                }
                else if(isPressedyk2==true){
                    buttonyk2.setBackgroundResource(R.drawable.ic_clear);
                    isPressedyk2=false;
                }
            }
        });

        final Button buttonyk3 = (Button) findViewById(R.id.btnyk3);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnyk3
        buttonyk3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedyk3) {
                    buttonyk3.setBackgroundResource(R.drawable.ic_bos);
                    isPressedyk3 = true;
                }
                else if(isPressedyk3==true){
                    buttonyk3.setBackgroundResource(R.drawable.ic_clear);
                    isPressedyk3=false;
                }
            }
        });

        final Button buttonyk4 = (Button) findViewById(R.id.btnyk4);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnük4
        buttonyk4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedyk4) {
                    buttonyk4.setBackgroundResource(R.drawable.ic_bos);
                    isPressedyk4 = true;
                }
                else if(isPressedyk4==true){
                    buttonyk4.setBackgroundResource(R.drawable.ic_clear);
                    isPressedyk4=false;
                }
            }
        });

        final Button buttonyk5 = (Button) findViewById(R.id.btnyk5);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnük5
        buttonyk5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedyk5) {
                    buttonyk5.setBackgroundResource(R.drawable.ic_bos);
                    isPressedyk5 = true;
                }
                else if(isPressedyk5==true){
                    buttonyk5.setBackgroundResource(R.drawable.ic_clear);
                    isPressedyk5=false;
                }
            }
        });

        final Button buttonyk6 = (Button) findViewById(R.id.btnyk6);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnük6
        buttonyk6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedyk6) {
                    buttonyk6.setBackgroundResource(R.drawable.ic_bos);
                    isPressedyk6 = true;
                }
                else if(isPressedyk6==true){
                    buttonyk6.setBackgroundResource(R.drawable.ic_clear);
                    isPressedyk6=false;
                }
            }
        });

        final Button buttonyk7 = (Button) findViewById(R.id.btnyk7);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnyk7
        buttonyk7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedyk7) {
                    buttonyk7.setBackgroundResource(R.drawable.ic_bos);
                    isPressedyk7 = true;
                }
                else if(isPressedyk7==true){
                    buttonyk7.setBackgroundResource(R.drawable.ic_clear);
                    isPressedyk7=false;
                }
            }
        });

        final Button buttonyk8 = (Button) findViewById(R.id.btnyk8);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnyk8
        buttonyk8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedyk8) {
                    buttonyk8.setBackgroundResource(R.drawable.ic_bos);
                    isPressedyk8 = true;
                }
                else if(isPressedyk8==true){
                    buttonyk8.setBackgroundResource(R.drawable.ic_clear);
                    isPressedyk8=false;
                }
            }
        });

        final Button buttonyk9 = (Button) findViewById(R.id.btnyk9);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnyk9
        buttonyk9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedyk9) {
                    buttonyk9.setBackgroundResource(R.drawable.ic_bos);
                    isPressedyk9 = true;
                }
                else if(isPressedyk9==true){
                    buttonyk9.setBackgroundResource(R.drawable.ic_clear);
                    isPressedyk9=false;
                }
            }
        });

        final Button buttonyk10 = (Button) findViewById(R.id.btnyk10);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnyk10
        buttonyk10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedyk10) {
                    buttonyk10.setBackgroundResource(R.drawable.ic_bos);
                    isPressedyk10 = true;
                }
                else if(isPressedyk10==true){
                    buttonyk10.setBackgroundResource(R.drawable.ic_clear);
                    isPressedyk10=false;
                }
            }
        });

        final Button buttonyk11 = (Button) findViewById(R.id.btnyk11);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnyk11
        buttonyk11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedyk11) {
                    buttonyk11.setBackgroundResource(R.drawable.ic_bos);
                    isPressedyk11 = true;
                }
                else if(isPressedyk11==true){
                    buttonyk11.setBackgroundResource(R.drawable.ic_clear);
                    isPressedyk11=false;
                }
            }
        });

        final Button buttonyk12 = (Button) findViewById(R.id.btnyk12);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnyk12
        buttonyk12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedyk12) {
                    buttonyk12.setBackgroundResource(R.drawable.ic_bos);
                    isPressedyk12 = true;
                }
                else if(isPressedyk12==true){
                    buttonyk12.setBackgroundResource(R.drawable.ic_clear);
                    isPressedyk12=false;
                }
            }
        });

        final Button buttonyk13 = (Button) findViewById(R.id.btnyk13);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnyk13
        buttonyk13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedyk13) {
                    buttonyk13.setBackgroundResource(R.drawable.ic_bos);
                    isPressedyk13 = true;
                }
                else if(isPressedyk13==true){
                    buttonyk13.setBackgroundResource(R.drawable.ic_clear);
                    isPressedyk13=false;
                }
            }
        });

        final Button buttonyk14 = (Button) findViewById(R.id.btnyk14);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnyk14
        buttonyk14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedyk14) {
                    buttonyk14.setBackgroundResource(R.drawable.ic_bos);
                    isPressedyk14 = true;
                }
                else if(isPressedyk14==true){
                    buttonyk14.setBackgroundResource(R.drawable.ic_clear);
                    isPressedyk14=false;
                }
            }
        });

        final Button buttonyk15 = (Button) findViewById(R.id.btnyk15);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnyk15
        buttonyk15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedyk15) {
                    buttonyk15.setBackgroundResource(R.drawable.ic_bos);
                    isPressedyk15 = true;
                }
                else if(isPressedyk15==true){
                    buttonyk15.setBackgroundResource(R.drawable.ic_clear);
                    isPressedyk15=false;
                }
            }
        });

        final Button buttonyk16 = (Button) findViewById(R.id.btnyk16);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnyk16
        buttonyk16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedyk16) {
                    buttonyk16.setBackgroundResource(R.drawable.ic_bos);
                    isPressedyk16 = true;
                }
                else if(isPressedyk16==true){
                    buttonyk16.setBackgroundResource(R.drawable.ic_clear);
                    isPressedyk16=false;
                }
            }
        });
        //-------------------------------------------------------------------------

        //-------------------------------------------------------------------------

        //KALECİ IMG8

        final Button buttonsk1 = (Button) findViewById(R.id.btnsk1);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnsk1
        buttonsk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedsk) {
                    buttonsk1.setBackgroundResource(R.drawable.ic_bos);
                    isPressedsk = true;
                }
                else if(isPressedsk==true){
                    buttonsk1.setBackgroundResource(R.drawable.ic_clear);
                    isPressedsk=false;
                }
            }
        });

        final Button buttonsk2 = (Button) findViewById(R.id.btnsk2);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnsk2
        buttonsk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedsk2) {
                    buttonsk2.setBackgroundResource(R.drawable.ic_bos);
                    isPressedsk2 = true;
                }
                else if(isPressedsk2==true){
                    buttonsk2.setBackgroundResource(R.drawable.ic_clear);
                    isPressedsk2=false;
                }
            }
        });

        final Button buttonsk3 = (Button) findViewById(R.id.btnsk3);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnsk3
        buttonsk3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedsk3) {
                    buttonsk3.setBackgroundResource(R.drawable.ic_bos);
                    isPressedsk3 = true;
                }
                else if(isPressedsk3==true){
                    buttonsk3.setBackgroundResource(R.drawable.ic_clear);
                    isPressedsk3=false;
                }
            }
        });

        final Button buttonsk4 = (Button) findViewById(R.id.btnsk4);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnsk4
        buttonsk4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedsk4) {
                    buttonsk4.setBackgroundResource(R.drawable.ic_bos);
                    isPressedsk4 = true;
                }
                else if(isPressedsk4==true){
                    buttonsk4.setBackgroundResource(R.drawable.ic_clear);
                    isPressedsk4=false;
                }
            }
        });

        final Button buttonsk5 = (Button) findViewById(R.id.btnsk5);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnsk5
        buttonsk5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedsk5) {
                    buttonsk5.setBackgroundResource(R.drawable.ic_bos);
                    isPressedsk5 = true;
                }
                else if(isPressedsk5==true){
                    buttonsk5.setBackgroundResource(R.drawable.ic_clear);
                    isPressedsk5=false;
                }
            }
        });

        final Button buttonsk6 = (Button) findViewById(R.id.btnsk6);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnsk6
        buttonsk6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedsk6) {
                    buttonsk6.setBackgroundResource(R.drawable.ic_bos);
                    isPressedsk6 = true;
                }
                else if(isPressedsk6==true){
                    buttonsk6.setBackgroundResource(R.drawable.ic_clear);
                    isPressedsk6=false;
                }
            }
        });

        final Button buttonsk7 = (Button) findViewById(R.id.btnsk7);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnsk7
        buttonsk7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedsk7) {
                    buttonsk7.setBackgroundResource(R.drawable.ic_bos);
                    isPressedsk7 = true;
                }
                else if(isPressedsk7==true){
                    buttonsk7.setBackgroundResource(R.drawable.ic_clear);
                    isPressedsk7=false;
                }
            }
        });

        final Button buttonsk8 = (Button) findViewById(R.id.btnsk8);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnsk8
        buttonsk8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedsk8) {
                    buttonsk8.setBackgroundResource(R.drawable.ic_bos);
                    isPressedsk8 = true;
                }
                else if(isPressedsk8==true){
                    buttonsk8.setBackgroundResource(R.drawable.ic_clear);
                    isPressedsk8=false;
                }
            }
        });

        final Button buttonsk9 = (Button) findViewById(R.id.btnsk9);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnsk9
        buttonsk9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedsk9) {
                    buttonsk9.setBackgroundResource(R.drawable.ic_bos);
                    isPressedsk9 = true;
                }
                else if(isPressedsk9==true){
                    buttonsk9.setBackgroundResource(R.drawable.ic_clear);
                    isPressedsk9=false;
                }
            }
        });

        final Button buttonsk10 = (Button) findViewById(R.id.btnsk10);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnsk10
        buttonsk10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedsk10) {
                    buttonsk10.setBackgroundResource(R.drawable.ic_bos);
                    isPressedsk10 = true;
                }
                else if(isPressedsk10==true){
                    buttonsk10.setBackgroundResource(R.drawable.ic_clear);
                    isPressedsk10=false;
                }
            }
        });

        final Button buttonsk11 = (Button) findViewById(R.id.btnsk11);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnsk11
        buttonsk11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedsk11) {
                    buttonsk11.setBackgroundResource(R.drawable.ic_bos);
                    isPressedsk11 = true;
                }
                else if(isPressedsk11==true){
                    buttonsk11.setBackgroundResource(R.drawable.ic_clear);
                    isPressedsk11=false;
                }
            }
        });

        final Button buttonsk12 = (Button) findViewById(R.id.btnsk12);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnsk12
        buttonsk12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedsk12) {
                    buttonsk12.setBackgroundResource(R.drawable.ic_bos);
                    isPressedsk12 = true;
                }
                else if(isPressedsk12==true){
                    buttonsk12.setBackgroundResource(R.drawable.ic_clear);
                    isPressedsk12=false;
                }
            }
        });

        final Button buttonsk13 = (Button) findViewById(R.id.btnsk13);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnsk13
        buttonsk13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedsk13) {
                    buttonsk13.setBackgroundResource(R.drawable.ic_bos);
                    isPressedsk13 = true;
                }
                else if(isPressedsk13==true){
                    buttonsk13.setBackgroundResource(R.drawable.ic_clear);
                    isPressedsk13=false;
                }
            }
        });

        final Button buttonsk14 = (Button) findViewById(R.id.btnsk14);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnsk14
        buttonsk14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedsk14) {
                    buttonsk14.setBackgroundResource(R.drawable.ic_bos);
                    isPressedsk14 = true;
                }
                else if(isPressedsk14==true){
                    buttonsk14.setBackgroundResource(R.drawable.ic_clear);
                    isPressedsk14=false;
                }
            }
        });

        final Button buttonsk15 = (Button) findViewById(R.id.btnsk15);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnsk15
        buttonsk15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedsk15) {
                    buttonsk15.setBackgroundResource(R.drawable.ic_bos);
                    isPressedsk15 = true;
                }
                else if(isPressedsk15==true){
                    buttonsk15.setBackgroundResource(R.drawable.ic_clear);
                    isPressedsk15=false;
                }
            }
        });

        final Button buttonsk16 = (Button) findViewById(R.id.btnsk16);
        //Kaleci kısmı dokundukça işaretci bırakma

        //btnsk16
        buttonsk16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPressedsk16) {
                    buttonsk16.setBackgroundResource(R.drawable.ic_bos);
                    isPressedsk16 = true;
                }
                else if(isPressedsk16==true){
                    buttonsk16.setBackgroundResource(R.drawable.ic_clear);
                    isPressedsk16=false;
                }
            }
        });
        //-------------------------------------------------------------------------

        btnarttır=findViewById(R.id.arttirBtn);
        btnazalt=findViewById(R.id.azaltBtn);


        //t9m1button
        t9m1 =findViewById(R.id.t9m1);
        t9m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m1.setText(String.valueOf(sayit9m1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t9m1button//


        //t9m2button
        t9m2 =findViewById(R.id.t9m2);
        t9m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m2.setText(String.valueOf(sayit9m2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t9m2button//

        //t9m3button
        t9m3 =findViewById(R.id.t9m3);
        t9m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m3.setText(String.valueOf(sayit9m3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t9m3button//

        //t9m4button
        t9m4 =findViewById(R.id.t9m4);
        t9m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m4.setText(String.valueOf(sayit9m4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t9m4button//


        //t9m5button
        t9m5 =findViewById(R.id.t9m5);
        t9m5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m5.setText(String.valueOf(sayit9m5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t9m5button//


        //t9m6button
        t9m6 =findViewById(R.id.t9m6);
        t9m6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m6.setText(String.valueOf(sayit9m6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t9m6button//

        //t9m7button
        t9m7 =findViewById(R.id.t9m7);
        t9m7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m7.setText(String.valueOf(sayit9m7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t9m7button//

        //t9m8button
        t9m8 =findViewById(R.id.t9m8);
        t9m8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m8.setText(String.valueOf(sayit9m8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t9m8button//


        //t9m9button
        t9m9 =findViewById(R.id.t9m9);
        t9m9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m9.setText(String.valueOf(sayit9m9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t9m9button//

        //t9m10button
        t9m10 =findViewById(R.id.t9m10);
        t9m10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m10.setText(String.valueOf(sayit9m10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t9m10button//

        //t9m11button
        t9m11 =findViewById(R.id.t9m11);
        t9m11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m11.setText(String.valueOf(sayit9m11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t9m11button//

        //t9m12button
        t9m12 =findViewById(R.id.t9m12);
        t9m12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m12.setText(String.valueOf(sayit9m12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t9m12button//

        //t9m13button
        t9m13 =findViewById(R.id.t9m13);
        t9m13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m13.setText(String.valueOf(sayit9m13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t9m13button//

        //t9m14button
        t9m14 =findViewById(R.id.t9m14);
        t9m14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m14.setText(String.valueOf(sayit9m14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t9m14button//

        //t9m15button
        t9m15 =findViewById(R.id.t9m15);
        t9m15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m15.setText(String.valueOf(sayit9m15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t9m15button//

        //t9m16button
        t9m16 =findViewById(R.id.t9m16);
        t9m16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m16.setText(String.valueOf(sayit9m16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t9m16button//

        //t9m11button
        t9m17 =findViewById(R.id.t9m17);
        t9m17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m17.setText(String.valueOf(sayit9m17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t9m17button//

        //------------------------------------------------------------------------------------

        //t6m1button
        t6m1 =findViewById(R.id.t6m1);
        t6m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m1.setText(String.valueOf(sayit6m1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t6m1button//


        //t6m2button
        t6m2 =findViewById(R.id.t6m2);
        t6m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m2.setText(String.valueOf(sayit6m2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t6m2button//


        //t6m3button
        t6m3 =findViewById(R.id.t6m3);
        t6m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m3.setText(String.valueOf(sayit6m3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t6m3button//

        //t6m4button
        t6m4 =findViewById(R.id.t6m4);
        t6m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m4.setText(String.valueOf(sayit6m4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t6m4button//


        //t6m5button
        t6m5 =findViewById(R.id.t6m5);
        t6m5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m5.setText(String.valueOf(sayit6m5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t6m5button//


        //t6m6button
        t6m6 =findViewById(R.id.t6m6);
        t6m6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m6.setText(String.valueOf(sayit6m6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t6m6button//

        //t6m7button
        t6m7 =findViewById(R.id.t6m7);
        t6m7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m7.setText(String.valueOf(sayit6m7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t6m7button//

        //t6m8button
        t6m8 =findViewById(R.id.t6m8);
        t6m8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m8.setText(String.valueOf(sayit6m8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t6m8button//


        //t6m9button
        t6m9 =findViewById(R.id.t6m9);
        t6m9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m9.setText(String.valueOf(sayit6m9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t6m9button//

        //t6m10button
        t6m10 =findViewById(R.id.t6m10);
        t6m10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m10.setText(String.valueOf(sayit6m10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t6m10button//

        //t6m11button
        t6m11 =findViewById(R.id.t6m11);
        t6m11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m11.setText(String.valueOf(sayit6m11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t6m11button//

        //t6m12button
        t6m12 =findViewById(R.id.t6m12);
        t6m12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m12.setText(String.valueOf(sayit6m12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t6m12button//

        //t6m13button
        t6m13 =findViewById(R.id.t6m13);
        t6m13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m13.setText(String.valueOf(sayit6m13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t6m13button//

        //t6m14button
        t6m14 =findViewById(R.id.t6m14);
        t6m14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m14.setText(String.valueOf(sayit6m14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t6m14button//

        //t6m15button
        t6m15 =findViewById(R.id.t6m15);
        t6m15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m15.setText(String.valueOf(sayit6m15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t6m15button//

        //t6m16button
        t6m16 =findViewById(R.id.t6m16);
        t6m16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m16.setText(String.valueOf(sayit6m16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t6m16button//

        //t6m11button
        t6m17 =findViewById(R.id.t6m17);
        t6m17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m17.setText(String.valueOf(sayit6m17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //t6m17button//

        //------------------------------------------------------------------------------------

        //tWelle1button
        tWelle1 =findViewById(R.id.tWelle1);
        tWelle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle1.setText(String.valueOf(sayitWelle1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tWelle1button//


        //tWelle2button
        tWelle2 =findViewById(R.id.tWelle2);
        tWelle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle2.setText(String.valueOf(sayitWelle2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tWelle2button//

        //tWelle3button
        tWelle3 =findViewById(R.id.tWelle3);
        tWelle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle3.setText(String.valueOf(sayitWelle3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tWelle3button//

        //tWelle4button
        tWelle4 =findViewById(R.id.tWelle4);
        tWelle4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle4.setText(String.valueOf(sayitWelle4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tWelle4button//


        //tWelle5button
        tWelle5 =findViewById(R.id.tWelle5);
        tWelle5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle5.setText(String.valueOf(sayitWelle5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tWelle5button//


        //tWelle6button
        tWelle6 =findViewById(R.id.tWelle6);
        tWelle6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle6.setText(String.valueOf(sayitWelle6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tWelle6button//

        //tWelle7button
        tWelle7 =findViewById(R.id.tWelle7);
        tWelle7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle7.setText(String.valueOf(sayitWelle7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tWelle7button//

        //tWelle8button
        tWelle8 =findViewById(R.id.tWelle8);
        tWelle8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle8.setText(String.valueOf(sayitWelle8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tWelle8button//


        //tWelle9button
        tWelle9 =findViewById(R.id.tWelle9);
        tWelle9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle9.setText(String.valueOf(sayitWelle9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tWelle9button//

        //tWelle10button
        tWelle10 =findViewById(R.id.tWelle10);
        tWelle10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle10.setText(String.valueOf(sayitWelle10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tWelle10button//

        //tWelle11button
        tWelle11 =findViewById(R.id.tWelle11);
        tWelle11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle11.setText(String.valueOf(sayitWelle11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tWelle11button//

        //tWelle12button
        tWelle12 =findViewById(R.id.tWelle12);
        tWelle12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle12.setText(String.valueOf(sayitWelle12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tWelle12button//

        //tWelle13button
        tWelle13 =findViewById(R.id.tWelle13);
        tWelle13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle13.setText(String.valueOf(sayitWelle13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tWelle13button//

        //tWelle14button
        tWelle14 =findViewById(R.id.tWelle14);
        tWelle14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle14.setText(String.valueOf(sayitWelle14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tWelle14button//

        //tWelle15button
        tWelle15 =findViewById(R.id.tWelle15);
        tWelle15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle15.setText(String.valueOf(sayitWelle15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tWelle15button//

        //tWelle16button
        tWelle16 =findViewById(R.id.tWelle16);
        tWelle16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle16.setText(String.valueOf(sayitWelle16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tWelle16button//

        //tWelle17button
        tWelle17 =findViewById(R.id.tWelle17);
        tWelle17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle17.setText(String.valueOf(sayitWelle17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tWelle17button//

        //------------------------------------------------------------------------------------

        //tartı1button
        tartı1 =findViewById(R.id.tartı1);
        tartı1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı1.setText(String.valueOf(sayitartı1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tartı1button//


        //tartı2button
        tartı2 =findViewById(R.id.tartı2);
        tartı2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı2.setText(String.valueOf(sayitartı2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tartı2button//

        //tartı3button
        tartı3 =findViewById(R.id.tartı3);
        tartı3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı3.setText(String.valueOf(sayitartı3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tartı3button//

        //tartı4button
        tartı4 =findViewById(R.id.tartı4);
        tartı4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı4.setText(String.valueOf(sayitartı4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tartı4button//


        //tartı5button
        tartı5 =findViewById(R.id.tartı5);
        tartı5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı5.setText(String.valueOf(sayitartı5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tartı5button//


        //tartı6button
        tartı6 =findViewById(R.id.tartı6);
        tartı6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı6.setText(String.valueOf(sayitartı6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tartı6button//

        //tartı7button
        tartı7 =findViewById(R.id.tartı7);
        tartı7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı7.setText(String.valueOf(sayitartı7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tartı7button//

        //tartı8button
        tartı8 =findViewById(R.id.tartı8);
        tartı8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı8.setText(String.valueOf(sayitartı8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tartı8button//


        //tartı9button
        tartı9 =findViewById(R.id.tartı9);
        tartı9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı9.setText(String.valueOf(sayitartı9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tartı9button//

        //tartı10button
        tartı10 =findViewById(R.id.tartı10);
        tartı10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı10.setText(String.valueOf(sayitartı10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tartı10button//

        //tartı11button
        tartı11 =findViewById(R.id.tartı11);
        tartı11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı11.setText(String.valueOf(sayitartı11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tartı11button//

        //tartı12button
        tartı12 =findViewById(R.id.tartı12);
        tartı12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı12.setText(String.valueOf(sayitartı12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tartı12button//

        //tartı13button
        tartı13 =findViewById(R.id.tartı13);
        tartı13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı13.setText(String.valueOf(sayitartı13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tartı13button//

        //tartı14button
        tartı14 =findViewById(R.id.tartı14);
        tartı14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı14.setText(String.valueOf(sayitartı14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tartı14button//

        //tartı15button
        tartı15 =findViewById(R.id.tartı15);
        tartı15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı15.setText(String.valueOf(sayitartı15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tartı15button//

        //tartı16button
        tartı16 =findViewById(R.id.tartı16);
        tartı16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı16.setText(String.valueOf(sayitartı16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tartı16button//

        //tartı11button
        tartı17 =findViewById(R.id.tartı17);
        tartı17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı17.setText(String.valueOf(sayitartı17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tartı17button//

        //------------------------------------------------------------------------------------

        //teksi1button
        teksi1 =findViewById(R.id.teksi1);
        teksi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi1.setText(String.valueOf(sayiteksi1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //teksi1button//


        //teksi2button
        teksi2 =findViewById(R.id.teksi2);
        teksi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi2.setText(String.valueOf(sayiteksi2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //teksi2button//

        //teksi3button
        teksi3 =findViewById(R.id.teksi3);
        teksi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi3.setText(String.valueOf(sayiteksi3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //teksi3button//

        //teksi4button
        teksi4 =findViewById(R.id.teksi4);
        teksi4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi4.setText(String.valueOf(sayiteksi4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //teksi4button//


        //teksi5button
        teksi5 =findViewById(R.id.teksi5);
        teksi5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi5.setText(String.valueOf(sayiteksi5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //teksi5button//


        //teksi6button
        teksi6 =findViewById(R.id.teksi6);
        teksi6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi6.setText(String.valueOf(sayiteksi6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //teksi6button//

        //teksi7button
        teksi7 =findViewById(R.id.teksi7);
        teksi7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi7.setText(String.valueOf(sayiteksi7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //teksi7button//

        //teksi8button
        teksi8 =findViewById(R.id.teksi8);
        teksi8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi8.setText(String.valueOf(sayiteksi8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //teksi8button//


        //teksi9button
        teksi9 =findViewById(R.id.teksi9);
        teksi9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi9.setText(String.valueOf(sayiteksi9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //teksi9button//

        //teksi10button
        teksi10 =findViewById(R.id.teksi10);
        teksi10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi10.setText(String.valueOf(sayiteksi10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //teksi10button//

        //teksi11button
        teksi11 =findViewById(R.id.teksi11);
        teksi11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi11.setText(String.valueOf(sayiteksi11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //teksi11button//

        //teksi12button
        teksi12 =findViewById(R.id.teksi12);
        teksi12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi12.setText(String.valueOf(sayiteksi12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //teksi12button//

        //teksi13button
        teksi13 =findViewById(R.id.teksi13);
        teksi13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi13.setText(String.valueOf(sayiteksi13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //teksi13button//

        //teksi14button
        teksi14 =findViewById(R.id.teksi14);
        teksi14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi14.setText(String.valueOf(sayiteksi14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //teksi14button//

        //teksi15button
        teksi15 =findViewById(R.id.teksi15);
        teksi15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi15.setText(String.valueOf(sayiteksi15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //teksi15button//

        //teksi16button
        teksi16 =findViewById(R.id.teksi16);
        teksi16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi16.setText(String.valueOf(sayiteksi16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //teksi16button//

        //teksi11button
        teksi17 =findViewById(R.id.teksi17);
        teksi17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi17.setText(String.valueOf(sayiteksi17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //teksi17button//

        //-----------------------------------------------------------------------------------

        //tdm1button
        tdm1 =findViewById(R.id.tdm1);
        tdm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm1.setText(String.valueOf(sayitdm1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdm1button//


        //tdm2button
        tdm2 =findViewById(R.id.tdm2);
        tdm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm2.setText(String.valueOf(sayitdm2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdm2button//

        //tdm3button
        tdm3 =findViewById(R.id.tdm3);
        tdm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm3.setText(String.valueOf(sayitdm3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdm3button//

        //tdm4button
        tdm4 =findViewById(R.id.tdm4);
        tdm4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm4.setText(String.valueOf(sayitdm4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdm4button//


        //tdm5button
        tdm5 =findViewById(R.id.tdm5);
        tdm5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm5.setText(String.valueOf(sayitdm5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdm5button//


        //tdm6button
        tdm6 =findViewById(R.id.tdm6);
        tdm6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm6.setText(String.valueOf(sayitdm6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdm6button//

        //tdm7button
        tdm7 =findViewById(R.id.tdm7);
        tdm7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm7.setText(String.valueOf(sayitdm7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdm7button//

        //tdm8button
        tdm8 =findViewById(R.id.tdm8);
        tdm8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm8.setText(String.valueOf(sayitdm8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdm8button//


        //tdm9button
        tdm9 =findViewById(R.id.tdm9);
        tdm9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm9.setText(String.valueOf(sayitdm9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdm9button//

        //tdm10button
        tdm10 =findViewById(R.id.tdm10);
        tdm10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm10.setText(String.valueOf(sayitdm10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdm10button//

        //tdm11button
        tdm11 =findViewById(R.id.tdm11);
        tdm11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm11.setText(String.valueOf(sayitdm11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdm11button//

        //tdm12button
        tdm12 =findViewById(R.id.tdm12);
        tdm12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm12.setText(String.valueOf(sayitdm12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdm12button//

        //tdm13button
        tdm13 =findViewById(R.id.tdm13);
        tdm13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm13.setText(String.valueOf(sayitdm13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdm13button//

        //tdm14button
        tdm14 =findViewById(R.id.tdm14);
        tdm14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm14.setText(String.valueOf(sayitdm14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdm14button//

        //tdm15button
        tdm15 =findViewById(R.id.tdm15);
        tdm15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm15.setText(String.valueOf(sayitdm15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdm15button//

        //tdm16button
        tdm16 =findViewById(R.id.tdm16);
        tdm16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm16.setText(String.valueOf(sayitdm16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdm16button//

        //tdm11button
        tdm17 =findViewById(R.id.tdm17);
        tdm17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm17.setText(String.valueOf(sayitdm17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdm17button//

        //-----------------------------------------------------------------------------------

        //tam1button
        tam1 =findViewById(R.id.tam1);
        tam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam1.setText(String.valueOf(sayitam1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tam1button//


        //tam2button
        tam2 =findViewById(R.id.tam2);
        tam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam2.setText(String.valueOf(sayitam2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tam2button//

        //tam3button
        tam3 =findViewById(R.id.tam3);
        tam3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam3.setText(String.valueOf(sayitam3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tam3button//

        //tam4button
        tam4 =findViewById(R.id.tam4);
        tam4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam4.setText(String.valueOf(sayitam4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tam4button//


        //tam5button
        tam5 =findViewById(R.id.tam5);
        tam5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam5.setText(String.valueOf(sayitam5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tam5button//


        //tam6button
        tam6 =findViewById(R.id.tam6);
        tam6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam6.setText(String.valueOf(sayitam6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tam6button//

        //tam7button
        tam7 =findViewById(R.id.tam7);
        tam7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam7.setText(String.valueOf(sayitam7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tam7button//

        //tam8button
        tam8 =findViewById(R.id.tam8);
        tam8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam8.setText(String.valueOf(sayitam8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tam8button//


        //tam9button
        tam9 =findViewById(R.id.tam9);
        tam9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam9.setText(String.valueOf(sayitam9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tam9button//

        //tam10button
        tam10 =findViewById(R.id.tam10);
        tam10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam10.setText(String.valueOf(sayitam10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tam10button//

        //tam11button
        tam11 =findViewById(R.id.tam11);
        tam11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam11.setText(String.valueOf(sayitam11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tam11button//

        //tam12button
        tam12 =findViewById(R.id.tam12);
        tam12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam12.setText(String.valueOf(sayitam12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tam12button//

        //tam13button
        tam13 =findViewById(R.id.tam13);
        tam13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam13.setText(String.valueOf(sayitam13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tam13button//

        //tam14button
        tam14 =findViewById(R.id.tam14);
        tam14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam14.setText(String.valueOf(sayitam14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tam14button//

        //tam15button
        tam15 =findViewById(R.id.tam15);
        tam15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam15.setText(String.valueOf(sayitam15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tam15button//

        //tam16button
        tam16 =findViewById(R.id.tam16);
        tam16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam16.setText(String.valueOf(sayitam16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tam16button//

        //tam11button
        tam17 =findViewById(R.id.tam17);
        tam17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam17.setText(String.valueOf(sayitam17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tam17button//

        //-----------------------------------------------------------------------------------

        //tkonter1button
        tkonter1 =findViewById(R.id.tkonter1);
        tkonter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter1.setText(String.valueOf(sayitkonter1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tkonter1button//


        //tkonter2button
        tkonter2 =findViewById(R.id.tkonter2);
        tkonter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter2.setText(String.valueOf(sayitkonter2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tkonter2button//

        //tkonter3button
        tkonter3 =findViewById(R.id.tkonter3);
        tkonter3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter3.setText(String.valueOf(sayitkonter3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tkonter3button//

        //tkonter4button
        tkonter4 =findViewById(R.id.tkonter4);
        tkonter4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter4.setText(String.valueOf(sayitkonter4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tkonter4button//


        //tkonter5button
        tkonter5 =findViewById(R.id.tkonter5);
        tkonter5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter5.setText(String.valueOf(sayitkonter5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tkonter5button//


        //tkonter6button
        tkonter6 =findViewById(R.id.tkonter6);
        tkonter6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter6.setText(String.valueOf(sayitkonter6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tkonter6button//

        //tkonter7button
        tkonter7 =findViewById(R.id.tkonter7);
        tkonter7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter7.setText(String.valueOf(sayitkonter7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tkonter7button//

        //tkonter8button
        tkonter8 =findViewById(R.id.tkonter8);
        tkonter8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter8.setText(String.valueOf(sayitkonter8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tkonter8button//


        //tkonter9button
        tkonter9 =findViewById(R.id.tkonter9);
        tkonter9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter9.setText(String.valueOf(sayitkonter9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tkonter9button//

        //tkonter10button
        tkonter10 =findViewById(R.id.tkonter10);
        tkonter10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter10.setText(String.valueOf(sayitkonter10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tkonter10button//

        //tkonter11button
        tkonter11 =findViewById(R.id.tkonter11);
        tkonter11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter11.setText(String.valueOf(sayitkonter11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tkonter11button//

        //tkonter12button
        tkonter12 =findViewById(R.id.tkonter12);
        tkonter12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter12.setText(String.valueOf(sayitkonter12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tkonter12button//

        //tkonter13button
        tkonter13 =findViewById(R.id.tkonter13);
        tkonter13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter13.setText(String.valueOf(sayitkonter13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tkonter13button//

        //tkonter14button
        tkonter14 =findViewById(R.id.tkonter14);
        tkonter14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter14.setText(String.valueOf(sayitkonter14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tkonter14button//

        //tkonter15button
        tkonter15 =findViewById(R.id.tkonter15);
        tkonter15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter15.setText(String.valueOf(sayitkonter15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tkonter15button//

        //tkonter16button
        tkonter16 =findViewById(R.id.tkonter16);
        tkonter16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter16.setText(String.valueOf(sayitkonter16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tkonter16button//

        //tkonter11button
        tkonter17 =findViewById(R.id.tkonter17);
        tkonter17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter17.setText(String.valueOf(sayitkonter17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tkonter17button//

        //-----------------------------------------------------------------------------------

        //tdp1button
        tdp1 =findViewById(R.id.tdp1);
        tdp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp1.setText(String.valueOf(sayitdp1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdp1button//


        //tdp2button
        tdp2 =findViewById(R.id.tdp2);
        tdp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp2.setText(String.valueOf(sayitdp2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdp2button//

        //tdp3button
        tdp3 =findViewById(R.id.tdp3);
        tdp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp3.setText(String.valueOf(sayitdp3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdp3button//

        //tdp4button
        tdp4 =findViewById(R.id.tdp4);
        tdp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp4.setText(String.valueOf(sayitdp4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdp4button//


        //tdp5button
        tdp5 =findViewById(R.id.tdp5);
        tdp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp5.setText(String.valueOf(sayitdp5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdp5button//


        //tdp6button
        tdp6 =findViewById(R.id.tdp6);
        tdp6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp6.setText(String.valueOf(sayitdp6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdp6button//

        //tdp7button
        tdp7 =findViewById(R.id.tdp7);
        tdp7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp7.setText(String.valueOf(sayitdp7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdp7button//

        //tdp8button
        tdp8 =findViewById(R.id.tdp8);
        tdp8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp8.setText(String.valueOf(sayitdp8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdp8button//


        //tdp9button
        tdp9 =findViewById(R.id.tdp9);
        tdp9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp9.setText(String.valueOf(sayitdp9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdp9button//

        //tdp10button
        tdp10 =findViewById(R.id.tdp10);
        tdp10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp10.setText(String.valueOf(sayitdp10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdp10button//

        //tdp11button
        tdp11 =findViewById(R.id.tdp11);
        tdp11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp11.setText(String.valueOf(sayitdp11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdp11button//

        //tdp12button
        tdp12 =findViewById(R.id.tdp12);
        tdp12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp12.setText(String.valueOf(sayitdp12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdp12button//

        //tdp13button
        tdp13 =findViewById(R.id.tdp13);
        tdp13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp13.setText(String.valueOf(sayitdp13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdp13button//

        //tdp14button
        tdp14 =findViewById(R.id.tdp14);
        tdp14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp14.setText(String.valueOf(sayitdp14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdp14button//

        //tdp15button
        tdp15 =findViewById(R.id.tdp15);
        tdp15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp15.setText(String.valueOf(sayitdp15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdp15button//

        //tdp16button
        tdp16 =findViewById(R.id.tdp16);
        tdp16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp16.setText(String.valueOf(sayitdp16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdp16button//

        //tdp17button
        tdp17 =findViewById(R.id.tdp17);
        tdp17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp17.setText(String.valueOf(sayitdp17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tdp17button//

        //-----------------------------------------------------------------------------------

        //tff1button
        tff1 =findViewById(R.id.tff1);
        tff1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff1.setText(String.valueOf(sayitff1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tff1button//


        //tff2button
        tff2 =findViewById(R.id.tff2);
        tff2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff2.setText(String.valueOf(sayitff2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tff2button//

        //tff3button
        tff3 =findViewById(R.id.tff3);
        tff3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff3.setText(String.valueOf(sayitff3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tff3button//

        //tff4button
        tff4 =findViewById(R.id.tff4);
        tff4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff4.setText(String.valueOf(sayitff4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tff4button//


        //tff5button
        tff5 =findViewById(R.id.tff5);
        tff5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff5.setText(String.valueOf(sayitff5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tff5button//


        //tff6button
        tff6 =findViewById(R.id.tff6);
        tff6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff6.setText(String.valueOf(sayitff6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tff6button//

        //tff7button
        tff7 =findViewById(R.id.tff7);
        tff7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff7.setText(String.valueOf(sayitff7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tff7button//

        //tff8button
        tff8 =findViewById(R.id.tff8);
        tff8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff8.setText(String.valueOf(sayitff8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tff8button//


        //tff9button
        tff9 =findViewById(R.id.tff9);
        tff9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff9.setText(String.valueOf(sayitff9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tff9button//

        //tff10button
        tff10 =findViewById(R.id.tff10);
        tff10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff10.setText(String.valueOf(sayitff10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tff10button//

        //tff11button
        tff11 =findViewById(R.id.tff11);
        tff11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff11.setText(String.valueOf(sayitff11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tff11button//

        //tff12button
        tff12 =findViewById(R.id.tff12);
        tff12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff12.setText(String.valueOf(sayitff12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tff12button//

        //tff13button
        tff13 =findViewById(R.id.tff13);
        tff13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff13.setText(String.valueOf(sayitff13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tff13button//

        //tff14button
        tff14 =findViewById(R.id.tff14);
        tff14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff14.setText(String.valueOf(sayitff14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tff14button//

        //tff15button
        tff15 =findViewById(R.id.tff15);
        tff15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff15.setText(String.valueOf(sayitff15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tff15button//

        //tff16button
        tff16 =findViewById(R.id.tff16);
        tff16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff16.setText(String.valueOf(sayitff16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tff16button//

        //tff11button
        tff17 =findViewById(R.id.tff17);
        tff17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff17.setText(String.valueOf(sayitff17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tff17button//

        //-----------------------------------------------------------------------------------

        //tfp1button
        tfp1 =findViewById(R.id.tfp1);
        tfp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp1.setText(String.valueOf(sayitfp1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfp1button//


        //tfp2button
        tfp2 =findViewById(R.id.tfp2);
        tfp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp2.setText(String.valueOf(sayitfp2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfp2button//

        //tfp3button
        tfp3 =findViewById(R.id.tfp3);
        tfp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp3.setText(String.valueOf(sayitfp3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfp3button//

        //tfp4button
        tfp4 =findViewById(R.id.tfp4);
        tfp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp4.setText(String.valueOf(sayitfp4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfp4button//


        //tfp5button
        tfp5 =findViewById(R.id.tfp5);
        tfp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp5.setText(String.valueOf(sayitfp5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfp5button//


        //tfp6button
        tfp6 =findViewById(R.id.tfp6);
        tfp6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp6.setText(String.valueOf(sayitfp6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfp6button//

        //tfp7button
        tfp7 =findViewById(R.id.tfp7);
        tfp7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp7.setText(String.valueOf(sayitfp7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfp7button//

        //tfp8button
        tfp8 =findViewById(R.id.tfp8);
        tfp8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp8.setText(String.valueOf(sayitfp8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfp8button//


        //tfp9button
        tfp9 =findViewById(R.id.tfp9);
        tfp9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp9.setText(String.valueOf(sayitfp9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfp9button//

        //tfp10button
        tfp10 =findViewById(R.id.tfp10);
        tfp10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp10.setText(String.valueOf(sayitfp10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfp10button//

        //tfp11button
        tfp11 =findViewById(R.id.tfp11);
        tfp11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp11.setText(String.valueOf(sayitfp11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfp11button//

        //tfp12button
        tfp12 =findViewById(R.id.tfp12);
        tfp12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp12.setText(String.valueOf(sayitfp12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfp12button//

        //tfp13button
        tfp13 =findViewById(R.id.tfp13);
        tfp13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp13.setText(String.valueOf(sayitfp13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfp13button//

        //tfp14button
        tfp14 =findViewById(R.id.tfp14);
        tfp14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp14.setText(String.valueOf(sayitfp14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfp14button//

        //tfp15button
        tfp15 =findViewById(R.id.tfp15);
        tfp15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp15.setText(String.valueOf(sayitfp15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfp15button//

        //tfp16button
        tfp16 =findViewById(R.id.tfp16);
        tfp16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp16.setText(String.valueOf(sayitfp16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfp16button//

        //tfp11button
        tfp17 =findViewById(R.id.tfp17);
        tfp17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp17.setText(String.valueOf(sayitfp17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfp17button//

        //-----------------------------------------------------------------------------------

        //tsr1button
        tsr1 =findViewById(R.id.tsr1);
        tsr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr1.setText(String.valueOf(sayitsr1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsr1button//


        //tsr2button
        tsr2 =findViewById(R.id.tsr2);
        tsr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr2.setText(String.valueOf(sayitsr2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsr2button//

        //tsr3button
        tsr3 =findViewById(R.id.tsr3);
        tsr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr3.setText(String.valueOf(sayitsr3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsr3button//

        //tsr4button
        tsr4 =findViewById(R.id.tsr4);
        tsr4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr4.setText(String.valueOf(sayitsr4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsr4button//


        //tsr5button
        tsr5 =findViewById(R.id.tsr5);
        tsr5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr5.setText(String.valueOf(sayitsr5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsr5button//


        //tsr6button
        tsr6 =findViewById(R.id.tsr6);
        tsr6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr6.setText(String.valueOf(sayitsr6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsr6button//

        //tsr7button
        tsr7 =findViewById(R.id.tsr7);
        tsr7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr7.setText(String.valueOf(sayitsr7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsr7button//

        //tsr8button
        tsr8 =findViewById(R.id.tsr8);
        tsr8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr8.setText(String.valueOf(sayitsr8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsr8button//


        //tfp9button
        tsr9 =findViewById(R.id.tsr9);
        tsr9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr9.setText(String.valueOf(sayitsr9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsr9button//

        //tsr10button
        tsr10 =findViewById(R.id.tsr10);
        tsr10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr10.setText(String.valueOf(sayitsr10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsr10button//

        //tsr11button
        tsr11 =findViewById(R.id.tsr11);
        tsr11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr11.setText(String.valueOf(sayitsr11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsr11button//

        //tsr12button
        tsr12 =findViewById(R.id.tsr12);
        tsr12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr12.setText(String.valueOf(sayitsr12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsr12button//

        //tsr13button
        tsr13 =findViewById(R.id.tsr13);
        tsr13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr13.setText(String.valueOf(sayitsr13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsr13button//

        //tsr14button
        tsr14 =findViewById(R.id.tsr14);
        tsr14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr14.setText(String.valueOf(sayitsr14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsr14button//

        //tsr15button
        tsr15 =findViewById(R.id.tsr15);
        tsr15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr15.setText(String.valueOf(sayitsr15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsr15button//

        //tsr16button
        tsr16 =findViewById(R.id.tsr16);
        tsr16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr16.setText(String.valueOf(sayitsr16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsr16button//

        //tsr11button
        tsr17 =findViewById(R.id.tsr17);
        tsr17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr17.setText(String.valueOf(sayitsr17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsr17button//

        //-----------------------------------------------------------------------------------

        //tsf1button
        tsf1 =findViewById(R.id.tsf1);
        tsf1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf1.setText(String.valueOf(sayitsf1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsf1button//


        //tsf2button
        tsf2 =findViewById(R.id.tsf2);
        tsf2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf2.setText(String.valueOf(sayitsf2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsf2button//

        //tsf3button
        tsf3 =findViewById(R.id.tsf3);
        tsf3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf3.setText(String.valueOf(sayitsf3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsf3button//

        //tsr4button
        tsf4 =findViewById(R.id.tsf4);
        tsf4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf4.setText(String.valueOf(sayitsf4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsf4button//


        //tsf5button
        tsf5 =findViewById(R.id.tsf5);
        tsf5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf5.setText(String.valueOf(sayitsf5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsf5button//


        //tsf6button
        tsf6 =findViewById(R.id.tsf6);
        tsf6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf6.setText(String.valueOf(sayitsf6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsf6button//

        //tsf7button
        tsf7 =findViewById(R.id.tsf7);
        tsf7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf7.setText(String.valueOf(sayitsf7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsf7button//

        //tsf8button
        tsf8 =findViewById(R.id.tsf8);
        tsf8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf8.setText(String.valueOf(sayitsf8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsf8button//


        //tsf9button
        tsf9 =findViewById(R.id.tsf9);
        tsf9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf9.setText(String.valueOf(sayitsf9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsf9button//

        //tsf10button
        tsf10 =findViewById(R.id.tsf10);
        tsf10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf10.setText(String.valueOf(sayitsf10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsf10button//

        //tsf11button
        tsf11 =findViewById(R.id.tsf11);
        tsf11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf11.setText(String.valueOf(sayitsf11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsf11button//

        //tsf12button
        tsf12 =findViewById(R.id.tsf12);
        tsf12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf12.setText(String.valueOf(sayitsf12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsf12button//

        //tsf13button
        tsf13 =findViewById(R.id.tsf13);
        tsf13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf13.setText(String.valueOf(sayitsf13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsf13button//

        //tsf14button
        tsf14 =findViewById(R.id.tsf14);
        tsf14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf14.setText(String.valueOf(sayitsf14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsf14button//

        //tsf15button
        tsf15 =findViewById(R.id.tsf15);
        tsf15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf15.setText(String.valueOf(sayitsf15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsf15button//

        //tsf16button
        tsf16 =findViewById(R.id.tsf16);
        tsf16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf16.setText(String.valueOf(sayitsf16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsf16button//

        //tsf11button
        tsf17 =findViewById(R.id.tsf17);
        tsf17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf17.setText(String.valueOf(sayitsf17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tsf17button//

        //-----------------------------------------------------------------------------------

        //tbeo1button
        tbeo1 =findViewById(R.id.tbeo1);
        tbeo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo1.setText(String.valueOf(sayitbeo1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbeo1button//


        //tbeo2button
        tbeo2 =findViewById(R.id.tbeo2);
        tbeo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo2.setText(String.valueOf(sayitbeo2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbeo2button//

        //tbeo3button
        tbeo3 =findViewById(R.id.tbeo3);
        tbeo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo3.setText(String.valueOf(sayitbeo3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbeo3button//

        //tbeo4button
        tbeo4 =findViewById(R.id.tbeo4);
        tbeo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo4.setText(String.valueOf(sayitbeo4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbeo4button//


        //tbeo5button
        tbeo5 =findViewById(R.id.tbeo5);
        tbeo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo5.setText(String.valueOf(sayitbeo5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbeo5button//


        //tbeo6button
        tbeo6 =findViewById(R.id.tbeo6);
        tbeo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo6.setText(String.valueOf(sayitbeo6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbeo6button//

        //tbeo7button
        tbeo7 =findViewById(R.id.tbeo7);
        tbeo7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo7.setText(String.valueOf(sayitbeo7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbeo7button//

        //tbeo8button
        tbeo8 =findViewById(R.id.tbeo8);
        tbeo8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo8.setText(String.valueOf(sayitbeo8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbeo8button//


        //tbeo9button
        tbeo9 =findViewById(R.id.tbeo9);
        tbeo9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo9.setText(String.valueOf(sayitbeo9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbeo9button//

        //tbeo10button
        tbeo10 =findViewById(R.id.tbeo10);
        tbeo10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo10.setText(String.valueOf(sayitbeo10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbeo10button//

        //tbeo11button
        tbeo11 =findViewById(R.id.tbeo11);
        tbeo11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo11.setText(String.valueOf(sayitbeo11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbeo11button//

        //tbeo12button
        tbeo12 =findViewById(R.id.tbeo12);
        tbeo12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo12.setText(String.valueOf(sayitbeo12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbeo12button//

        //tbeo13button
        tbeo13 =findViewById(R.id.tbeo13);
        tbeo13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo13.setText(String.valueOf(sayitbeo13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbeo13button//

        //tbeo14button
        tbeo14 =findViewById(R.id.tbeo14);
        tbeo14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo14.setText(String.valueOf(sayitbeo14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbeo14button//

        //tbeo15button
        tbeo15 =findViewById(R.id.tbeo15);
        tbeo15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo15.setText(String.valueOf(sayitbeo15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbeo15button//

        //tbeo16button
        tbeo16 =findViewById(R.id.tbeo16);
        tbeo16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo16.setText(String.valueOf(sayitbeo16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbeo16button//

        //tbeo11button
        tbeo17 =findViewById(R.id.tbeo17);
        tbeo17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo17.setText(String.valueOf(sayitbeo17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbeo17button//

        //-----------------------------------------------------------------------------------

        //tfoul1button
        tfoul1 =findViewById(R.id.tfoul1);
        tfoul1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul1.setText(String.valueOf(sayitfoul1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfoul1button//


        //tfoul2button
        tfoul2 =findViewById(R.id.tfoul2);
        tfoul2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul2.setText(String.valueOf(sayitfoul2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfoul2button//

        //tfoul3button
        tfoul3 =findViewById(R.id.tfoul3);
        tfoul3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul3.setText(String.valueOf(sayitfoul3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfoul3button//

        //tfoul4button
        tfoul4 =findViewById(R.id.tfoul4);
        tfoul4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul4.setText(String.valueOf(sayitfoul4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfoul4button//


        //tfoul5button
        tfoul5 =findViewById(R.id.tfoul5);
        tfoul5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul5.setText(String.valueOf(sayitfoul5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfoul5button//


        //tfoul6button
        tfoul6 =findViewById(R.id.tfoul6);
        tfoul6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul6.setText(String.valueOf(sayitfoul6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfoul6button//

        //tfoul7button
        tfoul7 =findViewById(R.id.tfoul7);
        tfoul7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul7.setText(String.valueOf(sayitfoul7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfoul7button//

        //tfoul8button
        tfoul8 =findViewById(R.id.tfoul8);
        tfoul8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul8.setText(String.valueOf(sayitfoul8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfoul8button//


        //tfoul9button
        tfoul9 =findViewById(R.id.tfoul9);
        tfoul9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul9.setText(String.valueOf(sayitfoul9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfoul9button//

        //tfoul10button
        tfoul10 =findViewById(R.id.tfoul10);
        tfoul10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul10.setText(String.valueOf(sayitfoul10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfoul10button//

        //tfoul11button
        tfoul11 =findViewById(R.id.tfoul11);
        tfoul11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul11.setText(String.valueOf(sayitfoul11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfoul11button//

        //tfoul12button
        tfoul12 =findViewById(R.id.tfoul12);
        tfoul12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul12.setText(String.valueOf(sayitfoul12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfoul12button//

        //tfoul13button
        tfoul13 =findViewById(R.id.tfoul13);
        tfoul13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul13.setText(String.valueOf(sayitfoul13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfoul13button//

        //tfoul14button
        tfoul14 =findViewById(R.id.tfoul14);
        tfoul14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul14.setText(String.valueOf(sayitfoul14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfoul14button//

        //tfoul15button
        tfoul15 =findViewById(R.id.tfoul15);
        tfoul15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul15.setText(String.valueOf(sayitfoul15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfoul15button//

        //tfoul16button
        tfoul16 =findViewById(R.id.tfoul16);
        tfoul16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul16.setText(String.valueOf(sayitfoul16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfoul16button//

        //tfoul11button
        tfoul17 =findViewById(R.id.tfoul17);
        tfoul17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul17.setText(String.valueOf(sayitfoul17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tfoul17button//

        //--------------------------------------------------------------------------------------------

        //trausy1button
        trausy1 =findViewById(R.id.trausy1);
        trausy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy1.setText(String.valueOf(sayitrausy1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausy1button//


        //trausy2button
        trausy2 =findViewById(R.id.trausy2);
        trausy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy2.setText(String.valueOf(sayitrausy2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausy2button//

        //trausy3button
        trausy3 =findViewById(R.id.trausy3);
        trausy3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy3.setText(String.valueOf(sayitrausy3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausy3button//

        //trausy4button
        trausy4 =findViewById(R.id.trausy4);
        trausy4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy4.setText(String.valueOf(sayitrausy4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausy4button//


        //trausy5button
        trausy5 =findViewById(R.id.trausy5);
        trausy5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy5.setText(String.valueOf(sayitrausy5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausy5button//


        //trausy6button
        trausy6 =findViewById(R.id.trausy6);
        trausy6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy6.setText(String.valueOf(sayitrausy6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausy6button//

        //trausy7button
        trausy7 =findViewById(R.id.trausy7);
        trausy7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy7.setText(String.valueOf(sayitrausy7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausy7button//

        //trausy8button
        trausy8 =findViewById(R.id.trausy8);
        trausy8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy8.setText(String.valueOf(sayitrausy8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausy8button//


        //trausy9button
        trausy9 =findViewById(R.id.trausy9);
        trausy9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy9.setText(String.valueOf(sayitrausy9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausy9button//

        //trausy10button
        trausy10 =findViewById(R.id.trausy10);
        trausy10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy10.setText(String.valueOf(sayitrausy10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausy10button//

        //trausy11button
        trausy11 =findViewById(R.id.trausy11);
        trausy11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy11.setText(String.valueOf(sayitrausy11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausy11button//

        //trausy12button
        trausy12 =findViewById(R.id.trausy12);
        trausy12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy12.setText(String.valueOf(sayitrausy12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausy12button//

        //trausy13button
        trausy13 =findViewById(R.id.trausy13);
        trausy13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy13.setText(String.valueOf(sayitrausy13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausy13button//

        //trausy14button
        trausy14 =findViewById(R.id.trausy14);
        trausy14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy14.setText(String.valueOf(sayitrausy14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausy14button//

        //trausy15button
        trausy15 =findViewById(R.id.trausy15);
        trausy15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy15.setText(String.valueOf(sayitrausy15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausy15button//

        //trausy16button
        trausy16 =findViewById(R.id.trausy16);
        trausy16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy16.setText(String.valueOf(sayitrausy16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausy16button//

        //trausy17button
        trausy17 =findViewById(R.id.trausy17);
        trausy17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy17.setText(String.valueOf(sayitrausy17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausy17button//

        //--------------------------------------------------------------------------------------------

        //trausi1button
        trausi1 =findViewById(R.id.trausi1);
        trausi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi1.setText(String.valueOf(sayitrausi1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausi1button//


        //trausi2button
        trausi2 =findViewById(R.id.trausi2);
        trausi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi2.setText(String.valueOf(sayitrausi2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausi2button//

        //trausi3button
        trausi3 =findViewById(R.id.trausi3);
        trausi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi3.setText(String.valueOf(sayitrausi3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausi3button//

        //trausi4button
        trausi4 =findViewById(R.id.trausi4);
        trausi4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi4.setText(String.valueOf(sayitrausi4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausi4button//


        //trausi5button
        trausi5 =findViewById(R.id.trausi5);
        trausi5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi5.setText(String.valueOf(sayitrausi5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausi5button//


        //trausi6button
        trausi6 =findViewById(R.id.trausi6);
        trausi6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi6.setText(String.valueOf(sayitrausi6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausi6button//

        //trausi7button
        trausi7 =findViewById(R.id.trausi7);
        trausi7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi7.setText(String.valueOf(sayitrausi7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausi7button//

        //trausi8button
        trausi8 =findViewById(R.id.trausi8);
        trausi8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi8.setText(String.valueOf(sayitrausi8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausi8button//


        //trausi9button
        trausi9 =findViewById(R.id.trausi9);
        trausi9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi9.setText(String.valueOf(sayitrausi9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausi9button//

        //trausi10button
        trausi10 =findViewById(R.id.trausi10);
        trausi10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi10.setText(String.valueOf(sayitrausi10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausi10button//

        //trausi11button
        trausi11 =findViewById(R.id.trausi11);
        trausi11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi11.setText(String.valueOf(sayitrausi11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausi11button//

        //trausi12button
        trausi12 =findViewById(R.id.trausi12);
        trausi12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi12.setText(String.valueOf(sayitrausi12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausi12button//

        //trausi13button
        trausi13 =findViewById(R.id.trausi13);
        trausi13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi13.setText(String.valueOf(sayitrausi13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausi13button//

        //trausi14button
        trausi14 =findViewById(R.id.trausi14);
        trausi14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi14.setText(String.valueOf(sayitrausi14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausi14button//

        //trausi15button
        trausi15 =findViewById(R.id.trausi15);
        trausi15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi15.setText(String.valueOf(sayitrausi15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausi15button//

        //trausi16button
        trausi16 =findViewById(R.id.trausi16);
        trausi16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi16.setText(String.valueOf(sayitrausi16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausi16button//

        //trausi17button
        trausi17 =findViewById(R.id.trausi17);
        trausi17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi17.setText(String.valueOf(sayitrausi17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //trausi17button//

        //--------------------------------------------------------------------------------------------

        //tbecom1button
        tbecom1 =findViewById(R.id.tbecom1);
        tbecom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom1.setText(String.valueOf(sayitbecom1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbecom1button//


        //tbecom2button
        tbecom2 =findViewById(R.id.tbecom2);
        tbecom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom2.setText(String.valueOf(sayitbecom2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbecom2button//

        //tbecom3button
        tbecom3 =findViewById(R.id.tbecom3);
        tbecom3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom3.setText(String.valueOf(sayitbecom3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbecom3button//

        //tbecom4button
        tbecom4 =findViewById(R.id.tbecom4);
        tbecom4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom4.setText(String.valueOf(sayitbecom4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbecom4button//


        //tbecom5button
        tbecom5 =findViewById(R.id.tbecom5);
        tbecom5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom5.setText(String.valueOf(sayitbecom5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbecom5button//


        //tbecom6button
        tbecom6 =findViewById(R.id.tbecom6);
        tbecom6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom6.setText(String.valueOf(sayitbecom6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbecom6button//

        //tbecom7button
        tbecom7 =findViewById(R.id.tbecom7);
        tbecom7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom7.setText(String.valueOf(sayitbecom7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbecom7button//

        //tbecom8button
        tbecom8 =findViewById(R.id.tbecom8);
        tbecom8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom8.setText(String.valueOf(sayitbecom8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbecom8button//


        //tbecom9button
        tbecom9 =findViewById(R.id.tbecom9);
        tbecom9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom9.setText(String.valueOf(sayitbecom9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbecom9button//

        //tbecom10button
        tbecom10 =findViewById(R.id.tbecom10);
        tbecom10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom10.setText(String.valueOf(sayitbecom10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbecom10button//

        //tbecom11button
        tbecom11 =findViewById(R.id.tbecom11);
        tbecom11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom11.setText(String.valueOf(sayitbecom11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbecom11button//

        //tbecom12button
        tbecom12 =findViewById(R.id.tbecom12);
        tbecom12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom12.setText(String.valueOf(sayitbecom12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbecom12button//

        //tbecom3button
        tbecom13 =findViewById(R.id.tbecom13);
        tbecom13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom13.setText(String.valueOf(sayitbecom13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbecom13button//

        //tbecom14button
        tbecom14 =findViewById(R.id.tbecom14);
        tbecom14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom14.setText(String.valueOf(sayitbecom14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbecom14button//

        //tbecom15button
        tbecom15 =findViewById(R.id.tbecom15);
        tbecom15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom15.setText(String.valueOf(sayitbecom15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbecom15button//

        //tbecom16button
        tbecom16 =findViewById(R.id.tbecom16);
        tbecom16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom16.setText(String.valueOf(sayitbecom16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbecom16button//

        //tbecom17button
        tbecom17 =findViewById(R.id.tbecom17);
        tbecom17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom17.setText(String.valueOf(sayitbecom17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tbecom17button//

        //--------------------------------------------------------------------------------------------

        //tred1button
        tred1 =findViewById(R.id.tred1);
        tred1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred1.setText(String.valueOf(sayitred1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tred1button//


        //tred2button
        tred2 =findViewById(R.id.tred2);
        tred2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred2.setText(String.valueOf(sayitred2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tred2button//

        //tred3button
        tred3 =findViewById(R.id.tred3);
        tred3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred3.setText(String.valueOf(sayitred3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tred3button//

        //tred4button
        tred4 =findViewById(R.id.tred4);
        tred4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred4.setText(String.valueOf(sayitred4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tred4button//


        //tred5button
        tred5 =findViewById(R.id.tred5);
        tred5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred5.setText(String.valueOf(sayitred5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tred5button//


        //tred6button
        tred6 =findViewById(R.id.tred6);
        tred6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred6.setText(String.valueOf(sayitred6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tred6button//

        //tred7button
        tred7 =findViewById(R.id.tred7);
        tred7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred7.setText(String.valueOf(sayitred7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tred7button//

        //tred8button
        tred8 =findViewById(R.id.tred8);
        tred8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred8.setText(String.valueOf(sayitred8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tred8button//


        //tred9button
        tred9 =findViewById(R.id.tred9);
        tred9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred9.setText(String.valueOf(sayitred9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tred9button//

        //tred10button
        tred10 =findViewById(R.id.tred10);
        tred10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred10.setText(String.valueOf(sayitred10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tred10button//

        //tred11button
        tred11 =findViewById(R.id.tred11);
        tred11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred11.setText(String.valueOf(sayitred11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tred11button//

        //tred12button
        tred12 =findViewById(R.id.tred12);
        tred12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred12.setText(String.valueOf(sayitred12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tred12button//

        //tred13button
        tred13 =findViewById(R.id.tred13);
        tred13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred13.setText(String.valueOf(sayitred13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tred13button//

        //tred14button
        tred14 =findViewById(R.id.tred14);
        tred14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred14.setText(String.valueOf(sayitred14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tred14button//

        //tred15button
        tred15 =findViewById(R.id.tred15);
        tred15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred15.setText(String.valueOf(sayitred15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tred15button//

        //tred16button
        tred16 =findViewById(R.id.tred16);
        tred16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred16.setText(String.valueOf(sayitred16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tred16button//

        //tred17button
        tred17 =findViewById(R.id.tred17);
        tred17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred17.setText(String.valueOf(sayitred17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
        //tred17button//

        //------------------------------------------------------------------------------------

        //------------------------------------------------------------------------------------

        btnazalt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                azaltıcıt9m1();
                azaltıcıt9m2();
                azaltıcıt9m3();
                azaltıcıt9m4();
                azaltıcıt9m5();
                azaltıcıt9m6();
                azaltıcıt9m7();
                azaltıcıt9m8();
                azaltıcıt9m9();
                azaltıcıt9m10();
                azaltıcıt9m11();
                azaltıcıt9m12();
                azaltıcıt9m13();
                azaltıcıt9m14();
                azaltıcıt9m15();
                azaltıcıt9m16();
                azaltıcıt9m17();


                azaltıcıt6m1();
                azaltıcıt6m2();
                azaltıcıt6m3();
                azaltıcıt6m4();
                azaltıcıt6m5();
                azaltıcıt6m6();
                azaltıcıt6m7();
                azaltıcıt6m8();
                azaltıcıt6m9();
                azaltıcıt6m10();
                azaltıcıt6m11();
                azaltıcıt6m12();
                azaltıcıt6m13();
                azaltıcıt6m14();
                azaltıcıt6m15();
                azaltıcıt6m16();
                azaltıcıt6m17();

                azaltıcıtWelle1();
                azaltıcıtWelle2();
                azaltıcıtWelle3();
                azaltıcıtWelle4();
                azaltıcıtWelle5();
                azaltıcıtWelle6();
                azaltıcıtWelle7();
                azaltıcıtWelle8();
                azaltıcıtWelle9();
                azaltıcıtWelle10();
                azaltıcıtWelle11();
                azaltıcıtWelle12();
                azaltıcıtWelle13();
                azaltıcıtWelle14();
                azaltıcıtWelle15();
                azaltıcıtWelle16();
                azaltıcıtWelle17();

                azaltıcıtartı1();
                azaltıcıtartı2();
                azaltıcıtartı3();
                azaltıcıtartı4();
                azaltıcıtartı5();
                azaltıcıtartı6();
                azaltıcıtartı7();
                azaltıcıtartı8();
                azaltıcıtartı9();
                azaltıcıtartı10();
                azaltıcıtartı11();
                azaltıcıtartı12();
                azaltıcıtartı13();
                azaltıcıtartı14();
                azaltıcıtartı15();
                azaltıcıtartı16();
                azaltıcıtartı17();

                azaltıcıteksi1();
                azaltıcıteksi2();
                azaltıcıteksi3();
                azaltıcıteksi4();
                azaltıcıteksi5();
                azaltıcıteksi6();
                azaltıcıteksi7();
                azaltıcıteksi8();
                azaltıcıteksi9();
                azaltıcıteksi10();
                azaltıcıteksi11();
                azaltıcıteksi12();
                azaltıcıteksi13();
                azaltıcıteksi14();
                azaltıcıteksi15();
                azaltıcıteksi16();
                azaltıcıteksi17();

                azaltıcıtdm1();
                azaltıcıtdm2();
                azaltıcıtdm3();
                azaltıcıtdm4();
                azaltıcıtdm5();
                azaltıcıtdm6();
                azaltıcıtdm7();
                azaltıcıtdm8();
                azaltıcıtdm9();
                azaltıcıtdm10();
                azaltıcıtdm11();
                azaltıcıtdm12();
                azaltıcıtdm13();
                azaltıcıtdm14();
                azaltıcıtdm15();
                azaltıcıtdm16();
                azaltıcıtdm17();

                azaltıcıtam1();
                azaltıcıtam2();
                azaltıcıtam3();
                azaltıcıtam4();
                azaltıcıtam5();
                azaltıcıtam6();
                azaltıcıtam7();
                azaltıcıtam8();
                azaltıcıtam9();
                azaltıcıtam10();
                azaltıcıtam11();
                azaltıcıtam12();
                azaltıcıtam13();
                azaltıcıtam14();
                azaltıcıtam15();
                azaltıcıtam16();
                azaltıcıtam17();

                azaltıcıtkonter1();
                azaltıcıtkonter2();
                azaltıcıtkonter3();
                azaltıcıtkonter4();
                azaltıcıtkonter5();
                azaltıcıtkonter6();
                azaltıcıtkonter7();
                azaltıcıtkonter8();
                azaltıcıtkonter9();
                azaltıcıtkonter10();
                azaltıcıtkonter11();
                azaltıcıtkonter12();
                azaltıcıtkonter13();
                azaltıcıtkonter14();
                azaltıcıtkonter15();
                azaltıcıtkonter16();
                azaltıcıtkonter17();

                azaltıcıtdp1();
                azaltıcıtdp2();
                azaltıcıtdp3();
                azaltıcıtdp4();
                azaltıcıtdp5();
                azaltıcıtdp6();
                azaltıcıtdp7();
                azaltıcıtdp8();
                azaltıcıtdp9();
                azaltıcıtdp10();
                azaltıcıtdp11();
                azaltıcıtdp12();
                azaltıcıtdp13();
                azaltıcıtdp14();
                azaltıcıtdp15();
                azaltıcıtdp16();
                azaltıcıtdp17();

                azaltıcıtff1();
                azaltıcıtff2();
                azaltıcıtff3();
                azaltıcıtff4();
                azaltıcıtff5();
                azaltıcıtff6();
                azaltıcıtff7();
                azaltıcıtff8();
                azaltıcıtff9();
                azaltıcıtff10();
                azaltıcıtff11();
                azaltıcıtff12();
                azaltıcıtff13();
                azaltıcıtff14();
                azaltıcıtff15();
                azaltıcıtff16();
                azaltıcıtff17();

                azaltıcıtfp1();
                azaltıcıtfp2();
                azaltıcıtfp3();
                azaltıcıtfp4();
                azaltıcıtfp5();
                azaltıcıtfp6();
                azaltıcıtfp7();
                azaltıcıtfp8();
                azaltıcıtfp9();
                azaltıcıtfp10();
                azaltıcıtfp11();
                azaltıcıtfp12();
                azaltıcıtfp13();
                azaltıcıtfp14();
                azaltıcıtfp15();
                azaltıcıtfp16();
                azaltıcıtfp17();

                azaltıcıtsr1();
                azaltıcıtsr2();
                azaltıcıtsr3();
                azaltıcıtsr4();
                azaltıcıtsr5();
                azaltıcıtsr6();
                azaltıcıtsr7();
                azaltıcıtsr8();
                azaltıcıtsr9();
                azaltıcıtsr10();
                azaltıcıtsr11();
                azaltıcıtsr12();
                azaltıcıtsr13();
                azaltıcıtsr14();
                azaltıcıtsr15();
                azaltıcıtsr16();
                azaltıcıtsr17();

                azaltıcıtsf1();
                azaltıcıtsf2();
                azaltıcıtsf3();
                azaltıcıtsf4();
                azaltıcıtsf5();
                azaltıcıtsf6();
                azaltıcıtsf7();
                azaltıcıtsf8();
                azaltıcıtsf9();
                azaltıcıtsf10();
                azaltıcıtsf11();
                azaltıcıtsf12();
                azaltıcıtsf13();
                azaltıcıtsf14();
                azaltıcıtsf15();
                azaltıcıtsf16();
                azaltıcıtsf17();

                azaltıcıtbeo1();
                azaltıcıtbeo2();
                azaltıcıtbeo3();
                azaltıcıtbeo4();
                azaltıcıtbeo5();
                azaltıcıtbeo6();
                azaltıcıtbeo7();
                azaltıcıtbeo8();
                azaltıcıtbeo9();
                azaltıcıtbeo10();
                azaltıcıtbeo11();
                azaltıcıtbeo12();
                azaltıcıtbeo13();
                azaltıcıtbeo14();
                azaltıcıtbeo15();
                azaltıcıtbeo16();
                azaltıcıtbeo17();

                azaltıcıtfoul1();
                azaltıcıtfoul2();
                azaltıcıtfoul3();
                azaltıcıtfoul4();
                azaltıcıtfoul5();
                azaltıcıtfoul6();
                azaltıcıtfoul7();
                azaltıcıtfoul8();
                azaltıcıtfoul9();
                azaltıcıtfoul10();
                azaltıcıtfoul11();
                azaltıcıtfoul12();
                azaltıcıtfoul13();
                azaltıcıtfoul14();
                azaltıcıtfoul15();
                azaltıcıtfoul16();
                azaltıcıtfoul17();

                azaltıcıtrausy1();
                azaltıcıtrausy2();
                azaltıcıtrausy3();
                azaltıcıtrausy4();
                azaltıcıtrausy5();
                azaltıcıtrausy6();
                azaltıcıtrausy7();
                azaltıcıtrausy8();
                azaltıcıtrausy9();
                azaltıcıtrausy10();
                azaltıcıtrausy11();
                azaltıcıtrausy12();
                azaltıcıtrausy13();
                azaltıcıtrausy14();
                azaltıcıtrausy15();
                azaltıcıtrausy16();
                azaltıcıtrausy17();

                azaltıcıtrausi1();
                azaltıcıtrausi2();
                azaltıcıtrausi3();
                azaltıcıtrausi4();
                azaltıcıtrausi5();
                azaltıcıtrausi6();
                azaltıcıtrausi7();
                azaltıcıtrausi8();
                azaltıcıtrausi9();
                azaltıcıtrausi10();
                azaltıcıtrausi11();
                azaltıcıtrausi12();
                azaltıcıtrausi13();
                azaltıcıtrausi14();
                azaltıcıtrausi15();
                azaltıcıtrausi16();
                azaltıcıtrausi17();

                azaltıcıtbecom1();
                azaltıcıtbecom2();
                azaltıcıtbecom3();
                azaltıcıtbecom4();
                azaltıcıtbecom5();
                azaltıcıtbecom6();
                azaltıcıtbecom7();
                azaltıcıtbecom8();
                azaltıcıtbecom9();
                azaltıcıtbecom10();
                azaltıcıtbecom11();
                azaltıcıtbecom12();
                azaltıcıtbecom13();
                azaltıcıtbecom14();
                azaltıcıtbecom15();
                azaltıcıtbecom16();
                azaltıcıtbecom17();

                azaltıcıtred1();
                azaltıcıtred2();
                azaltıcıtred3();
                azaltıcıtred4();
                azaltıcıtred5();
                azaltıcıtred6();
                azaltıcıtred7();
                azaltıcıtred8();
                azaltıcıtred9();
                azaltıcıtred10();
                azaltıcıtred11();
                azaltıcıtred12();
                azaltıcıtred13();
                azaltıcıtred14();
                azaltıcıtred15();
                azaltıcıtred16();
                azaltıcıtred17();

            }
        });

        btnarttır.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arttiricit9m1();
                arttiricit9m2();
                arttiricit9m3();
                arttiricit9m4();
                arttiricit9m5();
                arttiricit9m6();
                arttiricit9m7();
                arttiricit9m8();
                arttiricit9m9();
                arttiricit9m10();
                arttiricit9m11();
                arttiricit9m12();
                arttiricit9m13();
                arttiricit9m14();
                arttiricit9m15();
                arttiricit9m16();
                arttiricit9m17();



                arttiricit6m1();
                arttiricit6m2();
                arttiricit6m3();
                arttiricit6m4();
                arttiricit6m5();
                arttiricit6m6();
                arttiricit6m7();
                arttiricit6m8();
                arttiricit6m9();
                arttiricit6m10();
                arttiricit6m11();
                arttiricit6m12();
                arttiricit6m13();
                arttiricit6m14();
                arttiricit6m15();
                arttiricit6m16();
                arttiricit6m17();

                arttiricitWelle1();
                arttiricitWelle2();
                arttiricitWelle3();
                arttiricitWelle4();
                arttiricitWelle5();
                arttiricitWelle6();
                arttiricitWelle7();
                arttiricitWelle8();
                arttiricitWelle9();
                arttiricitWelle10();
                arttiricitWelle11();
                arttiricitWelle12();
                arttiricitWelle13();
                arttiricitWelle14();
                arttiricitWelle15();
                arttiricitWelle16();
                arttiricitWelle17();

                arttiricitartı1();
                arttiricitartı2();
                arttiricitartı3();
                arttiricitartı4();
                arttiricitartı5();
                arttiricitartı6();
                arttiricitartı7();
                arttiricitartı8();
                arttiricitartı9();
                arttiricitartı10();
                arttiricitartı11();
                arttiricitartı12();
                arttiricitartı13();
                arttiricitartı14();
                arttiricitartı15();
                arttiricitartı16();
                arttiricitartı17();

                arttiriciteksi1();
                arttiriciteksi2();
                arttiriciteksi3();
                arttiriciteksi4();
                arttiriciteksi5();
                arttiriciteksi6();
                arttiriciteksi7();
                arttiriciteksi8();
                arttiriciteksi9();
                arttiriciteksi10();
                arttiriciteksi11();
                arttiriciteksi12();
                arttiriciteksi13();
                arttiriciteksi14();
                arttiriciteksi15();
                arttiriciteksi16();
                arttiriciteksi17();

                arttiricitdm1();
                arttiricitdm2();
                arttiricitdm3();
                arttiricitdm4();
                arttiricitdm5();
                arttiricitdm6();
                arttiricitdm7();
                arttiricitdm8();
                arttiricitdm9();
                arttiricitdm10();
                arttiricitdm11();
                arttiricitdm12();
                arttiricitdm13();
                arttiricitdm14();
                arttiricitdm15();
                arttiricitdm16();
                arttiricitdm17();

                arttiricitam1();
                arttiricitam2();
                arttiricitam3();
                arttiricitam4();
                arttiricitam5();
                arttiricitam6();
                arttiricitam7();
                arttiricitam8();
                arttiricitam9();
                arttiricitam10();
                arttiricitam11();
                arttiricitam12();
                arttiricitam13();
                arttiricitam14();
                arttiricitam15();
                arttiricitam16();
                arttiricitam17();

                arttiricitkonter1();
                arttiricitkonter2();
                arttiricitkonter3();
                arttiricitkonter4();
                arttiricitkonter5();
                arttiricitkonter6();
                arttiricitkonter7();
                arttiricitkonter8();
                arttiricitkonter9();
                arttiricitkonter10();
                arttiricitkonter11();
                arttiricitkonter12();
                arttiricitkonter13();
                arttiricitkonter14();
                arttiricitkonter15();
                arttiricitkonter16();
                arttiricitkonter17();

                arttiricitdp1();
                arttiricitdp2();
                arttiricitdp3();
                arttiricitdp4();
                arttiricitdp5();
                arttiricitdp6();
                arttiricitdp7();
                arttiricitdp8();
                arttiricitdp9();
                arttiricitdp10();
                arttiricitdp11();
                arttiricitdp12();
                arttiricitdp13();
                arttiricitdp14();
                arttiricitdp15();
                arttiricitdp16();
                arttiricitdp17();

                arttiricitff1();
                arttiricitff2();
                arttiricitff3();
                arttiricitff4();
                arttiricitff5();
                arttiricitff6();
                arttiricitff7();
                arttiricitff8();
                arttiricitff9();
                arttiricitff10();
                arttiricitff11();
                arttiricitff12();
                arttiricitff13();
                arttiricitff14();
                arttiricitff15();
                arttiricitff16();
                arttiricitff17();

                arttiricitfp1();
                arttiricitfp2();
                arttiricitfp3();
                arttiricitfp4();
                arttiricitfp5();
                arttiricitfp6();
                arttiricitfp7();
                arttiricitfp8();
                arttiricitfp9();
                arttiricitfp10();
                arttiricitfp11();
                arttiricitfp12();
                arttiricitfp13();
                arttiricitfp14();
                arttiricitfp15();
                arttiricitfp16();
                arttiricitfp17();

                arttiricitsr1();
                arttiricitsr2();
                arttiricitsr3();
                arttiricitsr4();
                arttiricitsr5();
                arttiricitsr6();
                arttiricitsr7();
                arttiricitsr8();
                arttiricitsr9();
                arttiricitsr10();
                arttiricitsr11();
                arttiricitsr12();
                arttiricitsr13();
                arttiricitsr14();
                arttiricitsr15();
                arttiricitsr16();
                arttiricitsr17();

                arttiricitsf1();
                arttiricitsf2();
                arttiricitsf3();
                arttiricitsf4();
                arttiricitsf5();
                arttiricitsf6();
                arttiricitsf7();
                arttiricitsf8();
                arttiricitsf9();
                arttiricitsf10();
                arttiricitsf11();
                arttiricitsf12();
                arttiricitsf13();
                arttiricitsf14();
                arttiricitsf15();
                arttiricitsf16();
                arttiricitsf17();

                arttiricitbeo1();
                arttiricitbeo2();
                arttiricitbeo3();
                arttiricitbeo4();
                arttiricitbeo5();
                arttiricitbeo6();
                arttiricitbeo7();
                arttiricitbeo8();
                arttiricitbeo9();
                arttiricitbeo10();
                arttiricitbeo11();
                arttiricitbeo12();
                arttiricitbeo13();
                arttiricitbeo14();
                arttiricitbeo15();
                arttiricitbeo16();
                arttiricitbeo17();

                arttiricitfoul1();
                arttiricitfoul2();
                arttiricitfoul3();
                arttiricitfoul4();
                arttiricitfoul5();
                arttiricitfoul6();
                arttiricitfoul7();
                arttiricitfoul8();
                arttiricitfoul9();
                arttiricitfoul10();
                arttiricitfoul11();
                arttiricitfoul12();
                arttiricitfoul13();
                arttiricitfoul14();
                arttiricitfoul15();
                arttiricitfoul16();
                arttiricitfoul17();

                arttiricitrausy1();
                arttiricitrausy2();
                arttiricitrausy3();
                arttiricitrausy4();
                arttiricitrausy5();
                arttiricitrausy6();
                arttiricitrausy7();
                arttiricitrausy8();
                arttiricitrausy9();
                arttiricitrausy10();
                arttiricitrausy11();
                arttiricitrausy12();
                arttiricitrausy13();
                arttiricitrausy14();
                arttiricitrausy15();
                arttiricitrausy16();
                arttiricitrausy17();

                arttiricitrausi1();
                arttiricitrausi2();
                arttiricitrausi3();
                arttiricitrausi4();
                arttiricitrausi5();
                arttiricitrausi6();
                arttiricitrausi7();
                arttiricitrausi8();
                arttiricitrausi9();
                arttiricitrausi10();
                arttiricitrausi11();
                arttiricitrausi12();
                arttiricitrausi13();
                arttiricitrausi14();
                arttiricitrausi15();
                arttiricitrausi16();
                arttiricitrausi17();

                arttiricitbecom1();
                arttiricitbecom2();
                arttiricitbecom3();
                arttiricitbecom4();
                arttiricitbecom5();
                arttiricitbecom6();
                arttiricitbecom7();
                arttiricitbecom8();
                arttiricitbecom9();
                arttiricitbecom10();
                arttiricitbecom11();
                arttiricitbecom12();
                arttiricitbecom13();
                arttiricitbecom14();
                arttiricitbecom15();
                arttiricitbecom16();
                arttiricitbecom17();

                arttiricitred1();
                arttiricitred2();
                arttiricitred3();
                arttiricitred4();
                arttiricitred5();
                arttiricitred6();
                arttiricitred7();
                arttiricitred8();
                arttiricitred9();
                arttiricitred10();
                arttiricitred11();
                arttiricitred12();
                arttiricitred13();
                arttiricitred14();
                arttiricitred15();
                arttiricitred16();
                arttiricitred17();
            }
        });


    }


    //t9m1button//
    public void azaltıcıt9m1(){
        t9m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m1.setText(String.valueOf(sayit9m1--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit9m1(){
        t9m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m1.setText(String.valueOf(sayit9m1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t9m1button//

    //t9m2button//
    public void azaltıcıt9m2(){
        t9m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m2.setText(String.valueOf(sayit9m2--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit9m2(){
        t9m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m2.setText(String.valueOf(sayit9m2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t9m2button//

    //t9m3button//
    public void azaltıcıt9m3(){
        t9m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m3.setText(String.valueOf(sayit9m3--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit9m3(){
        t9m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m3.setText(String.valueOf(sayit9m3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t9m3button//

    //t9m4button//
    public void azaltıcıt9m4(){
        t9m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m4.setText(String.valueOf(sayit9m4--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit9m4(){
        t9m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m4.setText(String.valueOf(sayit9m4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t9m4button//

    //t9m5button//
    public void azaltıcıt9m5(){
        t9m5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m5.setText(String.valueOf(sayit9m5--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit9m5(){
        t9m5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m5.setText(String.valueOf(sayit9m5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t9m5button//

    //t9m6button//
    public void azaltıcıt9m6(){
        t9m6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m6.setText(String.valueOf(sayit9m6--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit9m6(){
        t9m6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m6.setText(String.valueOf(sayit9m6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t9m6button//

    //t9m7button//
    public void azaltıcıt9m7(){
        t9m7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m7.setText(String.valueOf(sayit9m7--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit9m7(){
        t9m7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m7.setText(String.valueOf(sayit9m7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t9m7button//

    //t9m8button//
    public void azaltıcıt9m8(){
        t9m8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m8.setText(String.valueOf(sayit9m8--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit9m8(){
        t9m8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m8.setText(String.valueOf(sayit9m8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t9m8button//

    //t9m9button//
    public void azaltıcıt9m9(){
        t9m9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m9.setText(String.valueOf(sayit9m9--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit9m9(){
        t9m9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m9.setText(String.valueOf(sayit9m9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t9m9button//

    //t9m10button//
    public void azaltıcıt9m10(){
        t9m10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m10.setText(String.valueOf(sayit9m10--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit9m10(){
        t9m10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m10.setText(String.valueOf(sayit9m10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t9m10button//

    //t9m11button//
    public void azaltıcıt9m11(){
        t9m11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m11.setText(String.valueOf(sayit9m11--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit9m11(){
        t9m11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m11.setText(String.valueOf(sayit9m11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t9m11button//

    //t9m12button//
    public void azaltıcıt9m12(){
        t9m12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m12.setText(String.valueOf(sayit9m12--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit9m12(){
        t9m12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m12.setText(String.valueOf(sayit9m12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t9m12button//

    //t9m13button//
    public void azaltıcıt9m13(){
        t9m13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m13.setText(String.valueOf(sayit9m13--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit9m13(){
        t9m13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m13.setText(String.valueOf(sayit9m13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t9m13button//

    //t9m14button//
    public void azaltıcıt9m14(){
        t9m14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m14.setText(String.valueOf(sayit9m14--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit9m14(){
        t9m14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m14.setText(String.valueOf(sayit9m14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t9m14button//

    //t9m15button//
    public void azaltıcıt9m15(){
        t9m15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m15.setText(String.valueOf(sayit9m15--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit9m15(){
        t9m15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m15.setText(String.valueOf(sayit9m15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t9m15button//

    //t9m16button//
    public void azaltıcıt9m16(){
        t9m16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m16.setText(String.valueOf(sayit9m16--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit9m16(){
        t9m16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m16.setText(String.valueOf(sayit9m16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t9m16button//

    //t9m17button//
    public void azaltıcıt9m17(){
        t9m17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m17.setText(String.valueOf(sayit9m17--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit9m17(){
        t9m17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t9m17.setText(String.valueOf(sayit9m17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t9m17button//

    //------------------------------------------------------------------------------------

    //t6m1button//
    public void azaltıcıt6m1(){
        t6m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m1.setText(String.valueOf(sayit6m1--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit6m1(){
        t6m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m1.setText(String.valueOf(sayit6m1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t6m1button//

    //t6m2button//
    public void azaltıcıt6m2(){
        t6m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m2.setText(String.valueOf(sayit6m2--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit6m2(){
        t6m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m2.setText(String.valueOf(sayit6m2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t6m2button//


    //t6m3button//
    public void azaltıcıt6m3(){
        t6m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m3.setText(String.valueOf(sayit6m3--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit6m3(){
        t6m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m3.setText(String.valueOf(sayit6m3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t6m3button//

    //t6m4button//
    public void azaltıcıt6m4(){
        t6m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m4.setText(String.valueOf(sayit6m4--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit6m4(){
        t6m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m4.setText(String.valueOf(sayit6m4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t6m4button//

    //t6m5button//
    public void azaltıcıt6m5(){
        t6m5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m5.setText(String.valueOf(sayit6m5--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit6m5(){
        t6m5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m5.setText(String.valueOf(sayit6m5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t6m5button//

    //t6m6button//
    public void azaltıcıt6m6(){
        t6m6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m6.setText(String.valueOf(sayit6m6--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit6m6(){
        t6m6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m6.setText(String.valueOf(sayit6m6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t6m6button//

    //t6m7button//
    public void azaltıcıt6m7(){
        t6m7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m7.setText(String.valueOf(sayit6m7--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit6m7(){
        t6m7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m7.setText(String.valueOf(sayit6m7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t6m7button//

    //t6m8button//
    public void azaltıcıt6m8(){
        t6m8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m8.setText(String.valueOf(sayit6m8--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit6m8(){
        t6m8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m8.setText(String.valueOf(sayit6m8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t6m8button//

    //t6m9button//
    public void azaltıcıt6m9(){
        t6m9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m9.setText(String.valueOf(sayit6m9--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit6m9(){
        t6m9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m9.setText(String.valueOf(sayit6m9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t6m9button//

    //t6m10button//
    public void azaltıcıt6m10(){
        t6m10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m10.setText(String.valueOf(sayit6m10--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit6m10(){
        t6m10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m10.setText(String.valueOf(sayit6m10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t6m10button//

    //t6m11button//
    public void azaltıcıt6m11(){
        t6m11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m11.setText(String.valueOf(sayit6m11--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit6m11(){
        t6m11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m11.setText(String.valueOf(sayit6m11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t6m11button//

    //t6m12button//
    public void azaltıcıt6m12(){
        t6m12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m12.setText(String.valueOf(sayit6m12--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit6m12(){
        t6m12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m12.setText(String.valueOf(sayit6m12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t6m12button//

    //t6m13button//
    public void azaltıcıt6m13(){
        t6m13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m13.setText(String.valueOf(sayit6m13--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit6m13(){
        t6m13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m13.setText(String.valueOf(sayit6m13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t6m13button//

    //t6m14button//
    public void azaltıcıt6m14(){
        t6m14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m14.setText(String.valueOf(sayit6m14--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit6m14(){
        t6m14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m14.setText(String.valueOf(sayit6m14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t6m14button//

    //t6m15button//
    public void azaltıcıt6m15(){
        t6m15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m15.setText(String.valueOf(sayit6m15--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit6m15(){
        t6m15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m15.setText(String.valueOf(sayit6m15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t6m15button//

    //t6m16button//
    public void azaltıcıt6m16(){
        t6m16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m16.setText(String.valueOf(sayit6m16--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit6m16(){
        t6m16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m16.setText(String.valueOf(sayit6m16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t6m16button//

    //t6m17button//
    public void azaltıcıt6m17(){
        t6m17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m17.setText(String.valueOf(sayit6m17--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricit6m17(){
        t6m17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                t6m17.setText(String.valueOf(sayit6m17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //t6m17button//

    //------------------------------------------------------------------------------------

    //tWelle1button//
    public void azaltıcıtWelle1(){
        tWelle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle1.setText(String.valueOf(sayitWelle1--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitWelle1(){
        tWelle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle1.setText(String.valueOf(sayitWelle1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tWelle1button//

    //tWelle2button//
    public void azaltıcıtWelle2(){
        tWelle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle2.setText(String.valueOf(sayitWelle2--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitWelle2(){
        tWelle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle2.setText(String.valueOf(sayitWelle2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tWelle2button//

    //tWelle3button//
    public void azaltıcıtWelle3(){
        tWelle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle3.setText(String.valueOf(sayitWelle3--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitWelle3(){
        tWelle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle3.setText(String.valueOf(sayitWelle3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tWelle3button//

    //tWelle4button//
    public void azaltıcıtWelle4(){
        tWelle4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle4.setText(String.valueOf(sayitWelle4--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitWelle4(){
        tWelle4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle4.setText(String.valueOf(sayitWelle4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tWelle4button//

    //tWelle5button//
    public void azaltıcıtWelle5(){
        tWelle5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle5.setText(String.valueOf(sayitWelle5--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitWelle5(){
        tWelle5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle5.setText(String.valueOf(sayitWelle5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tWelle5button//

    //tWelle6button//
    public void azaltıcıtWelle6(){
        tWelle6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle6.setText(String.valueOf(sayitWelle6--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitWelle6(){
        tWelle6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle6.setText(String.valueOf(sayitWelle6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tWelle6button//

    //tWelle7button//
    public void azaltıcıtWelle7(){
        tWelle7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle7.setText(String.valueOf(sayitWelle7--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitWelle7(){
        tWelle7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle7.setText(String.valueOf(sayitWelle7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tWelle7button//

    //tWelle8button//
    public void azaltıcıtWelle8(){
        tWelle8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle8.setText(String.valueOf(sayitWelle8--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitWelle8(){
        tWelle8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle8.setText(String.valueOf(sayitWelle8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tWelle8button//

    //tWelle9button//
    public void azaltıcıtWelle9(){
        tWelle9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle9.setText(String.valueOf(sayitWelle9--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitWelle9(){
        tWelle9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle9.setText(String.valueOf(sayitWelle9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tWelle9button//

    //tWelle10button//
    public void azaltıcıtWelle10(){
        tWelle10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle10.setText(String.valueOf(sayitWelle10--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitWelle10(){
        tWelle10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle10.setText(String.valueOf(sayitWelle10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tWelle10button//

    //tWelle11button//
    public void azaltıcıtWelle11(){
        tWelle11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle11.setText(String.valueOf(sayitWelle11--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitWelle11(){
        tWelle11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle11.setText(String.valueOf(sayitWelle11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tWelle11button//

    //tWelle12button//
    public void azaltıcıtWelle12(){
        tWelle12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle12.setText(String.valueOf(sayitWelle12--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitWelle12(){
        tWelle12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle12.setText(String.valueOf(sayitWelle12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tWelle12button//

    //tWelle13button//
    public void azaltıcıtWelle13(){
        tWelle13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle13.setText(String.valueOf(sayitWelle13--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitWelle13(){
        tWelle13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle13.setText(String.valueOf(sayitWelle13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tWelle13button//

    //tWelle14button//
    public void azaltıcıtWelle14(){
        tWelle14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle14.setText(String.valueOf(sayitWelle14--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitWelle14(){
        tWelle14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle14.setText(String.valueOf(sayitWelle14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tWelle14button//

    //tWelle15button//
    public void azaltıcıtWelle15(){
        tWelle15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle15.setText(String.valueOf(sayitWelle15--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitWelle15(){
        tWelle15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle15.setText(String.valueOf(sayitWelle15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tWelle15button//

    //tWelle16button//
    public void azaltıcıtWelle16(){
        tWelle16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle16.setText(String.valueOf(sayitWelle16--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitWelle16(){
        tWelle16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle16.setText(String.valueOf(sayitWelle16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tWelle16button//

    //tWelle17button//
    public void azaltıcıtWelle17(){
        tWelle17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle17.setText(String.valueOf(sayitWelle17--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitWelle17(){
        tWelle17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tWelle17.setText(String.valueOf(sayitWelle17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tWelle17button//

    //------------------------------------------------------------------------------------

    //tartı1button//
    public void azaltıcıtartı1(){
        tartı1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı1.setText(String.valueOf(sayitartı1--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitartı1(){
        tartı1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı1.setText(String.valueOf(sayitartı1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tartı1button//

    //tartı2button//
    public void azaltıcıtartı2(){
        tartı2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı2.setText(String.valueOf(sayitartı2--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitartı2(){
        tartı2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı2.setText(String.valueOf(sayitartı2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tartı2button//

    //tartı3button//
    public void azaltıcıtartı3(){
        tartı3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı3.setText(String.valueOf(sayitartı3--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitartı3(){
        tartı3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı3.setText(String.valueOf(sayitartı3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tartı3button//

    //tartı4button//
    public void azaltıcıtartı4(){
        tartı4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı4.setText(String.valueOf(sayitartı4--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitartı4(){
        tartı4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı4.setText(String.valueOf(sayitartı4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tartı4button//

    //tartı5button//
    public void azaltıcıtartı5(){
        tartı5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı5.setText(String.valueOf(sayitartı5--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitartı5(){
        tartı5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı5.setText(String.valueOf(sayitartı5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tartı5button//

    //tartı6button//
    public void azaltıcıtartı6(){
        tartı6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı6.setText(String.valueOf(sayitartı6--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitartı6(){
        tartı6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı6.setText(String.valueOf(sayitartı6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tartı6button//

    //tartı7button//
    public void azaltıcıtartı7(){
        tartı7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı7.setText(String.valueOf(sayitartı7--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitartı7(){
        tartı7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı7.setText(String.valueOf(sayitartı7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tartı7button//

    //tartı8button//
    public void azaltıcıtartı8(){
        tartı8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı8.setText(String.valueOf(sayitartı8--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitartı8(){
        tartı8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı8.setText(String.valueOf(sayitartı8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tartı8button//

    //tartı9button//
    public void azaltıcıtartı9(){
        tartı9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı9.setText(String.valueOf(sayitartı9--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitartı9(){
        tartı9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı9.setText(String.valueOf(sayitartı9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tartı9button//

    //tartı10button//
    public void azaltıcıtartı10(){
        tartı10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı10.setText(String.valueOf(sayitartı10--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitartı10(){
        tartı10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı10.setText(String.valueOf(sayitartı10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tartı10button//

    //tartı11button//
    public void azaltıcıtartı11(){
        tartı11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı11.setText(String.valueOf(sayitartı11--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitartı11(){
        tartı11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı11.setText(String.valueOf(sayitartı11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tartı11button//

    //tartı12button//
    public void azaltıcıtartı12(){
        tartı12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı12.setText(String.valueOf(sayitartı12--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitartı12(){
        tartı12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı12.setText(String.valueOf(sayitartı12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tartı12button//

    //tartı13button//
    public void azaltıcıtartı13(){
        tartı13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı13.setText(String.valueOf(sayitartı13--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitartı13(){
        tartı13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı13.setText(String.valueOf(sayitartı13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tartı13button//

    //tartı14button//
    public void azaltıcıtartı14(){
        tartı14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı14.setText(String.valueOf(sayitartı14--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitartı14(){
        tartı14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı14.setText(String.valueOf(sayitartı14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tartı14button//

    //tartı15button//
    public void azaltıcıtartı15(){
        tartı15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı15.setText(String.valueOf(sayitartı15--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitartı15(){
        tartı15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı15.setText(String.valueOf(sayitartı15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tartı15button//

    //tartı16button//
    public void azaltıcıtartı16(){
        tartı16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı16.setText(String.valueOf(sayitartı16--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitartı16(){
        tartı16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı16.setText(String.valueOf(sayitartı16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tartı16button//

    //tartı17button//
    public void azaltıcıtartı17(){
        tartı17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı17.setText(String.valueOf(sayitartı17--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitartı17(){
        tartı17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tartı17.setText(String.valueOf(sayitartı17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tartı17button//

    //------------------------------------------------------------------------------------

    //teksi1button//
    public void azaltıcıteksi1(){
        teksi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi1.setText(String.valueOf(sayiteksi1--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiriciteksi1(){
        teksi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi1.setText(String.valueOf(sayiteksi1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //teksi1button//

    //teksi2button//
    public void azaltıcıteksi2(){
        teksi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi2.setText(String.valueOf(sayiteksi2--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiriciteksi2(){
        teksi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi2.setText(String.valueOf(sayiteksi2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //teksi2button//

    //teksi3button//
    public void azaltıcıteksi3(){
        teksi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi3.setText(String.valueOf(sayiteksi3--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiriciteksi3(){
        teksi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi3.setText(String.valueOf(sayiteksi3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //teksi3button//

    //teksi4button//
    public void azaltıcıteksi4(){
        teksi4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi4.setText(String.valueOf(sayiteksi4--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiriciteksi4(){
        teksi4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi4.setText(String.valueOf(sayiteksi4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //teksi4button//

    //teksi5button//
    public void azaltıcıteksi5(){
        teksi5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi5.setText(String.valueOf(sayiteksi5--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiriciteksi5(){
        teksi5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi5.setText(String.valueOf(sayiteksi5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //teksi5button//

    //teksi6button//
    public void azaltıcıteksi6(){
        teksi6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi6.setText(String.valueOf(sayiteksi6--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiriciteksi6(){
        teksi6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi6.setText(String.valueOf(sayiteksi6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //teksi6button//

    //teksi7button//
    public void azaltıcıteksi7(){
        teksi7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi7.setText(String.valueOf(sayiteksi7--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiriciteksi7(){
        teksi7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi7.setText(String.valueOf(sayiteksi7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //teksi7button//

    //teksi8button//
    public void azaltıcıteksi8(){
        teksi8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi8.setText(String.valueOf(sayiteksi8--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiriciteksi8(){
        teksi8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi8.setText(String.valueOf(sayiteksi8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //teksi8button//

    //teksi9button//
    public void azaltıcıteksi9(){
        teksi9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi9.setText(String.valueOf(sayiteksi9--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiriciteksi9(){
        teksi9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi9.setText(String.valueOf(sayiteksi9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //teksi9button//

    //teksi10button//
    public void azaltıcıteksi10(){
        teksi10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi10.setText(String.valueOf(sayiteksi10--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiriciteksi10(){
        teksi10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi10.setText(String.valueOf(sayiteksi10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //teksi10button//

    //teksi11button//
    public void azaltıcıteksi11(){
        teksi11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi11.setText(String.valueOf(sayiteksi11--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiriciteksi11(){
        teksi11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi11.setText(String.valueOf(sayiteksi11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //teksi11button//

    //teksi12button//
    public void azaltıcıteksi12(){
        teksi12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi12.setText(String.valueOf(sayiteksi12--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiriciteksi12(){
        teksi12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi12.setText(String.valueOf(sayiteksi12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //teksi12button//

    //teksi13button//
    public void azaltıcıteksi13(){
        teksi13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi13.setText(String.valueOf(sayiteksi13--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiriciteksi13(){
        teksi13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi13.setText(String.valueOf(sayiteksi13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //teksi13button//

    //teksi14button//
    public void azaltıcıteksi14(){
        teksi14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi14.setText(String.valueOf(sayiteksi14--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiriciteksi14(){
        teksi14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi14.setText(String.valueOf(sayiteksi14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //teksi14button//

    //teksi15button//
    public void azaltıcıteksi15(){
        teksi15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi15.setText(String.valueOf(sayiteksi15--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiriciteksi15(){
        teksi15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi15.setText(String.valueOf(sayiteksi15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //teksi15button//

    //teksi16button//
    public void azaltıcıteksi16(){
        teksi16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi16.setText(String.valueOf(sayiteksi16--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiriciteksi16(){
        teksi16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi16.setText(String.valueOf(sayiteksi16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //teksi16button//

    //teksi17button//
    public void azaltıcıteksi17(){
        teksi17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi17.setText(String.valueOf(sayiteksi17--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiriciteksi17(){
        teksi17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                teksi17.setText(String.valueOf(sayiteksi17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //teksi17button//


    //------------------------------------------------------------------------------------

    //tdm1button//
    public void azaltıcıtdm1(){
        tdm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm1.setText(String.valueOf(sayitdm1--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdm1(){
        tdm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm1.setText(String.valueOf(sayitdm1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdm1button//

    //tdm2button//
    public void azaltıcıtdm2(){
        tdm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm2.setText(String.valueOf(sayitdm2--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdm2(){
        tdm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm2.setText(String.valueOf(sayitdm2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdm2button//

    //tdm3button//
    public void azaltıcıtdm3(){
        tdm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm3.setText(String.valueOf(sayitdm3--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdm3(){
        tdm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm3.setText(String.valueOf(sayitdm3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdm3button//

    //tdm4button//
    public void azaltıcıtdm4(){
        tdm4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm4.setText(String.valueOf(sayitdm4--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdm4(){
        tdm4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm4.setText(String.valueOf(sayitdm4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdm4button//

    //tdm5button//
    public void azaltıcıtdm5(){
        tdm5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm5.setText(String.valueOf(sayitdm5--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdm5(){
        tdm5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm5.setText(String.valueOf(sayitdm5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdm5button//

    //tdm6button//
    public void azaltıcıtdm6(){
        tdm6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm6.setText(String.valueOf(sayitdm6--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdm6(){
        tdm6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm6.setText(String.valueOf(sayitdm6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdm6button//

    //tdm7button//
    public void azaltıcıtdm7(){
        tdm7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm7.setText(String.valueOf(sayitdm7--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdm7(){
        tdm7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm7.setText(String.valueOf(sayitdm7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdm7button//

    //tdm8button//
    public void azaltıcıtdm8(){
        tdm8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm8.setText(String.valueOf(sayitdm8--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdm8(){
        tdm8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm8.setText(String.valueOf(sayitdm8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdm8button//

    //tdm9button//
    public void azaltıcıtdm9(){
        tdm9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm9.setText(String.valueOf(sayitdm9--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdm9(){
        tdm9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm9.setText(String.valueOf(sayitdm9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdm9button//

    //tdm10button//
    public void azaltıcıtdm10(){
        tdm10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm10.setText(String.valueOf(sayitdm10--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdm10(){
        tdm10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm10.setText(String.valueOf(sayitdm10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdm10button//

    //tdm11button//
    public void azaltıcıtdm11(){
        tdm11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm11.setText(String.valueOf(sayitdm11--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdm11(){
        tdm11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm11.setText(String.valueOf(sayitdm11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdm11button//

    //tdm12button//
    public void azaltıcıtdm12(){
        tdm12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm12.setText(String.valueOf(sayitdm12--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdm12(){
        tdm12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm12.setText(String.valueOf(sayitdm12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdm12button//

    //tdm13button//
    public void azaltıcıtdm13(){
        tdm13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm13.setText(String.valueOf(sayitdm13--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdm13(){
        tdm13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm13.setText(String.valueOf(sayitdm13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdm13button//

    //tdm14button//
    public void azaltıcıtdm14(){
        tdm14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm14.setText(String.valueOf(sayitdm14--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdm14(){
        tdm14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm14.setText(String.valueOf(sayitdm14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdm14button//

    //tdm15button//
    public void azaltıcıtdm15(){
        tdm15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm15.setText(String.valueOf(sayitdm15--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdm15(){
        tdm15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm15.setText(String.valueOf(sayitdm15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdm15button//

    //tdm16button//
    public void azaltıcıtdm16(){
        tdm16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm16.setText(String.valueOf(sayitdm16--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdm16(){
        tdm16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm16.setText(String.valueOf(sayitdm16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdm16button//

    //tdm17button//
    public void azaltıcıtdm17(){
        tdm17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm17.setText(String.valueOf(sayitdm17--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdm17(){
        tdm17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdm17.setText(String.valueOf(sayitdm17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdm17button//

    //------------------------------------------------------------------------------------

    //tam1button//
    public void azaltıcıtam1(){
        tam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam1.setText(String.valueOf(sayitam1--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitam1(){
        tam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam1.setText(String.valueOf(sayitam1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tam1button//

    //tam2button//
    public void azaltıcıtam2(){
        tam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam2.setText(String.valueOf(sayitam2--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitam2(){
        tam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam2.setText(String.valueOf(sayitam2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tam2button//

    //tam3button//
    public void azaltıcıtam3(){
        tam3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam3.setText(String.valueOf(sayitam3--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitam3(){
        tam3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam3.setText(String.valueOf(sayitam3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tam3button//

    //tam4button//
    public void azaltıcıtam4(){
        tam4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam4.setText(String.valueOf(sayitam4--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitam4(){
        tam4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam4.setText(String.valueOf(sayitam4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tam4button//

    //tam5button//
    public void azaltıcıtam5(){
        tam5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam5.setText(String.valueOf(sayitam5--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitam5(){
        tam5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam5.setText(String.valueOf(sayitam5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tam5button//

    //tam6button//
    public void azaltıcıtam6(){
        tam6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam6.setText(String.valueOf(sayitam6--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitam6(){
        tam6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam6.setText(String.valueOf(sayitam6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tam6button//

    //tam7button//
    public void azaltıcıtam7(){
        tam7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam7.setText(String.valueOf(sayitam7--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitam7(){
        tam7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam7.setText(String.valueOf(sayitam7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tam7button//

    //tam8button//
    public void azaltıcıtam8(){
        tam8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam8.setText(String.valueOf(sayitam8--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitam8(){
        tam8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam8.setText(String.valueOf(sayitam8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tam8button//

    //tam9button//
    public void azaltıcıtam9(){
        tam9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam9.setText(String.valueOf(sayitam9--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitam9(){
        tam9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam9.setText(String.valueOf(sayitam9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tam9button//

    //tam10button//
    public void azaltıcıtam10(){
        tam10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam10.setText(String.valueOf(sayitam10--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitam10(){
        tam10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam10.setText(String.valueOf(sayitam10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tam10button//

    //tam11button//
    public void azaltıcıtam11(){
        tam11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam11.setText(String.valueOf(sayitam11--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitam11(){
        tam11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam11.setText(String.valueOf(sayitam11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tam11button//

    //tam12button//
    public void azaltıcıtam12(){
        tam12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam12.setText(String.valueOf(sayitam12--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitam12(){
        tam12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam12.setText(String.valueOf(sayitam12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tam12button//

    //tam13button//
    public void azaltıcıtam13(){
        tam13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam13.setText(String.valueOf(sayitam13--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitam13(){
        tam13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam13.setText(String.valueOf(sayitam13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tam13button//

    //tam14button//
    public void azaltıcıtam14(){
        tam14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam14.setText(String.valueOf(sayitam14--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitam14(){
        tam14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam14.setText(String.valueOf(sayitam14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tam14button//

    //tam15button//
    public void azaltıcıtam15(){
        tam15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam15.setText(String.valueOf(sayitam15--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitam15(){
        tam15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam15.setText(String.valueOf(sayitam15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tam15button//

    //tam16button//
    public void azaltıcıtam16(){
        tam16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam16.setText(String.valueOf(sayitam16--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitam16(){
        tam16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam16.setText(String.valueOf(sayitam16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tam16button//

    //tam17button//
    public void azaltıcıtam17(){
        tam17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam17.setText(String.valueOf(sayitam17--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitam17(){
        tam17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tam17.setText(String.valueOf(sayitam17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tam17button//

    //------------------------------------------------------------------------------------

    //tkonter1button//
    public void azaltıcıtkonter1(){
        tkonter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter1.setText(String.valueOf(sayitkonter1--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitkonter1(){
        tkonter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter1.setText(String.valueOf(sayitkonter1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tkonter1button//

    //tkonter2button//
    public void azaltıcıtkonter2(){
        tkonter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter2.setText(String.valueOf(sayitkonter2--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitkonter2(){
        tkonter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter2.setText(String.valueOf(sayitkonter2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tkonter2button//

    //tkonter3button//
    public void azaltıcıtkonter3(){
        tkonter3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter3.setText(String.valueOf(sayitkonter3--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitkonter3(){
        tkonter3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter3.setText(String.valueOf(sayitkonter3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tkonter3button//

    //tkonter4button//
    public void azaltıcıtkonter4(){
        tkonter4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter4.setText(String.valueOf(sayitkonter4--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitkonter4(){
        tkonter4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter4.setText(String.valueOf(sayitkonter4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tkonter4button//

    //tkonter5button//
    public void azaltıcıtkonter5(){
        tkonter5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter5.setText(String.valueOf(sayitkonter5--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitkonter5(){
        tkonter5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter5.setText(String.valueOf(sayitkonter5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tkonter5button//

    //tkonter6button//
    public void azaltıcıtkonter6(){
        tkonter6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter6.setText(String.valueOf(sayitkonter6--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitkonter6(){
        tkonter6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter6.setText(String.valueOf(sayitkonter6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tkonter6button//

    //tkonter7button//
    public void azaltıcıtkonter7(){
        tkonter7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter7.setText(String.valueOf(sayitkonter7--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitkonter7(){
        tkonter7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter7.setText(String.valueOf(sayitkonter7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tkonter7button//

    //tkonter8button//
    public void azaltıcıtkonter8(){
        tkonter8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter8.setText(String.valueOf(sayitkonter8--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitkonter8(){
        tkonter8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter8.setText(String.valueOf(sayitkonter8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tkonter8button//

    //tkonter9button//
    public void azaltıcıtkonter9(){
        tkonter9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter9.setText(String.valueOf(sayitkonter9--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitkonter9(){
        tkonter9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter9.setText(String.valueOf(sayitkonter9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tkonter9button//

    //tkonter10button//
    public void azaltıcıtkonter10(){
        tkonter10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter10.setText(String.valueOf(sayitkonter10--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitkonter10(){
        tkonter10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter10.setText(String.valueOf(sayitkonter10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tkonter10button//

    //tkonter11button//
    public void azaltıcıtkonter11(){
        tkonter11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter11.setText(String.valueOf(sayitkonter11--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitkonter11(){
        tkonter11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter11.setText(String.valueOf(sayitkonter11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tkonter11button//

    //tkonter12button//
    public void azaltıcıtkonter12(){
        tkonter12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter12.setText(String.valueOf(sayitkonter12--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitkonter12(){
        tkonter12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter12.setText(String.valueOf(sayitkonter12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tkonter12button//

    //tkonter13button//
    public void azaltıcıtkonter13(){
        tkonter13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter13.setText(String.valueOf(sayitkonter13--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitkonter13(){
        tkonter13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter13.setText(String.valueOf(sayitkonter13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tkonter13button//

    //tkonter14button//
    public void azaltıcıtkonter14(){
        tkonter14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter14.setText(String.valueOf(sayitkonter14--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitkonter14(){
        tkonter14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter14.setText(String.valueOf(sayitkonter14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tkonter14button//

    //tkonter15button//
    public void azaltıcıtkonter15(){
        tkonter15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter15.setText(String.valueOf(sayitkonter15--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitkonter15(){
        tkonter15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter15.setText(String.valueOf(sayitkonter15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tkonter15button//

    //tkonter16button//
    public void azaltıcıtkonter16(){
        tkonter16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter16.setText(String.valueOf(sayitkonter16--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitkonter16(){
        tkonter16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter16.setText(String.valueOf(sayitkonter16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tkonter16button//

    //tkonter17button//
    public void azaltıcıtkonter17(){
        tkonter17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter17.setText(String.valueOf(sayitkonter17--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitkonter17(){
        tkonter17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tkonter17.setText(String.valueOf(sayitkonter17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tkonter17button//

    //------------------------------------------------------------------------------------

    //tdp1button//
    public void azaltıcıtdp1(){
        tdp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp1.setText(String.valueOf(sayitdp1--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdp1(){
        tdp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp1.setText(String.valueOf(sayitdp1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdp1button//

    //tdp2button//
    public void azaltıcıtdp2(){
        tdp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp2.setText(String.valueOf(sayitdp2--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdp2(){
        tdp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp2.setText(String.valueOf(sayitdp2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdp2button//

    //tdp3button//
    public void azaltıcıtdp3(){
        tdp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp3.setText(String.valueOf(sayitdp3--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdp3(){
        tdp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp3.setText(String.valueOf(sayitdp3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdp3button//

    //tdp4button//
    public void azaltıcıtdp4(){
        tdp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp4.setText(String.valueOf(sayitdp4--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdp4(){
        tdp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp4.setText(String.valueOf(sayitdp4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdp4button//

    //tdp5button//
    public void azaltıcıtdp5(){
        tdp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp5.setText(String.valueOf(sayitdp5--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdp5(){
        tdp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp5.setText(String.valueOf(sayitdp5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdp5button//

    //tdp6button//
    public void azaltıcıtdp6(){
        tdp6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp6.setText(String.valueOf(sayitdp6--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdp6(){
        tdp6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp6.setText(String.valueOf(sayitdp6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdp6button//

    //tdp7button//
    public void azaltıcıtdp7(){
        tdp7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp7.setText(String.valueOf(sayitdp7--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdp7(){
        tdp7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp7.setText(String.valueOf(sayitdp7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdp7button//

    //tdp8button//
    public void azaltıcıtdp8(){
        tdp8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp8.setText(String.valueOf(sayitdp8--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdp8(){
        tdp8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp8.setText(String.valueOf(sayitdp8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdp8button//

    //tdp9button//
    public void azaltıcıtdp9(){
        tdp9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp9.setText(String.valueOf(sayitdp9--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdp9(){
        tdp9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp9.setText(String.valueOf(sayitdp9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdp9button//

    //tdp10button//
    public void azaltıcıtdp10(){
        tdp10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp10.setText(String.valueOf(sayitdp10--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdp10(){
        tdp10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp10.setText(String.valueOf(sayitdp10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdp10button//

    //tdp11button//
    public void azaltıcıtdp11(){
        tdp11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp11.setText(String.valueOf(sayitdp11--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdp11(){
        tdp11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp11.setText(String.valueOf(sayitdp11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdp11button//

    //tdp12button//
    public void azaltıcıtdp12(){
        tdp12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp12.setText(String.valueOf(sayitdp12--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdp12(){
        tdp12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp12.setText(String.valueOf(sayitdp12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdp12button//

    //tdp13button//
    public void azaltıcıtdp13(){
        tdp13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp13.setText(String.valueOf(sayitdp13--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdp13(){
        tdp13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp13.setText(String.valueOf(sayitdp13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdp13button//

    //tdp14button//
    public void azaltıcıtdp14(){
        tdp14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp14.setText(String.valueOf(sayitdp14--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdp14(){
        tdp14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp14.setText(String.valueOf(sayitdp14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdp14button//

    //tdp15button//
    public void azaltıcıtdp15(){
        tdp15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp15.setText(String.valueOf(sayitdp15--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdp15(){
        tdp15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp15.setText(String.valueOf(sayitdm15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdp15button//

    //tdp16button//
    public void azaltıcıtdp16(){
        tdp16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp16.setText(String.valueOf(sayitdp16--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdp16(){
        tdp16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp16.setText(String.valueOf(sayitdp16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdp16button//

    //tdp17button//
    public void azaltıcıtdp17(){
        tdp17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp17.setText(String.valueOf(sayitdp17--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitdp17(){
        tdp17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tdp17.setText(String.valueOf(sayitdp17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tdp17button//

    //------------------------------------------------------------------------------------

    //tff1button//
    public void azaltıcıtff1(){
        tff1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff1.setText(String.valueOf(sayitff1--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitff1(){
        tff1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff1.setText(String.valueOf(sayitff1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tff1button//

    //tff2button//
    public void azaltıcıtff2(){
        tff2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff2.setText(String.valueOf(sayitff2--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitff2(){
        tff2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff2.setText(String.valueOf(sayitff2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tff2button//


    //tff3button//
    public void azaltıcıtff3(){
        tff3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff3.setText(String.valueOf(sayitff3--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitff3(){
        tff3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff3.setText(String.valueOf(sayitff3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tff3button//

    //tff4button//
    public void azaltıcıtff4(){
        tff4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff4.setText(String.valueOf(sayitff4--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitff4(){
        tff4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff4.setText(String.valueOf(sayitff4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tff4button//

    //tff5button//
    public void azaltıcıtff5(){
        tff5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff5.setText(String.valueOf(sayitff5--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitff5(){
        tff5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff5.setText(String.valueOf(sayitff5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tff5button//

    //tff6button//
    public void azaltıcıtff6(){
        tff6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff6.setText(String.valueOf(sayitff6--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitff6(){
        tff6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff6.setText(String.valueOf(sayitff6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tff6button//

    //tff7button//
    public void azaltıcıtff7(){
        tff7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff7.setText(String.valueOf(sayitff7--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitff7(){
        tff7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff7.setText(String.valueOf(sayitff7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tff7button//

    //tff8button//
    public void azaltıcıtff8(){
        tff8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff8.setText(String.valueOf(sayitff8--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitff8(){
        tff8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff8.setText(String.valueOf(sayitff8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tff8button//

    //tff9button//
    public void azaltıcıtff9(){
        tff9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff9.setText(String.valueOf(sayitff9--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitff9(){
        tff9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff9.setText(String.valueOf(sayitff9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tff9button//

    //tff10button//
    public void azaltıcıtff10(){
        tff10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff10.setText(String.valueOf(sayitff10--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitff10(){
        tff10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff10.setText(String.valueOf(sayitff10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tff10button//

    //tff11button//
    public void azaltıcıtff11(){
        tff11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff11.setText(String.valueOf(sayitff11--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitff11(){
        tff11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff11.setText(String.valueOf(sayitff11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tff11button//

    //tff12button//
    public void azaltıcıtff12(){
        tff12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff12.setText(String.valueOf(sayitff12--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitff12(){
        tff12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff12.setText(String.valueOf(sayitff12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tff12button//

    //tff13button//
    public void azaltıcıtff13(){
        tff13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff13.setText(String.valueOf(sayitff13--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitff13(){
        tff13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff13.setText(String.valueOf(sayitff13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tff13button//

    //tff14button//
    public void azaltıcıtff14(){
        tff14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff14.setText(String.valueOf(sayitff14--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitff14(){
        tff14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff14.setText(String.valueOf(sayitff14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tff14button//

    //tff15button//
    public void azaltıcıtff15(){
        tff15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff15.setText(String.valueOf(sayitff15--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitff15(){
        tff15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff15.setText(String.valueOf(sayitff15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tff15button//

    //tff16button//
    public void azaltıcıtff16(){
        tff16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff16.setText(String.valueOf(sayitff16--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitff16(){
        tff16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff16.setText(String.valueOf(sayitff16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tff16button//

    //tff17button//
    public void azaltıcıtff17(){
        tff17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff17.setText(String.valueOf(sayitff17--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitff17(){
        tff17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tff17.setText(String.valueOf(sayitff17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tff17button//

    //------------------------------------------------------------------------------------

    //tfp1button//
    public void azaltıcıtfp1(){
        tfp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp1.setText(String.valueOf(sayitfp1--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfp1(){
        tfp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp1.setText(String.valueOf(sayitfp1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfp1button//

    //tfp2button//
    public void azaltıcıtfp2(){
        tfp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp2.setText(String.valueOf(sayitfp2--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfp2(){
        tfp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp2.setText(String.valueOf(sayitfp2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfp2button//


    //tfp3button//
    public void azaltıcıtfp3(){
        tfp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp3.setText(String.valueOf(sayitfp3--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfp3(){
        tfp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp3.setText(String.valueOf(sayitfp3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfp3button//

    //tfp4button//
    public void azaltıcıtfp4(){
        tfp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp4.setText(String.valueOf(sayitfp4--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfp4(){
        tfp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp4.setText(String.valueOf(sayitfp4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfp4button//

    //tfp5button//
    public void azaltıcıtfp5(){
        tfp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp5.setText(String.valueOf(sayitfp5--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfp5(){
        tfp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp5.setText(String.valueOf(sayitfp5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfp5button//

    //tfp6button//
    public void azaltıcıtfp6(){
        tfp6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp6.setText(String.valueOf(sayitfp6--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfp6(){
        tfp6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp6.setText(String.valueOf(sayitfp6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfp6button//

    //tfp7button//
    public void azaltıcıtfp7(){
        tfp7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp7.setText(String.valueOf(sayitfp7--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfp7(){
        tfp7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp7.setText(String.valueOf(sayitfp7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfp7button//

    //tfp8button//
    public void azaltıcıtfp8(){
        tfp8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp8.setText(String.valueOf(sayitfp8--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfp8(){
        tfp8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp8.setText(String.valueOf(sayitfp8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfp8button//

    //tfp9button//
    public void azaltıcıtfp9(){
        tfp9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp9.setText(String.valueOf(sayitfp9--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfp9(){
        tfp9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp9.setText(String.valueOf(sayitfp9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfp9button//

    //tfp10button//
    public void azaltıcıtfp10(){
        tfp10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp10.setText(String.valueOf(sayitfp10--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfp10(){
        tfp10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp10.setText(String.valueOf(sayitfp10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfp10button//

    //tfp11button//
    public void azaltıcıtfp11(){
        tfp11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp11.setText(String.valueOf(sayitfp11--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfp11(){
        tfp11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp11.setText(String.valueOf(sayitfp11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfp11button//

    //tfp12button//
    public void azaltıcıtfp12(){
        tfp12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp12.setText(String.valueOf(sayitfp12--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfp12(){
        tfp12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp12.setText(String.valueOf(sayitfp12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfp12button//

    //tfp13button//
    public void azaltıcıtfp13(){
        tfp13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp13.setText(String.valueOf(sayitfp13--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfp13(){
        tfp13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp13.setText(String.valueOf(sayitfp13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfp13button//

    //tfp14button//
    public void azaltıcıtfp14(){
        tfp14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp14.setText(String.valueOf(sayitfp14--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfp14(){
        tfp14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp14.setText(String.valueOf(sayitfp14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfp14button//

    //tfp15button//
    public void azaltıcıtfp15(){
        tfp15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp15.setText(String.valueOf(sayitfp15--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfp15(){
        tfp15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp15.setText(String.valueOf(sayitfp15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfp15button//

    //tfp16button//
    public void azaltıcıtfp16(){
        tfp16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp16.setText(String.valueOf(sayitfp16--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfp16(){
        tfp16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp16.setText(String.valueOf(sayitfp16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfp16button//

    //tfp17button//
    public void azaltıcıtfp17(){
        tfp17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp17.setText(String.valueOf(sayitfp17--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfp17(){
        tfp17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfp17.setText(String.valueOf(sayitfp17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfp17button//

    //------------------------------------------------------------------------------------

    //tsr1button//
    public void azaltıcıtsr1(){
        tsr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr1.setText(String.valueOf(sayitsr1--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsr1(){
        tsr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr1.setText(String.valueOf(sayitsr1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsr1button//

    //tsr2button//
    public void azaltıcıtsr2(){
        tsr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr2.setText(String.valueOf(sayitsr2--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsr2(){
        tsr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr2.setText(String.valueOf(sayitsr2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsr2button//


    //tsr3button//
    public void azaltıcıtsr3(){
        tsr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr3.setText(String.valueOf(sayitsr3--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsr3(){
        tsr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr3.setText(String.valueOf(sayitsr3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsr3button//

    //tsr4button//
    public void azaltıcıtsr4(){
        tsr4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr4.setText(String.valueOf(sayitsr4--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsr4(){
        tsr4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr4.setText(String.valueOf(sayitsr4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsr4button//

    //tsr5button//
    public void azaltıcıtsr5(){
        tsr5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr5.setText(String.valueOf(sayitsr5--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsr5(){
        tsr5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr5.setText(String.valueOf(sayitsr5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsr5button//

    //tsr6button//
    public void azaltıcıtsr6(){
        tsr6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr6.setText(String.valueOf(sayitsr6--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsr6(){
        tsr6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr6.setText(String.valueOf(sayitsr6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsr6button//

    //tsr7button//
    public void azaltıcıtsr7(){
        tsr7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr7.setText(String.valueOf(sayitsr7--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsr7(){
        tsr7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr7.setText(String.valueOf(sayitsr7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsr7button//

    //tsr8button//
    public void azaltıcıtsr8(){
        tsr8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr8.setText(String.valueOf(sayitsr8--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsr8(){
        tsr8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr8.setText(String.valueOf(sayitsr8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsr8button//

    //tsr9button//
    public void azaltıcıtsr9(){
        tsr9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr9.setText(String.valueOf(sayitsr9--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsr9(){
        tsr9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr9.setText(String.valueOf(sayitsr9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsr9button//

    //tsr10button//
    public void azaltıcıtsr10(){
        tsr10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr10.setText(String.valueOf(sayitsr10--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsr10(){
        tsr10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr10.setText(String.valueOf(sayitsr10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsr10button//

    //tsr11button//
    public void azaltıcıtsr11(){
        tsr11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr11.setText(String.valueOf(sayitsr11--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsr11(){
        tsr11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr11.setText(String.valueOf(sayitsr11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsr11button//

    //tsr12button//
    public void azaltıcıtsr12(){
        tsr12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr12.setText(String.valueOf(sayitsr12--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsr12(){
        tsr12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr12.setText(String.valueOf(sayitsr12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsr12button//

    //tsr13button//
    public void azaltıcıtsr13(){
        tsr13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr13.setText(String.valueOf(sayitsr13--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsr13(){
        tsr13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr13.setText(String.valueOf(sayitsr13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsr13button//

    //tsr14button//
    public void azaltıcıtsr14(){
        tsr14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr14.setText(String.valueOf(sayitsr14--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsr14(){
        tsr14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr14.setText(String.valueOf(sayitsr14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsr14button//

    //tsr15button//
    public void azaltıcıtsr15(){
        tsr15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr15.setText(String.valueOf(sayitsr15--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsr15(){
        tsr15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr15.setText(String.valueOf(sayitsr15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsr15button//

    //tsr16button//
    public void azaltıcıtsr16(){
        tsr16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr16.setText(String.valueOf(sayitsr16--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsr16(){
        tsr16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr16.setText(String.valueOf(sayitsr16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsr16button//

    //tsr17button//
    public void azaltıcıtsr17(){
        tsr17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr17.setText(String.valueOf(sayitsr17--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsr17(){
        tsr17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsr17.setText(String.valueOf(sayitsr17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsr17button//

    //------------------------------------------------------------------------------------

    //tbeo1button//
    public void azaltıcıtbeo1(){
        tbeo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo1.setText(String.valueOf(sayitbeo1--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbeo1(){
        tbeo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo1.setText(String.valueOf(sayitbeo1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbeo1button//

    //tbeo2button//
    public void azaltıcıtbeo2(){
        tbeo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo2.setText(String.valueOf(sayitbeo2--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbeo2(){
        tbeo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo2.setText(String.valueOf(sayitbeo2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbeo2button//


    //tbeo3button//
    public void azaltıcıtbeo3(){
        tbeo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo3.setText(String.valueOf(sayitbeo3--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbeo3(){
        tbeo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo3.setText(String.valueOf(sayitbeo3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbeo3button//

    //tbeo4button//
    public void azaltıcıtbeo4(){
        tbeo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo4.setText(String.valueOf(sayitbeo4--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbeo4(){
        tbeo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo4.setText(String.valueOf(sayitbeo4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbeo4button//

    //tbeo5button//
    public void azaltıcıtbeo5(){
        tbeo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo5.setText(String.valueOf(sayitbeo5--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbeo5(){
        tbeo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo5.setText(String.valueOf(sayitbeo5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbeo5button//

    //tbeo6button//
    public void azaltıcıtbeo6(){
        tbeo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo6.setText(String.valueOf(sayitbeo6--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbeo6(){
        tbeo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo6.setText(String.valueOf(sayitbeo6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbeo6button//

    //tbeo7button//
    public void azaltıcıtbeo7(){
        tbeo7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo7.setText(String.valueOf(sayitbeo7--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbeo7(){
        tbeo7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo7.setText(String.valueOf(sayitbeo7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbeo7button//

    //tbeo8button//
    public void azaltıcıtbeo8(){
        tbeo8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo8.setText(String.valueOf(sayitbeo8--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbeo8(){
        tbeo8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo8.setText(String.valueOf(sayitbeo8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbeo8button//

    //tbeo9button//
    public void azaltıcıtbeo9(){
        tbeo9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo9.setText(String.valueOf(sayitbeo9--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbeo9(){
        tbeo9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo9.setText(String.valueOf(sayitbeo9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbeo9button//

    //tbeo10button//
    public void azaltıcıtbeo10(){
        tbeo10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo10.setText(String.valueOf(sayitbeo10--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbeo10(){
        tbeo10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo10.setText(String.valueOf(sayitbeo10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbeo10button//

    //tbeo11button//
    public void azaltıcıtbeo11(){
        tbeo11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo11.setText(String.valueOf(sayitbeo11--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbeo11(){
        tbeo11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo11.setText(String.valueOf(sayitbeo11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbeo11button//

    //tbeo12button//
    public void azaltıcıtbeo12(){
        tbeo12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo12.setText(String.valueOf(sayitbeo12--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbeo12(){
        tbeo12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo12.setText(String.valueOf(sayitbeo12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbeo12button//

    //tbeo13button//
    public void azaltıcıtbeo13(){
        tbeo13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo13.setText(String.valueOf(sayitbeo13--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbeo13(){
        tbeo13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo13.setText(String.valueOf(sayitbeo13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbeo13button//

    //tbeo14button//
    public void azaltıcıtbeo14(){
        tbeo14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo14.setText(String.valueOf(sayitbeo14--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbeo14(){
        tbeo14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo14.setText(String.valueOf(sayitbeo14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbeo14button//

    //tbeo15button//
    public void azaltıcıtbeo15(){
        tbeo15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo15.setText(String.valueOf(sayitbeo15--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbeo15(){
        tbeo15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo15.setText(String.valueOf(sayitbeo15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbeo15button//

    //tbeo16button//
    public void azaltıcıtbeo16(){
        tbeo16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo16.setText(String.valueOf(sayitbeo16--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbeo16(){
        tbeo16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo16.setText(String.valueOf(sayitbeo16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbeo16button//

    //tbeo17button//
    public void azaltıcıtbeo17(){
        tbeo17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo17.setText(String.valueOf(sayitbeo17--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbeo17(){
        tbeo17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbeo17.setText(String.valueOf(sayitbeo17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbeo17button//

    //------------------------------------------------------------------------------------

    //tsf1button//
    public void azaltıcıtsf1(){
        tsf1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf1.setText(String.valueOf(sayitsf1--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsf1(){
        tsf1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf1.setText(String.valueOf(sayitsf1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsf1button//

    //tsf2button//
    public void azaltıcıtsf2(){
        tsf2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf2.setText(String.valueOf(sayitsf2--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsf2(){
        tsf2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf2.setText(String.valueOf(sayitsf2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsf2button//


    //tsf3button//
    public void azaltıcıtsf3(){
        tsf3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf3.setText(String.valueOf(sayitsf3--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsf3(){
        tsf3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf3.setText(String.valueOf(sayitsf3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsf3button//

    //tsf4button//
    public void azaltıcıtsf4(){
        tsf4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf4.setText(String.valueOf(sayitsf4--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsf4(){
        tsf4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf4.setText(String.valueOf(sayitsf4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsf4button//

    //tsf5button//
    public void azaltıcıtsf5(){
        tsf5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf5.setText(String.valueOf(sayitsf5--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsf5(){
        tsf5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf5.setText(String.valueOf(sayitsf5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsf5button//

    //tsf6button//
    public void azaltıcıtsf6(){
        tsf6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf6.setText(String.valueOf(sayitsf6--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsf6(){
        tsf6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf6.setText(String.valueOf(sayitsf6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsf6button//

    //tsf7button//
    public void azaltıcıtsf7(){
        tsf7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf7.setText(String.valueOf(sayitsf7--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsf7(){
        tsf7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf7.setText(String.valueOf(sayitsf7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsf7button//

    //tsf8button//
    public void azaltıcıtsf8(){
        tsf8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf8.setText(String.valueOf(sayitsf8--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsf8(){
        tsf8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf8.setText(String.valueOf(sayitsf8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsf8button//

    //tsf9button//
    public void azaltıcıtsf9(){
        tsf9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf9.setText(String.valueOf(sayitsf9--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsf9(){
        tsf9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf9.setText(String.valueOf(sayitsf9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsf9button//

    //tsf10button//
    public void azaltıcıtsf10(){
        tsf10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf10.setText(String.valueOf(sayitsf10--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsf10(){
        tsf10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf10.setText(String.valueOf(sayitsf10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsf10button//

    //tsf11button//
    public void azaltıcıtsf11(){
        tsf11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf11.setText(String.valueOf(sayitsf11--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsf11(){
        tsf11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf11.setText(String.valueOf(sayitsf11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsf11button//

    //tsf12button//
    public void azaltıcıtsf12(){
        tsf12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf12.setText(String.valueOf(sayitsf12--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsf12(){
        tsf12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf12.setText(String.valueOf(sayitsf12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsf12button//

    //tsf13button//
    public void azaltıcıtsf13(){
        tsf13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf13.setText(String.valueOf(sayitsf13--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsf13(){
        tsf13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf13.setText(String.valueOf(sayitsf13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsf13button//

    //tsf14button//
    public void azaltıcıtsf14(){
        tsf14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf14.setText(String.valueOf(sayitsf14--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsf14(){
        tsf14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf14.setText(String.valueOf(sayitsf14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsf14button//

    //tsf15button//
    public void azaltıcıtsf15(){
        tsf15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf15.setText(String.valueOf(sayitsf15--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsf15(){
        tsf15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf15.setText(String.valueOf(sayitsf15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsf15button//

    //tsf16button//
    public void azaltıcıtsf16(){
        tsf16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf16.setText(String.valueOf(sayitsf16--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsf16(){
        tsf16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf16.setText(String.valueOf(sayitsf16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsf16button//

    //tsf17button//
    public void azaltıcıtsf17(){
        tsf17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf17.setText(String.valueOf(sayitsf17--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitsf17(){
        tsf17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tsf17.setText(String.valueOf(sayitsf17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tsf17button//

    //------------------------------------------------------------------------------------

    //tfoul1button//
    public void azaltıcıtfoul1(){
        tfoul1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul1.setText(String.valueOf(sayitfoul1--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfoul1(){
        tfoul1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul1.setText(String.valueOf(sayitfoul1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfoul1button//

    //tfoul2button//
    public void azaltıcıtfoul2(){
        tfoul2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul2.setText(String.valueOf(sayitfoul2--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfoul2(){
        tfoul2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul2.setText(String.valueOf(sayitfoul2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfoul2button//


    //tfoul3button//
    public void azaltıcıtfoul3(){
        tfoul3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul3.setText(String.valueOf(sayitfoul3--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfoul3(){
        tfoul3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul3.setText(String.valueOf(sayitfoul3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfoul3button//

    //tfoul4button//
    public void azaltıcıtfoul4(){
        tfoul4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul4.setText(String.valueOf(sayitfoul4--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfoul4(){
        tfoul4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul4.setText(String.valueOf(sayitfoul4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfoul4button//

    //tfoul5button//
    public void azaltıcıtfoul5(){
        tfoul5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul5.setText(String.valueOf(sayitfoul5--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfoul5(){
        tfoul5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul5.setText(String.valueOf(sayitfoul5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfoul5button//

    //tfoul6button//
    public void azaltıcıtfoul6(){
        tfoul6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul6.setText(String.valueOf(sayitfoul6--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfoul6(){
        tfoul6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul6.setText(String.valueOf(sayitfoul6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfoul6button//

    //tfoul7button//
    public void azaltıcıtfoul7(){
        tfoul7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul7.setText(String.valueOf(sayitfoul7--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfoul7(){
        tfoul7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul7.setText(String.valueOf(sayitfoul7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfoul7button//

    //tfoul8button//
    public void azaltıcıtfoul8(){
        tfoul8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul8.setText(String.valueOf(sayitfoul8--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfoul8(){
        tfoul8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul8.setText(String.valueOf(sayitfoul8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfoul8button//

    //tfoul9button//
    public void azaltıcıtfoul9(){
        tfoul9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul9.setText(String.valueOf(sayitfoul9--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfoul9(){
        tfoul9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul9.setText(String.valueOf(sayitfoul9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfoul9button//

    //tfoul10button//
    public void azaltıcıtfoul10(){
        tfoul10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul10.setText(String.valueOf(sayitfoul10--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfoul10(){
        tfoul10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul10.setText(String.valueOf(sayitfoul10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfoul10button//

    //tfoul11button//
    public void azaltıcıtfoul11(){
        tfoul11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul11.setText(String.valueOf(sayitfoul11--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfoul11(){
        tfoul11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul11.setText(String.valueOf(sayitfoul11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfoul11button//

    //tfoul12button//
    public void azaltıcıtfoul12(){
        tfoul12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul12.setText(String.valueOf(sayitfoul12--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfoul12(){
        tfoul12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul12.setText(String.valueOf(sayitfoul12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfoul12button//

    //tfoul13button//
    public void azaltıcıtfoul13(){
        tfoul13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul13.setText(String.valueOf(sayitfoul13--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfoul13(){
        tfoul13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul13.setText(String.valueOf(sayitfoul13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfoul13button//

    //tfoul14button//
    public void azaltıcıtfoul14(){
        tfoul14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul14.setText(String.valueOf(sayitfoul14--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfoul14(){
        tfoul14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul14.setText(String.valueOf(sayitfoul14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfoul14button//

    //tfoul15button//
    public void azaltıcıtfoul15(){
        tfoul15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul15.setText(String.valueOf(sayitfoul15--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfoul15(){
        tfoul15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul15.setText(String.valueOf(sayitfoul15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfoul15button//

    //tfoul16button//
    public void azaltıcıtfoul16(){
        tfoul16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul16.setText(String.valueOf(sayitfoul16--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfoul16(){
        tfoul16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul16.setText(String.valueOf(sayitfoul16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfoul16button//

    //tfoul17button//
    public void azaltıcıtfoul17(){
        tfoul17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul17.setText(String.valueOf(sayitfoul17--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitfoul17(){
        tfoul17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tfoul17.setText(String.valueOf(sayitfoul17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tfoul17button//

    //------------------------------------------------------------------------------------

    //trausy1button//
    public void azaltıcıtrausy1(){
        trausy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy1.setText(String.valueOf(sayitrausy1--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausy1(){
        trausy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy1.setText(String.valueOf(sayitrausy1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausy1button//

    //trausy2button//
    public void azaltıcıtrausy2(){
        trausy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy2.setText(String.valueOf(sayitrausy2--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausy2(){
        trausy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy2.setText(String.valueOf(sayitrausy2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausy2button//

    //trausy3button//
    public void azaltıcıtrausy3(){
        trausy3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy3.setText(String.valueOf(sayitrausy3--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausy3(){
        trausy3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy3.setText(String.valueOf(sayitrausy3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausy3button//

    //trausy4button//
    public void azaltıcıtrausy4(){
        trausy4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy4.setText(String.valueOf(sayitrausy4--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausy4(){
        trausy4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy4.setText(String.valueOf(sayitrausy4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausy4button//

    //trausy5button//
    public void azaltıcıtrausy5(){
        trausy5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy5.setText(String.valueOf(sayitrausy5--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausy5(){
        trausy5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy5.setText(String.valueOf(sayitrausy5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausy5button//

    //trausy6button//
    public void azaltıcıtrausy6(){
        trausy6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy6.setText(String.valueOf(sayitrausy6--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausy6(){
        trausy6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy6.setText(String.valueOf(sayitrausy6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausy6button//

    //trausy7button//
    public void azaltıcıtrausy7(){
        trausy7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy7.setText(String.valueOf(sayitrausy7--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausy7(){
        trausy7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy7.setText(String.valueOf(sayitrausy7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausy7button//

    //trausy8button//
    public void azaltıcıtrausy8(){
        trausy8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy8.setText(String.valueOf(sayitrausy8--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausy8(){
        trausy8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy8.setText(String.valueOf(sayitrausy8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausy8button//

    //trausy9button//
    public void azaltıcıtrausy9(){
        trausy9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy9.setText(String.valueOf(sayitrausy9--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausy9(){
        trausy9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy9.setText(String.valueOf(sayitrausy9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausy9button//

    //trausy10button//
    public void azaltıcıtrausy10(){
        trausy10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy10.setText(String.valueOf(sayitrausy10--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausy10(){
        trausy10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy10.setText(String.valueOf(sayitrausy10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausy10button//

    //trausy11button//
    public void azaltıcıtrausy11(){
        trausy11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy11.setText(String.valueOf(sayitrausy11--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausy11(){
        trausy11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy11.setText(String.valueOf(sayitrausy11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausy11button//

    //trausy12button//
    public void azaltıcıtrausy12(){
        trausy12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy12.setText(String.valueOf(sayitrausy12--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausy12(){
        trausy12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy12.setText(String.valueOf(sayitrausy12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausy12button//

    //trausy13button//
    public void azaltıcıtrausy13(){
        trausy13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy13.setText(String.valueOf(sayitrausy13--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausy13(){
        trausy13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy13.setText(String.valueOf(sayitrausy13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausy13button//

    //trausy14button//
    public void azaltıcıtrausy14(){
        trausy14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy14.setText(String.valueOf(sayitrausy14--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausy14(){
        trausy14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy14.setText(String.valueOf(sayitrausy14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausy14button//

    //trausy15button//
    public void azaltıcıtrausy15(){
        trausy15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy15.setText(String.valueOf(sayitrausy15--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausy15(){
        trausy15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy15.setText(String.valueOf(sayitrausy15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausy15button//

    //trausy16button//
    public void azaltıcıtrausy16(){
        trausy16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy16.setText(String.valueOf(sayitrausy16--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausy16(){
        trausy16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy16.setText(String.valueOf(sayitrausy16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausy16button//

    //trausy17button//
    public void azaltıcıtrausy17(){
        trausy17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy17.setText(String.valueOf(sayitrausy17--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausy17(){
        trausy17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausy17.setText(String.valueOf(sayitrausy17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausy17button//

    //------------------------------------------------------------------------------------

    //trausi1button//
    public void azaltıcıtrausi1(){
        trausi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi1.setText(String.valueOf(sayitrausi1--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausi1(){
        trausi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi1.setText(String.valueOf(sayitrausi1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausi1button//

    //trausi2button//
    public void azaltıcıtrausi2(){
        trausi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi2.setText(String.valueOf(sayitrausi2--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausi2(){
        trausi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi2.setText(String.valueOf(sayitrausi2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausi2button//

    //trausi3button//
    public void azaltıcıtrausi3(){
        trausi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi3.setText(String.valueOf(sayitrausi3--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausi3(){
        trausi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi3.setText(String.valueOf(sayitrausi3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausi3button//

    //trausi4button//
    public void azaltıcıtrausi4(){
        trausi4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi4.setText(String.valueOf(sayitrausi4--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausi4(){
        trausi4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi4.setText(String.valueOf(sayitrausi4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausi4button//

    //trausi5button//
    public void azaltıcıtrausi5(){
        trausi5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi5.setText(String.valueOf(sayitrausi5--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausi5(){
        trausi5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi5.setText(String.valueOf(sayitrausi5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausi5button//

    //trausi6button//
    public void azaltıcıtrausi6(){
        trausi6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi6.setText(String.valueOf(sayitrausi6--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausi6(){
        trausi6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi6.setText(String.valueOf(sayitrausi6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausi6button//

    //trausi7button//
    public void azaltıcıtrausi7(){
        trausi7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi7.setText(String.valueOf(sayitrausi7--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausi7(){
        trausi7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi7.setText(String.valueOf(sayitrausi7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausi7button//

    //trausi8button//
    public void azaltıcıtrausi8(){
        trausi8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi8.setText(String.valueOf(sayitrausi8--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausi8(){
        trausi8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi8.setText(String.valueOf(sayitrausi8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausi8button//

    //trausi9button//
    public void azaltıcıtrausi9(){
        trausi9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi9.setText(String.valueOf(sayitrausi9--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausi9(){
        trausi9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi9.setText(String.valueOf(sayitrausi9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausi9button//

    //trausi10button//
    public void azaltıcıtrausi10(){
        trausi10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi10.setText(String.valueOf(sayitrausi10--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausi10(){
        trausi10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi10.setText(String.valueOf(sayitrausi10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausi10button//

    //trausi11button//
    public void azaltıcıtrausi11(){
        trausi11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi11.setText(String.valueOf(sayitrausi11--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausi11(){
        trausi11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi11.setText(String.valueOf(sayitrausi11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausi11button//

    //trausi12button//
    public void azaltıcıtrausi12(){
        trausi12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi12.setText(String.valueOf(sayitrausi12--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausi12(){
        trausi12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi12.setText(String.valueOf(sayitrausi12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausi12button//

    //trausi13button//
    public void azaltıcıtrausi13(){
        trausi13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi13.setText(String.valueOf(sayitrausi13--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausi13(){
        trausi13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi13.setText(String.valueOf(sayitrausi13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausi13button//

    //trausi14button//
    public void azaltıcıtrausi14(){
        trausi14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi14.setText(String.valueOf(sayitrausi14--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausi14(){
        trausi14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi14.setText(String.valueOf(sayitrausi14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausi14button//

    //trausi15button//
    public void azaltıcıtrausi15(){
        trausi15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi15.setText(String.valueOf(sayitrausi15--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausi15(){
        trausi15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi15.setText(String.valueOf(sayitrausi15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausi15button//

    //trausi16button//
    public void azaltıcıtrausi16(){
        trausi16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi16.setText(String.valueOf(sayitrausi16--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausi16(){
        trausi16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi16.setText(String.valueOf(sayitrausi16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausi16button//

    //trausi17button//
    public void azaltıcıtrausi17(){
        trausi17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi17.setText(String.valueOf(sayitrausi17--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitrausi17(){
        trausi17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                trausi17.setText(String.valueOf(sayitrausi17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //trausi17button//

    //------------------------------------------------------------------------------------

    //tbecom1button//
    public void azaltıcıtbecom1(){
        tbecom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom1.setText(String.valueOf(sayitbecom1--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbecom1(){
        tbecom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom1.setText(String.valueOf(sayitbecom1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbecom1button//

    //tbecom2button//
    public void azaltıcıtbecom2(){
        tbecom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom2.setText(String.valueOf(sayitbecom2--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbecom2(){
        tbecom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom2.setText(String.valueOf(sayitbecom2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbecom2button//


    //tbecom3button//
    public void azaltıcıtbecom3(){
        tbecom3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom3.setText(String.valueOf(sayitbecom3--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbecom3(){
        tbecom3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom3.setText(String.valueOf(sayitbecom3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbecom3button//

    //tbecom4button//
    public void azaltıcıtbecom4(){
        tbecom4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom4.setText(String.valueOf(sayitbecom4--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbecom4(){
        tbecom4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom4.setText(String.valueOf(sayitbecom4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbecom4button//

    //tbeo5button//
    public void azaltıcıtbecom5(){
        tbecom5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom5.setText(String.valueOf(sayitbecom5--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbecom5(){
        tbecom5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom5.setText(String.valueOf(sayitbecom5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbecom5button//

    //tbecom6button//
    public void azaltıcıtbecom6(){
        tbecom6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom6.setText(String.valueOf(sayitbecom6--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbecom6(){
        tbecom6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom6.setText(String.valueOf(sayitbecom6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbecom6button//

    //tbecom7button//
    public void azaltıcıtbecom7(){
        tbecom7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom7.setText(String.valueOf(sayitbecom7--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbecom7(){
        tbecom7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom7.setText(String.valueOf(sayitbecom7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbecom7button//

    //tbecom8button//
    public void azaltıcıtbecom8(){
        tbecom8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom8.setText(String.valueOf(sayitbecom8--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbecom8(){
        tbecom8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom8.setText(String.valueOf(sayitbecom8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbecom8button//

    //tbecom9button//
    public void azaltıcıtbecom9(){
        tbecom9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom9.setText(String.valueOf(sayitbecom9--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbecom9(){
        tbecom9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom9.setText(String.valueOf(sayitbecom9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbecom9button//

    //tbecom10button//
    public void azaltıcıtbecom10(){
        tbecom10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom10.setText(String.valueOf(sayitbecom10--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbecom10(){
        tbecom10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom10.setText(String.valueOf(sayitbecom10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbecom10button//

    //tbecom11button//
    public void azaltıcıtbecom11(){
        tbecom11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom11.setText(String.valueOf(sayitbecom11--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbecom11(){
        tbecom11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom11.setText(String.valueOf(sayitbecom11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbecom11button//

    //tbecom12button//
    public void azaltıcıtbecom12(){
        tbecom12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom12.setText(String.valueOf(sayitbecom12--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbecom12(){
        tbecom12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom12.setText(String.valueOf(sayitbecom12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbecom12button//

    //tbecom13button//
    public void azaltıcıtbecom13(){
        tbecom13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom13.setText(String.valueOf(sayitbecom13--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbecom13(){
        tbecom13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom13.setText(String.valueOf(sayitbecom13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbecom13button//

    //tbecom14button//
    public void azaltıcıtbecom14(){
        tbecom14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom14.setText(String.valueOf(sayitbecom14--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbecom14(){
        tbecom14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom14.setText(String.valueOf(sayitbecom14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbecom14button//

    //tbecom15button//
    public void azaltıcıtbecom15(){
        tbecom15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom15.setText(String.valueOf(sayitbecom15--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbecom15(){
        tbecom15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom15.setText(String.valueOf(sayitbecom15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbecom15button//

    //tbecom16button//
    public void azaltıcıtbecom16(){
        tbecom16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom16.setText(String.valueOf(sayitbecom16--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbecom16(){
        tbecom16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom16.setText(String.valueOf(sayitbecom16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbecom16button//

    //tbecom17button//
    public void azaltıcıtbecom17(){
        tbecom17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom17.setText(String.valueOf(sayitbecom17--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitbecom17(){
        tbecom17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tbecom17.setText(String.valueOf(sayitbecom17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tbecom7button//

    //------------------------------------------------------------------------------------

    //tred1button//
    public void azaltıcıtred1(){
        tred1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred1.setText(String.valueOf(sayitred1--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitred1(){
        tred1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred1.setText(String.valueOf(sayitred1++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tred1button//

    //tred2button//
    public void azaltıcıtred2(){
        tred2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred2.setText(String.valueOf(sayitred2--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitred2(){
        tred2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred2.setText(String.valueOf(sayitred2++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tred2button//

    //tred3button//
    public void azaltıcıtred3(){
        tred3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred3.setText(String.valueOf(sayitred3--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitred3(){
        tred3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred3.setText(String.valueOf(sayitred3++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tred3button//

    //tred4button//
    public void azaltıcıtred4(){
        tred4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred4.setText(String.valueOf(sayitred4--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitred4(){
        tred4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred4.setText(String.valueOf(sayitred4++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tred4button//

    //tred5button//
    public void azaltıcıtred5(){
        tred5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred5.setText(String.valueOf(sayitred5--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitred5(){
        tred5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred5.setText(String.valueOf(sayitred5++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tred5button//

    //tred6button//
    public void azaltıcıtred6(){
        tred6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred6.setText(String.valueOf(sayitred6--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitred6(){
        tred6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred6.setText(String.valueOf(sayitred6++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tred6button//

    //tred7button//
    public void azaltıcıtred7(){
        tred7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred7.setText(String.valueOf(sayitred7--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitred7(){
        tred7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred7.setText(String.valueOf(sayitred7++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tred7button//

    //tred8button//
    public void azaltıcıtred8(){
        tred8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred8.setText(String.valueOf(sayitred8--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitred8(){
        tred8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred8.setText(String.valueOf(sayitred8++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tred8button//

    //tred9button//
    public void azaltıcıtred9(){
        tred9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred9.setText(String.valueOf(sayitred9--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitred9(){
        tred9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred9.setText(String.valueOf(sayitred9++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tred9button//

    //tred10button//
    public void azaltıcıtred10(){
        tred10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred10.setText(String.valueOf(sayitred10--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitred10(){
        tred10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred10.setText(String.valueOf(sayitred10++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tred10button//

    //tred11button//
    public void azaltıcıtred11(){
        tred11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred11.setText(String.valueOf(sayitred11--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitred11(){
        tred11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred11.setText(String.valueOf(sayitred11++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tred11button//

    //tred12button//
    public void azaltıcıtred12(){
        tred12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred12.setText(String.valueOf(sayitred12--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitred12(){
        tred12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred12.setText(String.valueOf(sayitred12++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tred12button//

    //tred13button//
    public void azaltıcıtred13(){
        tred13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred13.setText(String.valueOf(sayitred13--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitred13(){
        tred13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred13.setText(String.valueOf(sayitred13++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tred13button//

    //tred14button//
    public void azaltıcıtred14(){
        tred14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred14.setText(String.valueOf(sayitred14--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitred14(){
        tred14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred14.setText(String.valueOf(sayitred14++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tred14button//

    //tred15button//
    public void azaltıcıtred15(){
        tred15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred15.setText(String.valueOf(sayitred15--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitred15(){
        tred15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred15.setText(String.valueOf(sayitred15++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tred15button//

    //tred16button//
    public void azaltıcıtred16(){
        tred16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred16.setText(String.valueOf(sayitred16--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitred16(){
        tred16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred16.setText(String.valueOf(sayitred16++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tred16button//

    //tred17button//
    public void azaltıcıtred17(){
        tred17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred17.setText(String.valueOf(sayitred17--));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    public void arttiricitred17(){
        tred17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//butonumuzun tıklanma olayı
                // TODO Auto-generated method stub
                tred17.setText(String.valueOf(sayitred17++));//textview nesnemizin text özelliğini arttırdığımız sayaç değişkenimizle set ediyoruz.
            }
        });
    }
    //tred17button//

    //------------------------------------------------------------------------------------
    @Override
    protected void onStart() {
        super.onStart();
        //name,number alanlarını veritabanından çeker. Ekranda gösterir.
        notebookRef.addSnapshotListener(this, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot queryDocumentSnapshots, FirebaseFirestoreException e) {
                if (e != null) {
                    return;
                }
                String data = "";
                String data3 = "";


                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                    Player note = documentSnapshot.toObject(Player.class);
                    note.setDocumentId(documentSnapshot.getId());

                    String name = note.getName();
                    String number=note.getNumber();

                    data +=  name + "\n";
                    data3 += number + "\n";

                }
                textViewData.setText(data);
                textViewNumber.setText(data3);

            }
        });

        //------------------------------------------------------------------------------

        //Tarihe göre sıralama yapar Create Match sayfaında girilen verilere göre
        db.collection("creatematch")
                .orderBy("date", Query.Direction.ASCENDING)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                textViewOpponent.setText("" +document.get("opponent"));
                                textViewReferee.setText("" +document.get("referee"));
                                textViewDate.setText("" +document.get("date"));
                                textViewPlace.setText("" +document.get("place"));

                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });





    }

    //------------------------------------------------------------------------------------
    // SCREENSHOT
    private void initViews() {
        parentView = findViewById(R.id.parentView);
        buttonScreenshotActivity = findViewById(R.id.buttonScreenshotActivity);
        buttonSaveScreenshot = findViewById(R.id.buttonSaveScreenshot);
        buttonReset = findViewById(R.id.buttonReset);
        imageViewShowScreenshot = findViewById(R.id.imageViewShowScreenshot);
    }

    private void initListeners() {
        buttonScreenshotActivity.setOnClickListener(this);
        buttonSaveScreenshot.setOnClickListener(this);
        buttonReset.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonScreenshotActivity:
                bitmap = ScreenshotUtil.getInstance().takeScreenshotForScreen(activity); // Take ScreenshotUtil for activity
                imageViewShowScreenshot.setImageBitmap(bitmap);
                break;
            case R.id.buttonSaveScreenshot:
                requestPermissionAndSave();
                break;
            case R.id.buttonReset:
                bitmap = null;
                imageViewShowScreenshot.setImageBitmap(bitmap);
                break;

            case R.id.buttonSaveALL:
                savePlayer();
                break;
        }
    }


    private void requestPermissionAndSave() {

        Dexter.withActivity(this)
                .withPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {

                        if (bitmap != null) {
                            String path = Environment.getExternalStorageDirectory().toString() + "/test.png";
                            FileUtil.getInstance().storeBitmap(bitmap, path);
                            Toast.makeText(activity, getString(R.string.toast_message_screenshot_success) + " " + path, Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(activity, getString(R.string.toast_message_screenshot), Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        // check for permanent denial of permission
                        if (response.isPermanentlyDenied()) {
                            Toast.makeText(activity, getString(R.string.settings_message), Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }


    private void savePlayer(){
        //------------------------------------------------------------------------------
        //Player index değerleri veritabanına kaydedilir

        //PLAYER 1 Document a
        //TORE 9m
        String Textt9m1 = t9m1.getText().toString().trim();

        //TORE 6m
        String Textt6m1 = t6m1.getText().toString().trim();

        Map<String, Object> data = new HashMap<>();
        data.put("t9m1", Textt9m1);
        data.put("t6m1", Textt6m1);

        db.collection("match").document("a")
                .set(data, SetOptions.merge())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(StartMatch.this, "Added", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(StartMatch.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        //------------------------------------------------------------------------------
        //PLAYER 2 Document b
        //TORE 9m
        String Textt9m2 = t9m2.getText().toString().trim();

        //TORE 6m
        String Textt6m2 = t6m2.getText().toString().trim();

        Map<String, Object> data2 = new HashMap<>();
        data2.put("t9m2", Textt9m2);
        data2.put("t6m2", Textt6m2);

        db.collection("match").document("b")
                .set(data2, SetOptions.merge())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(StartMatch.this, "Added", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(StartMatch.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        //------------------------------------------------------------------------------
        //PLAYER 3 Document c
        //TORE 9m
        String Textt9m3 = t9m3.getText().toString().trim();

        //TORE 6m
        String Textt6m3 = t6m3.getText().toString().trim();

        Map<String, Object> data3 = new HashMap<>();
        data3.put("t9m3", Textt9m3);
        data3.put("t6m3", Textt6m3);

        db.collection("match").document("c")
                .set(data3, SetOptions.merge())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(StartMatch.this, "Added", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(StartMatch.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        //------------------------------------------------------------------------------

        //PLAYER 4 Document d
        //TORE 9m
        String Textt9m4 = t9m4.getText().toString().trim();

        //TORE 6m
        String Textt6m4 = t6m4.getText().toString().trim();

        Map<String, Object> data4 = new HashMap<>();
        data4.put("t9m4", Textt9m4);
        data4.put("t6m4", Textt6m4);

        db.collection("match").document("d")
                .set(data4, SetOptions.merge())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(StartMatch.this, "Added", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(StartMatch.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        //------------------------------------------------------------------------------
        //PLAYER 5 Document e
        //TORE 9m
        String Textt9m5 = t9m5.getText().toString().trim();

        //TORE 6m
        String Textt6m5 = t6m5.getText().toString().trim();

        Map<String, Object> data5 = new HashMap<>();
        data5.put("t9m5", Textt9m5);
        data5.put("t6m5", Textt6m5);

        db.collection("match").document("e")
                .set(data5, SetOptions.merge())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(StartMatch.this, "Added", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(StartMatch.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        //------------------------------------------------------------------------------
        //PLAYER 6 Document f
        //TORE 9m
        String Textt9m6 = t9m6.getText().toString().trim();

        //TORE 6m
        String Textt6m6 = t6m6.getText().toString().trim();

        Map<String, Object> data6 = new HashMap<>();
        data6.put("t9m6", Textt9m6);
        data6.put("t6m6", Textt6m6);

        db.collection("match").document("f")
                .set(data6, SetOptions.merge())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(StartMatch.this, "Added", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(StartMatch.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        //------------------------------------------------------------------------------
        //PLAYER 7 Document g
        //TORE 9m
        String Textt9m7 = t9m7.getText().toString().trim();

        //TORE 6m
        String Textt6m7 = t6m7.getText().toString().trim();

        Map<String, Object> data7 = new HashMap<>();
        data7.put("t9m7", Textt9m7);
        data7.put("t6m7", Textt6m7);

        db.collection("match").document("g")
                .set(data7, SetOptions.merge())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(StartMatch.this, "Added", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(StartMatch.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        //------------------------------------------------------------------------------
        //PLAYER 8 Document h
        //TORE 9m
        String Textt9m8 = t9m8.getText().toString().trim();

        //TORE 6m
        String Textt6m8 = t6m8.getText().toString().trim();

        Map<String, Object> data8 = new HashMap<>();
        data8.put("t9m8", Textt9m8);
        data8.put("t6m8", Textt6m8);

        db.collection("match").document("h")
                .set(data8, SetOptions.merge())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(StartMatch.this, "Added", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(StartMatch.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        //------------------------------------------------------------------------------
        //PLAYER 9 Document i
        //TORE 9m
        String Textt9m9 = t9m9.getText().toString().trim();

        //TORE 6m
        String Textt6m9 = t6m9.getText().toString().trim();

        Map<String, Object> data9 = new HashMap<>();
        data9.put("t9m9", Textt9m9);
        data9.put("t6m9", Textt6m9);

        db.collection("match").document("i")
                .set(data9, SetOptions.merge())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(StartMatch.this, "Added", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(StartMatch.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        //------------------------------------------------------------------------------
        //PLAYER 10 Document k
        //TORE 9m
        String Textt9m10 = t9m10.getText().toString().trim();

        //TORE 6m
        String Textt6m10 = t6m10.getText().toString().trim();

        Map<String, Object> data10 = new HashMap<>();
        data10.put("t9m10", Textt9m10);
        data10.put("t6m10", Textt6m10);

        db.collection("match").document("k")
                .set(data10, SetOptions.merge())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(StartMatch.this, "Added", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(StartMatch.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        //------------------------------------------------------------------------------
        //PLAYER 11 Document l
        //TORE 9m
        String Textt9m11 = t9m11.getText().toString().trim();

        //TORE 6m
        String Textt6m11 = t6m11.getText().toString().trim();

        Map<String, Object> data11 = new HashMap<>();
        data11.put("t9m11", Textt9m11);
        data11.put("t6m11", Textt6m11);

        db.collection("match").document("l")
                .set(data11, SetOptions.merge())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(StartMatch.this, "Added", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(StartMatch.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        //------------------------------------------------------------------------------
        //PLAYER 12 Document m
        //TORE 9m
        String Textt9m12 = t9m12.getText().toString().trim();

        //TORE 6m
        String Textt6m12 = t6m12.getText().toString().trim();

        Map<String, Object> data12 = new HashMap<>();
        data12.put("t9m12", Textt9m12);
        data12.put("t6m12", Textt6m12);

        db.collection("match").document("m")
                .set(data12, SetOptions.merge())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(StartMatch.this, "Added", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(StartMatch.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        //------------------------------------------------------------------------------
        //PLAYER 13 Document n
        //TORE 9m
        String Textt9m13 = t9m13.getText().toString().trim();

        //TORE 6m
        String Textt6m13 = t6m13.getText().toString().trim();

        Map<String, Object> data13 = new HashMap<>();
        data13.put("t9m13", Textt9m13);
        data13.put("t6m13", Textt6m13);

        db.collection("match").document("n")
                .set(data13, SetOptions.merge())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(StartMatch.this, "Added", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(StartMatch.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        //------------------------------------------------------------------------------
        //PLAYER 14 Document o
        //TORE 9m
        String Textt9m14 = t9m14.getText().toString().trim();

        //TORE 6m
        String Textt6m14 = t6m14.getText().toString().trim();

        Map<String, Object> data14 = new HashMap<>();
        data14.put("t9m14", Textt9m14);
        data14.put("t6m14", Textt6m14);

        db.collection("match").document("o")
                .set(data14, SetOptions.merge())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(StartMatch.this, "Added", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(StartMatch.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        //------------------------------------------------------------------------------
        //PLAYER 15 Document p
        //TORE 9m
        String Textt9m15 = t9m15.getText().toString().trim();

        //TORE 6m
        String Textt6m15 = t6m15.getText().toString().trim();

        Map<String, Object> data15 = new HashMap<>();
        data15.put("t9m15", Textt9m15);
        data15.put("t6m15", Textt6m15);

        db.collection("match").document("p")
                .set(data15, SetOptions.merge())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(StartMatch.this, "Added", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(StartMatch.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        //------------------------------------------------------------------------------
        //PLAYER 16 Document r
        //TORE 9m
        String Textt9m16 = t9m16.getText().toString().trim();

        //TORE 6m
        String Textt6m16 = t6m16.getText().toString().trim();

        Map<String, Object> data16 = new HashMap<>();
        data16.put("t9m16", Textt9m16);
        data16.put("t6m16", Textt6m16);

        db.collection("match").document("r")
                .set(data16, SetOptions.merge())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(StartMatch.this, "Added", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(StartMatch.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        //------------------------------------------------------------------------------
        //PLAYER 17 Document s
        //TORE 9m
        String Textt9m17 = t9m17.getText().toString().trim();

        //TORE 6m
        String Textt6m17 = t6m17.getText().toString().trim();

        Map<String, Object> data17 = new HashMap<>();
        data17.put("t9m17", Textt9m17);
        data17.put("t6m17", Textt6m17);

        db.collection("match").document("s")
                .set(data17, SetOptions.merge())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(StartMatch.this, "Added", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(StartMatch.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }


}



