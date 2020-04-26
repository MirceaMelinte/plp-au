package core

import model._
import scala.collection.JavaConverters._

object Interpreter {
    def translateCommandText(cmdText: String, errorCallback: String => Unit): java.util.List[DrawResult] = {
        try {
            val (boundingBoxCommand, shapeCommands) =
                cmdText
                    .replaceAll(Expressions.specialCharsExcept, "")
                    .split(Expressions.newLineEscape, 2) match {

                case Array(boundingBoxCmdText, shapeCmdText) =>
                    (boundingBoxCmdText, shapeCmdText.split(Expressions.newLineEscape))
            }

            shapeCommands
                .map((commandText: String) => Format.getCoordinateList(commandText))
                .reduce((left, right) => left:::right)
                .filter(drawResult => clipOutOfBoundsDrawings(drawResult, boundingBoxCommand))
                .asJava
        } catch {
            case ex: NoSuchElementException =>
                errorCallback("Syntax error(s) have been found in the following line/command:\n" + ex.getMessage())
                List[DrawResult]().asJava
        }
    }

    def clipOutOfBoundsDrawings(drawResult: DrawResult, boundingBoxCommand: String): Boolean = {
        val Expressions.boxPattern(bbX0, bbY0, bbX1, bbY1) = boundingBoxCommand

        drawResult.getXCoordinate() <= bbX1.toInt &&
            drawResult.getXCoordinate() >= bbX0.toInt &&
            drawResult.getYCoordinate() <= bbY1.toInt &&
            drawResult.getYCoordinate() >= bbY0.toInt
    }
}