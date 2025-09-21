package HashMap;//1912. Design HashMap.Movie Rental System
//Hard
//Topics
//premium lock icon
//Companies
//Hint
//You have a movie renting company consisting of n shops. You want to implement a renting system that supports searching for, booking, and returning movies. The system should also support generating a report of the currently rented movies.
//
//Each movie is given as a 2D integer array entries where entries[i] = [shopi, moviei, pricei] indicates that there is a copy of movie moviei at shop shopi with a rental price of pricei. Each shop carries at most one copy of a movie moviei.
//
//The system should support the following functions:
//
//Search: Finds the cheapest 5 shops that have an unrented copy of a given movie. The shops should be sorted by price in ascending order, and in case of a tie, the one with the smaller shopi should appear first. If there are less than 5 matching shops, then all of them should be returned. If no shop has an unrented copy, then an empty list should be returned.
//Rent: Rents an unrented copy of a given movie from a given shop.
//Drop: Drops off a previously rented copy of a given movie at a given shop.
//Report: Returns the cheapest 5 rented movies (possibly of the same movie ID) as a 2D list res where res[j] = [shopj, moviej] describes that the jth cheapest rented movie moviej was rented from the shop shopj. The movies in res should be sorted by price in ascending order, and in case of a tie, the one with the smaller shopj should appear first, and if there is still tie, the one with the smaller moviej should appear first. If there are fewer than 5 rented movies, then all of them should be returned. If no movies are currently being rented, then an empty list should be returned.
//Implement the HashMap.MovieRentingSystem class:
//
//HashMap.MovieRentingSystem(int n, int[][] entries) Initializes the HashMap.MovieRentingSystem object with n shops and the movies in entries.
//List<Integer> search(int movie) Returns a list of shops that have an unrented copy of the given movie as described above.
//void rent(int shop, int movie) Rents the given movie from the given shop.
//void drop(int shop, int movie) Drops off a previously rented movie at the given shop.
//List<List<Integer>> report() Returns a list of cheapest rented movies as described above.
//Note: The test cases will be generated such that rent will only be called if the shop has an unrented copy of the movie, and drop will only be called if the shop had previously rented out the movie.
//
//
//
//Example 1:
//
//Input
//["HashMap.MovieRentingSystem", "search", "rent", "rent", "report", "drop", "search"]
//[[3, [[0, 1, 5], [0, 2, 6], [0, 3, 7], [1, 1, 4], [1, 2, 7], [2, 1, 5]]], [1], [0, 1], [1, 2], [], [1, 2], [2]]
//Output
//[null, [1, 0, 2], null, null, [[0, 1], [1, 2]], null, [0, 1]]
//
//Explanation
//HashMap.MovieRentingSystem movieRentingSystem = new HashMap.MovieRentingSystem(3, [[0, 1, 5], [0, 2, 6], [0, 3, 7], [1, 1, 4], [1, 2, 7], [2, 1, 5]]);
//movieRentingSystem.search(1);  // return [1, 0, 2], Movies of ID 1 are unrented at shops 1, 0, and 2. Shop 1 is cheapest; shop 0 and 2 are the same price, so order by shop number.
//movieRentingSystem.rent(0, 1); // Rent movie 1 from shop 0. Unrented movies at shop 0 are now [2,3].
//movieRentingSystem.rent(1, 2); // Rent movie 2 from shop 1. Unrented movies at shop 1 are now [1].
//movieRentingSystem.report();   // return [[0, 1], [1, 2]]. HashMap.Movie 1 from shop 0 is cheapest, followed by movie 2 from shop 1.
//movieRentingSystem.drop(1, 2); // Drop off movie 2 at shop 1. Unrented movies at shop 1 are now [1,2].
//movieRentingSystem.search(2);  // return [0, 1]. Movies of ID 2 are unrented at shops 0 and 1. Shop 0 is cheapest, followed by shop 1.
//
//
//Constraints:
//
//1 <= n <= 3 * 105
//1 <= entries.length <= 105
//0 <= shopi < n
//1 <= moviei, pricei <= 104
//Each shop carries at most one copy of a movie moviei.
//At most 105 calls in total will be made to search, rent, drop and report.
import java.util.*;class Movie implements Comparable<Movie>{
    int shop;
    int movieId;
    int price;

    public Movie(int shop, int movieId, int price){
        this.shop=shop;
        this.movieId = movieId;
        this.price=price;
    }

    @Override
    public int compareTo(Movie m){
        if(this.price!=m.price){
            return this.price-m.price;
        }else if(this.shop!=m.shop){
            return this.shop-m.shop;
        }else{
            return this.movieId -m.movieId;
        }
    }
}

