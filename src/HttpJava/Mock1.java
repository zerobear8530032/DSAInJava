package HttpJava;

import java.io.*;
import java.net.*;
import java.util.List;

import com.google.gson.*;

class Page{
    int page;
    int per_page;
    int total;
    int total_pages;
    List<Restaurant> data;

    @Override
    public String toString() {
        return "page{" +
                "page=" + page +
                ", per_page=" + per_page +
                ", total=" + total +
                ", total_pges=" + total_pages +
                ", data=" + data +
                '}';
    }

    public Page(){}

    public Page(int page, int per_page, int total, int total_pages, List<Restaurant> data) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<Restaurant> getData() {
        return data;
    }

    public void setData(List<Restaurant> data) {
        this.data = data;
    }
}
class Restaurant{
    int id;
    String city;
    String name;
    int estimated_cost;
    UserRating user_rating;

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", name='" + name + '\'' +
                ", estimated_cost=" + estimated_cost +
                ", user_rating=" + user_rating +
                '}';
    }


    public Restaurant(){}

    public Restaurant(int id, String city, String name, int estimated_cost, UserRating user_rating) {
        this.id = id;
        this.city = city;
        this.name = name;
        this.estimated_cost = estimated_cost;
        this.user_rating = user_rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEstimated_cost() {
        return estimated_cost;
    }

    public void setEstimated_cost(int estimated_cost) {
        this.estimated_cost = estimated_cost;
    }

    public UserRating getUser_rating() {
        return user_rating;
    }

    public void setUser_rating(UserRating user_rating) {
        this.user_rating = user_rating;
    }
}
class UserRating{
    double average_rating;
    int votes;

    @Override
    public String toString() {
        return "UserRating{" +
                "average_rating=" + average_rating +
                ", votes=" + votes +
                '}';
    }
    public UserRating(){}

    public UserRating(double average_rating, int votes) {
        this.average_rating = average_rating;
        this.votes = votes;
    }

    public double getAverage_rating() {
        return average_rating;
    }

    public void setAverage_rating(double average_rating) {
        this.average_rating = average_rating;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
public class Mock1 {

    public static String getBestRestaurant(String city, int minVotes) throws Exception {
        String url ="https://jsonmock.hackerrank.com/api/food_outlets?city="+city+"&page=";
        String bestRestaurant = "";
        double maxrating = 0;
        int bestRestaurantVotes=0;
        int p=1;
        int total_page=1;
        while(p<=total_page){
            URL conurl = new URL(url+p);
            HttpURLConnection connection= (HttpURLConnection) conurl.openConnection();
//            System.out.println(connection.getResponseCode());
            BufferedReader reader= new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = reader.readLine();
            Gson gson= new Gson();
            Page page= gson.fromJson(line,Page.class);
            total_page=page.getTotal_pages();
            p++;
//            System.out.println(line);
            for(Restaurant restaurant:page.getData()){
                if(restaurant.getCity().equalsIgnoreCase(city) && restaurant.getUser_rating().getVotes()>=minVotes){
                    if(bestRestaurant.equals("") || maxrating<restaurant.getUser_rating().average_rating){
                        bestRestaurant=restaurant.getName();
                        maxrating=restaurant.getUser_rating().getAverage_rating();
                        bestRestaurantVotes= restaurant.getUser_rating().getVotes();
                    }else if(maxrating==restaurant.getUser_rating().average_rating && restaurant.getUser_rating().getVotes()>bestRestaurantVotes){
                        bestRestaurant=restaurant.getName();
                        maxrating=restaurant.getUser_rating().getAverage_rating();
                        bestRestaurantVotes= restaurant.getUser_rating().getVotes();
                    }
                }
            }
        }
        return bestRestaurant;
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int n= Integer.parseInt(br.readLine());
        for(int i =0;i<n;i++){
            String city = br.readLine();
            int minVotes = Integer.parseInt(br.readLine().trim());
            String expected = br.readLine();
            String result =getBestRestaurant(city, minVotes);
            if (result.equals(expected)) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL");
                System.out.println("Expected: " + expected);
                System.out.println("Got: " + result);
            }
        }
        br.close();
    }
}
