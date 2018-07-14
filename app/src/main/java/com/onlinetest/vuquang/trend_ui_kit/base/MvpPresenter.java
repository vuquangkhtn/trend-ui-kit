package com.onlinetest.vuquang.trend_ui_kit.base;

/**
 * Created by janisharali on 27/01/17.
 */

/**
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the MvpView type that wants to be attached with.
 */
public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();

//    void setUserAsLoggedOut();
}
