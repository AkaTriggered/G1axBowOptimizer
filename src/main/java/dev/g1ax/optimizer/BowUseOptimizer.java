package dev.g1ax.optimizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BowUseOptimizer {
    private static final Logger LOGGER = LoggerFactory.getLogger("G1axBowOptimizer");
    private static int clientUseTicks = 0;
    private static boolean isUsing = false;
    private static long lastReleaseTime = 0;

    public static void startUsing() {
        try {
            isUsing = true;
            clientUseTicks = 0;
        } catch (Exception e) {
            LOGGER.error("Error starting bow use", e);
        }
    }

    public static void stopUsing() {
        try {
            isUsing = false;
            clientUseTicks = 0;
            lastReleaseTime = System.currentTimeMillis();
        } catch (Exception e) {
            LOGGER.error("Error stopping bow use", e);
        }
    }

    public static void tick() {
        try {
            if (isUsing) {
                clientUseTicks++;
            }
        } catch (Exception e) {
            LOGGER.error("Error in bow tick", e);
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
