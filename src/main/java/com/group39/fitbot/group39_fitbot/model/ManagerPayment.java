package com.group39.fitbot.group39_fitbot.model;

public class ManagerPayment {
    private String firstname;
    private String lastname;
    private int payment;
    private String membership_category;
    private int payment_id;

    public ManagerPayment() {
    }

    public ManagerPayment(String firstname, String lastname, int payment, String membership_category) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.payment = payment;
        this.membership_category = membership_category;
    }

    public ManagerPayment(String firstname, String lastname, int payment, String membership_category, int payment_id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.payment = payment;
        this.membership_category = membership_category;
        this.payment_id = payment_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public String getMembership_category() {
        return membership_category;
    }

    public void setMembership_category(String membership_category) {
        this.membership_category = membership_category;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    @Override
    public String toString() {
        return "ManagerPayment{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", payment=" + payment +
                ", membership_category='" + membership_category + '\'' +
                ", payment_id=" + payment_id +
                '}';
    }
}
