package ru.gb.lesson1;

/*
*1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
*   Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
*2. Создайте два класса: беговая дорожка и стена, при прохождении через которые,
*   участники должны выполнять соответствующие действия (бежать или прыгать),
*   результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
*3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
*4. У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
*   Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.
* */


import java.util.ArrayList;

public class Race {

    public static void main(String[] args) {

        ArrayList<Barrier> barrier = createSampleRace();

        ArrayList<Participant> participants = new ArrayList<>();
        participants.add(new Participant(new Cat("Tom", 10,500)));
        participants.add(new Participant(new Human("Peter", 4, 5000)));
        participants.add(new Participant(new Robot("Rob", 3, 1000)));
        participants.add(new Participant(new Robot("Bender", 20, 1000)));

        for (int i = 0; i < participants.size(); i++) {
            boolean isFinish = true;
            for (int j = 0; j < barrier.size(); j++) {
                if(!barrier.get(j).tryBarrier(participants.get(i))) {
                    System.out.println(participants.get(i).getName() + " failed on the barier number "+ (j+1));
                    isFinish = false;
                    break;
                };
            }
            if (isFinish) System.out.println(participants.get(i).getName() + " has finished");
        }

    }

    public static ArrayList<Barrier> createSampleRace () {
        ArrayList<Barrier> barrier = new ArrayList<>();
        barrier.add(new Barrier(new Treadmill(Difficulty.LOW)));
        barrier.add(new Barrier(new Wall(Difficulty.LOW)));
        barrier.add(new Barrier(new Treadmill(Difficulty.MEDIUM)));
        barrier.add(new Barrier(new Wall(Difficulty.MEDIUM)));
        barrier.add(new Barrier(new Wall(Difficulty.HARD)));
        barrier.add(new Barrier(new Treadmill(Difficulty.HARD)));

        return barrier;
    }

    static class Participant implements Jumping, Running{
        private String name;
        private int maxJump;
        private int maxRun;

        private TypeOfParticipant type;

        private Cat cat;
        private Human human;
        private Robot robot;

        public Participant (Cat cat) {
            this.cat = cat;
            this.name = cat.getName();
            this.maxJump = cat.getMaxJump();
            this.maxRun = cat.getMaxRun();
            type = TypeOfParticipant.CAT;
        }

        public Participant (Human human) {
            this.human = human;
            this.name = human.getName();
            this.maxJump = human.getMaxJump();
            this.maxRun = human.getMaxRun();
            type = TypeOfParticipant.HUMAN;
        }

        public Participant (Robot robot) {
            this.robot = robot;
            this.name = robot.getName();
            this.maxJump = robot.getMaxJump();
            this.maxRun = robot.getMaxRun();
            type = TypeOfParticipant.ROBOT;
        }

        public String getName (){
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
            switch (type) {
                case CAT:
                    cat.jump();
                    break;
                case HUMAN:
                    human.jump();
                    break;
                case ROBOT:
                    robot.jump();
                    break;
            }
        }

        @Override
        public void run() {
            switch (type) {
                case CAT:
                    cat.run();
                    break;
                case HUMAN:
                    human.run();
                    break;
                case ROBOT:
                    robot.run();
                    break;
            }
        }
    }

    static class Barrier {
        private Wall wall;
        private Treadmill treadmill;
        private TypeOfBarrier type;

        public Barrier (Wall wall){
            this.wall = wall;
            type = TypeOfBarrier.WALL;
        }

        public Barrier (Treadmill treadmill){
            this.treadmill = treadmill;
            type = TypeOfBarrier.TREADMILL;
        }

        public boolean tryBarrier (Participant participant){
            boolean isDone = false;
            switch (type){
                case WALL:
                    participant.jump();
                    isDone = wall.isAchieved(participant);
                    wall.getResult(isDone);
                    break;

                case TREADMILL:
                    participant.run();
                    isDone = treadmill.isAchieved(participant);
                    treadmill.getResult(isDone);
                    break;
            }
            return isDone;
        }

    }

    enum TypeOfParticipant{
        CAT, HUMAN, ROBOT
    }

    enum TypeOfBarrier {
        WALL, TREADMILL
    }


}
