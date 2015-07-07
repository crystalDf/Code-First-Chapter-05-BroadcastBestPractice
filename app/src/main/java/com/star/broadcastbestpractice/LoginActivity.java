package com.star.broadcastbestpractice;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {

    private EditText mAccountEditText;
    private EditText mPasswordEditText;
    private CheckBox mRememberPassCheckBox;
    private Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);

        mAccountEditText = (EditText) findViewById(R.id.account);
        mPasswordEditText = (EditText) findViewById(R.id.password);
        mRememberPassCheckBox = (CheckBox) findViewById(R.id.remember_pass);
        mLoginButton = (Button) findViewById(R.id.login);

        SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
        Boolean remember = pref.getBoolean("rememberPass", false);
        if (remember) {
            mAccountEditText.setText(pref.getString("account", ""));
            mPasswordEditText.setText(pref.getString("password", ""));
            mRememberPassCheckBox.setChecked(remember);
        }

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = mAccountEditText.getText().toString();
                String password = mPasswordEditText.getText().toString();
                boolean rememberPass = mRememberPassCheckBox.isChecked();
                if ("admin".equals(account) && "123456".equals(password)) {

                    SharedPreferences.Editor editor =
                            getSharedPreferences("login", MODE_PRIVATE).edit();
                    if (rememberPass) {
                        editor.putString("account", account);
                        editor.putString("password", password);
                        editor.putBoolean("rememberPass", rememberPass);
                    } else {
                        editor.clear();
                    }
                    editor.commit();

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "account or password is invalid",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
