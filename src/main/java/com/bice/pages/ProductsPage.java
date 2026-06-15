package com.bice.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage{

    public ProductsPage(){
        super();
    }

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
