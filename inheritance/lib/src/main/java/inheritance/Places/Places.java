package inheritance.Places;

import inheritance.Review.Review;

import java.util.ArrayList;

public class Places {

    protected String name;
    protected int priceScore;
    protected int reviewCount = 0;
    protected ArrayList<Review> reviews;

    public Places(String name, int priceScore){
        this.name = name;
        setPriceScore(priceScore);
        reviews = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getStarCount() {
        if (reviews.size() > 0) {
            return getAverageStarCount(reviews);
        } else {
            return 0;
        }
    }

    private double getAverageStarCount(ArrayList<Review> reviewList){
        double sum = 0.0;
        for(Review item: reviewList) {
            sum += item.getStarCount();
        }
        return sum/reviewList.size();
    }

    public void addReview(Review review) {
        boolean namePresent = reviews.stream().anyMatch((v) -> v.author.equals(review.author));
        if(!namePresent) {
            reviews.add(review);
            reviewCount++;
            System.out.println(reviews);
        } else {
            System.out.println("You have already left a review!");
        }
    }

    public int getPriceScore() {
        return priceScore;
    }

    public void setPriceScore(int priceScore) {
        if(priceScore < 0 || priceScore > 3) {
            throw new IllegalArgumentException("Number input is out of range, please select a number between 0 and 3");
        }
        this.priceScore = priceScore;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public String toString() {
        return "{ name: " + name + ", price: " + priceScore + ", rating: " + getStarCount() + " }";
    }
}
