package com.SevenDigITs.Solutions.E_Learning.Signin_Signup;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.SevenDigITs.Solutions.E_Learning.R;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class ForgotPassword extends AppCompatActivity {

    // initializing action variables
    private EditText inputEmail, newPassword, newRePassword;
    private Button btnCheck, btnReset, btnBack;
    private FirebaseAuth auth;

    private static final String TAG = SignInActivity.class.getSimpleName();

    public static final String PREFS_NAME = "LoginPrefs";
    DatabaseReference databaseReference, rootRef;
    private String deviceID, userName;

    //defining AwesomeValidation object
    private AwesomeValidation awesomeValidation;
    boolean invalid = false;

    //defining firebase
    Firebase firebase;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /** Remove title bar */
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        /** Remove notification bar */
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        /** defining XML object and tag them */
        inputEmail = (EditText) findViewById(R.id.email);
        newPassword = (EditText) findViewById(R.id.newPassword_edit_text);
        newRePassword = (EditText) findViewById(R.id.newRepassword_edit_text);
        btnCheck = (Button) findViewById(R.id.btnCheckEmail);
        btnReset = (Button) findViewById(R.id.btnResetPassword);
        btnBack = (Button) findViewById(R.id.btn_back);


        /** start validation code */
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this, R.id.email, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        //awesomeValidation.addValidation(this, R.id.newPassword_edit_text, "((?=.\\d)(?=.[a-z]).{6,20})", R.string.passworderror);
        awesomeValidation.addValidation(this, R.id.newRepassword_edit_text, R.id.password_edit_textReg, R.string.err_password_confirmation);

        /** Database Connection */
        deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        rootRef = databaseReference.child("Users" + deviceID);
        // get name and make a valdation
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child("Users" + deviceID).exists()) {
                    // retrieve user email from database
                    rootRef.child("UserEmail").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            //Get map of users in datasnapshot
                            String mail = dataSnapshot.getValue(String.class);
                            userName = mail.toString().trim();
                            System.out.println(userName);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            // Failed to read value
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
                // Failed to read value
                Log.e(TAG, "Failed to read user", databaseError.toException());
            }
        });
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // If email AND password all contain valid values
                if (inputEmail.getText().toString().equals(userName)) {

                    newPassword.setVisibility(View.VISIBLE);
                    newRePassword.setVisibility(View.VISIBLE);
                    btnReset.setVisibility(View.VISIBLE);
                    btnCheck.setVisibility(View.GONE);

                    //Else IF email field value and Password field value are not match any value stored in database
                } else if (!inputEmail.getText().toString().equals(userName)) {
                    invalid = true;
                    //Error message
                    Toast.makeText(ForgotPassword.this, "Reset password Failed your email don't registered ", Toast.LENGTH_LONG).show();
                    //Open Sign in page agin
//                    Intent intent = new Intent(ForgotPassword.this, ForgotPassword.class);
//                    startActivity(intent);
//                    finish();
                }
            }
        });
        //add
        //fire base set data in it
        Firebase.setAndroidContext(this);
        String deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        firebase = new Firebase("https://e-learning-7c397.firebaseio.com/Users" + deviceID);
        mAuth = FirebaseAuth.getInstance();
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (
                        !(inputEmail.getText().toString()).equalsIgnoreCase(null)
                                && (inputEmail.getText().toString()).length() > 0
                                && !(newPassword.getText().toString()).equalsIgnoreCase(null)
                                && (newPassword.getText().toString()).length() > 0
                                && !(newRePassword.getText().toString()).equalsIgnoreCase(null)
                                && (newRePassword.getText().toString()).length() > 0
                                && (Objects.equals(newPassword.getText().toString(), newRePassword.getText().toString()))
                                && awesomeValidation.validate()) {

                    Firebase firebasePassword = firebase.child("Password");
                    firebasePassword.setValue(newPassword.getText().toString());

                    Firebase firebaseRepassword = firebase.child("Repassword");
                    firebaseRepassword.setValue(newRePassword.getText().toString());

                    Toast.makeText(ForgotPassword.this, "Password changed Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ForgotPassword.this, SignInActivity.class);
                    startActivity(intent);
                    finish();

                } else if (!awesomeValidation.validate()) {
                    invalid = true;
                    Toast.makeText(getApplicationContext(), "Data is not valid .. please check your data",
                            Toast.LENGTH_SHORT).show();
                    //this elses ensure that string is not = null and length == 0 to register
                } else {
                    Toast.makeText(ForgotPassword.this, "Password changed Not Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ForgotPassword.this, ForgotPassword.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newAccountIntent = new Intent(ForgotPassword.this, SignInActivity.class);
                startActivity(newAccountIntent);
                finish();
            }
        });
    }
}
