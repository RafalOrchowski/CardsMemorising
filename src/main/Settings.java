package main;


public class Settings {
    private int timeRemember, timeConcentration;
    private boolean clubs, hearts, diamonds, spades;

    public void setTimeRemember(int timeRemember) {
        this.timeRemember = timeRemember;
    }

    public void setTimeConcentration(int timeConcentration) {
        this.timeConcentration = timeConcentration;
    }

    public int getTimeRemember() {
        return timeRemember;
    }

    public int getTimeConcentration() {
        return timeConcentration;
    }

    public boolean getClubs() {
        return clubs;
    }

    public void setClubs(boolean clubs) {
        this.clubs = clubs;
    }

    public boolean getHearts() {
        return hearts;
    }

    public void setHearts(boolean hearts) {
        this.hearts = hearts;
    }

    public boolean getDiamonds() {
        return diamonds;
    }

    public void setDiamonds(boolean diamonds) {
        this.diamonds = diamonds;
    }

    public boolean getSpades() {
        return spades;
    }

    public void setSpades(boolean spades) {
        this.spades = spades;
    }
}
