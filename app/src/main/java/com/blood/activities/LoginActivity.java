package com.blood.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blood.R;
import com.blood.utilities.PublicValues;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jobykorahgeorge on 19-Oct-17.
 */

public class LoginActivity extends AppCompatActivity {


    private EditText username;
    @BindView(R.id.password)
    private EditText password;
    private CallbackManager callbackManager;
    private LoginButton loginbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.login_page);
        ButterKnife.bind(this);
        username=(EditText)findViewById(R.id.username);

        loginbutton = (LoginButton) findViewById(R.id.login_button);
        loginbutton.setReadPermissions(Arrays.asList("public_profile, email, user_birthday"));
        callbackManager = CallbackManager.Factory.create();
        loginbutton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {
                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {
                                Log.v("Main", response.toString());
                                setProfileToView(object);
                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender, birthday , locale");
                request.setParameters(parameters);
                request.executeAsync();
            }


            @Override
            public void onCancel() {
                Toast.makeText(LoginActivity.this,"cancel",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(FacebookException exception) {
                Toast.makeText(LoginActivity.this, "error to Login Facebook", Toast.LENGTH_LONG).show();
            }


        });

    }

    private void setProfileToView(JSONObject jsonObject) {

        try {
            SharedPreferences sharedPref = getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString(PublicValues.FACEBOOK_USER_ID, jsonObject.getString("id")).commit();
            editor.putString(PublicValues.USER_NAME, jsonObject.getString("name")).commit();
            editor.putString(PublicValues.EMAIL_ID, jsonObject.getString("email")).commit();
            editor.putString(PublicValues.DATE_OF_BIRTH, jsonObject.getString("birthday")).commit();
            editor.putString(PublicValues.GENDER, jsonObject.getString("gender")).commit();
            editor.apply();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    callbackManager.onActivityResult(requestCode, resultCode, data);
}
}
