/*
 * CoreMe Minecraft Mod API
 * Copyright (c) 2014 by BigDaveNz aka David J. Dudson (bigdavenz@bigdavenz.co.nz).
 * Released under GNU General Public Licence version 3 https://www.gnu.org/licenses/gpl.html
 */

package nz.co.bigdavenz.coreme

import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.Mod.EventHandler

/**
 * Created by BigDaveNz aka David J. Dudson.
 * Date 30/03/2014.
 * Time 4:12 PM.
 *
 * Core class for CoreMe
 */

@Mod(modid = "CoreMe", version = "This-Doesnt-Mean-Anything-Look-At-The-File")
class CoreMe {

  import cpw.mods.fml.common.event.FMLServerStartingEvent

  @EventHandler
  def serverLoad(event: FMLServerStartingEvent) {
  }
}
