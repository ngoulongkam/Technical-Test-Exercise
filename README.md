# Technical-Test-Exercise
This project aims to build a well structured test automation framework, as part of the Capgemini technical test assessment.
## Requirements
Should include multiple tests, that can all be ran with one command, that run automatically against the http://automationpractice.com domain. It should achieve the following:
```
1. Create a new account
2. Login
3. Find the most expensive dress and add it to the cart
4. Log out and back in again, ensuring the dress is still in the cart
```
## Prerequisites
The following prerequisites are required to run the framework:
```
JVM Language: Java 11.0.4
Dependency Manager: Maven 3.5.1
  - Selenium 3.141.59
  - JUnit 4.12
  - JUnit Jupiter 5.5.2
Driver Injection: ChromeDriver 78.0.3904.70 (Important ChromeDriver version matches version of Chrome on the machine)
IDE: IntelliJ IDEA (Any compatible IDEs are fine)
```
Java was chosen as the prefered language of choice, as it is the language I have developed the most during my time with Ten10. Additionally, the use of Maven allows all dependencies to be managed easily within the same environment. The combination of Selenium and ChromeDriver allows for automation to be completed within one of the most popular user browsers. The inclusion of JUnit external libary allows for repeatable unit tests to be written and handles test validation.
## Automated Tests
Within the project's source files, you will find the following:
```
PageObjects: OO approach that provides the automation behaviour for each page interacted with. 
- SourcePage
- HomePage
- SignInPage
- RegistrationPage
- DressesPage
- CheckoutPage
Tests: 
- TestSuite (Used to run all tests at once. **Run this method**)
- Registration
- SignIn
- UserJourney
```
Within the PageObjects package you will find all the relevant source code used to complete
Selenium actions. While the Tests package follows an Arrange, Act and Assert principle; individual 
unit tests that focus on each of the requirements set. Instances of the pages are declared,
methods called and tests asserted.
### Known Bugs
1. When ordering Dresses, on the product page, the site becomes unresponsive and stuck on 'Loading'. This means
the 'UserJourney: addMostExpensiveDressToCart' fails. However, an assertion error message is provided.
2. When a user logs back in, the website fails to remember which items had been in their cart. Therefore, the 'UserJourney: checkProductAlwaysRemainsInUserCart' also fails.
## Author
Ewan Hardingham
ewan.hardingham@ten10.com
