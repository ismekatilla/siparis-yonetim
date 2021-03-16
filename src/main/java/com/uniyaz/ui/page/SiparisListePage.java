package com.uniyaz.ui.page;

import com.uniyaz.core.domain.Musteri;
import com.uniyaz.core.domain.MusteriUrun;
import com.uniyaz.core.service.MusteriUrunService;
import com.uniyaz.ui.SyUI;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by AKARTAL on 15.3.2021.
 */
public class SiparisListePage extends BasePage {

    private VerticalLayout mainLayout;
    private Table table;
    private Container container;

    public SiparisListePage() {
        SyUI syUI = (SyUI) SyUI.getCurrent();
        Musteri musteri = syUI.getMusteri();
        fillPageByMusteri(musteri);
    }

    public SiparisListePage(Musteri musteri) {
        fillPageByMusteri(musteri);
    }

    private void fillPageByMusteri(Musteri musteri) {
        MusteriUrunService musteriUrunService = new MusteriUrunService();
        List<MusteriUrun> musteriUrunList = musteriUrunService.findByMusteriId(musteri.getId());
        fillTable(musteriUrunList);
    }

    @Override
    public void buildMainLayout() {

        mainLayout = new VerticalLayout();
        mainLayout.setSizeUndefined();
        addComponent(mainLayout);
        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);

        buildTable();
        mainLayout.addComponent(table);
        mainLayout.setComponentAlignment(table, Alignment.MIDDLE_CENTER);
    }

    private void buildTable() {
        table = new Table();

        buildContainer();
        table.setContainerDataSource(container);
        table.setColumnHeaders("ID", "MÜŞTERİ", "ÜRÜN", "FİYAT");
    }

    private void buildContainer() {

        container = new IndexedContainer();
        container.addContainerProperty("id", Long.class, null);
        container.addContainerProperty("musteri", String.class, null);
        container.addContainerProperty("urun", String.class, null);
        container.addContainerProperty("fiyat", BigDecimal.class, null);
    }

    private void fillTable(List<MusteriUrun> musteriUrunList) {

        for (MusteriUrun musteriUrun : musteriUrunList) {
            Item item = container.addItem(musteriUrun);
            item.getItemProperty("id").setValue(musteriUrun.getId());
            item.getItemProperty("musteri").setValue(musteriUrun.getMusteri().getAdi());
            item.getItemProperty("urun").setValue(musteriUrun.getUrun().getAdi());
            item.getItemProperty("fiyat").setValue(musteriUrun.getUrun().getFiyat());
        }
    }
}