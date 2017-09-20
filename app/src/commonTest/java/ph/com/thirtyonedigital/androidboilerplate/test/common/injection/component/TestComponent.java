package ph.com.thirtyonedigital.androidboilerplate.test.common.injection.component;

import javax.inject.Singleton;

import dagger.Component;
import ph.com.thirtyonedigital.androidboilerplate.injection.component.ApplicationComponent;
import ph.com.thirtyonedigital.androidboilerplate.test.common.injection.module.ApplicationTestModule;

@Singleton
@Component(modules = ApplicationTestModule.class)
public interface TestComponent extends ApplicationComponent {

}
