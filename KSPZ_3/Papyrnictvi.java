public class Papyrnictvi {
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = sc.nextInt();
		int pecunia = sc.nextInt();
		int[] itemy = new int[N];
		int suma = 0;
		int deleted = 0;
		for (int i = 0; i < N; i++){
			itemy[i] = sc.nextInt();
			suma += itemy[i];
			
		}
		sc.close();
		quickSort(itemy, 0, N-1);
		for (int i = N - 1; i >= 0; i--){
			if (suma > pecunia){
				suma -= itemy[i];
				deleted++;
				continue;
			}
			break;
		}
		System.out.println(deleted);
	}

	
	public static void quickSort(int arr[], int begin, int end) {
		if (begin < end) {
        int partitionIndex = partition(arr, begin, end);
 
        quickSort(arr, begin, partitionIndex-1);
        quickSort(arr, partitionIndex+1, end);
		}
	}
	
	public static int partition(int arr[], int begin, int end) {
		int pivot = arr[end];
		int i = (begin-1);
 
		for (int j = begin; j < end; j++) {
			if (arr[j] <= pivot) {
				i++;
 
				int swapTemp = arr[i];
				arr[i] = arr[j];
				arr[j] = swapTemp;
			}
		}	
 
		int swapTemp = arr[i+1];
		arr[i+1] = arr[end];
		arr[end] = swapTemp;
 
		return i+1;
	}
}
		