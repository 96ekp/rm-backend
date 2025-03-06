package com.sawlov2code.rmbackend.menu.services;

import com.sawlov2code.rmbackend.menu.model.Menu;

import java.util.List;

public interface MenuService {
    Menu createMenu(Menu menu);
    Menu updateMenu(Long id, Menu menuDetails);
    Menu findMenuById(Long id);
    void deleteMenu(Long id);
    List<Menu> getAllMenus();

}
