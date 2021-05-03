package com.day10;

import java.util.Arrays;

/*
1 ~ 16 을 4 X 4 배열에 담고 
	
(2-1)
1	2	3	4
5	6	7	8
9	10	11	12
13	14	15	16

 */
public class Quiz03 {
	public static void main(String[] args) {
		int [][] a = new int [4][4];
		int sum = 0;
		for (int i=0; i<a.length; ++i) {
			for (int j=0; j<a[i].length; ++j) {
				++sum;
				a[i][j]=sum;
			}
		System.out.println(Arrays.toString(a[i]));}
    
    
    //선생님 풀이
    		int[][] arr = new int[4][4];
		for(int i = 0; i < arr.length; ++i) {
			for(int j = 0; j < arr[i].length; ++j) {
				arr[i][j] = (i * 4) + (j + 1);
			}
		}
		
		for(int i = 0; i < arr.length; ++i) {
			for(int j = 0; j < arr[i].length; ++j) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
    
	}
}
