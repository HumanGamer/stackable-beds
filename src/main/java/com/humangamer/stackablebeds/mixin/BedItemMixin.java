package com.humangamer.stackablebeds.mixin;

import com.humangamer.stackablebeds.util.ItemStackLimit;
import net.minecraft.block.Block;
import net.minecraft.item.BedItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BedItem.class)
public abstract class BedItemMixin extends BlockItem implements ItemStackLimit {

	public BedItemMixin(Block block, Settings settings)
	{
		super(block, settings);
	}

	@Override
	public int getItemStackLimit(ItemStack stack) {
		return 64;
	}
}
