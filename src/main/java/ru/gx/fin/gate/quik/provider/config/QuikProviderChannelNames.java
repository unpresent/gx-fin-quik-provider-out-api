package ru.gx.fin.gate.quik.provider.config;

@SuppressWarnings("unused")
public abstract class QuikProviderChannelNames {
    public abstract static class Streams {
        public static final String ALL_TRADES_V1 = "quik-provider-streams.all-trades-v1";
        public static final String ORDERS_V1 = "quik-provider-streams.orders-v1";
        public static final String DEALS_V1 = "quik-provider-streams.deals-v1";
        public static final String SECURITIES_V1 = "quik-provider-streams.securities-v1";
    }

    public abstract static class Snapshots {
        public static final String SECURITIES_V1 = "quik-provider-snapshots.securities-v1";
    }
}
