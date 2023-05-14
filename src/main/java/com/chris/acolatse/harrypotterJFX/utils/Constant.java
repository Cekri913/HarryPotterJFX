package com.chris.acolatse.harrypotterJFX.utils;

public class Constant {


    //Java console color
    public static final String RED = "\u001B[31m";
    public static final String BLACK = "\u001B[30m";
    public static final String GREEN = "\u001B[32m";
    public static final String CYAN = "\u001B[36m";
    public static final String YELLOW = "\u001B[33m";
    public static final String WHITE_TEXT = "\u001B[37m";
    public static final String ITALIC_TEXT = "\033[3m";
    public static final String BOLD_TEXT = "\033[0;1m";
    public static final String RESET_DESIGN = "\033[0;0m";


    public static final String FIVE_TAB = "\t\t\t\t\t";


    public static String customDisplayText(String custom, String text) {
        return custom + text + RESET_DESIGN;
    }
    public static String customDisplayText(String font, String text, String color) {
        return font + color + text + RESET_DESIGN;
    }

    public static String welcomeText = """                   
                                        Welcome to << Harry Potter at Home >>,\s
                                        the wizarding role-playing game.\s
                                        Do you have what it takes to become the greatest wizards ?\s\s
                                        Your goal is to complete your studies at Hogwarts.\s
                                        Each year will be filled with challenges.
                                        Can you meet all the challenges ?\s """;

}
