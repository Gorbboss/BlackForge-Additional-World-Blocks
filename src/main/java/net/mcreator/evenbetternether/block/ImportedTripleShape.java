package net.mcreator.evenbetternether.block;

import net.minecraft.util.StringRepresentable;

public enum ImportedTripleShape implements StringRepresentable {
    TOP("top"), MIDDLE("middle"), BOTTOM("bottom");
    private final String name;
    ImportedTripleShape(String name) { this.name = name; }
    @Override public String getSerializedName() { return name; }
}
