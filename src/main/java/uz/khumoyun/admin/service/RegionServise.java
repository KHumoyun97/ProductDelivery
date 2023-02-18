package uz.khumoyun.admin.service;

import uz.khumoyun.persistencelibrary.entities.Region;

import java.util.List;

public interface RegionServise {
    Region save(Region region);

    List<Region> findAll();

    void deleteById(Long id);

    Region findById(Long id);
}
