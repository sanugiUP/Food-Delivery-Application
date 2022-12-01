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

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SpecialMenuItemFragment extends Fragment implements ItemOnClick
{
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    SpecialMenuItem current_item;

    public SpecialMenuItemFragment()
    {
    }

    public static SpecialMenuItemFragment newInstance(String param1, String param2)
    {
        SpecialMenuItemFragment fragment = new SpecialMenuItemFragment();
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
            // TODO: Rename and change types of parameters
            String mParam1 = getArguments().getString(ARG_PARAM1);
            String mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        int screenSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
        View view = inflater.inflate(R.layout.fragment_special_menu_item, container, false);
        ImageView restaurantList = view.findViewById(R.id.restaurant_list_icon);
        RecyclerView rv = view.findViewById(R.id.special_items_recycle_view);

        if (screenSize == Configuration.SCREENLAYOUT_SIZE_LARGE || screenSize == Configuration.SCREENLAYOUT_SIZE_XLARGE) {
            rv.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL,false));
        }else{
            rv.setLayoutManager(new GridLayoutManager(getActivity(), 1, GridLayoutManager.VERTICAL,false));
        }
        SpecialMenuItemAdapter specialItemAdapter = new SpecialMenuItemAdapter(container.getContext(), this);
        rv.setAdapter(specialItemAdapter);
        restaurantList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                RestaurantFragment restaurant_fragment = new RestaurantFragment();
                fr.replace(R.id.fragment_container, restaurant_fragment);
                fr.commit();
            }
        });
        return view;
    }

    @Override
    public void itemOnClick(int position)
    {
        DeliveryAppDBModel deliverAppDBModel = new DeliveryAppDBModel();
        deliverAppDBModel.load(getActivity());
        ArrayList<SpecialMenuItem> specialItemList = deliverAppDBModel.getAllSpecialItems();
        current_item = specialItemList.get(position);
        ArrayList<RestaurantItem> restaurantItems = deliverAppDBModel.getAllRestaurantItems(current_item.getRestaurantName());

        FragmentTransaction fr = getParentFragmentManager().beginTransaction();
        RestaurantItemFragment restaurant_item_fragment = new RestaurantItemFragment();
        restaurant_item_fragment.setList(restaurantItems);
        fr.replace(R.id.fragment_container, restaurant_item_fragment);
        fr.commit();
    }


    private static class SpecialMenuItemAdapter extends RecyclerView.Adapter<SpecialMenuItemAdapter.SpecialMenuItemViewHolder> {

        public ArrayList<SpecialMenuItem> specialMenuItemsList;
        private final ItemOnClick itemOnClick;
        private final Context context;

        public SpecialMenuItemAdapter(Context context, ItemOnClick itemOnClick)
        {
            DeliveryAppDBModel deliverAppDBModel = new DeliveryAppDBModel();
            deliverAppDBModel.load(context);
            this.specialMenuItemsList = deliverAppDBModel.getAllSpecialItems();
            this.itemOnClick = itemOnClick;
            this.context = context;
        }

        @NonNull
        @Override
        public SpecialMenuItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.special_menu_item,parent,false);
            return new SpecialMenuItemAdapter.SpecialMenuItemViewHolder(view, itemOnClick);
        }

        @Override
        public void onBindViewHolder(@NonNull SpecialMenuItemViewHolder holder, int position)
        {
            SpecialMenuItem specialItem = specialMenuItemsList.get(position);
            holder.bind(specialItem, context);
        }

        @Override
        public int getItemCount() {
            return specialMenuItemsList.size();
        }

        protected static class SpecialMenuItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            ImageView special_item_pic;
            TextView special_item_price;
            TextView special_item_desc;
            TextView special_item_name;
            TextView restaurant_name;
            TextView currency_icon;
            ItemOnClick itemOnClick;

            public SpecialMenuItemViewHolder(@NonNull View itemView, ItemOnClick itemOnClick)
            {
                super(itemView);
                special_item_pic = itemView.findViewById(R.id.special_item_image);
                special_item_name = itemView.findViewById(R.id.special_item_name);
                special_item_price = itemView.findViewById(R.id.special_item_price);
                special_item_desc = itemView.findViewById(R.id.special_item_description);
                restaurant_name = itemView.findViewById(R.id.sitem_restaurant_name);
                currency_icon = itemView.findViewById(R.id.currency);
                this.itemOnClick = itemOnClick;
                itemView.setOnClickListener(this);
            }

            public void bind(SpecialMenuItem specialItem, Context context)
            {
                Picasso.with(context).load(specialItem.getImageLink()).into(special_item_pic);
                special_item_name.setText(specialItem.getFoodItemName());
                special_item_price.setText(specialItem.getFoodItemPrice());
                restaurant_name.setText(specialItem.getRestaurantName());
                special_item_desc.setText(specialItem.getDescription());
                currency_icon.setText("$");
            }

            @Override
            public void onClick(View view)
            {
                itemOnClick.itemOnClick(getAbsoluteAdapterPosition());
            }
        }
    }
}