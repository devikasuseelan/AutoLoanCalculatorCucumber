$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Userstory.feature");
formatter.feature({
  "line": 1,
  "name": "verify Auto Loan Calculator",
  "description": "As an user I want to check whether \r\n  - An error message is displayed if price is not entered in the Auto Loan calculator\r\n  - Check whether Auto Loan calculator calculates EMI and the generated values are correct",
  "id": "verify-auto-loan-calculator",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Check for price error message",
  "description": "",
  "id": "verify-auto-loan-calculator;check-for-price-error-message",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "I navigated to the auto loan calculator page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I entered details without price and clicked calculate",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I Should get an error message",
  "keyword": "Then "
});
formatter.match({
  "location": "UserStory.I_navigated_to_the_auto_loan_calculator_page()"
});
formatter.result({
  "duration": 34238961538,
  "status": "passed"
});
formatter.match({
  "location": "UserStory.I_entered_details_without_price_and_clicked_calculate()"
});
formatter.result({
  "duration": 4462236474,
  "status": "passed"
});
formatter.match({
  "location": "UserStory.I_Should_get_an_error_message()"
});
formatter.result({
  "duration": 2100583244,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "Check for price error message",
  "description": "",
  "id": "verify-auto-loan-calculator;check-for-price-error-message;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 12,
  "name": "I navigated to the auto loan calculator page",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "I entered details \"4.5\" \"$10000\" and click on the calculate button",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "I should be able to verify the generated values\"for 60 months at 4.5% APR.\" \"$10,000\"  \"$1,186\" \"$10,000\"  \"$11,186\" \"$187 /month\"",
  "matchedColumns": [
    3,
    4,
    5,
    6,
    7,
    8
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "UserStory.I_navigated_to_the_auto_loan_calculator_page()"
});
formatter.result({
  "duration": 38121185564,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "4.5",
      "offset": 19
    },
    {
      "val": "$10000",
      "offset": 25
    }
  ],
  "location": "UserStory.I_entered_details_and_click_on_the_calculate_button(String,String)"
});
formatter.result({
  "duration": 7054275219,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "for 60 months at 4.5% APR.",
      "offset": 48
    },
    {
      "val": "$10,000",
      "offset": 77
    },
    {
      "val": "$1,186",
      "offset": 88
    },
    {
      "val": "$10,000",
      "offset": 97
    },
    {
      "val": "$11,186",
      "offset": 108
    },
    {
      "val": "$187 /month",
      "offset": 118
    }
  ],
  "location": "UserStory.I_should_be_able_to_verify_the_generated_values(String,String,String,String,String,String)"
});
formatter.result({
  "duration": 1503524317,
  "status": "passed"
});
});