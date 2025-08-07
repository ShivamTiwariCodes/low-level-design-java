package designpatterns.flyweightPattern;

public class FlyweightPatternDemo {


    public void run() {

        CharacterFactory characterFactory = new CharacterFactory();

        String sentense = "This is a sentence.";
        int size = 12;
        String color = "Black";
        String font = "Italic";
        int y=0;

        for(int i=0; i<sentense.length(); i++) {
            Character ch = characterFactory.getCharacter(sentense.charAt(i), size, font, color);
            ch.draw(i*size, y);
        }
    }
}
