package ir.shahriari.periodictable;

import ir.shahriari.periodictable.ui.Group1;
import ir.shahriari.periodictable.ui.Group2;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
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
        var group1 = new Group1();
        var group2 = new Group2();

        var root = new HBox(.5, group1, group2);
        root.setPadding(new Insets(5));
        root.setStyle("-fx-background-color: white;");
        return root;
    }

    public static Main getInstance() {
        return instance;
    }
}
