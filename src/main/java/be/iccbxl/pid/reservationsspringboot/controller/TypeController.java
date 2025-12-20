package be.iccbxl.pid.reservationsspringboot.controller;

<<<<<<< HEAD
import be.iccbxl.pid.reservationsspringboot.model.Type;
import be.iccbxl.pid.reservationsspringboot.service.TypeService;
=======
import java.util.List;
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

<<<<<<< HEAD
import java.util.List;

@Controller
public class TypeController {
    @Autowired
    TypeService service;

    @GetMapping("/types")
    public String index2(Model model) {
        List<Type> types = service.getAll();

        model.addAttribute("types", types);
        model.addAttribute("title", "Liste des types");

=======
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
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
        return "type/index";
    }

    @GetMapping("/types/{id}")
<<<<<<< HEAD
    public String show(Model model, @PathVariable("id") String id) {
        Type type = service.getType(id);

        model.addAttribute("type", type);
        model.addAttribute("title", "Fiche d'un type");

        return "type/show";
    }


=======
    public String show(Model model, @PathVariable("id") Long id) {
        Type type = service.get(id);
        if (type == null) {
            return "redirect:/types";
        }
        model.addAttribute("type", type);
        model.addAttribute("title", "Fiche d'un type");
        return "type/show";
    }
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
}
