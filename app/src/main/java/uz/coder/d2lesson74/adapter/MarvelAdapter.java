package uz.coder.d2lesson74.adapter;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;


import java.util.List;


import uz.coder.d2lesson74.databinding.ItemLayoutBinding;
import uz.coder.d2lesson74.model.MarvelData;

public class MarvelAdapter extends  RecyclerView.Adapter<MarvelAdapter.VH> {
    private List<MarvelData> marvelDataList;
    private int checkCount = 5000;
    public MarvelAdapter(List<MarvelData> marvelDataList) {
        this.marvelDataList = marvelDataList;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(ItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.itemLayoutBinding.name.setText(marvelDataList.get(position).getName());
        holder.itemLayoutBinding.realName.setText(marvelDataList.get(position).getRealname());
        holder.itemLayoutBinding.team.setText(marvelDataList.get(position).getTeam());
        holder.itemLayoutBinding.fApp.setText(marvelDataList.get(position).getFirstappearance());
        holder.itemLayoutBinding.publisher.setText(marvelDataList.get(position).getPublisher());
        String s = marvelDataList.get(position).getBio();
        String imageurl = marvelDataList.get(position).getImageurl();
       






        Handler handler = new Handler();  // handler object
        // runnable class
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                holder.itemLayoutBinding.progress.setVisibility(View.VISIBLE);
                checkCount -= 1000;
                if(checkCount > 0) {
                    handler.postDelayed(this,1000);
                }
                else {

                    holder.itemLayoutBinding.progress.setVisibility(View.INVISIBLE);
                    Toast.makeText(holder.itemView.getContext(),"Progress bar invisible",Toast.LENGTH_SHORT).show();
                    // Or your other work
                }
            }
        };

        handler.postDelayed(runnable,1000);  // will start run() method after 1 second

    }

    @Override
    public int getItemCount() {
        return marvelDataList.size();
    }

    public static class VH extends RecyclerView.ViewHolder{
        ItemLayoutBinding itemLayoutBinding;
        public VH(@NonNull ItemLayoutBinding itemLayoutBinding) {
            super(itemLayoutBinding.getRoot());
            this.itemLayoutBinding = itemLayoutBinding;

        }
    }
}
