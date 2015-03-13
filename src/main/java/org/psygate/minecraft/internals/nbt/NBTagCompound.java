package org.psygate.minecraft.internals.nbt;

import java.io.*;
import java.util.*;

public class NBTagCompound extends NBTag {

    private Map<String, NBTag> tags = new HashMap<String, NBTag>();

    public NBTagCompound() {
        super("", NBTagType.Compound);
    }

    public NBTagCompound(String name) {
        super(name, NBTagType.Compound);
    }

    @Override
    protected void writeTag(DataOutput dos) throws IOException {
        for (NBTag tag : tags.values()) {
            NBTagIO.writeNamedTag(tag, dos);
        }
        dos.writeByte(NBTagType.End.TYPE_BYTE);
    }

    @Override
    protected void loadTag(DataInput dis) throws IOException {
        tags.clear();
        NBTag tag;
        while ((tag = NBTagIO.readNamedTag(dis)).getType() != NBTagType.End) {
            tags.put(tag.getName(), tag);
        }
    }

    public Collection<NBTag> getAllTags() {
        return tags.values();
    }

    public void put(String name, NBTag tag) {
        tags.put(name, tag.setName(name));
    }

    public void putByte(String name, byte value) {
        tags.put(name, new NBTagByte(name, value));
    }

    public void putShort(String name, short value) {
        tags.put(name, new NBTagShort(name, value));
    }

    public void putInt(String name, int value) {
        tags.put(name, new NBTagInt(name, value));
    }

    public void putLong(String name, long value) {
        tags.put(name, new NBTagLong(name, value));
    }

    public void putFloat(String name, float value) {
        tags.put(name, new NBTagFloat(name, value));
    }

    public void putDouble(String name, double value) {
        tags.put(name, new NBTagDouble(name, value));
    }

    public void putString(String name, String value) {
        tags.put(name, new NBTagString(name, value));
    }

    public void putByteArray(String name, byte[] value) {
        tags.put(name, new NBTagByteArray(name, value));
    }

    public void putIntArray(String name, int[] value) {
        tags.put(name, new NBTagIntArray(name, value));
    }

    public void putCompound(String name, NBTagCompound value) {
        tags.put(name, value.setName(name));
    }

    public void putBoolean(String string, boolean val) {
        putByte(string, val ? (byte) 1 : 0);
    }

    public NBTag get(String name) {
        return tags.get(name);
    }

    public boolean contains(String name) {
        return tags.containsKey(name);
    }

    public byte getByte(String name) {
        if (!tags.containsKey(name)) {
            return (byte) 0;
        }
        return ((NBTagByte) tags.get(name)).data;
    }

    public short getShort(String name) {
        if (!tags.containsKey(name)) {
            return (short) 0;
        }
        return ((NBTagShort) tags.get(name)).data;
    }

    public int getInt(String name) {
        if (!tags.containsKey(name)) {
            return (int) 0;
        }

        NBTag tag = tags.get(name);

        if (tag instanceof NBTagByte) {
            return ((NBTagByte) tag).data;
        } else if (tag instanceof NBTagShort) {
            return ((NBTagShort) tag).data;
        } else if (tag instanceof NBTagInt) {
            return ((NBTagInt) tag).data;
        }

        return ((NBTagInt) tags.get(name)).data;
    }

    public long getLong(String name) {
        if (!tags.containsKey(name)) {
            return (long) 0;
        }
        return ((NBTagLong) tags.get(name)).data;
    }

    public float getFloat(String name) {
        if (!tags.containsKey(name)) {
            return (float) 0;
        }
        return ((NBTagFloat) tags.get(name)).data;
    }

    public double getDouble(String name) {
        if (!tags.containsKey(name)) {
            return (double) 0;
        }
        return ((NBTagDouble) tags.get(name)).data;
    }

    public String getString(String name) {
        if (!tags.containsKey(name)) {
            return "";
        }
        return ((NBTagString) tags.get(name)).data;
    }

    public byte[] getByteArray(String name) {
        if (!tags.containsKey(name)) {
            return new byte[0];
        }
        return ((NBTagByteArray) tags.get(name)).data;
    }

    public int[] getIntArray(String name) {
        if (!tags.containsKey(name)) {
            return new int[0];
        }
        return ((NBTagIntArray) tags.get(name)).data;
    }

    public NBTagCompound getCompound(String name) {
        if (!tags.containsKey(name)) {
            return new NBTagCompound(name);
        }
        return (NBTagCompound) tags.get(name);
    }

    public Set<String> keySet() {
        return tags.keySet();
    }

    @SuppressWarnings("unchecked")
    public NBTagList<? extends NBTag> getList(String name) {
        if (!tags.containsKey(name)) {
            return new NBTagList<NBTag>(name);
        }
        return (NBTagList<? extends NBTag>) tags.get(name);
    }

    public boolean getBoolean(String string) {
        return getByte(string) != 0;
    }

    @Override
    public String toString() {
        return getName() + ": {" + tags + "}";
    }

    public boolean isEmpty() {
        return tags.isEmpty();
    }

    @Override
    public NBTag copy() {
        NBTagCompound tag = new NBTagCompound(getName());
        for (String key : tags.keySet()) {
            tag.put(key, tags.get(key).copy());
        }
        return tag;
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            NBTagCompound o = (NBTagCompound) obj;
            return tags.entrySet().equals(o.tags.entrySet());
        }
        return false;
    }
}
