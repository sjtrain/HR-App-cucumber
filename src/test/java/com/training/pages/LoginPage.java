package com.training.pages;
import org.openqa.selenium.By;
import com.training.base.BasePage;
import com.training.base.BaseTest;

public class LoginPage extends BasePage {
	
	//static WebDriver driver;
	
	  public LoginPage() {
		super(BaseTest.getDriver());  
	   addObject("Username", By.id("username"));
	   addObject("Password", By.id("password"));
	   addObject("Login", By.id("Login"));
	   addObject("ErrorMessage", By.id("error"));//same placeholder for different error messages
	   addObject("Checkbox", By.xpath("//*[@id=\'rememberUn\']"));
	   addObject("UsernameDisplay", By.xpath("//*[@id=\"username\"]"));
	   
	   addObject("ForgotPassword", By.id("forgot_password_link"));
	   
	  
	 
	   
	  
	  }
		

}
