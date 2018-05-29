package tennis;

public class ScoreBuilderAdvantage implements ScoreBuilder {
    @Override
    public boolean isAcceptable(Points points) {
        return (points.pointsPlayer1 >= 3 && points.pointsPlayer2 >=  3) && Math.abs(points.pointsPlayer2 - points.pointsPlayer1) == 1;
    }

    @Override
    public String getScore(Points points) {
        if (points.pointsPlayer1 == points.pointsPlayer2+1) {
            return "Advantage player 1";
        }
        if (points.pointsPlayer2 == points.pointsPlayer1+1) {
            return "Advantage player 2";
        }
        throw new UnsupportedOperationException("Erreur ?");
    }
}
