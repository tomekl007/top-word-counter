package com.tomekl007.spark

import org.apache.spark.{SparkContext, SparkConf}


object SparkContextInitializer {

  def createSparkContext(name: String) = {
    val sc: SparkConf = basicSparkConf(name)
    new SparkContext(sc)
  }

  def basicSparkConf(name: String): SparkConf = {
    new SparkConf()
      .setAppName(name)
      .set("spark.io.compression.codec", "lzf")
      .set("spark.speculation", "true")

  }
}
