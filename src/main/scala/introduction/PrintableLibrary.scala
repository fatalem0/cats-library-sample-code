package introduction

object PrintableLibrary extends App {

  // Define type class Printable[A] with a single method format
  trait Printable[A] {
    def format(value: A): String
  }

  // Create an object PrintableInstances containing instances of Printable for String and Int
  object PrintableInstances {
    implicit val printableString: Printable[String] = new Printable[String] {
      def format(value: String): String = value
    }

    implicit val printableInt: Printable[Int] = new Printable[Int] {
      def format(value: Int): String = value.toString
    }

    final case class Cat(name: String, age: Int, color: String)

    implicit val printableCat: Printable[Cat] = new Printable[Cat] {
      def format(cat: Cat) = {
        val name = Printable.format(cat.name)
        val age = Printable.format(cat.age)
        val color = Printable.format(cat.color)
        s"$name is a $age year-old $color cat."
      }
    }
  }

  // Define an object Printable with two generic interface methods
  object Printable {
    def format[A](value: A)(implicit printable: Printable[A]): String = printable.format(value)

    def print[A](value: A)(implicit printable: Printable[A]): Unit = println(format(value))
  }
}
