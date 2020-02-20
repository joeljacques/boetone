package boetone.tonality

import boetone.tonality.Pitch.IntegerNotation

/**
 * defines a pitch space containing pitch classes
 * @param elems Sequence of pitch classes
 * @tparam A class that can represent pitch classes
 */
class PitchSpace[A <: IntegerNotation](elems: Seq[A]) {
  val length: Int = elems.size

  def apply(step: Int): IntegerNotation= {
    elems(step % elems.size)
  }

}

object PitchSpace{
  def apply[A<:IntegerNotation](elems: A*): PitchSpace[A] = {
    new PitchSpace[A](Seq(elems: _*).sorted)
  }
}
