package com.andy6804tw.dengueweather.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andy6804tw.dengueweather.Adapter.NoticeAdapter;
import com.andy6804tw.dengueweather.DataModle.NoticeModel;
import com.andy6804tw.dengueweather.R;
import com.andy6804tw.dengueweather.Utils.FlowLayout;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoticeFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    private ArrayList<NoticeModel> list;
    private FlowLayout mFlowLayout;//標籤view

    public NoticeFragment() {
        // Required empty public constructor
    }
    private String[] mVals =new String[]{
            "Dengue","Zika","Rabies","Measles","All"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_notice, container, false);

        setHasOptionsMenu(true);//來告知這個fragment有另外的OptionsMenu(參考)
        recyclerView =(RecyclerView) view.findViewById(R.id.recycler_view);
        mFlowLayout = (FlowLayout) view.findViewById(R.id.flowLayout);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        initData();
        initView();
        adapter = new NoticeAdapter(getContext(),list);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void initData() {
        list=new ArrayList<>();
        for(int i=0;i<level.length;i++){
            list.add(new NoticeModel(level[i],region[i],date[i],detail[i],url[i]));
        }
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_item, menu);

        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(queryListener);//QueryListener的監聽事件

    }
    final private android.support.v7.widget.SearchView.OnQueryTextListener queryListener = new android.support.v7.widget.SearchView.OnQueryTextListener() {

        @Override
        public boolean onQueryTextChange(String newText) {

            ArrayList<NoticeModel>myList=new ArrayList<>();
            newText=newText.toLowerCase();
            initData();
            for(int i=0;i<list.size();i++){
                if (list.get(i).getRegion().toLowerCase().contains(newText) || list.get(i).getDetail().toLowerCase().contains(newText)) {
                    myList.add(list.get(i));
                }
            }
            adapter = new NoticeAdapter(getContext(),myList);
            recyclerView.setAdapter(adapter);
            //Log.e("query",newText);
            return true;
        }

        @Override
        public boolean onQueryTextSubmit(String query) {
            Log.d(TAG, "submit:"+query);
            return false;
        }
    };
    private void initView() {

        LayoutInflater mInflater = LayoutInflater.from(getActivity());
        for (int i = 0; i < mVals.length; i++) {
            final TextView tv = (TextView) mInflater.inflate(R.layout.textview, mFlowLayout, false);
            tv.setText(mVals[i]);
            mFlowLayout.addView(tv);

            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final ArrayList<NoticeModel>myList=new ArrayList<>();
                    initData();
                    if(tv.getText().toString().equals("All"))
                        myList.addAll(list);
                    else{
                        for(int i=0;i<list.size();i++){
                            if (list.get(i).getRegion().toLowerCase().contains(tv.getText().toString().toLowerCase()) || list.get(i).getDetail().toLowerCase().contains(tv.getText().toString().toLowerCase())) {
                                myList.add(list.get(i));
                            }
                        }
                    }

                    adapter = new NoticeAdapter(getContext(),myList);
                    recyclerView.setAdapter(adapter);
                }
            });

        }
    }

    String[] level={"2","3","1","1","1","2","1","1","1","1","1","1","1"};
    String[] region={"Dengue in Sri Lanka","Rabies in Malaysia","Measles in Democratic Republic of the Congo","Measles in France","Chickenpox (varicella) in Pakistan",
    "Dengue in Fiji","Malaria in Burundi","Measles in Belgium","Measles in Germany","Measles in Italy","Measles in Indonesia","Measles in Guinea",
    "Avian Flu (H7N9) in China"};
    String[] date={"August 09, 2017","August 09, 2017","July 07, 2017","July 07, 2017","June 02, 2017","May 12, 2017","April 24, 2017","April 17, 2017",
    "April 17, 2017","April 17, 2017","April 07, 2017","March 10, 2017","March 07, 2017"};
    String[] detail={"The Ministry of Health in Sri Lanka has reported a dengue epidemic. More than 100,000 cases have been reported across the country.",
    "The Malaysian state of Sarawak has declared parts of three divisions to be “rabies infectious areas.”",
    "Health officials in the Democratic Republic of the Congo have reported an outbreak of measles.",
    "Health officials in France have reported an outbreak of measles.",
    "Health officials in Pakistan have reported a large outbreak of chickenpox, also known as varicella. Cases in children and adults, including deaths, have been reported in 10 districts.",
    "The Fiji Ministry of Health and Medical Services has declared a dengue outbreak. Travelers to Fiji should protect themselves against mosquito bites to avoid getting dengue.",
    "A malaria epidemic has been declared by the Burundi Ministry of Health. CDC continues to recommend that travelers to Burundi take prescription medicine to prevent malaria.",
    "Health officials in Belgium have reported an outbreak of measles. CDC recommends that travelers to Belgium protect themselves by making sure they are vaccinated against measles.",
    "Health officials in Germany have reported an outbreak of measles. CDC recommends that travelers to Germany protect themselves by making sure they are vaccinated against measles.",
    "Health officials in Italy have reported an outbreak of measles. CDC recommends that travelers to Italy protect themselves by making sure they are vaccinated against measles.",
    "Health officials in Australia, Canada, and Taiwan have reported several cases of measles in travelers returning from Indonesia, including the island of Bali.",
    "A measles outbreak has been reported in Guinea, with 13 of the country’s 33 prefectures affected. CDC recommends that travelers to Guinea protect themselves by making sure they are vaccinated against measles, particularly infants 6–11 months of age (1 dose of measles vaccine) and children 12 months of age or older (2 doses of measles vaccine). Clinicians should keep measles in mind when treating patients with fever and rash, especially if the patient has recently traveled internationally.",
    "Chinese health authorities have confirmed human cases of avian influenza A (H7N9) since September 2016. CDC advises people traveling to China to avoid contact with poultry (including poultry markets and farms), birds, and their droppings and to avoid eating undercooked poultry. Infected birds that appear healthy may still be able to transmit this virus to humans.",};
    String[] url={"https://wwwnc.cdc.gov/travel/notices/watch/dengue-sri-lanka",
    "https://wwwnc.cdc.gov/travel/notices/alert/rabies-malaysia",
    "https://wwwnc.cdc.gov/travel/notices/watch/measles-democratic-republic-of-the-congo",
    "https://wwwnc.cdc.gov/travel/notices/watch/measles-france",
    "https://wwwnc.cdc.gov/travel/notices/watch/chickenpox-pakistan",
    "https://wwwnc.cdc.gov/travel/notices/watch/dengue-fiji",
    "https://wwwnc.cdc.gov/travel/notices/watch/malaria-burundi",
    "https://wwwnc.cdc.gov/travel/notices/watch/measles-belgium",
    "https://wwwnc.cdc.gov/travel/notices/watch/measles-germany",
    "https://wwwnc.cdc.gov/travel/notices/watch/measles-italy",
    "https://wwwnc.cdc.gov/travel/notices/watch/measles-indonesia",
    "https://wwwnc.cdc.gov/travel/notices/watch/measles-guinea",
    "https://wwwnc.cdc.gov/travel/notices/watch/avian-flu-h7n9"};

}
