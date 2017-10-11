import activation.sigmoid
import ml.nn.{Layer, NeuralNet}

/**
  * Created by antoinesauray on 11/10/2017.
  */

object Main {

  def main(args: Array[String]) {

    // 1.0 at the beginning for the bias
    val f1 = List(0.5, 0.8)
    val f2 = List(1.0, 0.2)

    val X = List(
      f1, f2
    )

    val l2 = new Layer(List(
      List(0.5, 0.1, 0.2)
    ), sigmoid, null)


    val l1 = new Layer(List(
      List(1.5, 0.2, 0.1),
      List(2.0, 0.3, 0.5)
    ), sigmoid, l2)

    val layers = List(l1,l2)
    val nn = new NeuralNet(layers)
    val result = nn.forwardProp(X, layers.head)
  }
}


