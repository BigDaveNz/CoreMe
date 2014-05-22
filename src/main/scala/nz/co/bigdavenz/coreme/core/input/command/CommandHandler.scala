/*
 * CoreMe Minecraft Mod API
 * Copyright (c) 2014 by BigDaveNz aka David J. Dudson (bigdavenz@bigdavenz.co.nz).
 * Released under GNU General Public Licence version 3 https://www.gnu.org/licenses/gpl.html
 */

package nz.co.bigdavenz.coreme.core.input.command

import net.minecraft.command.{ICommandSender, CommandBase}
import net.minecraft.entity.player.EntityPlayer
import nz.co.bigdavenz.coreme.CoreMe
import nz.co.bigdavenz.coreme.core.chat.{CommunicationPrefix, CommunicationStyle, PlayerCommunication}
import nz.co.bigdavenz.coreme.core.gui.TimeGui

/**
 * Created by BigDaveNz aka David J. Dudson.
 * Date 22/05/2014.
 * Time 1:12 PM.
 *
 * Handles all Game Commands
 */
class CommandHandler extends CommandBase {
  /**
   * command name for input /[CommandName]
   * @return command name
   */
  override def getCommandName: String = CoreMe.getModInitial.toLowerCase

  /**
   * Default Command usage
   * @param var1 Command sender
   * @return default usage
   */
  override def getCommandUsage(var1: ICommandSender): String = "/cm [time]"

  /**
   * process the command, and get a result
   * @param var1 Command sender
   * @param var2 Command arguments
   */
  override def processCommand(var1: ICommandSender, var2: Array[String]): Unit = {

    if (var2.nonEmpty) var2(0) match {
      case "time" if !TimeGui.getShow => TimeGui.setShow(true)
      case "time" if !TimeGui.getShow => TimeGui.setShow(true)
      case _ => new PlayerCommunication(CoreMe.getModInitial, "What is this bullshit command you are trying to send me?? Try again... Command was: " + var2.mkString(","), CommunicationStyle.NOTIFICATION, Some(var1.asInstanceOf[EntityPlayer]), CommunicationPrefix.NONE).send
    }

  }
}
