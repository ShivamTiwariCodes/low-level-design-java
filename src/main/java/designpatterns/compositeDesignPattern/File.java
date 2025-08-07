package designpatterns.compositeDesignPattern;

public class File implements FileSystem{

    private String fileName;

    public File(String filenName) {
        this.fileName = filenName;
    }

    @Override
    public void ls() {
        System.out.println("File : " + fileName);
    }
}
