public class piskvorky {
	public static void funkce (int smer, int koef1, int koef2, int i, int x, int y, char hrac, char[][] pole){
		for (int j = 1; j <= 4; j++){
				if (pole[x - (j * koef1)][y  - (j * koef2)] == hrac){
					smer++;
				}
				else{break;}
			}
		if (smer == 4){
				System.out.printf("%c %d", hrac, i);
				System.exit(0);
			}
		for (int k = 1; k <= 4 - smer; k++){
				if (pole[x+(k * koef1)][y + (k * koef2)] != hrac){
					break;
				}
				if (k == 4 - smer){
					System.out.printf("%c %d", hrac, i);
					System.exit(0);
				}
			}
	}
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = sc.nextInt();
		char[][] pole = new char[11000][11000];
		for (int i = 0; i < N; i++){
			char hrac = sc.next().charAt(0);
			int x = sc.nextInt() + 10;
			int y = sc.nextInt() + 10;
			pole[x][y] = hrac;
			int horizfound = 0;
			funkce(horizfound, 1, 0, i, x, y, hrac, pole);
			int vertfound = 0;
			funkce(vertfound, 0, 1, i, x, y, hrac, pole);
			int diag1 = 0;
			funkce(diag1, 1, 1, i, x, y, hrac, pole);
			int diag2 = 0;
			funkce(diag2, 1, -1, i, x, y, hrac, pole);
				
		/*for (int x = 0; x < 10; x++){
			for (int y = 0; y < 10; y++){
				System.out.printf("%c ", pole[x][y]);
			}
			System.out.println("");
		} */
		}
		System.out.println("NIKDO");
	}
}