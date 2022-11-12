package ir.shahriari.periodictable.model;

public record Element(String name, String symbol, int atomicNumber, double atomicMass, int group, int period,
                      String block, String source) {

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Symbol: " + symbol + "\n" +
                "Atomic Number: " + atomicNumber + "\n" +
                "Atomic Mass: " + atomicMass + "\n" +
                "Group: " + group + "\n" +
                "Period: " + period;
    }
}
