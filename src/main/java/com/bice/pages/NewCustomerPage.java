package com.bice.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.bice.data.Customer;


public class NewCustomerPage extends BasePage{

    private static final List<String> REQUIRED_FIELDS = List.of(
        "name", "city", "state", "pinno", "telephoneno", "emailid"

    );

    @FindBy (name = "name")
    private WebElement nameField;

    @FindBy (xpath ="//textarea[@name='addr']")
    private WebElement addressField;

    @FindBy (name = "city")
    private WebElement cityField;

    @FindBy (name = "state")
    private WebElement stateField;

    @FindBy (name = "pinno")
    private WebElement pinField;

    @FindBy(name = "telephoneno")
    private WebElement phoneField;

    @FindBy(name = "emailid")
    private WebElement emailField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(id = "dob")
    private WebElement dobField;

    @FindBy(name = "sub")
    private WebElement submitButton;



    public NewCustomerPage(){
        super();
    }

    // Recorre
    public boolean areAllFieldsPresent (){
        for (String fieldName : REQUIRED_FIELDS){
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

    public boolean areAllFieldsFilled() {
    for (String fieldName : REQUIRED_FIELDS) {
        String xpath = String.format("//input[@type='text' and @name='%s']", fieldName);
        WebElement field = driver.findElement(By.xpath(xpath));
        String value = field.getAttribute("value");
        System.out.println("[CHECK] Campo: " + fieldName + " | valor: " + value);
        if (value == null || value.isEmpty()) {
            return false;
        }
    }
    return true;
}

    // Input datos para formulario
    public void fillForm(Customer customer) throws InterruptedException{
        typeText(nameField, customer.getName());
        typeText(addressField, customer.getAddr());
        typeText(cityField, customer.getCity());
        typeText(stateField, customer.getState());
        typeText(pinField, customer.getPinno());
        typeText(phoneField, customer.getTelephoneno());
        typeText(emailField, customer.getEmailid());
        //typeText(passwordField, customer.getPassword());
        //typeText(dobField, customer.getDob());
        fillDateField(customer.getDob());
        Thread.sleep(5000);

    }

    
    private void fillDateField(String dob) {
    System.out.println("[TYPE] → input#dob | valor: " + dob);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].value = arguments[1];", dobField, dob);
    
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    


    public void clickSubmit(){
        clickElement(submitButton);
    }

    
    
}
