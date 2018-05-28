import {equal} from "assert";
import {formatScore, nextScoreWithFormatting, Score} from "../src/TennisLogic";
import { assert, expect } from 'chai';

describe('TennisLogic', () => {

    describe('nextScoreWithFormatting', () => {
        const equalScores = [
            [0, 0, "Love-All"],
            [1, 1, "Fifteen-All"],
            [2, 2, "Thirty-All"],
            [3, 3, "Deuce"],
            [4, 4, "Deuce"],

        ]
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
        ]
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
        ]

        equalScores.forEach(([p1, p2, result]) =>{
            it('equal scores', () => {
                let score: Score = [p1, p2] as Score;
                expect(formatScore(score)).equal(result)
            });
            
            it('point scores', () => {
                
            });
        })

        pointScores.forEach(([p1, p2, result]) =>{
            it('point scores', () => {
                let score: Score = [p1, p2] as Score;
                expect(formatScore(score)).equal(result)
            });
        });
        endOfGame.forEach(([p1, p2, result]) =>{
            it('end of game', () => {
                let score: Score = [p1, p2] as Score;
                expect(formatScore(score)).equal(result)
            });
        });
    });
});