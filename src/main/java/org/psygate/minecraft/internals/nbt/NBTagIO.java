package org.psygate.minecraft.internals.nbt;

import java.io.*;
import java.util.zip.*;

public class NBTagIO {

    public static NBTagCompound read(File file) {//throws IOException {
        if (!file.exists()) {
            throw new IllegalArgumentException(new FileNotFoundException("File not found " + file));
        }

        try (DataInputStream in = new DataInputStream(new GZIPInputStream(new FileInputStream(file)))) {
            return read(in);
        } catch (IOException e) {

        }

        try (DataInputStream in = new DataInputStream(new FileInputStream(file))) {
            return read(in);
        } catch (IOException e) {
        }

        throw new IllegalArgumentException("File " + file + " is not an NBTag.");
    }

    public static void write(NBTagCompound tag, File file) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
        try {
            write(tag, dos);
        } finally {
            dos.close();
        }
    }

    public static NBTagCompound read(DataInput dis) throws IOException {
        NBTag tag = readNamedTag(dis);
        if (tag instanceof NBTagCompound) {
            return (NBTagCompound) tag;
        }
        throw new IOException("Root tag must be a named compound tag");
    }

    public static void write(NBTagCompound tag, DataOutput dos) throws IOException {
        writeNamedTag(tag, dos);
    }

    protected static NBTag readNamedTag(DataInput dis) throws IOException {
        NBTagType type = NBTagType.valueOf(dis.readByte());
        if (type == NBTagType.End) {
            return new NBTagEnd();
        }

        String name = dis.readUTF();// new String(bytes, "UTF-8");

        NBTag tag = type.newTag(name);
//        short length = dis.readShort();
//        byte[] bytes = new byte[length];
//        dis.readFully(bytes);

        tag.loadTag(dis);
        return tag;
    }

    protected static void writeNamedTag(NBTag tag, DataOutput dos) throws IOException {
        dos.writeByte(tag.getType().TYPE_BYTE);
        if (tag.getType() == NBTagType.End) {
            return;
        }

//        byte[] bytes = tag.getName().getBytes("UTF-8");
//        dos.writeShort(bytes.length);
//        dos.write(bytes);
        dos.writeUTF(tag.getName());

        tag.writeTag(dos);
    }
    
}
