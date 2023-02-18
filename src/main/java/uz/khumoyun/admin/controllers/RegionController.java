package uz.khumoyun.admin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.khumoyun.admin.service.RegionServise;
import uz.khumoyun.persistencelibrary.entities.Region;

import java.util.List;

@Controller
@RequestMapping("/regions")
@RequiredArgsConstructor
public class RegionController {

    private final RegionServise regionServise;

    @GetMapping
    public String places(Model model) {

        List<Region> regions= regionServise.findAll();
        model.addAttribute("regions",regions);
        return "regions/regions";
    }

    @GetMapping("/add")
    public String add(Model model) {

       Region region=new Region();
        model.addAttribute("region",region);
        return "regions/form";
    }

    @PostMapping ("/add")
    public String save(Region region,Model model) {

        System.out.println(region);
        regionServise.save(region);
        return "redirect:/regions";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        System.out.println(id);
        Region region=regionServise.findById(id);
        model.addAttribute("regions",region);
        return "regions/form";
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id) {
        System.out.println(id);
        regionServise.deleteById(id);
        System.out.println(" ****** ochirdi ******");
        return "redirect:/regions";
    }
}
