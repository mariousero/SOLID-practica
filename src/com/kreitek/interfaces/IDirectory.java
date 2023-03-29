package com.kreitek.interfaces;

import com.kreitek.files.FileSystemItemBase;

import java.util.List;

public interface IDirectory {
    List<FileSystemItemBase> listFiles();
    void addFile(FileSystemItemBase file);
    void removeFile(FileSystemItemBase file);
    String getFullPath();
}
