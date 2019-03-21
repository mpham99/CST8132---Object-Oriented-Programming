
public class ExerciseThree {

	public int [][][] myArray3;

	public ExerciseThree() {
		myArray3= new int[8][10][3]; 
		// i for columns, j for rows, k for columns in one row
		for (int i=0; i<8; i++) 
			for (int j=0; j<10; j++)
				for (int k=0; k<3; k++)
					myArray3[i][j][k] = j+1 + (i*10) + (k*80);
	}

	public void printArrayValues() {
		System.out.println("myArray3 = {");

		for (int i=0; i<8; i++) {// 
			System.out.print("{");

			for (int j=0; j<10; j++) {
				System.out.print("{");

				for (int k=0; k<3; k++) {
					System.out.print(myArray3[i][j][k]);
					if(k<2)
						System.out.print(",");
				}// end of inner loop #2	

				System.out.print("}");
				System.out.print(",");

			}// end of inner loop #1
			
			System.out.print("}");
			System.out.println(",\n");
		}// end of for loop

		System.out.println("};");
		
	}// end of printArrayValues

	public void displayArrayTotal() {
		int i,j;
		int total = 0;
		for (int[][] x : myArray3 ) 
			for (int [] y : x)
				for (int z : y)
					total += z;
		System.out.println("Sum of all the elements of the array is " + total);
	}



}
