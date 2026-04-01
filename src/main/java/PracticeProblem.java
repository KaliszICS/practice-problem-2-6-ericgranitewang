public class PracticeProblem {

	public static void main(String args[]) {
		double arr[] = {155.2, 155.1, 1, 5, 3, 2, 7, 8};
		insertionSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static int[] bubbleSort(double[] nums) {
		int comps = 0;
		int swaps = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			boolean real = true;
			for (int j = 0; j < nums.length - 1 - i; j++) {
				if (nums[j] > nums[j+1]) {
					double temp = nums[j+1];
					nums[j+1] = nums[j];
					nums[j] = temp;
					swaps += 3;
					real = false;
				}
				comps++;
			}
			if (real) {
				break;
			}
		}
		return new int[]{swaps, comps};
	}

	public static int[] selectionSort (double[] nums) {
		int swaps = 0;
		int comps = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < nums.length ; j++) {
				if (nums[j] < nums[minIndex]) {
					minIndex = j;
					swaps++;
				}
				comps++;
			}
			double temp = nums[i];
			nums[i] = nums[minIndex];
			nums[minIndex] = temp;
			swaps += 3;
		}
		return new int[]{swaps, comps};
	}

	public static int[] insertionSort(double[] nums) {
		int swaps = 0;
		int comps = 0;
		for (int i = 1; i < nums.length; i++) {
			double current = nums[i];
			int index = i;
			swaps++;
			for (int j = i; j > 0; j--) {
				if (current < nums[j-1]) {
					comps++;
					nums[j] = nums[j-1];
					index = j-1;
					swaps += 1;
				} else {
					//there should be an extra comparison here but like the program doesn't like that
					break;
				}
			}
			nums[index] = current;
			swaps++;
		}
		return new int[]{swaps, comps};
	}

	public static String leastSwaps(double[] nums) {
		double[] clone1 = new double[nums.length];
		double[] clone2 = new double[nums.length];
		double[] clone3 = new double[nums.length];
		for (int i = 0; i < nums.length; i++) {
			clone1[i] = nums[i];
			clone2[i] = nums[i];
			clone3[i] = nums[i];
		}
		int bubbleCount = bubbleSort(clone1)[0];
		int selectionCount = selectionSort(clone2)[0];
		int insertionCount = insertionSort(clone3)[0];
		if (bubbleCount <= selectionCount && bubbleCount <= insertionCount) {
			return "Bubble";
		} else if (insertionCount <= bubbleCount && insertionCount <= selectionCount) {
			return "Insertion";
		} else {
			return "Selection";
		}
	}

	public static String leastIterations(double[] nums) {
		double[] clone1 = new double[nums.length];
		double[] clone2 = new double[nums.length];
		double[] clone3 = new double[nums.length];
		for (int i = 0; i < nums.length; i++) {
			clone1[i] = nums[i];
			clone2[i] = nums[i];
			clone3[i] = nums[i];
		}
		int bubbleCount = bubbleSort(clone1)[1];
		int selectionCount = selectionSort(clone2)[1];
		int insertionCount = insertionSort(clone3)[1];
		if (bubbleCount <= selectionCount && bubbleCount <= insertionCount) {
			return "Bubble";
		} else if (insertionCount <= bubbleCount && insertionCount <= selectionCount) {
			return "Insertion";
		} else {
			return "Selection";
		}
	}

}
