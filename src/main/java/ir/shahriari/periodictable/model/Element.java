package ir.shahriari.periodictable.model;

import javafx.scene.paint.Color;

import java.net.URI;

public record Element(String name, String symbol, int atomicNumber, int group, int period, Color color, URI source) {

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Symbol: " + symbol + "\n" +
                "Atomic Number: " + atomicNumber + "\n" +
                "Group: " + group + "\n" +
                "Period: " + period;
    }
}
