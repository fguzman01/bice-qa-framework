package com.bice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;;

public class CheckoutPage extends BasePage{

    @FindBy (css = "[data-test='firstName']")
    private WebElement firstNameField;

    @FindBy (css = "[data-test='lastName']")
    private WebElement lastNameField;

    @FindBy (css = "[data-test='postalCode']")
    private WebElement postalCodeField;

    @FindBy(css = "[data-test='continue']")
    private WebElement continueButton;

    @FindBy(css = "[data-test='finish']")
    private WebElement finishButton;

    @FindBy(css = "[data-test='complete-header']")
    private WebElement completeHeader;

     @FindBy(css = "[data-test='back-to-products']")
    private WebElement backHomeButton;

    public boolean areCheckoutFieldsPresent(){
        boolean firstName = isDisplayed(firstNameField);
        boolean lastName = isDisplayed(lastNameField);
        boolean postalCode = isDisplayed(postalCodeField);

        System.out.println("[CHECK] First Name visible: " + firstName);
        System.out.println("[CHECK] Last Name visible: " + lastName);
        System.out.println("[CHECK] Postal Code visible: " + postalCode);

        return firstName && lastName && postalCode;
    }

    public void fillCheckoutForms(String firstName, String lastName, String postalCode){
        typeText(firstNameField, firstName);
        typeText(lastNameField, lastName);
        typeText(postalCodeField, postalCode);
    }

    public boolean isProductInSummary(String productName) {
        String xpath = String.format("//div[@data-test='inventory-item-name' and text()='%s']", productName);
        WebElement product = driver.findElement(By.xpath(xpath));
        boolean visible = isDisplayed(product);
        System.out.println("[SUMMARY] Producto en resumen: " + productName + " | visible: " + visible);
        return visible;
    }

    public void clickFinish() {
        clickElement(finishButton);
    }

    public boolean isOrderComplete() {
        return isDisplayed(completeHeader);
    }

    public void clickBackHome() {
        clickElement(backHomeButton);
    }

     public void clickContinue() {
        clickElement(continueButton);
    }

   
}
