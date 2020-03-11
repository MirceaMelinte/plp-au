package graphics;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Utils {
    protected static void drawCanvasGrid(Canvas drawingCanvas) {
        GraphicsContext graphicsContext = drawingCanvas.getGraphicsContext2D();
        graphicsContext.setLineWidth(0.2f);

        for (int x = 0; x < 900; x += 30) {
            double x1 = x;

            graphicsContext.moveTo(x1, 0);
            graphicsContext.lineTo(x1, 750);
        }

        for (int y = 0; y < 750; y += 30) {
            double y1 = y;

            graphicsContext.moveTo(0, y1);
            graphicsContext.lineTo(900, y1);
        }

        graphicsContext.stroke();
    }
}