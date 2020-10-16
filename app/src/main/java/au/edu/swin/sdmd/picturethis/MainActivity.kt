package au.edu.swin.sdmd.picturethis

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_food.*
import kotlinx.android.synthetic.main.activity_food.view.*
import kotlinx.android.synthetic.main.activity_main.*

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

    private var requestCode: Int = 0

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

        food1 = FoodDetails("Chicken Rice", "Malaysian Cuisine", "26/9/2020", 3.0.toFloat())
        food2 = FoodDetails("Nasi Lemak", "Malaysian Cuisine", "26/9/2020", 4.0.toFloat())
        food3 = FoodDetails("Fried Noodle", "Malaysian Cuisine", "26/9/2020", 5.0.toFloat())
        food4 = FoodDetails("Satay", "Malaysian Cuisine", "26/9/2020",  2.0.toFloat())

    }


    fun onClick(view: View) {
        val i = Intent(this, Food::class.java).apply {

        when(view.id) {
            R.id.chickenrice -> {
                putExtra("Food Details", food1)
                foodImageView1?.contentDescription = "Chicken Rice"
                requestCode = 1
            }
            R.id.nasilemak -> {
                putExtra("Food Details", food2)
                requestCode = 2
            }
            R.id.friednoodle -> {
                putExtra("Food Details", food3)
                requestCode = 3
            }
            R.id.satay -> {
                putExtra("Food Details", food4)
                requestCode = 4
            }
        }
        }

        i.putExtra("Request Code", requestCode)
        startActivityForResult(i, requestCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

            val returnFood = data?.getParcelableExtra<FoodDetails>("Food Return")

            if (resultCode != Activity.RESULT_OK ) return

            else {
                when (requestCode) {
                    1 -> {
                        foodTextView1?.text = returnFood?.foodName
                        foodRating1?.text = returnFood?.rating.toString()
                        food1 = returnFood
                    }
                    2 -> {
                        foodTextView2?.text = returnFood?.foodName
                        foodRating2?.text = returnFood?.rating.toString()
                        food2 = returnFood
                    }
                    3 -> {
                        foodTextView3?.text = returnFood?.foodName
                        foodRating3?.text = returnFood?.rating.toString()
                        food3 = returnFood
                    }
                    4 -> {
                        foodTextView4?.text = returnFood?.foodName
                        foodRating4?.text = returnFood?.rating.toString()
                        food4 = returnFood
                    }
                }
            }
        }
}