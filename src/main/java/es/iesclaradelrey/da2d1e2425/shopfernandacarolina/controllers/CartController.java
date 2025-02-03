package es.iesclaradelrey.da2d1e2425.shopfernandacarolina.controllers;

import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities.Product;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities.ProductInCart;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities.Valoration;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.services.ProductInCartService;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final ProductInCartService productInCartService;
    private final ProductService productService;

    public CartController(ProductInCartService productInCartService, ProductService productService) {
        this.productInCartService = productInCartService;
        this.productService = productService;
    }


    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable("id") Long productId) {
        System.out.println("En añadir producto");
        Product p = this.productService.findById(productId);
        ProductInCart productInCart = new ProductInCart(1, LocalDateTime.now(), LocalDateTime.now(), p);
        productInCartService.save(productInCart);

        return "redirect:/productPorNum/" + productId;
    }

    @RequestMapping("/pedido")
    public String showCart(Model model) {
        List<ProductInCart> productosEnCarrito = productInCartService.findAll();
        Double precio = 0.0;
        for (ProductInCart pr : productosEnCarrito) {
            precio += (pr.getCantidad() * pr.getProduct().getPrice());
        }
        model.addAttribute("productosEnCarrito", productosEnCarrito);
        model.addAttribute("precio", precio);
        return "carrito";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long productId) {
        System.out.println("En eliminar producto");
        ProductInCart p = productInCartService.findById(productId);
        productInCartService.delete(p);
        return "redirect:/cart/pedido";
    }


    @GetMapping("/delete/all")
    public String deleteProduct() {
        productInCartService.deleteAllProductInCart();
        return "redirect:/cart/pedido";
    }
}
