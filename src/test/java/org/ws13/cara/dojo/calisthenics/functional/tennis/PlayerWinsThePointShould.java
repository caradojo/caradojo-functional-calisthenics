package org.ws13.cara.dojo.calisthenics.functional.tennis;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Assume;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;

import static com.google.common.truth.Truth.assertThat;
import static java.lang.Integer.MAX_VALUE;
import static org.ws13.cara.dojo.calisthenics.functional.tennis.Player.PLAYER1;
import static org.ws13.cara.dojo.calisthenics.functional.tennis.Player.PLAYER2;

/**
 * @author ctranxuan
 */
@RunWith(JUnitQuickcheck.class)
public class PlayerWinsThePointShould {

    @Property
    @DisplayName("return a score with one point more for player1 when player1 wins the point")
    public void return_a_score_with_one_point_incremented_for_player1_when_player1_wins_the_point(
            @InRange(min = "0", max = "2147483646") int aPlayer1Point, @InRange(min = "0", max = "2147483647") int aPlayer2Point) {
        Assume.assumeTrue(aPlayer1Point >= 0);
        Assume.assumeTrue(aPlayer1Point < MAX_VALUE);

        Score score = new Score(aPlayer1Point, aPlayer2Point);
        Score newScore = PLAYER1.winsThePoint(score);

        assertThat(newScore.player1Points()).isEqualTo(score.player1Points() + 1);
        assertThat(newScore.player2Points()).isEqualTo(score.player2Points());
    }

    @Property
    @DisplayName("return a score with one point more for player2 when player2 wins the point")
    public void return_a_score_with_one_point_incremented_for_player2_when_player2_wins_the_point(
            @InRange(min = "0", max = "2147483646") int aPlayer1Point, @InRange(min = "0", max = "2147483647") int aPlayer2Point) {
        Assume.assumeTrue(aPlayer1Point >= 0);
        Assume.assumeTrue(aPlayer1Point < MAX_VALUE);

        Score score = new Score(aPlayer1Point, aPlayer2Point);
        Score newScore = PLAYER2.winsThePoint(score);

        assertThat(newScore.player1Points()).isEqualTo(score.player1Points());
        assertThat(newScore.player2Points()).isEqualTo(score.player2Points() + 1);
    }


}