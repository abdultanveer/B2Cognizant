package com.example.b2cognizant.di;

import com.example.b2cognizant.DependencyActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * real estate agent who knows both the buyer and seller
 */
@Singleton
@Component(modules = {SharedPrefModule.class})
public interface MyComponent {

    void inject(DependencyActivity activity);


}
