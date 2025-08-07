package designpatterns.compositeDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem{

    private String directoryName;
    private List<FileSystem> list;

    public Directory(String directoryName) {
        this.directoryName = directoryName;
        list = new ArrayList<>();
    }

    public void ls() {
        System.out.println("Directory : " + directoryName);
        for(FileSystem item: list) {
            item.ls();
        }
    }

    public void addItem(FileSystem item) {
        list.add(item);
    }
}
