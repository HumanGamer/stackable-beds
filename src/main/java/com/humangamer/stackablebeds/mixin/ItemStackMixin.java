package com.humangamer.stackablebeds.mixin;

import com.humangamer.stackablebeds.util.ItemStackLimit;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @Shadow
    public Item getItem()
    {
        return null;
    }

    @Inject(method = "getMaxCount", at = @At("HEAD"), cancellable = true)
    public void getMaxStackSizeStackSensitive(CallbackInfoReturnable<Integer> ci)
    {
        if (this.getItem() instanceof ItemStackLimit)
            ci.setReturnValue(((ItemStackLimit) this.getItem()).getItemStackLimit((ItemStack) (Object) this));
    }
}
