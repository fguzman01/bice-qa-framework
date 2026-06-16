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

    // Instanciar flos previo
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
    public void ingresaUsuarioYPassword(String username, String password) {
        loginFlow.loginAs(username, password);
    }

    
    @Then("debe ver la pagina de login succes")
    public void debeVerLaPaginaDeCuentas() {
        assert loginPage.isLoginSuccesful()
            : "Se esperaba mensaje de bienvenida pero no apareció";
    }

    @When("el usuario valido desde DataProvider intenta ingresar")
    public void loginConDataProvider(){
        UserData user = DataProvider.getUser("validUser");
        System.out.println("[DATA] Usuario desde JSON: " + user.getUsername());
        loginFlow.loginAs(user.getUsername(), user.getPassword());
    }

    @Then("debe entregar error invalid")
    public void errorInvalid() throws InterruptedException{
        Thread.sleep(2000);
        assert loginPage.isErrorMessageDisplayed( "Your username is invalid!")
            : "No se mostro lo requerido";
    }

    
}
