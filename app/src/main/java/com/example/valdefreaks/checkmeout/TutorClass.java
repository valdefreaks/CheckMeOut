package com.example.valdefreaks.checkmeout;

/**
 * Created by valdefreaks on 18/10/18.
 */

public class TutorClass {
    private int n_idTutor;
    private String d_tutor;
    private String d_relationship;

    public TutorClass(int n_idTutor, String d_tutor, String d_relationship){
        this.n_idTutor = n_idTutor;
        this.d_tutor = d_tutor;
        this.d_relationship = d_relationship;
    }

    public int getN_idTutor() {
        return n_idTutor;
    }

    public void setN_idTutor(int n_idTutor) {
        this.n_idTutor = n_idTutor;
    }

    public String getD_tutor() {
        return d_tutor;
    }

    public void setD_tutor(String d_tutor) {
        this.d_tutor = d_tutor;
    }

    public String getD_relationship() {
        return d_relationship;
    }

    public void setD_relationship(String d_relationship) {
        this.d_relationship = d_relationship;
    }

    public boolean compareWith(TutorClass tutor){
        return this.d_tutor.compareTo(tutor.d_tutor) == 0 &&
                this.d_relationship.compareTo(tutor.d_relationship) == 0;
    }
}
