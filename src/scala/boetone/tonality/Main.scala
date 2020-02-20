package boetone.tonality

import boetone.tonality.Pitch.TwelveTone

object Main extends App {
  val a: TwelveTone = TwelveTone(0)
  println(a(4).toString)
  val cmaj: DiatonicScale = DiatonicScale.fromMode(Mode.Ionian, 0)
  println(cmaj)
  println(TwelveTone.pitchOctaveFreq(0.0, 4))
}
