package com.training.pages;
import org.openqa.selenium.By;
import com.training.base.BasePage;
import com.training.base.BaseTest;

public class MyProfilePage extends BasePage {
	
	//static WebDriver driver;
	
	public MyProfilePage() {
		super(BaseTest.getDriver());  
		
		 addObject("EditProfileButton", By.xpath("//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div/div/a/img"));
		 addObject("EditProfileFrame", By.id("contactInfoContentId"));
		 
		
	}

}