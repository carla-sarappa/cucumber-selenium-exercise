Feature: Account creation

  Scenario: Invalid email
    Given I am on Grindr Create Account page
    When I enter "a@a.a" as email
    And click the Create Account button
    Then the error returned is "Email is invalid"

  Scenario: Blank password
    Given I am on Grindr Create Account page
    When I enter "carla.sarappa@gmail.com" as email
    And I enter "" as password
    And click the Create Account button
    Then the error returned is "Password can't be blank"

  Scenario: Invalid password too short
    Given I am on Grindr Create Account page
    When I enter "carla.sarappa@gmail.com" as email
    And I enter "asd" as password
    And click the Create Account button
    Then the error returned is "Password is too short (minimum is 6 characters)"

  Scenario: Invalid captcha
    Given I am on Grindr Create Account page
    When I enter "carla.sarappa@gmail.com" as email
    And I enter "asdasda" as password
    And I enter "asd" as captcha
    And click the Create Account button
    Then the error returned is "You typed the CAPTCHA words incorrectly. Please try again."

#  Casos de prueba a comprobar:
#  Validar que un error es mostrado al usuario
  # en caso de que el email este vacio o sea inválido
#  Validar que un error es mostrado al usuario
  # si el password es inválido (menor a 6 caracteres) o vacio
#  Validar que aun ingresando campos validos para el email y password
  # no es posible crear la cuenta introduciendo un CAPTCHA invalido