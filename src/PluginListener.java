
/**
 * PluginListener.java - Extend this and register it to listen to specific
 * hooks.
 * 
 * @author Maine
 */
public abstract class PluginListener {

    /**
     * Priority - Used for priority for plugin listeners
     */
    public enum Priority {

        /**
         * Highly critical for hooks that absolutely must occur before any
         * others. Use carefully.
         */
        CRITICAL,
        /**
         * May block/interrupt/undo the action, but prefer MEDIUM
         */
        HIGH,
        /**
         * Preferred priority for blocking/interrupting/undoing the action
         */
        MEDIUM,
        /**
         * Must not block/interrupt/undo the action
         */
        LOW
    }

    /**
     * Called when a player moves from one block to another
     * 
     * @param player
     *            player moving
     * @param from
     *            previous block location
     * @param to
     *            current block location
     */
    public void onPlayerMove(Player player, Location from, Location to) {
    }

    /**
     * Called when a player teleports from one location to another
     * 
     * @param player
     *            player moving
     * @param from
     *            previous block location
     * @param to
     *            current block location
     * @return false if you want the player to teleport.
     */
    public boolean onTeleport(Player player, Location from, Location to) {
        return false;
    }

    /**
     * Called during the early login process to check whether or not to kick the
     * player
     * 
     * @param user
     * @return kick reason. null if you don't want to kick the player.
     */
    public String onLoginChecks(String user) {
        return null;
    }

    /**
     * Called during the later login process
     * 
     * @param player
     */
    public void onLogin(Player player) {
    }

    /**
     * Called on player disconnect
     * 
     * @param player
     */
    public void onDisconnect(Player player) {
    }

    /**
     * Called when a player talks. If you return true the message won't be sent
     * out.
     * 
     * @param player
     * @param message
     * @return false if you want the message to be sent.
     */
    public boolean onChat(Player player, String message) {
        return false;
    }

    /**
     * Called before the command is parsed. Return true if you don't want the
     * command to be parsed.
     * 
     * @param player
     * @param split
     * @return false if you want the command to be parsed.
     */
    public boolean onCommand(Player player, String[] split) {
        return false;
    }

    /**
     * Called before the console command is parsed. Return true if you don't
     * want the server command to be parsed by the server.
     * 
     * @param split
     * @return false if you want the command to be parsed.
     */
    public boolean onConsoleCommand(String[] split) {
        return false;
    }

    /**
     * Called when a player is banned
     * 
     * @param mod
     *            moderator that's banning
     * @param player
     *            player being banned
     * @param reason
     *            reason for ban
     */
    public void onBan(Player mod, Player player, String reason) {
    }

    /**
     * Called when a player is IP banned
     * 
     * @param mod
     *            moderator that's banning
     * @param player
     *            player being banning
     * @param reason
     *            for IP ban
     */
    public void onIpBan(Player mod, Player player, String reason) {
    }

    /**
     * Called when a player is kicked
     * 
     * @param mod
     *            moderator that's kicking
     * @param player
     *            player being kicked
     * @param reason
     *            reason for kick
     */
    public void onKick(Player mod, Player player, String reason) {
    }

    /**
     * Called when someone presses right click. If they right clicked with a
     * block you can return true to cancel that. You can intercept this to add
     * your own right click actions to different item types (see itemInHand)
     * 
     * @param player
     * @param blockPlaced
     * @param blockClicked
     * @param itemInHand
     * @return false if you want the action to go through
     */
    public boolean onBlockCreate(Player player, Block blockPlaced, Block blockClicked, int itemInHand) {
        return false;
    }

    /**
     * Called when a person left clicks a block.
     * 
     * @param player
     * @param block
     * @return
     */
    public boolean onBlockDestroy(Player player, Block block) {
        return false;
    }

    /**
     * Called when a person actually breaks the block.
     * 
     * @param player
     * @param block
     * @return
     */
    public boolean onBlockBreak(Player player, Block block) {
        return false;
    }

    /**
     * Called when a player swings their arm, aka left clicks (even if no block
     * is in front of them)
     * 
     * @param player
     *            player swinging
     */
    public void onArmSwing(Player player) {
    }

    /**
     * Called when a player's inventory is modified.
     * 
     * @param player
     *            player who's inventory was modified
     * @return true if you want any changes to be reverted
     */
    public boolean onInventoryChange(Player player) {
        return false;
    }

    /**
     * Called when a player's crafting table inventory is modified. This is the
     * 2x2 box in a player's inventory, not the actual 3x3 crafting table!
     * 
     * @param player
     *            player who's crafting table was modified
     * @return true if you want any changes to be reverted
     */
    public boolean onCraftInventoryChange(Player player) {
        return false;
    }

    /**
     * Called when a player's equipment inventory is modified.
     * 
     * @param player
     *            player who's equipment was modified
     * @return true if you want any changes to be reverted
     */
    public boolean onEquipmentChange(Player player) {
        return false;
    }

    /**
     * Called when a player drops an item.
     * 
     * @param player
     *            player who dropped the item
     * @param item
     *            item that was dropped
     * @return true if you don't want the dropped item to be spawned in the
     *         world
     */
    public boolean onItemDrop(Player player, Item item) {
        return false;
    }

    /**
     * Called when either a sign, chest or furnace is changed.
     * 
     * @param player
     *            player who changed it
     * @param block
     *            complex block that changed
     * @return true if you want any changes to be reverted
     */
    public boolean onComplexBlockChange(Player player, ComplexBlock block) {
        return false;
    }

    /**
     * Called when either a sign, chest or furnace is sent to a player
     * 
     * @param player
     *            player who the block is being sent to
     * @param block
     *            complex block that's being sent
     * @return true if you want the chest, furnace or sign to be empty
     */
    public boolean onSendComplexBlock(Player player, ComplexBlock block) {
        return false;
    }

    /*
     * Called when either a lava block or a lighter tryes to light something on fire.
     * block status depends on the light source:
     * 1 = lava.
     * 2 = lighter (flint + steel).
     * 3 = spread (dynamic spreading of fire).
     * @param block
     *          block that the fire wants to spawn in.
     *
     * @return true if you dont want the fire to ignite.
     */
    public boolean onIgnite(Block block, Player player) {
        return false;
    }

    /*
     * Called when a dynamite block or a creeper is triggerd.
     * block status depends on explosive compound:
     * 1 = dynamite.
     * 2 = creeper.
     * @param block
     *          dynamite block/creeper location block.
     *
     * @return true if you dont the block to explode.
     */
    public boolean onExplode(Block block) {
        return false;
    }

    /*
     * Called when fluid wants to flow to a certain block.
     * (10 & 11 for lava and 8 & 9 for water)
     * 
     * @param blockFrom
     *              the block where the fluid came from.
     *              (blocktype = fluid type)
     * @param blockTo
     *              the block where fluid wants to flow to.
     *
     *
     * @return true if you dont want the substance to flow.
     */
    public boolean onFlow(Block blockFrom,Block blockTo) {
        return false;
    }
    
    /**
     * @param mob Mob attempting to spawn.
     * @return true if you dont want mob to spawn.
     */
    public boolean onMobSpawn(Mob mob) {
    	return false;
    }
}
