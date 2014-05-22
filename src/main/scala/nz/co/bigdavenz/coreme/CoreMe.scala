/*
 * CoreMe Minecraft Mod API
 * Copyright (c) 2014 by BigDaveNz aka David J. Dudson (bigdavenz@bigdavenz.co.nz).
 * Released under GNU General Public Licence version 3 https://www.gnu.org/licenses/gpl.html
 */

package nz.co.bigdavenz.coreme

import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.{FMLPreInitializationEvent, FMLServerStartingEvent}
import net.minecraftforge.common.MinecraftForge
import nz.co.bigdavenz.coreme.core.chat.{CommunicationStyle, ConsoleCommunication}
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

  @EventHandler
  def serverStarting(event: FMLServerStartingEvent): Unit = {
    event.registerServerCommand(new CommandHandler)
    new ConsoleCommunication(CoreMe.getModInitial, "Server Started, Command Handler Registered", CommunicationStyle.NOTIFICATION)
  }

  @EventHandler
  def preInit(event: FMLPreInitializationEvent): Unit = {
    MinecraftForge.EVENT_BUS.register( new)
  }


  /**
   * Initials for this mod
   */
  @BeanProperty val modInitial = "CM"
}
