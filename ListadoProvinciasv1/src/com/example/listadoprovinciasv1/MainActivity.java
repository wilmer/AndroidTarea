package com.example.listadoprovinciasv1;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.renderscript.Element;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;




public class MainActivity extends Activity {
	
	private ListView lista; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado);

        
        ArrayList<Provincia> datos = new ArrayList<Provincia>();  
        
        datos.add(new Provincia(R.drawable.arequipa, "Arequipa", "Arequipa","http://es.wikipedia.org/wiki/Provincia_de_Arequipa"));
        datos.add(new Provincia(R.drawable.camana, "Camana", "Camana","http://es.wikipedia.org/wiki/Provincia_de_Camana"));
        datos.add(new Provincia(R.drawable.islay, "Islay", "Mollendo","http://es.wikipedia.org/wiki/Provincia_de_Islay"));
        datos.add(new Provincia(R.drawable.caraveli, "Caraveli", "Caraveli","http://es.wikipedia.org/wiki/Provincia_de_Caraveli"));
        datos.add(new Provincia(R.drawable.castilla, "Castilla", "Aplao","http://es.wikipedia.org/wiki/Provincia_de_Castilla"));
        datos.add(new Provincia(R.drawable.caylloma, "Caylloma", "Chivay","http://es.wikipedia.org/wiki/Provincia_de_Caylloma"));
        datos.add(new Provincia(R.drawable.condesuyos, "Condesuyos", "Chuquibamba","http://es.wikipedia.org/wiki/Provincia_de_Condesuyos"));
        datos.add(new Provincia(R.drawable.union, "La Union", "Cotahuasi","http://es.wikipedia.org/wiki/Provincia_de_La_Union"));
        lista = (ListView) findViewById(R.id.ListView_listado);
        lista.setAdapter(new Lista_adaptador(this, R.layout.entrada, datos){
			@Override
			public void onEntrada(Object entrada, View view) {
		        if (entrada != null) {
		            TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior); 
		            if (texto_superior_entrada != null) 
		            	texto_superior_entrada.setText(((Provincia) entrada).get_capital()); 
		              
		            
		            TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior); 
		            if (texto_inferior_entrada != null)
		            	texto_inferior_entrada.setText(((Provincia) entrada).get_capital()); 
		              
		            ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen); 
		            if (imagen_entrada != null)
		            	imagen_entrada.setImageResource(((Provincia) entrada).get_idImagen());
		        }
			}
		});
        
        lista.setOnItemClickListener(new OnItemClickListener() { 
			@Override
			public void onItemClick(AdapterView<?> nuevo, View view, int posicion, long id) {
				Provincia elegido = (Provincia) nuevo.getItemAtPosition(posicion); 
                
                CharSequence texto = "Seleccionado: " + elegido.get_nombre();
                Toast toast = Toast.makeText(MainActivity.this, texto, Toast.LENGTH_LONG);
                toast.show();
			}
        });
 }
    
    
    
    public void pgWeb(View view) {
    	
   
   Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://es.wikipedia.org/wiki/Provincia_de_Arequipa"));
startActivity(intent);
 }
    
    
}

