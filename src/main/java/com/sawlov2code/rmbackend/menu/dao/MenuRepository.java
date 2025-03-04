package com.sawlov2code.rmbackend.menu.dao;


import com.sawlov2code.rmbackend.menu.model.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    Page<Menu> findAll(Pageable pageable);
}
