package com.example.macbookpro.practiceapp.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.example.macbookpro.practiceapp.EventBus.OnLoginSuccess;
import com.example.macbookpro.practiceapp.Model.User;
import com.example.macbookpro.practiceapp.R;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {
    private CallbackManager callbackManager;
    private LoginButton btnLoginFB;
    private AccessToken accessToken;
    private User user;
    public static final String SHAREPRE_FILE_NAME = "user_infor";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLoginFB = findViewById(R.id.login_button);
        callbackManager = CallbackManager.Factory.create();
        btnLoginFB.setReadPermissions(Arrays.asList(
                "public_profile", "email", "user_birthday"));
        if (checkLogin()) {
            LoginManager.getInstance().logInWithReadPermissions(LoginActivity.this, Arrays.asList(
                    "public_profile", "email", "user_birthday"));
            EventBus.getDefault().postSticky(new OnLoginSuccess(user));
            Intent intent = new Intent(LoginActivity.this, LifelogActivity.class);
            startActivity(intent);

        }

        btnLoginFB.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                final GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        try {
                            String id = object.getString("id");
                            String name = object.getString("name");
                            String email = object.getString("email");
                            String gender = object.getString("gender");
                            String birthday = object.getString("birthday");
                            String url = "https://graph.facebook.com/" + id + "/picture?type=large";
                            user = new User(id, name, email, gender, birthday);
                            SharedPreferences sharedPreferences = getSharedPreferences(SHAREPRE_FILE_NAME, Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("ID_KEY", id);
                            editor.putString("ID_NAME", name);
                            editor.putString("ID_EMAIL", email);
                            editor.putString("ID_URL", url);
                            editor.putString("ID_BIRTHDAY", birthday);
                            editor.apply();
                        } catch (JSONException e) {
                            Toast.makeText(LoginActivity.this, "Error!", Toast.LENGTH_LONG).show();
                        }
                        Intent intent = new Intent(LoginActivity.this, LifelogActivity.class);
                        startActivity(intent);
                    }
                });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender,birthday");
                request.setParameters(parameters);
                request.executeAsync();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

    public static String printKeyHash(Activity context) {
        PackageInfo packageInfo;
        String key = null;
        try {
            String packageName = context.getApplicationContext().getPackageName();

            packageInfo = context.getPackageManager().getPackageInfo(packageName,
                    PackageManager.GET_SIGNATURES);

            Log.e("Package Name=", context.getApplicationContext().getPackageName());

            for (Signature signature : packageInfo.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                key = new String(Base64.encode(md.digest(), 0));

                Log.e("Key Hash=", key);
            }
        } catch (PackageManager.NameNotFoundException e1) {
            Log.e("Name not found", e1.toString());
        } catch (NoSuchAlgorithmException e) {
            Log.e("No such an algorithm", e.toString());
        } catch (Exception e) {
            Log.e("Exception", e.toString());
        }

        return key;
    }


    private boolean checkLogin() {
        accessToken = AccessToken.getCurrentAccessToken();
        boolean checked = accessToken == null ? false : true;
        return checked;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
