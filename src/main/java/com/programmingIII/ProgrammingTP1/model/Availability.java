package com.programmingIII.ProgrammingTP1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "availability")
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_availability")
    private Integer idAvailability;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_from_hour", referencedColumnName = "id_hour")
    private Hour fromHour;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_until_hour", referencedColumnName = "id_hour")
    private Hour untilHour;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_week", referencedColumnName = "id_week")
    private Week week;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_provider", referencedColumnName = "id_provider")
    private Provider provider;

    public Availability() {}

    public int getIdAvailability() {
        return idAvailability;
    }

    public void setIdAvailability(Integer idAvailability) {
        this.idAvailability = idAvailability;
    }

    public Hour getFromHour() {
        return fromHour;
    }

    public void setFromHour(Hour fromHour) {
        this.fromHour = fromHour;
    }

    public Hour getUntilHour() {
        return untilHour;
    }

    public void setUntilHour(Hour untilHour) {
        this.untilHour = untilHour;
    }

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
