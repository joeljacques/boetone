package boetone.tonality

import scala.math.{log10, pow, rint, floor, round}
import Intervals._

object Pitch {


  val standardPitch: Int = 440

  trait PitchClass {
    def pitch: Double
  }

  /**
   * represents a pitch class based on the "integer notation"
   * pitch is the specific pitch class with 0 = C and 1 = C#/Db
   */
  trait IntegerNotation extends PitchClass with Ordered[IntegerNotation] {
    def pitch: Double

    def inClass(frequency: Double): Boolean

    def octaveFreq(octave: Int): Double

  }
  // maybe not needed
  object IntegerNotation{
    implicit def ordering[A <: IntegerNotation]: Ordering[A] = (a: IntegerNotation, b: IntegerNotation) => a.pitch compare b.pitch
  }

  /**
   * Companion object for the pitch class representation for the 12 tone system
   */
  object TwelveTone {

    private val _names: Map[Double, String] = Map(0.0 -> "C", 1.0 -> "C#/Db", 2.0 -> "D", 3.0 -> "D#/Eb", 4.0 -> "E", 5.0 -> "F", 6.0 -> "F#/Gb",
      7.0 -> "G", 8.0 -> "G#/Ab", 9.0 -> "A", 10.0 -> "A#,Bb", 11.0 -> "B")

    def pitchName(pitch: Double): String = _names(rint(pitch))

    def apply(pitch: Double): TwelveTone = {
      new TwelveTone(pitch % 12)
    }

    /**
     * determines whether a note is in a given pitch Class or not
     *
     * @param frequency
     * @param pitch Pitch of the class. This should be a value mod 12. 0 would be C and 11 would be B/Cb
     * @return True if frequency is in pitch class, else false
     */
    def inPitchClass(frequency: Double, pitch: Double): Boolean = {
      rint(9 + 12 * (log10(frequency / standardPitch) / log10(2))) match {
        case a if a % 12 == pitch => true
        case _ => false
      }
    }

    /**
     * returns the frequency for the given octave of a pitch class. Middle C is C4 or c'
     *
     * @param pitch  pitch of the pitch class
     * @param octave the desired octave of the given pitch
     * @return frequency in Hz
     */
    def pitchOctaveFreq(pitch: Double, octave: Int): Double = {
      val newP = (pitch % 12) + (12 * (octave - 4)) // Pitch 0 would be C4
      pow(10, (log10(2) * ((newP - 9) / 12)) + log10(standardPitch))
    }

    /**
     * Returns the SpecificPitch with the given pitch right above the given SpecificPitch.
     * nextAbove(C4, A) would return A4 and nextAbove(A4, C) would return C5
     * @param basePitch
     * @param nextPitch
     * @return
     */
    def nextAbove(basePitch: SpecificPitch, nextPitch: Double): SpecificPitch = {
      val combined = basePitch.pitch + nextPitch
      val octave: Int = round(floor(combined/12).floatValue()) + basePitch.octave
      SpecificPitch(nextPitch, octave)
    }

    /**
     * Switches the Specific pitch with the one an octave below it and calls next Above
     * @param basePitch
     * @param nextPitch
     * @return
     */
    def nextBelow(basePitch: SpecificPitch, nextPitch: Double): SpecificPitch = {
      nextAbove(SpecificPitch(basePitch.pitch, basePitch.octave -1), nextPitch)
    }
  }

  /**
   * Representation for the chromatic scale
   *
   * @param pitch
   */
  case class TwelveTone(pitch: Double) extends IntegerNotation {

    import TwelveTone._

    def inClass(frequency: Double): Boolean = inPitchClass(frequency, pitch)

    def octaveFreq(octave: Int): Double = pitchOctaveFreq(pitch, octave)

    override def compare(that: IntegerNotation): Int = that.pitch compareTo pitch

    def apply(octave: Int): Double = octaveFreq(octave)

    def asName(): String = _names(rint(pitch))

    override def toString: String = s"pitch: $pitch, letter name: ${_names(rint(pitch))}"
  }

  case class SpecificPitch(pitch: Double, octave: Int) extends Ordered[SpecificPitch] {
    import TwelveTone.nextAbove
    override def compare(that: SpecificPitch): Int = {
      if (that.octave == octave) that.pitch compareTo pitch else that.octave compareTo octave
    }
    // because of this SpecificPitch is only defined for TwelveTone PitchSpace
  }

  object SpecificPitch{
  }
}
