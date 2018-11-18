package com.example.valdefreaks.checkmeout;

import java.util.Date;

/**
 * Created by valdefreaks on 5/10/18.
 */

public class RubricClass {
    private String title;
    private String description;
    private String date;
    private int id_rubric;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public void setId_rubric(int id_rubric) {
        this.id_rubric = id_rubric;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId_rubric() {
        return id_rubric;
    }
}
