package graphics;

import javafx.fxml.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextArea;
import javafx.scene.image.PixelWriter;
import model.DrawResult;
import model.TextResult;

import java.util.ArrayList;
import java.util.List;

public class Processor {
    @FXML
    Canvas drawingCanvas;

    @FXML
    TextArea textAreaEditor;
    @FXML
    TextArea textAreaErrors;

    public Processor() { }

    @FXML
    public void initialize() {
        Utils.drawCanvasGrid(drawingCanvas);

        drawingCanvas.setOnMouseClicked(event -> processEditorInput());
        textAreaEditor.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) {
                processEditorInput();
            }
        });
    }

    public void handleError(String output) {
        textAreaErrors.setText(output);
    }

    private void processEditorInput() {
        String editorInput = textAreaEditor.getText();

        List<DrawResult> resultSet = new ArrayList(); // TODO: text parser

        if (!resultSet.isEmpty()) {
            textAreaErrors.setText("");
        }

        GraphicsContext context = drawingCanvas.getGraphicsContext2D();

        context.clearRect(0, 0, drawingCanvas.getWidth(), drawingCanvas.getHeight());

        for (DrawResult result: resultSet) {
            if (result instanceof TextResult) {
                TextResult textResult = (TextResult)result;
                context.strokeText(textResult.getText(), textResult.getXCoordinate(), textResult.getYCoordinate());
            } else {
                PixelWriter pixelWriter = context.getPixelWriter();
                pixelWriter.setColor(result.getXCoordinate(), result.getYCoordinate(), result.getColor());
            }
        }
    }
}