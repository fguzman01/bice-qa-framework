package com.bice.web.steps;

import com.bice.config.ConfigManager;
import com.bice.config.WebDriverFactory;
import com.bice.data.DataProvider;
import com.bice.data.UserData;
import com.bice.flows.LoginFlow;
import com.bice.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.Scenario;

public class LoginSteps {

    private LoginFlow loginFlow;
    private LoginPage loginPage;

    // Instanciar flows  previo
    @Before
    public void setUp() {
        WebDriverFactory.initDriver();
        loginFlow = new LoginFlow();
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

    @When("ingresa usuario {string} y password {string}")
    public void ingresarUsuarioYPassword(String username, String password){
        loginFlow.loginAs(username, password);
    }

    @When ("el usuario valido desde DataProvider intenta ingresar")
    public void elUsuarioValidoDesdeDataProviderIntentaIngresar(){
        UserData user = DataProvider.getUser("validUser");
        System.out.println("[DATA] Usuario desde JSON: " + user.getUsername());
        loginFlow.loginAs(user.getUsername(),user.getPassword());
    }

    @Then("debe ver la pagina de productos")
    public void debeVerPaginaDeProductos (){
        assert loginPage.isLoginSuccessful()
         : "Nose mostro textile prodcuts";
    }

    @Then("debe entregar error por falta de datos")
    public void debeEntregarErrorPorFaltaDeDatos(){
        assert loginPage.isErrorMessageDisplayed("Password is required") 
        : "No se mostró el mensaje de password requerido";
    }

    @Then("debe entregar error por password incorrecto")
    public void debeENtregarPassWordIncorrecta(){
        assert loginPage.isErrorMessageDisplayed("do not match") 
            : "No se mostró el mensaje de credenciales inválidas";
    }

    @Then("debe entregar error por usuario bloqueado")
    public void debeEntregarErrorPorUsuarioBloqueado() {
        assert loginPage.isErrorMessageDisplayed("locked out") 
        : "No se mostró el mensaje de usuario bloqueado";
    }






    
    
}
