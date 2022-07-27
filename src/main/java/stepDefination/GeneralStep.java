package stepDefination;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObject.ShoeStorePage;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.DriverFactory;
import utility.Utility;

public class GeneralStep {

	public WebDriver driver;
	ShoeStorePage shoeStorePage;
	Utility utill;

	@Before
	public void setUp() {

		driver = DriverFactory.get_driver_instance();
		shoeStorePage = new ShoeStorePage(driver);
		utill = new Utility();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@After
	public void tearDown(Scenario scenario) throws IOException {
		driver.quit();
	}

	@Given("Go to shoe store")
	public void go_to_shoe_store() {
		driver.get(Utility.getProperty("url"));
	}

	@When("Search {string} in the brand")
	public void search_in_the_brand(String string) throws Exception {
		utill.selectbyText(shoeStorePage.drp_brand, string);
		utill.PerformActionOnElement(shoeStorePage.btn_search, "click", "");

	}

	@Then("Validate search result")
	public void validate_search_result() {

		Assert.assertTrue(shoeStorePage.result.size() > 0);
	}

	@Then("Enter the email address as {string} and validate message")
	public void enter_the_email_address_as_and_validate_message(String string) throws Exception {
		utill.PerformActionOnElement(shoeStorePage.txt_email, "type", string);
		utill.PerformActionOnElement(shoeStorePage.btn_email_submit, "click", "");
		if (string.isEmpty()) {
			Assert.assertEquals(shoeStorePage.alertMessage.getText(), "Please enter an email address");
		} else if (string.contains(".com")) {
			Assert.assertEquals(shoeStorePage.alertMessage.getText(),
					"Thanks! We will notify you of our new shoes at this email: " + string);
		} else {
			Assert.assertEquals(shoeStorePage.alertMessage.getText(), "Invalid email format. Ex. name@example.com");
		}
	}

	@Then("Enter the promo code as {string} and validate message")
	public void enter_the_promo_as_and_validate_message(String string) throws Exception {
		utill.PerformActionOnElement(shoeStorePage.txt_promocode, "type", string);
		utill.PerformActionOnElement(shoeStorePage.btn_promo_submit, "click", "");
		Assert.assertEquals(shoeStorePage.alertMessage.getText(), "Invalid code format");

	}
}
