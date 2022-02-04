package com.example.handball_project;

import com.google.firebase.firestore.Exclude;

import java.io.Serializable;

public class Person implements Serializable {

    @Exclude
    private String id;

    private String documentId;

    private String name;
    private String surname;
    private String number;
    private String date;

    @Exclude
    public String getDocumentId() {
        return documentId;
    }
    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public Person(){

    }







    public Person(String name, String surname,String number,String date) {

        this.name = name;
        this.surname = surname;
        this.number = number;
        this.date = date;


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
