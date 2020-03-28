package graphics;

import core.Interpreter;
import javafx.fxml.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextArea;
import javafx.scene.image.PixelWriter;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.List;
import model.DrawResult;
import model.TextResult;

public class ViewModel {
    @FXML
    Canvas drawingCanvas;
    @FXML
    TextArea textAreaEditor;
    @FXML
    TextArea textAreaErrors;

    static final KeyCombination keyShiftTab = new KeyCodeCombination(KeyCode.F, KeyCombination.CONTROL_ANY);

    public ViewModel() { }

    @FXML
    public void initialize() {
        Utils.drawCanvasGrid(drawingCanvas);

        textAreaErrors.setText("Tip: Use the CTRL+F key combination for parsing the command input from the editor.");

        textAreaEditor.addEventFilter(KeyEvent.KEY_RELEASED, keyEvent -> {
            if (keyShiftTab.match(keyEvent)) {
                processEditorInput();
            }
        });
    }

    private void processEditorInput() {
        String editorInput = textAreaEditor.getText();

        List<DrawResult> resultSet;
        resultSet = Interpreter.translateCommandText(
            editorInput,
            (String errorText) -> {
                textAreaErrors.setText(errorText);
                return null;
            });

        if (!resultSet.isEmpty()) {
            textAreaErrors.setText("");
        }

        GraphicsContext context = drawingCanvas.getGraphicsContext2D();

        context.clearRect(0, 0, drawingCanvas.getWidth(), drawingCanvas.getHeight());
        Utils.drawCanvasGrid(drawingCanvas);

        for (DrawResult result: resultSet) {
            if (result instanceof TextResult) {
                TextResult textResult = (TextResult)result;

                context.setFont(Font.font(20D));
                context.fillText(textResult.getText(), textResult.getXCoordinate(), textResult.getYCoordinate());
            } else {
                PixelWriter pixelWriter = context.getPixelWriter();
                pixelWriter.setColor(result.getXCoordinate(), result.getYCoordinate(), Color.web(result.getColor(), 1D));
            }
        }
    }
}