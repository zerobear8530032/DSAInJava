package NQT;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
public class Solution {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	DepartMentalStore[] arr = new DepartMentalStore[4];
	for(int i =0;i<4;i++) {
		String id = sc.next();
		String name = sc.next();
		String location = sc.next();
		int worker = sc.nextInt();
		int  rating = sc.nextInt();
		arr[i]=new DepartMentalStore(id, name, location, worker, rating);
	}
	String prefixid = sc.next();
	String location = sc.next();
	
	int avg = findAverageWorkerInSpecificLocation(arr, prefixid);
	List<DepartMentalStore> stores= findStoreDetailForGivenLocation(arr, location);
	if(avg<=0) {
		System.out.println("No stores are available with the given input");		
	}else {
		System.out.println(avg);
	}
	if(stores==null) {
		System.out.println("No stores present in the given location");
	}else {
		for( DepartMentalStore s:stores) {
			System.out.println(s.getStoreName());
		}
	}
	
	
}
 public static int findAverageWorkerInSpecificLocation(DepartMentalStore [] arr, String startid) {
	int c=0;
	int sum=0;
	for(DepartMentalStore s:arr) {
		if(s.getId().startsWith(startid)) {
			c++;
			sum+= s.getNoOfWorker();
		}
	}
	
	if(c==0) {
		return 0;
	}
	return sum/c;	

}
 public static List<DepartMentalStore> findStoreDetailForGivenLocation(DepartMentalStore [] arr, String location) {
	 int c=0;
	 int sum=0;
	 List<DepartMentalStore> stores= new ArrayList<DepartMentalStore>();
	 for(DepartMentalStore s:arr) {
		 if(s.getLocation().equals(location)) {
			 stores.add(s);
		 }
	 }
	 if(stores.size()==0) {
		 return null;
	 }
	 sort(stores);
	
		 return stores;
	 
 }
 public static void sort(List<DepartMentalStore> store) {
	 for(int  i =0;i<store.size();i++) {
		 for(int j =i+1;j<store.size();j++) {
			 if(store.get(i).getRating()>store.get(j).getRating()) {
				 DepartMentalStore temp = store.get(i);
				 store.set(i, store.get(j));
				 store.set(j, temp);
			 }
		 }
	 }
 }
	 
 }


class DepartMentalStore{
	
	String id;
	String storeName;
	String location;
	int  noOfWorker;
	int rating;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getNoOfWorker() {
		return noOfWorker;
	}
	public void setNoOfWorker(int noOfWorker) {
		this.noOfWorker = noOfWorker;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public DepartMentalStore(String id, String storeName, String location, int noOfWorker, int rating) {
		this.id = id;
		this.storeName = storeName;
		this.location = location;
		this.noOfWorker = noOfWorker;
		this.rating = rating;
	}
	
	
	
	
}
