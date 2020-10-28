package com.example.programmingquestionbank.Image;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
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
    private  OnItemClickListener listener;

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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnCreateContextMenuListener , MenuItem.OnMenuItemClickListener {

        TextView textView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.cardTextViewID);
            imageView = itemView.findViewById(R.id.cardImageViewID);
            itemView.setOnClickListener(this);
            itemView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener!= null){
                int  position = getAdapterPosition();
                if (position!=RecyclerView.NO_POSITION){
                    listener.onItemClick(position);
                }
            }
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

            menu.setHeaderTitle("Choose an action");
            menu.setHeaderIcon(R.drawable.arrow);
            MenuItem doAnyTask = menu.add(Menu.NONE,1,1,"do any task");
            MenuItem delete = menu.add(Menu.NONE,2,1,"delete ");

            doAnyTask.setOnMenuItemClickListener(this);
            delete.setOnMenuItemClickListener(this);
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {

            if (listener!= null){
                int  position = getAdapterPosition();
                if (position!=RecyclerView.NO_POSITION){
                    switch (item.getItemId()){
                        case 1:
                          listener.OndoAnyTask(position);
                         return true;
                        case 2:
                            listener.Ondelete(position);
                            return true;
                    }
                }
            }
            return false;
        }
    }

    public  interface  OnItemClickListener{

        void  onItemClick(int position);
        void  OndoAnyTask(int position);
        void  Ondelete (int position);
    }
    public  void  setOnItemClickListener(OnItemClickListener listener){

        this.listener = listener;

    }

}
