package com.bice.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//div[text()='Entendido']")
    private WebElement msjEntendido;

    @FindBy(xpath = "//div[@role='button' and contains(@data-testid,'sign_in')]")
    private WebElement buttonCuenta;
    
    @FindBy(xpath =  "//input[contains(@data-testid,'email')]")
    private WebElement emailField;

    @FindBy(xpath = "//input[contains(@data-testid,'password')]")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='button' and @data-testid='unifiedAuth.submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//marquee[contains(text(),'Welcome To Manager')]")
    private WebElement welcomeMessage;

    @FindBy (xpath = "//*[contains(text(),'Este usuario no está registrado en la nueva Sucursal Virtual')]")
    private WebElement mensajeError;

    

    public LoginPage() {
        super();
    }


    //CLick mensaje entendido
    public void clickMensaje (){
        clickElement(msjEntendido);
    }

    //CLick ya tengo cuelta
    public void clcikTengoCuenta (){
        clickElement(buttonCuenta);
    }

    //Inpunt email
    public void inputMail (String mail){
        typeText(emailField, mail);

    }

    //Input pasword
    public void inputPass (String password){
        typeText(passwordField, password);

    }

    //CLick boton iniciar seisión
    public void clickIniciarsesion(){
        clickElement(loginButton);
    }

    //Espera que se muestre mensaje error
    public boolean  mensajeErroDisponible (){
       return isDisplayed(mensajeError);
    }


}