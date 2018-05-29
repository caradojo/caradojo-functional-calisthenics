package tennis;

public class ScoreBuilderAdvantage implements ScoreBuilder {
    @Override
    public boolean isAcceptable(Points points) {
        return (points.pointsPlayer1 >= 3 && points.pointsPlayer2 >=  3) && (points.pointsPlayer2 > points.pointsPlayer1);
    }

    @Override
    public String getScore(Points points) {
        if (points.pointsPlayer2 > points.pointsPlayer1) {
            return "Advantage player 2";
        }
        throw new UnsupportedOperationException("Not implemented yet !");
    }
}
