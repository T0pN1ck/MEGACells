package gripe._90.megacells.definition;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

import gripe._90.megacells.MEGACells;

@SuppressWarnings({"FieldCanBeLocal", "FieldMayBeFinal"})
@Config(name = MEGACells.MODID)
public final class MEGAConfig implements ConfigData {
    @ConfigEntry.Gui.Excluded
    public static MEGAConfig INSTANCE;

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 2, max = 12)
    private int CompressionChainLimit = 3;

    @ConfigEntry.Gui.Tooltip
    private boolean AllowSpentWaste = false;

    public int getCompressionChainLimit() {
        return CompressionChainLimit;
    }

    public boolean isSpentWasteAllowed() {
        return AllowSpentWaste;
    }

    public static void load() {
        if (INSTANCE != null) {
            throw new IllegalStateException("Config has already been loaded");
        }

        AutoConfig.register(MEGAConfig.class, GsonConfigSerializer::new);
        INSTANCE = AutoConfig.getConfigHolder(MEGAConfig.class).getConfig();
    }
}
