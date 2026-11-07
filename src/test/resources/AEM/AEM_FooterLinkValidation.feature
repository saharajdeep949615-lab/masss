Feature: Footer link validation for all pages

  @TRDF

  Scenario: Prod Organic page Link Validation
    Given Validation footer link present in the Validation
    |      product            |  region  |   view_port  |
    |      ITCHROME           |   PROD   |   desktop    |
    |      MILES              |   PROD   |   desktop    |

 #################################################### PA ###############################################

  @TRDPF

  Scenario: PA Organic page Link Validation
    Given Validation footer link present in the Validation
      |      product            |  region  |   view_port  |
      |      ITCHROME           |   PA     |   desktop    |
      |      MILES              |   PA     |   desktop    |