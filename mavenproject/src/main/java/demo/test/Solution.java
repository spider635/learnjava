package demo.test;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static int minGasStations(int[] disList, int[] lGasList, int distance, int initialGas) {
		int n = disList.length;
		int stops = 0;
		int currentPos = 0;
		int currentGas = initialGas;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		int i = 0;

		while (currentPos + currentGas < distance) {
			// Add all reachable gas stations to the heap
			while (i < n && disList[i] <= currentPos + currentGas) {
				maxHeap.offer(lGasList[i]);
				i++;
			}

			if (maxHeap.isEmpty()) {
				return -1;
			}

			// Take the gas from the station offering the most fuel
			currentGas += maxHeap.poll();
			stops++;
		}

		return stops;
	}

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// input for disList
			int disList_size = in.nextInt();
			int disList[] = new int[disList_size];
			for (int idx = 0; idx < disList_size; idx++) {
				disList[idx] = in.nextInt();
			}
			// input for lGasList
			int lGasList_size = in.nextInt();
			int lGasList[] = new int[lGasList_size];
			for (int idx = 0; idx < lGasList_size; idx++) {
				lGasList[idx] = in.nextInt();
			}
			// input for distance
			int distance = in.nextInt();
			// input for initialGas
			int initialGas = in.nextInt();

			int result = minGasStations(disList, lGasList, distance, initialGas);
			System.out.print(result);
		}
	}
}