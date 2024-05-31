Feature: Place an order via E-Commerce website

Background:
Given Landing on login page

Scenario Outline:
Given Enter username <name> and password <pass>
When Add product <product> to cart and checkout
Then Click on checkout button and submit order
And verify "THANKYOU FOR THE ORDER." message is displayed

Examples:
|name|pass|product|
|srinivasvas.sv47@gmail.com|Santyvas@1203|ZARA COAT 3|