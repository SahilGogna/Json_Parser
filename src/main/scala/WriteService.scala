import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

object WriteService extends HadoopConfigurations {
  def main(args: Array[String]): Unit = {
    writeToHdfs()
  }
  def writeToHdfs() = {
    // making a confugration object
    val config = new Configuration()

    // adding configuration files of the cluster to the config object
    config.addResource(new Path("/Users/sahilgogna/opt/hadoop-2.7.3/etc/cloudera/core-site.xml"))
    config.addResource(new Path("/Users/sahilgogna/opt/hadoop-2.7.3/etc/cloudera/hdfs-site.xml"))

    val fileSystem = FileSystem.get(config)
    val hdfsPath = "/user/fall2019/"
    print(fileSystem.exists(new Path(hdfsPath)))
  }
}