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

@Entity
@Table(name = "petition")
public class Petition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_petition")
    private Long id_petition;

    @Column(name = "id_type_petition")
    private Long id_type_petition;

    @Column(name  = "description")
    private String description;

    @Column(name = "date_since")
    private Date date_since;

    @Column(name = "date_until")
    private Date date_until;

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

    @Column(name = "id_customer")
    private Long id_customer;

    @Column(name = "id_state")
    private Long id_state;

    public Long getId_petition() {
        return id_petition;
    }

    public void setId_petition(Long id_petition) {
        this.id_petition = id_petition;
    }

    public Long getId_type_petition() {
        return id_type_petition;
    }

    public void setId_type_petition(Long id_type_petition) {
        this.id_type_petition = id_type_petition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_since() {
        return date_since;
    }

    public void setDate_since(Date date_since) {
        this.date_since = date_since;
    }

    public Date getDate_until() {
        return date_until;
    }

    public void setDate_until(Date date_until) {
        this.date_until = date_until;
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

    public Long getId_customer() {
        return id_customer;
    }

    public void setId_customer(Long id_customer) {
        this.id_customer = id_customer;
    }

    public Long getId_state() {
        return id_state;
    }

    public void setId_state(Long id_state) {
        this.id_state = id_state;
    }

    


    
}
