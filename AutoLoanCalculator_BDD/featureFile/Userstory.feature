Feature: verify Auto Loan Calculator 
	As an user I want to check whether 
    - An error message is displayed if price is not entered in the Auto Loan calculator
    - Check whether Auto Loan calculator calculates EMI and the generated values are correct
    
Scenario: Check for price error message 
	Given I navigated to the auto loan calculator page 
	When I entered details without price and clicked calculate 
	Then I Should get an error message 
	
Scenario Outline: Check for price error message 
	Given I navigated to the auto loan calculator page 
	When I entered details "<interestRate>" "<price>" and click on the calculate button 
	Then I should be able to verify the generated values"<monthInt>" "<exp_price>"  "<interest>" "<finance>"  "<loan>" "<emi>" 
	Examples: 
	
		|interestRate|price|    |monthInt                  |  exp_price |interest|finance| loan  | emi|  
		|4.5| $10000|           |for 60 months at 4.5% APR.| $10,000|$1,186  |$10,000|$11,186|  $187 /month|    