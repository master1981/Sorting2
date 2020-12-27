package ge;

public class k_means {

	public static void main(String[] args) {

		double[] cluster = { 1, 2, 3, 4 };
		double[] objects = { 1, 2, 3, 4, 5, 6, 7, 8 };

		double[] new_group = new double[objects.length];

		int index = 0;
		// for (int l = 0; l < objects.length; l = l + 2) {
		// for (int k = 0; k < cluster.length - 2; k = k + 2) {
		for (int i = 0; i < objects.length; i = i + 2) {
			for (int j = 0; j <= cluster.length - 2; j = j + 2) {
				double val = Math.pow(
						Math.pow((objects[i] - cluster[j]), 2) + Math.pow((objects[i + 1] - cluster[j + 1]), 2), 0.5);

				System.out.println(i + ": i -----" + j + ": j ========" + index + ":");
				System.out.println(val);
				new_group[index] = val;

				index++;

				// }
				// }
			}

		}
		System.out.println();
		for (int n = 0; n < new_group.length; n++) {
			System.out.print(new_group[n] + " || ");

		}

//		for (int i = 0; i < objects.length; i++) {
//			for (int j = 0; j < cluster.length; j++) {
//				for (int k = 0; k < cluster.length; k++) {
//					for (int l = 0; l < cluster.length; l++) {
//						new_group[j] = Math
//								.pow(((objects[j][i] - cluster[k][i]) + (objects[k][i + 1] - cluster[j][i + 1])), 0.5);
//						if (new_group[i] > max)
//							new_group[i] = max;
//					}
//				}
//
//			}
//
//		}

	}

}
