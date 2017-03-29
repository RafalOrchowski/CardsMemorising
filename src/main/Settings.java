package main;


public class Settings {
    private static int timeRemember, timeConcentration;
    private static boolean clubs, hearts, diamonds, spades;

    public void setTimeRemember(int timeRemember) {
        this.timeRemember = timeRemember;
    }

    public void setTimeConcentration(int timeConcentration) {
        this.timeConcentration = timeConcentration;
    }

    public static int getTimeRemember() {
        return timeRemember;
    }

    public static int getTimeConcentration() {
        return timeConcentration;
    }

    public static boolean getClubs() {
        return clubs;
    }

    public void setClubs(boolean clubs) {
        this.clubs = clubs;
    }

    public static boolean getHearts() {
        return hearts;
    }

    public void setHearts(boolean hearts) {
        this.hearts = hearts;
    }

    public static boolean getDiamonds() {
        return diamonds;
    }

    public void setDiamonds(boolean diamonds) {
        this.diamonds = diamonds;
    }

    public static boolean getSpades() {
        return spades;
    }

    public void setSpades(boolean spades) {
        this.spades = spades;
    }


}
