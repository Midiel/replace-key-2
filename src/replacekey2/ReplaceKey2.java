/*********************************************************************
Purpose/Description: This program finds a element/key in an originally sorted
                      array with distinct integers before being rotated an
                      unknown number of times.
Author’s Panther ID: xxxxxx
Certification:
I hereby certify that this work is my own and none of it is the work of
any other person.
********************************************************************/
package replacekey2;

/**
 *
 * @author midiel305
 */
public class ReplaceKey2 {
    
    /** A)
     * - This method finds and element/key in an array of elements that was 
     * originally sorted with distinct integers before being rotated an unknown
     * number of times.
     * 
     * B)
     * The running time complexity is O(logN). Because on every recursion
     * the size is divided in half.
     * 
     * @param array the array of elements
     * @param leftIndex left index of the array
     * @param rightIndex right index of the array
     * @param key to search for
     * @return the position of the key, or -1 if not found
     */
    static int findElement(int[] array, int leftIndex, int rightIndex, int key) {
        
        // Check if the array has already been checked completely
        if (leftIndex > rightIndex) {
            return -1;
        }
       
        // Split the search area in half
        int middle = (leftIndex + rightIndex) / 2;
        
        // Check the middle element is the key
        if (array[middle] == key) {
            return middle;
        }
       
        // check if the left half is sorted, then we can eassily do a binary
        // search for the key using recursion.
        if (array[middle] >= array[leftIndex]) {
            
            // If key is in the left half, do a binary search using recursion
            if (key >= array[leftIndex] && key <= array[middle]) {
               return findElement(array, leftIndex, (middle - 1), key);
            
            // If not, then search the right half
            } else {
                return findElement(array, (middle + 1), rightIndex, key);
            }
        }
       
        // If the eft half was not sorted then the right half must be sorted.
        // Do a binary search on the right half.
        if (key >= array[middle] && key <= array[rightIndex]) {
            return findElement(array, (middle + 1), rightIndex, key);
        } else {
            return findElement(array, leftIndex, (middle - 1), key);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Variables to test the findElement algorithm
        int[] array = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};    // array of elements
        int leftIndex = 0;                              // initial left index
        int rightIndex = array.length - 1;              // initial right index
        int index;                                      // index of element found   
        
        // key element to find
        int key = 5;
    
        index = findElement(array, leftIndex, rightIndex, key);
        
        System.out.print("Element/key " + key );
        
        if(index > -1) {
            System.out.println(" is in the index " + index + " in the array.");
        } else {
            System.out.println(" is not in the array.");
        }    
    }  
}