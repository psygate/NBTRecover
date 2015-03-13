package org.psygate.minecraft.internals.nbt;

import java.io.*;
import java.util.Objects;

public abstract class NBTag {

    private String name;
    private final NBTagType type;

    protected NBTag(String name, NBTagType type) {
        setName(name);

        this.type = type;
    }

    public NBTagType getType() {
        return type;
    }
    
    public final NBTag setName(String name) {
        if (name == null) {
            this.name = "";
        } else {
            this.name = name;
        }
        return this;
    }

    public String getName() {
        if (name == null) {
            return "";
        }
        return name;
    }

    public void writePreamble(DataOutput out) throws IOException {
        out.write(getType().TYPE_BYTE);

        if (getType() != NBTagType.End) {
            out.writeUTF(getName());
            writeTag(out);
        }
    }

    protected abstract void loadTag(DataInput in) throws IOException;

    protected abstract void writeTag(DataOutput out) throws IOException;

    public abstract NBTag copy();

}
