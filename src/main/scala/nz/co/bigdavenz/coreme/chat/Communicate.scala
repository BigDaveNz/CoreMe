/*
 * CoreMe Minecraft Mod API
 * Copyright (c) 2014 by BigDaveNz aka David J. Dudson (bigdavenz@bigdavenz.co.nz).
 * Released under GNU General Public Licence version 3 https://www.gnu.org/licenses/gpl.html
 */

package nz.co.bigdavenz.coreme.chat

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.{EnumChatFormatting, ChatStyle, ChatComponentText}
import cpw.mods.fml.common.FMLLog
import net.minecraft.server.MinecraftServer

/**
 * Created by BigDaveNz aka David J. Dudson.
 * Date 30/03/2014.
 * Time 4:13 PM.
 *
 * Message handler, to console/players etc.
 */
class Communicate {

  /**
   * Sends message to player
   * @param player - player which requires the message
   * @param comType - type of message
   * @param message - the message
   */
  def withPlayer(player: EntityPlayer, comType: CommunicationType, message: String) {
    player.addChatComponentMessage(new ChatComponentText("[CM-" + comType.toString() + "] ").appendText(message).setChatStyle(getFormatting(comType)))
  }

  /**
   * Sends a message to all logged in players
   * @param comType - type of message
   * @param message - the message
   */
  def withAll(comType: CommunicationType, message: String) {
    MinecraftServer.getServer.getConfigurationManager.sendChatMsg(new ChatComponentText("[CM-BROADCAST-" + comType.toString() + "] ").appendText(message).setChatStyle(getFormatting(comType)))
  }

  /**
   * Sends a message to the Console
   * @param comType - type of message
   * @param message - the message
   */
  def withConsole(comType: CommunicationType, message: String) {
    comType match {
      case comType.ERROR => FMLLog.severe("[CM] " + message)
      case comType.WARNING => FMLLog.warning("[CM] " + message)
      case _ => FMLLog.info("[CM] " + message)
    }
  }

  /**
   * Gets the appropriate chat style based on message type
   * @param comType - type of message
   * @return chat style for message
   */
  def getFormatting(comType: CommunicationType): ChatStyle = {
    comType match {
      case comType.ERROR => new ChatStyle().setColor(EnumChatFormatting.RED).setBold(true)
      case comType.WARNING => new ChatStyle().setColor(EnumChatFormatting.GOLD).setBold(true)
      case comType.CELEBRATION => new ChatStyle().setColor(EnumChatFormatting.YELLOW).setBold(true)
      case comType.NOTIFICATION => new ChatStyle().setColor(EnumChatFormatting.BLUE).setItalic(true)
      case _ => throw new IllegalArgumentException("Invalid chat type")
    }
  }
}
