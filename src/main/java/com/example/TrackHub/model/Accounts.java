package com.example.TrackHub.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tpc_accounts")
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    public Long id;

    @Column(name = "code")
    public String code;

    @Column(name = "name")
    public String name;

    @Column(name = "active")
    public String active;

    @Column(name = "valid_from")
    public LocalDateTime valid_from;

    @Column(name = "valid_to")
    public LocalDateTime valid_to;

    @Column(name = "responsible")
    public Long responsible;

    @Column(name = "create_by")
    public String create_by;

    @Column(name = "create_date")
    public LocalDateTime create_date;

    @Column(name = "update_by")
    public String update_by;

    @Column(name = "update_date")
    public LocalDateTime update_date;

    public Accounts() {
    }

    public Accounts(final Long id, final String name, final String active, final Long responsible, final LocalDateTime valid_to,
            final LocalDateTime valid_from, final String create_by, final String update_by, final String code) {
    }

    public Accounts(final long id, final String code, final String name, final String active, final LocalDateTime valid_from,
            final LocalDateTime valid_to, final long responsible, final String create_by, final LocalDateTime create_date,
            final String update_by, final LocalDateTime update_date) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.active = active;
        this.valid_from = valid_from;
        this.valid_to = valid_to;
        this.responsible = responsible;
        this.create_by = create_by;
        this.create_date = create_date;
        this.update_by = update_by;
        this.update_date = update_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getActive() {
        return active;
    }

    public void setActive(final String active) {
        this.active = active;
    }

    public LocalDateTime getValid_from() {
        return valid_from;
    }

    public void setValid_from(final LocalDateTime valid_from) {
        this.valid_from = valid_from;
    }

    public LocalDateTime getValid_to() {
        return valid_to;
    }

    public void setValid_to(final LocalDateTime valid_to) {
        this.valid_to = valid_to;
    }

    public Long getResponsible() {
        return responsible;
    }

    public void setResponsible(final Long responsible) {
        this.responsible = responsible;
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(String.valueOf(id));
        builder.append(", ");
        builder.append(code);
        builder.append(", ");
        builder.append(name);
        builder.append(", ");
        builder.append(active);
        builder.append(", ");
        builder.append(String.valueOf(valid_from));
        builder.append(", ");
        builder.append(String.valueOf(valid_to));
        builder.append(", ");
        builder.append(String.valueOf(responsible));
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
