package com.blood.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.blood.R;
import com.blood.utilities.PublicValues;
import com.facebook.login.widget.ProfilePictureView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewUserRegister extends AppCompatActivity {

    @BindView(R.id.profile_dp)
    ImageView profile_dp;
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.mobile)
    EditText mobile;
    @BindView(R.id.dob)
    EditText dob;
    @BindView(R.id.gender)
    EditText gender;
    @BindView(R.id.weight)
    EditText weight;
    private ProfilePictureView profilePictureView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_register);
        ButterKnife.bind(this);
        profilePictureView = (ProfilePictureView) findViewById(R.id.profile_dp);
        gender=(EditText)findViewById(R.id.gender);

        dob=(EditText)findViewById(R.id.dob);
        name=(EditText)findViewById(R.id.name);
        name.setSelected(false);
        email=(EditText)findViewById(R.id.email);
        SharedPreferences sharedPref = getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
        String id=sharedPref.getString(PublicValues.FACEBOOK_USER_ID,"");
        profilePictureView.setPresetSize(ProfilePictureView.LARGE);
        profilePictureView.setProfileId(id);
        name.setText(sharedPref.getString(PublicValues.USER_NAME,""));
        dob.setText(sharedPref.getString(PublicValues.DATE_OF_BIRTH,""));
        gender.setText(sharedPref.getString(PublicValues.GENDER,""));
        email.setText(sharedPref.getString(PublicValues.EMAIL_ID,""));



    }
}
