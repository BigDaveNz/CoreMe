/*
 * CoreMe Minecraft Mod API
 * Copyright (c) 2014 by BigDaveNz aka David J. Dudson (bigdavenz@bigdavenz.co.nz).
 * Released under GNU General Public Licence version 3 https://www.gnu.org/licenses/gpl.html
 */

package nz.co.bigdavenz.coreme.core.chat

import cpw.mods.fml.common.FMLLog
import nz.co.bigdavenz.coreme.core.chat.CommunicationPrefix.CommunicationPrefix
import nz.co.bigdavenz.coreme.core.chat.CommunicationStyle.CommunicationStyle

/**
 * Created by BigDaveNz aka David J. Dudson.
 * Date 31/03/2014.
 * Time 7:07 PM.
 *
 * Class for communicating with Console
 */
class ConsoleCommunication(modInitial: String, message: String, style: CommunicationStyle, prefix: CommunicationPrefix) extends Communication(modInitial, message, style, prefix) {

  /**
   * Sends the message based on style
   */
  def send {
    style match {
      case CommunicationStyle.ERROR => FMLLog.severe(getPrefix + getMessage)
      case CommunicationStyle.WARNING => FMLLog.warning(getPrefix + getMessage)
      case _ => FMLLog.info(getPrefix + getMessage)
    }
  }
}
