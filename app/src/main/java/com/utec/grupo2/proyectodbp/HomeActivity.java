package com.utec.grupo2.proyectodbp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    private Button mLogout;
    private FirebaseAuth Auth;
    FragmentManager manejador;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.opcion1:
                pantalla1Fragment fragmentoUno = new pantalla1Fragment();
                //Estaríamos reemplazado en cada uno de los fragmentos
                manejador.beginTransaction().replace(R.id.area, fragmentoUno).commit();
                return true;
            case R.id.opcion2:
                pantalla2Fragment fragmentoDos = new pantalla2Fragment();
                manejador.beginTransaction().replace(R.id.area, fragmentoDos).commit();
                return true;
            case R.id.opcion3:
                pantalla3Fragment fragmentoTres = new pantalla3Fragment();
                manejador.beginTransaction().replace(R.id.area, fragmentoTres).commit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Auth=FirebaseAuth.getInstance();
        mLogout= (Button) findViewById(R.id.logout_button);
        manejador = getSupportFragmentManager();
        pantalla1Fragment fragmentoUno = new pantalla1Fragment();
        manejador.beginTransaction().replace(R.id.area, fragmentoUno).commit();
    }
    public void Logout(View view){
        Auth.signOut();
        startActivity(new Intent(HomeActivity.this, AuthActivity.class));
        finish();
    }
}