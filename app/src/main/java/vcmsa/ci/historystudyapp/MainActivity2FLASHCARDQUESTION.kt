package vcmsa.ci.historystudyapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2FLASHCARDQUESTION : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_activity2_flashcardquestion)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

 var questionText: TextView
 var trueButton: Button
 var falseButton: Button

 var currentIndex = 0
 var score = 0

data class Question(val text: String, val answer: Boolean)

 val questions = listOf(
    Question("if mansa musa was the richest man in history?", true),
    Question("if was rome built in day?", false),
    Question("if pablo escober one of the most wanted man in history?", true),
    Question("if ADOLF HITLER one the most hated figures in history?", true),
    Question("if alert einstein invented the light bulb?", true),
)

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_flashcard)

    questionText = findViewById(R.id.questionText)
    trueButton = findViewById(R.id.trueButton)
    falseButton = findViewById(R.id.falseButton)

    showQuestion()

    trueButton.setOnClickListener {
        checkAnswer(true)
    }

    falseButton.setOnClickListener {
        checkAnswer(false)
    }
}

private fun showQuestion() {
    if (currentIndex < questions.size) {
        questionText.text = questions[currentIndex].text
    }
}

private fun checkAnswer(userAnswer: Boolean) {
    val correctAnswer = questions[currentIndex].answer
    if (userAnswer == correctAnswer) {
        score++
        Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
    } else {
        Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()
    }

    currentIndex++
    if (currentIndex < questions.size) {
        showQuestion()
    } else {
        val intent = Intent(this, main_activity3_scorescreen::class.java)
        intent.putExtra("score", score)
        intent.putExtra("total", questions.size)
        startActivity(intent)
        finish()

    } or if not finished {
}
}  val score = intent.getIntExtra("score", 0)
val total = intent.getIntExtra("total", 0)

val scoreText: TextView = findViewById(R.id.scoreText)
scoreText.text = "You scored $score out of $total!"
}
}