package nyc.bionic.spotifyoauthsample.di;

import android.app.Application;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import javax.inject.Singleton;
import nyc.bionic.spotifyoauthsample.CoreApp;

@Singleton
@Component(modules = {AndroidInjectionModule.class})
public interface CoreComponent extends AndroidInjector<CoreApp> {

  @Component.Builder
  interface Builder {

    @BindsInstance
    Builder application(Application application);

    CoreComponent build();
  }
}
