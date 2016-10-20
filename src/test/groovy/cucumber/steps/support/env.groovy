package cucumber.steps.support

import cucumber.api.groovy.Hooks
import cucumber.helpers.GrindrPageService

import cucumber.environment.TestEnvironment
import cucumber.runtime.ScenarioImpl
import org.openqa.selenium.WebDriver

this.metaClass.mixin(Hooks)

class CustomWorld {
    final WebDriver driver
    final TestEnvironment testEnvironment
    final GrindrPageService grindrPageService

    CustomWorld() {
        testEnvironment = new TestEnvironment()
        driver = testEnvironment.loadEnvironment()
        grindrPageService = new GrindrPageService(testEnvironment)
    }

}

World {
    new CustomWorld()
}

Before() {
    println "BEFORE hook called"
    println "WEB DRIVER SELECTED: ${driver.class.simpleName}"
}

Before("@pending") { ScenarioImpl scenario ->
    grindrPageService.logWarnMessage("Scenario = '${scenario.name}' is pending a fix")
}

After() { ScenarioImpl scenario ->
    try {
        println "AFTER hook called"
        println "STEP STATUS: ${scenario.status}\n\n\n"
    } finally {
        driver.quit()
    }

}


