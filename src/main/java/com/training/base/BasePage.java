package com.training.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;

	public HashMap<String, By> ObjectRepo = new HashMap<String, By>();

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void addObject(String logicalName, By by) {

		ObjectRepo.put(logicalName, by);
	}

	private WebElement getElement(String logicalName) {

		By by = ObjectRepo.get(logicalName);
		WebElement element = driver.findElement(by);
		return element;
	}
	
	

	public void enterintoTextBox(String LogicalName, String value) {

		WebElement element = getElement(LogicalName);
		waitForElement(element);
		element.clear();
		element.sendKeys(value);
	}

	public void clickonButton(String LogicalName) {

		WebElement element = getElement(LogicalName);
		waitForElement(element);
		element.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// To get text from a text element
	public String getWebElementText(String LogicalName) {
		WebElement element = getElement(LogicalName);
		// System.out.println(element.getText());
		waitForElement(element);
		return element.getText();
	}

	public String getTitle(String LogicalName) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver.getTitle();

	}

	// To get text from input text box element
	public String getInputTextBoxValue(String LogicalName) {
		// WebElement inputTextBox = driver.findElement(By.id(LogicalName));
		WebElement inputTextBox = getElement(LogicalName);
		// Get the text from the input text box
		String text = inputTextBox.getAttribute("value");
		return text;

	}

	//Getting all the link elements(with <a>tag) under the div tag in to a List
	public List<String> getDivMenuLinkItems(String logicalName) {
		WebElement divElement = getElement(logicalName);

		// Find all the link elements under the <div> element using the <a> tag
		List<WebElement> links = divElement.findElements(By.tagName("a"));

		// Create a list to store the link titles
		List<String> linkTitles = new ArrayList<String>();

		// Iterate through each link element and get its title attribute
		for (WebElement link : links) {
			if (link.isDisplayed()) {
				String title = link.getText();
				System.out.println(title);
				if (title != null && !title.isEmpty()) {
					linkTitles.add(title);
				}
			}
		}
		return linkTitles;
	}
	
	
	
	//Getting all the list elements(with <li>tag) under the div tag in to a List
		public List<String> getDivMenuListItems(String logicalName) {
			
			 WebElement frameElement = getElement(logicalName);
			 driver.switchTo().frame(frameElement);
			

			// Find all the list elements 
			List<WebElement> lists = driver.findElements(By.tagName("li"));

			// Create a list to store the list titles
			List<String> listTitles = new ArrayList<String>();

			// Iterate through each list element and get its title attribute
			for (WebElement list : lists) {
				if (list.isDisplayed()) {
					String title = list.getText();
					System.out.println(title);
					if (title != null && !title.isEmpty()) {
						listTitles.add(title);
					}
				}
			}
			return listTitles;
		}
	
	

	private void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

}
