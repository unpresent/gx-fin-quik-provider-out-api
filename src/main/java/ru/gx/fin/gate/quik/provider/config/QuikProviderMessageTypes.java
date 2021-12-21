package ru.gx.fin.gate.quik.provider.config;

@SuppressWarnings("unused")
public abstract class QuikProviderMessageTypes {
    public abstract static class Streams {
        public static final String ALL_TRADES   = "QUIK-PROVIDER:STREAM-PUBLISH:ALL-TRADES-PACKAGE";
        public static final String ORDERS       = "QUIK-PROVIDER:STREAM-PUBLISH:ORDERS-PACKAGE";
        public static final String DEALS        = "QUIK-PROVIDER:STREAM-PUBLISH:DEALS-PACKAGE";
        public static final String SECURITIES   = "QUIK-PROVIDER:STREAM-PUBLISH:SECURITIES-PACKAGE";
    }

    public abstract static class Snapshots {
        public static final String SECURITY = "QUIK-PROVIDER:SNAPSHOT-PUBLISH:SECURITY";
    }
}
