package vcmsa.ci.historystudyapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3SCORESCREEN : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_activity3_scorescreen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

val score = intent.getIntExtra("score", 0)
val total = intent.getIntExtra("total", 0)

val scoreText: TextView = findViewById(R.id.scoreText)
scoreText.text = "You scored $score out of $total!"
}
 val highScoreFeedback = listOf(
    "Excellent job!",
    "keep at it",
    "Impressive you did it!",
    "You really understand great!",
    "Top marks!"
)

val lowScoreFeedback = listOf(
    "Keep practicing!",
    "You’ll get it next time!",
    "you can do better.",
    "Don't give up!",
    "More study will help!"
)

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_result)

    val score = intent.getIntExtra("score", 0)
    val total = intent.getIntExtra("total", 5)
    val questions = intent.getStringArrayListExtra("questions")
    val answers = intent.getStringArrayListExtra("answers")

    val scoreText: TextView = findViewById(R.id.scoreText)
    val feedbackText: TextView = findViewById(R.id.feedbackText)
    val reviewButton: Button = findViewById(R.id.reviewButton)

    scoreText.text = "You scored $score out of $total"

    val feedback = if (score >= total * 0.7) {
        highScoreFeedback.random()
    } else {
        lowScoreFeedback.random()
    }

    feedbackText.text = feedback

    reviewButton.setOnClickListener {
        val intent = Intent(this, ReviewmainActivity3scorescreen::class.java)
        intent.putStringArrayListExtra("questions", questions)
        intent.putStringArrayListExtra("answers", answers)
        startActivity(intent)
    }(intent)stop/end {}
}
