package frasesdodia.studio.com.frasesdodia;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button GerarNovaFrase;
    private TextView MostrarFrase;
    private String[] frase = {"Naruto", "Sasuke", "Sakura", "Kakashi", "Akuma", "Itachi"};
    //ArrayList<String> fraseslista = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GerarNovaFrase = (Button)findViewById(R.id.botaoNovaFraseId);
        MostrarFrase = (TextView)findViewById(R.id.textoNovaFraseId);
        //fraseslista.addAll(Arrays.asList(frase));
        //MostrarFrase.setText(String.valueOf(fraseslista.size()));
        /*GerarNovaFrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fraseslista.size() > 0) {
                    Random random = new Random();
                    int nomesorteado = random.nextInt(fraseslista.size());
                    MostrarFrase.setText(fraseslista.get(nomesorteado));
                    fraseslista.remove(nomesorteado);
                }
            }
        });*/
    }
}
