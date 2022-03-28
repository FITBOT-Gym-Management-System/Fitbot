package com.group39.fitbot.group39_fitbot.model;

import java.time.LocalDate;

public class InstructorAppointment {
    LocalDate appointment_date;
    Integer appointment_count;

    public InstructorAppointment() {
    }

    public InstructorAppointment(LocalDate appointment_date, Integer appointment_count) {
        this.appointment_date = appointment_date;
        this.appointment_count = appointment_count;
    }

    public LocalDate getAppointment_date() {
        return appointment_date;
    }

    public Integer getAppointment_count() {
        return appointment_count;
    }

    public void setAppointment_date(LocalDate appointment_date) {
        this.appointment_date = appointment_date;
    }

    public void setAppointment_count(Integer appointment_count) {
        this.appointment_count = appointment_count;
    }

    @Override
    public String toString() {
        return "InstructorAppointment{" +
                "appointment_date=" + appointment_date +
                ", appointment_count=" + appointment_count +
                '}';
    }
}
