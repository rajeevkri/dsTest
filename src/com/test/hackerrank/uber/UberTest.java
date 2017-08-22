package com.test.hackerrank.uber;

import java.util.Arrays;
import java.util.Comparator;

public class UberTest {

	// Form a team with maximum score
	static long teamFormation(int[] score, int team, int m) {
		int n = score.length;

		if ((2 * m) < n) {
			Arrays.sort(score);
			long total = 0;
			int t = 0;
			for (int i = n - 1; i >= 0; i--) {
				total += score[i];
				t++;
				if (t == team) {
					break;
				}
			}
			return total;
		} else {
			Arrays.sort(score, 0, m - 1);
			Arrays.sort(score, n - m - 1, n - 1);
			int i = m - 1, j = n - 1;
			int t = 0;
			long total = 0;
			while (i >= 0 && j >= n - m - 1) {
				if (score[i] >= score[j]) {
					total += score[i--];
				} else {
					total += score[j--];
				}
				t++;
				if (t == team) {
					break;
				}
			}
			return total;
		}

	}

	// maximize total bundleQuantity, given bundleCost for each bundle
	static int budgetShopping(int n, int[] bundleQuantities, int[] bundleCosts) {
		// Greedy approach
		int value = 0;
		Item[] items = new Item[bundleQuantities.length];
		for (int i = 0; i < items.length; i++) {
			items[i] = new Item(bundleQuantities[i], bundleCosts[i]);
		}
		Arrays.sort(items, new Comparator<Item>() {
			public int compare(Item i1, Item i2) {
				return i1.val_per_unit > i2.val_per_unit ? -1 : 1;
			}
		});
		int i = 0;
		while (i < items.length && n > 0) {
			int fraction = Math.min(items[i].weight, n);
			value += items[i].val_per_unit * fraction;
			n -= fraction;
			if (n < items[i].weight)
				i++;
		}
		return value;
	}

	private static class Item {
		int weight;
		double val_per_unit;

		public Item(int val, int wgt) {
			this.weight = wgt;
			val_per_unit = Math.round(((double) val) / ((double) wgt) * 10000.0) / 10000.0;
		}
	}
}
