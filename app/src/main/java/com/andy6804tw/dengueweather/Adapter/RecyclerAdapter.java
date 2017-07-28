package com.andy6804tw.dengueweather.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.andy6804tw.dengueweather.R;
import com.github.pwittchen.weathericonview.WeatherIconView;

/**
 * Created by andy6804tw on 2017/7/27.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private Context mContext;

    public RecyclerAdapter(Context context){
        mContext=context;
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        private WeatherIconView weatherIconView;

        public ViewHolder(View itemView) {
            super(itemView);
            weatherIconView = (WeatherIconView) itemView.findViewById(R.id.my_weather_icon);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        //天氣圖示
        viewHolder.weatherIconView.setIconSize(25);
        viewHolder.weatherIconView.setIconColor(Color.WHITE);
        viewHolder.weatherIconView.setIconResource(weatherIcon(15));
    }

    @Override
    public int getItemCount() {
        return 10;
    }
    public String weatherIcon(int code){
        //天氣圖示
        if(code==0)
            return mContext.getString(R.string.wi_yahoo_0);
        else if(code==1)
            return mContext.getString(R.string.wi_yahoo_1);
        else if(code==2)
            return mContext.getString(R.string.wi_yahoo_2);
        else if(code==3)
            return mContext.getString(R.string.wi_yahoo_3);
        else if(code==4)
            return mContext.getString(R.string.wi_yahoo_4);
        else if(code==5)
            return mContext.getString(R.string.wi_yahoo_5);
        else if(code==6)
            return mContext.getString(R.string.wi_yahoo_6);
        else if(code==7)
            return mContext.getString(R.string.wi_yahoo_7);
        else if(code==8)
            return mContext.getString(R.string.wi_yahoo_8);
        else if(code==9)
            return mContext.getString(R.string.wi_yahoo_9);
        else if(code==10)
            return mContext.getString(R.string.wi_yahoo_10);
        else if(code==11)
            return mContext.getString(R.string.wi_yahoo_11);
        else if(code==12)
            return mContext.getString(R.string.wi_yahoo_12);
        else if(code==13)
            return mContext.getString(R.string.wi_yahoo_13);
        else if(code==14)
            return mContext.getString(R.string.wi_yahoo_14);
        else if(code==15)
            return mContext.getString(R.string.wi_yahoo_15);
        else if(code==16)
            return mContext.getString(R.string.wi_yahoo_16);
        else if(code==17)
            return mContext.getString(R.string.wi_yahoo_17);
        else if(code==18)
            return mContext.getString(R.string.wi_yahoo_18);
        else if(code==19)
            return mContext.getString(R.string.wi_yahoo_19);
        else if(code==20)
            return mContext.getString(R.string.wi_yahoo_20);
        else if(code==21)
            return mContext.getString(R.string.wi_yahoo_21);
        else if(code==22)
            return mContext.getString(R.string.wi_yahoo_22);
        else if(code==23)
            return mContext.getString(R.string.wi_yahoo_23);
        else if(code==24)
            return mContext.getString(R.string.wi_yahoo_24);
        else if(code==25)
            return mContext.getString(R.string.wi_yahoo_25);
        else if(code==26)
            return mContext.getString(R.string.wi_yahoo_26);
        else if(code==27)
            return mContext.getString(R.string.wi_yahoo_27);
        else if(code==28)
            return mContext.getString(R.string.wi_yahoo_28);
        else if(code==29)
            return mContext.getString(R.string.wi_yahoo_29);
        else if(code==30)
            return mContext.getString(R.string.wi_yahoo_30);
        else if(code==31)
            return mContext.getString(R.string.wi_yahoo_31);
        else if(code==32)
            return mContext.getString(R.string.wi_yahoo_32);
        else if(code==33)
            return mContext.getString(R.string.wi_yahoo_33);
        else if(code==34)
            return mContext.getString(R.string.wi_yahoo_34);
        else if(code==35)
            return mContext.getString(R.string.wi_yahoo_35);
        else if(code==36)
            return mContext.getString(R.string.wi_yahoo_36);
        else if(code==37)
            return mContext.getString(R.string.wi_yahoo_37);
        else if(code==38)
            return mContext.getString(R.string.wi_yahoo_38);
        else if(code==39)
            return mContext.getString(R.string.wi_yahoo_39);
        else if(code==40)
            return mContext.getString(R.string.wi_yahoo_40);
        else if(code==41)
            return mContext.getString(R.string.wi_yahoo_41);
        else if(code==42)
            return mContext.getString(R.string.wi_yahoo_42);
        else if(code==43)
            return mContext.getString(R.string.wi_yahoo_43);
        else if(code==44)
            return mContext.getString(R.string.wi_yahoo_44);
        else if(code==45)
            return mContext.getString(R.string.wi_yahoo_45);
        else if(code==46)
            return mContext.getString(R.string.wi_yahoo_46);
        else if(code==47)
            return mContext.getString(R.string.wi_yahoo_47);
        else
            return mContext.getString(R.string.wi_yahoo_3200);
    }
}