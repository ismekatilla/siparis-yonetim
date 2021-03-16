package com.uniyaz.core.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by AKARTAL on 12.3.2021.
 */
@Entity
@Table(name = "MENU")
public class Menu extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "BASLIK", nullable = false, length = 30)
    @NotNull
    private String baslik;

    @Column(length = 100)
    private String classPath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_UST", foreignKey = @ForeignKey(name = "FK_MENU_MENU"))
    private Menu menuUst;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    public Menu getMenuUst() {
        return menuUst;
    }

    public void setMenuUst(Menu menuUst) {
        this.menuUst = menuUst;
    }
}