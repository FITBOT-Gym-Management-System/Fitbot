package com.group39.fitbot.group39_fitbot.model;

import java.time.LocalDate;

public class WorkoutPlanData {
    private int workout_plan_id;
    private String plan_name;
    private int time_duration;
    private String item_name;
    private int total_time;
    private String member_id;
    private String instructor_id;
    private int total_calories;
    private LocalDate completed_date;

    public WorkoutPlanData() {
    }

    public WorkoutPlanData(int workout_plan_id, String plan_name, int time_duration, String item_name, int total_time, String member_id, String instructor_id, int total_calories, LocalDate completed_date) {
        this.workout_plan_id = workout_plan_id;
        this.plan_name = plan_name;
        this.time_duration = time_duration;
        this.item_name = item_name;
        this.total_time = total_time;
        this.member_id = member_id;
        this.instructor_id = instructor_id;
        this.total_calories = total_calories;
        this.completed_date = completed_date;
    }

    public int getWorkout_plan_id() {
        return workout_plan_id;
    }

    public void setWorkout_plan_id(int workout_plan_id) {
        this.workout_plan_id = workout_plan_id;
    }

    public String getPlan_name() {
        return plan_name;
    }

    public void setPlan_name(String plan_name) {
        this.plan_name = plan_name;
    }

    public int getTime_duration() {
        return time_duration;
    }

    public void setTime_duration(int time_duration) {
        this.time_duration = time_duration;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getTotal_time() {
        return total_time;
    }

    public void setTotal_time(int total_time) {
        this.total_time = total_time;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(String instructor_id) {
        this.instructor_id = instructor_id;
    }

    public int getTotal_calories() {
        return total_calories;
    }

    public void setTotal_calories(int total_calories) {
        this.total_calories = total_calories;
    }

    public LocalDate getCompleted_date() {
        return completed_date;
    }

    public void setCompleted_date(LocalDate completed_date) {
        this.completed_date = completed_date;
    }

    @Override
    public String toString() {
        return "WorkoutPlanData{" +
                "workout_plan_id=" + workout_plan_id +
                ", plan_name='" + plan_name + '\'' +
                ", time_duration=" + time_duration +
                ", item_name='" + item_name + '\'' +
                ", total_time=" + total_time +
                ", member_id='" + member_id + '\'' +
                ", instructor_id='" + instructor_id + '\'' +
                ", total_calories=" + total_calories +
                ", completed_date=" + completed_date +
                '}';
    }
}
