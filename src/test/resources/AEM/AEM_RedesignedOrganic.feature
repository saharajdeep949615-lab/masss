Feature: Text check all the aem pages

  @TDRR @raj123

    Scenario Outline: Prod Organic Text Validation
    Given Verify each section in the respective "<product>" page in "<view>" view "<region>" region
    And FAQ items are displayed "<faqDisplayed>" in the respective "<product>" page in "<view>" view "<region>" region
    Examples:
      |   product   |    view    |    region    | faqDisplayed |
      |   ITCHROME  |   desktop  |    PROD      |  YES         |
      |    MILES    |   desktop  |    PROD      |  YES         |







