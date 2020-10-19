package com.mismascotasfavoritas.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mismascotasfavoritas.R;
import com.mismascotasfavoritas.adapter.MisMascotasFavoritoAdapter;
import com.mikhaellopez.circularimageview.CircularImageView;


public class FragmentoDePerfil extends Fragment {

    private CircularImageView perfil;
    private TextView textoFavorito;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_perfil,container,false);
        RecyclerView recyclerViewFavoritoMascotas = v.findViewById(R.id.recyclerFavorito);
        GridLayoutManager grid = new GridLayoutManager(getActivity(), 3);

        recyclerViewFavoritoMascotas.setLayoutManager(grid);


        RecyclerViewFragment.calcularDatosFavorito();

        perfil = v.findViewById(R.id.circularImageView);
        textoFavorito = v.findViewById(R.id.txt_mascotaFavorita);



        perfil.setCircleColor(R.color.colorAccent);
        perfil.setBorderColor(R.color.colorPrimaryDark);
        perfil.setShadowColor(R.color.colorAccent);
        perfil.setImageResource(RecyclerViewFragment.favorita.getFoto());
        perfil.setElevation(10);

        textoFavorito.setText(RecyclerViewFragment.favorita.getNombre());



        MisMascotasFavoritoAdapter adaptador = new MisMascotasFavoritoAdapter(RecyclerViewFragment.favorita);

        recyclerViewFavoritoMascotas.setAdapter(adaptador);

        return v;
    }




}



