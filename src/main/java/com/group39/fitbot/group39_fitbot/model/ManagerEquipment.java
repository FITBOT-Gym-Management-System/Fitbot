package com.group39.fitbot.group39_fitbot.model;

import java.sql.Date;
import java.time.LocalDate;

public class ManagerEquipment {
      private String branch_id;
      private String equipment_id;
      private String description;
      private String category;
      private Date purchase_date;
      private Date last_modified_date;
      private Date next_maintenance_date;
      private String serial_no;

    public ManagerEquipment(String branch_id, String equipment_id, String description, String category, Date purchase_date, Date last_modified_date, Date next_maintenance_date, String serial_no) {
        this.branch_id = branch_id;
        this.equipment_id = equipment_id;
        this.description = description;
        this.category = category;
        this.purchase_date = purchase_date;
        this.last_modified_date = last_modified_date;
        this.next_maintenance_date = next_maintenance_date;
        this.serial_no = serial_no;
    }

    public ManagerEquipment() {

    }

    public ManagerEquipment(String description, String category, Date purchase_date, String serial_no) {
        this.description = description;
        this.category = category;
        this.purchase_date = purchase_date;
        this.serial_no = serial_no;
    }

    public ManagerEquipment(String equipment_id, String category, Date next_maintenance_date) {
        this.equipment_id = equipment_id;
        this.category = category;
        this.next_maintenance_date = next_maintenance_date;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public String getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(String equipment_id) {
        this.equipment_id = equipment_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    public Date getLast_modified_date() {
        return last_modified_date;
    }

    public void setLast_modified_date(Date last_modified_date) {
        this.last_modified_date = last_modified_date;
    }

    public Date getNext_maintenance_date() {
        return next_maintenance_date;
    }

    public void setNext_maintenance_date(Date next_maintenance_date) {
        this.next_maintenance_date = next_maintenance_date;
    }

    public String getSerial_no() {
        return serial_no;
    }

    public void setSerial_no(String serial_no) {
        this.serial_no = serial_no;
    }

    @Override
    public String toString() {
        return "ManagerEquipment{" +
                "branch_id='" + branch_id + '\'' +
                ", equipment_id='" + equipment_id + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", purchase_date=" + purchase_date +
                ", last_modified_date=" + last_modified_date +
                ", next_maintenance_date=" + next_maintenance_date +
                ", serial_no='" + serial_no + '\'' +
                '}';
    }
}


