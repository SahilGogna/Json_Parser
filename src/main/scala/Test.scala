import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object Test extends App{

  val spark = SparkSession.builder()
    .appName("Json handler")
    .config("spark.master", "local")
    .getOrCreate()

  val data = spark.read
    .option("inferschema", "true")
    .option("multiline", "true")
    .json("/Users/sahilgogna/station_status.json")

  data.printSchema()

  val df = data.select(
    col("data.stations.eightd_has_available_keys"),
    col("data.stations.is_charging"),
    col("data.stations.is_installed"),
    col("data.stations.is_renting"),
    col("data.stations.is_returning"),
    col("data.stations.last_reported"),
    col("data.stations.num_bikes_available"),
    col("data.stations.num_bikes_disabled"),
    col("data.stations.num_docks_available"),
    col("data.stations.num_docks_disabled"),
    col("data.stations.num_ebikes_available"),
    col("data.stations.station_id")
  )
//  df.show(truncate = false)
  df.printSchema()
//  df.withColumn("col1",element_at(col("element"),1)).show()

//    write
//    .format("csv")
//    .option("header", "true")
//    .save("/Users/sahilgogna/Desktop/folder/test")

}
