package ml.nn

import activation._
import error.ErrorFunction
import math.{DoubleMatrix, mult}

class Layer(weightsC: DoubleMatrix, activationC: Activation, nextC: Layer = null) {

  val weights: DoubleMatrix = weightsC
  val activation: Activation = activationC
  val next: Layer = nextC
  var prev: Layer = _

  override def toString = s"Fully connected layer"
}

class NeuralNet(layersC: List[Layer], errorFunctionC: ErrorFunction) {

  val layers : List[Layer] = layersC
  var errorFunction : ErrorFunction = errorFunctionC

  var prevTmp = layers.head

  /*
    Set previous layer
   */
  layers.foreach(layer =>
    if(prevTmp != layer){layer.prev = prevTmp; prevTmp = layer}
  )

  def train(X: DoubleMatrix, y: DoubleMatrix) = {
    val (layer, fpass) = forwardProp(X, layers.head)
    val err = errorFunction(fpass, y)
    println(s"error: $err")
    backwardProp(err, layer)
  }

  def forwardProp(X: DoubleMatrix, layer: Layer): (Layer, DoubleMatrix) = {
    // add the bias with fill
    if(layer.next != null) forwardProp(X=layer.activation(mult(layer.weights, List.fill(X.length)(1.0) :: X)), layer=layer.next)
    else (layer, layer.activation(mult(layer.weights, List.fill(X.length)(1.0) :: X)))
  }

  def backwardProp(err: Double, lastLayer: Layer): Unit = {
    var layer = lastLayer
    do{
        println("layer back")
      layer = layer.prev
    } while(layer.prev != null)
  }

}