// approch :
// simple create 2 : mapping :
// one map will have a key which is combine with movie id and shop id which map to actual object
// second map will have a direct mapping from movie id to priority queue of sorted movies according to criteria
// last we can use 2 sorted Sets one for rented movies second for unrented movies
// now for search we can just use the movie id to sorted queue
// top shops from that priority queue or sorted set depends on implementation
// rented simily remove the movie from unrented set and add to rented set
// but to get the actual object we can use the movieID,shop Id as key to get object
// similary we can do vise versa sfor drop
// and for report we can apply same operation in rented sorted set like we did in search
//| Operation | Time Complexity                        |
//| --------- | -------------------------------------- |
//| search    | O(log k) (k = copies of the movie)     |
//| rent      | O(log n)                               |
//| drop      | O(log n)                               |
//| report    | O(log r) (r = currently rented movies) |
//| Space     | O(n)                                   |
class MovieRentingSystem {

    TreeSet<Movie> unRentedMovies;
    TreeSet<Movie> rentedMovies;

    HashMap<Integer, TreeSet<Movie>> movieToShop;
    HashMap<String, Movie> MStoMovie;

    public MovieRentingSystem(int n, int[][] entries) {
        unRentedMovies = new TreeSet<>();
        rentedMovies = new TreeSet<>();
        MStoMovie = new HashMap<>();
        movieToShop= new HashMap<>();
        for (int[] movie : entries) {
            int sId = movie[0];
            int mId = movie[1];
            int price = movie[2];
            Movie m = new Movie(sId, mId, price);
            String key = sId + "," + mId;
            MStoMovie.put(key, m);
            if (movieToShop.containsKey(mId)) {
                movieToShop.get(mId).add(m);
            } else {
                TreeSet<Movie> movies = new TreeSet<>();
                movies.add(m);
                movieToShop.put(mId, movies);
            }
            unRentedMovies.add(m);
        }
    }

    public List<Integer> search(int movie) {
        TreeSet<Movie> topMovies = movieToShop.get(movie);
        List<Integer> topShops = new ArrayList<>();
        List<Movie> removed = new ArrayList<>();
        if (topMovies == null) {
            return topShops;
        }
        while (topShops.size() < 5 && topMovies.size() != 0) {
            Movie m = topMovies.removeFirst();
            removed.add(m);
            topShops.add(m.shop);
        }
        for (Movie m : removed) {
            topMovies.add(m);
        }
        return topShops;
    }

    public void rent(int shop, int movie) {
        String key = shop + "," + movie;
        Movie rentedmovie = MStoMovie.get(key);
        unRentedMovies.remove(rentedmovie);
        rentedMovies.add(rentedmovie);
        if (movieToShop.containsKey(movie)) {
            movieToShop.get(movie).remove(rentedmovie);
        }
    }

    public void drop(int shop, int movie) {
        String key = shop + "," + movie;
        Movie dropmovie = MStoMovie.get(key);
        rentedMovies.remove(dropmovie);
        unRentedMovies.add(dropmovie);
        if (movieToShop.containsKey(movie)) {
            movieToShop.get(movie).add(dropmovie);
        }
    }

    public List<List<Integer>> report() {

        List<List<Integer>> topRenterMovies = new ArrayList<>();
        List<Movie> removed = new ArrayList<>();
        if (rentedMovies == null) {
            return topRenterMovies;
        }
        while (topRenterMovies.size() < 5 && rentedMovies.size() != 0) {
            Movie m = rentedMovies.removeFirst();
            removed.add(m);
            topRenterMovies.add(Arrays.asList(m.shop, m.movieId));
        }
        for (Movie m : removed) {
            rentedMovies.add(m);
        }
        return topRenterMovies;
    }
    public static void main(String[] args) {
        int [][] entries= {{0, 1, 5}, {0, 2, 6},{0, 3, 7}, {1, 1, 4}, {1, 2, 7}, {2, 1, 5}};
        MovieRentingSystem movieRentingSystem = new MovieRentingSystem(3, entries);
        movieRentingSystem.search(1);  // return [1, 0, 2], Movies of ID 1 are unrented at shops 1, 0, and 2. Shop 1 is cheapest; shop 0 and 2 are the same price, so order by shop number.
        movieRentingSystem.rent(0, 1); // Rent movie 1 from shop 0. Unrented movies at shop 0 are now [2,3].
        movieRentingSystem.rent(1, 2); // Rent movie 2 from shop 1. Unrented movies at shop 1 are now [1].
        movieRentingSystem.report();   // return [[0, 1], [1, 2]]. Movie 1 from shop 0 is cheapest, followed by movie 2 from shop 1.
        movieRentingSystem.drop(1, 2); // Drop off movie 2 at shop 1. Unrented movies at shop 1 are now [1,2].
        movieRentingSystem.search(2);  // return [0, 1]. Movies of ID 2 are unrented at shops 0 and 1. Shop 0 is cheapest, followed by shop 1.
    }
}



