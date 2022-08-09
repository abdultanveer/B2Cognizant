package com.example.b2cognizant.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * this class is a provider -- seller
 *
 */
@Module
public class SharedPrefModule {
    Context mContext;


    public  SharedPrefModule(Context context){
        mContext = context;
    }

    @Singleton
    @Provides
    Context provideContext(){
        return mContext;
    }

    @Singleton
    @Provides
    public SharedPreferences provideSharedPreferences(){
        return PreferenceManager.getDefaultSharedPreferences(mContext);
    }
}