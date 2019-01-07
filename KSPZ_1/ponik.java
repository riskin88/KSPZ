public class ponik {
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int predchozi = 0;
		int[] vysledky = new int[N];
		for (int i = 0; i < N; i++){
			String cas = sc.nextLine();
			String[] cisla = cas.split(":");
			int hodiny = Integer.parseInt(cisla[0]) * 3600;
			int minuty = Integer.parseInt(cisla[1]) * 60;
			int vteriny = Integer.parseInt(cisla[2]);
			int novy = hodiny + minuty + vteriny;
			int vysledek = novy - predchozi;
			predchozi = novy;
			vysledky[i] = vysledek;
		}
		for (int i = 0; i < N; i++){
			System.out.println(vysledky[i]);
		}
	}
}