package com.example.TrackHub.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tpc_teams")
public class Teams {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    public Long id;

    @Column(name = "code")
    public String code;

    @Column(name = "name")
    public String name;

    @Column(name = "assigned_project_id")
    public Long assigned_project_id;

    @Column(name = "team_lead_id")
    public Long team_lead_id;

    @Column(name = "valid_from")
    public LocalDateTime valid_from;

    @Column(name = "valid_to")
    public LocalDateTime valid_to;

    @Column(name = "create_by")
    public String create_by;

    @Column(name = "create_date")
    public LocalDateTime create_date;

    @Column(name = "update_by")
    public String update_by;

    @Column(name = "update_date")
    public LocalDateTime update_date;

    public Teams() {
    }

    public Teams(Long id, String name, Long assigned_project_id, Long team_lead_id, LocalDateTime valid_to,
                 LocalDateTime valid_from, String create_by, String update_by, String code) {
    }

    public Teams(long id, String code, String name, Long assigned_project_id, Long team_lead_id,
                 LocalDateTime valid_from, LocalDateTime valid_to, String create_by, LocalDateTime create_date,
                 String update_by, LocalDateTime update_date) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.assigned_project_id = assigned_project_id;
        this.team_lead_id = team_lead_id;
        this.valid_from = valid_from;
        this.valid_to = valid_to;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAssigned_project_id() {
        return assigned_project_id;
    }

    public void setAssigned_project_id(Long assigned_project_id) {
        this.assigned_project_id = assigned_project_id;
    }

    public Long getTeam_lead_id() {
        return team_lead_id;
    }

    public void setTeam_lead_id(Long team_lead_id) {
        this.team_lead_id = team_lead_id;
    }

    public LocalDateTime getValid_from() {
        return valid_from;
    }

    public void setValid_from(LocalDateTime valid_from) {
        this.valid_from = valid_from;
    }

    public LocalDateTime getValid_to() {
        return valid_to;
    }

    public void setValid_to(LocalDateTime valid_to) {
        this.valid_to = valid_to;
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(String.valueOf(id));
        builder.append(", ");
        builder.append(code);
        builder.append(", ");
        builder.append(name);
        builder.append(", ");
        builder.append(assigned_project_id);
        builder.append(", ");
        builder.append(team_lead_id);
        builder.append(", ");
        builder.append(String.valueOf(valid_from));
        builder.append(", ");
        builder.append(String.valueOf(valid_to));
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
