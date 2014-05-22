/*
 * CoreMe Minecraft Mod API
 * Copyright (c) 2014 by BigDaveNz aka David J. Dudson (bigdavenz@bigdavenz.co.nz).
 * Released under GNU General Public Licence version 3 https://www.gnu.org/licenses/gpl.html
 */

package nz.co.bigdavenz.coreme.core.database

/**
 * Created by BigDaveNz aka David J. Dudson.
 * Date 19/05/2014.
 * Time 5:12 PM.
 *
 * Handles the database
 */
object MainDatabase {

  //  class Players(tag: Tag) extends Table[(String, Int, Int, Int)](tag, "PLAYERS") {
  //    def username = column[String]("PLAYER_NAME", O.PrimaryKey)
  //
  //    def runDistance = column[Int]("RUN_DISTANCE")
  //
  //    def jumpDistance = column[Int]("JUMP_DISTANCE")
  //
  //    def swimDistance = column[Int]("SWIM_DISTANCE")
  //
  //    def * = (username, runDistance, jumpDistance, swimDistance)
  //  }
  //
  //  val players = TableQuery[Players]
  //
  //  class Mods(tag: Tag) extends Table[(String)](tag, "MODS") {
  //    def modId = column("MOD_ID", O.PrimaryKey)
  //
  //    def * = modId
  //  }
  //
  //  val mods = TableQuery[Mods]
  //
  //  class Worlds(tag: Tag) extends Table[(String)](tag, "WORLDS") {
  //    def seed = column[String]("WORLD_SEED", O.PrimaryKey)
  //
  //    def server = foreignKey("SERVER_FK", ip, servers)
  //
  //    def * = seed
  //  }
  //
  //  val worlds = TableQuery[Worlds]
  //
  //  class Servers(tag: Tag) extends Table[(String)](tag, "SERVERS") {
  //    def ip = column[String]("SERVER_IP", O.PrimaryKey)
  //
  //    def * = ip
  //  }
  //
  //  val servers = TableQuery[Servers]
  //
  //  class ServerMods {
  //    //Todo finish the join
  //  }
  //
  //  class Blocks(tag: Tag) extends Table[(String, String, Int, Float)](tag, "BLOCKS") {
  //    def blockName = column("BLOCK_NAME", O.PrimaryKey)
  //
  //    def mod = column("MOD_NAME")
  //
  //    def baseExperience = column("BASE_EXPERIENCE")
  //
  //    def modifier = column("MODIFIER")
  //
  //    def * = (blockName, mod)
  //  }
  //
  //  class Items(tag: Tag) extends Table[(String, String, Int, Float)](tag, "ITEMS") {
  //    def blockName = column("ITEM_NAME", O.PrimaryKey)
  //
  //    def mod = column("MOD_NAME")
  //
  //    def baseExperience = column("BASE_EXPERIENCE")
  //
  //    def modifier = column("MODIFIER")
  //
  //    def * = (blockName, mod)
  //  }
  //
  //  val blocks = TableQuery[Blocks]
  //
  //  class PlayerItems(tag: Tag) extends Table[(String, String, Int, Int)](tag, "PLAYER_ITEMS") {
  //    def player = column("PLAYER_NAME", O.PrimaryKey)
  //
  //    def itemName = column("ITEM_NAME")
  //
  //    def craft = column("CRAFT_EXPERIENCE")
  //
  //    def use = column("USE_EXPERIENCE")
  //
  //    def * = (player, itemName, craft, use)
  //  }
  //
  //  val itemPlayers = TableQuery[PlayerItems]
  //
  //  class PlayerBlocks(tag: Tag) extends Table[(String, String, Int, Int, Int)](tag, "PLAYER_BLOCKS") {
  //
  //    def player = column("PLAYER_NAME")
  //
  //    def blockName = column("BLOCK_NAME")
  //
  //    def craft = column("CRAFT_EXPERIENCE")
  //
  //    def use = column("USE_EXPERIENCE")
  //
  //    def place = column("PLACE_EXPERIENCE")
  //
  //    def * = (player, blockName, craft, use, place)
  //  }
  //
  //val playerBlocks = TableQuery[PlayerItems]

}
