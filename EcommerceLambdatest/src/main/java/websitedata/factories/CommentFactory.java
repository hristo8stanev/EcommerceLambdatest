package websitedata.factories;

import com.github.javafaker.Faker;
import enums.ReviewStars;
import website.pages.productpage.CommentDetails;

public class CommentFactory {

    public static final Faker faker = new Faker();

    public static CommentDetails userReview(ReviewStars stars) {

        return CommentDetails.builder()
                .userName(faker.name().firstName())
                .yourReview(faker.lorem().characters())
                .reviewStars(stars)
                .build();
    }
}