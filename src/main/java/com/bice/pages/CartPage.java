package com.bice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(css = "[data-test='checkout']")
    private WebElement checkoutButton;

    public CartPage(){
        super();
    }

    public void clickCheckout() {
        clickElement(checkoutButton);
    }


    // Validar si producto esta en el carro
    public boolean isProductInCart(String productName){
        try{
            String xpath = String.format("//div[@data-test='inventory-item-name' and text()='%s']"
                , productName);
            System.out.println("Elemento : " + xpath);
            WebElement product = driver.findElement(By.xpath(xpath));
            System.out.println("[CART] Producto encontrado en carrito: " + productName);
            return isDisplayed(product);

        }catch (Exception e){
            return false;
        }
    }

    // Remove producto con parametro nombre
    public void removeProductByName (String productName){
        String dataTest = "remove-" + productName.toLowerCase().replace(" ", "-");
        String xpath = String.format("//button[@data-test='%s']", dataTest);
        System.out.println(dataTest); 
        WebElement removeButton = driver.findElement(By.xpath(xpath));
        clickElement(removeButton);
        System.out.println("[CART] Producto eliminado: " + productName);

    }


    
}
