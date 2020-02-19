package boetone.Sound

import boetone.Sound.Pitch.TwelveTone

object Main extends App {
  val a: TwelveTone = TwelveTone(0)
  println(a(4).toString)
  val cmaj: DiatonicScale = DiatonicScale.fromMode(Mode.Ionian, 0)
  println(cmaj)

}
