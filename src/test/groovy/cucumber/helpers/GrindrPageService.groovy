package cucumber.helpers

import cucumber.environment.TestEnvironment

import cucumber.pages.GrindrCreateAccountPage
import groovy.util.logging.Slf4j
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

/**
 * Created by Sarappa Carla on 20/10/16 06:45.
 */

@Slf4j

class GrindrPageService {
    final TestEnvironment testEnvironment
    final WebDriver driver
    private GrindrCreateAccountPage grindrCreateAccountPage

    GrindrPageService(TestEnvironment tstEnv) {
        testEnvironment = tstEnv
        driver = testEnvironment.driver
        grindrCreateAccountPage = new GrindrCreateAccountPage(driver)
    }

    void onGrindrCreateAccountPage() {
        grindrCreateAccountPage.navigateToHomePage()
    }

    void enterEmail(String email) {
        grindrCreateAccountPage.enterEmail(email)
    }

    void enterPassword(String password) {
        grindrCreateAccountPage.enterPassword(password)
    }

    void enterCaptcha(String captcha) {
        grindrCreateAccountPage.enterCaptcha(captcha)
    }

    void clickCreateAccountButton() {
        driver.findElement(By.xpath("//input[@type='submit' and @value='Create Account']")).submit()
    }

    String getErrorMessage(){
        grindrCreateAccountPage.getErrorMessage()
    }

    void exampleUseOfTestEnvironmentInMethod() {
        grindrCreateAccountPage.methodThatAcceptsTestEnvironment(testEnvironment)
    }

    static void logInfoMessage(String message) {
        log.info(message)
    }

    static void logWarnMessage(String message) {
        log.warn(message)
    }
}
