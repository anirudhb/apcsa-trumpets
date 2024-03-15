package apcsa;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scraper {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://amazon.com");
        try {
            Thread.sleep(10000);
        } catch (Exception e) {}

        ArrayList<Review> reviews = new ArrayList<>();
        for (int page = 0; page < 30; page++) {
            String url = "https://www.amazon.com/Mendini-Cecilio-MTT-L-Trumpet-Gold/product-reviews/B00I8QJT78/ref=cm_cr_dp_d_show_all_btm?ie=UTF8&reviewerType=all_reviews";
            if (page != 0) {
                url = "https://www.amazon.com/Mendini-Cecilio-MTT-L-Trumpet-Gold/product-reviews/B00I8QJT78/ref=cm_cr_dp_d_show_all_btm?ie=UTF8&pageNumber=" + page + "&reviewerType=all_reviews";
            }

            // go to the amazon page
            driver.get(url);
            List<WebElement> elements = driver.findElements(By.cssSelector("[data-hook=review]"));
            for (WebElement e : elements) {
                String reviewer = e.findElement(By.cssSelector(".a-profile-name")).getText();
                String starsText = e.findElement(By.cssSelector(".a-icon-alt")).getText();
                int stars = 5;
                if (starsText.length() > 0) {
                    stars = Integer.parseInt(starsText.substring(0, 1));
                }
                String review = e.findElement(By.cssSelector("[data-hook=review-body]")).getText();
                reviews.add(new Review(reviewer, stars, review));
            }
        }

        driver.quit();

        try {
            PrintWriter writer = new PrintWriter("socialMediaPosts_scraped.txt", "utf-8");
            for (Review r : reviews) {
                writer.println(r);
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        HashSet<String> words = new HashSet<>();

        for (Review review : reviews) {
            String r = Util.cleanString(review.review);
            for (String w : r.split(" ")) {
                words.add(w);
            }
        }

        try {
            PrintWriter writer = new PrintWriter("targetWords_scraped.txt", "utf-8");
            for (String w : words) {
                writer.println(w);
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
