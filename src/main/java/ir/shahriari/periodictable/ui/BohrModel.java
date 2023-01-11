package ir.shahriari.periodictable.ui;

import javafx.beans.binding.Bindings;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BohrModel extends StackPane {

    private final Circle core;

    public BohrModel(int[] shells) {
        core = new Circle(20, Color.RED);
        getChildren().add(core);

        for (int i = 0; i < shells.length; i++) {
            var orbit = new Circle();
            orbit.getStyleClass().add("orbit");
            orbit.radiusProperty().bind(core.radiusProperty().multiply((i + 1) * 2));

            getChildren().add(orbit);

            var angleStep = 2 * Math.PI / shells[i];
            var angle = 0.0;
            for (int j = 0; j < shells[i]; j++) {
                angle += angleStep;

                var electron = new Circle();
                electron.setFill(Color.BLUE);
                electron.radiusProperty().bind(core.radiusProperty().divide(2));
                electron.translateXProperty().bind(Bindings.multiply(Math.sin(angle), orbit.radiusProperty()));
                electron.translateYProperty().bind(Bindings.multiply(Math.cos(angle), orbit.radiusProperty()));

                getChildren().add(electron);
            }
        }
    }

    public Circle getCore() {
        return core;
    }
}
