package com.example.calculateurdimpots;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Déclaration des éléments de l'interface
    private EditText surfaceInput, piecesInput;
    private CheckBox piscineCheckbox;
    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Liaison XML <-> Java
        surfaceInput = findViewById(R.id.input_surface);
        piecesInput = findViewById(R.id.input_pieces);
        piscineCheckbox = findViewById(R.id.checkbox_piscine);
        resultView = findViewById(R.id.result);

        // Écouteur du bouton "Calculer"
        findViewById(R.id.button_calcul).setOnClickListener(v -> calculer());
    }

    private void calculer() {
        String surfaceStr = surfaceInput.getText().toString().trim();
        String piecesStr = piecesInput.getText().toString().trim();

        if (surfaceStr.isEmpty() || piecesStr.isEmpty()) {
            resultView.setText("Veuillez remplir tous les champs.");
            return;
        }

        double surface = Double.parseDouble(surfaceStr);
        int pieces = Integer.parseInt(piecesStr);
        boolean piscine = piscineCheckbox.isChecked();

        double impotBase = surface * 2;
        double supplement = pieces * 50 + (piscine ? 100 : 0);
        double total = impotBase + supplement;

        resultView.setText("Impôt total : " + total + " DH");
    }
}