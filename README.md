# Alfred Carre tech test

This document serves as a guide for using the test framework created for the TruNarrative tech test.

The framework uses [Cucumber][cucumber] with [Selenium][selenium] to enable automated web testing.

## Getting started

1. Clone this project `git clone https://github.com/FreddieCarre/cucumber-selenium.git`

## Project Layout

The layout looks something like this

```
.
├── src/
|    └── test/
|        ├── java/
|        |   ├── com/
|        |   |   ├── trunarrative.techtest/
|        |   |   |                ├── glue/
|        |   |   |                |   └── TruNarrativeStepDefs.java
|        |   |   |                |
|        |   |   |                └── pages/
|        |   |   |                    ├── HomePage.java
|        |   |   |                    └── LeadershipPage.java
|        |   |   |
|        |   |   └─ google/
|        |   |      ├── glue/
|        |   |      |   └── GoogleStepDefs.java
|        |   |      └── pages/
|        |   |          ├── SearchPage.java
|        |   |          └── ResultsPage.java
|        |   |
|        |   ├── common/
|        |   |    ├─ glue/
|        |   |    |  └── Utils.java
|        |   |    ├─ BasePage.java
|        |   |    ├─ Config.java
|        |   |    └─ DriverFactory.java
|        |   |
|        |   └── runner/
|        |       └── TestRunner.java
|        |
|        └── resources/
|            ├── configs/
|            |	└── testConfig.properties
|            └── features/
|             	└── google-search.feature
└── pom.xml
```

An overview of some of the important packages.

| Package/file  | Description |
| ------------- | ------------- |
| glue  | Contain step definition classes |
| pages  | Contain page object classes |
| features  | Contain your feature files |
| Utils.java | Contains test setup and teardown functions |
| BasePage.java | Common page interactions |
| Config.java | Used to write config files to System.properties |
| DriverFactory.java | WebDriver management |
| TestRunner.java | Required to run feature files as tests |

## Running tests

Tests can be executed on your own system, or using the provided docker-compose file to run via the containerised selenium grid.

You can run from the command line using mvn clean test, or by using your IDE run configuration (Junit pointing to TestRunner class).

### Execution Options

This framework currently allows execution on Chrome (default) and Firefox.
To choose to run on Firefox, pass the argument `-Dbrowser=firefox` to whichever method you use to run the tests

### Locally

You will need to have either [ChromeDriver][chrome] or [FirefoxDriver][firefox] downloaded and added to your systems path,
this allows Selenium to find the executable. You will also need the correct browser and version installed.

Tests are run locally by default.

### Remote

With [Docker][docker] running on your machine, from the project root, run `docker-compose up`.
This will create the containers for the selenium hub and a node for Firefox and one for Chrome.

This removes the need for installing drivers and browsers locally.

To run the tests, once you have the containers running, you can pass the argument `-Dremote=true` to your test command.


[cucumber]: https://cucumber.io
[selenium]: https://www.seleniumhq.org/
[docker]: https://www.docker.com/
[chrome]: https://chromedriver.chromium.org/downloads
[firefox]: https://www.seleniumhq.org/download/