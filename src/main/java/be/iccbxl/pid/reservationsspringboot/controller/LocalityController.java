package be.iccbxl.pid.reservationsspringboot.controller;

<<<<<<< HEAD
=======
//…

>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
import be.iccbxl.pid.reservationsspringboot.model.Locality;
import be.iccbxl.pid.reservationsspringboot.service.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
@Controller
public class LocalityController {
    @Autowired
    LocalityService service;

<<<<<<< HEAD
    @GetMapping("/dev/localities")
    public String index2(Model model) {
        List<Locality> localities = service.getAll();

        model.addAttribute("localities", localities);
        model.addAttribute("title", "Liste des localités");

        return "locality/index";
    }

    @GetMapping("/dev/localities/{id}")
=======
    //…

    @GetMapping("/localities/{id}")
>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
    public String show(Model model, @PathVariable("id") String id) {
        Locality locality = service.get(id);

        model.addAttribute("locality", locality);
        model.addAttribute("title", "Fiche d'une localité");

        return "locality/show";
    }

}
<<<<<<< HEAD
=======

>>>>>>> b40d85abf2a6b9a0d4520f7c7f16a1e0739abc1a
