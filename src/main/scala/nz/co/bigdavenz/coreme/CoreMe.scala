/*
 * CoreMe Minecraft Mod API
 * Copyright (c) 2014 by BigDaveNz aka David J. Dudson (bigdavenz@bigdavenz.co.nz).
 * Released under GNU General Public Licence version 3 https://www.gnu.org/licenses/gpl.html
 */

package nz.co.bigdavenz.coreme

import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.{FMLPreInitializationEvent, FMLServerStartingEvent}
import cpw.mods.fml.common.{FMLCommonHandler, Mod}
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.init.Items
import net.minecraft.item.Item
import net.minecraftforge.common.MinecraftForge
import nz.co.bigdavenz.coreme.core.event.CmEvent
import nz.co.bigdavenz.coreme.core.input.command.CommandHandler
import scala.beans.BeanProperty

/**
 * Created by BigDaveNz aka David J. Dudson.
 * Date 30/03/2014.
 * Time 4:12 PM.
 *
 * Core class for CoreMe
 */

@Mod(modid = "CoreMe", version = "This-Doesnt-Mean-Anything-Look-At-The-File", modLanguage = "scala")
object CoreMe {

  /**
   * Initials for this mod
   */
  @BeanProperty val modInitial = "CM"

  /**
   * Mod Name
   */
  @BeanProperty val modName = "CoreMe"

  /**
   * Handles all commands
   */
  @BeanProperty val commandHandler = new CommandHandler

  /**
   * Handles Both FML and Forge Events
   */
  @BeanProperty val eventHandler = new CmEvent

  /**
   * Handles command registration
   * @param event server starting event
   */
  @EventHandler
  def serverStarting(event: FMLServerStartingEvent): Unit = {
    event.registerServerCommand(getCommandHandler)
  }

  /**
   * The Creative Tab
   */
  val tabCM: CreativeTabs = new CreativeTabs(CreativeTabs.getNextID, getModName) {
    override def getTabIconItem: Item = Items.cookie
  }

  /**
   * Pre init phase of minecraft loading, registers the event handler
   * @param event pre init event
   */
  @EventHandler
  def preInit(event: FMLPreInitializationEvent): Unit = {
    MinecraftForge.EVENT_BUS.register(getEventHandler)
    FMLCommonHandler.instance().bus.register(getEventHandler)
  }


}
