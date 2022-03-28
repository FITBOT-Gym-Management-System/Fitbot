package com.group39.fitbot.group39_fitbot.model;

import java.time.LocalDate;

public class ManagerInstructorView {
    private String first_name;
    private String last_name;
    private LocalDate joined_date;
    private String instructor_id;

    public ManagerInstructorView() {
    }

    public ManagerInstructorView(String first_name, String last_name, LocalDate joined_date, String instructor_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.joined_date = joined_date;
        this.instructor_id = instructor_id;
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

    public LocalDate getJoined_date() {
        return joined_date;
    }

    public void setJoined_date(LocalDate joined_date) {
        this.joined_date = joined_date;
    }

    public String getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(String instructor_id) {
        this.instructor_id = instructor_id;
    }

    @Override
    public String toString() {
        return "ManagerInstructorView{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", joined_date=" + joined_date +
                ", instructor_id='" + instructor_id + '\'' +
                '}';
    }
}

