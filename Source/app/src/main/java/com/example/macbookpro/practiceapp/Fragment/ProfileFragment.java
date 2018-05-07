package com.example.macbookpro.practiceapp.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.macbookpro.practiceapp.Model.User;
import com.example.macbookpro.practiceapp.R;
import com.example.macbookpro.practiceapp.Util.ReceivedKeyName;
import com.facebook.login.LoginManager;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    private Button btnLogOut;
    private ImageView imgAvatar;
    private User receivedUser;
    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance(User user) {
        Bundle bundle = new Bundle();
        ProfileFragment fragment = new ProfileFragment();
        bundle.putSerializable(ReceivedKeyName.RECEIVED_USER, user);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        receivedUser = (User) getArguments().getSerializable(ReceivedKeyName.RECEIVED_USER);
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        btnLogOut = view.findViewById(R.id.btn_log_out);
        imgAvatar = view.findViewById(R.id.img_avatar);
        Picasso.with(getContext()).load(receivedUser.getAvatar()).into(imgAvatar);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginManager.getInstance().logOut();
                getActivity().finish();
            }
        });
        return view;
    }


}
