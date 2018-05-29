package tennis;

public class ScoreBuilderDeuce implements ScoreBuilder {
    @Override
    public boolean isAcceptable(Points points) {
        return (points.pointsPlayer1 >= 3 && points.pointsPlayer2 >=  3) && (points.pointsPlayer1 == points.pointsPlayer2);
    }

    @Override
    public String getScore(Points points) {
        return "DEUCE";
    }
}
