package introduction

import cats.{Show, Eq}
import cats.implicits._
import introduction.PrintableLibrary.Printable

object UsingCats extends App {

  final case class Cat(name: String, age: Int, color: String)

  // implementation of Printable for Cat using Show from "Cats" instead of Printable
  implicit val catShow: Show[Cat] =
    new Show[Cat] {
      def show(cat: Cat): String = s"${cat.name} is a ${cat.age} year-old ${cat.color} cat."
    }

  implicit val catEq: Eq[Cat] =
    Eq.instance[Cat] { (cat1, cat2) =>
      (cat1.name == cat2.name) && (cat1.age == cat2.age) && (cat1.color == cat2.color)
    }

  val cat1 = Cat("Toto", 11, "red")
  println(cat1.show)

  val cat2 = Cat("Garfield",   38, "orange and black")
  val cat3 = Cat("Heathcliff", 33, "orange and black")

  println(s"cat2 and cat3 are equal: ${cat2 === cat3}")

  val optionCat1 = Option(cat2)
  val optionCat2 = Option.empty[Cat]

  println(s"optionCat1 and optionCat2 are equal: ${optionCat1 === optionCat2}")
}
