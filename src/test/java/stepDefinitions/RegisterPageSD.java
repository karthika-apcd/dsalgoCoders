package stepDefinitions;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.RegisterPage;
import utilities.LoggerLoad;


public class RegisterPageSD {

	RegisterPage register = new RegisterPage();
	


	@Given("The user opens Register Page")
	public void the_user_opens_register_page() {
		LoggerLoad.info("User Opens the Registration Page by clicking the Register Button ");
		register.navigateToRegisterLink();
	}
	

	@When("The user clicks {string} button with all fields empty")
	public void the_user_clicks_button_with_all_fields_empty(String string) {
		LoggerLoad.info("User Clicks the Register Button without entering any values in Username Field");
		register.clickRegisterButton();
	}
	

	@Then("It should display an error {string} below Username textbox")
	public void it_should_display_an_error_below_username_textbox(String string, String expectedErrorMsg) {
		LoggerLoad
		.info("Error Message is shown in the username textbox field : " + register.getEmptyFieldErrormsgUser());
       assertTrue(register.getEmptyRequiredUserField(), "Username Field is Empty - required attribute is validated");
      
        
     
	assertEquals(register.getEmptyFieldErrormsgUser(), expectedErrorMsg);
}
	
//T2
	@When("The user clicks {string} button after entering username with other fields empty")
	public void the_user_clicks_button_after_entering_username_with_other_fields_empty(String string, io.cucumber.datatable.DataTable dataTable) {
		LoggerLoad.info("The user enter valid username with other fields empty");
		register.enterValidUsername(dataTable);
		register.clickRegisterButton();
	}

	@Then("It should display an error {string} below Password textbox")
	public void it_should_display_an_error_below_password_textbox(String string, String expectedErrorMsg) {
		LoggerLoad
		.info("Error Message is shown in the password textbox field : " + register.getEmptyFieldErrormsgPwd());
assertTrue(register.getEmptyRequiredPwdField(), "Password Field is Empty - required attribute is validated");
assertEquals(register.getEmptyFieldErrormsgPwd(), expectedErrorMsg);
}
//T3
	@When("The user clicks {string} button after entering {string} and {string} with Password Confirmation field empty")
	public void the_user_clicks_button_after_entering_and_with_password_confirmation_field_empty(String string, String string2, String string3, io.cucumber.datatable.DataTable dataTable) {
		LoggerLoad.info("The user enter valid username and valid password with Password Confirmation Field is empty");
		register.enterValidUsername(dataTable);
		register.enterValidPassword(dataTable);
		register.clickRegisterButton();

	}

	@Then("It should display an error {string} below Password Confirmation textbox")
	public void it_should_display_an_error_below_password_confirmation_textbox(String expectedErrorMsg) {
		LoggerLoad.info("Error Message is shown in the password confirmation textbox field : "
				+ register.getEmptyFieldErrormsgPwdConfirm());
		assertTrue(register.getEmptyRequiredPwdConfirmField(),
				"Password Confirmation Field is Empty - required attribute is validated");
		assertEquals(register.getEmptyFieldErrormsgPwdConfirm(), expectedErrorMsg);
	}
//T4
	@When("The user enters a {string} with characters other than Letters, digits and {string}")
	public void the_user_enters_a_with_characters_other_than_letters_digits_and(String string, String string2, io.cucumber.datatable.DataTable dataTable) {
		register.enterValidUsername(dataTable);
		register.enterValidPassword(dataTable);
		register.enterValidPwdConfirm(dataTable);
		register.clickRegisterButton();
	}

	@Then("It should display an error message {string}")
	public void it_should_display_an_error_message(String string, DataTable dataTable, String expErrorMsg) {
		LoggerLoad.info("Expected Error Message : " + expErrorMsg);
		LoggerLoad.info("Actual Message displayed in the browser : " + register.getErrorMsg());
		assertEquals(register.getErrorMsg(), expErrorMsg);
	}
//T5

	@When("The user clicks {string} button after entering valid {string} and different passwords in {string} and {string} fields")
	public void the_user_clicks_button_after_entering_valid_and_different_passwords_in_and_fields(String string, String string2, String string3, String string4, io.cucumber.datatable.DataTable dataTable) {
		register.enterValidUsername(dataTable);
		register.enterValidPassword(dataTable);
		register.enterValidPwdConfirm(dataTable);
		register.clickRegisterButton();
	}
//T6

	@When("he user enters a valid {string} and {string} with characters less than {int}.")
	public void he_user_enters_a_valid_and_with_characters_less_than(String string, String string2, Integer int1, io.cucumber.datatable.DataTable dataTable) {
		register.enterValidUsername(dataTable);
		register.enterValidPassword(dataTable);
		register.enterValidPwdConfirm(dataTable);
		register.clickRegisterButton();
	}
	//T7
	@When("The user enters a valid {string} and {string} with only numbers")
	public void the_user_enters_a_valid_and_with_only_numbers(String string, String string2, io.cucumber.datatable.DataTable dataTable) {
		register.enterValidUsername(dataTable);
		register.enterValidPassword(dataTable);
		register.enterValidPwdConfirm(dataTable);
		register.clickRegisterButton();

	}
//T8
	@When("The user enters a valid {string} and {string} and {string}")
	public void the_user_enters_a_valid_and_and(String string, String string2, String string3, io.cucumber.datatable.DataTable dataTable) {
		register.enterValidUsername(dataTable);
		register.enterValidPassword(dataTable);
		register.enterValidPwdConfirm(dataTable);
		register.clickRegisterButton();

	}
	@Then("The user should be redirected to Homepage with the message {string}")
	public void the_user_should_be_redirected_to_homepage_with_the_message(String successMsg) {
	
		LoggerLoad.info("New Account Created. You are logged in as kamala@vimala ");
		register.homepage();
		
	}
		
	//T9
	@Given("The user is in the {string} page.")
	public void the_user_is_in_the_page(String string) {
		LoggerLoad.info("User is in the SignIn Page ");		
	}

	@When("The user clicks the {string} link.")
	public void the_user_clicks_the_link(String string) {
		LoggerLoad.info("User clicks the signout link");
		register.clickSignOutLink();
	}

	@Then("The user should be redirected to the homepage with the message {string}.")
	public void the_user_should_be_redirected_to_the_homepage_with_the_message(String string, String successMsg) {
		LoggerLoad.info("User is redirected to Homepage ");
		LoggerLoad.info("Expected Success Message : " + successMsg);
		LoggerLoad.info("Actual Message displayed in the browser : " + register.getErrorMsg());
		assertEquals(register.getErrorMsg(), successMsg);
	}
}
	
