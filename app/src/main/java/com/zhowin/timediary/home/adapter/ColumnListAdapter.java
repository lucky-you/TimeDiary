package com.zhowin.timediary.home.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhowin.timediary.R;
import com.zhowin.timediary.home.model.ColumnList;

import java.util.List;

/**
 * Created by : Z_B on 2019/7/28.
 * describe：栏目分类
 */
public class ColumnListAdapter extends BaseQuickAdapter<ColumnList, BaseViewHolder> {
    public ColumnListAdapter(@Nullable List<ColumnList> data) {
        super(R.layout.include_column_list_item_view, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ColumnList item) {

        helper.setText(R.id.tvColumnText, item.getColumnName())
                .setGone(R.id.icDeleteItem, item.getColumnType() == 2)
                .addOnClickListener(R.id.icDeleteItem);

    }


}
