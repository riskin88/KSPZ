public class piskvorky2 {
	public static void funkce (int koef1, int koef2, int i, char hrac, int[][] pole){
		int smer = 0;
		int count = 0;
	//	for (int j = 0; j < i/2; j++){
			for (int k = 1; k <= 4; k++){
				count = 0;
				for (int j = 0; j < i/2; j++){
					if ( pole[j][0] == (pole[i/2][0] - (k * koef1)) && pole[j][1] == (pole[i/2][1] - (k * koef2))){
						smer++;
						count++;
						break;
					}
				}
				if (count == 0){
					break;
				}
			}
			if (smer == 4){
				System.out.printf("%c %d", hrac, i);
				System.exit(0);
			}
			count = 0;
			for (int k = 1; k <= 4 - smer; k++){
				count = 0;
				for (int j = 0; j < i/2; j++){
					if ( pole[j][0] == (pole[i/2][0] + (k * koef1)) && pole[j][1] == (pole[i/2][1] + (k * koef2)) ){
						if (k == 4 - smer){
							System.out.printf("%c %d", hrac, i);
							System.exit(0);
						}
						count++;
						break;
					}
				}
				if (count == 0){
					return;
				}
			}
		
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
					funkce(1, 0, i, hrac, krizek);
				funkce(0, 1, i, hrac, krizek);
				funkce(1, 1, i, hrac, krizek);
				funkce(1, -1, i, hrac, krizek);
				}
			}
			else {
				kolecko[i/2][0] = sc.nextInt();
				kolecko[i/2][1] = sc.nextInt();
				if (i > 450000){
				funkce(1, 0, i, hrac, kolecko);
				funkce(0, 1, i, hrac, kolecko);
				funkce(1, 1, i, hrac, kolecko);
				funkce(1, -1, i, hrac, kolecko);
				}
			}
		}
		System.out.println("NIKDO");
		/*System.out.printf("%d", N);
		System.out.println("");
		for (int x = 0; x < N/2; x++){
			for (int y = 0; y < 2; y++){
				System.out.printf("%d ", krizek[x][y]);
			}
			System.out.println("");
		}
		System.out.println("");
		for (int x = 0; x < N/2; x++){
			for (int y = 0; y < 2; y++){
				System.out.printf("%d ", kolecko[x][y]);
			}
			System.out.println("");
		}*/
	}
}