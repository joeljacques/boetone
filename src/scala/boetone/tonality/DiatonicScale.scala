package boetone.tonality

import boetone.tonality.Mode.GregorianMode
import boetone.tonality.Pitch.TwelveTone

/**
 * Represents all diatonic scales (right now only gregorian modes are defined).
 * the primary constructor shouldn't be used. Use 'fromMode'
 * @param elems
 */
class DiatonicScale(elems: Seq[TwelveTone], keyPitch: Int) extends PitchSpace[TwelveTone](elems){
  override def toString: String = "Diatonic Space: " ++ elems.foldLeft("[")((str, tt) => f"${str} (${tt.toString}),").dropRight(1) ++ " ]"
}

object DiatonicScale{
  /**
   * DiatonicScale Factory for given modes.
   * @param mode diatonic mode (would technically work with any mode)
   * @param keyPitch pitch compatible with the twelvetone integer notation (0 to 11)
   * @return
   */
  def fromMode(mode: GregorianMode, keyPitch: Int): DiatonicScale = {
    val elems: Seq[TwelveTone] = mode.semitones.scanLeft(TwelveTone(keyPitch))((tt, num)=> TwelveTone(tt.pitch + num))
    new DiatonicScale(elems, keyPitch)
  }
}
