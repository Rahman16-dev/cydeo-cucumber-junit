package cydeo.pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class ViewAllOrdersPage extends cydeo.pages.BasePage {

    public ViewAllOrdersPage(){
        PageFactory.initElements(com.cydeo.utilities.Driver.getDriver(), this);
    }

    //we need to locate the first cell of the first row
    @FindBy(xpath = "//table[@class='table is-fullwidth']/tbody/tr[1]/td[1]")
    public WebElement newCustomerCell;



}