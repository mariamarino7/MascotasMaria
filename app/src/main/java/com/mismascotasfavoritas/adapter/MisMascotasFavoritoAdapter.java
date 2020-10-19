package com.mismascotasfavoritas.adapter;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mismascotasfavoritas.Mascota;
import com.mismascotasfavoritas.R;
import com.mismascotasfavoritas.fragments.RecyclerViewFragment;


public class MisMascotasFavoritoAdapter extends RecyclerView.Adapter<MisMascotasFavoritoAdapter.MyViewHolder> {
    private Mascota mascotaFavorita;


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageViewFavoritoListItem;
        private final TextView cantidadLikes;
        private final ImageView imagenLikes;




        public MyViewHolder(View itemView) {
            super(itemView);



            imageViewFavoritoListItem = itemView.findViewById(R.id.image_favorito_list_item);
            imagenLikes= itemView.findViewById(R.id.imagenlikesPerfil);
            cantidadLikes = itemView.findViewById(R.id.txt_numeroLikes);
        }
    }

    public MisMascotasFavoritoAdapter(Mascota mascota) {
                mascotaFavorita=mascota;
    }


    @Override
    public MisMascotasFavoritoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View element = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.perfil_items_gridlayout, parent, false);
        return new MisMascotasFavoritoAdapter.MyViewHolder(element);
    }

    @Override
    public void onBindViewHolder(@NonNull MisMascotasFavoritoAdapter.MyViewHolder holder, final int position) {


        final TextView textRateInt = holder.cantidadLikes;
        holder.imageViewFavoritoListItem.setImageResource(mascotaFavorita.getImagen().get(position));
        textRateInt.setText(String.valueOf(mascotaFavorita.getCalificacion()));
        holder.imagenLikes.setImageResource(R.drawable.ic_pet_food_yellow);

    }

    @Override
    public int getItemCount() {
        if (RecyclerViewFragment.favorita!= null) {
            return RecyclerViewFragment.favorita.getImagen().size();
        }else {
            return 0;
        }
    }
}







