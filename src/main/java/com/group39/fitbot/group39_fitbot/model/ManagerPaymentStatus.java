package com.group39.fitbot.group39_fitbot.model;

public class ManagerPaymentStatus {
    private int payment_status;

    public ManagerPaymentStatus(int payment_status) {
        this.payment_status = payment_status;
    }

    public int getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(int payment_status) {
        this.payment_status = payment_status;
    }

    @Override
    public String toString() {
        return "ManagerPaymentStatus{" +
                "payment_status=" + payment_status +
                '}';
    }
}
