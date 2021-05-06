package com.day11;

public class RemindHomework03 {
	public static void main(String[] args) {
//	1 ~ 16 을 4 X 4 배열에 담고 
//	
//	(2-1)
//	1	2	3	4
//	5	6	7	8
//	9	10	11	12
//	13	14	15	16
		int[][] arr = new int[4][4];
		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr[i].length; ++j) {
				arr[i][j] = (i * 4) + (j + 1);
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}

//	(2-2)
//	1	5	9	13
//	2	6	10	14
//	3	7	11	15
//	4	8	12	16
		System.out.println();

		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr[i].length; ++j) {
				System.out.print(arr[j][i] + "\t");
			}
			System.out.println();
		}

//	(2-3)
//	1	2	3	4
//	8	7	6	5
//	9	10	11	12
//	16	15	14	13

		System.out.println();

		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr[i].length; ++j) {
				if (i % 2 == 1) {
					System.out.print(arr[i][3 - j] + "\t");
				} else if (i % 2 == 0) {
					System.out.print(arr[i][j] + "\t");
				}

			}
			System.out.println();
		}

	}
}
