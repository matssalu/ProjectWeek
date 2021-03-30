package gui.Speler;

import java.util.Objects;

public class Speler {
    private String naam;
    private int score;

    public Speler(String naam, int score){
        if(naam == null || naam.trim().isEmpty())throw new DomainException("Error");
        if(naam.contains(" "))throw new DomainException("error");
        if(naam.trim().isEmpty())throw new IllegalArgumentException();
        if(score < 0)throw new IllegalArgumentException();
        this.naam = naam;
        this.score = score;
    }

    public Speler(String naam) {
        if(naam == null || naam.trim().isEmpty())throw new DomainException("Error");
        this.naam = naam;
    }


    public String getNaam() { return naam; }
    public int getScore() { return score; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speler speler = (Speler) o;
        return score == speler.score && Objects.equals(naam, speler.naam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam, score);
    }

    @Override
    public String toString() {
        return this.naam + " heeft als score: " + this.score;
    }

    public int Score(){
        score = 0;
        return score;
    }

    public void addToScore(int positiveScore) {
        if(this.score + positiveScore < 0) throw new DomainException("score negatief");
        this.score = this.score + positiveScore;
    }
}

