package ir.shahriari.periodictable;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.ui.ElementNode;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.json.JSONArray;

import java.io.BufferedReader;
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

        var headerTitle = new Label("Periodic Table");
        headerTitle.setId("header-title");
        var headerBox = new HBox(headerTitle);
        headerBox.setId("header-box");
        headerBox.setAlignment(Pos.CENTER);
        headerBox.setPadding(new Insets(10));

        var root = new VBox(3, headerBox, scrollPane);
        root.setId("root");

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
}
