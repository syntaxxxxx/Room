package com.example.idn.roomdatabase.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.idn.roomdatabase.MainActivity;
import com.example.idn.roomdatabase.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuUtama extends Fragment {


    @BindView(R.id.btn_create)
    Button btnCreate;
    @BindView(R.id.btn_read)
    Button btnRead;
    @BindView(R.id.btn_delete)
    Button btnDelete;
    @BindView(R.id.btn_update)
    Button btnUpdate;


    public MenuUtama() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_menu_utama,
                container, false);

        ButterKnife.bind(this, v);
        return v;

    }


    @OnClick({R.id.btn_create, R.id.btn_read, R.id.btn_delete, R.id.btn_update})
    public void onViewClicked(View view) {

        switch (view.getId()) {

            case R.id.btn_create:
                createUser();
                break;

            case R.id.btn_read:
                readUser();
                break;

            case R.id.btn_delete:
                updateUser();
                break;

            case R.id.btn_update:
                deleteUser();
                break;

        }
    }


    private void deleteUser() {
        MainActivity.fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, new DeleteUser())
                .addToBackStack(null)
                .commit();
    }


    private void updateUser() {
        MainActivity.fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, new UpdateUser())
                .addToBackStack(null)
                .commit();
    }


    private void readUser() {
        MainActivity.fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, new ReadUser())
                .addToBackStack(null)
                .commit();
    }


    private void createUser() {
        MainActivity.fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, new CreateUser())
                .addToBackStack(null)
                .commit();
    }
}
