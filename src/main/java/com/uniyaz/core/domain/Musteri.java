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
}