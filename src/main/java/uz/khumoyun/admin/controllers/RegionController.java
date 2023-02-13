package uz.khumoyun.admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.khumoyun.entities.Place;

import java.util.List;

@Controller
@RequestMapping("/places")
public class PlaceController {



    @GetMapping
    public String places(Model model){

        List<Place>places= List.of(
            new Place(1L,"Yunusobod"),
            new Place(2L,"Chilonzor")
    );


        model.addAttribute("places",places);
        return "places";
    }
}
