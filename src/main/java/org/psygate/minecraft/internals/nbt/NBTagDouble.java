package org.psygate.minecraft.internals.nbt;

import java.io.*;

public class NBTagDouble extends NBTag {

    public double data;

    public NBTagDouble(String name) {
        super(name, NBTagType.Double);
    }

    public NBTagDouble(String name, double data) {
        super(name, NBTagType.Double);
        this.data = data;
    }

    @Override
    protected void writeTag(DataOutput dos) throws IOException {
        dos.writeDouble(data);
    }

    @Override
    protected void loadTag(DataInput dis) throws IOException {
        data = dis.readDouble();
    }

    @Override
    public String toString() {
        return "d" + data;
    }

    @Override
    public NBTag copy() {
        return new NBTagDouble(getName(), data);
    }
}
