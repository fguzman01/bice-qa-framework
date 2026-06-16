package com.bice.web.steps;

import com.bice.pages.CartPage;
import com.bice.pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CartSteps {

    private CartPage cartPage = new CartPage();

    @And("el usuario va al carrito")
    public void elUsuarioVaAlCarrito (){
        ProductsPage productsPage = new ProductsPage();
        productsPage.goToCart();
    }

    @Then ("el producto {string} debe estar en el carrito")
    public void elProductoDebeEstarEnElCarrito(String productName){
        assert cartPage.isProductInCart(productName)
            : "El producto esta en el carrito" + productName;

    }

    @When("el usuario elimina el producto {string} del carrito")
    public void elUsuarioEliminaElProductoDelCarrito(String productName){
        cartPage.removeProductByName(productName);

    }

    @Then("el producto {string} no debe estar en el carrito")
    public void elProductoNoDebeEstarEnElCarrito(String productName) {
        assert !cartPage.isProductInCart(productName)
            :"El rpoducto sigue en el carro" + productName;   
    }
    
    
}
