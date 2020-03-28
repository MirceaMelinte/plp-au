package core

import model.DrawResult

object Fill {
    def generateColoredPixelsRecursive(color: String, objects: List[DrawResult], accumulator: List[DrawResult]): List[DrawResult] = objects match {
        case Nil => accumulator
        case x::xs => {
            val pixel = findPixelByCoordinates(x, xs)

            if (pixel == None) {
                generateColoredPixelsRecursive(color, xs, accumulator)
            } else {
                val linePixels = Bresenham
                    .generateLinePixels(
                        x.getXCoordinate(),
                        x.getYCoordinate(),
                        pixel.get.getXCoordinate(),
                        pixel.get.getYCoordinate())
                    .map(result => new DrawResult(result.getXCoordinate(), result.getYCoordinate(), color))

                generateColoredPixelsRecursive(color, xs, accumulator ::: linePixels)
            }
        }
    }

    def findPixelByCoordinates(currentObject: DrawResult, objectList: List[DrawResult]): Option[DrawResult] = objectList match {
        case Nil => None
        case x::xs =>
            if (x.getXCoordinate() != currentObject.getXCoordinate() &&
                x.getYCoordinate() == currentObject.getYCoordinate()) Option(x)
            else findPixelByCoordinates(currentObject, xs)
    }
}