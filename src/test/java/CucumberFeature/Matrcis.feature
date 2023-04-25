Feature: Matrix Calculations
  As Automation Test Engineer I want to perform  the Matrix Class to Ensure it works properly

  Scenario: Create a Matrix with random values
    Given I have a matrix of size3x3
    When  I Create matrix with random values
    Then  The matrix should have values between 0 and 1

 Scenario: Create an identity matrix
   Given I have a matrix of size 4x4
   When  I Create an identity matrix
   Then  The matrix should have 1s on the diagonal and 0s elsewhere

  Scenario: Transpose a matrix
    Given I have a matrix
    When  I Transpose the matrix
    Then  The result of matrix should be transposed

  Scenario: Sum of  two matrix
    Given I have two matrix of the same size
    When  I Add the two matrix
    Then  The result should be sum of the two matrix

  Scenario: Subtract of two matrix
    Given I have two matrix of the same size
    When  I subtract one matrix from the other.
    Then  The result should be the difference of the two matrix

  Scenario: Multiply two matrix
    Given I have to matrix that can be multiplied
    When  I multiply one matrix by the other
    Then  The result matrix should be the product of two matrix

