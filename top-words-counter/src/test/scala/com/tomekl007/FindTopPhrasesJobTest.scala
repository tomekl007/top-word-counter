package com.tomekl007

import com.tomekl007.spark.SparkSuite
import org.scalatest.Matchers._

class FindTopPhrasesJobTest extends SparkSuite {
  override def appName: String = "top-words-phrases-test"

  test("should find top 2 phrases in given text input delimited by ;") {
    //given
    val inputText = spark.makeRDD(List("this;is;a;text;and;this;should;be;find;top;phrases;in;this;text"))

    //when
    val res = FindTopPhrasesJob.findTopPhrases(inputText, 2)

    //then
    res should contain theSameElementsAs List(
      ("this", 3),
      ("text", 2)
    )

  }


}
