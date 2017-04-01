package com.zsy.lib.ui.test;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zsy.lib.R;

import java.util.List;

/**
 * Created by mzs on 2017/4/1.
 */

public class TestRvAdapter extends RecyclerView.Adapter<TestRvAdapter.VH> {

    private List<String> datas;
    private OnItemClickLsn onItemClickLsn;

    public TestRvAdapter(List<String> datas) {
        this.datas = datas;
    }

    public void setOnItemClickLsn(OnItemClickLsn onItemClickLsn) {
        this.onItemClickLsn = onItemClickLsn;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_test, parent, false);
        return new VH(itemView);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        final int p = position;
        holder.actionTv.setText(datas.get(p));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickLsn != null) {
                    onItemClickLsn.onItemClick(p);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class VH extends RecyclerView.ViewHolder {

        private TextView actionTv;

        VH(View itemView) {
            super(itemView);
            actionTv = (TextView) itemView.findViewById(R.id.tv_action);

        }
    }

    interface OnItemClickLsn {
        void onItemClick(int position);
    }

}
