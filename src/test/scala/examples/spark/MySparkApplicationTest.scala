package examples.spark

import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.{BeforeAndAfter, FunSuite}

class MySparkApplicationTest extends FunSuite with BeforeAndAfter {
  var sc: SparkContext = null;

  // This is ran before each tests
  before {
    // configuration de Spark
    val conf = new SparkConf()
      .setAppName("SparkTPApp1Test")
      .setMaster("local") // Configure to run spark locally for your tests 
    sc = new SparkContext(conf)
  }

  // This is ran after each tests
  after {
    sc.stop()
  }

  test("Return a tuple containing the number of A,B letters per file") {
    // Let's remember that you don't want to test what spark does, but what you're doing with it
    // So you don't really test if it counts properly but you count if it returns what it's supposed to return
    val result = MySparkApplication.compteAB(Utils.getResource("fake_data").getFile, sc)
    assert(result != null)
    assert(result._1.isInstanceOf[Long])
    assert(result._2.isInstanceOf[Long])
    assert(result._1 == 6)
    assert(result._2 == 3)
  }

}
