package org.ws13.cara.dojo.calisthenics.functional.tennis.consoles;

import org.ws13.cara.dojo.calisthenics.functional.tennis.Player;
import org.ws13.cara.dojo.calisthenics.functional.tennis.Score;
import org.ws13.cara.dojo.calisthenics.functional.tennis.TennisConsole;
import org.ws13.cara.dojo.calisthenics.functional.tennis.converters.AdvantagePointsConverter;
import org.ws13.cara.dojo.calisthenics.functional.tennis.converters.DeucePointsConverter;
import org.ws13.cara.dojo.calisthenics.functional.tennis.converters.NormalPointsConverter;
import org.ws13.cara.dojo.calisthenics.functional.tennis.converters.TennisPointsConverter;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;

import static java.util.Objects.requireNonNull;

/**
 * @author ctranxuan
 */
public class IoTennisConsole implements TennisConsole {
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
