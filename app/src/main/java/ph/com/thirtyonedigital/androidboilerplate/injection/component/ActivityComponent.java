package ph.com.thirtyonedigital.androidboilerplate.injection.component;

import dagger.Subcomponent;
import ph.com.thirtyonedigital.androidboilerplate.injection.PerActivity;
import ph.com.thirtyonedigital.androidboilerplate.injection.module.ActivityModule;
import ph.com.thirtyonedigital.androidboilerplate.ui.main.MainActivity;

/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
