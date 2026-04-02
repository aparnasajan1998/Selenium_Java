Feature: Search and Place the order for products
#  Scenario: Search experience for product search in both home and offers page
#
#    Given User is on GreenCart Landing page
#    When User searched with short name "tom" and extracted actual name
#    Then User searched for "tom" shortname in offers page
#    And Validate product name in offers page matches with landing page

#there is a concept of Scenario Outline which helps to parameterize the test with different data sets.Feature:
@OffersPage
  Scenario Outline: Search experience for product search in both home and offers page

    Given User is on GreenCart Landing page
    When User searched with short name <Name> and extracted actual name
    Then User searched for <Name> shortname in offers page
    And Validate product name in offers page matches with landing page

    Examples:
    | Name |
    | Tom |
    | Beet |