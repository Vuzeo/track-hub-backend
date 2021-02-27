package com.example.TrackHub.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tpt_worklog")
public class Worklog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    public Long id;

    @Column(name = "employee_id")
    public Integer employee_id;

    @Column(name = "project_id")
    public Integer project_id;

    @Column(name = "project_activity_id")
    public Integer project_activity_id;

    @Column(name = "work_date")
    public LocalDateTime work_date;

    @Column(name = "hours")
    public Integer hours;

    @Column(name = "minutes")
    public Integer minutes;

    @Column(name = "notes")
    public String notes;

    @Column(name = "create_by")
    public String create_by;

    @Column(name = "create_date")
    public LocalDateTime create_date;

    @Column(name = "update_by")
    public String update_by;

    @Column(name = "update_date")
    public LocalDateTime update_date;

    public Worklog() {
    }

    public Worklog(long id, Integer employee_id, Integer project_id, Integer project_activity_id,
                   LocalDateTime work_date, Integer hours, Integer minutes, String notes,
                   String create_by, LocalDateTime create_date, String update_by,
                   LocalDateTime update_date) {
        this.id = id;
        this.employee_id = employee_id;
        this.project_id = project_id;
        this.project_activity_id = project_activity_id;
        this.work_date = work_date;
        this.hours = hours;
        this.minutes = minutes;
        this.notes = notes;
        this.create_by = create_by;
        this.create_date = create_date;
        this.update_by = update_by;
        this.update_date = update_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public Integer getProject_id() {
        return project_id;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    public Integer getProject_activity_id() {
        return project_activity_id;
    }

    public void setProject_activity_id(Integer project_activity_id) {
        this.project_activity_id = project_activity_id;
    }

    public LocalDateTime getWork_date() {
        return work_date;
    }

    public void setWork_date(LocalDateTime work_date) {
        this.work_date = work_date;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public LocalDateTime getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDateTime create_date) {
        this.create_date = create_date;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    public LocalDateTime getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(LocalDateTime update_date) {
        this.update_date = update_date;
    }

}
