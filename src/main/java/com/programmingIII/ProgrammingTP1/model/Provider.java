package com.programmingIII.ProgrammingTP1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "provider")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_provider")
    private Integer idProvider;

    @NotNull
    @Column(name = "id_type_provider")
    private Integer idTypeProvider;

    @NotNull
    @Column(name = "id_category")
    private Integer idCategory;

    @NotNull
    @Column(name = "id_grade_provider")
    private Integer idGradeProvider;

    @NotNull
    @Column(name = "id_profession")
    private Integer idProfession;

    @NotNull
    @Column(name = "id_user")
    private Integer idUser;

    @NotNull
    @Column(name = "id_offer")
    private Integer idOffer;

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotNull
    @Column(name = "gps_lat")
    private Double gpsLat;

    @NotNull
    @Column(name = "gps_long")
    private Double gpsLong;

    public Provider() {}

    public Provider(int idProvider, int idTypeProvider, int idCategory, int idGradeProvider, int idProfession, int idUser, int idOffer, String name, String address, Double gpsLat, Double gpsLong) {
        this.idProvider = idProvider;
        this.idTypeProvider = idTypeProvider;
        this.idCategory = idCategory;
        this.idGradeProvider = idGradeProvider;
        this.idProfession = idProfession;
        this.idUser = idUser;
        this.idOffer = idOffer;
        this.name = name;
        this.address = address;
        this.gpsLat = gpsLat;
        this.gpsLong = gpsLong;
    }

    public int getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(Integer idProvider) {
        this.idProvider = idProvider;
    }

    public int getIdTypeProvider() {
        return idTypeProvider;
    }

    public void setIdTypeProvider(Integer idTypeProvider) {
        this.idTypeProvider = idTypeProvider;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public int getIdGradeProvider() {
        return idGradeProvider;
    }

    public void setIdGradeProvider(Integer idGradeProvider) {
        this.idGradeProvider = idGradeProvider;
    }

    public int getIdProfession() {
        return idProfession;
    }

    public void setIdProfession(Integer idProfession) {
        this.idProfession = idProfession;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public int getIdOffer() {
        return idOffer;
    }

    public void setIdOffer(Integer idOffer) {
        this.idOffer = idOffer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(Double gpsLat) {
        this.gpsLat = gpsLat;
    }

    public Double getGpsLong() {
        return gpsLong;
    }

    public void setGpsLong(Double gpsLong) {
        this.gpsLong = gpsLong;
    }
}
