package ir.shahriari.periodictable;

import ir.shahriari.periodictable.ui.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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
        primaryStage.setScene(new Scene(createContent(), 900, 700));
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

        var root = new ScrollPane(gridPane);
        root.setFitToWidth(true);
        root.setFitToHeight(true);

        return root;
    }

    public static Main getInstance() {
        return instance;
    }
}
