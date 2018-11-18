package com.marbit.hobbypaddle.di.modules;


import com.marbit.hobbypaddle.di.ActivityScope;
import com.marbit.hobbypaddle.domain.presenters.MenuPresenterImpl;
import com.marbit.hobbypaddle.presentation.presenters.MenuPresenter;
import com.marbit.hobbypaddle.presentation.ui.fragments.interfaces.MenuView;

import dagger.Module;
import dagger.Provides;

@Module
public class MenuModule {

    private MenuView view;

    public MenuModule(MenuView menuView){
        this.view = menuView;
    }

    @Provides
    @ActivityScope
    public MenuView provideView(){
        return view;
    }

    @Provides
    @ActivityScope
    public MenuPresenter providePresenter(MenuView view){
        return new MenuPresenterImpl(view);
    }
}
