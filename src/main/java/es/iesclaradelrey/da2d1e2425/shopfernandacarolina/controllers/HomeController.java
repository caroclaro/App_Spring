package es.iesclaradelrey.da2d1e2425.shopfernandacarolina.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping({" ", "/"})
    public String HomeController() {
        return "index.html";

    }


    @RequestMapping("/ofertas")
    public String ofertas(Model model) {
        return "categoriaPorNum";
    }


    @RequestMapping("/sobreNosotros")
    public String us(Model model) {
        return "sobreNosotros";
    }


    @RequestMapping("/contactanos")
    public String contact(Model model) {
        return "contactanos";
    }

    @RequestMapping("/cart")
    public String carrito(Model model) {
        return "carrito";
    }
}
