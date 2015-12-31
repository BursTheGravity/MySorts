//Leo Au-Yeung
//APCS1 pd10
//MySorts.java
//2015-12-23

//contains bubbleSort, selectionSort, & bogoSort

import java.util.ArrayList;

public class MySorts {
	
	//~~~~~~~~~~~~~~~~~~~~~~~ArrayUtils~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static Object[] populateInt (Object[] s, int lower, int upper) {
		for (int x = 0 ; x < s.length ; x += 1) {
			s[x] = ((int)(Math.random() * (upper - lower))) + lower;
		}
		return s;
	}
	
	//populates with alphabet
	public static Object[] populateStr (Object[] s) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		for (int x = 0 ; x < s.length ; x += 1) {
			int pos = (int)(Math.random() * (25));
			s[x] = alphabet.substring(pos,pos+1);
		}
		return s;
	}
	
	public static String stringify (Object[] a) {
		String ans ="";
		for (Object x : a) {
			ans += x + " ";
		}
		return ans;
	}
	
	public static int linSearch (Object[] a, Object target) {
		for (int x = 0; x < a.length ; x += 1) {
			if (a[x] == target) {
				return x;
			}
		}
		return -1;
	}
	
	public static int frequency (Object[] a, Object target) {
		int freq = 0;
		for (int x = 0; x < a.length ; x += 1) {
			if (a[x] == target) {
				freq += 1;
			}
		}
		return freq;
	}
	
  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
		ArrayList<Integer> retAL = new ArrayList<Integer>();
		while( size > 0 ) {
			//     offset + rand int on interval [lo,hi]
			retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
			size--;
		}
		return retAL;
	}
	
    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
		int randomIndex;
        for( int i = al.size()-1; i > 0; i-- ) {
			//pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
			//swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
		}
	}
	
	//checks if ArrayList is sorted
	public static boolean isSorted(ArrayList<Integer> data) {
		for (int i = 0; i < data.size() - 1; i++) {
			//goes through entire AL
			if ( (data.get(i)).compareTo(data.get(i + 1) > 0 ) {
				//checks for any occurrences of index greater than next index
				return false;
			}
		}
		return true;
	}
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
  /*======================================
  BubbleSort methods -- implements bubblesort algorithm (vanilla version)
  ======================================*/
  
  // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bubbleSortV( ArrayList<Comparable> data ) {
		for (int ctr = 0; ctr < data.size(); ctr++) {
			for (int i = data.size() - 1 ; i > 0 ; i--) {
				if ( (data.get(i)).compareTo(data.get(i-1)) < 0 ) {
					Comparable temp1 = data.get(i);
					Comparable temp2 = data.get(i-1);
					data.set(i, temp2);
					data.set(i-1, temp1);
				}
				System.out.println("After " + (5 - i) + " sorts: " + data);
			}
		}
	}//end bubbleSortV -- O(n^2)
	
  // ArrayList-returning bubbleSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input ) {
		//ArrayList<Comparable> temp = input;
		//Confused about whether the input was supposed to be sorted or not
		ArrayList<Comparable> temp = new ArrayList<Comparable>();
		for (int x = 0; x < input.size(); x++) {
			temp.add(input.get(x));
		}
		bubbleSortV(temp);
		return temp;
	}//end bubbleSort -- O(n)
	
	/*======================================
  SelectionSort methods -- implements bubblesort algorithm
  ======================================*/
	
	// VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void selectionSortV( ArrayList<Comparable> data ) {
		for (int pos = 0; pos < data.size() - 1; pos++) {
			Comparable min = data.get(pos);
			int minPos = pos;
			for (int i = pos; i < data.size(); i++) {
				if ( (data.get(i)).compareTo(min) <= 0 ) {
					min = data.get(i);
					minPos = i;
				}
			}
			data.set(minPos, data.get(pos));
			data.set(pos, min);
		}
	}//end selectionSort -- O(n^2)
	
	
    // ArrayList-returning selectionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> selectionSort( ArrayList<Comparable> input ) {
		ArrayList<Comparable> temp = new ArrayList<Comparable>();
		for (int x = 0; x < input.size(); x++) {
			temp.add(input.get(x));
		}
		selectionSortV(temp);
		return temp;
	}//end selectionSort -- O(n)
	
	/*======================================
  BogoSort methods -- implements bubblesort algorithm
  ======================================*/
	
	public static void bogoSortV( ArrayList<Comparable> data ) {
		while ( !(isSorted(data)) ) {
			shuffle(data);
		}
	}//end bogoSort -- O(n)
	
	public static ArrayList<Comparable> bogoSort( ArrayList<Comparable> input ) {
		ArrayList<Comparable> temp = new ArrayList<Comparable>();
		for (int x = 0; x < input.size(); x++) {
			temp.add(input.get(x));
		}
		bogoSortV(temp);
		return temp;
	}//end bogoSort -- O(n)
	
	public static void main (String[] args) {
	  
	  //Testing BubbleSort methods
	  ArrayList glen = new ArrayList<Integer>();
		glen.add(7);
		glen.add(1);
		glen.add(5);
		glen.add(12);
		glen.add(3);
		System.out.println( "ArrayList glen before sorting:\n" + glen );
		ArrayList glenSorted = bubbleSort( glen );
		System.out.println( "sorted version of ArrayList glen:\n" 
		+ glenSorted );
		System.out.println( "ArrayList glen after sorting:\n" + glen );
		
		ArrayList coco = populate( 10, 1, 1000 );
		System.out.println( "ArrayList coco before sorting:\n" + coco );
		ArrayList cocoSorted = bubbleSort( coco );
		System.out.println( "sorted version of ArrayList coco:\n" 
		+ cocoSorted );
		System.out.println( "ArrayList coco after sorting:\n" + coco );
		System.out.println();
		
		//Testing SelectionSort methods
		ArrayList selecto = new ArrayList<Integer>();
		selecto.add(7);
		selecto.add(1);
		selecto.add(5);
		selecto.add(12);
		selecto.add(3);
		System.out.println( "ArrayList selecto before sorting:\n" + selecto );
		ArrayList selectoSorted = selectionSort( selecto );
		System.out.println( "sorted version of ArrayList selecto:\n" + selectoSorted );
		System.out.println( "ArrayList selecto after sorting:\n" + selecto );
		
		ArrayList sortio = populate( 10, 1, 1000 );
		System.out.println( "ArrayList sortio before sorting:\n" + sortio );
		ArrayList sortioSorted = selectionSort( sortio );
		System.out.println( "sorted version of ArrayList sortio:\n" + sortioSorted );
		System.out.println( "ArrayList sortio after sorting:\n" + sortio );
		System.out.println( sortio );
			
		//Testing BogoSort methods
		ArrayList bobo = new ArrayList<Integer>();
		bobo.add(7);
		bobo.add(1);
		bobo.add(5);
		bobo.add(12);
		bobo.add(3);
		System.out.println( "ArrayList bobo before sorting:\n" + bobo );
		ArrayList boboSorted = bubbleSort( bobo );
		System.out.println( "sorted version of ArrayList bobo:\n" + boboSorted );
		System.out.println( "ArrayList bobo after sorting:\n" + bobo );
		
		ArrayList gogo = populate( 10, 1, 1000 );
		System.out.println( "ArrayList gogo before sorting:\n" + gogo );
		ArrayList gogoSorted = bubbleSort( gogo );
		System.out.println( "sorted version of ArrayList gogo:\n" + gogoSorted );
		System.out.println( "ArrayList gogo after sorting:\n" + gogo );
		System.out.println();
		
	}
}
