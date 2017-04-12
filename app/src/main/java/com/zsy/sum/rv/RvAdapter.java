package com.zsy.sum.rv;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.zsy.lib.utils.depend.Lg;
import com.zsy.sum.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mzs on 2017/4/11.
 */

public class RvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int TypeHead = 0x10;
    private final int Type1 = 0x11;
    private final int Type2 = 0x12;

    private boolean isNoMore = false;

    private List<Object> datas;


    public RvAdapter(List<Object> datas) {
        this.datas = datas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case TypeHead:
                View bottomV = inflater.inflate(R.layout.item_rv_head, parent, false);
                return new HeadVH(bottomV);
            case Type1:
                View view1 = inflater.inflate(R.layout.item_rv_type1, parent, false);
                return new VH1(view1);
            case Type2:
                View view2 = inflater.inflate(R.layout.item_rv_type2, parent, false);
                return new VH2(view2);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == getItemCount() - 1) {
            if (isNoMore) {
                ((HeadVH) holder).loadingPb.setVisibility(View.GONE);
                ((HeadVH) holder).stateTv.setText("noMore");
            }
            return;
        }
        Object o = datas.get(position);
        if (o instanceof Person) {
            ((VH1) holder).nameTv.setText(((Person) o).getName());
            ((VH1) holder).ageTv.setText(((Person) o).getAge() + "");
        } else {
            ((VH2) holder).typeTv.setText(((Animal) o).getType());
            ((VH2) holder).colorTv.setText(((Animal) o).getColor());
        }
    }

    @Override
    public int getItemCount() {
        return datas.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            return TypeHead;
        } else {
            Object o = datas.get(position);
            if (o instanceof Person) {
                return Type1;
            } else {
                return Type2;
            }
        }
    }

    class HeadVH extends RecyclerView.ViewHolder {

        @BindView(R.id.pb_loading) ProgressBar loadingPb;
        @BindView(R.id.tv_state) TextView stateTv;

        public HeadVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class VH1 extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_name) TextView nameTv;
        @BindView(R.id.tv_age) TextView ageTv;

        public VH1(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class VH2 extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_type) TextView typeTv;
        @BindView(R.id.tv_color) TextView colorTv;

        public VH2(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setNoMore(boolean noMore) {
        isNoMore = noMore;
    }
//    public static boolean isVisBottom(RecyclerView recyclerView) {
//        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
//        //屏幕中最后一个可见子项的position
//        int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
//        //当前屏幕所看到的子项个数
//        int visibleItemCount = layoutManager.getChildCount();
//        //当前RecyclerView的所有子项个数
//        int totalItemCount = layoutManager.getItemCount();
//        //RecyclerView的滑动状态
//        int state = recyclerView.getScrollState();
//        if (visibleItemCount > 0 && lastVisibleItemPosition == totalItemCount - 1 && state == recyclerView.SCROLL_STATE_IDLE) {
//            return true;
//        } else {
//            return false;
//        }
//    }


}
