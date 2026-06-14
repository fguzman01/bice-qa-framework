package com.bice.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    // Link new customer
    @FindBy(xpath = "//a[@href='addcustomerpage.php']")
    private WebElement newCustomerLink;

    // Titulo de pagina en home
    @FindBy(xpath = "//a[contains(text(),'Manager')]")
    private WebElement managerTitle;

    public HomePage(){
        super();
    }

    // ── Actions en HomePage  ─────────────────────────────────────────

    public void clickNewCustomer() {
        clickElement(newCustomerLink);
    }

    public boolean isHomePageDisplayed() {
        return isDisplayed(managerTitle);
    }


    
}
