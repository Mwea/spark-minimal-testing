package examples.spark.domain

import examples.spark.Utils

object ExampleSchema {
  val sourceS = Utils.loadSchema("Source.sql")
  val objectS = Utils.loadSchema("Object.sql")

  val s_objectId = sourceS.indexOf("objectId")
  val s_sourceId = sourceS.indexOf("sourceId")
  val s_ra = sourceS.indexOf("ra")
  val s_decl = sourceS.indexOf("decl")
}
