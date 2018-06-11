package examples.spark

import java.net.URL

import scala.io.Source

object Utils {

  val att_line = """^\s*(\S*)\s.*$""".r

  def loadSchema(resource: String): Array[String] = {
    val reader = Source.fromURL(getResource(resource)).getLines()
    reader
      .drop(1)
      .filter(l => l.trim != ");")
      .map(l => att_line.replaceAllIn(l, "$1"))
      .toArray
  }

  def getResource(resource: String): URL = {
    getClass.getClassLoader.getResource(resource)
  }
}
