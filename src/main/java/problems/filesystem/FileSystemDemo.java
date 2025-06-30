package problems.filesystem;

import problems.filesystem.components.Directory;

public class FileSystemDemo {

//    support commands : ls, cd .., cd path, mkdir, touch fileName, pwd

    public static void run() {

        FileSystem fileSystem = FileSystem.getInstance();

        Directory base = fileSystem.getBase();

        System.out.println("Creating folders in base...");
        fileSystem.mkdir("users");
        fileSystem.mkdir("tmp");
        fileSystem.mkdir("var");

        fileSystem.ls(); // Should show: users, tmp, var

        // Navigate into /users
        Directory users = fileSystem.cd(base, "users");
        fileSystem.pwd(users); // /base/users

        System.out.println("\nCreating user directories...");
        fileSystem.mkdir(users, "alice");
        fileSystem.mkdir(users, "bob");
        fileSystem.mkdir(users, "eve");

        fileSystem.ls(users); // Should show: alice, bob, eve

        // Navigate into /users/alice
        Directory alice = fileSystem.cd(users, "alice");
        fileSystem.pwd(alice); // /base/users/alice

        System.out.println("\nCreating files in alice...");
        fileSystem.touch(alice, "doc.txt");
        fileSystem.touch(alice, "photo.png");

        fileSystem.ls(alice); // Should show: doc.txt, photo.png

        System.out.println("\nCreating subfolder in alice...");
        fileSystem.mkdir(alice, "projects");

        Directory projects = fileSystem.cd(alice, "projects");

        fileSystem.touch(projects, "resume.pdf");
        fileSystem.touch(projects, "todo.txt");

        fileSystem.pwd(projects); // /base/users/alice/projects
        fileSystem.ls(projects); // resume.pdf, todo.txt

        // Test cd ..
        Directory backToAlice = fileSystem.cd(projects); // cd ..
        fileSystem.pwd(backToAlice); // /base/users/alice

        // Create another folder under base/tmp/logs/debug
        Directory tmp = fileSystem.cd(base, "tmp");
        fileSystem.mkdir(tmp, "logs");
        Directory logs = fileSystem.cd(tmp, "logs");
        fileSystem.mkdir(logs, "debug");

        Directory debug = fileSystem.cd(tmp, "logs/debug");

        fileSystem.touch(debug, "log1.txt");
        fileSystem.touch(debug, "log2.txt");

        System.out.println("\nListing /tmp/logs/debug...");
        fileSystem.pwd(debug); // /base/tmp/logs/debug
        fileSystem.ls(debug);  // log1.txt, log2.txt

        // Invalid cd path test
        System.out.println("\nTrying to cd to invalid path...");
        Directory invalid = fileSystem.cd(base, "not_existing_path");
        System.out.println("Invalid cd returned: " + invalid);

        // Deep structure
        System.out.println("\nCreating deep nested structure...");
        Directory current = base;
        for (int i = 1; i <= 5; i++) {
            fileSystem.mkdir(current, "level_" + i);
            current = fileSystem.cd(current, "level_" + i);
            fileSystem.touch(current, "file_at_level_" + i + ".txt");
        }
        fileSystem.pwd(current); // /base/level_1/.../level_5
        fileSystem.ls(current);  // file_at_level_5.txt
    }
}