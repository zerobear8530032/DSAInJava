package Arrays;
public class concat2Array {
	
	
	public static int [] concatarray(int [] arr1,int [] arr2) {
		int l1=arr1.length;
		int l2=arr2.length;
		int  output []= new int [l1+l2];
		for (int i = 0; i < l1; i++) {
		    output[i] = arr1[i];
		}
		for (int j = 0; j < l2; j++) {
		    output[j + l1] = arr2[j];
		}
		return output;
	}
	
	

	public static void main(String[] args) {
		 
		long start = System.currentTimeMillis();
		int arr1[] = new int [1000000];
		int arr2[] = new int [1000000];
		int[] output=concatarray(arr1, arr2);
		long end = System.currentTimeMillis()-start;
		System.out.println(end);
		

	}

}
