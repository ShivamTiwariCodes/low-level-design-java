package designpatterns.compositeDesignPattern;


/***
 * To form tree like structure
 */
public class CompositeDesignPatternDemo {

    public void run() {

        FileSystem file1 = new File("file 1");
        FileSystem file2 = new File("file 2");
        FileSystem file3 = new File("file 3");
        FileSystem file4 = new File("file 4");
        FileSystem dir1 = new Directory("Directory 1");
        FileSystem dir2 = new Directory("Directory 2");
        FileSystem dir3 = new Directory("Directory 3");
        FileSystem dir4 = new Directory("Directory 4");

        ((Directory)dir1).addItem(file1);
        ((Directory)dir2).addItem(file2);
        ((Directory)dir2).addItem(dir1);
        ((Directory)dir3).addItem(file3);
        ((Directory)dir4).addItem(file4);
        ((Directory)dir4).addItem(dir2);
        ((Directory)dir4).addItem(dir3);
        dir4.ls();
    }

}
