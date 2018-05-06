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
public class DeleteUser extends Fragment {


    @BindView(R.id.edt_delete_id)
    EditText edtDeleteId;
    @BindView(R.id.btn_delete_id)
    Button btnDeleteId;
    Unbinder unbinder;

    public DeleteUser() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_user, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_delete_id)
    public void onViewClicked() {

        int id = Integer.parseInt(edtDeleteId.getText().toString().trim());
        User user = new User();
        user.setId(id);

        // akses database nya
        MainActivity.myDatabase.myDao().deleteUser(user);

        Toast.makeText(getActivity(), "Delete Success", Toast.LENGTH_SHORT).show();
        edtDeleteId.setText("");

    }
}
