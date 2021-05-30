package org.mutua.model;

import java.io.Serializable;

public class Member implements Serializable {

    private String email;
    private Long team;
    private boolean active;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTeam() {
        return team;
    }

    public void setTeam(Long team) {
        this.team = team;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        if (active != member.active) return false;
        if (!email.equals(member.email)) return false;
        return team.equals(member.team);
    }

    @Override
    public int hashCode() {
        int result = email.hashCode();
        result = 31 * result + team.hashCode();
        result = 31 * result + (active ? 1 : 0);
        return result;
    }
}
