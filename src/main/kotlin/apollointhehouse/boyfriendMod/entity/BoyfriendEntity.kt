package apollointhehouse.boyfriendMod.entity

import net.minecraft.client.Minecraft
import net.minecraft.src.*


class BoyfriendEntity(world: World) : EntityMob(world) {
    private val mc: Minecraft = Minecraft.getMinecraft()
    private val player: EntityPlayer = mc.thePlayer
    private val world = mc.theWorld
    private var owner = ""
    private var stay = false

    init {
        super.worldObj
        texture = "/assets/boyfriendMod/entity/boyfriend.png"
    }

    override fun getDropItemId(): Int {
        return Item.foodPorkchopRaw.itemID
    }

    override fun dropFewItems() {
        val i = this.dropItemId
        if (i > 0) dropItem(i, 2)
    }

    override fun findPlayerToAttack(): Entity? {
        return null
    }

    private fun pathTo(target: Entity?, maxDistance: Float) {
        setPathToEntity(world.getPathToEntity(this, target, maxDistance))
    }

    override fun onLivingUpdate() {
        super.onLivingUpdate()
        if (owner == "") return

        return when {
            stay -> setPathToEntity(null as PathEntity?)
            getDistanceToEntity(player) > 5 -> pathTo(player, 16.0F)
            else -> return
        }
    }

    override fun interact(entityplayer: EntityPlayer): Boolean {
        val inventory = player.inventory
        val currentItem = inventory.currentItem
        val itemStack = inventory.getCurrentItem()

        if (owner != "") {
            stay = !stay
            return true
        }

        if (itemStack == null) {
            println("Item stack is null")
            return false
        }

        if (itemStack.stackSize < 1) {
            println("Stack size is ${itemStack.stackSize} is less than one")
            return false
        }

        if (itemStack.itemID != Item.cherry.itemID) {
            println("Item is not cherry")
            return false
        }

        println("Used one cherry")

        itemStack.consumeItem(entityplayer)
        if (itemStack.stackSize < 1) inventory.setInventorySlotContents(currentItem, null)

        owner = player.username

        return true
    }
}
