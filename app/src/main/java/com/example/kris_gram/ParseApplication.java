package com.example.kris_gram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    // Initializes Parse SDK as soon as the application is created
    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("RITpc8Rb4FPAadGsrhZUJLAnhKhfsVuhgioT3zt9")
                .clientKey("3CFQoSyjQqnWQeK6IOLXKol9HIfzognXMMLuc6Rr")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
