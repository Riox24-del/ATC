package ac.eq.atc.ui.dashboard;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import ac.eq.atc.MainActivity;
import ac.eq.atc.R;
import ac.eq.atc.databinding.FragmentDashboardBinding;


public class DashboardFragment extends Fragment {

    private Button AlertBtn;
    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.boton2;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        AlertBtn = root.findViewById(R.id.boton1);
        AlertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alerta = new AlertDialog.Builder(requireContext()); // Usar requireContext() para obtener el contexto adecuado
                alerta.setMessage("Tu solicitud ha sido enviada")
                        .setCancelable(true)
                        .show();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
