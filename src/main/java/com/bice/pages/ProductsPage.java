package com.bice.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage{

    @FindBy(xpath = "//*[@data-test='shopping-cart-badge']")
    private WebElement cartBadge;

    @FindBy(css = "[data-test='shopping-cart-link']")
    private WebElement cartLink;
    
    public ProductsPage(){
        super();
    }

    public void goToCart() {
        clickElement(cartLink);
    }

    // Recorrer caja de productos y selecionar segun nombre
    public void addProductToCartByName(String productName) {
        List<WebElement> items = driver.findElements(By.xpath("//*[@data-test='inventory-item']"));

        for (WebElement item : items){
            String name = item.findElement(By.cssSelector("[data-test='inventory-item-name']")).getText();
            if (name.equals(productName)){
                System.out.println("[FOUND] Producto encontrado: " + name);
                WebElement addButton = item.findElement(By.cssSelector("[data-test='add-to-cart-" 
                + productName.toLowerCase().replace(" ", "-") + "']"));
                clickElement(addButton);
                System.out.println("[CART] Producto agregado: " + name);
                break;
            }

        }
    }

    public int getCartCount() {
        try {
            return Integer.parseInt(getText(cartBadge));
        } catch (Exception e) {
            return 0;
        }
    }


    // Obtener lista de proudctos Nombre - Precio
    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();

            List<WebElement> names = driver.findElements(By.cssSelector("[data-test='inventory-item-name']"));
            List<WebElement> prices = driver.findElements(By.cssSelector("[data-test='inventory-item-price']"));

            for (int i= 0; i<names.size(); i++){
                String name = names.get(i).getText();
                String price = prices.get(i).getText();

                System.out.println("[PRODUCT] " + name + " | " + price);
                products.add(new Product(name, price));

            }

        return products;
    }

    public record Product(String name, String price) {}
    
}
