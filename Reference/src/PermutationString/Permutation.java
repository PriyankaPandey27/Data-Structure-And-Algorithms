/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PermutationString;

import java.util.ArrayList;

/**
 *
 * @author admin
 */


class Permutation
{
	public  static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    Integer input[]=a.toArray(new Integer[a.size()]);
	permuteUnique(input, 0, result);
	return result;
	}

	private static void permuteUnique(Integer[] num, int start, ArrayList<ArrayList<Integer>> result) {

	if (start >= num.length ) {
		ArrayList<Integer> item = convertArrayToList(num);
		result.add(item);
	}

	for (int j = start; j <= num.length-1; j++) {
		if (containsDuplicate(num, start, j)) {
			swap(num, start, j);
			permuteUnique(num, start + 1, result);
			swap(num, start, j);
		}
	}
}

private static ArrayList<Integer> convertArrayToList(Integer[] num) {
	ArrayList<Integer> item = new ArrayList<Integer>();
	for (int h = 0; h < num.length; h++) {
		item.add(num[h]);
	}
	return item;
}

private static boolean containsDuplicate(Integer[] arr, int start, int end) {
	for (int i = start; i <= end-1; i++) {
		if (arr[i] == arr[end]) {
			return false;
		}
	}
	return true;
}

private static void swap(Integer[] a, int i, int j) {
	int temp = a[i];
	a[i] = a[j];
	a[j] = temp;
}



}
