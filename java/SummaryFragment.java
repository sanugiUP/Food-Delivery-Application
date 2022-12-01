package com.example.mad_assignment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class SummaryFragment extends Fragment
{
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TextView price;

    public SummaryFragment()
    {
        // Required empty public constructor
    }

    public static SummaryFragment newInstance(String param1, String param2)
    {
        SummaryFragment fragment = new SummaryFragment();
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
        View view = inflater.inflate(R.layout.fragment_summary, container, false);
        RecyclerView rv = view.findViewById(R.id.order_item_recycle_view);
        Button checkout = view.findViewById(R.id.btn_checkout);
        price = view.findViewById(R.id.total_price);
        Button total = view.findViewById(R.id.btn_getTotal);
        rv.setLayoutManager(new GridLayoutManager(getActivity(), 1, GridLayoutManager.VERTICAL, false));
        SummaryAdaptor summaryAdaptor = new SummaryAdaptor(container.getContext());
        rv.setAdapter(summaryAdaptor);

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(price.getText().toString().equals("0")){
                    Toast.makeText(getActivity(),"Cart is Empty!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(requireContext(), LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateTotalPrice(container.getContext());
            }
        });
        return view;
    }

    public void updateTotalPrice(Context context)
    {
        DeliveryAppDBModel deliverAppDBModel = new DeliveryAppDBModel();
        deliverAppDBModel.load(context);
        ArrayList<SummaryStruct> list = deliverAppDBModel.getAllSummaryItems();
        double totalPrice = 0.0;

        for (int i = 0; i < list.size(); i++) {
            double itemprice = Double.parseDouble(list.get(i).getFoodItemPrice()) * Integer.parseInt(list.get(i).getFoodItemQuantity());
            totalPrice = totalPrice + itemprice;
        }

        price.setText(String.valueOf(totalPrice));
    }

    private class SummaryAdaptor extends RecyclerView.Adapter<SummaryAdaptor.SummaryViewHolder>
    {
        public ArrayList<SummaryStruct> summary_of_items;
        private final Context context;

        public SummaryAdaptor(Context context) {
            DeliveryAppDBModel deliverAppDBModel = new DeliveryAppDBModel();
            deliverAppDBModel.load(context);
            this.summary_of_items = deliverAppDBModel.getAllSummaryItems();
            this.context = context;
        }

        @NonNull
        @Override
        public SummaryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.summary_item,parent,false);
            return new SummaryViewHolder(view, context);
        }

        @Override
        public void onBindViewHolder(@NonNull SummaryViewHolder holder, int position) {
            SummaryStruct summary_item = summary_of_items.get(position);
            holder.bind(summary_item, context);
        }

        /* REF : https://stackoverflow.com/questions/56147356/how-to-delete-recyclerview-item-when-click-on-button*/
        public void removeAt(int position) {
            summary_of_items.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, summary_of_items.size());
        }

        @Override
        public int getItemCount() {
            return summary_of_items.size();
        }

        protected class SummaryViewHolder extends RecyclerView.ViewHolder{
            ImageView cross_button;
            TextView food_item_name;
            TextView food_item_price;
            TextView food_item_count;
            TextView dollarIcon;
            TextView quantityIcon;
            Context context;

            public SummaryViewHolder(@NonNull View itemView, Context context) {
                super(itemView);
                food_item_name = itemView.findViewById(R.id.summary_food_Name);
                food_item_price = itemView.findViewById(R.id.summary_food_price);
                food_item_count = itemView.findViewById(R.id.summary_food_quantity);
                cross_button = itemView.findViewById(R.id.cross);
                dollarIcon = itemView.findViewById(R.id.currency);
                quantityIcon = itemView.findViewById(R.id.summary_qantity_icon);
                this.context = context;

                cross_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DeliveryAppDBModel deliverAppDBModel = new DeliveryAppDBModel();
                        deliverAppDBModel.load(context);
                        deliverAppDBModel.deleteSummary(summary_of_items.get(getAbsoluteAdapterPosition()));
                        removeAt(getAbsoluteAdapterPosition());
                        updateTotalPrice(context);
                    }
                });
            }

            public void bind(SummaryStruct order_item, Context context) {
                food_item_name.setText(order_item.getFoodItemName());
                food_item_price.setText(order_item.getFoodItemPrice());
                food_item_count.setText(order_item.getFoodItemQuantity());
            }
        }
    }

}
