package eg.springframework.sfgpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/owners")
public class OwnerController {

    @GetMapping(value = {"", "/index", "/index.html"})
    public String listOwners() {
        return "owners/index";
    }
}
