package examples

import org.apache.spark.{ SparkConf, SparkContext }
import org.apache.spark.streaming.dstream.{ DStream, InputDStream }
import org.apache.spark.streaming.{ Seconds, StreamingContext }

object SampleConsumer extends Serializable {

  val batchSeconds = 2 // Size of batch intervals
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[4]").setAppName("SampleConsumer")
    val ssc = new StreamingContext(sparkConf, Seconds(batchSeconds.toInt))
    val messages = ssc.socketTextStream("localhost", 9889)
    val words = messages.flatMap(_.split(","))
    words.print()
    val pairs = words.map(word => (word, 1))
    val wordsCount = pairs.reduceByKey(_ + _)
    wordsCount.print()

    // Start the computation
    println("Start streaming")
    ssc.start()
    // Wait for the computation to terminate
    ssc.awaitTermination()

  }

}