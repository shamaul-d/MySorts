// Shamaul Dilmohamed
// APCS1 pd10
// HW52 -- Selection, Natch
// 2015-12-22

/*======================================
  class SelectionSort -- implements SelectionSort algorithm
  ======================================*/

import java.util.ArrayList;

public class SelectionSort {

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
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void selectionSortV( ArrayList<Comparable> data ) 
    {
	/* your implementation UP IN HERE, UP IN HERE */
	for (int i = 0; i < data.size()-1; i++) {
	    int hold = i;
	    for (int x = data.size() - 1; x > i; x--) {
		if (data.get(x).compareTo(data.get(hold)) < 0) {
		    hold = x;
		}
	    }
	    Comparable c = data.get(i);
	    data.set(i,data.get(hold));
	    data.set(hold,c);
	}
    }//end selectionSort -- O(n^2)


    // ArrayList-returning selectionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> 
   	selectionSort( ArrayList<Comparable> input ) 
    {
	ArrayList<Comparable> ans = new ArrayList<Comparable>();
	for (Comparable c : input) {
	    ans.add(c);
	}
	selectionSortV(ans);
	return ans;
	/* your implementation UP IN HERE, UP IN HERE */
    }//end selectionSort -- O(n^2)


    //main method for testing
    public static void main( String [] args ) {


	  ArrayList glen = new ArrayList<Integer>();
	  glen.add(7);
	  glen.add(1);
	  glen.add(5);
	  glen.add(12);
	  glen.add(3);
	  System.out.println( "ArrayList glen before sorting:\n" + glen );
	  selectionSortV(glen);
	  System.out.println( "ArrayList glen after sorting:\n" + glen );
	/*============================================
	  ============================================*/
	

	  ArrayList coco = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco before sorting:\n" + coco );
	  selectionSortV(coco);
	  System.out.println( "ArrayList coco after sorting:\n" + coco );
	/*===============for VOID methods=============
	  ============================================*/


	  ArrayList glen1 = new ArrayList<Integer>();
	  glen1.add(7);
	  glen1.add(1);
	  glen1.add(5);
	  glen1.add(12);
	  glen1.add(3);
	  System.out.println( "ArrayList glen1 before sorting:\n" + glen1 );
	  ArrayList glenSorted = selectionSort( glen1 );
	  System.out.println( "sorted version of ArrayList glen1:\n" 
	  + glenSorted );
	  System.out.println( "ArrayList glen1 after sorting:\n" + glen1 );

	  ArrayList coco1 = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco before sorting:\n" + coco1 );
	  ArrayList cocoSorted = selectionSort( coco1 );
	  System.out.println( "sorted version of ArrayList coco1:\n" 
	  + cocoSorted );
	  System.out.println( "ArrayList coco after sorting:\n" + coco1 );
	  System.out.println( coco1 );
	/*==========for AL-returning methods==========
	  ============================================*/

    }//end main

}//end class SelectionSort
