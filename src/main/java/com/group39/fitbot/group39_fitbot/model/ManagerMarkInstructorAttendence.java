package com.group39.fitbot.group39_fitbot.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class ManagerMarkInstructorAttendence {
    private LocalDate date;
    private LocalTime start_time;
    private LocalTime end_time;
    private String instructor_id;
    private int status;


    public ManagerMarkInstructorAttendence() {
    }
    public ManagerMarkInstructorAttendence(LocalDate date, LocalTime start_time, LocalTime end_time, String instructor_id, int status) {
        this.date = date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.instructor_id = instructor_id;
        this.status = status;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalTime start_time) {
        this.start_time = start_time;
    }

    public LocalTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalTime end_time) {
        this.end_time = end_time;
    }

    public String getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(String instructor_id) {
        this.instructor_id = instructor_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ManagerMarkInstructorAttendence{" +
                "date=" + date +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", instructor_id='" + instructor_id + '\'' +
                ", status=" + status +
                '}';
    }
}
