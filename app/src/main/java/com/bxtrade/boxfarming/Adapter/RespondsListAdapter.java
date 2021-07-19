package com.bxtrade.boxfarming.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bxtrade.boxfarming.Global.NetworkState;
import com.bxtrade.boxfarming.R;

import java.util.List;

public class RespondsListAdapter extends RecyclerView.Adapter<RespondsListAdapter.RespondsListViewHolder> {

    private Context context;
    private List<String> respondCodeArray;
    private List<String> dateRespondsArray;
    private List<String> itemNameArray;
    private List<String> quantityArray;
    private List<String> sellerNameArray;
    private List<String> sellerContactArray;
    private List<String> respondedOrNotRespondedArray;

    private NetworkState networkState;

    public RespondsListAdapter(Context context, List<String>respondCode,  List<String>dateResponds,
                               List<String>itemName,  List<String>quantity,  List<String>sellerName,
                               List<String>sellerContact,  List<String>respondedOrNotResponded){
        this.respondCodeArray = respondCode;
        this.dateRespondsArray = dateResponds;
        this.itemNameArray = itemName;
        this.quantityArray = quantity;
        this.sellerNameArray = sellerName;
        this.sellerContactArray = sellerContact;
        this.respondedOrNotRespondedArray = respondedOrNotResponded;

        this.context = context;
        networkState = new NetworkState();
    }
    @NonNull
    @Override
    public RespondsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.responds_list_view_layout, parent, false);
        return new RespondsListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RespondsListViewHolder holder, final int position) {
        holder.respondCode.setText(respondCodeArray.get(position));
        holder.dateResponds.setText(dateRespondsArray.get(position));
        holder.itemName.setText(itemNameArray.get(position));
        holder.quantity.setText(quantityArray.get(position));
        holder.sellerName.setText(sellerNameArray.get(position));
        holder.sellerContact.setText(sellerContactArray.get(position));
        holder.respondedOrNotResponded.setText(respondedOrNotRespondedArray.get(position));
    }

    @Override
    public int getItemCount() {
        return respondCodeArray.size();
    }

    public class RespondsListViewHolder extends RecyclerView.ViewHolder {

        TextView respondCode, dateResponds,itemName, quantity, sellerName, sellerContact, respondedOrNotResponded;

        public RespondsListViewHolder(@NonNull View itemView) {
            super(itemView);

            respondCode = itemView.findViewById(R.id.respond_code);
            dateResponds = itemView.findViewById(R.id.date_responds);
            itemName = itemView.findViewById(R.id.item_name);
            quantity = itemView.findViewById(R.id.quantity);
            sellerName = itemView.findViewById(R.id.seller_name);
            sellerContact = itemView.findViewById(R.id.seller_contact);
            respondedOrNotResponded = itemView.findViewById(R.id.respondedOrNotResponded);

        }
    }
}
