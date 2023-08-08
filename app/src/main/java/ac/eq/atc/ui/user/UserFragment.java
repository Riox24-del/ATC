package ac.eq.atc.ui.user;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import ac.eq.atc.MainActivity;
import ac.eq.atc.R;
import ac.eq.atc.ui.admin.adminPubliFragment;

public class UserFragment extends Fragment {
    private Button btnAdmin;
    private UserViewModel mViewModel;

    public static UserFragment newInstance() {
        return new UserFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user, container, false);


               Button btnAdmin = rootView.findViewById(R.id.btnAdmin);
                btnAdmin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        adminPubliFragment adminFragment = new adminPubliFragment();
                        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, adminFragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();

                        // Cambiar la barra de navegación al fragment de administrador
                        ((MainActivity) requireActivity()).toggleNavigationVisibility(false);
                    }
                });



        return rootView; // Move this line after setting up the click listener
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        // TODO: Use the ViewModel
    }
}
