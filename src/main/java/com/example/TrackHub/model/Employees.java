package com.example.TrackHub.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tpc_employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    public Long id;

    @Column(name = "first_name")
    public String fname;

    @Column(name = "last_name")
    public String lname;

    @Column(name = "display_name")
    public String display_name;

    @Column(name = "dob")
    public LocalDateTime dob;

    @Column(name = "experience")
    public String experience;

    @Column(name = "employees_role_id")
    public Long employees_role_id;

    @Column(name = "create_by")
    public String create_by;

    @Column(name = "create_date")
    public LocalDateTime create_date;

    @Column(name = "update_by")
    public String update_by;

    @Column(name = "update_date")
    public LocalDateTime update_date;

    @Column(name = "role")
    public String role;

    public Employees() {
    }

    public Employees(final long id, final String code, final String fname, final String lname, final String display_name,
            final LocalDateTime dob, final String experience, final long employees_role_id, final String create_by,
            final LocalDateTime create_date, final String update_by, final LocalDateTime update_date, final String role) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.display_name = display_name;
        this.dob = dob;
        this.experience = experience;
        this.employees_role_id = employees_role_id;
        this.create_by = create_by;
        this.create_date = create_date;
        this.update_by = update_by;
        this.update_date = update_date;
        this.role = role;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(String.valueOf(id));
        builder.append(", ");
        builder.append(fname);
        builder.append(", ");
        builder.append(lname);
        builder.append(", ");
        builder.append(display_name);
        builder.append(", ");
        builder.append(dob);
        builder.append(", ");
        builder.append(experience);
        builder.append(", ");
        builder.append(", ");
        builder.append(String.valueOf(employees_role_id));
        builder.append(", ");
        builder.append(create_by);
        builder.append(", ");
        builder.append(String.valueOf(create_date));
        builder.append(", ");
        builder.append(update_by);
        builder.append(", ");
        builder.append(String.valueOf(update_date));
        builder.append(", ");
        builder.append(role);

        return builder.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(final String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(final String lname) {
        this.lname = lname;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(final LocalDateTime dob) {
        this.dob = dob;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(final String experience) {
        this.experience = experience;
    }

    public Long getEmployees_role_id() {
        return employees_role_id;
    }

    public void setEmployees_role_id(final Long employees_role_id) {
        this.employees_role_id = employees_role_id;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(final String create_by) {
        this.create_by = create_by;
    }

    public LocalDateTime getCreate_date() {
        return create_date;
    }

    public void setCreate_date(final LocalDateTime create_date) {
        this.create_date = create_date;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(final String update_by) {
        this.update_by = update_by;
    }

    public LocalDateTime getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(final LocalDateTime update_date) {
        this.update_date = update_date;
    }

    public String getDisplayName() {
        return display_name;
    }

    public void setDisplayName(final String display_name) {
        this.display_name = display_name;
    }
}
