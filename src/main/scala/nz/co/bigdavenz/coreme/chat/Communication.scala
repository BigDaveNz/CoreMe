/*
 * CoreMe Minecraft Mod API
 * Copyright (c) 2014 by BigDaveNz aka David J. Dudson (bigdavenz@bigdavenz.co.nz).
 * Released under GNU General Public Licence version 3 https://www.gnu.org/licenses/gpl.html
 */

package nz.co.bigdavenz.coreme.chat

import nz.co.bigdavenz.coreme.chat.CommunicationStyle.CommunicationStyle
import scala.beans.BeanProperty


/**
 * Created by BigDaveNz aka David J. Dudson.
 * Date 31/03/2014.
 * Time 3:50 PM.
 *
 * Handles all communications
 */
abstract class Communication(@BeanProperty val modInitial: String, @BeanProperty val message: String) {

  /**
   * The send function is what actually sends the communication
   */
  def send

  /**
   * Apply method simply calls the constructor and the send method. If you don't want messages sent automatically use the new Keyword
   * @param modInitial - The initials of your mod. For instance Buildcraft = BC.
   * @param message - the message which is to be sent
   */
  def apply(modInitial: String, message: String, style: CommunicationStyle): Unit = {
    this(modInitial, message, style)
    this.send
  }
}
