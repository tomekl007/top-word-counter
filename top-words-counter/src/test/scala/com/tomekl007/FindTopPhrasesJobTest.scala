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

  test("should find top 2 phrases in given text input delimited by ; case-insensitive") {
    //given
    val inputText = spark.makeRDD(List("this;is;a;TeXt;and;this;should;be;find;top;phrases;in;THIS;TexT"))

    //when
    val res = FindTopPhrasesJob.findTopPhrases(inputText, 2)

    //then
    res should contain theSameElementsAs List(
      ("this", 3),
      ("text", 2)
    )
  }

  test("should find top 2 phrases in given text input delimited by characters other than a-z, A-Z, 0-9") {
    //given
    val inputText = spark.makeRDD(List("this;is+a?TeXt!and this:should)be(find&top^phrases_in\nTHIS*TexT"))

    //when
    val res = FindTopPhrasesJob.findTopPhrases(inputText, 2)

    //then
    res should contain theSameElementsAs List(
      ("this", 3),
      ("text", 2)
    )
  }

}
