public class kvadry {
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		String[] radky = new String[N];
		String[][] souradnice = new String[N][];
		for (int i = 0; i < N; i++){
			radky[i] = sc.nextLine();
		}
		for (int i = 0; i < N; i++){
			souradnice[i] = radky[i].split(" ");
		}
		int[][] souradky = new int[N][6];
		for (int i = 0; i < N; i++){
			for (int j = 0; j < 6; j++){
				souradky[i][j] = Integer.parseInt(souradnice[i][j]);
			}
		}
		int maximumx = 0;
		int maximumy = 0;
		int maximumz = 0;
		int minimumx = souradky[0][1];
		int minimumy = souradky[0][3];
		int minimumz = souradky[0][5];
		for (int i = 0; i < N; i++){
			if (souradky[i][0] > maximumx){
				maximumx = souradky[i][0];
			}
			if (souradky[i][1] < minimumx){
				minimumx = souradky[i][1];
			}
			if (maximumx >= minimumx){
				System.out.println("0");
				return;
			}
			if (souradky[i][2] > maximumy){
				maximumy = souradky[i][2];
			}
			if (souradky[i][3] < minimumy){
				minimumy = souradky[i][3];
			}
			if (maximumy >= minimumy){
				System.out.println("0");
				return;
			}
			if (souradky[i][4] > maximumz){
				maximumz = souradky[i][4];
			}
			if (souradky[i][5] < minimumz){
				minimumz = souradky[i][5];
			}
			if (maximumz >= minimumz){
				System.out.println("0");
				return;
			}
		}
		long output = Long.valueOf(Long.valueOf(minimumx - maximumx) * Long.valueOf(minimumy - maximumy) * Long.valueOf(minimumz - maximumz));
		System.out.printf("%d\n", output);
		/* System.out.printf("%d\n", N);
		 for (int[] a : souradky) {
			for (int i : a) {
				System.out.print(i + "\t"); 
			}
					 	System.out.println("\n"); 
		} */
	}
}

