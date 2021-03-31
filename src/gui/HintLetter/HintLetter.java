package gui.HintLetter;

public class HintLetter {
    char letter;
    boolean isGeraden;
    public HintLetter(char letter) {
        this.letter = letter;
    }

    public boolean isGeraden() {
        return isGeraden;
    }

    public boolean raad(char x) {
        letter = java.lang.Character.toLowerCase(letter);
        if (this.letter==letter && !isGeraden){
            isGeraden = true;
            return true;
        }
        return false;
    }

    public char toChar() {
        return isGeraden ? letter : '_';
    }
    

    public char getLetter() {
        return letter;
    }
}
