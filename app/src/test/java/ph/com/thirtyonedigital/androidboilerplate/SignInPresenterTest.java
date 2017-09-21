package ph.com.thirtyonedigital.androidboilerplate;

import android.app.Activity;

import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import io.reactivex.Observable;
import ph.com.thirtyonedigital.androidboilerplate.data.model.Ribot;
import ph.com.thirtyonedigital.androidboilerplate.test.common.TestDataFactory;
import ph.com.thirtyonedigital.androidboilerplate.ui.signin.SignInMvpView;
import ph.com.thirtyonedigital.androidboilerplate.ui.signin.SignInPresenter;
import ph.com.thirtyonedigital.androidboilerplate.util.RxSchedulersOverrideRule;

import static com.facebook.internal.CallbackManagerImpl.RequestCodeOffset.Login;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by markcadag on 20/09/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class SignInPresenterTest {

    @Mock
    SignInMvpView signInMvpView;

    private SignInPresenter mMainPresenter;

    @Mock
    Activity activity;

    @Rule
    public final RxSchedulersOverrideRule mOverrideSchedulersRule = new RxSchedulersOverrideRule();
    @Before
    public void setUp() {
        mMainPresenter = new SignInPresenter();
        mMainPresenter.attachView(signInMvpView);
    }

    @After
    public void tearDown() {
        mMainPresenter.detachView();
    }

    @Test
    public void testFacebookLogin() {
        when(mMockDataManager.getRibots())
                .thenReturn(Observable.just(ribots));

        mMainPresenter.loginWithFacebook(activity, callbac);
        verify(signInMvpView).showRibots(ribots);
        verify(signInMvpView, never()).showRibotsEmpty();
        verify(signInMvpView, never()).showError();
    }

}