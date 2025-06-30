package problems.filesystem;

import problems.filesystem.components.Directory;

public class FileSystemDemo {

//    support commands : ls, cd .., cd path, mkdir, touch fileName, pwd

    public static void run() {

        FileSystem fileSystem = FileSystem.getInstance();

        fileSystem.mkdir("folder_1");

        Directory base = fileSystem.getBase();

        Directory dir_1 = fileSystem.cd(base, "folder_1");

        fileSystem.mkdir(dir_1, "folder_1_1");
        fileSystem.mkdir(dir_1, "folder_1_2");
        fileSystem.mkdir(dir_1, "folder_1_3");

        Directory dir_1_2 = fileSystem.cd(base, "folder_1/folder_1_2");

        fileSystem.touch(dir_1_2, "file_1_2_1");

        dir_1_2.ls();
        dir_1_2.pwd();

    }
}
