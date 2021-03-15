package com.uniyaz.core.domain;

import javax.persistence.*;

/**
 * Created by AKARTAL on 15.3.2021.
 */
@Entity
@Table(name = "MUSTERI_URUN")
public class MusteriUrun extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_MUSTERI", foreignKey = @ForeignKey(name = "FK_MUSTERI_URUN_MUSTERI"))
    private Musteri musteri;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_URUN", foreignKey = @ForeignKey(name = "FK_MUSTERI_URUN_URUN"))
    private Urun urun;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }

    public Urun getUrun() {
        return urun;
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
    }
}
