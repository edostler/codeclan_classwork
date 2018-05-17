import db.DBHelper;
import models.File;
import models.Folder;
import models.Owner;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Owner owner1 = new Owner("Ed Ostler", "eozzyostlerston");
        DBHelper.saveOrUpdate(owner1);
        Owner owner2 = new Owner("Phil Ostler", "pozzyostlerston");
        DBHelper.saveOrUpdate(owner2);

        Folder folder1 = new Folder("Homework", owner1);
        DBHelper.saveOrUpdate(folder1);
        Folder folder2 = new Folder("Music", owner2);
        DBHelper.saveOrUpdate(folder2);

        File file1 = new File("ruby_file", "rb", 323, folder1);
        DBHelper.saveOrUpdate(file1);
        File file2 = new File("JavaFile", "java", 112, folder1);
        DBHelper.saveOrUpdate(file2);
        File file3 = new File("Brand New: Lit Me Up", "mp3", 3542, folder2);
        DBHelper.saveOrUpdate(file3);
        File file4 = new File("Taking Back Sunday: Can't Look Back", "mp3", 2300, folder2);
        DBHelper.saveOrUpdate(file4);
        File file5 = new File("Busted: Year 3000", "mp3", 1450, folder2);
        DBHelper.saveOrUpdate(file5);

        DBHelper.delete(file5);

        List<Folder> folders = DBHelper.getAll(Folder.class);
        List<File> files = DBHelper.getAll(File.class);

        List<File> fileresults = DBHelper.getFilesByFolder(folder1);

        List<Folder> folderresults = DBHelper.getFoldersByOwner(owner2);

    }

}
