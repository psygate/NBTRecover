package org.psygate.minecraft.internals.nbt;

import java.io.*;

public class NBTagByteArray extends NBTag {

    public byte[] data;

    public NBTagByteArray(String name) {
        super(name, NBTagType.ByteArray);
    }

    public NBTagByteArray(String name, byte[] data) {
        super(name, NBTagType.ByteArray);
        this.data = data;
    }

    protected void writeTag(DataOutput dos) throws IOException {
        dos.writeInt(data.length);
        dos.write(data);
    }

    protected void loadTag(DataInput dis) throws IOException {
        int length = dis.readInt();
        data = new byte[length];
        dis.readFully(data);
    }

    @Override
    public String toString() {
        return "[" + data.length + " bytes]";
    }

    @Override
    public NBTag copy() {
        byte[] cp = new byte[data.length];
        System.arraycopy(data, 0, cp, 0, data.length);
        return new NBTagByteArray(getName(), cp);
    }
}
