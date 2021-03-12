package com.uniyaz.core.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * Created by AKARTAL on 12.3.2021.
 */
@Entity
@Table(name = "URUN")
public class Urun extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ADI", nullable = false, length = 100)
    @NotNull
    private String adi;

    @Size(max = 50)
    @Column(length = 50)
    private String kodu;

    @Column(precision = 15, scale = 2)
    private BigDecimal fiyat;

    private Musteri musteri;

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

    public String getKodu() {
        return kodu;
    }

    public void setKodu(String kodu) {
        this.kodu = kodu;
    }

    public BigDecimal getFiyat() {
        return fiyat;
    }

    public void setFiyat(BigDecimal fiyat) {
        this.fiyat = fiyat;
    }
}
