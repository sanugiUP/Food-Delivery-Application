package com.example.mad_assignment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RestaurantItemFragment extends Fragment implements ItemOnClick {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ArrayList<RestaurantItem> restaurantItems;
    TextView totalCartItems;
    int totalItems;

    public RestaurantItemFragment()
    {
    }

    public void setList(ArrayList<RestaurantItem> restaurantItems)
    {
        this.restaurantItems = restaurantItems;
    }

    public static RestaurantItemFragment newInstance(String param1, String param2)
    {
        RestaurantItemFragment fragment = new RestaurantItemFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String mParam1 = getArguments().getString(ARG_PARAM1);
            String mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        int screenSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
        View view = inflater.inflate(R.layout.fragment_restaurant_item, container, false);
        totalCartItems = view.findViewById(R.id.TotalItems);
        ImageView cart = view.findViewById(R.id.cart);
        RecyclerView rv = view.findViewById(R.id.restaurant_item_recycle_view);

        if (screenSize == Configuration.SCREENLAYOUT_SIZE_LARGE || screenSize == Configuration.SCREENLAYOUT_SIZE_XLARGE) {
            rv.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false));
        }else{
            rv.setLayoutManager(new GridLayoutManager(getActivity(), 1, GridLayoutManager.VERTICAL, false));
        }


        RestaurantItemAdapter restaurantItemAdapter = new RestaurantItemAdapter(container.getContext(), restaurantItems, this);
        rv.setAdapter(restaurantItemAdapter);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                SummaryFragment summary_fragment = new SummaryFragment();
                fr.replace(R.id.fragment_container, summary_fragment);
                fr.commit();
            }
        });

        return view;
    }

    @Override
    public void itemOnClick(int position)
    {
        totalItems = totalItems + position;
        totalCartItems.setText(String.valueOf(totalItems));
    }


    private class RestaurantItemAdapter extends RecyclerView.Adapter<RestaurantItemAdapter.RestaurantItemViewHolder>
    {
        public ArrayList<RestaurantItem> restaurantItems;
        private final Context context;
        private ItemOnClick itemOnClick;


        public RestaurantItemAdapter(Context context, ArrayList<RestaurantItem> restaurantItems, ItemOnClick itemOnClick){
            this.restaurantItems = restaurantItems;
            this.context = context;
            this.itemOnClick = itemOnClick;
        }

        @NonNull
        @Override
        public RestaurantItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.restaurant_item,parent,false);
            return new RestaurantItemViewHolder(view, itemOnClick,context);
        }

        @Override
        public void onBindViewHolder(@NonNull RestaurantItemViewHolder holder, int position) {
            RestaurantItem restaurant_item = restaurantItems.get(position);
            holder.bind(restaurant_item, context);
        }

        @Override
        public int getItemCount() { return restaurantItems.size(); }


        protected class RestaurantItemViewHolder extends RecyclerView.ViewHolder
        {
            ImageView food_item_pic;
            TextView food_item_name;
            TextView food_item_price;
            TextView count;
            ImageView plus;
            ImageView minus;
            Button add_btn;
            ItemOnClick itemOnClick;

            public RestaurantItemViewHolder(@NonNull View itemView, ItemOnClick itemOnClick,Context context) {
                super(itemView);
                food_item_name = itemView.findViewById(R.id.food_item_name);
                food_item_price = itemView.findViewById(R.id.food_item_price);
                food_item_pic = itemView.findViewById(R.id.food_item_image);
                count = itemView.findViewById(R.id.count);
                plus = itemView.findViewById(R.id.plus);
                minus = itemView.findViewById(R.id.minus);
                add_btn = itemView.findViewById(R.id.Add_Btn);
                this.itemOnClick = itemOnClick;

                DeliveryAppDBModel deliveryAppDBModel = new DeliveryAppDBModel();
                deliveryAppDBModel.load(context);

                plus.setOnClickListener(v -> {
                    int val = Integer.parseInt(String.valueOf(count.getText()));
                    count.setText(String.valueOf(val + 1));
                });

                minus.setOnClickListener(v -> {
                    int val = Integer.parseInt(String.valueOf(count.getText()));
                    if(val >= 1){
                        count.setText(String.valueOf(val - 1));
                    }
                });

                add_btn.setOnClickListener(v ->{
                    int val = Integer.parseInt(String.valueOf(count.getText()));
                    if(val != 0){
                        itemOnClick.itemOnClick(Integer.parseInt(String.valueOf(count.getText())));
                        SummaryStruct summaryStruct = new SummaryStruct(food_item_name.getText().toString(),food_item_price.getText().toString(), count.getText().toString(), restaurantItems.get(0).getRestaurantName());
                        deliveryAppDBModel.addSummary(summaryStruct);
                    }
                });
            }


            public void bind(RestaurantItem restaurant_item, Context context)
            {
                Picasso.with(context).load(restaurant_item.getImageLink()).into(food_item_pic);
                food_item_name.setText(restaurant_item.getFoodItemName());
                food_item_price.setText(restaurant_item.getFoodItemPrice());
            }
        }
    }
}
