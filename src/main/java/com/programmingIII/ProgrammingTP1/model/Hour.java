package com.programmingIII.ProgrammingTP1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "hour")
public class Hour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hour")
    private Integer idHour;

    @NotNull
    @Column(name = "id_week")
    private Integer idWeek;

    @NotBlank
    private String name;

    public Hour() {}

    public Hour(int idHour, int idWeek, String name) {
        this.idHour = idHour;
        this.idWeek = idWeek;
        this.name = name;
    }

    public int getIdHour() {
        return idHour;
    }

    public void setIdHour(int idHour) {
        this.idHour = idHour;
    }

    public int getIdWeek() {
        return idWeek;
    }

    public void setIdWeek(int idWeek) {
        this.idWeek = idWeek;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
