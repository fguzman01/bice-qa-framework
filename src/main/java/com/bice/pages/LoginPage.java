package com.bice.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    

    @FindBy(id ="password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement userName;


    @FindBy (xpath = "//*[text()='Products']")
    private WebElement productTitle;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;

    
    public LoginPage() {
        super();
    }

    //Inpunt user name 
    public void inputUsername (String username){
        typeText(this.userName, username);
    }

    //Inpunt user name 
    public void inputPassword (String pass){
        typeText(this.password, pass);
    }

    // Ingresar click login
    public void clickLoginButton (){
        clickElement(loginButton);
    }
     
     // ── Métodos de validación ─────────────────────────────────────────


    //Validación pagina producto luego de login
    public boolean isLoginSuccessful(){
        return isDisplayed(productTitle);
    }

    public String getErrorMessage() {
    return getText(errorMessage);
    }

    public boolean isErrorMessageDisplayed(String expectedText) {
        try {
            String actual = getErrorMessage();
            System.out.println("[CHECK] Mensaje de error: " + actual);
            return actual.contains(expectedText);
        } catch (Exception e) {
            return false;
        }
    }

    

    
}