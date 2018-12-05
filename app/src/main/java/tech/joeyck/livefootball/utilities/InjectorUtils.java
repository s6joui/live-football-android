/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tech.joeyck.livefootball.utilities;

import android.content.Context;

import tech.joeyck.livefootball.AppExecutors;
import tech.joeyck.livefootball.data.LiveFootballRepository;
import tech.joeyck.livefootball.data.network.LiveFootballAPI;
import tech.joeyck.livefootball.ui.competition_detail.CompetitionViewModelFactory;
import tech.joeyck.livefootball.ui.competition_detail.standings.StandingsViewModelFactory;
import tech.joeyck.livefootball.ui.competition_picker.CompetitionPickerViewModelFactory;
import tech.joeyck.livefootball.ui.competition_detail.matches.MatchesViewModelFactory;
import tech.joeyck.livefootball.ui.team_detail.TeamDetailViewModelFactory;

/**
 * Provides static methods to inject the various classes needed for Sunshine
 */
public class InjectorUtils {

    public static LiveFootballRepository provideRepository(Context context) {
        AppExecutors executors = AppExecutors.getInstance();
        LiveFootballAPI service = NetworkUtils.buildRetrofit(context).create(LiveFootballAPI.class);
        return LiveFootballRepository.getInstance(service,executors);
    }

    public static CompetitionPickerViewModelFactory provideMainViewModelFactory(Context context) {
        LiveFootballRepository repository = provideRepository(context.getApplicationContext());
        return new CompetitionPickerViewModelFactory(repository);
    }

    public static StandingsViewModelFactory provideStandingsViewModelFactory(Context context, int competitionId) {
        LiveFootballRepository repository = provideRepository(context.getApplicationContext());
        return new StandingsViewModelFactory(repository,competitionId);
    }

    public static TeamDetailViewModelFactory provideTeamDetailViewModelFactory(Context context, int teamId) {
        LiveFootballRepository repository = provideRepository(context.getApplicationContext());
        return new TeamDetailViewModelFactory(repository,teamId);
    }

    public static MatchesViewModelFactory provideMatchesViewModelFactory(Context context, int competitionId, int matchday, int teamId) {
        LiveFootballRepository repository = provideRepository(context.getApplicationContext());
        return new MatchesViewModelFactory(repository,competitionId, matchday,teamId);
    }

    public static CompetitionViewModelFactory provideCompetitionViewModelFactory(Context context, int competitionId, String competitionName, int matchday,int themeColor){
        return new CompetitionViewModelFactory(competitionId,competitionName,matchday,themeColor);
    }

}