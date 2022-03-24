package com.pushpa.android_college_list.model;

public class College {
    private int id;
    private String name;
    private String website;
    private double lat;

    public College() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLang() {
        return lang;
    }

    public void setLang(double lang) {
        this.lang = lang;
    }

    private double lang;

    public College(int id, String name, String website, long lat, long lang) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.lat = lat;
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "College{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", website='" + website + '\'' +
                ", lat=" + lat +
                ", lang=" + lang +
                '}';
    }
}
