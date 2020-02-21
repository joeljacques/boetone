package boetone.tonality

import boetone.tonality.Pitch.TwelveTone
import TwelveTone.pitchName

object Main extends App {
  val base = 3.0
  var triad = Triad.major(4.0)
  println(f"${pitchName(base)} Major triad consists of ${pitchName(triad.first)}, ${pitchName(triad.second)} and ${pitchName(triad.third)}")
  triad = Triad.minor(4.0)
  println(f"${pitchName(base)} Minor triad consists of ${pitchName(triad.first)}, ${pitchName(triad.second)} and ${pitchName(triad.third)}")
}
