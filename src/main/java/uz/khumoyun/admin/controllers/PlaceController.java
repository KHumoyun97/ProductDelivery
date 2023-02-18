package uz.khumoyun.admin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.khumoyun.admin.service.PlaceService;
import uz.khumoyun.admin.service.RegionServise;
import uz.khumoyun.persistencelibrary.entities.Place;


@Controller
@RequestMapping("/places")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;
    private final RegionServise regionServise;

    @GetMapping
    public String places(Model model){
        model.addAttribute("places",placeService.findAll());
        return "places/places";
    }

    @GetMapping("/add")
    public String add(Model model){

        Place place=new Place();

        model.addAttribute("place",place);
        model.addAttribute("regions",regionServise.findAll());
        return "places/form";
    }

    @PostMapping("/add")
    public String save(Place place,Model model){

        System.out.println(place);
        placeService.save(place);
        return "redirect:/places";
    }

}
