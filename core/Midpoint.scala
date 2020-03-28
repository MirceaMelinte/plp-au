package core

import model.DrawResult

object Midpoint {
    def generateCirclePixels(x: Int, y: Int, radius: Int): List[DrawResult] = {
        val defaultColor = "#000000"

        val (deltaX, deltaY, offset) = (1, -2 * radius, 1 - radius)

        val initialPixels = List[DrawResult](
            new DrawResult(x, y + radius, defaultColor),
            new DrawResult(x, y - radius, defaultColor),
            new DrawResult(x + radius, y, defaultColor),
            new DrawResult(x - radius, y, defaultColor))

        addOuterCirclePixelsRecursive(initialPixels, deltaX, deltaY, offset, 0, radius, x, y, defaultColor)
    }

    def addOuterCirclePixelsRecursive(resultList: List[DrawResult],
                                          deltaX: Int,
                                          deltaY: Int,
                                          offset: Int,
                                          offsetX: Int,
                                          offsetY: Int,
                                          x: Int,
                                          y: Int,
                                          defaultColor: String): List[DrawResult] = {
        val mainOuterPixels =
            new DrawResult(x + offsetX, y + offsetY, defaultColor) ::
            new DrawResult(x - offsetX, y + offsetY, defaultColor) ::
            new DrawResult(x + offsetX, y - offsetY, defaultColor) ::
            new DrawResult(x - offsetX, y - offsetY, defaultColor) ::
            new DrawResult(x + offsetY, y + offsetX, defaultColor) ::
            new DrawResult(x - offsetY, y + offsetX, defaultColor) ::
            new DrawResult(x + offsetY, y - offsetX, defaultColor) ::
            new DrawResult(x - offsetY, y - offsetX, defaultColor) ::
            resultList

        if (offsetX >= offsetY) {
            mainOuterPixels
        } else if (offset >= 0) {
            addOuterCirclePixelsRecursive(
                mainOuterPixels,
                deltaX + 2,
                deltaY + 2,
                offset + deltaX + 2 + deltaY + 2,
                offsetX + 1,
                offsetY - 1,
                x,
                y,
                defaultColor)
        } else {
            addOuterCirclePixelsRecursive(
                mainOuterPixels,
                deltaX + 2,
                deltaY,
                offset + deltaX,
                offsetX + 1,
                offsetY,
                x,
                y,
                defaultColor)
        }
    }
}