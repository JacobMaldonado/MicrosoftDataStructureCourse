/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microsoftdatastructure;

import javax.swing.JOptionPane;

public class MergeSort {

    public static void main(String[] args) {
        int arreglo[] = new int[10];

        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = Integer.parseInt(JOptionPane.showInputDialog(i));
        }

        arreglo = mergeSort(arreglo);

        for (int i = 0; i < arreglo.length; i++) {
            System.out.println(arreglo[i] + "\n");
        }
    }

    public static int[] mergeSort(int[] lst) {
        int n = lst.length;
        int[] left;
        int[] right;

        // create space for left and right subarrays
        if (n % 2 == 0) {
            left = new int[n / 2];
            right = new int[n / 2];
        } else {
            left = new int[n / 2];
            right = new int[n / 2 + 1];
        }

        // fill up left and right subarrays
        for (int i = 0; i < n; i++) {
            if (i < n / 2) {
                left[i] = lst[i];
            } else {
                right[i - n / 2] = lst[i];
            }
        }

        if (lst.length > 2) {
            left = mergeSort(left);
            right = mergeSort(right);
        }
        // merge
        return merge(left, right);
    }
// the function for merging two sorted arrays

    public static int[] merge(int[] left, int[] right) {
        // create space for the merged array
        int[] result = new int[left.length + right.length];

        // running indices
        int i = 0;
        int j = 0;
        int index = 0;

        // add until one subarray is deplete
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[index++] = left[i++];
            } else {
                result[index++] = right[j++];
            }
        }

        // add every leftover elelment from the subarray 
        while (i < left.length) {
            result[index++] = left[i++];
        }

        // only one of these two while loops will be executed
        while (j < right.length) {
            result[index++] = right[j++];
        }

        return result;
    }

}
