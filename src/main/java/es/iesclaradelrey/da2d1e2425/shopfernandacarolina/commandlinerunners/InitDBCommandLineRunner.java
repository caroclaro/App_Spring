package es.iesclaradelrey.da2d1e2425.shopfernandacarolina.commandlinerunners;

import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities.Category;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities.Product;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities.ProductInCart;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.entities.Valoration;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.services.CategoryServiceImpl;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.services.ProductInCartServiceImpl;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.services.ProductService;
import es.iesclaradelrey.da2d1e2425.shopfernandacarolina.services.ValorationServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class InitDBCommandLineRunner implements CommandLineRunner {
    private final ProductService productService;
    private final CategoryServiceImpl categoryService;
    private final ProductInCartServiceImpl productInCartService;
    private final ValorationServiceImpl valorationService;

    public InitDBCommandLineRunner(ProductService productService, CategoryServiceImpl categoryService, ProductInCartServiceImpl productInCartService, ValorationServiceImpl valorationService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.productInCartService = productInCartService;
        this.valorationService = valorationService;
    }


    @Override
    public void run(String... args) throws Exception {
        Category exterior = categoryService.save(new Category("Exterior", "Embellece tu jardín con nuestra selección de plantas de exterior robustas y vibrantes.", "/img/plantasExterior.jpg"));
        Category arboles = categoryService.save(new Category("Árboles", "Explora nuestra variedad de árboles que añadirán vida y sombra a tu jardín.", "/img/arbol.jpg"));
        Category interior = categoryService.save(new Category("Interiores", "Descubre nuestras plantas de interior que alegrarán cualquier espacio.", "/img/plantasInterior.jpg"));
        Category tools = categoryService.save(new Category("Tools", "Encuentra las herramientas perfectas para mantener tu jardín en óptimas condiciones.", "/img/herramientas.jpg"));

        Product peral = productService.save(new Product("Peral", " El Peral es un árbol frutal que ofrece deliciosas peras. Ideal para jardines o huertos caseros, sus flores blancas y follaje lo hacen perfecto para embellecer tu espacio exterior.\n", "/img/peral.jpg", 18, arboles));
        Product cactus = productService.save(new Product("Cactus", "El Cactus es una planta resistente que se adapta a climas secos. Con espinas y una apariencia única, es perfecta para jardines de bajo mantenimiento o espacios interiores con poca agua.", "/img/cactus.jpg", 6, exterior));
        Product orquideas = productService.save(new Product("Orquídeas", "Las Orquídeas son flores exóticas y hermosas. Con una fragancia suave y colores variados, son ideales para decorar interiores y agregar un toque de elegancia a cualquier espacio.", "/img/orquideas.jpg", 4, exterior));
        Product helecho = productService.save(new Product("Helecho", "El Helecho es perfecto para interiores. Su follaje verde purifica el aire y es ideal para lugares con poca luz, creando un ambiente fresco y relajante en tu hogar u oficina. ", "/img/helecho.jpg", 3, interior));
        Product pothos = productService.save(new Product("Pothos", "El Pothos es una planta trepadora fácil de cuidar. Con hojas en forma de corazón, es ideal para interiores con poca luz y es resistente a condiciones adversas. ", "/img/photos.jpg", 2, interior));
        Product macetas = productService.save(new Product("Macetas", "Las Macetas son esenciales para el cultivo de plantas. Disponibles en varios tamaños, proporcionan espacio adecuado para el crecimiento y desarrollo de las raíces de tus plantas favoritas. ", "/img/herramientas.jpg", 4, tools));
        Product abono = productService.save(new Product("Abono", "El Abono nutre el suelo, ayudando a que tus plantas crezcan saludables y fuertes. Ideal para mejorar la calidad del suelo y promover un jardín vibrante y lleno de vida. ", "/img/abono.jpg", 5, tools));
        Product palmera = productService.save(new Product("Palmera", "La Palmera es una planta tropical que aporta un toque exótico a tu jardín o interior. Con sus elegantes hojas, es ideal para exteriores soleados y de bajo mantenimiento.", "/img/palmera.jpg", 25, arboles));


        valorationService.save(new Valoration(4.5, "Juan Pérez", "Excelente producto, lo recomiendo mucho.", LocalDateTime.now(), palmera));
        valorationService.save(new Valoration(3.8, "María López", "Buen producto, pero podría mejorar en calidad.", LocalDateTime.now(), palmera));
        valorationService.save(new Valoration(5.0, "Carlos García", "Perfecto, superó mis expectativas.", LocalDateTime.now(), palmera));
        valorationService.save(new Valoration(2.5, "Ana Martínez", "No me gustó, el producto no cumplió con lo esperado.", LocalDateTime.now(), palmera));
        valorationService.save(new Valoration(4.0, "Luis Sánchez", "Buen producto, pero tardó en llegar.", LocalDateTime.now(), palmera));
        valorationService.save(new Valoration(3.0, "Patricia Rodríguez", "Aceptable, pero no lo volvería a comprar.", LocalDateTime.now(), palmera));
//        valorationService.save(new Valoration(3.0, "Patricia Rodríguez", "Aceptable, pero no lo volvería a comprar. El producto cumple con lo que promete, aunque tiene algunos detalles que podrían mejorarse. La calidad es promedio y el diseño no es tan atractivo como se muestra en las fotos del sitio web. Además, la entrega fue algo lenta y el embalaje podría haber sido más cuidadoso. A pesar de estos inconvenientes, el precio es razonable para lo que ofrece, y tal vez podría ser útil para aquellos que no buscan algo de alta gama. En resumen, aunque no es una compra que repetiría, no es una mala opción si se busca algo funcional sin muchas expectativas. Para mejorar, recomendaría trabajar en la calidad de los materiales y mejorar la presentación del producto.", LocalDateTime.now(), p1));


        valorationService.save(new Valoration(5.0, "Pedro González", "El Peral es un excelente producto, muy resistente.", LocalDateTime.now(), peral));
        valorationService.save(new Valoration(4.2, "Lucía Fernández", "Me encantó el Peral, aunque venía con algunas hojas secas.", LocalDateTime.now(), peral));
        valorationService.save(new Valoration(3.5, "Carlos Martínez", "El Peral está bien, pero no es tan robusto como esperaba.", LocalDateTime.now(), peral));
        valorationService.save(new Valoration(2.0, "Isabel Ruiz", "No me gustó, el Peral llegó algo dañado y no creció como esperaba.", LocalDateTime.now(), peral));

        valorationService.save(new Valoration(4.7, "Marta Jiménez", "El Cactus es una planta realmente atractiva, su diseño único le da un toque especial a cualquier ambiente. Además, es muy resistente, lo cual lo hace perfecto para interiores, ya que requiere poco mantenimiento. Lo tengo en casa desde hace varias semanas y sigue luciendo igual de bien. La calidad del producto es excelente, y la atención al cliente también fue de primer nivel. Totalmente recomendable para quienes buscan una planta de bajo cuidado pero que aporte frescura y estilo al espacio.", LocalDateTime.now(), cactus));

//        valorationService.save(new Valoration(4.7, "Marta Jiménez", "El Cactus es muy bonito y resistente. Perfecto para interiores.", LocalDateTime.now(), cactus));
        valorationService.save(new Valoration(3.9, "José Rodríguez", "Buen producto, pero tardó en llegar.", LocalDateTime.now(), cactus));
        valorationService.save(new Valoration(2.5, "Ana González", "No fue lo que esperaba, el Cactus estaba más pequeño de lo que se muestra en la foto.", LocalDateTime.now(), cactus));
        valorationService.save(new Valoration(5.0, "Laura Sánchez", "Perfecto para mi hogar, el Cactus llegó en excelente estado.", LocalDateTime.now(), cactus));

        valorationService.save(new Valoration(4.8, "Patricia Rodríguez", "Las Orquídeas llegaron preciosas y en perfecto estado.", LocalDateTime.now(), orquideas));
        valorationService.save(new Valoration(3.7, "Roberto Martínez", "Las Orquídeas son bonitas, pero una llegó con algunas flores marchitas.", LocalDateTime.now(), orquideas));
        valorationService.save(new Valoration(4.0, "Elena García", "Muy buenas Orquídeas, aunque algunas ramas estaban un poco débiles.", LocalDateTime.now(), orquideas));
        valorationService.save(new Valoration(1.5, "Carlos López", "Las Orquídeas llegaron en muy mal estado, no las recomendaría.", LocalDateTime.now(), orquideas));


        valorationService.save(new Valoration(3.5, "Luis Sánchez", "El Helecho estaba algo seco al llegar, pero lo recuperé con cuidado.", LocalDateTime.now(), helecho));
        valorationService.save(new Valoration(4.1, "Juan Pérez", "El Helecho llegó bastante bien y ha crecido mucho desde entonces.", LocalDateTime.now(), helecho));
        valorationService.save(new Valoration(2.8, "María López", "El Helecho no estaba tan saludable como pensé, algunas hojas se secaron rápido.", LocalDateTime.now(), helecho));
        valorationService.save(new Valoration(5.0, "Patricia Rodríguez", "Perfecto, un Helecho precioso y lleno de vida.", LocalDateTime.now(), helecho));


        valorationService.save(new Valoration(4.5, "José Pérez", "El Pothos es hermoso y crece rápido. Muy recomendable.", LocalDateTime.now(), pothos));
        valorationService.save(new Valoration(3.8, "Ana Martínez", "El Pothos llegó bien, aunque no estaba tan frondoso como esperaba.", LocalDateTime.now(), pothos));
        valorationService.save(new Valoration(4.2, "Carlos García", "Buen producto, el Pothos se adapta perfectamente al interior.", LocalDateTime.now(), pothos));
        valorationService.save(new Valoration(2.5, "Lucía Fernández", "El Pothos no estuvo en buen estado al llegar, algunas hojas se cayeron.", LocalDateTime.now(), pothos));

        valorationService.save(new Valoration(5.0, "José Martínez", "Excelente calidad en las Macetas, resistentes y prácticas.", LocalDateTime.now(), macetas));
        valorationService.save(new Valoration(4.2, "Isabel Sánchez", "Muy buenas Macetas, aunque un poco caras para el tamaño.", LocalDateTime.now(), macetas));
        valorationService.save(new Valoration(3.5, "Patricia Gómez", "Macetas buenas, pero no son tan estéticas como esperaba.", LocalDateTime.now(), macetas));
        valorationService.save(new Valoration(4.0, "Raúl López", "Macetas bastante buenas, cumplen su función, pero no son tan robustas.", LocalDateTime.now(), macetas));


        valorationService.save(new Valoration(4.9, "Elena García", "El Abono es muy eficaz, mis plantas mejoraron mucho.", LocalDateTime.now(), abono));
        valorationService.save(new Valoration(3.8, "Laura Ruiz", "Buen Abono, pero podría tener un poco más de nutrientes.", LocalDateTime.now(), abono));
        valorationService.save(new Valoration(2.0, "Carlos Jiménez", "El Abono no tuvo buenos resultados en mis plantas, no lo volvería a comprar.", LocalDateTime.now(), abono));
        valorationService.save(new Valoration(4.3, "Juan Pérez", "Buen producto, mis plantas se han recuperado con este Abono.", LocalDateTime.now(), abono));


    }
}
