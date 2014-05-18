/*
 * CoreMe Minecraft Mod API
 * Copyright (c) 2014 by BigDaveNz aka David J. Dudson (bigdavenz@bigdavenz.co.nz).
 * Released under GNU General Public Licence version 3 https://www.gnu.org/licenses/gpl.html
 */

package nz.co.bigdavenz.coreme.core.chat

/**
 * Created by BigDaveNz aka David J. Dudson.
 * Date 30/03/2014.
 * Time 6:14 PM.
 */
object CommunicationStyle extends Enumeration {

  /**
   * Error - For red error messages
   * Warning - For orange warning messages
   * Celebration - For gold celebration text
   * Notification - For general notifications
   */
  type CommunicationStyle = Value
  val ERROR, WARNING, CELEBRATION, NOTIFICATION = Value
}
