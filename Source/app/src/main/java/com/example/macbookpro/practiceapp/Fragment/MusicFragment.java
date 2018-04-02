package com.example.macbookpro.practiceapp.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.macbookpro.practiceapp.Adapter.MusicTypeAdapter;
import com.example.macbookpro.practiceapp.Model.MusicType;
import com.example.macbookpro.practiceapp.Network.MusicInterface;
import com.example.macbookpro.practiceapp.Network.MusicTypeResponseJSON;
import com.example.macbookpro.practiceapp.Network.RetrofitInstance;
import com.example.macbookpro.practiceapp.R;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class MusicFragment extends Fragment {

    private AVLoadingIndicatorView avi;
    private RecyclerView rclMusicType;
    private Context context;
    private List<MusicType> musicTypeList = new ArrayList<>();
    MusicTypeAdapter adapter;

    public MusicFragment() {
        // Required empty public constructor
    }

    public static MusicFragment newInstance() {

        Bundle args = new Bundle();

        MusicFragment fragment = new MusicFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music, container, false);

        adapter = new MusicTypeAdapter(musicTypeList, getContext());
        rclMusicType = view.findViewById(R.id.rlv_music_type);
        avi = view.findViewById(R.id.avi);

        rclMusicType.setAdapter(adapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (position % 3 == 0 ? 2 : 1);
            }
        });

        rclMusicType.setLayoutManager(gridLayoutManager);
        loadData();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void loadData() {
        MusicInterface musicInterface = RetrofitInstance.getInstance().create(MusicInterface.class);
        avi.show();
        musicInterface.getMusicType().enqueue(new Callback<MusicTypeResponseJSON>() {
            @Override
            public void onResponse(Call<MusicTypeResponseJSON> call, Response<MusicTypeResponseJSON> response) {
                List<MusicTypeResponseJSON.MusicTypeJSON> list = response.body().subgenres;

                for (MusicTypeResponseJSON.MusicTypeJSON items : list) {
                    String id = items.getId();
                    String musicName = items.getTranslation_key();
                    int imageId = getContext().getResources().getIdentifier(
                            "genre_x2_" + items.getId(),
                            "raw",
                            getContext().getPackageName());
                    Log.e("image", "" + imageId);
                    musicTypeList.add(new MusicType(id, musicName, imageId));
                }
                avi.hide();
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<MusicTypeResponseJSON> call, Throwable t) {
                Toast.makeText(getContext(), "No Internet!", Toast.LENGTH_LONG).show();
            }
        });

    }
}
