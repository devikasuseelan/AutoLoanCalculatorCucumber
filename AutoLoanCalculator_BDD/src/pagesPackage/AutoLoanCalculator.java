package pagesPackage;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import stepDefinition.UserStory;

public class AutoLoanCalculator extends UserStory {

	public AutoLoanCalculator() {

		PageFactory.initElements(driver, this);
	}

	// Initialize Webelements

	@FindBy(how = How.CLASS_NAME, using = "close")
	WebElement continueButton;

	// Find the CarResearch dropdown
	@FindBy(how = How.ID, using = ("CarResearch & Reviews"))
	WebElement carResearch;

	// Find Monthly payment calculator
	@FindBy(how = How.XPATH, using = ("//a[contains(text(),'Monthly Payment Calculator')]"))
	WebElement monthlyPaymentCalculator;

	// Find tenure options
	@FindBy(how = How.XPATH, using = ("//*[@id=\'j_id_3s-tabsColumn-j_id_43-j_id_44-autoLoanCalculator-j_id_4a-calculatorFormColumn-loanCalculatorMonths-loanCalculatorLengthOfLoan\']/tbody/tr"))
	WebElement monthsTable;

	// Find 24 months
	@FindBy(how = How.XPATH, using = ("/html[1]/body[1]/div[2]/div[3]/div[2]/div[1]/form[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/table[1]/tbody[1]/tr[1]/td[1]/label[1]"))
	WebElement month;

	// Find interest rate textbox
	@FindBy(how = How.XPATH, using = ("//*[@id=\'j_id_3s-tabsColumn-j_id_43-j_id_44-autoLoanCalculator-j_id_4a-calculatorFormColumn-j_id_55-loanCalculatorInterestRate\']"))
	WebElement interest_Rate;

	// Find price textbox
	@FindBy(how = How.XPATH, using = ("//*[@id=\'j_id_3s-tabsColumn-j_id_43-j_id_44-autoLoanCalculator-j_id_4a-calculatorFormColumn-j_id_5k-priceInput\']"))
	WebElement price_Value;

	// Find calculate button
	@FindBy(how = How.XPATH, using = ("/html[1]/body[1]/div[2]/div[3]/div[2]/div[1]/form[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]/input[1]"))
	WebElement calculateBtn;

	// Find the results in Auto Loan calculator
	@FindBy(how = How.XPATH, using = ("/html[1]/body[1]/div[2]/div[3]/div[2]/div[1]/form[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[3]"))
	WebElement MonthandInterest;

	@FindBy(how = How.XPATH, using = ("/html[1]/body[1]/div[2]/div[3]/div[2]/div[1]/form[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/span[2]/span[1]"))
	WebElement price1;

	@FindBy(how = How.XPATH, using = ("/html[1]/body[1]/div[2]/div[3]/div[2]/div[1]/form[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/span[2]/span[1]"))
	WebElement totalFinance;

	@FindBy(how = How.XPATH, using = ("/html[1]/body[1]/div[2]/div[3]/div[2]/div[1]/form[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/span[2]/span[1]"))
	WebElement totalInterest;

	@FindBy(how = How.XPATH, using = ("/html[1]/body[1]/div[2]/div[3]/div[2]/div[1]/form[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/span[2]/span[1]"))
	WebElement totalLoan;

	@FindBy(how = How.XPATH, using = ("/html[1]/body[1]/div[2]/div[3]/div[2]/div[1]/form[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[2]"))
	WebElement actualEMI;

