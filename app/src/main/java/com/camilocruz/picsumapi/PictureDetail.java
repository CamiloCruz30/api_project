package com.camilocruz.picsumapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.camilocruz.picsumapi.models.ImageListModel;
import com.squareup.picasso.Picasso;

public class PictureDetail extends AppCompatActivity {

    TextView id;
    TextView author;
    TextView width;
    TextView height;
    ImageView download_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageListModel imageListModel = (ImageListModel) getIntent().getSerializableExtra("objectAuction");
        setContentView(R.layout.activity_picture_detail);

        id = findViewById(R.id.text_view_id_details);
        id.setText(imageListModel.getId());

        author = findViewById(R.id.text_view_author_details);
        author.setText(imageListModel.getAuthor());

        width = findViewById(R.id.text_view_width_details);
        width.setText(imageListModel.getWidth());

        height = findViewById(R.id.text_view_height_details);
        height.setText(imageListModel.getHeight());


        download_url = findViewById(R.id.image_view_details);
        Picasso.get().load(imageListModel.getDownload_url()).into(download_url);

    }
}