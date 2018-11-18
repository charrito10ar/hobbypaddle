package com.marbit.hobbypaddle.di.component;

import com.marbit.hobbypaddle.di.ActivityScope;
import com.marbit.hobbypaddle.di.modules.MenuModule;
import com.marbit.hobbypaddle.presentation.presenters.MenuPresenter;
import com.marbit.hobbypaddle.presentation.ui.fragments.MenuFragment;
import com.marbit.hobbypaddle.presentation.ui.fragments.interfaces.MenuView;

import dagger.Component;

@ActivityScope
@Component(modules = {MenuModule.class})
public interface MenuComponent {
    void inject(MenuFragment menuFragment);
    MenuView getMenuView();
    MenuPresenter getPresenter();
}
