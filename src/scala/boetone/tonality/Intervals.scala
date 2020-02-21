package boetone.tonality

object Intervals {
  trait Interval{
    def semitones: Int
  }

  trait Third

  object P1 extends Interval {
    override def semitones: Int = 0
  }

  object m2 extends Interval {
    override def semitones: Int = 1
  }

  object M2 extends Interval {
    override def semitones: Int = 2
  }

  object m3 extends Interval with Third {
    override def semitones: Int = 3
  }

  object M3 extends Interval with Third {
    override def semitones: Int = 4
  }

  object P4 extends Interval {
    override def semitones: Int = 5
  }

  object d5 extends Interval {
    override def semitones: Int = 6
  }

  object A4 extends Interval {
    override def semitones: Int = 6
  }

  object P5 extends Interval {
    override def semitones: Int = 7
  }

  object m6 extends Interval {
    override def semitones: Int = 8
  }

  object M6 extends Interval {
    override def semitones: Int = 9
  }

  object m7 extends Interval {
    override def semitones: Int = 10
  }

  object M7 extends Interval {
    override def semitones: Int = 11
  }

  object P8 extends Interval {
    override def semitones: Int = 12
  }

}
