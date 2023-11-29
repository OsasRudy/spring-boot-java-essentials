package com.springtest;

import jakarta.persistence.*;

import java.util.Objects;
@Entity

public class Multisport {
    @Id
    @SequenceGenerator(
            name = "multisport_id_sequence",
            sequenceName = "multisport_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "multisport_id_sequence"
    )
    private Integer sport_id;

    public Integer getSport_id() {
        return sport_id;
    }

    public void setSport_id(Integer sport_id) {
        this.sport_id = sport_id;
    }

    private String sport_name;
    private String competitions;
    private String tournament;
    private String fixture;

    public Multisport(Integer sport_id,
                      String sportName,
                      String competitions,
                      String tournament,
                      String fixture) {
        this.sport_id = sport_id;
        this.sport_name = sportName;
        this.competitions = competitions;
        this.tournament = tournament;
        this.fixture = fixture;
    }

    public Multisport() {

    }

    public String getSport_name() {
        return sport_name;
    }

    public String getCompetitions() {
        return competitions;
    }

    public String getTournament() {
        return tournament;
    }

    public String getFixture() {
        return fixture;
    }

    public void setSport_name(String sport_name) {
        this.sport_name = sport_name;
    }

    public void setCompetitions(String competitions) {
        this.competitions = competitions;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public void setFixture(String fixture) {
        this.fixture = fixture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Multisport that = (Multisport) o;
        return Objects.equals(sport_id, that.sport_id) && Objects.equals(sport_name, that.sport_name) && Objects.equals(competitions, that.competitions) && Objects.equals(tournament, that.tournament) && Objects.equals(fixture, that.fixture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sport_id, sport_name, competitions, tournament, fixture);
    }

    @Override
    public String toString() {
        return "Multisport{" +
                "sport_id=" + sport_id +
                ", sport_name='" + sport_name + '\'' +
                ", competitions='" + competitions + '\'' +
                ", tournament='" + tournament + '\'' +
                ", fixture='" + fixture + '\'' +
                '}';
    }
}
