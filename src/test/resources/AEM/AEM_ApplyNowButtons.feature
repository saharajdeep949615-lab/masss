Feature: Apply now Button Validation all pages

  @TRDAN

  Scenario: Prod Organic Apply now Button Validation , when DFSEDKEY is NOT present
    Given DFSEDKEY is not present in the Validation
    |     product     |  region   |   view   |
    |     ITCHROME    |   PROD    |  desktop |
    |      MILES      |   PROD    |  desktop |

    @TRDANB

  Scenario: Prod Organic Apply now Button Validation , when DFSEDKEY is present
    Given DFSEDKEY present in the Validation
      |     product     |  region   |   view   |
      |     ITCHROME    |   PROD    |  desktop |
      |      MILES      |   PROD    |  desktop |
