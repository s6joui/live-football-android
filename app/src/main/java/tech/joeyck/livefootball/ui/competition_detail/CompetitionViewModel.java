package tech.joeyck.livefootball.ui.competition_detail;

import android.arch.lifecycle.ViewModel;
import android.support.v4.app.Fragment;

import tech.joeyck.livefootball.data.LiveFootballRepository;
import tech.joeyck.livefootball.ui.competition_detail.matches.MatchesFragment;
import tech.joeyck.livefootball.ui.competition_detail.standings.StandingsFragment;

class CompetitionViewModel extends ViewModel {

    private int mCompetitionId;
    private String mCompetitionName;
    private int mMatchDay;

    CompetitionViewModel(int competitionId, String competitionName, int matchday){
        this.mCompetitionId = competitionId;
        this.mCompetitionName = competitionName;
        this.mMatchDay = matchday;
    }

    public int getCompetitionId() {
        return mCompetitionId;
    }

    public String getCompetitionName() {
        return mCompetitionName;
    }

    public int getMatchDay() {
        return mMatchDay;
    }

}