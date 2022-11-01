package inheritance;


public class Review {
    protected String author;
    protected double starCount;
    private String body;

    public Review(String author, int starCount, String body) {
        this.author = author;
        setStarCount(starCount);
        this.body = body;
    }

    public void setStarCount(int starCount) {
        if(starCount < 0 || starCount > 5) {
            throw new IllegalArgumentException("Number is out of range, please select a number between 0 and 5");
        }
        this.starCount = starCount;
    }

    public double getStarCount() {
        return starCount;
    }


    public String toString() {
        return "{ author: " + author + ", stars: " + starCount + ", review: " + body + " }";
    }

}
