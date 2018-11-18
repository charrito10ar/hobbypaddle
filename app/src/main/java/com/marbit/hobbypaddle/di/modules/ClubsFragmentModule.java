package com.marbit.hobbypaddle.di.modules;

import com.marbit.hobbypaddle.BaseApplication;
import com.marbit.hobbypaddle.data.CloudDataStore;
import com.marbit.hobbypaddle.di.ActivityScope;
import com.marbit.hobbypaddle.domain.presenters.ClubsPresenterImpl;
import com.marbit.hobbypaddle.domain.repositories.ClubRepository;
import com.marbit.hobbypaddle.domain.usecases.GetClubsUseCase;
import com.marbit.hobbypaddle.presentation.presenters.ClubsPresenter;
import com.marbit.hobbypaddle.presentation.ui.fragments.interfaces.ClubsView;

import dagger.Module;
import dagger.Provides;

@Module
public class ClubsFragmentModule {
    private ClubsView view;

    public ClubsFragmentModule(ClubsView view){
        this.view = view;
    }

    @Provides
    @ActivityScope
    public ClubsView provideView(){
        return view;
    }

    @Provides
    @ActivityScope
    public ClubsPresenter providePresenter(ClubsView view, GetClubsUseCase getClubsUseCase){
        return new ClubsPresenterImpl(view, getClubsUseCase);
    }

    @Provides
    @ActivityScope
    public GetClubsUseCase provideGetClubsUseCase(){
        return new GetClubsUseCase(BaseApplication.getApp().getNetComponent().provideClubRepository());
    }


}
