package com.sawlov2code.rmbackend.menu.services;

import com.sawlov2code.rmbackend.exception.MenuNotFoundException;
import com.sawlov2code.rmbackend.menu.dao.MenuRepository;
import com.sawlov2code.rmbackend.menu.model.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class MenuServiceImpl implements MenuService {
    private final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);
    private final MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    @Transactional
    public Menu createMenu(Menu menu) {
        logger.info("Creating new menu: {}", menu.getMenu_name());
        return menuRepository.save(menu);
    }

    @Override
    @Transactional
    public Menu updateMenu(Long id, Menu menuDetails) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new MenuNotFoundException("Menu not found with id: " + id));
        menu.setMenu_name(menuDetails.getMenu_name());
        menu.setImageUrl(menuDetails.getImageUrl());
        menu.setAi_generated(menuDetails.getAi_generated());
        logger.info("Updating menu with id: {}", id);
        return menuRepository.save(menu);
    }
    @Override
    public Menu findMenuById(Long id) {
        logger.info("Finding menu with id: {}", id);
        return menuRepository.findById(id)
                .orElseThrow(() -> new MenuNotFoundException("Menu not found with id: " + id));
    }

    @Override
    @Transactional
    public void deleteMenu(Long id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new MenuNotFoundException("Menu not found with id: " + id));
        menuRepository.delete(menu);
        logger.info("Deleting menu with id: {}", id);
    }


    @Override
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }


}
