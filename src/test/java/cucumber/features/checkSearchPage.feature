Feature: Check Search Page shows try-again message

  Scenario Outline:
    Given User wrote incorrect request down: <request>
    Then User should be able to see try-again message
    Examples:
      | request   |
      | blablabla |
      | aaaaa     |