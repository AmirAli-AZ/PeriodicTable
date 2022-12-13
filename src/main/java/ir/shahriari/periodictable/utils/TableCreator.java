package ir.shahriari.periodictable.utils;

import ir.shahriari.periodictable.model.Element;
import ir.shahriari.periodictable.ui.ElementNode;
import ir.shahriari.periodictable.ui.PlaceHolder;
import javafx.application.Platform;
import javafx.scene.layout.GridPane;
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
                            jsonObject.getString("summary")
                    )
            );
            GridPane.setConstraints(
                    elementNode,
                    isWideLayout() ? jsonObject.getInt("wxpos") - 1 : jsonObject.getInt("xpos") - 1,
                    isWideLayout() ? jsonObject.getInt("wypos") - 1 :jsonObject.getInt("ypos") - 1
            );

            Platform.runLater(() -> gridPane.getChildren().add(elementNode));
        }

        if (!isWideLayout()) {
            var lanthanidesPlaceHolder = new PlaceHolder("57-71");
            GridPane.setConstraints(lanthanidesPlaceHolder, 2, 5);

            var actinidesPlaceHolder = new PlaceHolder("89-103");
            GridPane.setConstraints(actinidesPlaceHolder, 2, 6);

            Platform.runLater(() -> gridPane.getChildren().addAll(lanthanidesPlaceHolder, actinidesPlaceHolder));
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
