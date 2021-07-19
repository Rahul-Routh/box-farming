package com.bxtrade.boxfarming.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bxtrade.boxfarming.Activity.ProductDescriptionActivity;
import com.bxtrade.boxfarming.Activity.TraderNameActivity;
import com.bxtrade.boxfarming.Global.NetworkState;
import com.bxtrade.boxfarming.R;

import java.util.List;

public class ProductDescriptionAdapter extends RecyclerView.Adapter<ProductDescriptionAdapter.ProductDescriptionViewHolder> {

    private Context context;
    private List<Integer> productDescriptionSellerImageArray;

    private List<String> productDistributorNameArray;
    private List<String> productDistributorAddressArray;
    private List<String> productQuantityArray;
    private List<String> productDistributorPhoneNoArray;

    private NetworkState networkState;

    public ProductDescriptionAdapter(Context context,
                                     List<Integer> productDescriptionSellerImages,
                                     List<String> productDistributorNames,
                                     List<String> productDistributorAddress,
                                     List<String> productQuantity,
                                     List<String> productDistributorPhoneNo){

        this.productDescriptionSellerImageArray = productDescriptionSellerImages;

        this.productDistributorNameArray = productDistributorNames;
        this.productDistributorAddressArray = productDistributorAddress;
        this.productQuantityArray = productQuantity;
        this.productDistributorPhoneNoArray = productDistributorPhoneNo;

        this.context = context;
        networkState = new NetworkState();
    }

    @NonNull
    @Override
    public ProductDescriptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.product_view_description_layout,parent,false);
        return new ProductDescriptionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductDescriptionViewHolder holder, final int position) {
        try{
        holder.productDescriptionSellerImage.setImageResource(productDescriptionSellerImageArray.get(position));

        holder.productDistributorName.setText(productDistributorNameArray.get(position));
        holder.productDistributorAddress.setText(productDistributorAddressArray.get(position));
        holder.productQuantity.setText(productQuantityArray.get(position));
        holder.productDistributorPhoneNo.setText(productDistributorPhoneNoArray.get(position));

        holder.replyButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(networkState.isNetworkAvailable(context)){
                    Intent intent = new Intent(context, TraderNameActivity.class);
                    context.startActivity(intent);
                }else {
                    Toast.makeText(context,"Please connect to internet", Toast.LENGTH_SHORT).show();
                }
            }
        });
        }catch (Exception e){e.printStackTrace();}
    }

    @Override
    public int getItemCount() {
        return productDistributorNameArray.size();
    }

    public class ProductDescriptionViewHolder extends RecyclerView.ViewHolder{


        ImageView productDescriptionSellerImage;

        TextView productDistributorName;
        TextView productDistributorAddress;
        TextView productQuantity;
        TextView productDistributorPhoneNo;

        CardView productDescriptionLayout;

        TextView replyButton;

        public ProductDescriptionViewHolder(@NonNull View itemView) {
            super(itemView);

            productDescriptionSellerImage = itemView.findViewById(R.id.productDescriptionSellerImage);

            productDistributorName = itemView.findViewById(R.id.productDistributorName);
            productDistributorAddress = itemView.findViewById(R.id.productDistributorAddress);
            productQuantity =  itemView.findViewById(R.id.productQuantity);
            productDistributorPhoneNo = itemView.findViewById(R.id.productDistributorPhoneNo);

            productDescriptionLayout = itemView.findViewById(R.id.productDescriptionLayout);
            replyButton = itemView.findViewById(R.id.reply_button);
        }
    }
}
