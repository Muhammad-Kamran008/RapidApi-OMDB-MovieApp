package com.example.rpaidapi_omdb.Model;

import java.util.List;

public class MovieResult {
    private String id="";
    private Image image=null;
    private int runningTimeInMinutes=1;
    private String title="";
    private String titleType="";
    private int year=1;
    private List<Principal> principals=null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getRunningTimeInMinutes() {
        return runningTimeInMinutes;
    }

    public void setRunningTimeInMinutes(int runningTimeInMinutes) {
        this.runningTimeInMinutes = runningTimeInMinutes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleType() {
        return titleType;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Principal> getPrincipals() {
        return principals;
    }

    public void setPrincipals(List<Principal> principals) {
        this.principals = principals;
    }
}
