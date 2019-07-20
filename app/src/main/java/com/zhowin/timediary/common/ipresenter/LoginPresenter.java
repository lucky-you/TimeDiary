package com.zhowin.timediary.common.ipresenter;

import com.zhowin.timediary.common.iview.ILoginView;
import com.zhowin.timediary.common.mvp.BasePresenter;

/**
 * author      : Z_B
 * date       : 2019/5/21
 * function  : 登录的presenter
 */
public class LoginPresenter extends BasePresenter<ILoginView> {
    public LoginPresenter(ILoginView mvpView) {
        super(mvpView);
    }
}
