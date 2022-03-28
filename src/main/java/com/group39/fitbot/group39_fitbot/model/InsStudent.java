package com.group39.fitbot.group39_fitbot.model;

import java.sql.Date;
import java.time.LocalDate;

public class InsStudent {
    private String MemberId;
    private String Name;
    private String Branch;
    private String Type;
    private String Email;
    private LocalDate Dob;
    private Integer Weight;
    private Integer Height;
    private String Membership;
    private String ContactNo;

    public InsStudent() {
    }

    public InsStudent(String name, String branch, LocalDate dob, Integer weight, Integer height, String membership) {
        Name = name;
        Branch = branch;
        Dob = dob;
        Weight = weight;
        Height = height;
        Membership = membership;
    }

    public InsStudent(String memberId, String name, String branch, String type, String email, String membership) {
        MemberId = memberId;
        Name = name;
        Branch = branch;
        Type = type;
        Email = email;
        Membership = membership;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public LocalDate getDob() {
        return Dob;
    }

    public void setDob(LocalDate dob) {
        Dob = dob;
    }

    public Integer getWeight() {
        return Weight;
    }

    public void setWeight(Integer weight) {
        Weight = weight;
    }

    public Integer getHeight() {
        return Height;
    }

    public void setHeight(Integer height) {
        Height = height;
    }

    public String getMembership() {
        return Membership;
    }

    public void setMembership(String membership) {
        Membership = membership;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String contactNo) {
        ContactNo = contactNo;
    }

    @Override
    public String toString() {
        return "InsStudent{" +
                "MemberId='" + MemberId + '\'' +
                ", Name='" + Name + '\'' +
                ", Branch='" + Branch + '\'' +
                ", Type='" + Type + '\'' +
                ", Email='" + Email + '\'' +
                ", Dob=" + Dob +
                ", Weight=" + Weight +
                ", Height=" + Height +
                ", Membership='" + Membership + '\'' +
                ", ContactNo='" + ContactNo + '\'' +
                '}';
    }
}
