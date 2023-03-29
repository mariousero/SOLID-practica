package com.kreitek.utils;

import com.kreitek.files.Directory;
import com.kreitek.files.File;
import com.kreitek.files.FileSystemItemBase;
import com.kreitek.interfaces.*;
import com.kreitek.service.FileManager;

public class FileSystemPrinter {

    private final FileManager fileManager;

    public FileSystemPrinter() {
        this.fileManager = new FileManager();
    }

    public static void print(FileSystemItemBase root, int nivel) {
        String indentation = "\t".repeat(nivel);
        String message = String.format("%s%s = %d bytes", indentation, root.getFullPath(), root.getSize());
        System.out.println(message);

        if (root instanceof Directory) {
            Directory directory = new Directory(root.getParent(), root.getName());
            for (FileSystemItemBase subitem:  ((Directory) root).listFiles()) {
                FileSystemPrinter.print(subitem, nivel + 1);
            }
        }

    }

}
