package domain.HintLetter;

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
        char temp = Character.toLowerCase(x);
        char temp2 = Character.toLowerCase(letter);
        if(temp2 == temp && this.isGeraden == false){
            this.isGeraden = true;
            return true;
        }
        return false;
    }

    public char getLetter() {
        return letter;
    }


    public char toChar() {
        return isGeraden ? letter : '_';
    }
    

}
