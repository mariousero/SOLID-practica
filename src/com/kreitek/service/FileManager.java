package com.kreitek.service;

import com.kreitek.files.Directory;
import com.kreitek.files.File;
import com.kreitek.files.error.InvalidFileFormatException;
import com.kreitek.interfaces.*;

import java.util.List;

public class FileManager {
    public static IFileSystemItem convertMp3ToWav(File archivo) {
        if (!"mp3".equalsIgnoreCase(archivo.getExtension())) {
            throw new InvalidFileFormatException("El fichero debe ser mp3");
        }

        int indexOfLastDot = archivo.getName().lastIndexOf(".");
        String nameWithoutExtension = archivo.getName();
        if (indexOfLastDot > 0) {
            nameWithoutExtension = archivo.getName().substring(0, indexOfLastDot);
        }
        String newFileName = nameWithoutExtension + ".wav";
        File result = new File(archivo.getParent(), newFileName);
        result.open();
        // Lógica de conversión de mp3 a wav. Se lee de este fichero y se escribe en result
        result.close();
        return result;
    }

    public static IFileSystemItem convertWavToMp3(File archivo) {
        if (!"wav".equalsIgnoreCase(archivo.getExtension())) {
            throw new InvalidFileFormatException("El fichero debe ser wav");
        }

        int indexOfLastDot = archivo.getName().lastIndexOf(".");
        String nameWithoutExtension = archivo.getName();
        if (indexOfLastDot > 0) {
            nameWithoutExtension = archivo.getName().substring(0, indexOfLastDot);
        }
        String newFileName = nameWithoutExtension + ".mp3";
        File result = new File(archivo.getParent(), newFileName);
        result.open();
        // Lógica de conversión de wav a mp3. Se lee de este fichero y se escribe en result
        result.close();
        return result;
    }

    // Aquí habría otros métodos para gestionar ficheros y directorios:
    // Crear ficheros, mover ficheros, eliminar ficheros, etc.
}
