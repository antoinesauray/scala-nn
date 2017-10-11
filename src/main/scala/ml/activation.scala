import math.{DoubleMatrix}

import scala.math._

/**
  * Created by antoinesauray on 11/10/2017.
  */

package object activation {

  type Activation = (DoubleMatrix) => DoubleMatrix

  def sigmoid(Z: DoubleMatrix) = {
    Z.map(c => c.map(r => 1.0f / 1.0f + exp(-r)))
  }

}

