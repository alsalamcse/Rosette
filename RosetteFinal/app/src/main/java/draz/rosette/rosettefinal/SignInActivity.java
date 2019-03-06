package draz.rosette.rosettefinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SignInActivity extends AppCompatActivity {
    private EditText etEmail,etPassWord;
    private Button btnLogIN,btnSignUp;

  //  FirebaseAuth auth;//to establish sign in sign up
    // FirebaseUser user;//user

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        etEmail=(EditText)findViewById(R.id .edEmail) ;
        etPassWord=(EditText)findViewById(R.id .edPassWord) ;
        btnLogIN=(Button)findViewById(R.id .btnLogIn) ;
        btnSignUp=(Button) findViewById(R.id .btnSignUp) ;

    }

}
