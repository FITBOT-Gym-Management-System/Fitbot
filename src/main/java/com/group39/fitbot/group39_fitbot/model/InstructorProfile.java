package com.group39.fitbot.group39_fitbot.model;

public class InstructorProfile {
    private String p_first_name;
    private String p_last_name;
    private String bio;
    private String p_country;
    private String p_language;
    private String p_price;
    private String p_duration;
    private String skills;

    public InstructorProfile(String p_first_name, String p_last_name, String bio, String p_country, String p_language, String p_price, String p_duration, String skills) {
        this.p_first_name = p_first_name;
        this.p_last_name = p_last_name;
        this.bio = bio;
        this.p_country = p_country;
        this.p_language = p_language;
        this.p_price = p_price;
        this.p_duration = p_duration;
        this.skills = skills;
    }

    public String getP_first_name() {
        return p_first_name;
    }

    public void setP_first_name(String p_first_name) {
        this.p_first_name = p_first_name;
    }

    public String getP_last_name() {
        return p_last_name;
    }

    public void setP_last_name(String p_last_name) {
        this.p_last_name = p_last_name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getP_country() {
        return p_country;
    }

    public void setP_country(String p_country) {
        this.p_country = p_country;
    }

    public String getP_language() {
        return p_language;
    }

    public void setP_language(String p_language) {
        this.p_language = p_language;
    }

    public String getP_price() {
        return p_price;
    }

    public void setP_price(String p_price) {
        this.p_price = p_price;
    }

    public String getP_duration() {
        return p_duration;
    }

    public void setP_duration(String p_duration) {
        this.p_duration = p_duration;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "InstructorProfile{" +
                "p_first_name='" + p_first_name + '\'' +
                ", p_last_name='" + p_last_name + '\'' +
                ", bio='" + bio + '\'' +
                ", p_country='" + p_country + '\'' +
                ", p_language='" + p_language + '\'' +
                ", p_price='" + p_price + '\'' +
                ", p_duration='" + p_duration + '\'' +
                ", skills='" + skills + '\'' +
                '}';
    }
}
