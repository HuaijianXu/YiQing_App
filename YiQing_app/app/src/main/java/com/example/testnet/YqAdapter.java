package com.example.testnet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class YqAdapter extends BaseAdapter{

    private List<Info> mList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public YqAdapter(Context context,List<Info> list){
        mContext=context;
        mList=list;
        mLayoutInflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView= mLayoutInflater.inflate(R.layout.list_item,null);
            viewHolder.mTvProvince=(TextView)convertView.findViewById(R.id.tv_province);
            viewHolder.mTvCostDate=(TextView)convertView.findViewById(R.id.tv_date);
            viewHolder.mTvConfirmed_num=(TextView)convertView.findViewById(R.id.tv_confirmed);
            viewHolder.mTvCured_num=(TextView)convertView.findViewById(R.id.tv_cured);
            viewHolder.mTvDead_num=(TextView)convertView.findViewById(R.id.tv_dead);
            viewHolder.mTvNewConfirmed_num=(TextView)convertView.findViewById(R.id.tv_new);
            convertView.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder) convertView.getTag();
        }
        Info bean=mList.get(position);
        viewHolder.mTvProvince.setText(bean.getProvince());
        viewHolder.mTvCostDate.setText(bean.getDate());
        viewHolder.mTvConfirmed_num.setText(bean.getConfirmed_num());
        viewHolder.mTvCured_num.setText(bean.getCured_num());
        viewHolder.mTvDead_num.setText(bean.getDead_num());
        viewHolder.mTvNewConfirmed_num.setText(bean.getNewconfirmed_num());
        return convertView;
    }

    private static class ViewHolder{
        public TextView mTvProvince;
        public TextView mTvCostDate;
        public TextView mTvConfirmed_num;
        public TextView mTvCured_num;
        public TextView mTvDead_num;
        public TextView mTvNewConfirmed_num;
    }
}
