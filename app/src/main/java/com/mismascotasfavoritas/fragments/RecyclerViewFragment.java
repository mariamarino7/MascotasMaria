package com.mismascotasfavoritas.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mismascotasfavoritas.Mascota;
import com.mismascotasfavoritas.R;
import com.mismascotasfavoritas.adapter.ListadoMascotasAdapter;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    public static ArrayList<Mascota> datosMascotas;

    public static ArrayList<Mascota> mascotasFavoritas = new ArrayList<>();

    public static Mascota favorita;
    ListadoMascotasAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmentrecyclerview_listado,container,false);
        RecyclerView recyclerViewListaMascotas = v.findViewById(R.id.recycler_view_layout);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewListaMascotas.setLayoutManager(layoutManager);

        inicializarlosDatos();


        adapter = new ListadoMascotasAdapter(datosMascotas);
        recyclerViewListaMascotas.setAdapter(adapter);



        return v;
    }

    public void inicializarlosDatos() {
        datosMascotas = new ArrayList<>();
        datosMascotas.add(new Mascota(R.drawable.conejo, getString(R.string.Conejo)));

        datosMascotas.add(new Mascota(R.drawable.elefante, getString(R.string.Elefante)));


        datosMascotas.add(new Mascota(R.drawable.panda, getString(R.string.Panda)));

        datosMascotas.add(new Mascota(R.drawable.perro, getString(R.string.Perro)));

        datosMascotas.add(new Mascota(R.drawable.hipopotamo, getString(R.string.Hipopotamo)));

        datosMascotas.add(new Mascota(R.drawable.koala, getString(R.string.Koala)));

        datosMascotas.add(new Mascota(R.drawable.leon, getString(R.string.Leon)));

        datosMascotas.add(new Mascota(R.drawable.llama, getString(R.string.Llama)));

        datosMascotas.add(new Mascota(R.drawable.oveja, getString(R.string.Oveja)));

        datosMascotas.add(new Mascota(R.drawable.pavoreal, getString(R.string.Pavo)));

        datosMascotas.add(new Mascota(R.drawable.pinguino, getString(R.string.Pinguino)));

        datosMascotas.add(new Mascota(R.drawable.vaca, getString(R.string.Vaca)));

    }

    public static void calcularDatosFavorito() {

        mascotasFavoritas.add(datosMascotas.get(0));
        boolean set;

        for (int firstList = 1; firstList < datosMascotas.size(); firstList++) {
            set = false;
            for (int secondList = 0; (secondList < mascotasFavoritas.size() && !set); secondList++) {

                if (datosMascotas.get(firstList).getCalificacion() >= mascotasFavoritas.get(secondList).getCalificacion()) {
                    mascotasFavoritas.add(secondList, datosMascotas.get(firstList));
                    set = true;

                }
            }
            if (!set) mascotasFavoritas.add(datosMascotas.get(firstList));
        }
        mascotasFavoritas.subList(5, mascotasFavoritas.size()).clear();
        cargarImagenes(8);
    }

    public static void cargarImagenes(int cantidad) {

        for (int x = 0; x <= cantidad; x++) {
            RecyclerViewFragment.favorita = mascotasFavoritas.get(0);
            RecyclerViewFragment.favorita.setImagen(RecyclerViewFragment.favorita.getFoto());

        }
    }



    }

