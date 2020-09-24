package au.edu.swin.sdmd.picturethis

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var foodImageView1: ImageView? = null
    private var foodImageView2: ImageView? = null
    private var foodImageView3: ImageView? = null
    private var foodImageView4: ImageView? = null

    private var foodTextView1: TextView? = null
    private var foodTextView2: TextView? = null
    private var foodTextView3: TextView? = null
    private var foodTextView4: TextView? = null

    private var ratingTextView1: TextView? = null
    private var ratingTextView2: TextView? = null
    private var ratingTextView3: TextView? = null
    private var ratingTextView4: TextView? = null

    private var food1: FoodDetails? = null
    private var food2: FoodDetails? = null
    private var food3: FoodDetails? = null
    private var food4: FoodDetails? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        foodImageView1 = findViewById<ImageView>(R.id.chickenrice)
        foodImageView2 = findViewById<ImageView>(R.id.nasilemak)
        foodImageView3 = findViewById<ImageView>(R.id.friednoodle)
        foodImageView4 = findViewById<ImageView>(R.id.satay)

        foodTextView1 = findViewById<TextView>(R.id.foodTextView1)
        foodTextView2 = findViewById<TextView>(R.id.foodTextView2)
        foodTextView3 = findViewById<TextView>(R.id.foodTextView3)
        foodTextView4 = findViewById<TextView>(R.id.foodTextView4)

        ratingTextView1 = findViewById<TextView>(R.id.foodRating1)
        ratingTextView2 = findViewById<TextView>(R.id.foodRating2)
        ratingTextView3 = findViewById<TextView>(R.id.foodRating3)
        ratingTextView4 = findViewById<TextView>(R.id.foodRating4)

        food1 = FoodDetails("chickenrice", "default", "default", 1.0.toFloat())
        food2 = FoodDetails("nasilemak", "default", "default", 1.0.toFloat())
        food3 = FoodDetails("friednoodle", "default", "default", 1.0.toFloat())
        food4 = FoodDetails("satay", "default", "default",  1.0.toFloat())

    }


    fun onClick(view: View) {
        val i = Intent(this, Food::class.java)

        when(view.id) {
            R.id.chickenrice -> { i.putExtra("Food Details", food1) }
            R.id.nasilemak -> {i.putExtra("Food Details", food2)}
            R.id.friednoodle -> {i.putExtra("Food Details", food3)}
            R.id.satay -> {i.putExtra("Food Details", food4)}
        }


        startActivityForResult(i, 0)
    }

}