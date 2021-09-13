package com.example.foodapp;

import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpTabFragment extends Fragment {

    EditText fullname, email2, phoneNo, address, pass2;

    Button signUp_Btn;

    FirebaseAuth mAuth;

    ProgressBar progBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_fragment, container, false);


        fullname = root.findViewById(R.id.fullname);
        email2 = root.findViewById(R.id.email2);
        phoneNo = root.findViewById(R.id.phoneNo);
        address = root.findViewById(R.id.address);
        pass2 = root.findViewById(R.id.pass2);
        signUp_Btn = root.findViewById(R.id.signUp_Btn);

        mAuth = FirebaseAuth.getInstance();
        progBar = root.findViewById(R.id.progressBar);

        signUp_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!validateName() | validateEmail() | validatePhone() | validateAddress() | validatePassword());

                    String fulname = fullname.getText().toString();
                    String email = email2.getText().toString();
                    String phoneno = phoneNo.getText().toString();
                    String addres = address.getText().toString();
                    String password = pass2.getText().toString();
            }
        });



        return root;


    }

    private Boolean validateName(){

        String val = fullname.getText().toString();

        if (val.isEmpty()){
            fullname.setError("Name cannot be empty");
            return false;
        } else{
            fullname.setError(null);
            return true;
        }
    }

    private Boolean validateEmail(){

        String val = email2.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()){
            email2.setError("Email cannot be empty");
            return false;
        } else if (!val.matches(emailPattern)){
            email2.setError("Invalid email address");
            return false;
        } else {
            email2.setError(null);
            return true;
        }
    }

    private Boolean validatePhone(){

        String val = phoneNo.getText().toString();

        if (val.isEmpty()) {
            phoneNo.setError("Field cannot be empty");
            return false;

        } else{
            phoneNo.setError(null);
            return true;
        }
    }

    private Boolean validateAddress(){

        String val = address.getText().toString();

        if (val.isEmpty()){
            address.setError("Field cannot be empty");
            return false;
        } else{
            address.setError(null);
            return true;
        }
    }

    private Boolean validatePassword(){

        String val = pass2.getText().toString();
        String passwordPattern = "^" + "(?=.*[a-zA-Z])" +   //any letter
                "(?=.*[@#$%^&+=])" +                        // at least 1 special character
                "(?=\\S+$)" +                               // no white space
                ".{4,}" +                                    // at least 4 characters
                "$";


        if (val.isEmpty()){
            pass2.setError("Password cannot be empty");
            return false;
        }else if (!val.matches(passwordPattern)){
            pass2.setError("Password to weak");
            return false;

        } else{
            pass2.setError(null);
            return true;
        }
    }

    }


