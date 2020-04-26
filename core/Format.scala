package core

import model._

object Format {
    def getCoordinateList(commandText: String): List[DrawResult] = commandText match {
        case Expressions.linePattern(lnX0: String, lnY0: String, lnX1: String, lnY1: String) =>
            val (argX0, argY0, argX1, argY1) = (lnX0.toInt, lnY0.toInt, lnX1.toInt, lnY1.toInt)

            Bresenham.generateLinePixels(argX0, argY0, argX1, argY1)

        case Expressions.rectanglePattern(rctX0: String, rctY0: String, rctX1: String, rctY1: String) =>
            val (argX0, argY0, argX1, argY1) = (rctX0.toInt, rctY0.toInt, rctX1.toInt, rctY1.toInt)

            Bresenham.generateLinePixels(argX0, argY0, argX1, argY0) :::
                Bresenham.generateLinePixels(argX0, argY1, argX1, argY1) :::
                Bresenham.generateLinePixels(argX0, argY0, argX0, argY1) :::
                Bresenham.generateLinePixels(argX1, argY0, argX1, argY1)

        case Expressions.circlePattern(circleX: String, circleY: String, circleRadius: String) =>
            val (argX, argY, argRad) = (circleX.toInt, circleY.toInt, circleRadius.toInt)

            Midpoint.generateCirclePixels(argX, argY, argRad)

        case Expressions.textPattern(textX: String, textY: String, strText: String) =>
            val (argX, argY, argText) = (textX.toInt, textY.toInt, strText)
            List[TextResult](new TextResult(argX, argY, "#000000", argText))

        case Expressions.drawPattern(color: String, commandText: String) =>
            Draw.generateColoredPixels(color, getCoordinateList(commandText))

        case Expressions.fillPattern(color: String, obj: String) =>
            Fill.generateColoredPixelsRecursive(color, getCoordinateList(obj), List[DrawResult]())

        case _ => throw new NoSuchElementException(commandText)
    }
}