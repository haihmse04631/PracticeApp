package com.example.macbookpro.practiceapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.macbookpro.practiceapp.Model.MusicType;
import com.example.macbookpro.practiceapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by MacbookPro on 3/26/18.
 */

public class MusicTypeAdapter extends RecyclerView.Adapter<MusicTypeAdapter.MusicTypeViewHolder> {
    List<MusicType> musicTypeList;
    Context context;

    public MusicTypeAdapter(List<MusicType> musicTypeList, Context context) {
        this.musicTypeList = musicTypeList;
        this.context = context;
    }

    @Override
    public MusicTypeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_music_type, parent, false);
        return new MusicTypeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MusicTypeViewHolder holder, int position) {
        holder.setData(musicTypeList.get(position));
    }

    @Override
    public int getItemCount() {
        return musicTypeList.size();
    }

    public class MusicTypeViewHolder extends RecyclerView.ViewHolder{
        ImageView ivMusicType;
        TextView tvMusicType;
        View view;

        public MusicTypeViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            ivMusicType = itemView.findViewById(R.id.iv_music_type);
            tvMusicType = itemView.findViewById(R.id.tv_music_type);
        }

        public void setData(MusicType musicType){
            Picasso.with(context).load(musicType.getImageID()).into(ivMusicType);
            tvMusicType.setText(musicType.getTypeName());
        }
    }

}
