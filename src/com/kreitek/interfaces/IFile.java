package com.kreitek.interfaces;

public interface IFile {
    void open();
    void close();
    void setPosition(int numberOfBytesFromBeginning);
    byte[] read(int numberOfBytesToRead);
    String getExtension();
    void write(byte[] buffer);
}
