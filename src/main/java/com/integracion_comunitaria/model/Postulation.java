package com.integracion_comunitaria.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

/**
 * Representa una postulación realizada por un proveedor a una petición publicada por un cliente.
 * Cada postulación incluye una propuesta, un costo, y un estado asociado.
 */
@Entity
@Table(name = "postulation")
public class Postulation {

    /**
     * Identificador único de la postulación.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idpostulation")
    private Long idPostulation;

    /**
     * ID de la petición a la que se realiza la postulación.
     */
    @Column(name = "id_petition")
    private Long idPetition;

    /**
     * ID del proveedor que realiza la postulación.
     */
    @Column(name = "id_provider")
    private Long idProvider;

    /**
     * Indicador si esta postulación fue la ganadora ("Y"/"N").
     */
    @Column(name = "winner")
    private String winner;

    /**
     * Propuesta escrita por el proveedor.
     */
    @Column(name = "proposal")
    private String proposal;

      /**
     * Costo estimado ofrecido por el proveedor.
     */
    @Column(name="cost")
    private Long cost;

    /**
     * ID del estado de la postulación.
     */
    @Column(name="id_state")
    private Long idState;


    /**
     * Marca si es la versión actual del registro ("Y"/"N").
     */
    @Column(name="current")
    private String current;


    /**
     * ID del usuario que creó la postulación.
     */
    @Column(name="id_user_create")
    private Long idUserCreate;

    /**
     * ID del usuario que actualizó la postulación por última vez.
     */
    @Column(name="id_user_update")
    private Long idUserUpdate;


    /**
     * Fecha de creación de la postulación.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_create")
    private Date dateCreate;

    /**
     * Fecha de la última actualización de la postulación.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_update")
    private Date dateUpdate;

    @Column(name="state")
    private String state;

    // Getters y setters

    public Long getIdPostulation() {
        return idPostulation;
    }

    public void setIdPostulation(Long idPostulation) {
        this.idPostulation = idPostulation;
    }

    public Long getIdPetition() {
        return idPetition;
    }

    public void setIdPetition(Long idPetition) {
        this.idPetition = idPetition;
    }

    public Long getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(Long idProvider) {
        this.idProvider = idProvider;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getProposal() {
        return proposal;
    }

    public void setProposal(String proposal) {
        this.proposal = proposal;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Long getIdState() {
        return idState;
    }

    public void setIdState(Long idState) {
        this.idState = idState;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public Long getIdUserCreate() {
        return idUserCreate;
    }

    public void setIdUserCreate(Long idUserCreate) {
        this.idUserCreate = idUserCreate;
    }

    public Long getIdUserUpdate() {
        return idUserUpdate;
    }

    public void setIdUserUpdate(Long idUserUpdate) {
        this.idUserUpdate = idUserUpdate;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
