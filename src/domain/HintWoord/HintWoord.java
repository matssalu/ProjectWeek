package domain.HintWoord;

import domain.HintLetter.HintLetter;

public class HintWoord {
    private HintLetter[] hintwoord;

    public HintWoord(String woord) {
        if (woord == null || woord.isEmpty()) throw new DomainException("Woord mag niet leeg zijn");

        hintwoord = new HintLetter[woord.length()];
        int i = 0;
        for (char c : woord.toCharArray()) {
            hintwoord[i] = new HintLetter(c);
            i++;
        }
    }

    public String getWoord() {
        String woord = "";
        for (HintLetter l : hintwoord){
            woord += l.getLetter();
        }
        return woord;
    }

    public boolean isGeraden() {
        for (HintLetter l : hintwoord) {
            if (!l.isGeraden()) {
                return false;
            }
        }
        return true;
    }

    public boolean isLetterAanwezig(char letter) {
        for (HintLetter l : hintwoord) {
            if (l.raad(letter)) {
                return true;
            }
        }
        return false;
    }

    public boolean raad(char letter) {
        if (!isLetterAanwezig(letter)) {
            return false;
        } else {
            for (HintLetter l : hintwoord) {
                l.raad(letter);
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < hintwoord.length; i++) {
            if (hintwoord[i].equals(' ')) {
                temp += "  ";
            } else {
                temp += " " + hintwoord[i].toChar();
            }
        }
        return temp.substring(1);
    }
}
