package com.uniyaz.core.service;

import com.uniyaz.core.domain.Menu;
import com.uniyaz.ui.page.*;
import org.junit.Test;

import java.util.List;

public class MenuServiceTest {

    @Test
    public void menuEkle() {

        Menu menu = new Menu();
        menu.setBaslik("Sipariş İşlemleri");

        MenuService menuService = new MenuService();
        menuService.save(menu);
    }

    @Test
    public void findAll() {
        MenuService menuService = new MenuService();
        List<Menu> menuList = menuService.findAll();
        for (Menu menu : menuList) {
            System.out.println(menu.getBaslik());
        }
    }

    @Test
    public void altMenuEkle() {

        MenuService menuService = new MenuService();
        Menu ustMenu = menuService.findById(10L);

        Menu menu = new Menu();
        menu.setBaslik("Listele");
        menu.setClassPath(SiparisListePage.class.getName());
        menu.setMenuUst(ustMenu);

        menuService.save(menu);
    }
}