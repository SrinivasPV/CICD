Feature: Error Validation

Background:
Given Landing on login page

Scenario Outline:
Given Enter username <name> and password <pass>
Then Check for any error
And verify the error message

Examples:
|name|pass|
|srinivasvas.sv47@gmail|Santy@123|