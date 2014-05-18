/*
 * CoreMe Minecraft Mod API
 * Copyright (c) 2014 by BigDaveNz aka David J. Dudson (bigdavenz@bigdavenz.co.nz).
 * Released under GNU General Public Licence version 3 https://www.gnu.org/licenses/gpl.html
 */

package nz.co.bigdavenz.coreme.core.file

import scala.xml.transform.{RewriteRule, RuleTransformer}
import scala.xml.{TopScope, Elem, Node}

/**
 * Created by BigDaveNz aka David J. Dudson.
 * Date 6/04/2014.
 * Time 3:15 PM.
 *
 * Deals with all XML serialization
 */
class XmlHelper {

  /**
   * Recursively gets nested data packages and their contents (in conjunction with toXML)
   * @param key - key its accessing
   * @param pack - data package to get the nested contents from
   * @return - The XML node of the nested data package
   */
  private def getNested(key: String, pack: DataPackage): Node = {
    val oldXML: Node = toElem(key)
    var newXML: Node = toElem(key)
    pack.foreach {
      case (k: String, v: Any) =>
        newXML = new RuleTransformer(new AddChildrenTo(newXML.label, toXml(k, v))).transform(oldXML).head
    }
    newXML
  }

  /**
   * Main xml function for generating XML from any datatype
   * @param key - key for the data package
   * @param value - the value to convert to xml
   * @return - the xml node
   */
  def toXml(key: String, value: Any): Node = {
    value match {
      case _: DataPackage => getNested(key, value.asInstanceOf[DataPackage])
      case _ if testAnyVal(value) => toElem(value.getClass.toString, value)
      case _ => <Error/>
    }
  }

  /**
   * Add a child node to an xml node
   * @param n - node
   * @param newChild - the node to add as a child
   * @return - the new complete node
   */
  def addChild(n: Node, newChild: Node) = n match {
    case Elem(prefix, label, attribs, scope, child@_*) =>
      Elem(prefix, label, attribs, scope, child ++ newChild: _*)
    case _ => sys.error("Can only add children to elements!")
  }

  /**
   * Adds children to the node
   * @param label
   * @param newChild
   */
  class AddChildrenTo(label: String, newChild: Node) extends RewriteRule {
    override def transform(n: Node) = n match {
      case n@Elem(_, `label`, _, _, _*) => addChild(n, newChild)
      case other => other
    }
  }

  /**
   * Tests whether a value is a primitive
   * @param t - value
   * @tparam T - Type
   * @return - true if t is a primitive
   */
  def testAnyVal[T: Manifest](t: T): Boolean = manifest[T] <:< manifest[AnyVal]

  /**
   *
   * @param tag
   * @param value
   * @param tagInner
   * @return
   */
  def toElem(tag: String, value: Any = null, tagInner: Node = null): Elem = {
    Elem(null, tag, null, TopScope, tagInner)
  }
}
