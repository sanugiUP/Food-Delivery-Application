package com.example.mad_assignment;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RestaurantFragment extends Fragment implements ItemOnClick{

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Restaurant current_Restaurant;

    public RestaurantFragment()
    {

    }

    public Restaurant getSelectedRestaurant(){
        return this.current_Restaurant;
    }

    public static RestaurantFragment newInstance(String param1, String param2)
    {
        RestaurantFragment fragment = new RestaurantFragment();
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
        View view = inflater.inflate(R.layout.fragment_restaurant, container, false);
        RecyclerView rv = view.findViewById(R.id.restaurant_recycle_view);

        if (screenSize == Configuration.SCREENLAYOUT_SIZE_LARGE || screenSize == Configuration.SCREENLAYOUT_SIZE_XLARGE) {
            rv.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL,false));
        }else{
            rv.setLayoutManager(new GridLayoutManager(getActivity(), 1, GridLayoutManager.VERTICAL,false));
        }

        RestaurantAdapter restaurantAdapter = new RestaurantAdapter(container.getContext(), this);
        rv.setAdapter(restaurantAdapter);
        return view;
    }

    @Override
    public void itemOnClick(int position)
    {
        DeliveryAppDBModel deliverAppDBModel = new DeliveryAppDBModel();
        deliverAppDBModel.load(getActivity());
        ArrayList<Restaurant> restaurants = deliverAppDBModel.getAllRestaurants();
        current_Restaurant = restaurants.get(position);
        ArrayList<RestaurantItem> rest_Items = deliverAppDBModel.getAllRestaurantItems(current_Restaurant.getLabel());
        FragmentTransaction fr = getParentFragmentManager().beginTransaction();
        RestaurantItemFragment restaurant_item_fragment = new RestaurantItemFragment();
        restaurant_item_fragment.setList(rest_Items);
        fr.replace(R.id.fragment_container, restaurant_item_fragment);
        fr.commit();
    }

    private class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>
    {
        public ArrayList<Restaurant> restaurantList;
        private final ItemOnClick itemOnClick;
        private final Context context;

        public RestaurantAdapter(Context context, ItemOnClick itemOnClick)
        {
            DeliveryAppDBModel deliverAppDBModel = new DeliveryAppDBModel();
            deliverAppDBModel.load(context);
            restaurantList = deliverAppDBModel.getAllRestaurants();
            this.itemOnClick = itemOnClick;
            this.context = context;
        }

        @NonNull
        @Override
        public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.restaurant,parent,false);
            return new RestaurantViewHolder(view, itemOnClick);
        }

        @Override
        public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position)
        {
            Restaurant restaurant = restaurantList.get(position);
            holder.bind(restaurant, context);
        }

        @Override
        public int getItemCount() { return restaurantList.size(); }

        protected class RestaurantViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
        {
            ImageView restaurant_pic;
            TextView restaurant_name;
            TextView restaurant_location;
            TextView currency_icon;
            ItemOnClick itemOnClick;

            public RestaurantViewHolder(@NonNull View itemView, ItemOnClick itemOnClick)
            {
                super(itemView);
                restaurant_pic = itemView.findViewById(R.id.restaurant_image);
                restaurant_name = itemView.findViewById(R.id.restaurant_name);
                restaurant_location = itemView.findViewById(R.id.restaurant_location);
                currency_icon = itemView.findViewById(R.id.currency);
                this.itemOnClick = itemOnClick;
                itemView.setOnClickListener(this);
            }

            public void bind(Restaurant restaurant, Context context)
            {
                Picasso.with(context).load(restaurant.getImageLink()).into(restaurant_pic);
                restaurant_name.setText(restaurant.getLabel());
                restaurant_location.setText(restaurant.getLocation());
            }

            @Override
            public void onClick(View view)
            {
                itemOnClick.itemOnClick(getAbsoluteAdapterPosition());
            }
        }
    }

}