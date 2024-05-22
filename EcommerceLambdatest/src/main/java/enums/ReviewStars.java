package enums;

import lombok.Getter;

@Getter
public enum ReviewStars {
    ONE_STAR(1),
    TWO_STAR(2),
    THREE_STAR(3),
    FOUR_STAR(4),
    FIVE_STAR(5);

    public final int reviewStars;

    ReviewStars(int stars) {
        this.reviewStars = stars;
    }
}