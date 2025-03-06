package com.sawlov2code.rmbackend.location.services;

import com.sawlov2code.rmbackend.location.model.Location;

import java.util.List;

public interface LocationService {
    List<Location> getAllLocations();
    Location getLocationById(Long id);
    Location createLocation(Location location);
    Location updateLocation(Long id, Location locationDetails);
    void deleteLocation(Long id);
}
