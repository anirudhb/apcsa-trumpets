package apcsa;

public class Review {
    public String reviewer;
    public int stars;
    public String review;

    public Review(String r, int s, String r2) {
        reviewer = r;
        stars = s;
        review = r2;
    }

    public static Review fromString(String s) {
        int i1 = s.indexOf("|");
        int i2 = s.indexOf("|", i1+1);
        String split0 = s.substring(0, i1);
        String split1 = s.substring(i1+1, i2);
        String split2 = s.substring(i2+1);
        String reviewer = split0.strip();
        int stars = Integer.parseInt(split1.strip().substring(0, 1));
        String review = split2.strip();
        return new Review(reviewer, stars, review);
    }

    @Override
    public String toString() {
        return reviewer + " | " + " " + stars + "/" + 5 + " | " + review.replaceAll("\n", " ");
    }
}
