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

public class CustomerChatAdapter extends RecyclerView.Adapter<CustomerChatAdapter.CustomerChatViewHolder> {

    private Context context;
    private List<String> respondCodeArray;
    private List<String> cropNameArray;
    private List<String> productQuantityArray;
    private List<String> rateArray;
    private List<String> expectedDateArray;
    private List<String> farmer_nameArray;
    private List<String> productDistributorPhoneNoArray;

    private List<String> offerRateArray;
    private List<String> demandQuantityArray;
    private List<String> date_demandArray;

    private List<String> repeatArray;
    private List<String> modifyArray;
    private List<String> respondArray;

    private NetworkState networkState;

    public CustomerChatAdapter( Context context,
                                List<String>respondCode, List<String>cropName, List<String>productQuantity, List<String>rate,
                                List<String>expectedDate, List<String>farmer_name,List<String> productDistributorPhoneNo,
                                List<String>offerRate, List<String>demandQuantity, List<String>date_demand,
                                List<String>repeat, List<String>modify, List<String>respond){
        this.respondCodeArray = respondCode;
        this.cropNameArray = cropName;
        this.productQuantityArray = productQuantity;
        this.rateArray = rate;
        this.expectedDateArray = expectedDate;
        this.farmer_nameArray = farmer_name;
        this.productDistributorPhoneNoArray = productDistributorPhoneNo;

        this.offerRateArray = offerRate;
        this.demandQuantityArray = demandQuantity;
        this.date_demandArray = date_demand;

        this.repeatArray = repeat;
        this.modifyArray = modify;
        this.respondArray = respond;

        this.context = context;
        networkState = new NetworkState();
    }

    @NonNull
    @Override
    public CustomerChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.customer_chat_view_layout, parent, false);
        return new CustomerChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerChatViewHolder holder, final int position) {
        holder.respondCode.setText(respondCodeArray.get(position));
        holder.cropName.setText(cropNameArray.get(position));
        holder.productQuantity.setText(productQuantityArray.get(position));
        holder.rate.setText(rateArray.get(position));
        holder.expectedDate.setText(expectedDateArray.get(position));
        holder.farmer_name.setText(farmer_nameArray.get(position));
        holder.productDistributorPhoneNo.setText(productDistributorPhoneNoArray.get(position));

        holder.offerRate.setText(offerRateArray.get(position));
        holder.demandQuantity.setText(demandQuantityArray.get(position));
        holder.date_demand.setText(date_demandArray.get(position));

        holder.repeat.setText(repeatArray.get(position));
        holder.modify.setText(modifyArray.get(position));
        holder.respond.setText(respondArray.get(position));
    }

    @Override
    public int getItemCount() {
        return respondCodeArray.size();
    }

    public class CustomerChatViewHolder extends RecyclerView.ViewHolder{

        TextView respondCode, cropName, productQuantity, rate, expectedDate, farmer_name, productDistributorPhoneNo,
                offerRate, demandQuantity, date_demand, repeat, modify, respond;

        public CustomerChatViewHolder(@NonNull View itemView) {
            super(itemView);

            respondCode = itemView.findViewById(R.id.respond_code);
            cropName = itemView.findViewById(R.id.cropName);
            productQuantity = itemView.findViewById(R.id.productQuantity);
            rate = itemView.findViewById(R.id.rate);
            expectedDate = itemView.findViewById(R.id.expectedDate);
            farmer_name = itemView.findViewById(R.id.farmer_name);
            productDistributorPhoneNo = itemView.findViewById(R.id.productDistributorPhoneNo);

            offerRate = itemView.findViewById(R.id.offerRate);
            demandQuantity = itemView.findViewById(R.id.demandQuantity);
            date_demand = itemView.findViewById(R.id.date_demand);

            repeat = itemView.findViewById(R.id.repeat);
            modify = itemView.findViewById(R.id.modify);
            respond = itemView.findViewById(R.id.respond);


        }
    }
}
