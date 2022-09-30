// Radix Sort

// 1. You are given an array(arr) of integers.
// 2. You have to sort the given array in increasing order using radix sort.


// Format Input
// An Integer n 
// arr1
// arr2..
// n integers

// Output
// Check the sample ouput and question video.

// Example
// Sample Input

// 5
// 7 
// 2 
// 4 
// 1 
// 3

// Sample Output
// After sorting on 1 place -> 1 2 3 4 7 
// 1 2 3 4 7

import java.util.*;

public class radix_sort {

  public static void radixSort(int[] arr) {
    int max = Integer.MIN_VALUE;
    for(int a : arr){
      if(a>max){
        max = a;
      }
    }
    int e = 1;
    while(e<=max){
      countSort(arr,e);
      e = e * 10;
    }
  }

  public static void countSort(int[] arr, int exp) {
    int [] ans = new int[arr.length]; 
   int [] freq = new int[10];
   for(int i = 0; i < arr.length; i++){
     freq[arr[i] / exp % 10]++;
   }
   for(int i = 0; i< freq.length; i++){
     if(i != 0){
       freq[i] += freq[i-1];
     }
   }
   for(int i= 0; i<freq.length; i++){
     freq[i]--;
   }
   for(int i = arr.length-1; i >= 0; i--){
     ans[freq[arr[i] / exp % 10]] = arr[i];
     freq[arr[i] / exp % 10]--;
   }
   for(int i = 0; i < ans.length; i++){
     arr[i] = ans[i];
   }
    System.out.print("After sorting on " + exp + " place -> ");
    print(arr);
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    radixSort(arr);
    print(arr);
    scn.close();
  }

}