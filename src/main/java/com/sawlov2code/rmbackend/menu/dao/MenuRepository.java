package com.sawlov2code.rmbackend.menu.dao;


import com.sawlov2code.rmbackend.menu.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

}
