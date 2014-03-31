/*
 * CoreMe Minecraft Mod API
 * Copyright (c) 2014 by BigDaveNz aka David J. Dudson (bigdavenz@bigdavenz.co.nz).
 * Released under GNU General Public Licence version 3 https://www.gnu.org/licenses/gpl.html
 */

package nz.co.bigdavenz.coreme.chat


/**
 * Created by BigDaveNz aka David J. Dudson.
 * Date 31/03/2014.
 * Time 3:09 PM.
 *
 * Allows for types such as broadcasts etc.
 */
object CommunicationType extends Enumeration {

  /**
   * Broadcast - For server broadcasts
   * Console - For console output
   * Player - For player output
   */
  type CommunicationType = Value
  val BROADCAST, CONSOLE, PLAYER = Value
}
