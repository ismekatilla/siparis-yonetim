package com.uniyaz.ui.page;

import com.uniyaz.core.domain.EnumCinsiyet;
import com.uniyaz.core.domain.Musteri;
import com.uniyaz.core.service.MusteriService;
import com.uniyaz.ui.SyUI;
import com.uniyaz.ui.component.ContentComponent;
import com.uniyaz.ui.component.SyEditButton;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.window.WindowMode;
import com.vaadin.ui.*;

import java.util.List;

/**
 * Created by AKARTAL on 12.3.2021.
 */
public class MusteriListePage extends VerticalLayout {

    private VerticalLayout mainLayout;
    private Table table;
    private Container container;

    public MusteriListePage() {

        setSizeFull();
        buildMainLayout();
        addComponent(mainLayout);

        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);

        fillTable();
    }

    private void buildMainLayout() {

        mainLayout = new VerticalLayout();
        mainLayout.setSizeUndefined();

        buildTable();
        mainLayout.addComponent(table);
    }

    private void buildTable() {

        table = new Table();
        table.setSelectable(true);

        buildContainer();
        table.setContainerDataSource(container);
        table.setColumnHeaders("ID", "ÜNVAN", "CİNSİYET", "", "", "");
    }

    private void buildContainer() {

        container = new IndexedContainer();
        container.addContainerProperty("id", Long.class, null);
        container.addContainerProperty("unvan", String.class, null);
        container.addContainerProperty("cinsiyet", EnumCinsiyet.class, null);
        container.addContainerProperty("guncelle", SyEditButton.class, null);
        container.addContainerProperty("secim", Button.class, null);
        container.addContainerProperty("siparis", Button.class, null);
    }

    private void fillTable() {

        MusteriService musteriService = new MusteriService();
        List<Musteri> musteriList = musteriService.findAll();
        for (Musteri musteri : musteriList) {
            Item item = container.addItem(musteri);
            item.getItemProperty("id").setValue(musteri.getId());
            item.getItemProperty("unvan").setValue(musteri.getUnvan());
            item.getItemProperty("cinsiyet").setValue(musteri.getCinsiyet());

            SyEditButton guncelle = buildGuncelleButton(musteri);
            item.getItemProperty("guncelle").setValue(guncelle);

            Button secim = buildSecimButton(musteri);
            item.getItemProperty("secim").setValue(secim);

            Button siparisButton = buildSiparisButton(musteri);
            item.getItemProperty("siparis").setValue(siparisButton);
        }
    }

    private Button buildSecimButton(Musteri musteri) {

        Button secim = new Button();
        secim.setIcon(FontAwesome.CHECK);
        secim.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                SyUI syUI = (SyUI) SyUI.getCurrent();
                syUI.setMusteri(musteri);
            }
        });
        return secim;
    }

    private SyEditButton buildGuncelleButton(final Musteri musteri) {
        SyEditButton guncelle = new SyEditButton();
        guncelle.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                SyUI syUI = (SyUI) SyUI.getCurrent();
                ContentComponent contentComponent = syUI.getContentComponent();

                MusteriPage musteriPage = new MusteriPage(musteri);
                contentComponent.addComponent(musteriPage);
            }
        });
        return guncelle;
    }

    private Button buildSiparisButton(Musteri musteri) {
        Button siparisButton = new Button();
        siparisButton.setIcon(FontAwesome.SHOPPING_BASKET);
        siparisButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                SiparisListePage siparisListePage = new SiparisListePage(musteri);
                Window window = new Window();
                window.setCaption("Siparişler");
                window.setClosable(true);
                window.setWindowMode(WindowMode.NORMAL);
                window.setWidth(30, Unit.PERCENTAGE);
                window.setHeight(30, Unit.PERCENTAGE);
                window.setResizable(true);
                window.center();
                window.setContent(siparisListePage);

                SyUI syUI = (SyUI) SyUI.getCurrent();
                syUI.addWindow(window);
            }
        });
        return siparisButton;
    }

    public Table getTable() {
        return table;
    }
}