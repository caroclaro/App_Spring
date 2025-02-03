package es.iesclaradelrey.da2d1e2425.shopfernandacarolina.controllers;


import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities.Category;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities.Product;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities.Valoration;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.services.CategoryService;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.services.ProductInCartService;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.services.ProductService;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.services.ValorationService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Controller
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final ValorationService valorationService;
    private final ProductInCartService productInCartService;

    public ProductController(ProductService productService, CategoryService categoryService, ValorationService valorationService, ProductInCartService productInCartService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.valorationService = valorationService;
        this.productInCartService = productInCartService;
    }


    @RequestMapping("/todosLosProductos")
    public String products(Model model) {
        List<Product> products = this.productService.findAll();
        Map<Long, Double> medias = new HashMap<>();

        for (Product p : products) {
            List<Valoration> valorations = p.getValorations();
            int cont = 0;
            Double media = 0.0;
            for (Valoration v : valorations) {
                media += v.getValor();
                cont++;
            }
            if (cont > 0) {
                media = media / cont;
            }
            media = (double) (Math.round(media * 100)) / 100;
            medias.put(p.getId(), media);

        }


        model.addAttribute("products", products);
        model.addAttribute("medias", medias);
        return "todosLosProductos";
    }

    @GetMapping("categoria/{id}")
    public String getProducts(@PathVariable Long id, Model model) {
        Map<Long, Double> medias = new HashMap<>();
        Optional<Category> category = this.categoryService.findById(id);
        if (category.isPresent()) {
            model.addAttribute("category", category.get());
            List<Product> products = this.productService.findByCategoryId(id);
            System.out.println(products);

            for (Product p : products) {
                List<Valoration> valorations = p.getValorations();
                int cont = 0;
                Double media = 0.0;
                for (Valoration v : valorations) {
                    media += v.getValor();
                    cont++;
                }
                if (cont > 0) {
                    media = media / cont;
                }
                media = (double) (Math.round(media * 100)) / 100;
                medias.put(p.getId(), media);

            }



            model.addAttribute("medias", medias);
            model.addAttribute("products", products);
            return "categoriaPorNum";

        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/productPorNum/{id}")
    public String getProductsByNumber(@PathVariable Long id, Model model) {
        Product product = this.productService.findById(id);
        if (product != null) {
            model.addAttribute("product", product);
            List<Valoration> valorations = this.valorationService.getValorationsByProductId(id);
            Double media = 0.0;
            int cont = 0;
            for (Valoration valoration : valorations) {
                media += valoration.getValor();
                cont++;
            }
            media = media / cont;
            media = (double) (Math.round(media * 100)) / 100;
            model.addAttribute("valorations", valorations);
            model.addAttribute("media", media);
            model.addAttribute("productInCart", productInCartService);
            return "productPorNum";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);


    }
}
