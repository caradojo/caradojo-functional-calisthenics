package org.ws13.cara.dojo.calisthenics.functional.tennis;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * @author ctranxuan
 */
public final class Score {
    private final int player1Points;
    private final int player2Points;

    public Score(int aPlayer1Points, int aPlayer2Points) {
        checkArgument(aPlayer1Points >= 0);
        checkArgument(aPlayer2Points >= 0);

        player1Points = aPlayer1Points;
        player2Points = aPlayer2Points;
    }

    public int player1Points() {
        return player1Points;
    }

    public int player2Points() {
        return player2Points;
    }

    @Override
    public boolean equals(Object aO) {
        if (this == aO) return true;
        if (!(aO instanceof Score)) return false;
        Score score = (Score) aO;
        return player1Points == score.player1Points &&
                player2Points == score.player2Points;
    }

    @Override
    public int hashCode() {
        return Objects.hash(player1Points, player2Points);
    }

    @Override
    public String toString() {
        return "Score{" +
                "player1Points=" + player1Points +
                ", player2Points=" + player2Points +
                '}';
    }
}
