package boetone.tonality

import boetone.tonality.Pitch.{SpecificPitch, TwelveTone}
import TwelveTone.nextAbove
import boetone.tonality.Intervals.Interval

class Chord(pPitches: Double*) {
  val pitches: Seq[Double] = pPitches


  def forOctave(octave: Int): Seq[SpecificPitch] = {
    pitches.drop(1).scanLeft(SpecificPitch(pitches.head, octave))((sp, pitch) => nextAbove(sp, pitch))
  }

  def apply(octave: Int): Seq[SpecificPitch] = forOctave(octave)

  def +(interval: Interval): Chord = new Chord(pitches :+ pitches.head + interval.semitones : _*)
}

object Chord {
  def inverse(chord: Chord): Chord= {
    new Chord(chord.pitches.drop(1) :+ chord.pitches.head :_*)
  }
}

