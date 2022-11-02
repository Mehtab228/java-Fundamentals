package inheritance.Places;

import inheritance.Review.Review;

import java.util.ArrayList;

public class Theatre extends Places{

    private final ArrayList<String> movieList;
    private int movieCount = 0;

    public Theatre(String name, int priceScore){
        super(name, priceScore);
        movieList = new ArrayList<>();
    }

    public void addMovie(String movieTitle) {
        if(!movieList.contains(movieTitle))
            movieList.add(movieTitle);
        movieCount++;
    }

    public void removeMovie(String movieTitle) {
        if(movieList.contains(movieTitle))
            movieList.remove(movieTitle);
        movieCount--;
    }

    public int getMovieCount() {
        return movieCount;
    }

    @Override
    public String toString() {
        return "{ name: " + name + ", price: " + priceScore + ", stars: "
                + getStarCount() + ", movies showing: " + movieList + " }";
    }
}
