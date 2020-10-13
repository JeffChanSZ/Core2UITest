package au.edu.swin.sdmd.picturethis

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.RatingBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_food.*

class Food : AppCompatActivity() {

//    lateinit var foodEditText: EditText

    private var resultCode: Int = 0
    private var foodDetails: FoodDetails? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        val foodImageView = findViewById<ImageView>(R.id.foodImageView) as ImageView
        val foodEditText = findViewById<EditText>(R.id.foodEditText) as EditText
        val cuisineEditText = findViewById<EditText>(R.id.cuisineEditText) as EditText
        val dateEditText = findViewById<EditText>(R.id.dateEditText) as EditText
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar) as RatingBar


        val intent = intent.apply {
        val requestCode = getIntExtra("Request Code", 0)
        val food = getParcelableExtra<FoodDetails>("Food Details");

        when (requestCode) {
            1 -> {
                foodImageView.setImageResource(R.drawable.chickenrice)
            }
            2 -> {
                foodImageView.setImageResource(R.drawable.nasilemak)
            }
            3 -> {
                foodImageView.setImageResource(R.drawable.meegoreng)
            }
            4 -> {
                foodImageView.setImageResource(R.drawable.satay)
            }
        }

        foodEditText.setText(food?.foodName)
        cuisineEditText.setText(food?.cuisine)
        dateEditText.setText(food?.date)
        ratingBar.rating = food?.rating!!
        }
    }


    override fun onBackPressed() {

        foodDetails = FoodDetails(foodEditText.text.toString(), cuisineEditText.text.toString(), dateEditText.text.toString(),
            ratingBar.rating
        )

        val datePattern = "\\d{1,2}/\\d{1,2}/\\d{4}".toRegex()

        if (dateEditText.text.matches(datePattern)){
            val intent = Intent().apply {
            putExtra("Food Return", foodDetails)
            }
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        else{
            dateEditText.error = "Date Format must be DD/MM/YYYY"
        }

    }

}