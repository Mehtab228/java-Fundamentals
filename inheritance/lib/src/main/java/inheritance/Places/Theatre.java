package inheritance.Places;

import inheritance.Review.Review;

import java.util.ArrayList;

public class Theatre extends Places{

    private final ArrayList<String> movieList;

    public Theatre(String name, int priceScore){
        super(name, priceScore);
        movieList = new ArrayList<>();
    }

    public void addMovie(String movieTitle) {
        if(!movieList.contains(movieTitle))
            movieList.add(movieTitle);
    }

    public void removeMovie(String movieTitle) {
        if(!movieList.contains(movieTitle))
            movieList.remove(movieTitle);
    }
}
