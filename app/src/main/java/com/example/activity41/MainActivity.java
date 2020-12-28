package com.example.activity41;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.activity41.R.id.checkbox;

public class MainActivity extends AppCompatActivity {
    private EditText Name, Password;
    private Button Login;
    private CheckBox checkBox;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = findViewById(R.id.Name);
        Password = findViewById(R.id.Password);
        Login = findViewById(R.id.boutonLogin);
        checkBox = findViewById(checkbox);
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()) {
                    mEditor.putString(getString(R.string.Checkbox), "True");
                    mEditor.commit();

                    String name = Name.getText().toString();
                    mEditor.putString(getString(R.string.Name), name);
                    mEditor.commit();

                    String password = Password.getText().toString();
                    mEditor.putString(getString(R.string.Password), password);
                    mEditor.commit();
                } else {

                    mEditor.putString(getString(R.string.Checkbox), "False");
                    mEditor.commit();


                    mEditor.putString(getString(R.string.Name), "");
                    mEditor.commit();


                    mEditor.putString(getString(R.string.Password), "");
                    mEditor.commit();
                }

            }
        });

    }

            private void checkSharedPreferences() {
            String name =  mPreferences.getString(getString(R.string.Name), "");
            String password = mPreferences.getString(getString(R.string.Password), "");
            String checkbox =  mPreferences.getString(getString(R.string.Checkbox), "False");

            Name.setText(name);
            Password.setText(password);

            checkBox.setChecked(checkbox.equals("True"));

        }

    }



