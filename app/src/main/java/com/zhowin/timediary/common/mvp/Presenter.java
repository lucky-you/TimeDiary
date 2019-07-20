package com.zhowin.timediary.common.mvp;

public interface Presenter<V> {

    void attachView(V view);

    void detachView();

}
