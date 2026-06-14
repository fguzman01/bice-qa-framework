package com.bice.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


public class NewCustomerPage extends BasePage{

    private static final List<String> REQUIERED_FIELDS = List.of(
        "name", "city", "state", "pinno", "telephoneno", "emailid"

    );

    public NewCustomerPage(){
        super();
    }

    // Recorre
    public boolean areAllFieldsPresent (){
        for (String fieldName : REQUIERED_FIELDS){
            String xpath = String.format("//input[@type='text' and @name='%s']", fieldName);
            WebElement field = driver.findElement(By.xpath(xpath));
            System.out.println("[CHECK] Campo encontrado" + fieldName + "| locator" + xpath + 
            "| visible : " +field.isDisplayed());
            if (!field.isDisplayed()) {
                return false;
            }
        }
         
        return true;
    }

    
    
}
