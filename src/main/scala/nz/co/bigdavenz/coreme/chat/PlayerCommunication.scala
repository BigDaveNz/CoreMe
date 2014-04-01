/*
 * CoreMe Minecraft Mod API
 * Copyright (c) 2014 by BigDaveNz aka David J. Dudson (bigdavenz@bigdavenz.co.nz).
 * Released under GNU General Public Licence version 3 https://www.gnu.org/licenses/gpl.html
 */

package nz.co.bigdavenz.coreme.chat

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.server.MinecraftServer
import net.minecraft.util.{ChatComponentText, IChatComponent, EnumChatFormatting, ChatStyle}
import nz.co.bigdavenz.coreme.chat.CommunicationStyle._
import scala.beans.BeanProperty

/**
 * Created by BigDaveNz aka David J. Dudson.
 * Date 31/03/2014.
 * Time 7:40 PM.
 *
 * Sends messages in game
 */
class PlayerCommunication(modInitial: String, message: String, @BeanProperty val requiredStyle: CommunicationStyle, @BeanProperty val player: Option[EntityPlayer]) extends Communication(modInitial, message) {

  /**
   * The send function is what actually sends the communication
   * Either by broadcasting through the configuration manager or by sending a chat message specific to the player
   */
  override def send: Unit = {
    getPlayer match {
      case Some(p) => p.addChatMessage(this.getChatComponent)
      case None => MinecraftServer.getServer.getConfigurationManager.sendChatMsg(this.getChatComponent)
    }
  }

  /**
   * Gets the appropriate chat component for the message
   * @return - returns the appropriate component
   */
  def getChatComponent: IChatComponent = {
    getChatText.setChatStyle(getStyle)
  }

  /**
   * Gets the appropriate chat style based on message type
   * @return chat style for the message
   */
  @BeanProperty val style: ChatStyle = {
    requiredStyle match {
      case CommunicationStyle.ERROR => new ChatStyle().setColor(EnumChatFormatting.RED).setBold(true)
      case CommunicationStyle.WARNING => new ChatStyle().setColor(EnumChatFormatting.GOLD).setBold(true)
      case CommunicationStyle.CELEBRATION => new ChatStyle().setColor(EnumChatFormatting.YELLOW).setBold(true)
      case CommunicationStyle.NOTIFICATION => new ChatStyle().setColor(EnumChatFormatting.BLUE).setItalic(true)
      case _ => new ChatStyle().setColor(EnumChatFormatting.GRAY)
    }
  }

  /**
   * gets the text to be displayed in the communication, adds mod info and
   * @return the text component of the message
   */
  @BeanProperty val chatText: ChatComponentText = {
    player match {
      case None => new ChatComponentText("[" + modInitial + "-BROADCAST-" + requiredStyle + "] " + message)
      case _ => new ChatComponentText("[" + modInitial + "-" + requiredStyle + "] " + message)
    }
  }
}
