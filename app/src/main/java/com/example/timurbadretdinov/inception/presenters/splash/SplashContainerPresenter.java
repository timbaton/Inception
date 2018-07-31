package com.example.timurbadretdinov.inception.presenters.splash;

public class SplashContainerPresenter {
    private SplashContainerView view;

    public SplashContainerPresenter(SplashContainerView view) {
        this.view = view;
    }

    public void onStartClicked() {
        view.showMessage("Button pressed");
    }
}
