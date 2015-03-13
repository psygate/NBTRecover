package org.psygate.minecraft.internals.nbt;

import java.io.*;

public class NBTagFloat extends NBTag {

    public float data;

    public NBTagFloat(String name) {
        super(name, NBTagType.Float);
    }

    public NBTagFloat(String name, float data) {
        super(name, NBTagType.Float);
        this.data = data;
    }

    @Override
    protected void writeTag(DataOutput dos) throws IOException {
        dos.writeFloat(data);
    }

    @Override
    protected void loadTag(DataInput dis) throws IOException {
        data = dis.readFloat();
    }

    @Override
    public String toString() {
        return "f" + data;
    }

    @Override
    public NBTag copy() {
        return new NBTagFloat(getName(), data);
    }
}
