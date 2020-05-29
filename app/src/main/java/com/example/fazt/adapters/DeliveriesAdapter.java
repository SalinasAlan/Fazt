package com.example.fazt.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.fazt.R;
import com.example.fazt.models.DeliveriesModel;
import com.example.fazt.ui.deliveries.DeliveriesFragment;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class DeliveriesAdapter extends FirebaseRecyclerAdapter<DeliveriesModel, DeliveriesAdapter.ViewHolder> {

    private Context mcontext;

    public DeliveriesAdapter(FirebaseRecyclerOptions<DeliveriesModel> options, Context context ) {
        super(options);
        mcontext = context;
    }

    @Override
    protected void onBindViewHolder( ViewHolder holder, int position, DeliveriesModel deliveries) {

        holder.textView_title.setText(deliveries.getTitle());
        holder.textView_custumer.setText(deliveries.getCustumer());
        holder.textView_direction.setText(deliveries.getDirection());
        holder.textView_description.setText(deliveries.getDescription());
        holder.textView_item.setText(deliveries.getItem());
        holder.textView_daliveryDate.setText(deliveries.getDaliveryDate());



    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.deliveries, parent, false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView_title, textView_custumer, textView_direction, textView_description, textView_item, textView_daliveryDate;

        public ViewHolder(View itemView) {
            super(itemView);

            textView_title = itemView.findViewById(R.id.textView_title);
            textView_custumer = itemView.findViewById(R.id.textView_custumer);
            textView_direction = itemView.findViewById(R.id.textView_direction);
            textView_description = itemView.findViewById(R.id.textView_description);
            textView_item = itemView.findViewById(R.id.textView_item);
            textView_daliveryDate = itemView.findViewById(R.id.textView_daliveryDate);
        }
    }

}
