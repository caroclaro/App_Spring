package es.iesclaradelrey.da2d1e2425.shopfernandacarolina.controllers;

import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities.Category;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities.Product;
import org.springframework.ui.Model;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
@RequestMapping({" ", "/"})

public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @RequestMapping("/categoria")
    public String categoria(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "buscando";
    }


}


