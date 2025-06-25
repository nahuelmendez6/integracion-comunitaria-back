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
    private Long idPetition;

    @Column(name = "id_type_petition")
    private Long idTypePetition;

    @Column(name  = "description")
    private String description;

    @Column(name = "date_since")
    private Date dateSince;

    @Column(name = "date_until")
    private Date dateUntil;

    @Column(name="id_user_create")
    private Long idUserCreate;

    @Column(name="id_user_update")
    private Long idUserUpdate;

    @Column(name = "id_customer")
    private Long idCustomer;

    @Column(name = "id_state")
    private Long idState;

    // Getters y setters con camelCase
    
    public Long getIdPetition() { return idPetition; }
    public void setIdPetition(Long idPetition) { this.idPetition = idPetition; }

    public Long getIdTypePetition() { return idTypePetition; }
    public void setIdTypePetition(Long idTypePetition) { this.idTypePetition = idTypePetition; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Date getDateSince() { return dateSince; }
    public void setDateSince(Date dateSince) { this.dateSince = dateSince; }

    public Date getDateUntil() { return dateUntil; }
    public void setDateUntil(Date dateUntil) { this.dateUntil = dateUntil; }

    public Long getIdUserCreate() { return idUserCreate; }
    public void setIdUserCreate(Long idUserCreate) { this.idUserCreate = idUserCreate; }

    public Long getIdUserUpdate() { return idUserUpdate; }
    public void setIdUserUpdate(Long idUserUpdate) { this.idUserUpdate = idUserUpdate; }

    public Long getIdCustomer() { return idCustomer; }
    public void setIdCustomer(Long idCustomer) { this.idCustomer = idCustomer; }

    public Long getIdState() { return idState; }
    public void setIdState(Long idState) { this.idState = idState; }
}
