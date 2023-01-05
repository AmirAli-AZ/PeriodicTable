package ir.shahriari.periodictable.utils;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.ui.ElementNode;
import ir.shahriari.periodictable.ui.PlaceHolder;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class TableCreator implements Runnable {

    private final GridPane gridPane;

    private boolean isWideLayout;

    private final AtomicBoolean creatingTable = new AtomicBoolean();

    public TableCreator(GridPane gridPane) {
        Objects.requireNonNull(gridPane);
        this.gridPane = gridPane;
    }

    public TableCreator(GridPane gridPane, boolean isWideLayout) {
        Objects.requireNonNull(gridPane);
        this.gridPane = gridPane;
        this.isWideLayout = isWideLayout;
    }

    @Override
    public void run() {
        creatingTable.set(true);
        Platform.runLater(() -> {
            if (!gridPane.getChildren().isEmpty())
                gridPane.getChildren().clear();
        });

        var reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/ir/shahriari/periodictable/periodic-table.json"))));
        var stringBuilder = new StringBuilder();
        String line;
        do {
            try {
                line = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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
                            jsonObject.getString("summary"),
                            jsonObject.get("boil"),
                            jsonObject.get("melt")
                    )
            );
            GridPane.setConstraints(
                    elementNode,
                    isWideLayout() ? jsonObject.getInt("wxpos") : jsonObject.getInt("xpos"),
                    isWideLayout() ? jsonObject.getInt("wypos") :jsonObject.getInt("ypos")
            );

            Platform.runLater(() -> gridPane.getChildren().add(elementNode));
        }

        if (!isWideLayout()) {
            var lanthanidesPlaceHolder = new PlaceHolder("57-71");
            GridPane.setConstraints(lanthanidesPlaceHolder, 3, 6);

            var actinidesPlaceHolder = new PlaceHolder("89-103");
            GridPane.setConstraints(actinidesPlaceHolder, 3, 7);

            Platform.runLater(() -> gridPane.getChildren().addAll(lanthanidesPlaceHolder, actinidesPlaceHolder));
        }

        for (int period = 1; period <= 7; period++) {
            var label = new Label(String.valueOf(period));
            label.setPrefHeight(90);
            label.setMinHeight(Region.USE_PREF_SIZE);
            label.setPadding(new Insets(5));
            label.setAlignment(Pos.CENTER);
            GridPane.setConstraints(label, 0, period);

            Platform.runLater(() -> gridPane.getChildren().add(label));
        }

        for (int group = 1; group <= 18; group++) {
            var label = new Label(String.valueOf(group));
            label.setPadding(new Insets(5));
            label.setAlignment(Pos.CENTER);
            label.setPrefWidth(90);
            label.setMinWidth(Region.USE_PREF_SIZE);
            if (isWideLayout() && group > 2)
                GridPane.setConstraints(label, group + 14, 0);
            else
                GridPane.setConstraints(label, group, 0);

            Platform.runLater(() -> gridPane.getChildren().add(label));
        }

        creatingTable.set(false);
    }

    public final void setWideLayout(boolean isWideLayout) {
        this.isWideLayout = isWideLayout;
    }

    public final boolean isWideLayout() {
        return isWideLayout;
    }

    public final void create() {
        if (isCreatingTable())
            return;

        var thread = new Thread(this);
        thread.setDaemon(true);
        thread.setName("creator-thread");
        thread.start();
    }

    public final boolean isCreatingTable() {
        return creatingTable.get();
    }
}
