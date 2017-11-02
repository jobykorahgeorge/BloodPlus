package com.blood.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.blood.R;
import com.blood.utilities.PublicValues;
import com.facebook.login.widget.ProfilePictureView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewUserRegister extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText dob;
    EditText gender;
    EditText weight;
    EditText userid;
    EditText password;
    EditText repassword;
    Spinner bloodgroup;
    Button save;
    String bloodselected = "Blood Group";
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
        userid=(EditText)findViewById(R.id.userid);
        password=(EditText)findViewById(R.id.password);
        repassword=(EditText)findViewById(R.id.repassword);
        weight=(EditText)findViewById(R.id.weight);
        bloodgroup=(Spinner)findViewById(R.id.bloodgroup);
        save=(Button)findViewById(R.id.save);


        SharedPreferences sharedPref = getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
        String id=sharedPref.getString(PublicValues.FACEBOOK_USER_ID,"");
        profilePictureView.setPresetSize(ProfilePictureView.CUSTOM);
        profilePictureView.setProfileId(id);
        name.setText(sharedPref.getString(PublicValues.USER_NAME,""));
        dob.setText(sharedPref.getString(PublicValues.DATE_OF_BIRTH,""));
        gender.setText(sharedPref.getString(PublicValues.GENDER,""));
        email.setText(sharedPref.getString(PublicValues.EMAIL_ID,""));

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().length()==0){

                }
                if(gender.getText().toString().length()==0){

                }
                if(email.getText().toString().length()==0){
                    AlertDialog alertDialog = new AlertDialog.Builder(NewUserRegister.this).create();
                    alertDialog.setTitle("oops!");
                    alertDialog.setMessage("Enter email addres");
                    alertDialog.setButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //dismiss the dialog
                                }
                            });
                    alertDialog.show();
                }
                if(dob.getText().toString().length()==0){

                }
                if(weight.getText().toString().length()==0){
                    AlertDialog alertDialog = new AlertDialog.Builder(NewUserRegister.this).create();
                    alertDialog.setTitle("oops!");
                    alertDialog.setMessage("Give an approximate weight");
                    alertDialog.setButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //dismiss the dialog
                                }
                            });
                    alertDialog.show();
                }
                if(userid.getText().toString().length()==0){
                    AlertDialog alertDialog = new AlertDialog.Builder(NewUserRegister.this).create();
                    alertDialog.setTitle("oops!");
                    alertDialog.setMessage("must give a user id");
                    alertDialog.setButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //dismiss the dialog
                                }
                            });
                    alertDialog.show();
                }
                if(password.getText().toString().length()==0){
                    AlertDialog alertDialog = new AlertDialog.Builder(NewUserRegister.this).create();
                    alertDialog.setTitle("oops!");
                    alertDialog.setMessage("Passwords field cannot be empty");
                    alertDialog.setButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //dismiss the dialog
                                }
                            });
                    alertDialog.show();
                }
                if(!password.getText().toString().equals(repassword.getText().toString()) ){
                    AlertDialog alertDialog = new AlertDialog.Builder(NewUserRegister.this).create();
                    alertDialog.setTitle("oops!");
                    alertDialog.setMessage("Passwords do not match");
                    alertDialog.setButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //dismiss the dialog
                                }
                            });
                    alertDialog.show();
                }
                if(bloodgroup.getSelectedItem().toString().compareTo(bloodselected)==0){
                    AlertDialog alertDialog = new AlertDialog.Builder(NewUserRegister.this).create();
                    alertDialog.setTitle("oops!");
                    alertDialog.setMessage("Select a blood group");
                    alertDialog.setButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //dismiss the dialog
                                }
                            });
                    alertDialog.show();
                }

            }
        });

    }
}
