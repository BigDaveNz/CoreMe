/*
 * CoreMe Minecraft Mod API
 * Copyright (c) 2014 by BigDaveNz aka David J. Dudson (bigdavenz@bigdavenz.co.nz).
 * Released under GNU General Public Licence version 3 https://www.gnu.org/licenses/gpl.html
 */

package nz.co.bigdavenz.coreme.core.chat

/**
 * Created by BigDaveNz aka David J. Dudson.
 * Date 22/05/2014.
 * Time 6:40 PM.
 *
 * Prefixes for communications
 */
object CommunicationPrefix extends Enumeration {

  type CommunicationPrefix = Value
  val NONE, MOD_ID, TYPE, ALL = Value
}
