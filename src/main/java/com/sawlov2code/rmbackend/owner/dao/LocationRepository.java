package com.sawlov2code.rmbackend.owner.dao;

import com.sawlov2code.rmbackend.owner.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
