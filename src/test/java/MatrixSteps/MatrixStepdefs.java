package MatrixSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import matrix.Matrix;
import org.junit.Assert;

public class MatrixStepdefs {
    private Matrix matrix;
    private Matrix otherMatrix;
    private Matrix resultMatrix;
    @Given("I have a matrix of size{int}x{int}")
    public void createMatrix(int rows, int columns) {
        matrix=new Matrix(rows, columns);
    }

    @When("I Create matrix with random values")
    public void createRandomMatrix() {
        matrix=Matrix.random(matrix.getRows(),matrix.getColumns());
    }
    @Then("The matrix should have values between 0 and 1")
    public void matrixShouldHaveRandomValues() {
        for(double[]row:matrix.getData()){
            for(double value:row){
                Assert.assertTrue(value>=0 && value<=1);
            }
        }
    }
    @Given("I have a matrix of size 4x4")
    public void HaveAMatrixOfSizeX(int rows, int columns) {
        matrix=new Matrix(rows,columns);
    }


    @When("I Create an identity matrix")
    public void CreateIdentityMatrix(){
        matrix= Matrix.identity(matrix.getRows());
    }
    @Then("The matrix should have 1s on the diagonal and 0s elsewhere")
    public void matrixShouldHaveIdentityValues() {
        for(int i=0;i<matrix.getRows();i++){
            for(int j=0;j<matrix.getColumns();j++){
                if(i==j){
                    Assert.assertEquals(1.0,matrix.get(i,j),0.0001);
                }else {
                    Assert.assertEquals(0.0,matrix.get(i,j),0.0001);
                }
            }
    }
    }
    @Given("I have a matrix")
    public void createMatrix() {
        matrix=new Matrix(new double[][] {{1.0,2.0,},{3.0,4.0,}});
    }
    @When("I Transpose the matrix")
    public void TransposeTheMatrix() {resultMatrix=matrix.transpose();
    }

    @Then("The result of matrix should be transposed")
    public void theResultOfMatrixShouldBeTransposed() {
        for(int i=0;i<matrix.getRows();i++){
            for(int j=0;i<matrix.getColumns();i++){
                Assert.assertEquals(matrix.get(i,j),resultMatrix.get(j,i),0.0001);
            }
        }
    }
    @Given("I have two matrix of the same size")
    public void HaveTwoMatrixOfTheSameSize() {
            matrix = new Matrix(new double[][] {{1.0, 2.0}, {3.0, 4.0}});
            otherMatrix = new Matrix(new double[][] {{5.0, 6.0}, {7.0, 8.0}});
        }
    @When("I Add the two matrix")
    public void AddTheTwoMatrix() {
        resultMatrix = matrix.plus(otherMatrix);
    }
    @Then("The result should be sum of the two matrix")
    public void theResultShouldBeSumOfTheTwoMatrix() {
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                Assert.assertEquals(matrix.get(i, j) + otherMatrix.get(i, j), resultMatrix.get(i, j), 0.0001);
            }
        }
    }
    @When("I subtract one matrix from the other.")
    public void SubtractOneMatrixFromTheOther() {
        resultMatrix = matrix.subtract(otherMatrix);
    }
    @Then("The result should be the difference of the two matrix")
    public void theResultShouldBeTheDifferenceOfTheTwoMatrix() {
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                Assert.assertEquals(matrix.get(i, j) - otherMatrix.get(i, j), resultMatrix.get(i, j), 0.0001);
            }
        }
    }
    @Given("I have to matrix that can be multiplied")
    public void MatrixThatCanBeMultiplied() {
    }

    @When("I multiply one matrix by the other")
    public void MultiplyMatrix() {
        resultMatrix = matrix.multiplyBy(otherMatrix);
    }
    @Then("The result matrix should be the product of two matrix")
    public void theResultMatrixShouldBeTheProductOfTwoMatrix() {
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                double expectedValue = 0;
                for (int k = 0; k < matrix.getColumns(); k++) {
                    expectedValue += matrix.get(i, k) * otherMatrix.get(k, j);
                }
                Assert.assertEquals(expectedValue, resultMatrix.get(i, j), 0.0001);
            }
        }
    }

}
