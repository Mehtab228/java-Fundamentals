package inheritance.Review;


public class Review {
    public String author;
    protected double starCount;
    private final String body;
    public String movieSeen = "";

    public Review(String author, int starCount, String body) {
        this.author = author;
        setStarCount(starCount);
        this.body = body;
    }

    public Review(String author,  int starCount, String body, String movieSeen){
        this.author = author;
        setStarCount(starCount);
        this.body = body;
        this.movieSeen = movieSeen;
    }

    public String getAuthor() {
        return author;
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
        if (movieSeen.equals(""))
            return "{ author: " + author + ", stars: " + starCount + ", review: " + body + " }";
        else
            return "{ author: " + author + ", stars: " + starCount + ", review: " + body
                    + ", movie_viewed: " + movieSeen + " }";
    }

}
