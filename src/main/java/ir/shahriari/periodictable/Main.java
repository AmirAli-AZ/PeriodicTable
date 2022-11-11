package ir.shahriari.periodictable;

import ir.shahriari.periodictable.ui.*;
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

import java.util.Objects;

public class Main extends Application {

    private static Main instance;

    public Main() {
        instance = this;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("PeriodicTable");
        var scene = new Scene(createContent(), 900, 700);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("themes/light-theme.css")).toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Parent createContent() {
        var gridPane = new GridPane();
        gridPane.setHgap(.5);
        gridPane.setVgap(.5);
        gridPane.setPadding(new Insets(5));

        new Group1(gridPane);
        new Group2(gridPane);
        new Group3(gridPane);
        new Group4(gridPane);
        new Group5(gridPane);
        new Group6(gridPane);
        new Group7(gridPane);

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

    public static Main getInstance() {
        return instance;
    }
}
