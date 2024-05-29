package website.pages.productpage;

import enums.ReviewStars;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class CommentDetails {

    public String userName;
    public String yourReview;
    public ReviewStars reviewStars;
}