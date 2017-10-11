package ml.nn

import activation._
import math.{DoubleMatrix, mult}

class Layer(weightsC: DoubleMatrix, activationC: Activation, nextC: Layer = null) {

  val weights: DoubleMatrix = weightsC
  val activation: Activation = activationC
  val next: Layer = nextC

  override def toString = s"Fully connected layer"
}

class NeuralNet(layersC: List[Layer]) {

  val layers : List[Layer] = layersC

  def forwardProp(X: DoubleMatrix, layer: Layer): DoubleMatrix = {
    if(layer.next != null) forwardProp(X=layer.activation(mult(layer.weights, List.fill(X.length)(1.0) :: X)), layer=layer.next)
    else layer.activation(mult(layer.weights, List.fill(X.length)(1.0) :: X))
  }

  def backwardProp(y: Double): Unit = {

  }

}