package uz.khumoyun.admin.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.khumoyun.admin.service.PlaceService;
import uz.khumoyun.persistencelibrary.entities.Place;
import uz.khumoyun.persistencelibrary.repository.PlaceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;

    @Override
    public Place save(Place place) {
        return placeRepository.save(place);
    }

    @Override
    public List<Place> findAll() {
        return (List<Place>) placeRepository.findAll();
    }
}
