package net.gegy1000.spleef.game.map;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

public final class SpleefMapConfig {
    public static final Codec<SpleefMapConfig> CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(
                Codec.INT.fieldOf("radius").forGetter(config -> config.radius),
                Codec.INT.fieldOf("levels").forGetter(config -> config.levels),
                Codec.INT.fieldOf("level_height").forGetter(map -> map.levelHeight),
                BlockState.CODEC.optionalFieldOf("wall", Blocks.STONE_BRICKS.getDefaultState()).forGetter(config -> config.wall),
                BlockState.CODEC.optionalFieldOf("floor", Blocks.SNOW_BLOCK.getDefaultState()).forGetter(config -> config.floor)
        ).apply(instance, SpleefMapConfig::new);
    });

    public final int radius;
    public final int levels;
    public final int levelHeight;
    public final BlockState wall;
    public final BlockState floor;

    public SpleefMapConfig(int radius, int levels, int levelHeight, BlockState wall, BlockState floor) {
        this.radius = radius;
        this.levels = levels;
        this.levelHeight = levelHeight;
        this.wall = wall;
        this.floor = floor;
    }
}
