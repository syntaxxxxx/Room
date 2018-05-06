package com.example.idn.roomdatabase.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.idn.roomdatabase.MainActivity;
import com.example.idn.roomdatabase.R;
import com.example.idn.roomdatabase.db.entity.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReadUser extends Fragment {


    @BindView(R.id.tv_display_users)
    TextView tvDisplayUsers;
    Unbinder unbinder;


    public ReadUser() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_read_user, container, false);
        unbinder = ButterKnife.bind(this, v);

        List<User> users = MainActivity.myDatabase.myDao().getUsers();
        String info = "";

        for (User user : users) {

            int id = user.getId();
            String name = user.getName();
            String email = user.getEmail();

            info = info + "\n\n"
                    + "ID : " + id + "\n Name : "
                    + name + "\n"
                    + "Email : " + email;

        }

        tvDisplayUsers.setText(info);
        return v;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
