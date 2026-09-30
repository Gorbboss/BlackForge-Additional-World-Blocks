package net.mcreator.evenbetternether.block;
import net.minecraft.util.StringRepresentable;
public enum ImportedLilyPart implements StringRepresentable {
    BOTTOM_LEFT("bottom_left"), TOP_LEFT("top_left"), TOP_RIGHT("top_right"), BOTTOM_RIGHT("bottom_right");
    private final String name;
    ImportedLilyPart(String name) { this.name = name; }
    @Override public String getSerializedName() { return name; }
}
