package com.example.idn.roomdatabase.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.idn.roomdatabase.MainActivity;
import com.example.idn.roomdatabase.R;
import com.example.idn.roomdatabase.db.entity.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateUser extends Fragment {


    @BindView(R.id.edt_id)
    EditText edtId;
    @BindView(R.id.edt_name)
    EditText edtName;
    @BindView(R.id.edt_email)
    EditText edtEmail;
    @BindView(R.id.btn_save)
    Button btnSave;
    Unbinder unbinder;


    public CreateUser() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_create_user,
                container, false);
        unbinder = ButterKnife.bind(this, v);
        return v;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick(R.id.btn_save)
    public void onViewClicked() {

        int userId = Integer.parseInt(edtId.getText().toString().trim());
        String userName = edtName.getText().toString().trim();
        String userEmail = edtEmail.getText().toString().trim();

        User user = new User();

        user.setId(userId);
        user.setName(userName);
        user.setEmail(userEmail);

        MainActivity.myDatabase.myDao().addUser(user);

        Toast.makeText(getActivity(), "Success",
                Toast.LENGTH_SHORT).show();

        edtId.setText("");
        edtName.setText("");
        edtEmail.setText("");

    }
}











