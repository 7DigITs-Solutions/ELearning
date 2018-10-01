package com.SevenDigITs.Solutions.E_Learning.Signin_Signup;


import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.SevenDigITs.Solutions.E_Learning.R;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.firebase.client.Firebase;
import com.google.common.collect.Range;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class SignUpActivity extends AppCompatActivity {

    //initializing
    Button button;
    Spinner spin;

    //defining AwesomeValidation object
    private AwesomeValidation awesomeValidation;
    boolean invalid = false;

    //defining firebase
    Firebase firebase;
    private FirebaseAuth mAuth;

    // for open session
    public static final String PREFS_NAME = "LoginPrefs";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**Remove title bar*/
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        /**Remove notification bar*/
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        /**spiner code */
        spin = (Spinner) findViewById(R.id.gender_spinner);
        List<String> list = new ArrayList<String>();
        list.add("Male");
        list.add("Female");
        //spin.setBackgroundColor(c);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item, list);
        dataAdapter.setDropDownViewResource( R.layout.spinner_item_drop_down);
        spin.setAdapter(dataAdapter);


        /** defining XML object and tag them */
        final EditText editTextName = (EditText) findViewById(R.id.name_edit_text);
        final EditText editTextEmail = (EditText) findViewById(R.id.email_edit_textReg);
        final EditText editTextPassword = (EditText) findViewById(R.id.password_edit_textReg);
        final EditText editTextRepassword = (EditText) findViewById(R.id.repassword_edit_text);
        final EditText editTextNumber = (EditText) findViewById(R.id.phone_number_edit_text);
        final EditText editTextUniversity = (EditText) findViewById(R.id.university_edit_text);
        final EditText editTextMajor = (EditText) findViewById(R.id.major_edit_text);
        final EditText editTextAge = (EditText) findViewById(R.id.age_edit_text);

        /**starting validation code*/
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        /**adding validation to edittexts*/
        awesomeValidation.addValidation(this, R.id.name_edit_text, "[a-zA-Z\\s]+", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.email_edit_textReg, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.password_edit_textReg, "((?=.*\\d)(?=.*[a-z]).{6,20})", R.string.passworderror);
        awesomeValidation.addValidation(this, R.id.phone_number_edit_text, "^[+]?[0-9]{11}$", R.string.mobileerror);
        awesomeValidation.addValidation(this, R.id.repassword_edit_text, R.id.password_edit_textReg, R.string.err_password_confirmation);
        awesomeValidation.addValidation(this, R.id.age_edit_text, Range.closed(15, 70), R.string.invalid_age_trusted);
        awesomeValidation.addValidation(this, R.id.major_edit_text, "[a-zA-Z\\s]+", R.string.err_major);



        /**fire base set data in it*/
        Firebase.setAndroidContext(this);
        String deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        firebase = new Firebase("https://e-learning-7c397.firebaseio.com/Users" + deviceID);
        mAuth = FirebaseAuth.getInstance();

        /** intializing RegButtonReg */
        button = (Button) findViewById(R.id.RegButtonReg);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (
                        !(editTextName.getText().toString()).equalsIgnoreCase(null)
                                && (editTextName.getText().toString()).length() > 0
                                && !(editTextEmail.getText().toString()).equalsIgnoreCase(null)
                                && (editTextEmail.getText().toString()).length() > 0
                                && !(editTextPassword.getText().toString()).equalsIgnoreCase(null)
                                && (editTextPassword.getText().toString()).length() > 0
                                && !(editTextRepassword.getText().toString()).equalsIgnoreCase(null)
                                && (editTextRepassword.getText().toString()).length() > 0
                                && !(editTextNumber.getText().toString()).equalsIgnoreCase(null)
                                && (editTextNumber.getText().toString()).length() > 0
//                                && !(editTextUniversity.getText().toString()).equalsIgnoreCase(null)
//                                && (editTextUniversity.getText().toString()).length() > 0
                                && !(editTextMajor.getText().toString()).equalsIgnoreCase(null)
                                && (editTextMajor.getText().toString()).length() > 0
                                && !(editTextAge.getText().toString()).equalsIgnoreCase(null)
                                && (editTextAge.getText().toString()).length() > 0
                                && (Objects.equals(editTextPassword.getText().toString(), editTextRepassword.getText().toString()))
                                && awesomeValidation.validate()) {

                    Firebase firebaseName = firebase.child("UserName");
                    firebaseName.setValue(editTextName.getText().toString());

                    Firebase firebaseEmail = firebase.child("UserEmail");
                    firebaseEmail.setValue(editTextEmail.getText().toString());

                    Firebase firebasePassword = firebase.child("Password");
                    firebasePassword.setValue(editTextPassword.getText().toString());

                    Firebase firebaseRepassword = firebase.child("Repassword");
                    firebaseRepassword.setValue(editTextRepassword.getText().toString());

                    Firebase firebasePhone = firebase.child("UserPhoneNumber");
                    firebasePhone.setValue(editTextNumber.getText().toString());

                    Firebase firebaseUniversity = firebase.child("UserUniversity");
                    firebaseUniversity.setValue(editTextUniversity.getText().toString());

                    Firebase firebaseMajor = firebase.child("UserMajor");
                    firebaseMajor.setValue(editTextMajor.getText().toString());

                    Firebase firebaseAge = firebase.child("UserAge");
                    firebaseAge.setValue(editTextAge.getText().toString());

                    Firebase firebaseGender = firebase.child("UserGender");
                    firebaseGender.setValue(String.valueOf(spin.getSelectedItem()));

                    Toast.makeText(SignUpActivity.this, "Registration Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                    startActivity(intent);
                    finish();

                } else if (!awesomeValidation.validate()) {
                    invalid = true;
                    Toast.makeText(getApplicationContext(), "Data is not valid .. please check your data",
                            Toast.LENGTH_SHORT).show();
                    /** this elses ensure that string is not = null and length == 0 to register*/
                } else {
                    Toast.makeText(SignUpActivity.this, "Registration failed ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUpActivity.this, SignUpActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

        });

        /** Button Action for login */
        Button loginAccountButton = (Button) findViewById(R.id.login_buttonReg);
        loginAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newAccountIntent = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(newAccountIntent);
                finish();
            }
        });
    }
}