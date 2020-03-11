package graphics;

import javafx.fxml.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextArea;

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

        textAreaEditor.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) {
                processEditorInput();
            }
        });
    }

    private void processEditorInput() {

    }
}