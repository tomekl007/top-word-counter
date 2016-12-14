package com.tomekl007

import com.tomekl007.spark.SparkContextInitializer
import org.apache.spark.rdd.RDD


object FindTopPhrasesJob {
  private val NumberOfTopPhrases: Int = 10

  def main(args: Array[String]) {

    val sparkContext = SparkContextInitializer.createSparkContext("find-top-phrases")
    val textFile = sparkContext.textFile("pathToFile")
    val result = findTopPhrases(textFile, NumberOfTopPhrases)

  }

  def findTopPhrases(textFile: RDD[String], numberOfTopPhrases: Int): List[(String, Int)] = {
    textFile
      .flatMap(_.split(";"))
      .map(_.toLowerCase)
      .map(phrase => (phrase, 1))
      .reduceByKey(_ + _)
      .takeOrdered(numberOfTopPhrases)(Ordering[Int].reverse.on(x => x._2))
      .toList
  }
}
