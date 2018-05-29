package tennis;

import java.util.List;
import java.util.function.Predicate;

import static java.util.Arrays.asList;

public class TennisGameState {

    private final Points points;

    TennisGameState() {
        this(new Points(0,0));
    }

    private TennisGameState(Points points) {
        this.points = points;
    }

    public boolean notFinished() {
        return !isFinished();
    }

    private boolean isFinished() {
        return (points.pointsPlayer1 >= 4 || points.pointsPlayer2 >= 4) && Math.abs(points.pointsPlayer1-points.pointsPlayer2) > 1;
    }

    public String winner() {
        return points.pointsPlayer1 > points.pointsPlayer2 ? "Player 1" : "Player 2";
    }

    private List<ScoreBuilder> builders = asList(
            new ScoreBuilderDeuce(),
            new ScoreBuilderAdvantage(),
            new ScoreBuilderNormal());

    public String currentScore() {

        Predicate<? super ScoreBuilder> isAcceptable = new Predicate<ScoreBuilder>() {
            @Override
            public boolean test(ScoreBuilder scoreBuilder) {
                return scoreBuilder.isAcceptable(points);
            }
        };

        return builders
                .stream()
                .filter(isAcceptable)
                .findFirst()
                .get()
                .getScore(points);
    }



    public TennisGameState computeNextScore(String pointWinner) {
        return new TennisGameState(new Points(
                this.points.pointsPlayer1+(pointWinner.equals("1") ? 1 : 0),
                this.points.pointsPlayer2+(pointWinner.equals("2") ? 1 : 0))
        );
    }


}
