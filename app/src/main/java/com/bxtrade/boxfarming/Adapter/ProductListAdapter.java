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
import com.bxtrade.boxfarming.Global.NetworkState;
import com.bxtrade.boxfarming.R;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder> {

    private Context context;
    private List<String> productNameArray;
    private List<Integer> productImagesArray;
    private List<String> productPriceArray;
    private NetworkState networkState;

    public ProductListAdapter(Context context, List<String> productNames, List<Integer> productImages, List<String> productPrice){
        this.productNameArray = productNames;
        this.productImagesArray = productImages;
        this.productPriceArray = productPrice;
        this.context = context;
        networkState = new NetworkState();
    }

    @NonNull
    @Override
    public ProductListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.product_view_layout,parent,false);
        return new ProductListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListViewHolder holder,final int position) {
        holder.productName.setText(productNameArray.get(position));
        holder.productImage.setImageResource(productImagesArray.get(position));
        holder.productPrice.setText(productPriceArray.get(position));

        holder.productListLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(networkState.isNetworkAvailable(context)){
                    Intent intent = new Intent(context, ProductDescriptionActivity.class);
                    context.startActivity(intent);
                }else {
                    Toast.makeText(context,"Please connect to internet", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return productNameArray.size();
    }

    public class ProductListViewHolder extends RecyclerView.ViewHolder {
        TextView productName;
        ImageView productImage;
        TextView productPrice;
        CardView productListLayout;

        public ProductListViewHolder(@NonNull View itemView) {
            super(itemView);

            productName = itemView.findViewById(R.id.productName);
            productImage = itemView.findViewById(R.id.productImage);
            productPrice = itemView.findViewById(R.id.productPrice);
            productListLayout = itemView.findViewById(R.id.productListLayout);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(v.getContext(), "Clicked -> " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
//                }
//            });
        }
    }
}
