package com.oguz.coinfo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Models.CoinModel;
import adapter.HomePageAdapter;

public class HomeFragment extends Fragment {

    private FirebaseFirestore firebaseFirestore;
    ArrayList<CoinModel> coins;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home, container,false);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        coins = new ArrayList<>();
        System.out.println("burası");

        getData();

        System.out.println("takıldı");
        /*RecyclerView recyclerView = view.findViewById(R.id.recyclerViewHome);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(new HomePageAdapter(coins));
        System.out.println("yok takılmadı");*/



        return view;
        // Inflate the layout for this fragment

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




    }


    private void getData(){

        System.out.println("now");

        firebaseFirestore.collection("Coins").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        System.out.println("he");
                        if(task.isSuccessful()){
                            System.out.println("yok");
                            for(QueryDocumentSnapshot document : task.getResult()){
                                Map<String, Object> data = document.getData();
                                System.out.println("veri");

                                String name =  (String)data.get("name");
                                String marketCap =  (String)data.get("marketCap");
                                String price = (String) data.get("price");
                                String priceWay = (String) data.get("priceWay");
                                String change24h =  (String) data.get("change24h");

                                System.out.println("hadi lan");
                                System.out.println(name);

                                CoinModel coinModel = new CoinModel(name, marketCap, price, priceWay, change24h);
                                coins.add(coinModel);
                            }

                        }
                        else{
                            System.out.println("fail");
                        }
                    }
                });
    }
}