package org.ws13.cara.dojo.calisthenics.functional.tennis;

import org.ws13.cara.dojo.calisthenics.functional.tennis.converters.AdvantagePointsConverter;
import org.ws13.cara.dojo.calisthenics.functional.tennis.converters.DeucePointsConverter;
import org.ws13.cara.dojo.calisthenics.functional.tennis.converters.NormalPointsConverter;
import org.ws13.cara.dojo.calisthenics.functional.tennis.converters.TennisPointsConverter;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;
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
public final class TennisGame {

    static class IoTennisConsole implements TennisConsole {
        private static final Scanner SCANNER = new Scanner(System.in);

        private static final List<TennisPointsConverter> POINTS_CONVERTERS = List.of(new NormalPointsConverter(),
                                                                                     new DeucePointsConverter(),
                                                                                     new AdvantagePointsConverter());
        @Override
        public String askWhoWinsThePoint() {
            System.out.println("Who wins the point?");
            return SCANNER.nextLine();
        }

        @Override
        public void displayWinner(Player aWinner) {
            requireNonNull(aWinner);
            System.out.println("Game winner is " + aWinner);
        }

        @Override
        public void displayPoints(Score aScore) {
            POINTS_CONVERTERS
                    .stream()
                    .map(convertScore(aScore))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .findFirst()
                    .ifPresent(System.out::println);
        }

        private Function<TennisPointsConverter, Optional<String>> convertScore(Score aScore) {
            return converter -> converter.apply(aScore);
        }


    }

    final static TennisConsole console = new IoTennisConsole();

    public static void main(String[] args) {
        Stream.iterate(new Score(0, 0), TennisGame::playOnePoint)
                .peek(console::displayPoints)
                .filter(hasAWinner())
                .map(findWinner())
                .findFirst()
                .ifPresent(console::displayWinner);
    }

    private static Score playOnePoint(Score aScore) {
        return askWhoWinsThePoint()
                .andThen(convertAnswerToPlayer())
                .andThen(computeScoreForPlayer())
                .apply(console)
                .apply(aScore);
    }

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

}
