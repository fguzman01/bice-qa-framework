package com.bice.web.steps;

import com.bice.pages.ProductsPage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.util.List;

public class ProductsSteps {
    private ProductsPage productsPage = new ProductsPage();

    @Then("se deben listar todos los productos disponibles")
    public void seDebenListarTodosLosProductos() throws InterruptedException {
        List<ProductsPage.Product> products = productsPage.getAllProducts();
        assert !products.isEmpty(): "No se encontraron productos";
        System.out.println("[TOTAL] Productos encontrados: " + products.size());
        Thread.sleep(1000);
    }

    @When("busca el producto {string} y lo agrega al carrito")
    public void buscaElProductoYLoAgregaAlCarrito(String productName) throws InterruptedException{
        productsPage.addProductToCartByName(productName);
        Thread.sleep(1000);

    }

    @Then("el carrito debe tener {int} producto")
    public void elCarritoDebeTener(int expectedCount) throws InterruptedException {
        int actual = productsPage.getCartCount();
        System.out.println("[CART] Cantidad en carrito: " + actual);
        assert actual == expectedCount 
        : "Esperado: " + expectedCount + " | Actual: " + actual;
        Thread.sleep(2000);
    }
    
}
