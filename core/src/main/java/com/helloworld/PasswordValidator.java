package com.helloworld;

public interface PasswordValidator {
    final static char START_CHAR_LOWER = 'a';
    final static char END_CHAR_LOWER = 'z';
    final static char START_CHAR_UPPER = 'A';
    final static char END_CHAR_UPPER = 'Z';
    final static char START_NUMBERS = '0';
    final static char END_NUMBERS = '9';
    final static String SYMBOLS = "_-!+-?.,{}[]";

    final static int SCORE_THRESHOLD = 8;


    public boolean isValid(int strength);

    public int calcPasswordStrength(String password);

    public int punctuateLength(String password);

    public int checkSymbolInclusion(String password);

    public int checkAllConditionsMet();
}
