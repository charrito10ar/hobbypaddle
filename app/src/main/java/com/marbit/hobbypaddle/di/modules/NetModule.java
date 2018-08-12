package com.marbit.hobbypaddle.di.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.marbit.hobbypaddle.BaseApplication;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.TimeUnit;

import javax.inject.Qualifier;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule {

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface RetrofitALogin {}

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface RetrofitAuth {}

    @Provides
    @Singleton
    @RetrofitALogin
    Retrofit provideRetrofitLogin() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        // Add logging
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(logging);
        builder.readTimeout(30, TimeUnit.SECONDS);
        builder.connectTimeout(30, TimeUnit.SECONDS);




        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();


        return new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();
    }

    @Provides
    @Singleton
    @RetrofitAuth
    Retrofit provideRetrofitAuth() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(logging);
        builder.readTimeout(30, TimeUnit.SECONDS);
        builder.connectTimeout(30, TimeUnit.SECONDS);


        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        return new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();
    }
/*
    @Provides
    @Singleton
    UserRepository provideUserRepository(CloudDataStore cloudDataStore, UserEntityDataMapper userEntityDataMapper) {
        return new UserRepositoryImpl(cloudDataStore, userEntityDataMapper);
    }

    @Provides
    @Singleton
    IncentiveRepository provideItemsRepository(CloudDataStore cloudDataStore, ItemEntityDataMapper itemEntityDataMapper, IncentiveDetailMapper incentiveDetailMapper, CategoryEntityDataMapper categoryEntityDataMapper) {
        return new IncentiveRepositoryImpl(cloudDataStore, itemEntityDataMapper, incentiveDetailMapper, categoryEntityDataMapper);
    }

    @Provides
    @Singleton
    CategoryRepository provideCategoryRepository(CloudDataStore cloudDataStore, CategoryEntityDataMapper categoryEntityDataMapper) {
        return new CategoryRepositoryImpl(cloudDataStore, categoryEntityDataMapper);
    }

    @Provides
    @Singleton
    SearchHistoryRepository provideSearchHistoryRepository(SearchHistoryDataMapper searchHistoryDataMapper, LocalDataStore localDataStore) {
        return new SearchHistoryRepositoryImpl(searchHistoryDataMapper, localDataStore);
    }

    @Provides
    @Singleton
    FeedbackRepository provideFeedbackRepository(CloudDataStore cloudDataStore, FeedbackDataMapper feedbackDataMapper, FeedbackStatsDataMapper feedbackStatsDataMapper) {
        return new FeedbackRepositoryImpl(cloudDataStore, feedbackDataMapper, feedbackStatsDataMapper);
    }

    @Provides
    @Singleton
    public CloudDataStore provideCloudUserAdapter(){
        return new CloudDataStore(provideRetrofitLogin());
    }

    @Provides
    @Singleton
    public CategoryEntityDataMapper provideCategoryEntityDataMapper(SubcategoryDataMapper subcategoryDataMapper){
        return new CategoryEntityDataMapper(subcategoryDataMapper);
    }*/
}