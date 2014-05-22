/*
 * CoreMe Minecraft Mod API
 * Copyright (c) 2014 by BigDaveNz aka David J. Dudson (bigdavenz@bigdavenz.co.nz).
 * Released under GNU General Public Licence version 3 https://www.gnu.org/licenses/gpl.html
 */

package nz.co.bigdavenz.coreme.core.gui

import net.minecraft.client.Minecraft
import net.minecraft.client.gui.{FontRenderer, Gui}
import net.minecraftforge.client.event.RenderGameOverlayEvent
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType
import nz.co.bigdavenz.coreme.CoreMe
import scala.beans.BeanProperty

/**
 * Created by BigDaveNz aka David J. Dudson.
 * Date 22/05/2014.
 * Time 7:36 PM.
 *
 * InGameGui for displaying the time stuff
 */
object TimeGui extends Gui {

  @BeanProperty var show = false

  def render(event: RenderGameOverlayEvent) {
    if (event.`type` != ElementType.EXPERIENCE || event.isCancelable) {
    } else {
      if (show) {
        def fontRenderer: FontRenderer = Minecraft.getMinecraft.fontRenderer
        Minecraft.getMinecraft.entityRenderer.setupOverlayRendering()
        fontRenderer.drawStringWithShadow(CoreMe.getEventHandler.getDisplayTime, 2, 2, 0xFFFFFF)
      }
    }
  }

}
