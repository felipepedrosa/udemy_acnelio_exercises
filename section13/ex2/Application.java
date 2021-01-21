package section13.ex2;

import section13.ex2.entities.Comment;
import section13.ex2.entities.Post;

import java.text.ParseException;

public class Application {


    public static void main(String[] args) throws ParseException {
        Post post1 = new Post(Post.sdf.parse("21/06/2018 13:05:44"), "Traveling to New Zealand",
                "I'm going to visit this wonderful country!", 12);

        post1.getComments().add(new Comment("Have a nice trip"));
        post1.getComments().add(new Comment("Wow that's awesome!"));

        Post post2 = new Post(Post.sdf.parse("28/07/2018 23:49:19"), "Good night guys","See u tomorrow",
                5);

        post2.getComments().add(new Comment("Good night"));
        post2.getComments().add(new Comment("May the Force be with u"));

        System.out.println(post1.toString());
        System.out.println();
        System.out.println(post2.toString());
    }
}
