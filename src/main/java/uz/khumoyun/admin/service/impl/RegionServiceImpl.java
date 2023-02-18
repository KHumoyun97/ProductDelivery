package uz.khumoyun.admin.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.khumoyun.persistencelibrary.repository.RegionRepository;
import uz.khumoyun.admin.service.RegionServise;
import uz.khumoyun.persistencelibrary.entities.Region;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionServise {

    private final RegionRepository regionRepository;

    @Override
    public Region save(Region region) {
        return regionRepository.save(region);
    }

    @Override
    public List<Region> findAll() {
        return (List<Region>) regionRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        regionRepository.deleteById(id);
    }

    @Override
    public Region findById(Long id) {
        return regionRepository.findById(id).get();
    }
}
