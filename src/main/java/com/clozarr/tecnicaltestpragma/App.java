package com.clozarr.tecnicaltestpragma;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		;

		// GDC Problem
		int gdc = gcdProblem(10000, 8000);
		System.out.println("GDC:" + gdc);

		int A[] = { 0, 3, 3, 7, 5, 3, 11, 1 };
		// AdjacentPointsMinDistance
		int minDistance = adjacentPointsMinDistance(A);
		System.out.println("Min Distance: " + minDistance);

		// AdjacentPointPairsCount
		int pairsCount = adjacentPointPairsCount(A);
		System.out.println("Pairs count: " + pairsCount);

	}

	public static int gcdProblem(int N, int M) {

		if (M == 0) {

			return N;

		} else {

			return gcdProblem(M, N % M);
		}
	}

	public static int adjacentPointsMinDistance(int[] A) {

		int minDistance = Integer.MAX_VALUE;
		int distance = 0;

		for (int p = 0; p < A.length - 1; p++) {

			for (int q = (p + 1); q < A.length; q++) {

				int u = A[p];
				int w = A[q];

				if (!find(A, u, w))
					distance = Math.abs((u - w));

				if (distance < minDistance)
					minDistance = distance;

			}

		}

		if (minDistance == Integer.MAX_VALUE)
			return -2;
		if (minDistance > 100000000)
			return -1;

		return minDistance;
	}

	public static int adjacentPointPairsCount(int[] A) {

		int count = 0;

		for (int p = 0; p < A.length - 1; p++) {

			for (int q = (p + 1); q < A.length; q++) {

				int u = A[p];
				int w = A[q];

				if (!find(A, u, w))
					count++;

			}

		}

		if (count > 100000000)
			return -1;

		return count;
	}

	private static boolean find(int[] A, int u, int w) {

		for (int i = 0; i < A.length; i++) {

			if ((u < A[i] && A[i] < w) || (u > A[i] && A[i] > w))
				return true;
		}
		return false;

	}

}
