package org.mutua.model;

import java.io.Serializable;
import java.util.Date;

public class WeekMorale implements Serializable {

    private Long id;
    private Date firstDayofWeek;
    private String observation;
    private Long teamId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFirstDayofWeek() {
        return firstDayofWeek;
    }

    public void setFirstDayofWeek(Date firstDayofWeek) {
        this.firstDayofWeek = firstDayofWeek;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeekMorale that = (WeekMorale) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
