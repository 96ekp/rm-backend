package com.sawlov2code.rmbackend.location.services;

import com.sawlov2code.rmbackend.location.dao.LocationRepository;
import com.sawlov2code.rmbackend.location.model.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }


    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Location getLocationById(Long id) {
        return locationRepository.findById(id).orElseThrow(() -> new RuntimeException("Location not found"));
    }

    @Override
    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location updateLocation(Long id, Location locationDetails) {
        Location location = locationRepository.findById(id).orElseThrow(() -> new RuntimeException("Location not found"));
        location.setAddress(locationDetails.getAddress());
        location.setCity(locationDetails.getCity());
        location.setProvince(locationDetails.getProvince());
        location.setPost_code(locationDetails.getPost_code());
        location.setCountry(locationDetails.getCountry());
        return locationRepository.save(location);
    }

    @Override
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
