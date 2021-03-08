package com.example.TrackHub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tpc_team_members")
public class TeamMembers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    public Long id;

    @Column(name = "team_id")
    public Long team_id;

    @Column(name = "team_member_id")
    public Long team_member_id;

    @Column(name = "team_member_role_id")
    public Long team_member_role_id;

    public TeamMembers() {
    }

    public TeamMembers(final long id, final Long team_id, final Long team_member_id, final Long team_member_role_id) {
        this.id = id;
        this.team_id = team_id;
        this.team_member_id = team_member_id;
        this.team_member_role_id = team_member_role_id;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append(String.valueOf(id));
        builder.append(", ");
        builder.append(String.valueOf(team_id));
        builder.append(", ");
        builder.append(String.valueOf(team_member_id));
        builder.append(", ");
        builder.append(String.valueOf(team_member_role_id));
        return builder.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getTeam_id() {
        return team_id;
    }

    public void setTeam_id(final Long team_id) {
        this.team_id = team_id;
    }

    public Long getTeam_member_id() {
        return team_member_id;
    }

    public void setTeam_member_id(final Long team_member_id) {
        this.team_member_id = team_member_id;
    }

    public Long getTeam_member_role_id() {
        return team_member_role_id;
    }

    public void setTeam_member_role_id(final Long team_member_role_id) {
        this.team_member_role_id = team_member_role_id;
    }
}
