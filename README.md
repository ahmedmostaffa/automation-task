
# BDD framework 

[![issues](https://custom-icon-badges.herokuapp.com/github/issues-raw/DenverCoder1/custom-icon-badges?logo=issue)](https://github.com/ahmedmostaffa "issues")
![GitHub contributors](https://img.shields.io/github/contributors/ahmedmostaffa/Selenium_training-)
![CI](https://img.shields.io/badge/CI-Jenkins-yellow)

BDD framework covering web UI testing using selenium WebDriver, cucumber and testNG for the 
following scenario:

```feature
 Scenario Outline: check the search functionality
    Given user open Nagwa home page
    And user choose "<language>" language
    When user search for "<specific>" lesson on search bar
    And  a list with all lessons that match the "<input>" will appear
    And user click on link 2 in the search results
    And user go to the worksheet section
    Then "<worksheet>" home page will open
    And all the questions are displayed
```

## Concepts Included

* Factory design pattern
* Page object model
* Utility classes

## Tools and technology used:
* TestNG unit testing framework.
* Cucumber BDD tool.
* Selenium WebDriver Web UI automation tool.
* Maven automation build tool.
* Extent, Cucumber report.

## Software Requirements

* Maven.
* Java 18.0.

## Framework Structure
### Overview
 - **BDD-framework**
    - **resources/**: contains all the screenshots, test data, feature files.
        - **screenshots/**: contain the taken screenshots. 
        - **recordings/**:
        - **testdata/**: excel, json files.
        - **features/**: the feature file specifies the steps in gherkin language.
    - **test-output/**: HTML, PDF reports (extent reports).
    - **target/**: cucumber report.
    - **src/main/java**
    - **src/test/java**
    - **src/main/resources**: log4j.properties ,config.properties (configuration of the framework)
    - **src/test/resources**: configuration of extent reports. 

- **src/main/java**: framework related part with PageObjects, drivers factory, utilities, listeners.
  - **utilities/**: utilities classes (Excel reader,element actions ,browser actions,..)
  - **drivers/**: driver factory.
  - **pages/**: page objects. (page elements and methods)
  - **listeners/**: listener classes.
  - **assertion/**: assertion classes.

- **src/test/java**  framework related part with test-runners, step definitions and cucumber hooks.
  - **runners/**: Features/tests to be executed are defined in this class.
  - **steps/**: the steps from the feature file are broken down to be coded into automation tests.
  - **hooks/**: cucumber 🥒 hooks.

## Documentation
### WebDriverManager.
#### Supported Browser WebDriver
|  Browser  |     WebDriver     | 
| :-------- | :-------          | 
|  Chrome   | ChromeDriver      | 
|  Firefox  | FirefoxDriver     |
|  Edge     | EdgeDriver        |

### Driver factory
#### Instantiating WebDriver.  
Factory design pattern a popular OOP pattern have been used to allow for easier extension and decoupled code.This helps create a really simple one-line-of-code way to create your WebDriver instance.

```Java
  public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String browser = "chrome";
        driver = new DriverFactory().createWebDriver(browser);
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
```


### Support video recording automatically.

BDD framework records a video for each execution when running runners during headed mode . Videos are not automatically recorded during headless mode.

Video recording can be turned off entirely by setting video to false from within your configuration/properties file .

Videos are stored in the recordings Folder which is set to resources/recordings by default with following format `recording DD-MM-yyyy HH:mm:ss`

### Logging
Logging can be easily added to runners by using the static methods from the Log class.
 
There are different logging message such as the following:

|Logging Level|Method                                       |
|:------------|:--------------------------------------------|
|Info         |log.Info("This is an info level message ");   |
|Warn         |log.Warn("This is a warning level message"); |
|Error        |log.error("This is an error level message");  |
|Debug        |log.debug("This is a debug level message");   |

### Properties file.

This is mainly used to configure the settings that are going to change as per times or environment or user profiles.
which will contain our framework configuration such as 

`runMode = local`
`baseURL = https://...`
`headless = true `
`language = EN `
`RemoteURL = https://localhost:4444/wd/hub `
`videoRecording = OFF `
`pageLoadTimeOut =  `
`implicitlyWait =  `
`max.timeOut.explicitWait= `   
`browser = chrome`

## Framework set up
* Clone repository from the following command or download zip and set it up in your local workspace.
 ```git 
git clone https://github.com/ahmedmostaffa/Nagwa-Automation-Task.git
 ```
* Open the project using any Java IDE.
## Running Tests Locally
* Open terminal (MAC OSX) or command prompt / PowerShell (for Windows OS) and navigate to the project directory.
* Type the below script
 ```
mvn clean test -DfileName=testng.xml
 ```




