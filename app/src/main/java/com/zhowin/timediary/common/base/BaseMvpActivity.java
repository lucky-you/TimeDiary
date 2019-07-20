package com.zhowin.timediary.common.base;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zhowin.timediary.R;
import com.zhowin.timediary.common.mvp.BasePresenter;
import com.zhowin.timediary.common.mvp.MvpActivity;
import com.zhowin.timediary.common.recyclerview.BaseSimpleAdapter;
import com.zhowin.timediary.common.view.TitleBuilder;


public abstract class BaseMvpActivity<P extends BasePresenter> extends MvpActivity<P> {


    protected String userToken;

    public TitleBuilder initTitle(Object obj) {
        if (obj instanceof String) {
            return new TitleBuilder(this).setTitleText((String) obj);
        } else {
            return new TitleBuilder(this).setTitleText((int) obj);
        }
    }

    public RecyclerView initCommonRecyclerView(BaseSimpleAdapter adapter, RecyclerView.ItemDecoration decoration) {
        return initCommonRecyclerView(R.id.recyclerView, adapter, decoration);
    }

    public RecyclerView initCommonRecyclerView(@IdRes int id, BaseSimpleAdapter adapter, RecyclerView.ItemDecoration decoration) {
        RecyclerView recyclerView = (RecyclerView) findViewById(id);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        if (decoration != null) {
            recyclerView.addItemDecoration(decoration);
        }
        recyclerView.setAdapter(adapter);
        return recyclerView;
    }

    public RecyclerView initGridRecyclerView(@IdRes int id, BaseSimpleAdapter adapter, RecyclerView.ItemDecoration decoration, int spanCount) {
        RecyclerView recyclerView = (RecyclerView) findViewById(id);
        recyclerView.setLayoutManager(new GridLayoutManager(this, spanCount));
        if (decoration != null) {
            recyclerView.addItemDecoration(decoration);
        }
        recyclerView.setAdapter(adapter);
        return recyclerView;
    }

    public RecyclerView initGridRecyclerView(BaseSimpleAdapter adapter, RecyclerView.ItemDecoration decoration, int spanCount) {
        return initGridRecyclerView(R.id.recyclerView, adapter, decoration, spanCount);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
