package com.SevenDigITs.Solutions.E_Learning;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InfoActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "LoginPrefs";
    private static final String TAG = InfoActivity.class.getSimpleName();
    private String deviceID, userEmail, userName, userNumber;
    DatabaseReference databaseReference, rootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);


        final TextView editTextUserName = (TextView) findViewById(R.id.user_name_edit_text_info);
        final TextView editTextUserEmail = (TextView) findViewById(R.id.email_edit_text_info);
        final TextView editTextUserNumber = (TextView) findViewById(R.id.phone_number_edit_text_info);


        deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        rootRef = databaseReference.child("Users" + deviceID);
        rootRef.child("UserName").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Get map of users in datasnapshot
                String name = dataSnapshot.getValue(String.class);
                userName = name.toString().trim();
                System.out.println(userName);
                editTextUserName.setText(userName);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Failed to read value
                Log.e(TAG, "Failed to read user", databaseError.toException());
            }
        });

        rootRef.child("UserEmail").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Get map of users in datasnapshot
                String mail = dataSnapshot.getValue(String.class);
                userEmail = mail.toString().trim();
                System.out.println(userEmail);
                editTextUserEmail.setText(userEmail);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Failed to read value
                Log.e(TAG, "Failed to read user", databaseError.toException());
            }
        });


        rootRef.child("UserPhoneNumber").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Get map of users in datasnapshot
                String name = dataSnapshot.getValue(String.class);
                userNumber = name.toString().trim();
                System.out.println(userNumber);
                editTextUserNumber.setText(userNumber);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Failed to read value
                Log.e(TAG, "Failed to read user", databaseError.toException());
            }
        });

    }
}
