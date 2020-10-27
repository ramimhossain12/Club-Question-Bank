package com.example.programmingquestionbank.Image;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.programmingquestionbank.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterMy extends RecyclerView.Adapter<AdapterMy.ViewHolder> {

    private Context context;
    private List<ImageUpload> uploadList;

    public AdapterMy(Context context, List<ImageUpload> uploadList) {
        this.context = context;
        this.uploadList = uploadList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ImageUpload imageUpload = uploadList.get(position);
        holder.textView.setText(imageUpload.getImageName());
        Picasso.get().load(imageUpload.getImageUrl())
                .placeholder(R.mipmap.ic_launcher_round)
                .fit()
                .centerCrop()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return uploadList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.cardTextViewID);
            imageView = itemView.findViewById(R.id.cardImageViewID);
        }
    }
}
