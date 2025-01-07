package bblsom.mixin.vanilla;

import bblsom.blocks.CustomBlockFarmland;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(targets = "net.minecraft.entity.passive.EntityRabbit$AIRaidFarm")
public abstract class EntityRabbitMixin {

	@ModifyExpressionValue(
			method = "shouldMoveTo",
			at = @At(value = "INVOKE", target = "Lnet/minecraft/block/state/IBlockState;getBlock()Lnet/minecraft/block/Block;", ordinal = 0)
	)
	private Block bblsom_vanillaEntityRabbitAIRaidFarm_shouldMoveTo(Block original) {
		if(original instanceof CustomBlockFarmland) return Blocks.FARMLAND;
		return original;
	}
}