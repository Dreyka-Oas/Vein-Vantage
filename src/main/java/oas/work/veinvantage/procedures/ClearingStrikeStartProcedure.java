package oas.work.veinvantage.procedures;

import oas.work.veinvantage.VeinVantageMod;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

import java.util.HashSet;
import java.util.Set;

@EventBusSubscriber
public class ClearingStrikeStartProcedure {
    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        execute(event.getLevel(), event.getPos(), event.getState(), event.getPlayer());
    }

    public static void execute(LevelAccessor world, BlockPos origin, BlockState blockstate, Entity entity) {
        if (!(entity instanceof Player player)) return;

        // Récupère le niveau de l'enchantement
        int enchantmentLevel = player.getMainHandItem().getEnchantmentLevel(
            world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT)
            .getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("vein_vantage:clearing_strike"))));
        if (enchantmentLevel == 0) return;

        // Profondeur de minage en fonction du niveau d’enchantement
        int depth = enchantmentLevel;

        // Vérification de la direction verticale (haut ou bas) en fonction du pitch
        Direction facing;
        float pitch = player.getXRot(); // pitch du joueur
        if (pitch <= -60) {
            facing = Direction.UP;  // Si le joueur regarde fortement vers le haut
        } else if (pitch >= 60) {
            facing = Direction.DOWN; // Si le joueur regarde fortement vers le bas
        } else {
            facing = player.getDirection(); // Sinon, on utilise la direction horizontale normale
        }

        // Récupère les positions des blocs dans la zone
        Set<BlockPos> blocksToDestroy = getSurroundingBlocks(origin, blockstate, facing, depth, world);

        // Casse chaque bloc dans la zone définie
        for (BlockPos pos : blocksToDestroy) {
            world.destroyBlock(pos, true); // `true` pour dropper les items
        }
    }

    private static Set<BlockPos> getSurroundingBlocks(BlockPos origin, BlockState blockstate, Direction facing, int depth, LevelAccessor world) {
        Set<BlockPos> positions = new HashSet<>();

        // Basé sur la direction du joueur, on détermine l'axe de propagation pour créer un 3x3
        if (facing == Direction.UP || facing == Direction.DOWN) {
            // Si le joueur regarde vers le haut ou le bas, on casse dans le plan XY
            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    for (int d = 0; d < depth; d++) {
                        BlockPos targetPos = (facing == Direction.UP) 
                                ? origin.offset(x, d, y)  // Pour "UP", on se propage en augmentant Y
                                : origin.offset(x, -d, y); // Pour "DOWN", on se propage en diminuant Y

                        // Vérifier si le bloc autour est du même type que le bloc cassé
                        if (world.getBlockState(targetPos).equals(blockstate)) {
                            positions.add(targetPos);
                        }
                    }
                }
            }
        } else {
            // Si le joueur regarde dans une direction horizontale, on casse dans le plan XZ
            for (int i = -1; i <= 1; i++) { // Boucle sur le 3x3
                for (int j = -1; j <= 1; j++) {
                    for (int d = 0; d < depth; d++) {
                        BlockPos targetPos;

                        switch (facing) {
                            // Horizontal - Nord/Sud
                            case NORTH -> targetPos = origin.offset(i, j, -d);
                            case SOUTH -> targetPos = origin.offset(i, j, d);
                            // Horizontal - Est/Ouest
                            case EAST -> targetPos = origin.offset(d, i, j);
                            case WEST -> targetPos = origin.offset(-d, i, j);
                            default -> throw new IllegalStateException("Unexpected value: " + facing);
                        }

                        // Vérifier si le bloc autour est du même type que le bloc cassé
                        if (world.getBlockState(targetPos).equals(blockstate)) {
                            positions.add(targetPos);
                        }
                    }
                }
            }
        }

        return positions;
    }
}
