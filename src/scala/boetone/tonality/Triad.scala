package boetone.tonality

import boetone.tonality.Intervals.Third
import boetone.tonality.Pitch.SpecificPitch

class Triad(first: Double, second: Double, third: Double) extends Chord(Seq(first,second,third): _*){
  def first: Double = pitches.head
  def second: Double = pitches(1)
  def third: Double = pitches(2)
}

object Triad{
  def major(basePitch: Double): Triad = {
    new Triad(basePitch, basePitch + 4.0, basePitch + 7.0)
  }
  def minor(basePitch: Double): Triad = {
    new Triad(basePitch, basePitch + 3.0, basePitch + 7.0)
  }
}
