package ru.gb.lesson1;

public class Treadmill {
    private int length;

    public int getLength(){
        return length;
    }

    public Treadmill(Difficulty difficulty) {
        switch (difficulty) {
            case LOW :
                this.length = 10;
                break;
            case MEDIUM:
                this.length = 100;
                break;
            case HARD:
                this.length = 1000;
                break;
        }
    }

    public boolean isAchieved (Running participant){
        int maxLength = 0;
        if (participant instanceof Race.Participant) maxLength = ((Race.Participant) participant).getMaxRun();
        else if (participant instanceof Cat) maxLength = ((Cat) participant).getMaxRun();
        else if (participant instanceof Human) maxLength = ((Human) participant).getMaxRun();
        else if (participant instanceof Robot) maxLength = ((Robot) participant).getMaxRun();

        return this.length <=maxLength;
    }

    public void getResult (boolean isAchieved){
        if (isAchieved) System.out.println("Successful run");
        else System.out.println("Failed run");
    }


}
