package com.kreitek.interfaces;

public interface IFileSystemItem {
    String getName();
    void setName(String name);
    IDirectory getParent();
    void setParent(IDirectory directory);
    String getFullPath();
    int getSize();
}
