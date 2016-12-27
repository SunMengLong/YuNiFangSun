package xn.bwie.com.yunifang.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

import xn.bwie.com.yunifang.R;
import xn.bwie.com.yunifang.bean.HomeBean;
import xn.bwie.com.yunifang.interface1.OnItemClickListener;
import xn.bwie.com.yunifang.viewholder.ZhuanTiViewHolder;

/**
 * Created by Pooh on 2016/12/7.
 */
public class ZhuanTiReceAdapter extends RecyclerView.Adapter<ZhuanTiViewHolder>{

    private Context conText;
    private ArrayList<HomeBean.DataBean.SubjectsBean.GoodsListBean> listBean;
    public OnItemClickListener onItmeClickListener;

    public ZhuanTiReceAdapter(ArrayList<HomeBean.DataBean.SubjectsBean.GoodsListBean> listBeen, Context context) {
        this.listBean=listBeen;
        this.conText=context;
    }

    @Override
    public ZhuanTiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //查找布局，返回ViewHolder
        View vv=View.inflate(conText, R.layout.item_more_goods_view,null);
        ZhuanTiViewHolder viewHolder=new ZhuanTiViewHolder(vv);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ZhuanTiViewHolder holder, final int position) {
        //设置数据
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItmeClickListener != null) {
                    onItmeClickListener.onItemClick(position);
                }
            }
        });

        ImageLoader.getInstance().displayImage(listBean.get(position).getGoods_img(),holder.fragment_more_goods_img);
        holder.fragment_more_goods_name.setText(listBean.get(position).getGoods_name());
        holder.fragment_more_goods_jieshao.setText(listBean.get(position).getEfficacy());
        holder.fragment_more_goods_price_tv1.setText("￥"+listBean.get(position).getShop_price());
        holder.fragment_more_goods_price_tv2.setText("￥"+listBean.get(position).getMarket_price());
    }

    @Override
    public int getItemCount() {
        return listBean.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItmeClickListener = onItemClickListener;
    }
}