	// Check for successfull navigation to home page and loan calculator page
	public void CheckForNavigation() throws IOException, InterruptedException, HeadlessException, AWTException {

		Thread.sleep(2000);
		continueButton.click();

		// Check whether navigated to Autotrader homepage
		Thread.sleep(1000);
		WebElement image = driver.findElement(
				By.xpath("//*[@id=\'mountNode\']/div/div[2]/header/div/div/nav/div/div[1]/div/div[1]/a/img[1]"));

		if (image.isDisplayed())

			System.out.println("Navigated to homepage");
		else {

			System.out.println("Could not navigate to homepage");

		}

		// Click on Car research & reviews
		Thread.sleep(1000);
		carResearch.click();

		// Select monthly payment calculator
		Thread.sleep(1000);
		monthlyPaymentCalculator.click();

		// Check whether navigated to Auto loan calculator page
		Thread.sleep(1000);
		String expectedTitle = "Auto Loan Calculator";
		String actualTitle = driver.findElement(By.xpath("//*[@id=\"atcui-page-wrapper\"]/div[3]/div[2]/h1/span"))
				.getText();

		if (expectedTitle.equals(actualTitle))
			System.out.println("Navigated to loan calculator page");
		else {

			System.out.println("Loan calculator page not displayed");
		}

	}

	// Check if error message is displayed if data is not entered in price field
	public void ValidatePrice() throws HeadlessException, IOException, AWTException {

		try {

			// click on 24 months
			Thread.sleep(500);
			month.click();

			// enter interest rate
			Thread.sleep(500);
			interest_Rate.clear();
			interest_Rate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END), "4.5");

			// click on calculate button
			Thread.sleep(500);
			calculateBtn.click();

			// Check for error message displayed
			Thread.sleep(2000);
			String expectedErrorMsg = "Please fill out the Vehicle Price field.";
			String actualErrorMsg = driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[3]/div[2]/div[1]/form[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]"))
					.getText();
			if (actualErrorMsg.contains(expectedErrorMsg))
				System.out.println("Error message is displayed");

		} catch (Exception e) {
			System.out.println("Price  Error Message not displayed ");

		}

	}
	
	// Calculate EMI for different tenure and interest rates using Auto Loan
		// Calculator
		public void EMICalculator(String rate, String price) throws IOException, HeadlessException, AWTException, InterruptedException {


			// Enter interest rates 
			Thread.sleep(1000);
			interest_Rate.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END), rate);
			
			// Enter price 
			Thread.sleep(1000);
			price_Value.sendKeys(price);
			
			//Click on calculate button
			Thread.sleep(2000);
			calculateBtn.click();

			try {
				// Check if interest is calculated
				Thread.sleep(1000);
				String expectedTxt = "Calculate again";
				String actualTxt = driver.findElement(By.xpath(
						"//*[@id=\'j_id_3s-tabsColumn-j_id_43-j_id_44-autoLoanCalculator-j_id_4a-calculatorFormColumn-j_id_9e\']"))
						.getText();
				Thread.sleep(1000);
				assertEquals(actualTxt, expectedTxt);
				System.out.println("Interest calculated");
			} catch (Exception e) {
				System.out.println("Interest not calculated");
				
			}
		}

		// Method to Calculate EMI and verify the results from Auto Loan calculator
		public void ValidateCalculator( String monthInt, String price, String interest, String finance, String loan, String emi) throws HeadlessException, AWTException, IOException {
			
			String exptedMonthInt = monthInt;
			String expectedTotalInterest = interest;
			String expectedTotalFinance = finance;
			String expectedTotalLoan = loan;
			String expectedEMI = emi;

			// Check whether the results are the same
			try {
				assertEquals(exptedMonthInt, MonthandInterest.getText());
				System.out.println("The price values are" + MonthandInterest.getText() + exptedMonthInt);

				assertEquals(price,price1.getText());
				System.out.println("The price values are" + price1.getText() + price);

				assertEquals(expectedTotalInterest, totalInterest.getText());
				System.out.println("The interest values are" + totalInterest.getText() + expectedTotalInterest);

				assertEquals(expectedEMI, actualEMI.getText());
				System.out.println("The EMI values are" + actualEMI.getText() + expectedEMI);

				assertEquals(expectedTotalFinance, totalFinance.getText());
				System.out.println("The finance values are" + totalFinance.getText() + expectedTotalFinance);

				assertEquals(expectedTotalLoan, totalLoan.getText());
				System.out.println("The loan values are" + totalLoan.getText() + expectedTotalLoan);
				
				System.out.println(" User Story 2:The results are as expected");

			} catch (Exception e) {
				System.out.println(" User Story 2:The results are not as expected");
				
			}

		}



}
