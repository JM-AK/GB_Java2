package ru.gb.lesson1;

public enum Difficulty {
    LOW ("Low"),
    MEDIUM ("Medium"),
    HARD ("Hard");

    private String levelName;

    public String getLevel(){
        return levelName;
    }

    Difficulty(String levelName) {
        this.levelName = levelName;
    }

}
