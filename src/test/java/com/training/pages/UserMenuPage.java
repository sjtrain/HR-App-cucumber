package com.training.pages;
import org.openqa.selenium.By;
import com.training.base.BasePage;
import com.training.base.BaseTest;

public class UserMenuPage extends BasePage {
	
	//static WebDriver driver;
	
	public UserMenuPage() {
		super(BaseTest.getDriver());  
		 addObject("Usermenu", By.xpath("//div[@id=\"userNavButton\"]"));
		 addObject("Logout", By.xpath("//a[text()='Logout']"));
		 
		 addObject("MyProfile", By.xpath("//a[contains(text(),'My Profile')]"));
		 addObject("MySettings", By.xpath("//a[contains(text(),'My Settings')]"));
		 addObject("DeveloperConsole", By.xpath("//a[contains(text(),'Developer Console')]"));
		 addObject("SwitchingtolightningExperience", By.xpath("//a[contains(text(),'Switch to Lightning Experience')]"));
		 
		 addObject("UserNavMenuItems", By.id("userNav-menuItems"));
		 
		 
	}

}
