# PwC Digital Pulse Project

1. This is a Cucumber-Java Project.
2. We are using Java, Selenium, Cucumber and Maven for project and package management.
3. You can find the available step definitation in /stepdefinition/ in location
4. By default all the test cases will be executed.
5. If you want to execute any specific feature then please update the tag to "Scenario_1 or Scenario_2 or Scenario_3" in the TestRunner.java file
6. You don't need to download driver. We are using WebDriverManager, it will automatically download the driver of browser.

# Running the Test Suite via CLI-

First you need to clone the 'master' branch of this project into your local machine. Make sure that you successfully import all the maven dependencies. After that run the following command to start the execution-

mvn clean install

# Reporting

After execution test report will be generated on the /Reports/ directory.
Report will be generated in 3 formats-
1. html format
2. json format
3. xml format
