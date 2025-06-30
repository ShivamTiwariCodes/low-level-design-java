package problems.filesystem.components;

import java.util.HashMap;
import java.util.Map;

public class Directory extends FileSystemComponent{

    private final Map<String, FileSystemComponent> elements;

    public Directory(String name, Directory parent) {
        super(name, parent);
        this.elements = new HashMap<>();
    }

    public void addElement(FileSystemComponent element) {
        elements.put(element.getName(), element);
    }

    public Map<String, FileSystemComponent> getElements() {
        return elements;
    }

    @Override
    public void ls() {
        for(Map.Entry<String, FileSystemComponent> e: elements.entrySet()) {
            System.out.println(e.getKey());
        }
    }

    public void pwd() {
        if(getParent() != null) {
            getParent().pwd();
            System.out.print("/");
        }
        System.out.print(getName());
    }


}
