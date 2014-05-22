/*
 * CoreMe Minecraft Mod API
 * Copyright (c) 2014 by BigDaveNz aka David J. Dudson (bigdavenz@bigdavenz.co.nz).
 * Released under GNU General Public Licence version 3 https://www.gnu.org/licenses/gpl.html
 */

package nz.co.bigdavenz.coreme.core.chat

import nz.co.bigdavenz.coreme.CoreMe
import nz.co.bigdavenz.coreme.core.chat.CommunicationPrefix.CommunicationPrefix
import nz.co.bigdavenz.coreme.core.chat.CommunicationStyle.CommunicationStyle
import scala.beans.BeanProperty


/**
 * Created by BigDaveNz aka David J. Dudson.
 * Date 31/03/2014.
 * Time 3:50 PM.
 *
 * Handles all communications
 */
abstract class Communication(@BeanProperty val modInitial: String, @BeanProperty val message: String, @BeanProperty var style: CommunicationStyle, @BeanProperty var prefixType: CommunicationPrefix) {


  /**
   * The send function is what actually sends the communication
   */
  def send()

  /**
   * Defines what prefix the message will use
   */
  @BeanProperty val prefix: String = {
    getPrefixType match {
      case CommunicationPrefix.MOD_ID => "[" + CoreMe.getModInitial + "] "
      case CommunicationPrefix.NONE => ""
      case CommunicationPrefix.TYPE => "[" + getPrefixType + "] "
      case CommunicationPrefix.ALL => "[" + CoreMe.getModInitial "-" + getPrefixType + "]"
      case _ => "ERRORS EVERYWHERE REPORT THIS TO BIGDAVENZ -> Communication/prefix"
    }
  }
}
