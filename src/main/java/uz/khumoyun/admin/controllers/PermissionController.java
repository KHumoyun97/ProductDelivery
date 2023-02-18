package uz.khumoyun.admin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import uz.khumoyun.admin.service.PermissionService;
import uz.khumoyun.persistencelibrary.entities.Permission;

import javax.validation.Valid;


@Controller
@RequestMapping("/permissions")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    @GetMapping()
    public String places(Model model) {
        model.addAttribute( "permissions", permissionService.findAll());
        return "permissions/list";
    }
    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("permission", new Permission());
        return "permissions/form";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id,  Model model) {
        System.out.println(id);
        Permission permission=permissionService.findById(id);
        model.addAttribute("permission",permission);
        return "permissions/form";
    }


    @PostMapping ("/save")
    public String save(@Valid Permission permission, Errors errors, Model model) {
        System.out.println(errors.hasErrors());
        System.out.println(errors.getAllErrors());
        if (errors.hasErrors()){
            return "permissions/form";
        }

        System.out.println(permission);
        permissionService.save(permission);
        return "redirect:/permissions";
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public boolean delete(@PathVariable Long id) {
        System.out.println(id);
        permissionService.deleteById(id);
        System.out.println("deleted");
        return true;
    }


}
