package be.iccbxl.pid.reservationsspringboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import be.iccbxl.pid.reservationsspringboot.model.Type;
import be.iccbxl.pid.reservationsspringboot.service.TypeService;

@Controller
public class TypeController {

    private final TypeService service;

    @Autowired
    public TypeController(TypeService service) {
        this.service = service;
    }

    @GetMapping("/types")
    public String index(Model model) {
        List<Type> types = service.getAll();
        model.addAttribute("types", types);
        model.addAttribute("title", "Liste des types");
        return "type/index";
    }

    @GetMapping("/types/{id}")
    public String show(Model model, @PathVariable("id") Long id) {
        Type type = service.get(id);
        if (type == null) {
            return "redirect:/types";
        }
        model.addAttribute("type", type);
        model.addAttribute("title", "Fiche d'un type");
        return "type/show";
    }
}
