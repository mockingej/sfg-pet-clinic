package eg.springframework.sfgpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/vets")
public class VetController {

    @GetMapping(value = {"", "/index", "/index.html"})
    public String listVets() {
        return "vets/index";
    }

}
