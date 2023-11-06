package pageObjects;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import factory.DriverFactory;
import utilities.ConfigReader;
import utilities.LoggerLoad;
public class HomePage {
	
	
	public static WebDriver driver = DriverFactory.getdriver();
	String URL = ConfigReader.getApplicationUrl();
	String homeUrl = ConfigReader.getHomePage();
	ConfigReader config = new ConfigReader();// why do we need this line?



	
	@FindBy(xpath = "//a[@href='/home']")WebElement getStarted;

	
	@FindBy(xpath = "//a[@href='data-structures-introduction']")WebElement dataStructures;
	@FindBy(xpath = "//a[@href='array']")WebElement array;
	@FindBy(xpath = "//a[@href='linked-list']")WebElement linkedList;
	@FindBy(xpath = "//a[@href='stack']")WebElement stack;
	@FindBy(xpath = "//a[@href='queue']")WebElement queue;
	@FindBy(xpath = "//a[@href='tree']")WebElement tree;
	@FindBy(xpath = "//a[@href='graph']")WebElement graph;

	@FindBy(xpath = "//a[@class='nav-link dropdown-toggle']")WebElement dropdown_dataStructs;
	@FindBy(xpath = "//a[@href='/array']")WebElement dropdown_array;
	@FindBy(xpath = "//a[@href='/linked-list']")WebElement dropdown_linkedList;
	@FindBy(xpath = "//a[@href='/stack']")WebElement dropdown_stack;
	@FindBy(xpath = "//a[@href='/queue']")WebElement dropdown_queue;
	@FindBy(xpath = "//a[@href='/tree']")WebElement dropdown_tree;
	@FindBy(xpath = "//a[@href='/graph']")WebElement dropdown_graph;

	
	@FindBy(xpath = "//div[@class='alert alert-primary']")WebElement ds_alertMsg;


	@FindBy(xpath = "//a[@href='/register']")WebElement registerHmPg;


	@FindBy(xpath = "//a[@href='/login']")WebElement signInHmPg;

	
	public HomePage() {
		PageFactory.initElements(driver, this);
	
	}


	public void dsAlgoPortal() {
		driver.get(URL);
	}

	
	public void getStarted(String string) {
		getStarted.click();
	}


	public String verifyPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;

	}

	public void homePage() {
		driver.get(homeUrl);
	}

	
	public String alertMessage() {
		String alertMsg = ds_alertMsg.getText();
		return alertMsg;
	}

	public void home_getStarted(String string) {
		switch (string) {
		case "Datastructures":
			LoggerLoad.info("Click " + dataStructures.getText() + " link on Data Structures-Introduction");
			dataStructures.click();
			break;
		case "Arrays":
			LoggerLoad.info("Click " + array.getText() + " link on Array");
			array.click();
			break;
		case "Linkedlist":
			LoggerLoad.info("Click " + linkedList.getText() + " link on Linkedlist");
			linkedList.click();
			break;
		case "Stack":
			LoggerLoad.info("Click " + stack.getText() + " link on Stack");
			stack.click();
			break;
		case "Queue":
			LoggerLoad.info("Click " + queue.getText() + " link on Queue");
			queue.click();
			break;
		case "Tree":
			LoggerLoad.info("Click " + tree.getText() + " link on Tree");
			tree.click();
			break;
		case "Graph":
			LoggerLoad.info("Click " + graph.getText() + " link on Graph");
			graph.click();
			break;

		}
	}

	
	public void home_dropdown(String string) {

		dropdown_dataStructs.click();
		LoggerLoad.info("Click " + dropdown_dataStructs.getText() + " link in the dropdown");
		switch (string) {
		case "Arrays":
			LoggerLoad.info("Click " + dropdown_array.getText() + " link in the dropdown");
			dropdown_array.click();
			break;
		case "Linkedlist":
			LoggerLoad.info("Click " + dropdown_linkedList.getText() + " link in the dropdown");
			dropdown_linkedList.click();
			break;
		case "Stack":
			LoggerLoad.info("Click " + dropdown_stack.getText() + " link in the dropdown");
			dropdown_stack.click();
			break;
		case "Queue":
			LoggerLoad.info("Click " + dropdown_queue.getText() + " link in the dropdown");
			dropdown_queue.click();
			break;
		case "Tree":
			LoggerLoad.info("Click " + dropdown_tree.getText() + " link in Tree");
			dropdown_tree.click();
			break;
		case "Graph":
			LoggerLoad.info("Click " + dropdown_graph.getText() + " link in Graph");
			dropdown_graph.click();
			break;

		}
	}
	public void registerHomePage() {
		registerHmPg.click();
	}
    public void signInHomePage() {	
		signInHmPg.click();
	}
}
