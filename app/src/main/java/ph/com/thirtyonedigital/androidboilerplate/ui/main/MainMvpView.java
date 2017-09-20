package ph.com.thirtyonedigital.androidboilerplate.ui.main;

import java.util.List;

import ph.com.thirtyonedigital.androidboilerplate.data.model.Ribot;
import ph.com.thirtyonedigital.androidboilerplate.ui.base.MvpView;

public interface MainMvpView extends MvpView {

    void showRibots(List<Ribot> ribots);

    void showRibotsEmpty();

    void showError();

}
