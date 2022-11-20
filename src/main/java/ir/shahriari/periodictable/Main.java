package ir.shahriari.periodictable;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.ui.ElementNode;
import ir.shahriari.periodictable.ui.PlaceHolder;
import ir.shahriari.periodictable.utils.Theme;
import ir.shahriari.periodictable.utils.ThemeManger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
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
        ThemeManger.setTheme(scene, ThemeManger.load());
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        addIconsToWindows();
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

        var themeCheckMenuItem = new CheckMenuItem("Dark Theme");
        var theme = ThemeManger.load();
        if (theme == Theme.DARK)
            themeCheckMenuItem.setSelected(true);
        themeCheckMenuItem.selectedProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue)
                ThemeManger.setTheme(root.getScene(), Theme.DARK);
            else
                ThemeManger.setTheme(root.getScene(), Theme.LIGHT);
        });

        var closeMenuItem = new MenuItem("Close");
        closeMenuItem.setOnAction(actionEvent -> Platform.exit());
        closeMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN));

        var fileMenu = new Menu("_File");
        fileMenu.getItems().addAll(snapShotMenuItem, themeCheckMenuItem, closeMenuItem);
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

        var lanthanidesPlaceHolder = new PlaceHolder("57-71");
        GridPane.setConstraints(lanthanidesPlaceHolder, 2, 5);

        var actinidesPlaceHolder = new PlaceHolder("89-103");
        GridPane.setConstraints(actinidesPlaceHolder, 2, 6);

        gridPane.getChildren().addAll(lanthanidesPlaceHolder, actinidesPlaceHolder);
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

    private void addIconsToWindows() {
        Window.getWindows().addListener((ListChangeListener<? super Window>) change -> {
            while (change.next()) {
                if (change.wasAdded()) {
                    for (Window window : change.getAddedSubList()) {
                        if (window instanceof Stage stageWindow) {
                            stageWindow.getIcons().addAll(
                                    new Image(Objects.requireNonNull(getClass().getResource("icons/icon64.png")).toExternalForm()),
                                    new Image(Objects.requireNonNull(getClass().getResource("icons/icon32.png")).toExternalForm()),
                                    new Image(Objects.requireNonNull(getClass().getResource("icons/icon64.png")).toExternalForm())
                            );
                        }
                    }
                }
            }
        });
    }
}
