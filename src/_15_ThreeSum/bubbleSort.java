package _15_ThreeSum;

public class bubbleSort {
	public static int[] bubbleSort(int[] arr) {
		int n = arr.length;
		for(int i = 0; i < n - 1; i ++) {
			boolean swapped = false;
			for(int j = 0; j < n - 1 - i; j ++) {
				if(arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			if(!swapped) break;
		}
		return arr;
	}
	public static void main(String[] args) {
		int[] arr = {-1,0,1,2,-1,-4};
		for(int i : bubbleSort(arr)) {
			System.out.print(i + " ");
		}
	}
}
