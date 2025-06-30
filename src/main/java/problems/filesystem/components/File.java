package problems.filesystem.components;

public class File extends FileSystemComponent {


    public File(String name, Directory parent) {
        super(name, parent);
    }

    @Override
    public void ls() {
        System.out.println(getName());
    }
}
