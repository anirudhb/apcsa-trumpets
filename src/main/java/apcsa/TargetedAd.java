package apcsa;

import java.util.ArrayList;
import java.util.HashSet;

/*
 * Problem 2 Sell My Pet Food
 */
public class TargetedAd {

  public static void main(String[] args)
  {
    DataCollector collector = new DataCollector();
    collector.setData("socialMediaPosts.txt", "targetWords.txt");
    HashSet<String> targetWords = new HashSet<>();
    String s = collector.getNextTargetWord();
    while (!s.equals("NONE")) {
      targetWords.add(s);
      s = collector.getNextTargetWord();
    }
    String r = collector.getNextPost();
    HashSet<String> targetedUsers = new HashSet<>();
    while (!r.equals("NONE")) {
      Review review = Review.fromString(r);
      boolean doTarget = false;
      // chunk
      for (String word : Util.cleanString(review.review).split(" ")) {
        if (targetWords.contains(word)) {
          targetedUsers.add(review.reviewer.toLowerCase());
          doTarget = true;
        }
        if (doTarget) break;
      }
      r = collector.getNextPost();
    }
    collector.prepareAdvertisement("targetedAds.txt", String.join(" ", targetedUsers), "Buy trumpets fr");
    /*  
     * TODO:
     * PREPARATION WORK
     * (1) Create a file called targetWords.txt. Populate this file with words on each line that
     *     you think would determine if a user is a dog or cat owner.
     * 
     * PROGRAMMING
     * (2) Create a new DataCollector object and set the data to "socialMediaPostsSmall.txt" and "targetWords.txt"
     *     Important: Use the socialMedialPostsSmall to create your algorithm. Using a small file will help you 
     *     generate your solution quicker and give you the ability to double check your work.
     * (3) Create a String variable to hold the names of all the user. (The first word of every post is 
     *     a person's username)
     * (4) Compare each user's post to each target word. If a user mentions a target word, add their username to 
     *     the String of users. Separate usernames with a space. 
     *         Hint: You can use loops to look through each word. 
     *         Hint2: You can use indexOf to check if a word is in a user post. 
     * (5) Once you have all the users, use your DataCollector's prepareAdvertisement method to prepare a file 
     *     with all users and the advertisement you will send them.
     *         Additional Info: The prepareAdvertisement creates a new file on your computer. Check the posts of
     *         some of the usernames to make sure your algorithm worked.
     * 
     * THE FINAL SOLUTION
     * (6) Your solution should work with the socialMedialPostsSmall.txt. Modify your DataCollector initialization
     *    so you use the socialMediaPosts.txt. You should now have a larger file of users to target.
     */


    /* your code here */
    
     
  }

}
