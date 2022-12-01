package com.example.mad_assignment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegistrationFormFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public RegistrationFormFragment()
    {
    }

    public static RegistrationFormFragment newInstance(String param1, String param2)
    {
        RegistrationFormFragment fragment = new RegistrationFormFragment();
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
        View view = inflater.inflate(R.layout.fragment_registration_form, container, false);
        EditText username = view.findViewById(R.id.et_register_username);
        EditText password = view.findViewById(R.id.et_register_password);
        EditText email = view.findViewById(R.id.et_register_email);
        Button btn_done = view.findViewById(R.id.reg_Button);

        DeliveryAppDBModel deliveryAppDBModel = new DeliveryAppDBModel();
        deliveryAppDBModel.load(container.getContext());

        btn_done.setOnClickListener(view1 -> {

            if(username.getText().toString().equals("")|| password.getText().toString().equals("") || email.getText().toString().equals("")) {
                Toast.makeText(getActivity(), "The fields cannot be null", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Customer customer = new Customer(username.getText().toString(),email.getText().toString(),password.getText().toString());
                boolean is_Success = deliveryAppDBModel.validateCustomerLogInDetails(customer.getCustomerName(), customer.getCustomerPassword());
                if(!is_Success){
                    deliveryAppDBModel.addCustomer(customer);
                    Toast.makeText(getActivity(), "Registration Successful", Toast.LENGTH_SHORT).show();
                    FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                    LoginFormFragment login_fragment = new LoginFormFragment();
                    fr.replace(R.id.frag_container_two, login_fragment);
                    fr.commit();
                }
                else{
                    Toast.makeText(getActivity(),"Customer With The Same Username Already Exist!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}