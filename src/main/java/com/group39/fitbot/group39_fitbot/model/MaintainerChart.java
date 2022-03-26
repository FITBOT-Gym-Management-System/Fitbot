package com.group39.fitbot.group39_fitbot.model;

import java.time.LocalDate;

public class MaintainerChart {
    private LocalDate Date;
    private int Count;

    public MaintainerChart() {
    }

    public MaintainerChart(LocalDate date, int count) {
        Date = date;
        Count = count;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    @Override
    public String toString() {
        return "MaintainerChart{" +
                "Date=" + Date +
                ", Count=" + Count +
                '}';
    }
}
