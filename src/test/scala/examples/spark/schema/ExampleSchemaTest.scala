package examples.spark.schema

import examples.spark.domain.ExampleSchema
import org.scalatest.FunSuite

class ExampleSchemaTest extends FunSuite {

  test("Check some attributes in source") {
    assert(ExampleSchema.sourceS(0) == "sourceId")
    assert(ExampleSchema.sourceS(2) == "decl")
  }

  test("Check some attributes in object") {
    assert(ExampleSchema.objectS(0) == "objectId")
  }

  test("Check schema lengths") {
    assert(ExampleSchema.sourceS.length == 4)
    assert(ExampleSchema.objectS.length == 2)
  }

}
