package org.psygate.minecraft.internals.nbt;

/**
 *
 * @author psygate
 */
public enum NBTagType {

    End(0, new NBTagEnd()),
    Byte(1, new NBTagByte(null)),
    Short(2, new NBTagShort(null)),
    Int(3, new NBTagInt(null)),
    Long(4, new NBTagLong(null)),
    Float(5, new NBTagFloat(null)),
    Double(6, new NBTagDouble(null)),
    ByteArray(7, new NBTagByteArray(null)),
    String(8, new NBTagString(null, "")),
    List(9, new NBTagList(null)),
    Compound(10, new NBTagCompound()),
    IntArray(11, new NBTagIntArray(null));

    public final int TYPE_BYTE;
    private final NBTag tag;

    private NBTagType(int type, NBTag tag) {
        this.TYPE_BYTE = type;
        this.tag = tag;
    }

    public NBTag newTag(String name) {
        NBTag out = tag.copy();
        out.setName((name == null) ? "" : name);
        return out;
    }

    public static NBTagType valueOf(int value) {
        for (NBTagType type : values()) {
            if (value == type.TYPE_BYTE) {
                return type;
            }
        }

        throw new IllegalArgumentException();
    }
}
