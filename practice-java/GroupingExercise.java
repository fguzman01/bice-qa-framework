import java.util.*;
import java.util.stream.*;

public class GroupingExercise {

    record Product(String name, String category, double price) {}

    public static void main(String[] args) {
        List<Product> products = List.of(
            new Product("Sauce Labs Backpack", "Bags", 29.99),
            new Product("Sauce Labs Bike Light", "Accessories", 9.99),
            new Product("Sauce Labs Bolt T-Shirt", "Clothing", 15.99),
            new Product("Sauce Labs Fleece Jacket", "Clothing", 49.99),
            new Product("Sauce Labs Onesie", "Clothing", 7.99),
            new Product("Test.allTheThings() T-Shirt", "Clothing", 15.99)
        );

        // TODO 1: Agrupar los productos por categoría
         Map<String, List<Product>> productsByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::category));
        // Resultado esperado: Map<String, List<Product>>
        
        // TODO 2: Imprimir cada categoría con la cantidad de productos que tiene
        System.out.println("--- Cantidad de productos por categoría ---");
        productsByCategory.forEach((category, list) -> 
            System.out.println("Categoría: " + category + " | Cantidad: " + list.size())
        );

        //todo 3
        Map<String, Double> avgPriceByCategory = products.stream()
        .collect(Collectors.groupingBy(Product::category, Collectors.averagingDouble(Product::price)));
        System.out.println("--- Precio promedio por categoria ---");
        avgPriceByCategory.forEach((category, avg) -> 
            System.out.println("Categoria: " + category + " | Promedio: $" + avg)
        );
        
    }
}
