package com.uniyaz.core.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by AKARTAL on 12.3.2021.
 */
@Entity
@Table(name = "MUSTERI")
public class Musteri extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ADI", nullable = false, length = 100)
    @NotNull
    private String adi;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private EnumCinsiyet cinsiyet;

    @Transient
    private String unvan;

    @Column(length = 100)
    private String adres;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public EnumCinsiyet getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(EnumCinsiyet cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getUnvan() {
        if (EnumCinsiyet.BAY.equals(cinsiyet)) return "Bay " + getAdi();
        else if (EnumCinsiyet.BAYAN.equals(cinsiyet)) return "Bayan " + getAdi();
        else return getAdi();
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}