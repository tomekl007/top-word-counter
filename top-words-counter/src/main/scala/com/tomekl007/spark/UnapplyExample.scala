package com.tomekl007.spark

import scala.annotation.tailrec

case class CustomList[T](values: T*)

object CustomList {

  def unapply[A](list: CustomList[A]): Option[(A, Seq[A])] =
    if (list.values.size < 2) None
    else Some((list.values.head, list.values.tail.toList))
}

object UnapplyExample {
  def main(args: Array[String]): Unit = {

    val customList = CustomList("1","2", "3")
    decompose(customList)
  }

  @tailrec
  def decompose[A](customList: CustomList[A]): CustomList[A] = {
    customList match {
      case CustomList(head, rest) => println(s"value: $head, rest: $rest"); decompose(CustomList(rest.toList.head))
    }
  }
}
