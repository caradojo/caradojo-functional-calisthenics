package org.ws13.cara.dojo.calisthenics.functional.tennis;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assume.assumeTrue;

/**
 * @author ctranxuan
 */
@DisplayName("HasAWinner should")
@RunWith(JUnitQuickcheck.class)
public class HasAWinnerShould {
    private final HasAWinner hasAWinner = new HasAWinner();


    @Property
    @DisplayName("return false when score points is less than 3 i.e. less than 40 in tennis point")
    public void return_false_when_score_points_are_less_than_3(
            @InRange(min="0", max = "3") int aPlayerPoint1,
            @InRange(min="0", max = "3") int aPlayerPoint2
    ) {
        Score score = new Score(aPlayerPoint1, aPlayerPoint2);
        boolean hasWinner = hasAWinner.test(score);

        assertThat(hasWinner).isFalse();
    }

    @Property
    @DisplayName("return true when score points of one player is greater than 3 (ie 40 in tennis point) and the absolute difference between points is greater than 1")
    public void return_true_when_one_score_point_is_greater_than_3_with_an_absolute_difference_greater_than_1(
            @InRange(min="0", max = "2147483646") int aPlayerPoint1,
            @InRange(min="0", max = "2147483646") int aPlayerPoint2) {
        assumeTrue(Math.abs(aPlayerPoint1 - aPlayerPoint2) > 1);

        Score score = new Score(aPlayerPoint1, aPlayerPoint2);
        boolean hasWinner = hasAWinner.test(score);

        assertThat(hasWinner).isTrue();
    }

    @Property
    @DisplayName("return false when score points are equal")
    public void return_false_when_score_points_are_equal(
            @InRange(min="0", max = "2147483647") int aPlayerPoint) {
        Score score = new Score(aPlayerPoint, aPlayerPoint);
        boolean hasWinner = hasAWinner.test(score);

        assertThat(hasWinner).isFalse();
    }

    @Property
    @DisplayName("return false when score points are greater than 3 (ie 40 tennis point) and the difference is 1 for player 1")
    public void return_false_when_score_points_are_greater_than_3_and_the_difference_is_1_for_player1(
            @InRange(min="0", max = "2147483647") int aPlayerPoint) {
        Score score = new Score(aPlayerPoint + 1, aPlayerPoint);
        boolean hasWinner = hasAWinner.test(score);

        assertThat(hasWinner).isFalse();
    }

    @Property
    @DisplayName("return false when score points are greater than 3 (ie 40 tennis point) and the difference is 1 for player 2")
    public void return_false_when_score_points_are_greater_than_3_and_the_difference_is_1_for_player2(
            @InRange(min="0", max = "2147483647") int aPlayerPoint) {
        Score score = new Score(aPlayerPoint, aPlayerPoint + 1);
        boolean hasWinner = hasAWinner.test(score);

        assertThat(hasWinner).isFalse();
    }
//
//    @ParameterizedTest(name = "score is [{0}, {1}]")
//    @CsvSource({
//            "0, 0",
//            "0, 1",
//            "0, 2",
//            "0, 3",
//            "1, 0",
//            "1, 1",
//            "1, 2",
//            "1, 3",
//            "2, 0",
//            "2, 1",
//            "2, 2",
//            "2, 3",
//            "3, 0",
//            "3, 1",
//            "3, 2",
//            "3, 3"
//
//    })
//    @DisplayName("return false when score points is less than 3 i.e. less than 40 in tennis point")
//    void return_false_when_score_points_are_less_than_3(int aPlayerPoint1, int aPlayerPoint2) {
//        Score score = new Score(aPlayerPoint1, aPlayerPoint2);
//        boolean hasWinner = hasAWinner.test(score);
//
//        assertThat(hasWinner).isFalse();
//    }
}