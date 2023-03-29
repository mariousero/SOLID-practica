package com.kreitek.files;

import java.util.ArrayList;
import com.kreitek.interfaces.*;
import java.util.List;

public class Directory extends FileSystemItemBase implements IFileSystemItem, IDirectory {

    //private static final String NO_ES_VALIDO_PARA_DIRECTORIOS = "No es válido para directorios";
    private final List<FileSystemItemBase> files;

    public Directory(IDirectory parent, String name) {
        super(parent, name);
        files = new ArrayList<>();
        // Aquí vendría lógica que rellena la lista de ficheros
    }

    @Override
    public List<FileSystemItemBase> listFiles() {
        return files;
    }

    @Override
    public void addFile(FileSystemItemBase file) {
        if (!files.contains(file)) {
            files.add(file);
            file.setParent(this);
        }
    }

    @Override
    public void removeFile(FileSystemItemBase file) {
        files.remove(file);
    }

    @Override
    public int getSize() {
        int size = 0;

        for (int i = 0; i < files.size(); i++) {
            size += files.get(i).getSize();
        }

        return size;
    }

}
