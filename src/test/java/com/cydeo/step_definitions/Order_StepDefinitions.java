package cydeo.step_definitions;


import io.cucumber.java.en.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class Order_StepDefinitions {

    cydeo.pages.WebTableLoginPage webTableLoginPage = new cydeo.pages.WebTableLoginPage();
    cydeo.pages.BasePage basePage = new cydeo.pages.BasePage();
    cydeo.pages.OrderPage orderPage = new cydeo.pages.OrderPage();
    cydeo.pages.ViewAllOrdersPage viewAllOrdersPage = new cydeo.pages.ViewAllOrdersPage();

    @Given("user is already logged in and on order page")
    public void user_is_already_logged_in_and_on_order_page() {
        //Getting the page using the URL from configuration.properties
        com.cydeo.utilities.Driver.getDriver().get(com.cydeo.utilities.ConfigurationReader.getProperty("web.table.url"));

        //Calling our login method to log in to web table app
        webTableLoginPage.login();

        //clicking to "order" link to go order page
        basePage.order.click();

    }
    @When("user selects product type {string}")
    public void user_selects_product_type(String string) {

        Select select = new Select(orderPage.productDropdown);
        select.selectByVisibleText(string);

    }
    //    @When("user enters quantity {string}")
//    public void user_enters_quantity(String string) {
//
//    }
    @And("user enters quantity {int}")
    public void userEntersQuantity(int quantity) {
        //accepting int argument and sending it using sendKeys() method
        //since sendKeys() method only accepts String, we need to either concat with ""
        //or send String.valueOf(int);
        //orderPage.inputQuantity.sendKeys(String.valueOf(quantity));

        //clear() method will delete whatever is in the input box
        //orderPage.inputQuantity.clear();

        //imitating pressing back_space button from keyboard to delete existing input
        orderPage.inputQuantity.sendKeys(Keys.BACK_SPACE);

        orderPage.inputQuantity.sendKeys(quantity+"");

    }

    @When("user enters customer name {string}")
    public void user_enters_customer_name(String string) {
        orderPage.inputName.sendKeys(string);
    }
    @When("user enters street {string}")
    public void user_enters_street(String string) {
        orderPage.inputStreet.sendKeys(string);
    }
    @When("user enters city {string}")
    public void user_enters_city(String string) {
        orderPage.inputCity.sendKeys(string);
    }
    @When("user enters state {string}")
    public void user_enters_state(String string) {
        orderPage.inputState.sendKeys(string);
    }
    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String string) {
        orderPage.inputZip.sendKeys(string);
    }
    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String expectedCardType) {

        //This line will loop through the list and decide which radio button to click
        com.cydeo.utilities.BrowserUtils.clickRadioButton(orderPage.cardType, expectedCardType);

    }
    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String string) {
        orderPage.cardNoInput.sendKeys(string);
    }
    @When("user enters expiry date {string}")
    public void user_enters_expiry_date(String string) {
        orderPage.cardExpInput.sendKeys(string);
    }
    @When("user enters process order button")
    public void user_enters_process_order_button() {
        orderPage.processOrderBtn.click();
    }
    @Then("user should see {string} in first row of the web table")
    public void user_should_see_in_first_row_of_the_web_table(String expectedName) {
        String actualName = viewAllOrdersPage.newCustomerCell.getText();

        Assert.assertEquals(expectedName, actualName);
    }


}