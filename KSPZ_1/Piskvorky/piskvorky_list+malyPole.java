public class piskvorky3 {
	public static void FiveInARow (int koef1, int koef2, int i, char hrac, char[][] pole){
		int smer = 0;
		for (int j = 1; j <= 4; j++){
				if (pole[4 - (j * koef1)][4  - (j * koef2)] == hrac){
					smer++;
				}
				else{break;}
			}
		if (smer == 4){
				System.out.printf("%c %d", hrac, i);
				System.exit(0);
			}
		for (int k = 1; k <= 4 - smer; k++){
				if (pole[4 + (k * koef1)][4 + (k * koef2)] != hrac){
					break;
				}
				if (k == 4 - smer){
					System.out.printf("%c %d", hrac, i);
					System.exit(0);
				}
			}
	}
	public static void NarvatDoPole (char hrac, int[][] field, int i){
		char[][] pole = new char [9][9];
		pole[4][4] = hrac;
		for (int j = 0; j < i/2; j++){
			if (Math.abs(field[j][0] - field[i/2][0]) <= 4 &&  Math.abs(field[j][1] - field[i/2][1]) <= 4){
				pole[field[j][0] - field[i/2][0] + 4][field[j][1] - field[i/2][1] + 4] = hrac;
			}
		}
		FiveInARow (1, 0, i, hrac, pole);
		FiveInARow (0, 1, i, hrac, pole);
		FiveInARow (1, 1, i, hrac, pole);
		FiveInARow (1, -1, i, hrac, pole);
	}
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = sc.nextInt();
		int[][] krizek = new int[N/2][2];
		int[][] kolecko = new int[N/2][2];
		for (int i = 0; i < N; i++){
			char hrac = sc.next().charAt(0);
			if (hrac == 'X'){
				krizek[i/2][0] = sc.nextInt();
				krizek[i/2][1] = sc.nextInt();
				if (i > 450000){
				NarvatDoPole(hrac, krizek, i);
				}
			}
			else {
				kolecko[i/2][0] = sc.nextInt();
				kolecko[i/2][1] = sc.nextInt();
				if (i > 450000){
				NarvatDoPole(hrac, kolecko, i);
				}
			}
		}
		System.out.println("NIKDO");
	}
}