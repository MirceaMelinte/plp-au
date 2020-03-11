import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChartEditor extends Application {
    static final String FXML_FILE_PATH = "index.fxml";

    static final short SCENE_WIDTH = 1366;
    static final short SCENE_HEIGHT = 768;

    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource(FXML_FILE_PATH));

        stage.setScene(new Scene(parent, SCENE_WIDTH, SCENE_HEIGHT));
        stage.setResizable(false);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}