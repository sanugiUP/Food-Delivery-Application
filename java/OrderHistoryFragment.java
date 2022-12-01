package com.example.mad_assignment;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class OrderHistoryFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static String username;

    public OrderHistoryFragment(String username)
    {
        this.username = username;
    }

    public static OrderHistoryFragment newInstance(String param1, String param2) {
        OrderHistoryFragment fragment = new OrderHistoryFragment(username);
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String mParam1 = getArguments().getString(ARG_PARAM1);
            String mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_order_history, container, false);
        RecyclerView rv = view.findViewById(R.id.order_history_recycle_view);
        rv.setLayoutManager(new GridLayoutManager(getActivity(), 1, GridLayoutManager.VERTICAL,false));
        OrderHistoryAdapter adapter = new OrderHistoryAdapter(container.getContext());
        rv.setAdapter(adapter);
        return view;
    }

    private static class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryFragment.OrderHistoryAdapter.OrderHistoryViewHolder> {
        public ArrayList<Order> orders;

        public OrderHistoryAdapter(Context context) {
            DeliveryAppDBModel deliverAppDBModel = new DeliveryAppDBModel();
            deliverAppDBModel.load(context);
            orders = deliverAppDBModel.getOrderHistory(username);
        }

        @NonNull
        @Override
        public OrderHistoryFragment.OrderHistoryAdapter.OrderHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.order_item, parent, false);
            return new OrderHistoryViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull OrderHistoryFragment.OrderHistoryAdapter.OrderHistoryViewHolder holder, int position) {
            Order order = orders.get(position);
            holder.bind(order);
        }

        @Override
        public int getItemCount() {
            return orders.size();
        }

        protected static class OrderHistoryViewHolder extends RecyclerView.ViewHolder {
            TextView time;
            TextView item_name;
            TextView price;
            TextView quantity;
            TextView restaurant_name;
            TextView amt_paid;

            public OrderHistoryViewHolder(@NonNull View itemView) {
                super(itemView);
                time = itemView.findViewById(R.id.time_of_order);
                item_name = itemView.findViewById(R.id.order_item_name);
                price = itemView.findViewById(R.id.price_per_serving);
                quantity = itemView.findViewById(R.id.quantity_ordered);
                restaurant_name = itemView.findViewById(R.id.restaurant_ordered);
            }

            public void bind(Order order) {
                time.setText(order.getTime());
                item_name.setText(order.getFoodItem());
                price.setText(order.getPrice());
                quantity.setText(order.getQuantity());
                restaurant_name.setText(order.getRestaurantName());
            }
        }
    }
}