/**
 * 
 */
package structure;

/**
 * @author lumia
 *
 */
public class bubbleSort {
	
	public static int[] bubbleSort(int[] array) {
		for(int i=0;i<array.length-1;i++) {
			for(int j=0;i<array.length-i-1;j++) {
				if(array[j]>array[j+1]) {
					int temp = array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
		return array;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		
	}

}
