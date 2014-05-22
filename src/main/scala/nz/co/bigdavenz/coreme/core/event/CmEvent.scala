/*
 * CoreMe Minecraft Mod API
 * Copyright (c) 2014 by BigDaveNz aka David J. Dudson (bigdavenz@bigdavenz.co.nz).
 * Released under GNU General Public Licence version 3 https://www.gnu.org/licenses/gpl.html
 */

package nz.co.bigdavenz.coreme.core.event

import cpw.mods.fml.common.eventhandler.SubscribeEvent
import cpw.mods.fml.common.gameevent.PlayerEvent
import cpw.mods.fml.common.gameevent.TickEvent.ServerTickEvent
import net.minecraft.entity.player.EntityPlayer
import net.minecraftforge.event.entity.living.LivingHurtEvent
import nz.co.bigdavenz.coreme.CoreMe
import nz.co.bigdavenz.coreme.core.chat.{ConsoleCommunication, CommunicationStyle, PlayerCommunication}
import scala.beans.BeanProperty

/**
 * Created by BigDaveNz aka David J. Dudson.
 * Date 22/05/2014.
 * Time 1:43 PM.
 *
 * Handles all events
 */
class CmEvent {

  @BeanProperty var serverTick: Int = 0
  @BeanProperty val dayTicks: Int = 1728000
  @BeanProperty val hourTicks: Int = 72000
  @BeanProperty val minuteTicks: Int = 1200
  @BeanProperty val secondTicks: Int = 20

  def getDisplayTime: String = {
    val day = (getServerTick / getDayTicks, getServerTick % getDayTicks)
    val hour = (day._2 / getHourTicks, day._2 % getHourTicks)
    val minute = (hour._2 / getMinuteTicks, hour._2 % getMinuteTicks)
    val second = (minute._2 / getSecondTicks, minute._2 % getSecondTicks)
    val tick = second._2
    day._1 + " Day(s)" + hour._1 + ":" + minute._1 + "." + second._1 + "." + tick
  }

  @SubscribeEvent
  def onPlayerLogin(event: PlayerEvent.PlayerLoggedInEvent) {
    new PlayerCommunication(CoreMe.getModInitial, "Minecraft limits your potential!, together we can unlock your full potential!", CommunicationStyle.NOTIFICATION, Some(event.player)).sendWithoutPrefix
  }

  @SubscribeEvent
  def onLivingHurt(event: LivingHurtEvent) {
    event.entity match {
      case player: EntityPlayer =>
        new ConsoleCommunication(CoreMe.getModInitial, "AARGHH, Im hurt!!! Amount: " + event.ammount + " , Source: " + event.source.getDamageType + ", Entity: " + player.getDisplayName, CommunicationStyle.NOTIFICATION).sendWithoutPrefix
        new PlayerCommunication(CoreMe.getModInitial, "AARGHH, Your hurt!!! Amount: " + event.ammount + " , Source: " + event.source.getDamageType, CommunicationStyle.NOTIFICATION, Some(player)).sendWithoutPrefix
      case _ =>
    }
  }

  @SubscribeEvent
  def onServerTick(event: ServerTickEvent) {
    serverTick += 1
  }
}
