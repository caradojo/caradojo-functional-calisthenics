import {equal} from "assert";
import {formatScore, isGameFinished, nextScoreWithFormatting, Score, p1, p2} from "../src/TennisLogic";
import {assert, expect} from 'chai';

function nextScore(previousScore: Score, ballWinner: string) {
    const {score} = nextScoreWithFormatting({score: previousScore, ballWinner});
    return score;
}


describe('TennisLogic', () => {

    describe('nextScore', () => {
        it('adds 1 to player who wins', () => {
            expect(nextScore([0, 0], p1)).eql([1, 0]);
            expect(nextScore([0, 0], p2)).eql([0, 1]);
            expect(nextScore([5, 6], p2)).eql([5, 7])
        });
    });

    describe('isGameFinished', () => {
        it('is over when one player has atleast 4 points and two more than the oponent', () => {
            expect(isGameFinished([0, 0])).false;
            expect(isGameFinished([1, 0])).false;
            expect(isGameFinished([2, 0])).false;
            expect(isGameFinished([3, 0])).false;
            expect(isGameFinished([4, 0])).true;
            
            expect(isGameFinished([0, 0])).false;
            expect(isGameFinished([0, 1])).false;
            expect(isGameFinished([0, 2])).false;
            expect(isGameFinished([0, 3])).false;
            expect(isGameFinished([0, 4])).true;

            expect(isGameFinished([3, 4])).false;
            expect(isGameFinished([4, 3])).false;
            expect(isGameFinished([10, 11])).false;

            expect(isGameFinished([3, 5])).true;
            expect(isGameFinished([5, 3])).true;
            expect(isGameFinished([11, 9])).true

        });
        
    });

    describe('formatScore', () => {
        const equalScores = [
            [0, 0, "Love-All"],
            [1, 1, "Fifteen-All"],
            [2, 2, "Thirty-All"],
            [3, 3, "Deuce"],
            [4, 4, "Deuce"],
        ];

        equalScores.forEach(([p1, p2, result]) => {
            it('equal scores', () => {
                let score: Score = [p1, p2] as Score;
                expect(formatScore(score)).equal(result)
            });
        });

        const pointScores = [
            [1, 0, "Fifteen-Love"],
            [0, 1, "Love-Fifteen"],
            [2, 0, "Thirty-Love"],
            [0, 2, "Love-Thirty"],
            [3, 0, "Forty-Love"],
            [0, 3, "Love-Forty"],

            [2, 1, "Thirty-Fifteen"],
            [1, 2, "Fifteen-Thirty"],
            [3, 1, "Forty-Fifteen"],
            [1, 3, "Fifteen-Forty"],

            [3, 2, "Forty-Thirty"],
            [2, 3, "Thirty-Forty"],
        ];
        pointScores.forEach(([p1, p2, result]) => {
            it('point scores', () => {
                let score: Score = [p1, p2] as Score;
                expect(formatScore(score)).equal(result)
            });
        });

        const endOfGame = [
            [4, 0, "Win for player1"],
            [0, 4, "Win for player2"],

            [4, 1, "Win for player1"],
            [1, 4, "Win for player2"],

            [4, 2, "Win for player1"],
            [2, 4, "Win for player2"],

            [4, 3, "Advantage player1"],
            [3, 4, "Advantage player2"],
            [5, 4, "Advantage player1"],
            [4, 5, "Advantage player2"],
            [15, 14, "Advantage player1"],
            [14, 15, "Advantage player2"],

            [6, 4, "Win for player1"],
            [4, 6, "Win for player2"],
            [16, 14, "Win for player1"],
            [14, 16, "Win for player2"]
        ];

        endOfGame.forEach(([p1, p2, result]) => {
            it('end of game', () => {
                let score: Score = [p1, p2] as Score;
                expect(formatScore(score)).equal(result)
            });
        });
    });
});