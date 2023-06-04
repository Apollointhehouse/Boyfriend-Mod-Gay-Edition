package apollointhehouse.boyfriendMod

import apollointhehouse.boyfriendMod.entity.BoyfriendEntity
import net.minecraft.src.ModelBiped
import net.minecraft.src.RenderBiped
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import turniplabs.halplibe.helper.EntityHelper

val MODID: String = "boyfriend-mod"
val LOGGER: Logger = LoggerFactory.getLogger(MODID)

@Suppress("unused")
fun init() {
    LOGGER.info("Hello Fabric world!")


    // Entity
    EntityHelper.createEntity(BoyfriendEntity::class.java, RenderBiped(ModelBiped(), 0.5F), 60, "Boyfriend")
}