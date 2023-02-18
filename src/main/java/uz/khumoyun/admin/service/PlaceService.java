package uz.khumoyun.admin.service;


import uz.khumoyun.persistencelibrary.entities.Place;

import java.util.List;

public interface PlaceService {
    Place save(Place Place);

    List<Place> findAll();
}
