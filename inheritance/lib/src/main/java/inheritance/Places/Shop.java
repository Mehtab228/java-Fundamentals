package inheritance.Places;

import inheritance.Review.Review;

public class Shop extends Places {
    private final String description;

    public Shop (String name, String description, int priceScore){
        super(name, priceScore);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "{ name: " + name + ", description: " + description + ", price: " + priceScore + ", stars: " + getStarCount() + " }";
    }

}
