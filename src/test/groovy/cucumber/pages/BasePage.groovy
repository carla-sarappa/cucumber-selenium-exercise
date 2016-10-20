package cucumber.pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait


class BasePage {
    final WebDriver driver

    BasePage(WebDriver webDriver) {
        driver = webDriver
    }

    String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 10)
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id('flash_error')))

        return driver.findElement(By.id('flash_error')).getText()
    }


}
