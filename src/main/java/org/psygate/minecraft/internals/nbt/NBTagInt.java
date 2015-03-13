package org.psygate.minecraft.internals.nbt;

import java.io.*;

public class NBTagInt extends NBTag {

    public int data;

    public NBTagInt(String name) {
        super(name, NBTagType.Int);
    }

    public NBTagInt(String name, int data) {
        super(name, NBTagType.Int);
        this.data = data;
    }

    @Override
    protected void writeTag(DataOutput dos) throws IOException {
        dos.writeInt(data);
    }

    @Override
    protected void loadTag(DataInput dis) throws IOException {
        data = dis.readInt();
    }

    @Override
    public String toString() {
        return "i" + data;
    }

    @Override
    public NBTag copy() {
        return new NBTagInt(getName(), data);
    }

}
