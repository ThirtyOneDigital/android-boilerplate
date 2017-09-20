package ph.com.thirtyonedigital.androidboilerplate.injection.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import ph.com.thirtyonedigital.androidboilerplate.data.DataManager;
import ph.com.thirtyonedigital.androidboilerplate.data.SyncService;
import ph.com.thirtyonedigital.androidboilerplate.data.local.DatabaseHelper;
import ph.com.thirtyonedigital.androidboilerplate.data.local.PreferencesHelper;
import ph.com.thirtyonedigital.androidboilerplate.data.remote.RibotsService;
import ph.com.thirtyonedigital.androidboilerplate.injection.ApplicationContext;
import ph.com.thirtyonedigital.androidboilerplate.injection.module.ApplicationModule;
import ph.com.thirtyonedigital.androidboilerplate.util.RxEventBus;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(SyncService syncService);

    @ApplicationContext Context context();
    Application application();
    RibotsService ribotsService();
    PreferencesHelper preferencesHelper();
    DatabaseHelper databaseHelper();
    DataManager dataManager();
    RxEventBus eventBus();

}
