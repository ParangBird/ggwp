package com.backend.ggwp.domain.leagueitem;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class LeagueItemComparator implements Comparator<LeagueItem> {
    @Override
    public int compare(LeagueItem o1, LeagueItem o2) {
        if (o1.getLeaguePoints() < o2.getLeaguePoints())
            return 1;
        else if (o1.getLeaguePoints() > o2.getLeaguePoints())
            return -1;
        return 0;
    }

    @Override
    public Comparator<LeagueItem> reversed() {
        return Comparator.super.reversed();
    }

    @Override
    public Comparator<LeagueItem> thenComparing(Comparator<? super LeagueItem> other) {
        return Comparator.super.thenComparing(other);
    }

    @Override
    public <U> Comparator<LeagueItem> thenComparing(Function<? super LeagueItem, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return Comparator.super.thenComparing(keyExtractor, keyComparator);
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<LeagueItem> thenComparing(Function<? super LeagueItem, ? extends U> keyExtractor) {
        return Comparator.super.thenComparing(keyExtractor);
    }

    @Override
    public Comparator<LeagueItem> thenComparingInt(ToIntFunction<? super LeagueItem> keyExtractor) {
        return Comparator.super.thenComparingInt(keyExtractor);
    }

    @Override
    public Comparator<LeagueItem> thenComparingLong(ToLongFunction<? super LeagueItem> keyExtractor) {
        return Comparator.super.thenComparingLong(keyExtractor);
    }

    @Override
    public Comparator<LeagueItem> thenComparingDouble(ToDoubleFunction<? super LeagueItem> keyExtractor) {
        return Comparator.super.thenComparingDouble(keyExtractor);
    }
}
