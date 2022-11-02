/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package inheritance;

import inheritance.Places.Restaurant;
import inheritance.Places.Shop;
import inheritance.Places.Theatre;
import inheritance.Review.Review;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    @Test
    void testRestaurantConstructor() {
        Restaurant sut = new Restaurant("Carmelos", 3);
        assert(sut.getName().equals("Carmelos"));
        assert(sut.getPriceScore() == 3);
        assert(sut.getStarCount() == 0.0);
        assert(sut.toString().equals("{ name: Carmelos, price: 3, stars: 0.0 }"));
    }

    @Test void testShopConstructor(){
        Shop sut = new Shop("Target", "Black hole of stuff", 2);
        assert(sut.getName().equals("Target"));
        assert(sut.getPriceScore() == 2);
        assert(sut.getStarCount() == 0.0);
        assert(sut.getDescription().equals("Black hole of stuff"));
        assert(sut.toString().equals("{ name: Target, description: Black hole of stuff, price: 2, stars: 0.0 }"));
    }

    @Test void testTheatreConstructor(){
        Theatre sut = new Theatre("MoviesR'Us", 3);
        assert(sut.getName().equals("MoviesR'Us"));
        assert(sut.getPriceScore() == 3);
        assert(sut.getStarCount() == 0.0);
        assert(sut.toString().equals("{ name: MoviesR'Us, price: 3, stars: 0.0, movies showing: [] }"));
    }

    @Test void addMovie(){
        Theatre sut = new Theatre("MoviesR'Us", 3);
        sut.addMovie("Lord of the Rings");
        sut.addMovie("Shaun of the Dead");
        sut.addMovie("Treasure Planet");
        assert(sut.getMovieCount() == 3);
        assert(sut.toString().equals("{ name: MoviesR'Us, price: 3, stars: 0.0, movies showing: [Lord of the Rings, Shaun of the Dead, Treasure Planet] }"));
    }

    @Test void removeMovie(){
        Theatre sut = new Theatre("MoviesR'Us", 3);
        sut.addMovie("Lord of the Rings");
        sut.addMovie("Shaun of the Dead");
        sut.addMovie("Treasure Planet");
        sut.removeMovie("Shaun of the Dead");
        assert(sut.getMovieCount() == 2);
        assert(sut.toString().equals("{ name: MoviesR'Us, price: 3, stars: 0.0, movies showing: [Lord of the Rings, Treasure Planet] }"));
    }

    @Test void addTheatreReview(){
        Theatre sut = new Theatre("MoviesR'Us", 3);
        Review review = new Review("Max", 4, "Haven't seen it", "Treasure Planet");
        Review review2 = new Review("Ben", 3, "9/10", "Treasure Planet");
        Review review3 = new Review("Joe", 4, "8/10", "Treasure Planet");
        sut.addReview(review);
        sut.addReview(review2);
        sut.addReview(review3);
        assert(sut.getReviewCount() == 3);
        assert(sut.getStarCount() == 3.67);
        assert(review.toString().equals("{ author: Max, stars: 4.0, review: Haven't seen it, movie_viewed: Treasure Planet }"));
    }

    @Test void addReviewToReviews() {
        Restaurant sut = new Restaurant("Carmelos", 3);
        Review review = new Review("Joe", 5, "Amazing.");
        Review review2 = new Review("Max", 4, "Amazing.");
        sut.addReview(review);
        sut.addReview(review2);
        assert(sut.getReviewCount() == 2);
        assert (sut.getStarCount() == 4.5);
    }

    @Test void checkReview() {
        Restaurant sut = new Restaurant("Carmelos", 3);
        Review review = new Review("Joe", 5, "Amazing.");
        Review review2 = new Review("Max", 4, "So good.");
        sut.addReview(review);
        sut.addReview(review2);
        System.out.println(review.toString());
        assert(review.toString().equals("{ author: Joe, stars: 5.0, review: Amazing. }"));
        assert(review2.toString().equals("{ author: Max, stars: 4.0, review: So good. }"));
    }

    @Test void duplicateReview() {
        Restaurant sut = new Restaurant("Carmelos", 3);
        Review review = new Review("Ben", 5, "Amazing.");
        sut.addReview(review);
        Review review2 = new Review("Ben", 5, "Amazing.");
        sut.addReview(review2);
        assert(sut.getReviewCount() == 1);
    }

    @Test void badRestaurant(){
        assertThrows(IllegalArgumentException.class, () -> new Restaurant("Carmelos", -3));
    }

    @Test void badReviews(){
        assertThrows(IllegalArgumentException.class, () -> new Review("Joe", -5, "Amazing."));
    }
}