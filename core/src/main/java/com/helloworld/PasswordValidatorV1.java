package com.helloworld;

public class PasswordValidatorV1 implements PasswordValidator {

    private boolean letterCondition;
    private boolean minusCondition;
    private boolean mayusCondition;
    private boolean numberCondition;
    private boolean symbolsCondition;
    private boolean maxLength;

    public PasswordValidatorV1() {
        letterCondition = false;
        minusCondition = false;
        mayusCondition = false;
        numberCondition = false;
        symbolsCondition = false;
        maxLength = false;
    }

    @Override
    public boolean isValid(int strength) {
        return strength < SCORE_THRESHOLD;
    }

    @Override
    public int calcPasswordStrength(String password) {
        int score = 0;
        score += punctuateLength(password);
        score += checkSymbolInclusion(password);
        score += checkAllConditionsMet();
        return score;
    }

    @Override
    public int punctuateLength(String password) {
        int lengthScore = 0;
        int length = password.length();
        if (length >= 7 && length <= 8) lengthScore += 1;
        else if (length >= 9 && length <= 12) lengthScore += 2;
        else {
            lengthScore += 3;
            maxLength = true;
        }
        return lengthScore;
    }

    @Override
    public int checkSymbolInclusion(String password) {
        int symbolScore = 0;
        for (int pos = 0; pos < password.length(); pos++) {
            if (areAllSymbolConditionsMet()) break;

            letterInclusion(password, pos);
            letterMinusInclusion(password, pos);
            letterMayusInclusion(password, pos);
            numberInclusion(password, pos);
            symbolsInclusion(password, pos);
        }

        if (letterCondition) symbolScore += 1;
        if (mayusCondition && minusCondition) symbolScore += 2;
        if (numberCondition) symbolScore += 1;
        if (symbolsCondition) symbolScore += 2;

        return symbolScore;
    }

    private void letterInclusion(String password, int pos) {
        if (!letterCondition &&
                (password.charAt(pos) >= START_CHAR_LOWER && password.charAt(pos) <= END_CHAR_LOWER) ||
                (password.charAt(pos) >= START_CHAR_UPPER && password.charAt(pos) <= END_CHAR_UPPER))
            letterCondition = true;
    }

    private void letterMinusInclusion(String password, int pos) {
        if (!minusCondition &&
                password.charAt(pos) >= START_CHAR_LOWER && password.charAt(pos) <= END_CHAR_LOWER)
            minusCondition = true;
    }

    private void letterMayusInclusion(String password, int pos) {
        if (!mayusCondition &&
                password.charAt(pos) >= START_CHAR_UPPER && password.charAt(pos) <= END_CHAR_UPPER)
            mayusCondition = true;
    }

    private void numberInclusion(String password, int pos) {
        if (!numberCondition &&
                password.charAt(pos) >= START_NUMBERS && password.charAt(pos) <= END_NUMBERS)
            numberCondition = true;
    }

    private void symbolsInclusion(String password, int pos) {
        for (int i = 0; i < SYMBOLS.length(); i++) {
            if (symbolsCondition)
                break;

            if (password.charAt(pos) == SYMBOLS.charAt(i)) {
                symbolsCondition = true;
                break;
            }
        }
    }

    private boolean areAllSymbolConditionsMet() {
        return letterCondition
                && minusCondition
                && mayusCondition
                && numberCondition
                && symbolsCondition;
    }

    @Override
    public int checkAllConditionsMet() {
        if (maxLength
                && letterCondition
                && minusCondition
                && mayusCondition
                && numberCondition
                && symbolsCondition)
            return 1;
        return 0;
    }
}
