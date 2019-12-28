package com.groupOne.model;

public class Result {
    int stepNumber;
    String guessNumber;
    int strikeNumber;
    int hitNumber;
    int missNumber;

    public Result(int stepNumber, String guessNumber, int strikeNumber, int hitNumber, int missNumber) {
        this.stepNumber = stepNumber;
        this.guessNumber = guessNumber;
        this.strikeNumber = strikeNumber;
        this.hitNumber = hitNumber;
        this.missNumber = missNumber;
    }


    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getGuessNumber() {
        return guessNumber;
    }

    public void setGuessNumber(String guessNumber) {
        this.guessNumber = guessNumber;
    }

    public int getStrikeNumber() {
        return strikeNumber;
    }

    public void setStrikeNumber(int strikeNumber) {
        this.strikeNumber = strikeNumber;
    }

    public int getHitNumber() {
        return hitNumber;
    }

    public void setHitNumber(int hitNumber) {
        this.hitNumber = hitNumber;
    }

    public int getMissNumber() {
        return missNumber;
    }

    public void setMissNumber(int missNumber) {
        this.missNumber = missNumber;
    }
}
