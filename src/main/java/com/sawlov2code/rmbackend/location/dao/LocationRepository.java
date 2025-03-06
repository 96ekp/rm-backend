package com.sawlov2code.rmbackend.location.dao;

import com.sawlov2code.rmbackend.location.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
