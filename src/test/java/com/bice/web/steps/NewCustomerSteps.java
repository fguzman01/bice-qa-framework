package com.bice.web.steps;

import com.bice.pages.HomePage;
import com.bice.pages.NewCustomerPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class NewCustomerSteps {


    // Click link new customer
    @When ("el usuario hace clic en {string}")
    public void elUsuarioHaceClickEnNewCustomer(String menuoption){
        HomePage homePage = new HomePage();
        if (menuoption.equals("New Customer")) {
            homePage.clickNewCustomer();    
        }
        
    }

    @Then ("todos los campos del formulario deben estar presente")
    public void todosLosCamposDebenEstarPresentes(){
        NewCustomerPage newCustomerPage = new NewCustomerPage();
        newCustomerPage.areAllFieldsPresent();

    }
    
}
