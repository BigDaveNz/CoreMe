/*
 * CoreMe Minecraft Mod API
 * Copyright (c) 2014 by BigDaveNz aka David J. Dudson (bigdavenz@bigdavenz.co.nz).
 * Released under GNU General Public Licence version 3 https://www.gnu.org/licenses/gpl.html
 */

package nz.co.bigdavenz.coreme.input.command

/**
 * Created by BigDaveNz aka David J. Dudson.
 * Date 31/03/2014.
 * Time 1:40 PM.
 *
 * Commands for Op's. Defined as people who can ban/kick etc. on servers
 */
abstract class OperatorCommand extends Command{

  /**
   * Override permission requirements
   * @return 3
   */
  override def getRequiredPermissionLevel: Int = 3
}
