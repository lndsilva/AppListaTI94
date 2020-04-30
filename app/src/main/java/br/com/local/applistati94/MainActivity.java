package br.com.local.applistati94;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String[] nomesPlanetas = {"Terra", "Urano", "Venus", "Terra", "Urano", "Venus", "Terra", "Urano", "Venus"};
    int[] imgsPlanetas = {R.drawable.terra, R.drawable.urano, R.drawable.venus, R.drawable.terra, R.drawable.urano, R.drawable.venus, R.drawable.terra, R.drawable.urano, R.drawable.venus};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listaPlanetas);

        MeuAdaptador adaptador = new MeuAdaptador();

        //ligar a lista ao adaptador

        listView.setAdapter(adaptador);

        //cliclando nos itens da lista

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Cliquei no item " + nomesPlanetas[position],
                        Toast.LENGTH_SHORT).show();
            }
        });


    }

    //Inner Class - Uma classe dentro da outra.

    public class MeuAdaptador extends BaseAdapter {

        @Override
        //Conta quantos itens eu tenho na lista
        public int getCount() {
            return imgsPlanetas.length;
        }

        @Override
        //Mostra os itens da lista
        public Object getItem(int position) {
            return null;
        }

        @Override
        //Mostra um valor grande da minha lista
        public long getItemId(int position) {
            return 0;
        }

        @Override
        //Monta ou instancia o meu layout para a list - cria a lista com o modelo
        public View getView(int position, View convertView, ViewGroup parent) {
            //Pegar as informações do layout modelo

            TextView txtNomePlaneta;
            ImageView imgPlaneta;

            View view = getLayoutInflater().inflate(R.layout.modelo_planetas, null);

            txtNomePlaneta = view.findViewById(R.id.txtNomePlaneta);
            imgPlaneta = view.findViewById(R.id.imgPlaneta);

            txtNomePlaneta.setText(nomesPlanetas[position]);
            imgPlaneta.setImageResource(imgsPlanetas[position]);

            return view;
        }
    }

}
