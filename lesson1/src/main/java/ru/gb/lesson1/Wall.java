package ru.gb.lesson1;

public class Wall {
    private int height;

    public int getHeight(){
        return height;
    }

    public Wall(Difficulty difficulty) {
        switch (difficulty) {
            case LOW :
                this.height = 1;
                break;
            case MEDIUM:
                this.height = 3;
                break;
            case HARD:
                this.height = 5;
                break;
        }
    }

    public boolean isAchieved (Jumping participant){
        int maxHeight = 0;
        if (participant instanceof Race.Participant) maxHeight = ((Race.Participant) participant).getMaxJump();
        else if (participant instanceof Cat) maxHeight = ((Cat) participant).getMaxJump();
        else if (participant instanceof Human) maxHeight = ((Human) participant).getMaxJump();
        else if (participant instanceof Robot) maxHeight = ((Robot) participant).getMaxJump();

        return this.height <=maxHeight;
    }

    public void getResult (boolean isAchieved){
        if (isAchieved) System.out.println("Successful jump");
        else System.out.println("Failed jump");
    }


}
