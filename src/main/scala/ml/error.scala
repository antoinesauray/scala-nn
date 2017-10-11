/**
  * Created by antoinesauray on 11/10/2017.
  */

import math.DoubleMatrix

package object error {

  type ErrorFunction = (DoubleMatrix, DoubleMatrix) => Double

  /**
    *
    * Mean Squared Error (MSE)
    * @param predictions
    * @param targets
    * @return the error
    */
  def mse(predictions: DoubleMatrix, targets: DoubleMatrix): Double =
    scala.math.pow(predictions.zip(targets).map{ r: (List[Double], List[Double]) =>
      r._1.sum - r._2.sum
    }.sum, 2)
}
