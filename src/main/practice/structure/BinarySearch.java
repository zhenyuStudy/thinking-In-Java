/**
 * 
 */
package structure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author lumia
 *
 */
public class BinarySearch {
	
	public static int binarySearch(int[] array, int T) {
		int left = 0;
		int right = array.length - 1;

		while (left <= right) {
			int middle = (left + right)/2;
			if(array[middle] > T) {
				right = middle -1;
			}else if(array[middle] < T) {
				left = middle +1;
			}else {
				return middle;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] array = {2,4,6,7,8,9,10};
		System.out.println(binarySearch(array,9));
	}
}
