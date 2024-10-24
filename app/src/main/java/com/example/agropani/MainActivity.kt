import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.agropani.MenuActivity
import com.example.agropani.R
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usuario = findViewById<TextView>(R.id.tvUsuario)
        val password = findViewById<TextView>(R.id.tvPassword)
        val btnLogin = findViewById<Button>(R.id.bttIniciarSesion)

        btnLogin.setOnClickListener {
            try {
                val userInput = usuario.text.toString()
                val passInput = password.text.toString()

                // Validar si los campos están vacíos
                if (userInput.isEmpty() || passInput.isEmpty()) {
                    Toast.makeText(this, "Por favor, rellena ambos campos", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                // Simular autenticación con credenciales predeterminadas
                if (userInput == "admin" && passInput == "1234") {
                    val intent = Intent(this, MenuActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                }

            } catch (e: Exception) {
                // Capturar cualquier excepción inesperada
                Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                e.printStackTrace()
            }
        }
    }
}
