
/*
 * CoreMe Minecraft Mod API
 * Copyright (c) 2014 by BigDaveNz aka David J. Dudson (bigdavenz@bigdavenz.co.nz).
 * Released under GNU General Public Licence version 3 https://www.gnu.org/licenses/gpl.html
 */

package nz.co.bigdavenz.coreme.core.chat


import net.minecraft.util.EnumChatFormatting
import org.scalatest.FunSpec


/**
 * Created by BigDaveNz aka David J. Dudson.
 * Date 30/03/2014.
 * Time 4:12 PM.
 *
 * Test class for chat
 */

class CommunicationTest extends FunSpec {

  describe("A Communication to a single player with Error message") {
    val pCom: PlayerCommunication = new PlayerCommunication("TT", "This is a message", CommunicationStyle.ERROR, None)
    it("Should be red") {
      assert(pCom.getStyle.getColor == EnumChatFormatting.RED)
    }
    it("Should be bold") {
      assert(pCom.getStyle.getBold)
    }
    it("Should have a mod initial that's TT") {
      assert(pCom.getModInitial == "TT")
    }
    it("Should have a message \"This is a message\"") {
      assert(pCom.getMessage == "This is a message")
    }
  }

  describe("A Communication to a single player with Celebration message") {
    val pCom: PlayerCommunication = new PlayerCommunication("TT", "This is a message", CommunicationStyle.CELEBRATION, None)
    it("Should be yellow") {
      assert(pCom.getStyle.getColor == EnumChatFormatting.YELLOW)
    }
    it("Should be bold") {
      assert(pCom.getStyle.getBold)
    }
    it("Should have a mod initial that's TT") {
      assert(pCom.getModInitial == "TT")
    }
    it("Should have a message \"This is a message\"") {
      assert(pCom.getMessage == "This is a message")
    }
  }

  describe("A Communication to all players with Warning message") {
    val pCom: PlayerCommunication = new PlayerCommunication("TT", "This is a message", CommunicationStyle.WARNING, None)
    it("Should be gold") {
      assert(pCom.getStyle.getColor == EnumChatFormatting.GOLD)
    }
    it("Should be bold") {
      assert(pCom.getStyle.getBold)
    }
    it("Should have a mod initial that's TT") {
      assert(pCom.getModInitial == "TT")
    }
    it("Should have a message \"This is a message\"") {
      assert(pCom.getMessage == "This is a message")
    }
  }

  describe("A Communication to all players with Notification message") {
    val pCom: PlayerCommunication = new PlayerCommunication("TS", "This is a message2", CommunicationStyle.NOTIFICATION, None)
    it("Should be blue") {
      assert(pCom.getStyle.getColor == EnumChatFormatting.BLUE)
    }
    it("Should be italic") {
      assert(pCom.getStyle.getItalic)
    }
    it("Should have a mod initial that's TS") {
      assert(pCom.getModInitial == "TS")
    }
    it("Should have a message \"This is a message2\"") {
      assert(pCom.getMessage == "This is a message2")
    }

  }

  describe("An Error Communication to the console") {
    val cCom: ConsoleCommunication = new ConsoleCommunication("TS", "This is not a message", CommunicationStyle.ERROR)
    it("Should be an Error") {
      assert(cCom.getStyle == CommunicationStyle.ERROR)
    }
    it("Should have the message \"This is not a message\"") {
      assert(cCom.getMessage == "This is not a message")
    }
    it("Should have a mod initial TS") {
      assert(cCom.getModInitial == "TS")
    }
  }

}
