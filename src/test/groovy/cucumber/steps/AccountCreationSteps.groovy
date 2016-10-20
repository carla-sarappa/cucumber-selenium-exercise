package cucumber.steps

import static cucumber.api.groovy.EN.Given
import static cucumber.api.groovy.EN.Then
import static cucumber.api.groovy.EN.When

/**
 * Created by Sarappa Carla on 20/10/16 05:54.
 */


Given(~'^I am on Grindr Create Account page$') { ->
    println "\n\tInside step 'I am on Grindr Create Account page'"
    grindrPageService.onGrindrCreateAccountPage()
    grindrPageService.exampleUseOfTestEnvironmentInMethod()
}

When(~'^I enter "([^"]*)" as email$' ) { String email ->
    grindrPageService.enterEmail(email)
}

When(~/^I enter "([^"]*)" as password$/) { String password ->
    grindrPageService.enterPassword(password)
}

When(~/^I enter "([^"]*)" as captcha$/) { String captcha ->
    grindrPageService.enterCaptcha(captcha)
}

When(~'^click the Create Account button$') { ->
    grindrPageService.clickCreateAccountButton()
}

Then(~'^the error returned is "([^"]*)"$') { String expectedErrorMessage ->
    def actualErrorMessage = grindrPageService.getErrorMessage()
    assert expectedErrorMessage == actualErrorMessage : "The expected error message, '$expectedErrorMessage', does not match the actual,'$actualErrorMessage'"

}
