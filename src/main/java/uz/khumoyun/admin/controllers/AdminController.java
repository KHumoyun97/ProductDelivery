package uz.khumoyun.admin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.khumoyun.admin.service.AdminService;
import uz.khumoyun.persistencelibrary.entities.Admin;

import java.util.List;

@Controller
@RequestMapping("/admins")
@RequiredArgsConstructor
public class AdminController {

  private final AdminService adminService;

    @GetMapping()
    public String places(Model model){
        List<Admin> admins= adminService.findAll();

        model.addAttribute("admins",admins);
        System.out.println(model);
        return "admins/list";
    }

    @GetMapping("/add")
    public String add(Model model){
        System.out.println("Keldi 1 ");
        Admin admin=new Admin();
  //      System.out.println(" User" +admin.getId());
        model.addAttribute("admin",admin);
        return "admins/form";
    }


    @PostMapping("/add")
    public String save(Admin admin, Model model){
        System.out.println(admin);
        adminService.save(admin);
        return "redirect:/admins";
    }

}
