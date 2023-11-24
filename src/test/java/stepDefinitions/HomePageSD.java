package stepDefinitions;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import log4j.LoggerLoad;
import pageObjects.HomePage;

public class HomePageSD { 
	HomePage home = new HomePage();
	@Given("The user opens DS Algo portal link")
    public void the_user_opens_ds_algo_portal_link() {
    LoggerLoad.info("User is in DSAlgo portal page");
	home.dsAlgoPortal();
}

@When("The user clicks the {string} button")
public void the_user_clicks_the_button(String string) {
	LoggerLoad.info("User clicks on Get Started link in the DSAlgo portal page");
	home.getStarted(string);
}

@Then("The user should be redirected to the home page")
public void the_user_should_be_redirected_to_the_home_page() {
	String title = home.verifyPageTitle();
	LoggerLoad.info("Title of the Current Page : " + title);
	assertEquals(title, "NumpyNinja","Page Title do not match");
}

@Given("The user is on home page")
public void the_user_is_on_home_page() {
	LoggerLoad.info("User is on home page");
	home.homePage();
}

@When("The user clicks on  {string} without login")
public void the_user_clicks_on_without_login(String string) {
	LoggerLoad.info("User clicks on get started link");
	home.home_getStarted(string);
}

@Then("The user get warning message {string}")
public void the_user_get_warning_message(String string) {
	String alert=home.alertMessage();
	LoggerLoad.info("Actual Alert Message : " + alert);
	assertEquals(string, alert,"Alert Message do not match");
}

@When("The user clicks on dropdown {string} without login")
public void the_user_clicks_on_dropdown_without_login(String string) {
	LoggerLoad.info("User clicks on dropdown link");
	home.home_dropdown(string);
}


@Given("The user open Home Page")
public void the_user_open_home_page() {
 LoggerLoad.info("User is on home page");
}

@When("The user click {string}")
public void the_user_click(String string) {
LoggerLoad.info("The User clicks on SignIn Button");
	home.signInHomePage();
}

@Then("The user should be redirected to {string} page")
public void the_user_should_be_redirected_to_page(String string) {
String title = home.verifyPageTitle();
LoggerLoad.info("Title of the Current Page : " + title);
assertEquals(title, string, "Page Title do not match");	
}

@When("The user click Register")
public void the_user_click_register() {
	LoggerLoad.info("The User clicks on SignIn Button");
	home.registerHomePage();
}


@Then("The user should be redirected to Register form")
public void the_user_should_be_redirected_to_register_form() {
	String title = home.verifyPageTitle();
	LoggerLoad.info("Title of the Current Page : " + title);
	assertEquals(title, "Registration", "Page Title do not match");
}
}


