package com.marbit.hobbypaddle.di.component;

import com.marbit.hobbypaddle.di.application.ApplicationModule;
import com.marbit.hobbypaddle.di.modules.NetModule;
import com.marbit.hobbypaddle.domain.repositories.ClubRepository;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules={ApplicationModule.class, NetModule.class})
public interface NetComponent {
    @NetModule.RetrofitALogin
    Retrofit retrofitLogin();

    @NetModule.RetrofitAuth
    Retrofit retrofitAuth();

    ClubRepository provideClubRepository();
/*
    UserRepository getUserRepository();
    UserEntityDataMapper getUserEntityDataMapper();

    IncentiveRepository getItemsRepository();
    CategoryRepository getCategoryRepository();

    ItemEntityDataMapper getItemEntityDataMapper();

    CategoryEntityDataMapper getCategoryEntityDataMapper();

    SearchHistoryRepository getSearchHistoryRespository();
    SearchHistoryDataMapper getSearchHistoryDataMapper();
    FeedbackRepository getFeedbackRepository();
    LocalDataStore getLocalDataStore();
    */
}