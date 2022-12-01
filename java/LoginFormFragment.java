package com.example.mad_assignment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class LoginFormFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private EditText username;
    private EditText text_password;
    private Button register;
    private ImageView arrow;
    private ArrayList<Customer> customerList;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoginFormFragment() {
        // Required empty public constructor
    }

    public static LoginFormFragment newInstance(String param1, String param2) {
        LoginFormFragment fragment = new LoginFormFragment();
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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_form, container, false);
        username = view.findViewById(R.id.username_text);
        text_password = view.findViewById(R.id.text_password);
        register = view.findViewById(R.id.reg_Button);
        arrow = view.findViewById(R.id.btn_login);
        DeliveryAppDBModel deliveryAppDBModel = new DeliveryAppDBModel();
        deliveryAppDBModel.load(container.getContext());

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                RegistrationFormFragment registration_form_fragment = new RegistrationFormFragment();
                fr.replace(R.id.frag_container_two, registration_form_fragment);
                fr.commit();
            }
        });

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("") || text_password.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "The fields cannot be null", Toast.LENGTH_SHORT).show();
                } else {
                    boolean is_Success = deliveryAppDBModel.validateCustomerLogInDetails(username.getText().toString(), text_password.getText().toString());
                    if(is_Success){
                        Toast.makeText(getActivity(),"Login Successful",Toast.LENGTH_SHORT).show();

                        DeliveryAppDBModel deliveryAppDBModel = new DeliveryAppDBModel();
                        deliveryAppDBModel.load(container.getContext());

                        ArrayList<SummaryStruct> ordereditems = deliveryAppDBModel.getAllSummaryItems();
                        String datetime = new SimpleDateFormat("yy/MM/dd-HH:mm:ss").format(Calendar.getInstance().getTime());

                        // Adding to Customer Order history
                        for(int i = 0; i < ordereditems.size(); i++){
                            Order order = new Order(username.getText().toString(), datetime, ordereditems.get(i).getFoodItemName(), ordereditems.get(i).getFoodItemPrice(),
                                    ordereditems.get(i).getFoodItemQuantity(), ordereditems.get(i).getRestaurantName());
                            deliveryAppDBModel.addCustomerOrder(order);
                        }

                        FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                        SuccessfulPageFragment successful_page_fragment = new SuccessfulPageFragment(username.getText().toString());
                        fr.replace(R.id.frag_container_two, successful_page_fragment);
                        fr.commit();
                    }
                    else{
                        Toast.makeText(getActivity(),"Customer Doesn't Exist! Please Register To Proceed!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        return view;
    }
}