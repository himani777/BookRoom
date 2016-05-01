package com.example.gangwars.bookroom;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by gangwars on 26-04-2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> implements View.OnClickListener {

    ImageView imageView;
    ArrayList<String> data;
    Context context;

    RecyclerAdapter(ArrayList<String> data,Context context){
        this.context=context;
        this.data=data;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewimage, parent, false);
       ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        imageView=(ImageView)holder.v.findViewById(R.id.micon);
//        animation= AnimationUtils.loadAnimation(context, R.anim.zoom_in);
//        animation.setDuration(1500);
        switch(position){
            case 0:imageView.setImageResource(R.drawable.a);
                break;
            case 1:imageView.setImageResource(R.drawable.b);
                break;
            case 2:imageView.setImageResource(R.drawable.c);

                break;
            case 3:imageView.setImageResource(R.drawable.d);
                break;
            case 4:imageView.setImageResource(R.drawable.e);
                break;
            case 5:imageView.setImageResource(R.drawable.f);
                break;
            case 6:imageView.setImageResource(R.drawable.g);
                break;
            default: break;
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(0, 0, 0, 0);
//        imageView.startAnimation(animation);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View v) {

    }

    public  static class ViewHolder extends RecyclerView.ViewHolder {

        View v;
        public ViewHolder(View itemView) {
            super(itemView);
            v=itemView;
        }
    }
}
