package com.group39.fitbot.group39_fitbot.model;

public class InstructorDashboard {
    private int phy_meme_count;
    private int vir_mem_count;
    private String d_firstname;
    private String d_lastname;

    public InstructorDashboard(int phy_meme_count, int vir_mem_count, String d_firstname, String d_lastname) {
        this.phy_meme_count = phy_meme_count;
        this.vir_mem_count = vir_mem_count;
        this.d_firstname = d_firstname;
        this.d_lastname = d_lastname;
    }

    public int getPhy_meme_count() {
        return phy_meme_count;
    }

    public void setPhy_meme_count(int phy_meme_count) {
        this.phy_meme_count = phy_meme_count;
    }

    public int getVir_mem_count() {
        return vir_mem_count;
    }

    public void setVir_mem_count(int vir_mem_count) {
        this.vir_mem_count = vir_mem_count;
    }

    public String getD_firstname() {
        return d_firstname;
    }

    public void setD_firstname(String d_firstname) {
        this.d_firstname = d_firstname;
    }

    public String getD_lastname() {
        return d_lastname;
    }

    public void setD_lastname(String d_lastname) {
        this.d_lastname = d_lastname;
    }

    @Override
    public String toString() {
        return "InstructorDashboard{" +
                "phy_meme_count=" + phy_meme_count +
                ", vir_mem_count=" + vir_mem_count +
                ", d_firstname='" + d_firstname + '\'' +
                ", d_lastname='" + d_lastname + '\'' +
                '}';
    }
}
