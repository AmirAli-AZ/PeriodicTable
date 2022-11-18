package ir.shahriari.periodictable.utils;

public final class OS {

    private static final String osName = System.getProperty("os.name").toLowerCase();

    public static boolean isWindows() {
        return osName.contains("win");
    }

    public static boolean isLinux() {
        return osName.contains("nix") || osName.contains("nux") || osName.contains("aix");
    }
}
