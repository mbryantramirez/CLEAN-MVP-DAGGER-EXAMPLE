package nyc.bionic.spotifyoauthsample;

import android.content.Context;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import nyc.bionic.spotifyoauthsample.di.DaggerCoreComponent;

public class CoreApp extends DaggerApplication {

  @Override
  protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
    return DaggerCoreComponent.builder().application(this).build();
  }

  @Override
  protected void attachBaseContext(Context base) {
    super.attachBaseContext(base);
  }
}
