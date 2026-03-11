package dev.g1ax.optimizer;

public class BowUseOptimizer {
    private static int clientUseTicks = 0;
    private static boolean isUsing = false;
    private static long lastReleaseTime = 0;

    public static void startUsing() {
        isUsing = true;
        clientUseTicks = 0;
    }

    public static void stopUsing() {
        isUsing = false;
        clientUseTicks = 0;
        lastReleaseTime = System.currentTimeMillis();
    }

    public static void tick() {
        if (isUsing) {
            clientUseTicks++;
        }
    }

    public static int getUseTicks() {
        return clientUseTicks;
    }

    public static boolean isUsing() {
        return isUsing;
    }

    public static boolean isFullyCharged(int useTicks) {
        return useTicks >= 20;
    }

    public static boolean wasRecentlyReleased() {
        return System.currentTimeMillis() - lastReleaseTime < 100;
    }
}
