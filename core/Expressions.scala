package core

object Expressions {
    val newLineEscape = "\n"
    val specialCharsExcept = s"""[^\\w\\sa-zA-Z0-9"_,-.()?!%#]"""

    // Command regular expression patterns
    val linePattern = """\(LINE\s\((\d+)\s([0-9]+)\)\s\(([0-9]+)\s([0-9]+)\)\)""".r
    val rectanglePattern = """\(RECTANGLE\s\(([0-9]+)\s([0-9]+)\)\s\(([0-9]+)\s([0-9]+)\)\)""".r
    val circlePattern = """\(CIRCLE\s\(([0-9]+)\s([0-9]+)\)\s([0-9]+)\)""".r
    val textPattern = """\(TEXT-AT\s\(([0-9]+)\s([0-9]+)\)\s\"([\s\S]+)\"\)""".r
    val boxPattern = """\(BOUNDING-BOX\s\((\d+)\s([0-9]+)\)\s\(([0-9]+)\s([0-9]+)\)\)""".r
    val drawPattern = """\(DRAW\s(#[A-F0-9]{6})\s([\s\S]+)\)""".r
    val fillPattern = """\(FILL\s(#[A-F0-9]{6})\s([\s\S]+)\)""".r
}