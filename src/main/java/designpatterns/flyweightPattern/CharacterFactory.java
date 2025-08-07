package designpatterns.flyweightPattern;

import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {

    Map<String, Character> map;

    public CharacterFactory() {
        map = new HashMap<>();
    }

    public Character getCharacter(char character, int size, String font, String color) {
        String key = character + size + font + color;
        Character character1 = map.get(key);
        if(character1 == null) {
            character1 = new CharacterImpl(character, size, font, color);
            map.put(key, character1);
        }
        return character1;
    }
}
