package ru.gb.lesson1;

public class Robot implements Jumping, Running{
    private String name;
    private int maxJump;
    private int maxRun;

    public Robot (String name, int maxJump, int maxRun){
        this.name = name;
        this.maxJump = maxJump;
        this.maxRun = maxRun;
    }

    public String getName() {
        return name;
    }

    public int getMaxJump() {
        return maxJump;
    }

    public int getMaxRun() {
        return maxRun;
    }

    @Override
    public void jump() {
        System.out.println(name + " jump");
    }

    @Override
    public void run() {
        System.out.println(name + " run");
    }

}
