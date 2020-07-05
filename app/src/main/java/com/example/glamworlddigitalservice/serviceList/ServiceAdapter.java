package com.example.glamworlddigitalservice.serviceList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glamworlddigitalservice.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ImageViewHolder> {
    private Context mContext;
    private List<Upload_Service> mUploadServices;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{

        void onItemCLick(int positon);
    }




    public void setOnItemClickListener(OnItemClickListener listener){

        mListener = listener;

    }


    public ServiceAdapter(Context context, List<Upload_Service> uploadServices)
    {
        mContext=context;
        mUploadServices = uploadServices;

    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(mContext).inflate(R.layout.image_item, viewGroup,false);
        return  new ImageViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {
        Upload_Service uploadServiceCur = mUploadServices.get(i);
        imageViewHolder.img_description.setText(uploadServiceCur.getImgName());
        Picasso.get()
                .load(uploadServiceCur.getImgUrl())
                .placeholder(R.drawable.imagepreview)
                .fit()
                .centerCrop()
                .into(imageViewHolder.image_view);



    }

    @Override
    public int getItemCount() {
        return mUploadServices.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{
        public TextView img_description;
        public ImageView image_view;
        public  TextView img_price;
        public  TextView img_details;




        public ImageViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            img_description=itemView.findViewById(R.id.img_description);
            image_view=itemView.findViewById(R.id.image_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){

                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){

                            listener.onItemCLick(position);
                        }
                    }

                }
            });




        }


    }


}