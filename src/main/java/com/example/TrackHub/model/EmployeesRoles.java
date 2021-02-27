package com.example.TrackHub.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tpc_employees_roles")
public class EmployeesRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    public Long id;

    @Column(name = "code")
    public String code;

    @Column(name = "name")
    public String name;

    @Column(name = "create_by")
    public String create_by;

    @Column(name = "create_date")
    public LocalDateTime create_date;

    @Column(name = "update_by")
    public String update_by;

    @Column(name = "update_date")
    public LocalDateTime update_date;

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public void setCreate_date(LocalDateTime create_date) {
        this.create_date = create_date;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    public void setUpdate_date(LocalDateTime update_date) {
        this.update_date = update_date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeesRoles() {
    }

    public EmployeesRoles(long id, String code, String name, String create_by, LocalDateTime create_date,
                          String update_by, LocalDateTime update_date) {

        this.id = id;
        this.code = code;
        this.name = name;
        this.create_by = create_by;
        this.create_date = create_date;
        this.update_by = update_by;
        this.update_date = update_date;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getCreate_by() {
        return create_by;
    }

    public LocalDateTime getCreate_date() {
        return create_date;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public LocalDateTime getUpdate_date() {
        return update_date;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append(String.valueOf(id));
        builder.append(", ");
        builder.append(name);
        builder.append(", ");
        builder.append(code);
        builder.append(", ");
        builder.append(create_by);
        builder.append(", ");
        builder.append(String.valueOf(create_date));
        builder.append(", ");
        builder.append(update_by);
        builder.append(", ");
        builder.append(String.valueOf(update_date));

        return builder.toString();
    }
}