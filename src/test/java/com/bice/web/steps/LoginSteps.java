package com.bice.web.steps;

import com.bice.config.ConfigManager;
import com.bice.config.WebDriverFactory;
import com.bice.data.DataProvider;
import com.bice.data.UserData;
//import com.bice.flows.LoginFlow;
import com.bice.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.Scenario;

public class LoginSteps {

    //private LoginFlow loginFlow;
    private LoginPage loginPage;

    // Instanciar flos previo
    @Before
    public void setUp() {
        WebDriverFactory.initDriver();
        //loginFlow = new LoginFlow();
        loginPage = new LoginPage();
    }

    // Quit driver al finalizar
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
        loginPage.takeScreenshot("FAIL_" + scenario.getName());
        }
        WebDriverFactory.quitDriver();
    }

    @Given("el usuario navega al login")
    public void elUsuarioNavegaAlLogin() {
        loginPage.navigateTo(ConfigManager.getInstance().getBaseUrl());
    }

    @When ("usuario click en mensaje entendido")
    public void clcikMensajeEntendido (){
        loginPage.clickMensaje();

    }

    @And ("usuario click en ya tengo cuenta")
    public void clickEnMensajeCuenta (){
        loginPage.clcikTengoCuenta();

    }
    
    @When("ingresa usuario {string} y password {string}")
    public void ingresaUsuarioYPassword(String mail , String password) {
        //loginFlow.loginAs(username, password);
        loginPage.inputMail(mail);
        loginPage.inputPass(password);
    }

    @And("click en submit")
    public void clickSubmit (){
        loginPage.clickIniciarsesion();
    }

    @Then("debe entregar error de credenciales")
    public void mensajeErrorCredenciales (){

        assert loginPage.mensajeErroDisponible()
            : "no entrega error";

    }
    
}
