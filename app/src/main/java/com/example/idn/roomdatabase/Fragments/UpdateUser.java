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
public class UpdateUser extends Fragment {


    @BindView(R.id.edt_id_update)
    EditText edtIdUpdate;
    @BindView(R.id.edt_name_update)
    EditText edtNameUpdate;
    @BindView(R.id.edt_email_update)
    EditText edtEmailUpdate;
    @BindView(R.id.btn_save)
    Button btnSave;
    Unbinder unbinder;

    public UpdateUser() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_update_user,
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

        int userId = Integer.parseInt(edtIdUpdate.getText().toString().trim());
        String userName = edtNameUpdate.getText().toString().trim();
        String userEmail = edtEmailUpdate.getText().toString().trim();

        User user = new User();

        user.setId(userId);
        user.setName(userName);
        user.setEmail(userEmail);

        MainActivity.myDatabase.myDao().updateUser(user);

        Toast.makeText(getActivity(), "Update Success",
                Toast.LENGTH_SHORT).show();

        edtIdUpdate.setText("");
        edtNameUpdate.setText("");
        edtEmailUpdate.setText("");

    }
}
