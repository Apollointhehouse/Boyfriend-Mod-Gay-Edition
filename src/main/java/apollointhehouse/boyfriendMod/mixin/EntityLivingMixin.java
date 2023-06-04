package apollointhehouse.boyfriendMod.mixin;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityLiving.class)
public abstract class EntityLivingMixin extends Entity {

    public EntityLivingMixin(World world) {
        super(world);
    }

    @Inject(method = "onUpdate", at = @At("HEAD"), remap = false)
    @SuppressWarnings("all")
    public void onUpdate(CallbackInfo ci) {
        if (((EntityLiving) (Object) this) instanceof EntityPlayer) {

        }
    }
}
