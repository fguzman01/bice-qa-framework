package com.bice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement userField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "submit")
    private WebElement loginButton;

    @FindBy(xpath = "//h1[contains(text(),'Logged In Successfully')]")
    private WebElement welcomeMessage;

    @FindBy(xpath = "//a[contains(@href,'test-login')]")
    private WebElement logoutButton;

    @FindBy(id = "error")
    private WebElement errorMesj; 

    public LoginPage() {
        super();
    }

    //Ingresar username
    public void enterUsername(String username) {
        typeText(userField, username);
    }

    // Ingresar password 
    public void enterPassword(String password) {
        typeText(passwordField, password);
    }

    //Click en boton submit
    public void clickSubmit (){
        clickElement(loginButton);
    }

    //CLick logout button
    public void logOut(){
        clickElement(logoutButton );
    }

    public boolean isLoginSuccesful (){
        return isDisplayed(welcomeMessage);
    }

    public String getErrorMessage() {
        return getText(errorMesj);
    }

    public boolean isErrorMessageDisplayed(String expectText){
        try{

            String actual = getErrorMessage();
            System.out.println("[CHECK] Mensaje de error: " + actual);
            return actual.contains(expectText);

        }catch (Exception e){
            return false;
        }

        
    }

    
}