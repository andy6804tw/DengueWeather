package com.andy6804tw.dengueweather.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andy6804tw.dengueweather.DataModle.NoticeModel;
import com.andy6804tw.dengueweather.R;

import java.util.ArrayList;

/**
 * Created by apple on 2017/8/14.
 */

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<NoticeModel>list;

    public NoticeAdapter(Context context, ArrayList<NoticeModel>list){
        this.list=list;
        mContext=context;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivImage;
        private TextView tvRegion,tvDetail,tvDate;
        private CardView cardView;


        public ViewHolder(View itemView) {
            super(itemView);
            ivImage=(ImageView)itemView.findViewById(R.id.ivImage);
            tvRegion=(TextView)itemView.findViewById(R.id.tvRegion);
            tvDetail=(TextView)itemView.findViewById(R.id.tvDetail);
            tvDate=(TextView)itemView.findViewById(R.id.tvDate);
            cardView=(CardView)itemView.findViewById(R.id.cardView);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_notice_news_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        viewHolder.tvRegion.setText(list.get(position).getRegion());
        viewHolder.tvDetail.setText(list.get(position).getDetail());
        viewHolder.tvDate.setText(list.get(position).getDate());
        if(list.get(position).getLevel().equals("1"))
            viewHolder.ivImage.setImageResource(R.mipmap.ic_alert1);
        else if(list.get(position).getLevel().equals("2"))
            viewHolder.ivImage.setImageResource(R.mipmap.ic_alert2);
        else
            viewHolder.ivImage.setImageResource(R.mipmap.ic_alert3);
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(list.get(position).getUrl())));
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
