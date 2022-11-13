package ir.shahriari.periodictable;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.ui.ElementNode;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.json.JSONArray;

import javax.imageio.ImageIO;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main extends Application {

    private static Main instance;

    public Main() {
        instance = this;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("PeriodicTable");
        var scene = new Scene(createContent());
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("themes/light-theme.css")).toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    private Parent createContent() {
        var root = new BorderPane();
        root.setId("root");

        var gridPane = new GridPane();
        gridPane.setHgap(.5);
        gridPane.setVgap(.5);
        gridPane.setPadding(new Insets(5));
        gridPane.setAlignment(Pos.CENTER);

        try {
            addElements(gridPane);
        } catch (IOException e) {
            e.printStackTrace();
        }

        var scrollPane = new ScrollPane(gridPane);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        root.setCenter(scrollPane);

        var snapShotMenuItem = new MenuItem("SnapShot");
        snapShotMenuItem.setOnAction(actionEvent -> takeSnapShot(gridPane));
        snapShotMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
        var fileMenu = new Menu("File");
        fileMenu.getItems().add(snapShotMenuItem);
        var menuBar = new MenuBar(fileMenu);

        root.setTop(menuBar);

        return root;
    }

    private void addElements(GridPane gridPane) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("periodic-table.json"))));
        var stringBuilder = new StringBuilder();
        String line;
        do {
            line = reader.readLine();
            stringBuilder.append(line);
        } while (line != null);

        var jsonArray = new JSONArray(stringBuilder.toString());
        for (int i = 0; i < jsonArray.length(); i++) {
            var jsonObject = jsonArray.getJSONObject(i);

            var elementNode = new ElementNode(
                    new Element(
                            jsonObject.getString("name"),
                            jsonObject.getString("symbol"),
                            jsonObject.getInt("number"),
                            jsonObject.getDouble("atomic_mass"),
                            jsonObject.getInt("group"),
                            jsonObject.getInt("period"),
                            jsonObject.getString("block"),
                            jsonObject.getString("source"),
                            jsonObject.getString("summary")
                    )
            );
            GridPane.setConstraints(elementNode, jsonObject.getInt("xpos") - 1, jsonObject.getInt("ypos") - 1);

            gridPane.getChildren().add(elementNode);
        }
    }

    private void takeSnapShot(GridPane gridPane) {
        var snapShot = gridPane.snapshot(null, null);
        var bufferedSnapShot = SwingFXUtils.fromFXImage(snapShot, null);

        var fileChooser = new FileChooser();
        fileChooser.setTitle("Save SnapShot");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.setInitialFileName("periodic-table.png");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG Files", "*.png"));
        var file = fileChooser.showSaveDialog(gridPane.getScene().getWindow());

        if (file != null) {
            var filename = file.getName();
            var extension = filename.substring(filename.lastIndexOf('.') + 1);

            try {
                ImageIO.write(bufferedSnapShot, extension, file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
