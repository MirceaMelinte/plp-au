package core

import model.DrawResult

object Draw {
    def generateColoredPixels(color: String, objects: List[DrawResult]): List[DrawResult] =
        objects.map(x => new DrawResult(x.getXCoordinate(), x.getYCoordinate(), color))
}