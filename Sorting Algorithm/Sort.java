public class Sort {

	public static void main(String[] args) {
		int[] arr = {3, 7, 1, 2, 9, 8};
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		//arr = bubbleSort(arr);
		//arr = selectionSort(arr);
		//arr = insertionSort(arr);
		//mergeSort(arr, 0, arr.length-1);
		quickSort(arr, 0, arr.length-1);
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
	}

	//Bubble Sort
	static int[] bubbleSort(int[] a) {
		
		for(int i=0;i<a.length-1;i++) {
			for(int j=0;j<a.length-(i+1);j++) {
				if(a[j]>a[j+1]) {
					interchange(a, j, j+1);
				}
			}
		}
		return a;
	}

	//Selection Sort
	static int[] selectionSort(int[] a) {
		
		for(int i=0;i<a.length-1;i++) {
			int min = i;
			for(int j=i+1;j<a.length;j++) {
				if(a[j]<a[min])
					min = j;
			}
			interchange(a, i, min);
		}
		return a;
	}

	//Insertion Sort
	static int[] insertionSort(int[] a) {
		for(int i=1;i<a.length;i++) {
			int target = i;
			for(int j=i-1;j>=0;j--) {
				if(a[target]<a[j]) {
					interchange(a, target, j);
					target = j;
				}
			}
		}
		return a;
	}
	
	static void interchange(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	
	//Merge sort: O(nlogn) complexity
	static void mergeSort(int[] a, int begin, int end) {
		if((end-begin)>=1) {
			int splitPoint = mergeSplit(begin, end);
			mergeSort(a, begin, splitPoint);
			mergeSort(a, splitPoint+1, end);
			join(a, begin, splitPoint, end);
		}
	}
	private static int mergeSplit(int start, int end) {
		int mid = (start+end)/2;
		return mid;
	}
	private static void join(int[] a, int begin, int splitPoint, int end) {
		int interval = end-begin+1;
		int[] temp = new int[interval];
		int nextLeft = begin;
		int nextRight = splitPoint + 1;
		int i=0;
		
		while(nextLeft<=splitPoint && nextRight<=end) {
			if(a[nextLeft]<a[nextRight]) {
				temp[i] = a[nextLeft];
				i++; nextLeft++;
			}
			else {
				temp[i] = a[nextRight];
				i++; nextRight++;
			}
		}
		while(nextLeft<=splitPoint) {
			temp[i] = a[nextLeft];
			i++; nextLeft++;
		}
		while(nextRight<=end) {
			temp[i] = a[nextRight];
			i++; nextRight++;
		}
		
		for(int k=0;k<interval;k++) {
			a[begin+k] = temp[k];
		}
	}
	
	//Quick Sort: O(nlogn) complexity
	static void quickSort(int[] a, int begin, int end) {
		if((end-begin)>=1) {
			int splitPoint = quickSplit(a, begin, end);
			quickSort(a, begin, splitPoint);
			quickSort(a, splitPoint+1, end);
		}
	}
	private static int quickSplit(int[] a, int begin, int end) {
		int interval = end-begin+1;
		int[] temp = new int[interval];
		
		int splitValue = a[begin];
		int up=0;
		int down = interval-1;
		
		for(int i=begin+1;i<=end;i++) {
			if(a[i]<=splitValue) {
				temp[up] = a[i];
				up++;
			}
			else {
				temp[down] = a[i];
				down--;
			}
		}
		temp[up] = a[begin];
		
		for(int k=0;k<interval;k++) {
			a[begin+k] = temp[k];
		}
		
		return (begin+up);
	} 
	
	
	
	
	
	

}

