package org.psygate.minecraft.internals.nbt;

import java.io.*;

public class NBTagLong extends NBTag {

    public long data;

    public NBTagLong(String name) {
        super(name, NBTagType.Long);
    }

    public NBTagLong(String name, long data) {
        super(name, NBTagType.Long);
        this.data = data;
    }

    @Override
    protected void writeTag(DataOutput dos) throws IOException {
        dos.writeLong(data);
    }

    @Override
    protected void loadTag(DataInput dis) throws IOException {
        data = dis.readLong();
    }

    @Override
    public String toString() {
        return "l" + data;
    }

    @Override
    public NBTag copy() {
        return new NBTagLong(getName(), data);
    }

}
