package designpatterns.flyweightPattern;

public class CharacterImpl implements Character{

    private char character;
    private int size;
    private String font;
    private String color;

    public CharacterImpl(char character, int size, String font, String color) {
        this.character = character;
        this.size = size;
        this.font = font;
        this.color = color;
    }


    @Override
    public void draw(int x, int y) {
        System.out.println("Drawing character : " + character + " of size : " + size + " and color : " + color
        + " with font as : " + font + " at point : (" + x + ", " + y + ")" );
    }
}
