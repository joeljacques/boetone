package boetone.Sound

import boetone.Sound.Pitch.TwelveTone

object Main extends App {
  val a = TwelveTone.fromPitch(0)
  println(a.octaveFreq(4).toString)
}
