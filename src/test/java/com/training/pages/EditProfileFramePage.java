package com.training.pages;

import org.openqa.selenium.By;
import com.training.base.BasePage;
import com.training.base.BaseTest;

public class EditProfileFramePage extends BasePage{
	
	//static WebDriver driver;
	
		public EditProfileFramePage() {
			
			super(BaseTest.getDriver()); 
			
			 addObject("EditProfileFrame", By.id("contactInfoContentId"));
			 addObject("About", By.id("aboutTab"));
			 addObject("Lastname", By.id("lastName"));
			 addObject("SaveAllButton", By.xpath("//input[@value='Save All']"));
		}


}
