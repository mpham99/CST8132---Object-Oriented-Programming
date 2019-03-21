public class ExerciseTwo {

	public int [][] myArray2;

	public ExerciseTwo() {
		myArray2= new int[8][10]; 
		// i for columns, j for rows
		for (int i=0; i<8; i++)
			for (int j=0; j<10; j++)
				myArray2[i][j] = j+1 + (i*10);
	}// end of ExerciseTwo

	public void printArrayValues() {
		System.out.println("myArray2 = {");

		for (int i=0; i<8; i++) {// create rows
			System.out.print("{");
			
			for (int j=0; j<10; j++) {// put numbers in the rows
				System.out.print(myArray2[i][j]);
				System.out.print(",");	
			}// end of inner loop
			
			System.out.println("}");
		}// end of exterior loop
		
		System.out.println("};");
	}// end of printArrayValues

	public void displayArrayTotal() {
		//int i,j;
		int total = 0;
		for (int[] a : myArray2)
			for (int b : a)
				total += b;
		System.out.println("Sum of all elements of myArray2 is " + total);
	}// end of displayArrayTotal

}// end of class
