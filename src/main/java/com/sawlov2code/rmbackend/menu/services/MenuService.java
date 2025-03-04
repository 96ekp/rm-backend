package com.sawlov2code.rmbackend.menu.services;

import com.sawlov2code.rmbackend.menu.model.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MenuService {
    Menu createMenu(Menu menu);
    Menu updateMenu(Long id, Menu menuDetails);
    Menu findMenuById(Long id);
    void deleteMenu(Long id);
    Page<Menu> getMenus(Pageable pageable);

}
