/*
 * CoreMe Minecraft Mod API
 * Copyright (c) 2014 by BigDaveNz aka David J. Dudson (bigdavenz@bigdavenz.co.nz).
 * Released under GNU General Public Licence version 3 https://www.gnu.org/licenses/gpl.html
 */

package nz.co.bigdavenz.coreme.core.chat

import cpw.mods.fml.common.FMLLog
import nz.co.bigdavenz.coreme.core.chat.CommunicationStyle.CommunicationStyle
import scala.beans.BeanProperty

/**
 * Created by BigDaveNz aka David J. Dudson.
 * Date 31/03/2014.
 * Time 7:07 PM.
 *
 * Class for communicating with Console
 */
class ConsoleCommunication(modInitial: String, message: String, @BeanProperty val style: CommunicationStyle) extends Communication(modInitial, message) {

  /**
   * Sends the message based on style
   */
  def send {
    style match {
      case CommunicationStyle.ERROR => FMLLog.severe("[" + modInitial.toUpperCase + "] " + message)
      case CommunicationStyle.WARNING => FMLLog.warning("[" + modInitial.toUpperCase + "] " + message)
      case _ => FMLLog.info("[" + modInitial.toUpperCase + "] " + message)
    }
  }
}
