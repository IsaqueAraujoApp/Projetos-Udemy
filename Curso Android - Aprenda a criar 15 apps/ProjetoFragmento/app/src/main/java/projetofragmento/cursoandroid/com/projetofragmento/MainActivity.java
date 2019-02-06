package projetofragmento.cursoandroid.com.projetofragmento;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private boolean status = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                if(status){
                    LoginFragment loginFragment = new LoginFragment();
                    fragmentTransaction.add(R.id.relative,loginFragment);
                    fragmentTransaction.commit();
                    button.setText("Cadastre-se");
                    status = false;
                }else
                {
                    CadastroFragment cadastroFragmentt = new CadastroFragment();
                    fragmentTransaction.add(R.id.relative,cadastroFragmentt);
                    fragmentTransaction.commit();
                    button.setText("Logar");
                    status = true;
                }
            }
        });
    }
}
