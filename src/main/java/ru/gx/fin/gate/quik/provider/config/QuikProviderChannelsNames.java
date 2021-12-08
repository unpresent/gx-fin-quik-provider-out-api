package ru.gx.fin.gate.quik.provider.config;

@SuppressWarnings("unused")
public abstract class QuikProviderChannelsNames {
    public abstract static class Streams {
        public static final String ALL_TRADES = "quik-provider-streams.all-trades";
        public static final String ORDERS = "quik-provider-streams.orders";
        public static final String DEALS = "quik-provider-streams.deals";
        public static final String SECURITIES = "quik-provider-streams.securities";
    }

    public abstract static class Snapshots {
        public static final String SECURITIES = "quik-provider-snapshots.securities";
    }
}
