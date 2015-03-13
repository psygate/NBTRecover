package org.psygate.minecraft.internals.nbt;

import java.io.*;
import java.util.*;

public class NBTagList<T extends NBTag> extends NBTag implements Iterable<T> {

    private List<T> list = new ArrayList<>();
    private NBTagType type;

    public NBTagList() {
        super("", NBTagType.List);
    }

    public NBTagList(String name) {
        super(name, NBTagType.List);
    }

    @Override
    protected void writeTag(DataOutput dos) throws IOException {
        if (list.size() > 0) {
            type = list.get(0).getType();
        } else {
            type = NBTagType.Byte;
        }

        dos.writeByte(type.TYPE_BYTE);
        dos.writeInt(list.size());
        for (int i = 0; i < list.size(); i++) {
            list.get(i).writeTag(dos);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void loadTag(DataInput dis) throws IOException {
        type = NBTagType.valueOf(dis.readByte());
        int size = dis.readInt();

        list = new ArrayList<T>();
        for (int i = 0; i < size; i++) {
            NBTag tag = type.newTag(null);
            tag.loadTag(dis);
            list.add((T) tag);
        }
    }

    @Override
    public String toString() {
        return list.toString();
//        return "" + list.size() + " entries of type " + Tag.getTagName(type);
    }

    public void add(T tag) {
        type = tag.getType();
        list.add(tag);
    }

    public T get(int index) {
        return list.get(index);
    }

    public int size() {
        return list.size();
    }

    @Override
    public NBTag copy() {
        NBTagList<T> res = new NBTagList<T>(getName());
        res.type = type;
        for (T t : list) {
            @SuppressWarnings("unchecked")
            T copy = (T) t.copy();
            res.list.add(copy);
        }
        return res;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

}
