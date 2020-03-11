import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ChartEditor extends Application {
    static final String fxmlFilePath = "index.fxml";

    static final short sceneWidth = 1366;
    static final short sceneHeight = 768;

    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource(fxmlFilePath));

        stage.setScene(new Scene(parent, sceneWidth, sceneHeight));
        stage.setResizable(false);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}