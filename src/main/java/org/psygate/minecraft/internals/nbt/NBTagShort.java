package org.psygate.minecraft.internals.nbt;

import java.io.*;

public class NBTagShort extends NBTag {

    public short data;

    public NBTagShort(String name) {
        super(name, NBTagType.Short);
    }

    public NBTagShort(String name, short data) {
        super(name, NBTagType.Short);
        this.data = data;
    }

    @Override
    protected void writeTag(DataOutput dos) throws IOException {
        dos.writeShort(data);
    }

    @Override
    protected void loadTag(DataInput dis) throws IOException {
        data = dis.readShort();
    }

    @Override
    public String toString() {
        return "s" + data;
    }

    @Override
    public NBTag copy() {
        return new NBTagShort(getName(), data);
    }
}
