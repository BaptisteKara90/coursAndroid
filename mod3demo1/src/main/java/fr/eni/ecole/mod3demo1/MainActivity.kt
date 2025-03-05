package fr.eni.ecole.mod3demo1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etName = findViewById<EditText>(R.id.et_name)
        val etAge = findViewById<EditText>(R.id.et_age)
        val btn = findViewById<Button>(R.id.button)

        btn.setOnClickListener {
            val name = etName.text.toString()
            val age = etAge.text.toString()

            Toast.makeText(this, "Bonjour $name, tu as $age ans", Toast.LENGTH_LONG).show()
            Snackbar.make(etName, "Bonjour $name, tu as $age ans", Snackbar.LENGTH_LONG).show()
        }
    }
}