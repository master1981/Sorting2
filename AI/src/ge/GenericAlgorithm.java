package ge;

import java.util.Random;
import java.util.Scanner;

public class GenericAlgorithm {
	private static int avg = 0;

	public static void main(String[] args) {
		// Initializations
		int lastVlaue = 31;
		int high = 31;
		int low = 0;
		Random ran = new Random();
		int a[] = { 0, 1 };
		System.out.println("Enter populations: ");
		Scanner sc = new Scanner(System.in);
		int population = sc.nextInt();
		System.out.println("Enter crossover probability ");
		int cross = sc.nextInt();
		System.out.println("Enter Mutation probability");
		int MutationProbability = sc.nextInt();
		int allbinary[][] = new int[population][8];
		int allcrossover[][] = new int[population][100];
		int tempcross[][] = new int[population][100];
		int gen = 0, sumoffit = 0;
		int r[] = new int[population];
		int fit[] = new int[population];
		int p;
		int temp[] = new int[population];
		int array[] = new int[population];
		int chromes[] = new int[population];// chromosome generation.
		if (gen == 0) {
			for (int i = 0; i < population; i++) {
				array[i] = low + ran.nextInt(high);
			}
			gen++;
		}

		// ****//
		do {
			System.out.println("\n");
			System.out.println("=========== generation (" + gen + ") ======================");
			if (gen == 1)
				for (int i = 0; i < population; i++) {
					// System.out.println("chrome[" + i + "] = " + array[i]);
				}
			// Selection:

			System.out.println("===================== fitness value of chromosome =================");
			for (int i = 0; i < population; i++) {
				fit[i] = array[i] * array[i];
				sumoffit = sumoffit + fit[i];
				if (gen == 1)
					System.out.print("chrome[" + i + "] = " + array[i]);
				System.out.print(" |\t ");
				System.out.println(fit[i] + "\t");
			}
			System.out.println();
			if (gen == 1)
				System.out.println("sum of fitness value= " + sumoffit);
			p = ran.nextInt(sumoffit);
			if (gen == 1)
				System.out.println("random number is= " + p);
			int count = 0, t = 0, z = 0;
			for (z = 0; z < population; z++)
				temp[z] = fit[z];
			try {
				do {
					for (z = 0; z < population; z++) {
						if (count == population)
							break;
						else {
							if (temp[z] > p) {
								chromes[t] = array[z];
								count++;
								t++;
							} else
								temp[z] = temp[z] + fit[z];
						}
					}
					continue;
				} while (count < population);
			} catch (ArrayIndexOutOfBoundsException e) {
			}
			try {

				System.out.println("select chromes");
				for (int k = 0; k < population; k++)
					System.out.println(chromes[k] + "\t");

				System.out.println();
			} catch (ArrayIndexOutOfBoundsException e) {
			}
			// **************************************************************************************
			// **************************************************************************************
			// **************************************************************************************
			// **************************************************************************************
			// **************************************************************************************
			// **************************************************************************************

			// Converting to binary:
			for (int x = 0; x < population; x++) {
				int kgr = 5;
				do {
					r[x] = chromes[x] % 2;
					try {
						if (r[x] > 0) {
							allbinary[x][kgr] = a[1];
						} else {
							allbinary[x][kgr] = a[0];
						}
					} catch (ArrayIndexOutOfBoundsException e) {
					}
					kgr--;
					chromes[x] = chromes[x] / 2;
				} while (chromes[x] > 0);
			}
			System.out.println("===============converting to binery===============");
			for (int i = 0; i < population; i++) {
				for (int k = 0; k < population; k++) {
					System.out.print(allbinary[i][k]);
				}

				System.out.println();
			}
			// crossover:
			for (int i = 0; i < population; i += 2) {
				int randomnumber = ran.nextInt(100);
				if (randomnumber <= cross) {
					int crospt = ran.nextInt(5);
					System.out.println("crossPoit= " + crospt);
					for (int k = 0; k < population; k++) {
						if (k >= crospt)
							allcrossover[i][k] = allbinary[i + 1][k];

						else
							allcrossover[i][k] = allbinary[i][k];
					}
					for (int k = 0; k < population; k++) {
						if (k >= crospt)
							allcrossover[i + 1][k] = allbinary[i][k];
						else
							allcrossover[i + 1][k] = allbinary[i + 1][k];
					}
				} else {
					System.out.println("crossPoint=0");
					for (int k = 0; k < population; k++) {
						allcrossover[i][k] = allbinary[i][k];
						allcrossover[i + 1][k] = allbinary[i + 1][k];
					}
					System.out.println();
				}
			}
			System.out.println("===============after cross over=========");
			for (int i = 0; i < population; i++) {
				for (int k = 0; k < population; k++) {
					System.out.print(allcrossover[i][k]);
				}
				System.out.println();
			}
			// mutation
			int mutpt;
			for (int i = 0; i < population; i++) {
				for (int l = 0; l < population; l++) {
					mutpt = ran.nextInt(100);
					if (mutpt <= MutationProbability) {
						// System.out.println("allcrossover ["+i+"]["+l+"]at"+mutpt);
						if (allcrossover[i][l] == 0)
							allcrossover[i][l] = 1;
						else
							allcrossover[i][l] = 0;
					}
				}
			}
			int xyz = 0;
			System.out.println("=================after mutation================");
			for (xyz = 0; xyz < population; xyz++) {
				for (int k = 0; k < population; k++) {
					System.out.print(allcrossover[xyz][k]);
				}
				System.out.println();
			}
			// converting to decimal.
			int sum = 0;
			for (int i = 0; i < population; i++) {
				if (allcrossover[i][0] == 1)
					sum += (2 * 2 * 2 * 2 * 2);
				else
					sum += 0;
				if (allcrossover[i][1] == 1)
					sum += (2 * 2 * 2 * 2);
				else
					sum += 0;
				if (allcrossover[i][2] == 1)
					sum += (2 * 2 * 2);
				else
					sum += 0;
				if (allcrossover[i][3] == 1)
					sum += (2 * 2);
				else
					sum += 0;
				if (allcrossover[i][4] == 1)
					sum += (2);
				else
					sum += 0;
				if (allcrossover[i][5] == 1)
					sum += (1);
				else
					sum += 0;
				chromes[i] = sum;
				sum = 0;
			}
			System.out.println();
			// Average of the generation chromes.
			sum = 0;
			for (int i = 0; i < population; i++) {
				sum += chromes[i];
				array[i] = chromes[i];
			}
			avg = sum / population;
			System.out.println("==================avarage===" + avg + "================");

			if (avg < 29) {
				System.out.println("==================generated population===================");
				for (int i = 0; i < population; i++) {
					chromes[i] = array[i];
					System.out.println(chromes[i] + "\t");
				}
				System.out.println();
				gen++;
				p = 0;
				sumoffit = 0;
			}
		} while (avg < 29);
		System.out.println("END... average > " + avg);
	}
}
