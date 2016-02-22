import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import  org.junit.Test;

public class MatrixTest {
	@Test
	public void populateMatrix(){
		Matrix  matrixOfTwoByTwo = new Matrix(2,2);
		int[] values = {1,2,3,4};
		matrixOfTwoByTwo.populate(values);
		assertEquals(matrixOfTwoByTwo.getValueAt(0,0),1);
		assertEquals(matrixOfTwoByTwo.getValueAt(0,1),2);
		assertEquals(matrixOfTwoByTwo.getValueAt(1,0),3);
		assertEquals(matrixOfTwoByTwo.getValueAt(1,1),4);

		Matrix  matrixOfTwoByThree = new Matrix(2,3);
		int[] _values ={2,4,6,8,1,0};

		matrixOfTwoByThree.populate(_values);
		assertEquals(matrixOfTwoByThree.getValueAt(0,0),2);
		assertEquals(matrixOfTwoByThree.getValueAt(0,1),4);
		assertEquals(matrixOfTwoByThree.getValueAt(0,2),6);
		assertEquals(matrixOfTwoByThree.getValueAt(1,0),8);
		assertEquals(matrixOfTwoByThree.getValueAt(1,1),1);
		assertEquals(matrixOfTwoByThree.getValueAt(1,2),0);

	}
	@Test
	public void add_two_matrix(){
		Matrix matrix1= new Matrix(2,2);
		Matrix matrix2= new Matrix(2,2);
		Matrix result = new Matrix(2,2);
		int[] values = {1,2,3,4};
		int[] ans = {2,4,6,8};
		matrix1.populate(values);
		matrix2.populate(values);
		Matrix addedMatrix = matrix1.addTo(matrix2);
		result.populate(ans);
		String b = "this is fake";
		assertNotEquals(matrix1,result);
		assertNotEquals(result,b);
		assertEquals(result,addedMatrix);
	};

	@Test
	public void add_two_matrix_of_different_sizes(){
		Matrix matrix1= new Matrix(2,2);
		Matrix matrix2= new Matrix(2,3);
		Matrix nullMatrix = new Matrix(0,0);
		int[] values = {1,2,3,4};
		int[] values2 = {1,2,3,4,5,6};
		matrix1.populate(values);
		matrix2.populate(values2);
		Matrix addedMatrix = matrix1.addTo(matrix2);
		assertEquals(addedMatrix,nullMatrix);
	};

	@Test
	public void multiply_of_two_matrixs(){
		Matrix matrixOf2By3 = new Matrix(2,3);
		Matrix matrixOf3By3 = new Matrix(3,3);
		Matrix result = new Matrix(2,3);
		int[] values1 = {2,3,4,5,6,7};
		int[] values2 = {1,3,3,4,5,6,7,8,9};
		matrixOf2By3.populate(values1);
		matrixOf3By3.populate(values2);
		int[] expected = {42,53,60,78,101,114};
		result.populate(expected);
		Matrix multipliedMatrix = matrixOf2By3.multiply(matrixOf3By3);
		assertEquals(multipliedMatrix,result);
		assertNotEquals(multipliedMatrix,matrixOf3By3);

	};
	@Test
	public void multiply_of_two_matrixs_which_are_3_by_3_in_size(){
		Matrix matrix1 = new Matrix(3,3);
		Matrix matrix2 = new Matrix(3,3);
		Matrix result = new Matrix(3,3);
		int[] values1 = {2,4,6,7,3,8,1,8,3};
		int[] values2 = {9,8,7,1,5,8,9,4,2};
		matrix1.populate(values1);
		matrix2.populate(values2);
		int[] expected = {76,60,58,138,103,89,44,60,77};
		result.populate(expected);
		Matrix multipliedMatrix = matrix1.multiply(matrix2);
		assertEquals(multipliedMatrix,result);
		assertNotEquals(multipliedMatrix,matrix2);

	};

	@Test
	public void multiply_of_two_matrixs_which_are_not_multiplicable(){
		Matrix matrix1 = new Matrix(3,3);
		Matrix matrix2 = new Matrix(2,3);
		Matrix result = new Matrix(0,0);
		int[] values1 = {2,4,6,7,3,8,1,8,3};
		int[] values2 = {1,5,8,9,4,2};
		matrix1.populate(values1);
		matrix2.populate(values2);
		Matrix multipliedMatrix = matrix1.multiply(matrix2);
		assertEquals(multipliedMatrix,result);
	};
	@Test
	public void determinant_of_3_by_3_matrix(){
		Matrix matrix = new Matrix(3,3);
		int[] values = {1,2,3,3,2,1,2,1,3};
		matrix.populate(values);
		int determinantOfMatrix = matrix.findDeterminant();
		assertEquals(determinantOfMatrix,-12);
	}
	@Test
	public void determinant_of_3_by_3_matrix_of_1_to_9(){
		Matrix matrix = new Matrix(3,3);
		int[] values = {6,7,9,5,9,1,98,43,86};
		matrix.populate(values);
		int determinantOfMatrix = matrix.findDeterminant();
		assertEquals(determinantOfMatrix,-3941);
	};

	@Test
	public void determinant_of_2_by_2_matrix(){
		Matrix matrix = new Matrix(2,2);
		int[] values = {6,7,9,11};
		matrix.populate(values);
		int determinantOfMatrix = matrix.findDeterminant();
		assertEquals(determinantOfMatrix,3);
	}

	@Test
	public void determinant_of_2_by_2_null_matrix(){
		Matrix matrix = new Matrix(2,2);
		int[] values = {0,0,0,0};
		matrix.populate(values);
		int determinantOfMatrix = matrix.findDeterminant();
		assertEquals(determinantOfMatrix,0);
	};

	@Test
	public void determinant_of_odd_matrix(){
		Matrix matrix = new Matrix(2,3);
		int[] values = {3,5,20,2,43,41};
		matrix.populate(values);
		int determinantOfMatrix = matrix.findDeterminant();
		assertEquals(determinantOfMatrix,0);
	};

	@Test
	public void determinant_of_4_by_4_matrix(){
		Matrix matrix = new Matrix(4,4);
		int[] values = {2,56,2,6,12,53,75,81,12,45,78,13,134,86,9,0};
		matrix.populate(values);
		int determinantOfMatrix = matrix.findDeterminant();
		assertEquals(determinantOfMatrix,37578488);
	};

	@Test
	public void determinant_of_5_by_5_matrix(){
		Matrix matrix = new Matrix(5,5);
		int[] values = {2,56,2,6,1,12,53,75,81,0,5,12,45,78,13,34,134,86,9,0,34,134,86,19,10};
		matrix.populate(values);
		int determinantOfMatrix = matrix.findDeterminant();
		assertEquals(determinantOfMatrix,-7124500);
	}
	
	
}