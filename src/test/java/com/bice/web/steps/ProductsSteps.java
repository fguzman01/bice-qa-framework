package com.bice.web.steps;

import com.bice.pages.ProductsPage;
import io.cucumber.java.en.Then;

import java.util.List;

public class ProductsSteps {

    @Then("se deben listar todos los productos disponibles")
    public void seDebenListarTodosLosProductos() {
        ProductsPage productsPage = new ProductsPage();
        List<ProductsPage.Product> products = productsPage.getAllProducts();
        assert !products.isEmpty(): "No se encontraron productos";
        System.out.println("[TOTAL] Productos encontrados: " + products.size());
    }

    
}
