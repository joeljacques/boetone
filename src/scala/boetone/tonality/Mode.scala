package boetone.tonality

/**
 * Provides build tools for scales and pitch spaces
 */
object Mode {

  sealed trait GregorianMode{
    def semitones: Seq[Int]
  }

  trait MajorScale extends GregorianMode
  trait MinorScale extends GregorianMode

  case object Ionian extends MajorScale {
    def semitones = Seq(2, 2, 1, 2, 2, 2, 1)
  }

  case object Aeolian extends MinorScale {
    def semitones = Seq(2, 1, 2, 2, 1, 2, 2)
  }

  case object Dorian extends GregorianMode {
    def semitones = Seq(2, 1, 2, 2, 2, 1, 2)
  }

  case object Phrygian extends GregorianMode {
    def semitones = Seq(1, 2, 2, 2 ,1 ,2 ,2)
  }

  case object Lydian extends GregorianMode {
    def semitones = Seq(2, 2, 2, 1, 2, 2, 1)
  }

  case object Mixolydian extends GregorianMode {
    def semitones = Seq(2, 2, 1, 2, 2, 1, 2)
  }

  case object Locrian extends GregorianMode {
    def semitones = Seq(1, 2, 2, 1, 2, 2, 2)
  }
  /*
  val modes: Map[String, Seq[Int]] = Map("ionian" -> Seq(2, 2, 1, 2, 2, 2, 1),
                                      "dorian" -> Seq(2, 1, 2, 2, 2, 1, 2),
                                      "phrygian" -> Seq(1, 2, 2, 2 ,1 ,2 ,2),
                                      "lydian" -> Seq(2, 2, 2, 1, 2, 2, 1),
                                      "mixolydian" -> Seq(2, 2, 1, 2, 2, 1, 2),
                                      "aeolian" -> Seq(2, 1, 2, 2, 1, 2, 2),
                                      "locrian" -> Seq(1, 2, 2, 1, 2, 2, 2))*/

}
