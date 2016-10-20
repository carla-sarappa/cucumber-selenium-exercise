package cucumber.pages

import cucumber.environment.TestEnvironment
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

/**
 * Created by Sarappa Carla on 20/10/16 06:48.
 */
class GrindrCreateAccountPage extends BasePage {

    GrindrCreateAccountPage(WebDriver webDriver) {
        super(webDriver)
    }

    GrindrCreateAccountPage navigateToHomePage() {
        driver.get('http://neo-account.preprod1.grindr.com/signup?locale=en')
        return this
    }

    GrindrCreateAccountPage enterEmail(String email) {
        driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys(email)
        return this
    }

    GrindrCreateAccountPage enterPassword(String password){
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password)
        return this
    }

    GrindrCreateAccountPage enterCaptcha(String captcha){
        driver.findElement(By.xpath("//input[@name='recaptcha_response_field']")).sendKeys(captcha)
        return this
    }

    String getError(){
        driver.findElement(By.id('flash_error')).getText()
        return this
    }


    @SuppressWarnings("GrMethodMayBeStatic")
    void methodThatAcceptsTestEnvironment(TestEnvironment testEnvironment) {
        println "${testEnvironment.class.simpleName}"
    }
}
