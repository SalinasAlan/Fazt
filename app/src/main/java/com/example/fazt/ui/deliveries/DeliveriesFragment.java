package com.example.fazt.ui.deliveries;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fazt.R;
import com.example.fazt.adapters.DeliveriesAdapter;
import com.example.fazt.models.DeliveriesModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.security.AuthProvider;

public class DeliveriesFragment extends Fragment {

    private DeliveriesViewModel deliveriesViewModel;

    private RecyclerView recyclerView;
    private DeliveriesAdapter adapter;
    private AuthProvider authProvider;
    private FirebaseDatabase FirebaseDatabase;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        deliveriesViewModel =
                ViewModelProviders.of(this).get(DeliveriesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_deliveries, container, false);
        /*final TextView textView = root.findViewById(R.id.text_dashboard);
        deliveriesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

         */

        recyclerView = root.findViewById(R.id.recycleView_deliveries);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        return root;
    }

    @Override
    public void onStart() {
        super.onStart();

        //authProvider = new AuthProvider();

        Query query = FirebaseDatabase.getInstance().getReference()
                            .child("Deliveries")
                            .orderByChild("id");

        FirebaseRecyclerOptions<DeliveriesModel> options = new FirebaseRecyclerOptions.Builder<DeliveriesModel>()
                .setQuery(query, DeliveriesModel.class)
                .build();

        adapter = new DeliveriesAdapter(options, getContext());

        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
