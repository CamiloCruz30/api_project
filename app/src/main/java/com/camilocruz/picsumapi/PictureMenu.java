package com.camilocruz.picsumapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.camilocruz.picsumapi.Api.RetrofitClient;
import com.camilocruz.picsumapi.adapters.ImageListAdapter;
import com.camilocruz.picsumapi.models.ImageListModel;
import com.camilocruz.picsumapi.models.SearchImageModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PictureMenu extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public ListView listViewXml ;
    List<ImageListModel> listResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_menu);

        listViewXml = findViewById(R.id.list_view_image_list);
        getFromInternetImagesList();
        listViewXml.setOnItemClickListener(this);
    }

    private void  getFromInternetImagesList(){
        Call<List<ImageListModel>> call = RetrofitClient.getInstance().getMyApi().getImageList();
        call.enqueue(new Callback<List<ImageListModel>>() {
            @Override
            public void onResponse(Call<List<ImageListModel>> call, Response<List<ImageListModel>> response) {
                if(response.isSuccessful()){
                    listResponse = response.body();
                      //    for (int i = 0; i < listResponse.size(); i++){
                  //      String m = listResponse.get(i).getAuthor();
                    //    Toast.makeText(getApplicationContext(), m, Toast.LENGTH_SHORT).show();
                   // }
                    ImageListAdapter adapter = new ImageListAdapter(PictureMenu.this, listResponse);
                    listViewXml.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<ImageListModel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "error de red", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(getApplicationContext(), PictureDetail.class);
        i.putExtra("objectAuction", listResponse.get(position));
        startActivity(i);
    }

    private void  getFromInternetImogesList() {
        Call<List<SearchImageModel>> call = RetrofitClient.getInstance().getMyApi().getSearchImageList();
    }
}