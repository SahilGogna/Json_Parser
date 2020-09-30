import org.apache.spark.sql.SparkSession
import scalaj.http._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.StructType

import scala.collection.mutable.ListBuffer

object Convert extends App {
  val fileName = "station_status"
  //  val json_data = scala.io.Source.fromURL("https://api-core.bixi.com/gbfs/en/station_status.json")
  //    .getLines()
  //    .mkString("\n")
  //
  //  val updated_data = json_data.substring(json_data.indexOf("stations\"") + 13)
  //  println(updated_data)

  val spark = SparkSession.builder()
    .appName("Aggregation and Grouping")
    .config("spark.master", "local")
    .getOrCreate()

  val data = spark.read
    .option("inferschema", "true")
    .option("multiline", "true")
    .json("/Users/sahilgogna/station_status.json")


//  val app = data.select("data")
//  app.createOrReplaceTempView("data")
//  app.printSchema()
//
//  val element = app.select("data.stations")
//  element.createOrReplaceTempView("element")
//
//  println(element.count())


}
