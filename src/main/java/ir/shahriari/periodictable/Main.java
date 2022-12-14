package ir.shahriari.periodictable;

import ir.shahriari.periodictable.ui.AboutDialog;
import ir.shahriari.periodictable.ui.InfoDialog;
import ir.shahriari.periodictable.utils.TableCreator;
import ir.shahriari.periodictable.utils.Theme;
import ir.shahriari.periodictable.utils.ThemeManager;
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

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    private static Main instance;

    private TableCreator tableCreator;

    private AboutDialog aboutDialog;

    private InfoDialog infoDialog;

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
        var scene = new Scene(createContent(), 900, 600);
        ThemeManager.setTheme(scene, ThemeManager.load());
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        addIconsToWindows();

        aboutDialog = new AboutDialog();
        infoDialog = new InfoDialog(primaryStage);

        primaryStage.show();

        tableCreator.create();
    }

    private Parent createContent() {
        var root = new BorderPane();
        root.setId("root");

        var gridPane = new GridPane();
        gridPane.setHgap(.5);
        gridPane.setVgap(.5);
        gridPane.setPadding(new Insets(5));
        gridPane.setAlignment(Pos.CENTER);

        tableCreator = new TableCreator(gridPane);

        var scrollPane = new ScrollPane(gridPane);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        root.setCenter(scrollPane);

        var snapShotMenuItem = new MenuItem("SnapShot");
        snapShotMenuItem.setOnAction(actionEvent -> takeSnapShot(gridPane));
        snapShotMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));

        var themeCheckMenuItem = new CheckMenuItem("Dark Theme");
        var theme = ThemeManager.load();
        if (theme == Theme.DARK)
            themeCheckMenuItem.setSelected(true);
        themeCheckMenuItem.selectedProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue)
                ThemeManager.setTheme(root.getScene(), Theme.DARK);
            else
                ThemeManager.setTheme(root.getScene(), Theme.LIGHT);
        });

        var closeMenuItem = new MenuItem("Close");
        closeMenuItem.setOnAction(actionEvent -> Platform.exit());
        closeMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN));

        var wideLayoutCheckMenuItem = new CheckMenuItem("Wide Layout");
        wideLayoutCheckMenuItem.selectedProperty().addListener((observableValue, oldValue, newValue) -> {
            if (tableCreator.isCreatingTable())
                return;

            tableCreator.setWideLayout(newValue);
            tableCreator.create();
        });

        var fileMenu = new Menu("_File");
        fileMenu.getItems().addAll(snapShotMenuItem, themeCheckMenuItem, wideLayoutCheckMenuItem, closeMenuItem);

        var aboutMenuItem = new MenuItem("About");
        aboutMenuItem.setOnAction(actionEvent -> aboutDialog.show());

        var helpMenu = new Menu("_Help");
        helpMenu.getItems().addAll(aboutMenuItem);

        var menuBar = new MenuBar(fileMenu, helpMenu);

        root.setTop(menuBar);

        return root;
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

    public InfoDialog getInfoDialog() {
        return infoDialog;
    }
}
