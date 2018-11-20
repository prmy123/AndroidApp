package com.example.android.roomdbexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateFragment extends Fragment implements View.OnClickListener{

    private TextView TxtUserId, TxtUserName, TxtUserEmail;
    private Button BnUpdate;


    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_update, container, false);

        TxtUserId = view.findViewById(R.id.txt_user_id_update);
        TxtUserName = view.findViewById(R.id.txt_user_name_update);
        TxtUserEmail = view.findViewById(R.id.txt_user_email_update);

        BnUpdate = view.findViewById(R.id.bn_update);

        BnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(TxtUserId.getText().toString());
                String name = TxtUserName.getText().toString();
                String email = TxtUserEmail.getText().toString();

                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setEmail(email);

                MainActivity.myAppDatabase.myDao().updateUser(user);
                Toast.makeText(getActivity(), "User Data Successfully Updated ...", Toast.LENGTH_SHORT).show();
                TxtUserId.setText("");
                TxtUserName.setText("");
                TxtUserEmail.setText("");
            }
        });

        return view;

    }

    @Override
    public void onClick(View view) {

    }
}
