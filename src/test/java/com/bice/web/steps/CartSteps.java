package com.bice.web.steps;

import com.bice.pages.CartPage;
import com.bice.pages.CheckoutPage;
import com.bice.pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CartSteps {

    private CartPage cartPage = new CartPage();
    private CheckoutPage  checkoutPage = new CheckoutPage();

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

    @And("el usuario hace click en checkout")
    public void elUsuarioHaceClicEnCheckout(){
        cartPage.clickCheckout();

    }

    @Then("el formulario de checkout debe tener los tres campos")
    public void elFormularioDeCheckoutDebeTenerLosTresCampos(){
        assert checkoutPage.areCheckoutFieldsPresent()
            : "Faltan campos en el formulario de checkout";

    }

    @And("completa el formulario de checkout con {string} {string} {string}")
    public void completaElFormularioDeCheckoutCon(String firstName, String lastName, String postalCode){
        checkoutPage.fillCheckoutForms(firstName, lastName, postalCode);
    }
    @And("hacer click en continue")
    public void haceClicEnContinue() {
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.clickContinue();
}

    @Then("el producto {string} debe aparecer en el resumen")
    public void elProductoDebeAparecerEnElResumen(String productName){
        assert checkoutPage.isProductInSummary(productName)
            :"El producto no aparece en el resumen" + productName;

    }

    @When("hace click en finish")
    public void hacerClickEnfinish(){
        checkoutPage.clickFinish();
    }

    @Then ("debe ver el mensaje de orden completada")
    public void debeVerElMensajeDeOrdenCompletada() {
        assert checkoutPage.isOrderComplete()
            :"No se mostro el mensaje de orden completada";
    }

    @When("hace click en volver al inicio")
    public void haceClicEnVolverAlInicio(){
        checkoutPage.clickBackHome();
    }


    
    
}
