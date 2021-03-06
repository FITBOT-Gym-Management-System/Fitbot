package com.group39.fitbot.group39_fitbot.model;

import java.sql.Date;
import java.time.LocalDate;

public class Maintainer {

    private String maintainer_id;
    private String first_name;
    private String last_name;
    private String email;
    private String nic;
    private LocalDate dob;
    private String gender;

    public Maintainer() {
    }

    public Maintainer(String maintainer_id) {
        this.maintainer_id = maintainer_id;
    }

    public Maintainer(String maintainer_id, String first_name, String last_name, String email, String nic, LocalDate dob, String gender) {
        this.maintainer_id = maintainer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.nic = nic;
        this.dob = dob;
        this.gender = gender;
    }



    public String getMaintainer_id() {
        return maintainer_id;
    }

    public void setMaintainer_id(String maintainer_id) {
        this.maintainer_id = maintainer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Maintainer{" +
                "maintainer_id='" + maintainer_id + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", nic='" + nic + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                '}';
    }
}

