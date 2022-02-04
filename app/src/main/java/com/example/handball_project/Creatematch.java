package com.example.handball_project;

import com.google.firebase.firestore.Exclude;

import java.io.Serializable;

public class Creatematch implements Serializable {

    private String documentId;

    private String opponent;
    private String place;
    private String date;
    private String referee;

    @Exclude
    public String getDocumentId() {
        return documentId;
    }
    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public Creatematch(){

    }

    public Creatematch(String opponent,String place,String date,String referee){

        this.opponent=opponent;
        this.place=place;
        this.date=date;
        this.referee=referee;

    }

    public String getOpponent(){
        return opponent;
    }
    public void setOpponent(String opponent){this.opponent=opponent;}

    public String getPlace(){
        return place;
    }
    public void setPlace(String place){this.place=place;}

    public String getDate(){
        return date;
    }
    public void setDate(String date){this.date=date;}

    public String getReferee(){
        return referee;
    }
    public void setReferee(String referee){this.referee=referee;}


}
