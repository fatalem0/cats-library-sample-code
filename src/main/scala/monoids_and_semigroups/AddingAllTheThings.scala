package monoids_and_semigroups

import cats.Monoid
import cats.instances.int._
import cats.instances.option._
import cats.syntax.semigroup._

object AddingAllTheThings extends App {
  def addWithoutCats(items: List[Int]): Int = items.sum

  def addWithCats(items: List[Int]): Int = items.foldLeft(Monoid[Int].empty)(_ |+| _)

  def addOptions(items: List[Option[Int]]): Option[Int] = {
    items.foldLeft(Monoid.empty[Option[Int]])(_ |+| _)
  }

  case class Order(totalCost: Double, quantity: Double)

  implicit val monoidOrder: Monoid[Order] = new Monoid[Order] {
    def combine(order1: Order, order2: Order): Order = {
      Order(
        order1.totalCost + order2.totalCost,
        order1.quantity + order2.quantity
      )
    }

    def empty: Order = Order(0, 0)
  }

  println(addWithoutCats(List(1, 2, 3)))
  println(addWithCats(List(1, 2, 3)))
  println(addOptions(List(Some(1), None, Some(2))))
}
