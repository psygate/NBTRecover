package org.psygate.minecraft.internals.nbt;

/**
 * Copyright Mojang AB.
 *
 * Don't do evil.
 */
import java.io.*;

public class NBTagByte extends NBTag {

    public byte data;

    public NBTagByte(String name) {
        super(name, NBTagType.Byte);
    }

    public NBTagByte(String name, byte data) {
        super(name, NBTagType.Byte);
        this.data = data;
    }

    @Override
    protected void writeTag(DataOutput dos) throws IOException {
        dos.writeByte(data);
    }

    @Override
    protected void loadTag(DataInput dis) throws IOException {
        data = dis.readByte();
    }

    @Override
    public String toString() {
        return "b" + data;
    }

    @Override
    public NBTag copy() {
        return new NBTagByte(getName(), data);
    }
}
