/*
 * CoreMe Minecraft Mod API
 * Copyright (c) 2014 by BigDaveNz aka David J. Dudson (bigdavenz@bigdavenz.co.nz).
 * Released under GNU General Public Licence version 3 https://www.gnu.org/licenses/gpl.html
 */

package nz.co.bigdavenz.coreme.core.input.command

import net.minecraft.command.{ICommandSender, CommandBase}
import net.minecraft.entity.player.EntityPlayer
import nz.co.bigdavenz.coreme.CoreMe
import nz.co.bigdavenz.coreme.core.chat.{CommunicationStyle, PlayerCommunication}

/**
 * Created by BigDaveNz aka David J. Dudson.
 * Date 22/05/2014.
 * Time 1:12 PM.
 *
 * Handles all Game Commands
 */
class CommandHandler extends CommandBase {
  override def getCommandName: String = CoreMe.getModInitial

  override def getCommandUsage(var1: ICommandSender): String = "CommandUsage"

  override def processCommand(var1: ICommandSender, var2: Array[String]): Unit = {

    new PlayerCommunication(CoreMe.getModInitial, var2.toString, CommunicationStyle.NOTIFICATION, Some(var1.asInstanceOf[EntityPlayer]))
  }
}
