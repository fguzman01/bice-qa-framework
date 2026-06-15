package com.bice.flows;

import com.bice.pages.LoginPage;
import com.bice.utils.actions.WaitActions;

public class LoginFlow {

    private final LoginPage loginPage;
    

    public LoginFlow() {
        this.loginPage = new LoginPage();
    }

    // Metodo de login completo
    public void loginAs(String username, String password){
        System.out.println("[FLOW] Iniciando login con usuario: " + username);
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();
        System.out.println("[FLOW] Login completado");

    }

    
    
}
