package ac.eq.atc;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import ac.eq.atc.databinding.ActivityMainBinding;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private BottomNavigationView navViewUser;
    private BottomNavigationView navViewAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        navViewUser = binding.navView; // Referencia a la barra de navegación de usuarios
        navViewAdmin = binding.navView2; // Referencia a la barra de navegación de administradores

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_user)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navViewUser, navController); // Usar navViewUser para la barra de usuarios

        // Configuración de la segunda barra de navegación
        BottomNavigationView secondNavView = binding.navView2;
        AppBarConfiguration secondAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_publicaciones, R.id.navigation_usuariosLista, R.id.navigation_addContactos, R.id.navigation_mapa)
                .build();
        NavController secondNavController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, secondNavController, secondAppBarConfiguration);
        NavigationUI.setupWithNavController(secondNavView, secondNavController);

        // Ocultar la segunda barra de navegación inicialmente
        navViewAdmin.setVisibility(View.GONE);
    }

    // Método para cambiar la visibilidad de las barras de navegación
    public void toggleNavigationVisibility(boolean showUserNav) {
        if (showUserNav) {
            navViewUser.setVisibility(View.VISIBLE);
            navViewAdmin.setVisibility(View.GONE);
        } else {
            navViewUser.setVisibility(View.GONE);
            navViewAdmin.setVisibility(View.VISIBLE);
        }
    }
}
