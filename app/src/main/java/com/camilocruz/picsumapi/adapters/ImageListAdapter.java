package com.camilocruz.picsumapi.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.camilocruz.picsumapi.R;
import com.camilocruz.picsumapi.models.ImageListModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageListAdapter extends BaseAdapter {
    protected Activity activity;
    protected List<ImageListModel> imageListModelList;

    public ImageListAdapter(Activity activity, List<ImageListModel> imageList){
        this.activity = activity;
        this.imageListModelList = imageList;
    }

    @Override
    public int getCount() {
        return imageListModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return imageListModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        
        View v = convertView;
        
        if(convertView == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.activity_element_picture_menu, null);
        }

        ImageListModel imageListModel = imageListModelList.get(position);

        TextView text_view_id     = v.findViewById(R.id.text_view_id);
        TextView text_view_author = v.findViewById(R.id.text_view_author);
        TextView text_view_url    = v.findViewById(R.id.text_view_url);


        ImageView image_view_download_url = v.findViewById(R.id.imageViewPicsum);

        text_view_id.setText(imageListModel.getId());
        text_view_author.setText(imageListModel.getAuthor());
        text_view_url.setText(imageListModel.getUrl());

        Picasso.get().load(imageListModel.getDownload_url()).into(image_view_download_url);

        return v;
    }
}
