// Name: Minh Duc Pham

public class Lab1 {
	public static void main (String[] args) {
		
		int maxWidth = 5;
		
		//first pattern
		for (int row =0; row < maxWidth; row++) {
		    for (int i=0; i < row+1; i++) {
		       System.out.print("*");
		    }
		    System.out.println();
		  }
		 System.out.println();
		 
		//second pattern
		for (int row =maxWidth; row >= 0; row--) {
		    for (int i=0; i < row; i++) {
		       System.out.print("*");
		    }
		    System.out.println();
		  }
		
		//third pattern
		for(int row = 0; row < maxWidth; row++) {
            for(int space=1; space < row+1; space++) {
                System.out.print(" ");
            }

            for(int star= maxWidth; star > row; star--) {
                System.out.print("*");
            }
            System.out.println();
        } 
		System.out.println();
		
		//fourth pattern
		 for(int row = maxWidth; row > 0; row--) {
	            for(int space=0; space < row-1; space++) {
	                System.out.print(" ");
	            }
	            for(int star=maxWidth; star > row-1; star--) {
	                System.out.print("*");
	            }
	            System.out.println();
	        }
		 
	}// end of main
}// end of class
