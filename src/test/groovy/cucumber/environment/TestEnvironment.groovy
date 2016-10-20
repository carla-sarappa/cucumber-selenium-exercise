package cucumber.environment

import cucumber.eventlistener.MyWebDriverEventListener

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.support.events.EventFiringWebDriver


class TestEnvironment {
    WebDriver driver

    TestEnvironment() {}

    WebDriver loadEnvironment() {
        readCommandLineArguments()
        return loadSelenium()
    }

    private void readCommandLineArguments() {
        // read from command line
    }

    @SuppressWarnings("GrMethodMayBeStatic")
    private WebDriver loadSelenium() {
        driver = new EventFiringWebDriver(new FirefoxDriver()).register(new MyWebDriverEventListener())
        return driver
    }
}
