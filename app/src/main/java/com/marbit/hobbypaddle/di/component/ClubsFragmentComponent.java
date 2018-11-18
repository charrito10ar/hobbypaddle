package com.marbit.hobbypaddle.di.component;

import com.marbit.hobbypaddle.di.ActivityScope;
import com.marbit.hobbypaddle.di.modules.ClubsFragmentModule;
import com.marbit.hobbypaddle.domain.usecases.GetClubsUseCase;
import com.marbit.hobbypaddle.presentation.presenters.ClubsPresenter;
import com.marbit.hobbypaddle.presentation.ui.fragments.ClubsFragment;
import com.marbit.hobbypaddle.presentation.ui.fragments.interfaces.ClubsView;

import dagger.Component;

@ActivityScope
@Component(modules = {ClubsFragmentModule.class})
public interface ClubsFragmentComponent {

    void inject(ClubsFragment clubsFragment);
    ClubsView getLoginView();
    ClubsPresenter getPresenter();
    GetClubsUseCase provideGetClubsUseCase();
}
