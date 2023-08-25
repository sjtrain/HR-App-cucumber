package com.training.steps;

import java.util.List;

import org.testng.Assert;

import com.training.base.BasePage;
import com.training.base.BaseTest;
import com.training.pagefactory.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps extends BaseTest {

	PageFactory pageFactory = new PageFactory();

	BasePage page;

	@Before
	public void setup() {
		launchapplication();

	}
	//corresponding page is initialized each time 
	@Given("User is on the {string}")
	public void user_is_on_the(String pageName)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		page = pageFactory.initialize(pageName);

	}

	@When("User enter into Textbox {string} {string}")
	public void user_enter_into_textbox(String logicalName, String value) {
		page.enterintoTextBox(logicalName, value);
	}

	@Then("User clicks on element {string}")
	public void user_clicks_on_button(String logicalName) {
		page.clickonButton(logicalName);
	}

	@Then("Assert: Message should be displayed {string} {string}")
	public void error_message_should_be_displayed(String logicalName, String value) {

		Assert.assertEquals(value, page.getWebElementText(logicalName));
	}

	@Then("Assert {string} with title {string}")
	public void assert_with_title(String pageName, String title) {
				
		Assert.assertEquals(title, page.getTitle(pageName));
	}
	
	@Then("Assert {string} with name displayed {string}")
	public void assert_with_name_displayed(String logicalName, String value) {
		Assert.assertEquals(value, page.getInputTextBoxValue(logicalName));
	}
	
	@Then("Assert link in {string}")
	public void assert_link_in(String logicalName, io.cucumber.datatable.DataTable dataTable) {
		 List<String> expectedLink = dataTable.asList(String.class);
		 List<String> actualLink = page.getDivMenuLinkItems(logicalName);// function call
		 Assert.assertTrue(actualLink.containsAll(expectedLink));
		
	}
	
	@Then("Assert list in {string}")
	public void assert_list_in(String value, io.cucumber.datatable.DataTable dataTable) {
	    
		 List<String> expectedList = dataTable.asList(String.class);
		 List<String> actualList = page.getDivMenuListItems(value);// function call
		 Assert.assertTrue(actualList.containsAll(expectedList));
	}


	@After
	public void teardown() {
		closedriver();
	}

}
