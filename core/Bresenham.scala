package core

import model.DrawResult

object Bresenham {
    def generateLinePixels(x0: Int, y0: Int, x1: Int, y1: Int): List[DrawResult] = {
        val defaultColor = "#000000"

        val (a0, a1, b0, b1) = (0, x1 - x0, 0, y1 - y0)

        if (b1 > a1) {
            addLinePixelsRecursive(List[DrawResult](), 2 * a1 - b1, b1, a1, a0, b0, b1, a1, defaultColor)
                .map(drawResult =>
                    new DrawResult(drawResult.getYCoordinate() + x0, drawResult.getXCoordinate() + y0, defaultColor))
        } else {
            addLinePixelsRecursive(List[DrawResult](), 2 * b1 - a1, a1, b1, a0, b0, a1, b1, defaultColor)
                .map(drawResult =>
                    new DrawResult(drawResult.getXCoordinate() + x0, drawResult.getYCoordinate() + y0, defaultColor))
        }
    }

    def addLinePixelsRecursive(resultList: List[DrawResult],
                                   delta: Int,
                                   deltaX: Int,
                                   deltaY: Int,
                                   x0: Int,
                                   y0: Int,
                                   x1: Int,
                                   y1: Int,
                                   defaultColor: String): List[DrawResult] = {
        if (x0 == x1) {
            new DrawResult(x0, y1, defaultColor) :: resultList
        } else if (delta > 0) {
            addLinePixelsRecursive(
                new DrawResult(x0, y0, defaultColor) :: resultList,
                delta - 2 * deltaX + 2 * deltaY,
                deltaX,
                deltaY,
                x0 + 1,
                y0 + 1,
                x1,
                y1,
                defaultColor)
        } else {
            addLinePixelsRecursive(
                new DrawResult(x0, y0, defaultColor) :: resultList,
                delta + 2 * deltaY,
                deltaX,
                deltaY,
                x0 + 1,
                y0,
                x1,
                y1,
                defaultColor)
        }
    }
}