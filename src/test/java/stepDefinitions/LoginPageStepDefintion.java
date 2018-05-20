package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ObjectRepositories.LoginPage;
import base.Actiondriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.*;
public class LoginPageStepDefintion  {
	
	Actiondriver ad= new Actiondriver();
	@Given("^: Open the app home page for gmail$")
    public void _open_the_app_home_page_for_gmail() throws Throwable {

//		ad.type(By.id(LoginPage.ID_USERNAME),"test");
		Actiondriver.type(By.id(LoginPage.ID_Store_Number), "10009");
//		ad.selectByIndex(By.cssSelector(LoginPage.Click_Search_Icon), 1);
		Actiondriver.click(By.cssSelector(LoginPage.Click_Search_Icon));
		
		
		}	    
}
