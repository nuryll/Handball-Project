package com.example.handball_project;

import com.google.firebase.firestore.Exclude;

import java.io.Serializable;

public class Player implements Serializable {

    private String name;
    private String number;

    //TORE 9m
    private String t9m1;
    private String t9m2;
    private String t9m3;
    private String t9m4;
    private String t9m5;
    private String t9m6;
    private String t9m7;
    private String t9m8;
    private String t9m9;
    private String t9m10;
    private String t9m11;
    private String t9m12;
    private String t9m13;
    private String t9m14;
    private String t9m15;
    private String t9m16;
    private String t9m17;

    //TORE 6m
    private String t6m1;
    private String t6m2;
    private String t6m3;
    private String t6m4;
    private String t6m5;
    private String t6m6;
    private String t6m7;
    private String t6m8;
    private String t6m9;
    private String t6m10;
    private String t6m11;
    private String t6m12;
    private String t6m13;
    private String t6m14;
    private String t6m15;
    private String t6m16;
    private String t6m17;


    @Exclude
    private String id;

    private String documentId;

    @Exclude
    public String getDocumentId() {
        return documentId;
    }
    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public Player(){

    }


    public Player(String name,String number,String t6m1, String t6m2,String t6m3,String t6m4,String t6m5, String t6m6,String t6m7,String t6m8,
    String t6m9, String t6m10,String t6m11,String t6m12,String t6m13, String t6m14,String t6m15,String t6m16,String t6m17,
                  String t9m1, String t9m2,String t9m3,String t9m4,String t9m5, String t9m6,String t9m7,String t9m8,
                  String t9m9, String t9m10,String t9m11,String t9m12,String t9m13, String t9m14,String t9m15,String t9m16,String t9m17) {

        this.name = name;
        this.number = number;

        this.t6m1 = t6m1;
        this.t6m2 = t6m2;
        this.t6m3 = t6m3;
        this.t6m4 = t6m4;
        this.t6m5 = t6m5;
        this.t6m6 = t6m6;
        this.t6m7 = t6m7;
        this.t6m8 = t6m8;
        this.t6m9 = t6m9;
        this.t6m10 = t6m10;
        this.t6m11 = t6m11;
        this.t6m12 = t6m12;
        this.t6m13 = t6m13;
        this.t6m14 = t6m14;
        this.t6m15 = t6m15;
        this.t6m16 = t6m16;
        this.t6m17 = t6m17;

        this.t9m1 = t9m1;
        this.t9m2 = t9m2;
        this.t9m3 = t9m3;
        this.t9m4 = t9m4;
        this.t9m5 = t9m5;
        this.t9m6 = t9m6;
        this.t9m7 = t9m7;
        this.t9m8 = t9m8;
        this.t9m9 = t9m9;
        this.t9m10 = t9m10;
        this.t9m11 = t9m11;
        this.t9m12 = t9m12;
        this.t9m13 = t9m13;
        this.t9m14 = t9m14;
        this.t9m15 = t9m15;
        this.t9m16 = t9m16;
        this.t9m17 = t9m17;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    //t6m1
    public String getT6m1() {
        return t6m1;
    }

    public void setT6m1(String t6m1) {
        this.t6m1 = t6m1;
    }

    //t6m2
    public String getT6m2() {
        return t6m2;
    }

    public void setT6m2(String t6m2) {
        this.t6m2 = t6m2;
    }

    //t6m3
    public String getT6m3() {
        return t6m3;
    }

    public void setT6m3(String t6m3) {
        this.t6m3 = t6m3;
    }

    //t6m4
    public String getT6m4() {
        return t6m4;
    }

    public void setT6m4(String t6m4) {
        this.t6m4 = t6m4;
    }

    //t6m5
    public String getT6m5() {
        return t6m5;
    }

    public void setT6m5(String t6m5) {
        this.t6m5 = t6m5;
    }

    //t6m6
    public String getT6m6() {
        return t6m6;
    }

    public void setT6m6(String t6m6) {
        this.t6m6 = t6m6;
    }

    //t6m7
    public String getT6m7() {
        return t6m7;
    }

    public void setT6m7(String t6m7) {
        this.t6m7 = t6m7;
    }

    //t6m8
    public String getT6m8() {
        return t6m8;
    }

    public void setT6m8(String t6m8) {
        this.t6m8 = t6m8;
    }

    //t6m9
    public String getT6m9() {
        return t6m9;
    }

    public void setT6m9(String t6m9) {
        this.t6m9 = t6m9;
    }

    //t6m10
    public String getT6m10() {
        return t6m10;
    }

    public void setT6m10(String t6m10) {
        this.t6m10 = t6m10;
    }

    //t6m11
    public String getT6m11() {
        return t6m11;
    }

    public void setT6m11(String t6m11) {
        this.t6m11 = t6m11;
    }

    //t6m12
    public String getT6m12() {
        return t6m12;
    }

    public void setT6m12(String t6m12) {
        this.t6m12 = t6m12;
    }

    //t6m13
    public String getT6m13() {
        return t6m13;
    }

    public void setT6m13(String t6m13) {
        this.t6m5 = t6m13;
    }

    //t6m14
    public String getT6m14() {
        return t6m14;
    }

    public void setT6m14(String t6m14) {
        this.t6m14 = t6m14;
    }

    //t6m15
    public String getT6m15() {
        return t6m15;
    }

    public void setT6m15(String t6m15) {
        this.t6m15 = t6m15;
    }

    //t6m16
    public String getT6m16() {
        return t6m16;
    }

    public void setT6m16(String t6m16) {
        this.t6m16 = t6m16;
    }

    //t6m17
    public String getT6m17() {
        return t6m17;
    }

    public void setT6m17(String t6m17) {
        this.t6m17 = t6m17;
    }


    //--------------------------------------------------------------------------------


    //t9m1
    public String getT9m1() {
        return t9m1;
    }

    public void setT9m1(String t9m1) {
        this.t9m1 = t9m1;
    }

    //t9m2
    public String getT9m2() {
        return t9m2;
    }

    public void setT9m2(String t9m2) {
        this.t9m2 = t9m2;
    }

    //t9m3
    public String getT9m3() {
        return t9m3;
    }

    public void setT9m3(String t9m3) {
        this.t9m3 = t9m3;
    }

    //t9m4
    public String getT9m4() {
        return t9m4;
    }

    public void setT9m4(String t9m4) {
        this.t6m4 = t9m4;
    }

    //t9m5
    public String getT9m5() {
        return t9m5;
    }

    public void setT9m5(String t9m5) {
        this.t6m5 = t9m5;
    }

    //t9m6
    public String getT9m6() {
        return t9m6;
    }

    public void setT9m6(String t9m6) {
        this.t9m6 = t9m6;
    }

    //t9m7
    public String getT9m7() {
        return t9m7;
    }

    public void setT9m7(String t9m7) {
        this.t9m7 = t9m7;
    }

    //t9m8
    public String getT9m8() {
        return t9m8;
    }

    public void setT9m8(String t9m8) {
        this.t9m8 = t9m8;
    }

    //t9m9
    public String getT9m9() {
        return t9m9;
    }

    public void setT9m9(String t9m9) {
        this.t9m9 = t9m9;
    }

    //t9m10
    public String getT9m10() {
        return t9m10;
    }

    public void setT9m10(String t9m10) {
        this.t9m10 = t9m10;
    }

    //t9m11
    public String getT9m11() { return t9m11; }

    public void setT9m11(String t9m11) {
        this.t9m11 = t9m11;
    }

    //t9m12
    public String getT9m12() {
        return t9m12;
    }

    public void setT9m12(String t9m12) {
        this.t9m12 = t9m12;
    }

    //t9m13
    public String getT9m13() {
        return t9m13;
    }

    public void setT9m13(String t9m13) {
        this.t9m5 = t9m13;
    }

    //t9m14
    public String getT9m14() {
        return t9m14;
    }

    public void setT9m14(String t9m14) {
        this.t9m14 = t9m14;
    }

    //t9m15
    public String getT9m15() {
        return t9m15;
    }

    public void setT9m15(String t9m15) {
        this.t9m15 = t9m15;
    }

    //t9m16
    public String getT9m16() {
        return t9m16;
    }

    public void setT9m16(String t9m16) {
        this.t9m16 = t9m16;
    }

    //t9m17
    public String getT9m17() {
        return t9m17;
    }

    public void setT9m17(String t9m17) {
        this.t9m17 = t9m17;
    }
}
