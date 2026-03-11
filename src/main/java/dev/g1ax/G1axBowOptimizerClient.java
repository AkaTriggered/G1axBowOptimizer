package dev.g1ax;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class G1axBowOptimizerClient implements ClientModInitializer {
    public static final String MOD_ID = "g1axbowoptimizer";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        LOGGER.info("G1axBowOptimizer initialized - Bow mechanics optimized for client-side processing");
    }
}
