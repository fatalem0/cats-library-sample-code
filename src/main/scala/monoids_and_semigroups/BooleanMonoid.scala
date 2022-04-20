package monoids_and_semigroups

object BooleanMonoid {
  trait Semigroup[A] {
    def combine(a: A, b: A): A
  }

  trait Monoid[A] extends Semigroup[A] {
    def empty: A
  }

  object BooleanMonoidInstances {
    implicit val booleanAnd: Monoid[Boolean] = new Monoid[Boolean] {
      def combine(a: Boolean, b: Boolean): Boolean = a && b
      def empty: Boolean = true
    }

    implicit val booleanOr: Monoid[Boolean] = new Monoid[Boolean] {
      def combine(a: Boolean, b: Boolean): Boolean = a || b
      def empty: Boolean = false
    }

    implicit val booleanEither: Monoid[Boolean] = new Monoid[Boolean] {
      def combine(a: Boolean, b: Boolean): Boolean = (a && !b) || (!a && b)
      def empty: Boolean = false
    }

    implicit val booleanNor: Monoid[Boolean] = new Monoid[Boolean] {
      def combine(a: Boolean, b: Boolean): Boolean = (a || !b) && (!a || b)
      def empty: Boolean = true
    }
  }

  object Monoid {
    def apply[A](implicit monoid: Monoid[A]): Monoid[A] = monoid
  }
}
