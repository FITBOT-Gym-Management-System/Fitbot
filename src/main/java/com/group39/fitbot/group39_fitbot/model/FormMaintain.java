package com.group39.fitbot.group39_fitbot.model;


import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class FormMaintain {
     private String form_id;
     private String equipment_id;
     private String maintainer_id;
     private String equipment_type;
     private int no_of_maintainers;
     private String description;
     private int status;
     private String branchmanager_id;
     private String branch;
     private LocalTime re_time;
     private LocalDate re_date;
     private String complet_dis;
     private String complet_img;
     private LocalDate comp_date;
     private LocalTime comp_time;

     public FormMaintain() {
     }

     public FormMaintain(String form_id, String equipment_type, int status, String branch, LocalDate re_date, LocalDate comp_date) {
          this.form_id = form_id;
          this.equipment_type = equipment_type;
          this.status = status;
          this.branch = branch;
          this.re_date = re_date;
          this.comp_date = comp_date;
     }

     public String getForm_id() {
          return form_id;
     }

     public void setForm_id(String form_id) {
          this.form_id = form_id;
     }

     public String getEquipment_id() {
          return equipment_id;
     }

     public void setEquipment_id(String equipment_id) {
          this.equipment_id = equipment_id;
     }

     public String getMaintainer_id() {
          return maintainer_id;
     }

     public void setMaintainer_id(String maintainer_id) {
          this.maintainer_id = maintainer_id;
     }

     public String getEquipment_type() {
          return equipment_type;
     }

     public void setEquipment_type(String equipment_type) {
          this.equipment_type = equipment_type;
     }

     public int getNo_of_maintainers() {
          return no_of_maintainers;
     }

     public void setNo_of_maintainers(int no_of_maintainers) {
          this.no_of_maintainers = no_of_maintainers;
     }

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }

     public int getStatus() {
          return status;
     }

     public void setStatus(int status) {
          this.status = status;
     }

     public String getBranchmanager_id() {
          return branchmanager_id;
     }

     public void setBranchmanager_id(String branchmanager_id) {
          this.branchmanager_id = branchmanager_id;
     }

     public String getBranch() {
          return branch;
     }

     public void setBranch(String branch) {
          this.branch = branch;
     }

     public LocalTime getRe_time() {
          return re_time;
     }

     public void setRe_time(LocalTime re_time) {
          this.re_time = re_time;
     }

     public LocalDate getRe_date() {
          return re_date;
     }

     public void setRe_date(LocalDate re_date) {
          this.re_date = re_date;
     }

     public String getComplet_dis() {
          return complet_dis;
     }

     public void setComplet_dis(String complet_dis) {
          this.complet_dis = complet_dis;
     }

     public String getComplet_img() {
          return complet_img;
     }

     public void setComplet_img(String complet_img) {
          this.complet_img = complet_img;
     }

     public LocalDate getComp_date() {
          return comp_date;
     }

     public void setComp_date(LocalDate comp_date) {
          this.comp_date = comp_date;
     }

     public LocalTime getComp_time() {
          return comp_time;
     }

     public void setComp_time(LocalTime comp_time) {
          this.comp_time = comp_time;
     }
}



