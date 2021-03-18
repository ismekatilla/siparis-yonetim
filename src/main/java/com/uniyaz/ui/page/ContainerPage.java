package com.uniyaz.ui.page;

import com.uniyaz.common.exceptions.SyException;
import com.uniyaz.core.domain.Musteri;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by AKARTAL on 17.3.2021.
 */
public class ContainerPage extends BasePage {

    private VerticalLayout mainLayout;
    private TabSheet tabSheet;
    private Musteri musteri;
    private MusteriListePage musteriListePage;
    private SiparisListePage siparisListePage;
    private TabSheet.Tab musteriTab;
    private TabSheet.Tab siparisTab;

    public ContainerPage() {
        addComponent(mainLayout);
    }

    @Override
    public void buildMainLayout() {

        mainLayout = new VerticalLayout();
        mainLayout.setSizeFull();

        buildTabSheet();
        mainLayout.addComponent(tabSheet);
    }

    private void buildTabSheet() {
        
        tabSheet = new TabSheet();
        tabSheet.addSelectedTabChangeListener(new TabSheet.SelectedTabChangeListener() {
            @Override
            public void selectedTabChange(TabSheet.SelectedTabChangeEvent selectedTabChangeEvent) {
                if (musteri == null && selectedTabChangeEvent.getTabSheet().getSelectedTab() instanceof SiparisListePage) {
                    tabSheet.setSelectedTab(musteriTab);
                    throw new SyException("Müşteri Seçmelisiniz");
                }
            }
        });

        musteriListePage = new MusteriListePage();
        musteriTab = tabSheet.addTab(musteriListePage);
        musteriListePage.getTable().addItemClickListener(new ItemClickEvent.ItemClickListener() {
            @Override
            public void itemClick(ItemClickEvent itemClickEvent) {
                musteri = (Musteri) itemClickEvent.getItemId();

                if (musteri == null) {
                    tabSheet.setSelectedTab(musteriTab);
                    throw new SyException("Müşteri Seçmelisiniz");
                }

                siparisListePage.fillPageByMusteri(musteri);

            }
        });
        musteriTab.setCaption("Müşteri");


        siparisListePage = new SiparisListePage();
        siparisTab = tabSheet.addTab(siparisListePage);
        siparisTab.setCaption("Sipariş");
    }
}
