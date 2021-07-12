package BarOOP;

public class Grade {
    private final String profession;
    private final int score;

    public Grade(int score, String profession) {
        this.score = score;
        this.profession = profession;
    }

    public String getProfession() {
        return profession;
    }

    public int getScore() {
        return score;
    }

}
