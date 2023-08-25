package com.training.pages;

import org.openqa.selenium.By;
import com.training.base.BasePage;
import com.training.base.BaseTest;

public class ForgotPasswordPage extends BasePage{
	
	//static WebDriver driver;
	
		public ForgotPasswordPage() {
			
			super(BaseTest.getDriver());  
			addObject("ForgotPasswordUsername", By.id("un"));
			addObject("ContinueButton", By.id("continue"));
			addObject("CheckYourEmailMessage", By.id("header"));
			   
		}


}
