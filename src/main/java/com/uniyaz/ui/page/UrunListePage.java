package com.uniyaz.ui.page;

import com.uniyaz.core.domain.Urun;
import com.uniyaz.core.service.UrunService;
import com.uniyaz.ui.SyUI;
import com.uniyaz.ui.component.ContentComponent;
import com.uniyaz.ui.component.SyEditButton;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by AKARTAL on 12.3.2021.
 */
public class UrunListePage extends VerticalLayout {

    private VerticalLayout mainLayout;
    private Table table;
    private Container container;

    public UrunListePage() {

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

        buildContainer();
        table.setContainerDataSource(container);
        table.setColumnHeaders("ID", "ADI", "KODU", "FİYAT", "");
    }

    private void buildContainer() {

        container = new IndexedContainer();
        container.addContainerProperty("id", Long.class, null);
        container.addContainerProperty("adi", String.class, null);
        container.addContainerProperty("kodu", String.class, null);
        container.addContainerProperty("fiyat", BigDecimal.class, null);
        container.addContainerProperty("guncelle", SyEditButton.class, null);
    }

    private void fillTable() {

        UrunService urunService = new UrunService();
        List<Urun> urunList = urunService.findAllHql();
        for (Urun urun : urunList) {
            Item item = container.addItem(urun);
            item.getItemProperty("id").setValue(urun.getId());
            item.getItemProperty("adi").setValue(urun.getAdi());
            item.getItemProperty("kodu").setValue(urun.getKodu());
            item.getItemProperty("fiyat").setValue(urun.getFiyat());

            SyEditButton guncelle = new SyEditButton();
            guncelle.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent clickEvent) {

                    SyUI syUI = (SyUI) SyUI.getCurrent();
                    ContentComponent contentComponent = syUI.getContentComponent();

                    UrunPage urunPage = new UrunPage(urun);
                    contentComponent.addComponent(urunPage);
                }
            });
            item.getItemProperty("guncelle").setValue(guncelle);
        }
    }
}
