package com.kreitek.files;

import java.util.List;
import com.kreitek.interfaces.*;

public abstract class FileSystemItemBase implements IFileSystemItem {
    protected static final String PATH_SEPARATOR = "/";
    protected String name;
    protected IDirectory parent;

    protected FileSystemItemBase(IDirectory parent, String name) {
        setName(name);
        setParent(parent);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        }
        this.name = name;
    }

    @Override
    public IDirectory getParent() {
        return parent;
    }

    @Override
    public void setParent(IDirectory directory) {
        this.parent = directory;
    }

    @Override
    public String getFullPath() {
        String path = PATH_SEPARATOR;
        if (parent != null) {
            String parentFullPath = parent.getFullPath();
            path = parent.getFullPath() + (parentFullPath.length() > 1 ? PATH_SEPARATOR : "");
        }
        path = path + getName();
        return path;
    }


    @Override
    public abstract int getSize();

}
