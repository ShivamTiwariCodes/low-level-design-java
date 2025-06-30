package problems.filesystem.components;

public abstract class FileSystemComponent {

    private String name;
    private Directory parent;

     public FileSystemComponent(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public Directory getParent() {
        return parent;
    }

    public abstract void ls();
}
