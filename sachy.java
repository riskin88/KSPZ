public class sachy {
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int[] ted = new int[2];
		int[] finish = new int[2];
		String tedline = sc.nextLine();
		String[] tedin = tedline.split(" ");
		ted[0] = Integer.parseInt(tedin[0]);
		ted[1] = Integer.parseInt(tedin[1]);
		String finishline = sc.nextLine();
		String[] finishin = finishline.split(" ");
		finish[0] = Integer.parseInt(finishin[0]);
		finish[1] = Integer.parseInt(finishin[1]);
		int T = Integer.parseInt(sc.nextLine());
		String[] radky = new String[T];
		String[][] tahyin = new String[T][];
		for (int i = 0; i < T; i++){
			radky[i] = sc.nextLine();
		}
		for (int i = 0; i < T; i++){
			tahyin[i] = radky[i].split(" ");
		}
		int[][] tahy = new int[T][2];
		for (int i = 0; i < T; i++){
			for (int j = 0; j < 2; j++){
				tahy[i][j] = Integer.parseInt(tahyin[i][j]);
			}
		}
		int[][] pole = new int[N][N];
		int count = 0;
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				pole[x][y] = -1;
			}
		}
		pole[ted[0]][ted[1]] = 0;
		while (count != pole[finish[0]][finish[1]]){
			for (int radek = 0; radek < N; radek++) {
			for (int sloupec = 0; sloupec < N; sloupec++) {
				if (pole[radek][sloupec] == count){
					for (int i = 0; i < T; i++){
						if (radek + tahy[i][0]< N && radek + tahy[i][0] >= 0 && sloupec + tahy[i][1] < N && sloupec + tahy[i][1] >= 0){
							if (pole[radek + tahy[i][0]][sloupec + tahy[i][1]] == -1){	
							pole[radek + tahy[i][0]][sloupec + tahy[i][1]] = count + 1;
							j++;
							}
						}
					}
				}
			}
			}
			count++;
		}
		System.out.printf("%d", count);
		System.out.println("");
		int[][] policka = new int[count - 1][2];
		int[] aktualne = new int[2];
		aktualne[0] = finish[0];
		aktualne[1] = finish[1];
		for (int i = count; i > 1; i--){
			for (int k = 0; k < T; k++){
				if (aktualne[0] + tahy[k][0] < N && aktualne[0] + tahy[k][0] >= 0 && aktualne[1] + tahy[k][1] < N && aktualne[1] + tahy[k][1] >= 0){
					if (pole[aktualne[0] + (-1 * tahy[k][0])][aktualne[1] + (-1 * tahy[k][1])] == i - 1){
						policka[i - 2][0] = aktualne[0] + (-1 * tahy[k][0]);
						policka[i - 2][1] = aktualne[1] + (-1 * tahy[k][1]);
						aktualne[0] = policka[i - 2][0];
						aktualne[1] = policka[i - 2][1];
						break;
					}
				}
			}
		}
		for (int i = 0; i < count - 1; i++){
			for (int l = 0; l < 2; l++){
				System.out.printf("%d ", policka[i][l]);
			}
			System.out.println("");
		}
	}
}
