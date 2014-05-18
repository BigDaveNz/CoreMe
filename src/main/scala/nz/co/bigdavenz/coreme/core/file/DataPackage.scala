/*
 * CoreMe Minecraft Mod API
 * Copyright (c) 2014 by BigDaveNz aka David J. Dudson (bigdavenz@bigdavenz.co.nz).
 * Released under GNU General Public Licence version 3 https://www.gnu.org/licenses/gpl.html
 */

package nz.co.bigdavenz.coreme.core.file

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.reflect.ClassTag


/**
 * Created by BigDaveNz aka David J. Dudson.
 * Date 6/04/2014.
 * Time 2:47 PM.
 *
 * Package for all savable data to be in.
 * DataPackages are effectively HashMaps, with the
 */
class DataPackage() extends mutable.HashMap[String, Any] {

  /**
   * Implicits for type defaults
   */
  implicit val i: Int = 0
  implicit val d: Double = 0.0D
  implicit val f: Float = 0.0F
  implicit val sh: Short = 0
  implicit val l: Long = 0
  implicit val s: String = ""
  implicit val p: DataPackage = new DataPackage
  //Todo Fix infinite recursion with DataPackage

  /**
   * Main way of accessing any data inside the data package
   * @param key - Key in the DataPackage to access
   * @param default - default value for the key
   * @tparam T - Type of data you expect out of the DataPackage
   * @return - Either a single of type (mainly for nested data packages), or an immutable array of that type
   */
  private def getOfType[T](key: String)(implicit default: ClassTag[T]): Either[ArrayBuffer[T], T] = {
    val value = this.getOrElseUpdate(key, default)
    val rValue: Either[ArrayBuffer[T], T] = value match {
      case _: T if value.isInstanceOf[DataPackage] => Right(value.asInstanceOf[T])
      case _: T =>
        val ab: ArrayBuffer[T] = new ArrayBuffer[T]
        ab.append(value.asInstanceOf[T])
        Left(ab)
      case _: ArrayBuffer[T] => Left(value.asInstanceOf[ArrayBuffer[T]])
      case _ => throw new IllegalArgumentException("attempted to get a key/set of invalid type")
    }
    rValue
  }

  /**
   * Sets a new Key/Value pair in the data package
   * @param key - The key that will be used
   * @param value - the value of they field
   * @tparam T - they type of data
   */
  def setSingleOfType[T](key: String, value: T) {
    this.getOrElseUpdate(key, value)
  }

  /**
   * Returns the full array that is held within the key (all recent data)
   * @param key - the key that will be accessed
   * @param default - the default value for the type
   * @tparam T - they type of data
   * @return - The array of values
   */
  def getArrayOfType[T](key: String)(implicit default: ClassTag[T]): ArrayBuffer[T] = {
    getOfType(key)(default).left.get
  }

  /**
   * Get single value of a specific type (Used only for DataPackages currently)
   * @param key - key that will be got
   * @param default - the default value for that type
   * @tparam T - the type of data you want to access
   * @return
   */
  def getSingleOfType[T](key: String)(implicit default: ClassTag[T]): T = {
    getOfType(key)(default).right.get
  }

  /**
   * get the most recent value of a field
   * @param key - key that will be got
   * @param default - the default value for that field
   * @tparam T - The type of data
   * @return - The head of the array that was contained with the key
   */
  def getHeadOfType[T](key: String)(implicit default: ClassTag[T]): T = {
    val v: ArrayBuffer[T] = getArrayOfType(key)(default)
    v.head
  }
}

