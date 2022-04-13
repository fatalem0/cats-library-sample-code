package introduction

import introduction.PrintableLibrary.Printable
import introduction.PrintableLibrary.PrintableInstances._
import introduction.PrintableSyntax.PrintOps

object UsingTheLibrary extends App {
  val cat = Cat("Charlie", 10, "white")

  // interface object approach
  Printable.print(cat)

  // interface syntax approach
  Cat("Toto", 9, "black").print
}
