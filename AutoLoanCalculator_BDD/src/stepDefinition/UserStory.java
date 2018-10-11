package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pagesPackage.AutoLoanCalculator;

public class UserStory {
	public static WebDriver driver;

	@Given("^I navigated to the auto loan calculator page$")
	public void I_navigated_to_the_auto_loan_calculator_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Vishwam\\eclipse-workspace\\AutoLoanCalculator_BDD\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		// maximize browser
		driver.manage().window().maximize();

		// launch the url
		driver.get("http://www.autotrader.com");
		// Check whether navigated to auto loan calculator page
		AutoLoanCalculator obj = new AutoLoanCalculator();
		obj.CheckForNavigation();
	}

	@When("^I entered details without price and clicked calculate$")
	public void I_entered_details_without_price_and_clicked_calculate() throws Throwable {

		AutoLoanCalculator obj = new AutoLoanCalculator();
		obj.ValidatePrice();
	}

	@Then("^I Should get an error message$")
	public void I_Should_get_an_error_message() throws Throwable {

		System.out.println("UserStory 1: Price error Message");
		driver.close();

	}

	@When("^I entered details \"([^\"]*)\" \"([^\"]*)\" and click on the calculate button$")
	public void I_entered_details_and_click_on_the_calculate_button(String rate, String price) throws Throwable {
		AutoLoanCalculator obj = new AutoLoanCalculator();
		obj.EMICalculator(rate, price);

	}
	
	@Then("^I should be able to verify the generated values\"([^\"]*)\" \"([^\"]*)\"  \"([^\"]*)\" \"([^\"]*)\"  \"([^\"]*)\" \"([^\"]*)\"$")
	public void I_should_be_able_to_verify_the_generated_values(String monthInt, String price, String interest,
			String finance, String loan, String emi) throws Throwable {

		AutoLoanCalculator obj = new AutoLoanCalculator();
		obj.ValidateCalculator(monthInt, price, interest, finance, loan, emi);
		driver.quit();
	}

}
