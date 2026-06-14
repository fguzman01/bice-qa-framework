package com.bice.web.steps;

import com.bice.config.WebDriverFactory;
import com.bice.data.Customer;
import com.bice.data.DataProvider;
import com.bice.pages.HomePage;
import com.bice.pages.NewCustomerPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import io.cucumber.java.en.And;


public class NewCustomerSteps {
    private NewCustomerPage newCustomerPage;


    // Click link new customer
    @When ("el usuario hace clic en {string}")
    public void elUsuarioHaceClickEnNewCustomer(String menuoption){
        HomePage homePage = new HomePage();
        if (menuoption.equals("New Customer")) {
            homePage.clickNewCustomer();    
        } 
        newCustomerPage = new NewCustomerPage();   
    }

    @Then ("todos los campos del formulario deben estar presente")
    public void todosLosCamposDebenEstarPresentes(){
        newCustomerPage.areAllFieldsPresent();
    }

    @When ("el usuario completa el formulario de nuevo cliente")
    public void elUsuarioCompletaElformulario() throws InterruptedException{
        Customer customer = DataProvider.getCustomer("newCustomer");
        newCustomerPage.fillForm(customer);
    }

    
    @Then("todos los campos deben estar completos")
    public void todosLosCamposDebenEstarCompletos() {
        assert newCustomerPage.areAllFieldsFilled() : "Faltan campos por llenar";
    
    }
}
