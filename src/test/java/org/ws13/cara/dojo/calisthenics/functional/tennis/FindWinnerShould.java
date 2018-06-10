package org.ws13.cara.dojo.calisthenics.functional.tennis;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;

import static com.google.common.truth.Truth.assertThat;
import static org.ws13.cara.dojo.calisthenics.functional.tennis.Player.PLAYER1;
import static org.ws13.cara.dojo.calisthenics.functional.tennis.Player.PLAYER2;

/**
 * @author ctranxuan
 */
@DisplayName("FindWinner should")
@RunWith(JUnitQuickcheck.class)
public class FindWinnerShould {
    private final FindWinner findWinner = new FindWinner();

    @Property
    public void return_PLAYER1_when_player1Points_is_greater_than_player2Points_with_more_than_1_points_difference(
            @InRange(min="4", max = "2147483645") int aPlayerPoint) {
        Score score = new Score(aPlayerPoint + 2, aPlayerPoint);
        Player winner = findWinner.apply(score);

        assertThat(winner).isEqualTo(PLAYER1);
    }

    @Property
    public void return_PLAYER2_when_player2Points_is_greater_than_player1Points_with_more_than_1_points_difference(
            @InRange(min="4", max = "2147483645") int aPlayerPoint) {
        Score score = new Score(aPlayerPoint, aPlayerPoint + 2);
        Player winner = findWinner.apply(score);

        assertThat(winner).isEqualTo(PLAYER2);
    }
}