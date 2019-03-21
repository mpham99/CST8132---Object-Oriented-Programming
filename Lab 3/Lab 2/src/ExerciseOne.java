
public class ExerciseOne {

	public int [] myArray;
	
	public ExerciseOne() {
		myArray = new int[10];
		for (int i=0; i<10; i++)
			myArray[i] = i+1;
	}// end of ExerciseOne

	public void printArrayValues() {

		System.out.print("myArray = {");
		int i;
		for (i=0; i<9;i++) {
			System.out.print(myArray[i]);
			System.out.print(",");
		}// end of for loop
		
		System.out.println(myArray[i] + "}");
	}// end of printArrayValues

	public void displayArrayTotal() {
		
		int total = 0;
		for (int a:myArray)
			total += a;
		System.out.println("Sum of all elements of myArray is " + total);
	}// end of displayArrayTotal

}
