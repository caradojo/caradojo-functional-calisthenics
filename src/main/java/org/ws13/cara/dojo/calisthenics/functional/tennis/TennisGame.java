package org.ws13.cara.dojo.calisthenics.functional.tennis;

import org.ws13.cara.dojo.calisthenics.functional.tennis.consoles.IoTennisConsole;

import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;
import static org.ws13.cara.dojo.calisthenics.functional.tennis.AskWhoWinsThePoint.askWhoWinsThePoint;
import static org.ws13.cara.dojo.calisthenics.functional.tennis.ComputeScoreForPlayer.computeScoreForPlayer;
import static org.ws13.cara.dojo.calisthenics.functional.tennis.ConvertAnswerToPlayer.convertAnswerToPlayer;
import static org.ws13.cara.dojo.calisthenics.functional.tennis.FindWinner.findWinner;
import static org.ws13.cara.dojo.calisthenics.functional.tennis.HasAWinner.hasAWinner;

/**
 * @author ctranxuan
 */
// (score, player) -> score <=> (score)-> (player) -> score
//        Stream.iterate("", askPointWinner())
//              .map(answer -> convertToPlayer(answer))
//              .map(player -> computeNewScore(player))
//              .filter(score -> hasAWinner(score))
//              .map(score -> toWinner(score))
//              .findFirst()
//              .ifPresent(winner -> display(winner))
//              .accept(new Score(LOVE, LOVE));
//              ;
public final class TennisGame {
    private final TennisConsole console;

    public TennisGame(TennisConsole aConsole) {
        console = requireNonNull(aConsole);
    }

    public void runGame() {
        Stream.iterate(new Score(0, 0), this::playOnePoint)
                .peek(console::displayPoints)
                .filter(hasAWinner())
                .map(findWinner())
                .findFirst()
                .ifPresent(console::displayWinner);
    }

    private Score playOnePoint(Score aScore) {
        return askWhoWinsThePoint()
                .andThen(convertAnswerToPlayer())
                .andThen(computeScoreForPlayer())
                .apply(console)
                .apply(aScore);
    }

    public static void main(String[] args) {
        TennisConsole console = new IoTennisConsole();
        TennisGame tennisGame = new TennisGame(console);

        tennisGame.runGame();
    }
}
