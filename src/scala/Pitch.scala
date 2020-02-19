package boetone.Sound

import scala.math.{log10, rint, pow}

object Pitch {

  val standardPitch: Int = 440

  trait PitchClass {
  }
  /**
   * represents a pitch class based on the "integer notation"
   * pitch is the specific pitch class with 0 = C and 1 = C#/Db
   */
  trait IntegerNotation extends PitchClass {
    def pitch: Double
    def inClass(frequency: Double): Boolean
    def octaveFreq(octave: Int): Double
  }

  /**
   * Companion object for the pitch class representation for the 12 tone system
   */
  object TwelveTone{
    def fromPitch(pitch: Int): IntegerNotation = {
      TwelveTone(pitch)
    }

    /**
     * determines whether a note is in a given pitch Class or not
     * @param frequency
     * @param pitch Pitch of the class. This should be a value mod 12. 0 would be C and 11 would be B/Cb
     * @return True if frequency is in pitch class, else false
     */
    def inPitchClass(frequency: Double, pitch: Double): Boolean = {
      rint(9 + 12 * (log10(frequency/standardPitch) / log10(2))) match {
        case a if a % 12 == pitch => true
        case _ => false
      }
    }

    /**
     * returns the frequency for the given octave of a pitch class. Middle C is C4 or c'
     * @param pitch pitch of the pitch class
     * @param octave the desired octave of the given pitch
     * @return frequency in Hz
     */
    def pitchOctaveFreq(pitch: Double, octave: Int): Double = {
      val newP = (pitch % 12) + (12*(octave-4)) // Pitch 0 would be C4
      // somehow 0.0 behaves as if it were 1.0 ????
      newP match {
        case 0.0 => pow(10, (log10(2) * ( (0 - 9) / 12)) + log10(standardPitch))
        case num => pow(10, (log10(2) * ( (num - 9) / 12)) + log10(standardPitch))
      }
    }
  }

  /**
   * Representation for the chromatic scale
   * @param pitch
   */
  case class TwelveTone(pitch: Double) extends IntegerNotation {
    import TwelveTone._
    def inClass(frequency: Double): Boolean = inPitchClass(frequency, pitch)
    def octaveFreq(octave: Int): Double = pitchOctaveFreq(pitch, octave)
  }

  case class SemiTone(octave: Double,
                  pitchClass: TwelveTone)
}
