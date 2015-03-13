package org.psygate.minecraft.internals.nbt;

import java.io.*;

public class NBTagIntArray extends NBTag {

    public int[] data;

    public NBTagIntArray(String name) {
        super(name, NBTagType.IntArray);
    }

    public NBTagIntArray(String name, int[] data) {
        super(name, NBTagType.IntArray);
        this.data = data;
    }

    @Override
    protected void writeTag(DataOutput dos) throws IOException {
        dos.writeInt(data.length);
        for (int i = 0; i < data.length; i++) {
            dos.writeInt(data[i]);
        }
    }

    @Override
    protected void loadTag(DataInput dis) throws IOException {
        int length = dis.readInt();
        data = new int[length];
        for (int i = 0; i < length; i++) {
            data[i] = dis.readInt();
        }
    }

    @Override
    public String toString() {
        return "[" + data.length + " ints]";
    }

    @Override
    public NBTag copy() {
        int[] cp = new int[data.length];
        System.arraycopy(data, 0, cp, 0, data.length);
        return new NBTagIntArray(getName(), cp);
    }
}
