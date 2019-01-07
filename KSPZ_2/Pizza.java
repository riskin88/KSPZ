import java.util.ArrayList;
import java.util.List;

public class Pizza {
    
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = sc.nextInt();
		List<String> druhy = new ArrayList<>();
		List<Integer> cetnosti = new ArrayList<>();
		druhy.add(sc.next());
		cetnosti.add(sc.nextInt());
		for (int i = 0; i < N - 1; i++){
			String druh = sc.next();
			for (int j = 0; j < druhy.size(); j++){
				if (druh.equals(druhy.get(j))){
					cetnosti.set(j, cetnosti.get(j) + sc.nextInt());
					break;
				}
				else if (j == druhy.size() - 1){
					druhy.add(druh);
					cetnosti.add(sc.nextInt());
					j++;
				}
			}
		}
		for (int i = 0; i < druhy.size(); i++){
			int puvodniCetnost = cetnosti.get(i);
			cetnosti.set(i, (puvodniCetnost / 8) + 1);
			if (puvodniCetnost % 8 == 0){
				cetnosti.set(i, cetnosti.get(i) - 1);
			}
		}
		System.out.printf("%d\n", druhy.size());
		for (int i = 0; i < druhy.size(); i++){
			System.out.printf("%s ", druhy.get(i));
			System.out.printf("%d\n", cetnosti.get(i));
		}
	}
}