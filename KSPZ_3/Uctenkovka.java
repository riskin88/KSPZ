public class Uctenkovka {
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		String item = sc.next();
		char[] itemChars = item.toCharArray();
		int N = Integer.parseInt(sc.next());
		for(int i = 0; i < N; i++){
			String input = sc.next();
			int lettersPassed = 0;
			int lastFoundAt = -1;
			char[] inputChars = input.toCharArray();
			for (int j = 0; j < itemChars.length; j++){
				for (int k = lastFoundAt + 1; k < inputChars.length; k++){
					if (inputChars[k] == itemChars[j]){
						lettersPassed++;
						lastFoundAt = k;
						break;
					}
				}
			}
			if (lettersPassed >= itemChars.length){
					System.out.println("ANO");
			}
			else
				System.out.println("NE");
		}
	}
}