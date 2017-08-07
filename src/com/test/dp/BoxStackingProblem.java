package com.test.dp;

import java.util.Arrays;

public class BoxStackingProblem {
	public int maxHeight(Dimension[] input) {
		// Array to store all possible combinations for the input boxes, For
		// each combination 3 rotation will be possible

		Dimension[] allRotationInput = getAllRotation(input);
		// sort these boxes in non increasing order by their base area.(length X
		// width)
		Arrays.sort(allRotationInput);

		int n = allRotationInput.length;
		int T[] = new int[n];
		int result[] = new int[n];
		// applying longest decreasing order sequence algorithm
		for (int i = 0; i < n; i++) {
			T[i] = allRotationInput[i].height;
			result[i] = i;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if ((allRotationInput[j].length > allRotationInput[i].length)
						&& (allRotationInput[j].width > allRotationInput[i].width)) {
					int height = T[j] + allRotationInput[i].height;
					if (height > T[i]) {
						T[i] = height;
					}
				}
			}
		}

		int max = T[0];
		for (int i = 1; i < n; i++) {
			if (T[i] > max) {
				max = T[i];
			}
		}

		return max;
	}

	//Method to get all rotations possible for input given
	private Dimension[] getAllRotation(Dimension[] input) {
		Dimension[] allRotationInput = new Dimension[input.length * 3];
		int index = 0;
		for (int i = 0; i < input.length; i++) {
			allRotationInput[index++] = Dimension.createDimension(input[i].height, input[i].length, input[i].width);
			allRotationInput[index++] = Dimension.createDimension(input[i].length, input[i].height, input[i].width);
			allRotationInput[index++] = Dimension.createDimension(input[i].width, input[i].length, input[i].height);

		}
		return allRotationInput;
	}
	
	public static void main(String args[]) {
        BoxStackingProblem bs = new BoxStackingProblem();
        Dimension input[] = { new Dimension(3, 2, 5), new Dimension(1, 2, 4) };
        int maxHeight = bs.maxHeight(input);
        System.out.println("Max height is " + maxHeight);
    }
}
