package com.programmingIII.ProgrammingTP1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "week")
public class Week {
    @Id
    @NotNull
    @Column(name = "id_week")
    private Integer idWeek;

    @NotNull
    @Column(name = "id_type_jornal")
    private Integer idTypeJornal;

    @NotBlank
    @Column(name = "name")
    private String name;

    public Week() {
    }

    public Week(int idWeek, int idTypeJornal, String name) {
        this.idWeek = idWeek;
        this.idTypeJornal = idTypeJornal;
        this.name = name;
    }

    public int getIdWeek() {
        return idWeek;
    }

    public void setIdWeek(int idWeek) {
        this.idWeek = idWeek;
    }

    public int getIdTypeJornal() {
        return idTypeJornal;
    }

    public void setIdTypeJornal(int idTypeJornal) {
        this.idTypeJornal = idTypeJornal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
