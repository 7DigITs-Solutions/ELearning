package com.SevenDigITs.Solutions.E_Learning.Signin_Signup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.SevenDigITs.Solutions.E_Learning.MainActivity;
import com.SevenDigITs.Solutions.E_Learning.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignInActivity extends AppCompatActivity {

    //defining SharedPreferences and database object
    private static final String TAG = SignInActivity.class.getSimpleName();
    public static final String PREFS_NAME = "LoginPrefs";
    DatabaseReference databaseReference, rootRef;
    private String deviceID, userName, PasswordUser;

    //defining XML object
    private Button login_Button;
    private EditText txtName, txtPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**Remove title bar*/
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
       /**Remove notification bar */
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        /** defining XML object and tag them */
        login_Button = (Button) findViewById(R.id.LoginButton);
        txtName = (EditText) findViewById(R.id.email_edit_textLog);
        txtPass = (EditText) findViewById(R.id.password_edit_textLog);

        /** session open */
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        if (settings.getString("logged", "").toString().equals("logged")) {
            Intent intent = new Intent(SignInActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        /** Database Connection */
        deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
//        databaseReference = FirebaseDatabase.getInstance().getReference();
//        rootRef = databaseReference.child("Users" + deviceID);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        rootRef = databaseReference.child("Users" + deviceID);

        /** get name and make a validation */
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child("Users" + deviceID).exists()) {
                    /** retrieve user email from database */
                    rootRef.child("UserEmail").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            /** Get map of users in datasnapshot */
                            String mail = dataSnapshot.getValue(String.class);
                            userName = mail.toString().trim();
                            System.out.println(userName);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            /**  Failed to read value */
                            Log.e(TAG, "Failed to read user", databaseError.toException());
                        }
                    });

                    /** Retrieve user password from database */
                    rootRef.child("Password").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            /** Get map of users in datasnapshot */
                            String name = dataSnapshot.getValue(String.class);
                            PasswordUser = name.toString().trim();
                            System.out.println(PasswordUser);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            /** Failed to read value */
                            Log.e(TAG, "Failed to read user", databaseError.toException());
                        }
                    });
                } else {

                    System.out.println("Failed to read user ID");
                    Log.e(TAG, "Failed to read user ID");
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                /** Failed to read value */
                Log.e(TAG, "Failed to read user", databaseError.toException());
            }
        });


        /** Login RegButtonReg Action */
        login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /** If email AND password all contain valid values */
                if (txtName.getText().toString().equals(userName) &&
                        txtPass.getText().toString().equals(PasswordUser)) {

                    /** Open Session */
                    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putString("logged", "logged");
                    editor.commit();

                    /** Open Home Screen */
                    Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                    /** Else IF email field value and Password field value are not match any value stored in database */
                } else if (!txtName.getText().toString().equals(userName) ||
                        !txtPass.getText().toString().equals(PasswordUser)) {

                    if ((txtName.getText().toString()).isEmpty()
                            && (txtPass.getText().toString()).isEmpty()) {
                        /** Error message */
                        Toast.makeText(SignInActivity.this, "login Failed Email and Password Field is Empty ", Toast.LENGTH_SHORT).show();

                    } else if ((txtName.getText().toString()).isEmpty()) {
                        /** Error message */
                        Toast.makeText(SignInActivity.this, "login Failed Email Field is Empty ", Toast.LENGTH_SHORT).show();

                    } else if ((txtPass.getText().toString()).isEmpty()) {
                        /** Error message */
                        Toast.makeText(SignInActivity.this, "login Failed Password Field is Empty ", Toast.LENGTH_SHORT).show();

                    } else {
                        /** Error message */
                        Toast.makeText(SignInActivity.this, "login Failed Ensure from your data", Toast.LENGTH_SHORT).show();
//                        /** Open Sign in page again */
//                        Intent intent = new Intent(SignInActivity.this, SignInActivity.class);
//                        startActivity(intent);
//                        finish();
                    }


                }

            }
        });

        /** Button Action for create new account */
        Button createAccountButton = (Button) findViewById(R.id.RegbuttonLog);
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newAccountIntent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(newAccountIntent);
                finish();
            }
        });

        /**Button Action for forget password */
        Button forgetPasswordButton = (Button) findViewById(R.id.ForgetPasswordButton);
        forgetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forgetPasswordIntent = new Intent(SignInActivity.this, ForgotPassword.class);
                startActivity(forgetPasswordIntent);
                finish();
            }
        });
    }
}