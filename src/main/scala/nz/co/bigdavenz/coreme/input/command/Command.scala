/*
 * CoreMe Minecraft Mod API
 * Copyright (c) 2014 by BigDaveNz aka David J. Dudson (bigdavenz@bigdavenz.co.nz).
 * Released under GNU General Public Licence version 3 https://www.gnu.org/licenses/gpl.html
 */

package nz.co.bigdavenz.coreme.input.command

import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender


/**
 * Created by BigDaveNz aka David J. Dudson.
 * Date 31/03/2014.
 * Time 12:29 AM.
 *
 * Handles All Non Admin Commands
 */
abstract class Command extends CommandBase {
  override def getRequiredPermissionLevel: Int = 1
}
