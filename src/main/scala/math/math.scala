import scala.collection.mutable.ListBuffer

/**
  * Created by antoinesauray on 11/10/2017.
  */

package object math {

  type FloatVector = Array[Float]
  type FloatMatrix = Array[Array[Float]]

  type DoubleVector = List[Double]
  type DoubleMatrix = List[DoubleVector]

  def dotProductF(a: DoubleVector, b: DoubleVector): DoubleVector = {
    a.zip(b).map { t: (Double, Double) => t._1 * t._2 }
  }

  def dotProd(v1:DoubleVector,v2:DoubleVector) = {
    print(v1)
    print("   ")
    println(v2)
    v1.zip(v2).
      map { t: (Double, Double) => t._1 * t._2 }.sum
  }




  def transpose(m: DoubleMatrix): DoubleMatrix =
    if (m.head.isEmpty) Nil
    else m.map(_.head) :: transpose(m.map(_.tail))

  def mult(m1: DoubleMatrix, m2: DoubleMatrix) =
    for (m1row <- m1) yield
      for (m2col <- transpose(m2)) yield
        dotProd(m1row, m2col)

  def rowAt(m: DoubleMatrix, index: Int) =
    m.map(e => e(index))
}