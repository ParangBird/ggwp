package com.backend.ggwp.domain.game.leagueitem;

import com.backend.ggwp.domain.game.leagueitem.model.LeagueItem;

import java.util.Comparator;

public class LeagueItemComparator implements Comparator<LeagueItem> {
    @Override
    public int compare(LeagueItem o1, LeagueItem o2) {
        if (o1.getLeaguePoints() < o2.getLeaguePoints())
            return 1;
        else if (o1.getLeaguePoints() > o2.getLeaguePoints())
            return -1;
        return 0;
    }
}
