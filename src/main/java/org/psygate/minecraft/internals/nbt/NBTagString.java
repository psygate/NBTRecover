package org.psygate.minecraft.internals.nbt;

import java.io.*;

public class NBTagString extends NBTag {

    public String data;

    public NBTagString(String name) {
        super(name, NBTagType.String);
    }

    public NBTagString(String name, String data) {
        super(name, NBTagType.String);
        this.data = data;
        if (data == null) {
            throw new IllegalArgumentException("Empty string not allowed");
        }
    }

    @Override
    protected void writeTag(DataOutput dos) throws IOException {
        dos.writeUTF(data);
    }

    @Override
    protected void loadTag(DataInput dis) throws IOException {
        data = dis.readUTF();
    }

    @Override
    public String toString() {
        return "\"" + data + "\"";
    }

    @Override
    public NBTag copy() {
        return new NBTagString(getName(), data);
    }
}
