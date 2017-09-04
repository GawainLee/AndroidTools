package com.tapwater.login;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Tapwater on 16-1-10.
 */
public class Login extends Activity {

    private EditText editTextUserName;
    private EditText editTextPassword;
    private Button buttonLogin;
    private CheckBox checkBoxSaveUserName;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static final String userNameFile= "O0O0.db";
    private static int loginFallTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        info();
        //Listener
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check login fall time
                if (loginFallTime < 4) {
                    //check User name and password
                    String userName = editTextUserName.getText().toString();
                    String password = editTextPassword.getText().toString();
//                    int userLog = edi
                    if (userName.equals("apple") && password.equals("123"))
                    {
                        //check checkBox
                        if (checkBoxSaveUserName.isChecked()) {
                            editor.putString("userName", userName);
                            editor.commit();
                        } else {
                            editor.remove("userName");
                            editor.commit();
                        }
                        //Login
                    }
                    else
                    {
                        loginFallTime += 1;
                        Toast.makeText(Login.this, "Enter wrong user name or password.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Login.this, "Sorry, fall enter over 3 times. Please connect administrator.", Toast.LENGTH_SHORT).show();
                    editor.putInt("userLogNumber", 0);
                    finish();
                }

            }
        });
    }

    private void info()
    {
        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        checkBoxSaveUserName = (CheckBox) findViewById(R.id.checkBoxSaveUserName);
        sharedPreferences = getSharedPreferences(userNameFile,MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editTextUserName.setText(sharedPreferences.getString("userName",""));
    }
}
