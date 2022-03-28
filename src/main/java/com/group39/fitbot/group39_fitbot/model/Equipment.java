package com.group39.fitbot.group39_fitbot.model;

import java.sql.Date;
import java.time.LocalDate;

public class Equipment {
      private String branch_name;
      private String equipment_id;
      private String description;
      private String category;
      private LocalDate purchase_date;
      private LocalDate last_modified_date;
      private LocalDate next_maintenance_date;
      private int duration;
      private int maintain_count;
      private int equipment_has_modified;

      public Equipment() {
      }

      public Equipment(String equipment_id) {
            this.equipment_id = equipment_id;
      }

      public Equipment(String branch_name, String equipment_id, String description, String category, LocalDate purchase_date, LocalDate last_modified_date, LocalDate next_maintenance_date, int duration, int equipment_has_modified) {
            this.branch_name = branch_name;
            this.equipment_id = equipment_id;
            this.description = description;
            this.category = category;
            this.purchase_date = purchase_date;
            this.last_modified_date = last_modified_date;
            this.next_maintenance_date = next_maintenance_date;
            this.duration = duration;
            this.equipment_has_modified = equipment_has_modified;
      }

      public Equipment(String branch_name, String equipment_id, String description, String category, LocalDate purchase_date, LocalDate last_modified_date, LocalDate next_maintenance_date, int duration) {
            this.branch_name = branch_name;
            this.equipment_id = equipment_id;
            this.description = description;
            this.category = category;
            this.purchase_date = purchase_date;
            this.last_modified_date = last_modified_date;
            this.next_maintenance_date = next_maintenance_date;
            this.duration = duration;

      }

      public Equipment(String branch_name, String equipment_id, String description, String category, LocalDate purchase_date, LocalDate last_modified_date, LocalDate next_maintenance_date, int duration, int maintain_count, int equipment_has_modified) {
            this.branch_name = branch_name;
            this.equipment_id = equipment_id;
            this.description = description;
            this.category = category;
            this.purchase_date = purchase_date;
            this.last_modified_date = last_modified_date;
            this.next_maintenance_date = next_maintenance_date;
            this.duration = duration;
            this.maintain_count = maintain_count;
            this.equipment_has_modified = equipment_has_modified;
      }


      public String getBranch_name() {
            return branch_name;
      }

      public void setBranch_name(String branch_name) {
            this.branch_name = branch_name;
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

      public LocalDate getPurchase_date() {
            return purchase_date;
      }

      public void setPurchase_date(LocalDate purchase_date) {
            this.purchase_date = purchase_date;
      }

      public LocalDate getLast_modified_date() {
            return last_modified_date;
      }

      public void setLast_modified_date(LocalDate last_modified_date) {
            this.last_modified_date = last_modified_date;
      }

      public LocalDate getNext_maintenance_date() {
            return next_maintenance_date;
      }

      public void setNext_maintenance_date(LocalDate next_maintenance_date) {
            this.next_maintenance_date = next_maintenance_date;
      }

      public int getDuration() {
            return duration;
      }

      public void setDuration(int duration) {
            this.duration = duration;
      }

      public int getMaintain_count() {
            return maintain_count;
      }

      public void setMaintain_count(int maintain_count) {
            this.maintain_count = maintain_count;
      }

      public int getEquipment_has_modified() {
            return equipment_has_modified;
      }

      public void setEquipment_has_modified(int equipment_has_modified) {
            this.equipment_has_modified = equipment_has_modified;
      }

      @Override
      public String toString() {
            return "Equipment{" +
                    "branch_name='" + branch_name + '\'' +
                    ", equipment_id='" + equipment_id + '\'' +
                    ", description='" + description + '\'' +
                    ", category='" + category + '\'' +
                    ", purchase_date=" + purchase_date +
                    ", last_modified_date=" + last_modified_date +
                    ", next_maintenance_date=" + next_maintenance_date +
                    ", duration=" + duration +
                    ", maintain_count=" + maintain_count +
                    ", equipment_has_modified=" + equipment_has_modified +
                    '}';
      }
}



