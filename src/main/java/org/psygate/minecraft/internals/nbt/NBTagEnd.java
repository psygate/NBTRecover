package org.psygate.minecraft.internals.nbt;

import java.io.*;

public class NBTagEnd extends NBTag {

    public NBTagEnd() {
        super(null, NBTagType.End);
    }

    @Override
    protected void loadTag(DataInput dis) throws IOException {
    }

    @Override
    protected void writeTag(DataOutput dos) throws IOException {
        throw new IllegalStateException();
    }

    @Override
    public String toString() {
        return "END_TAG";
    }

    @Override
    public NBTag copy() {
        return new NBTagEnd();
    }
}
