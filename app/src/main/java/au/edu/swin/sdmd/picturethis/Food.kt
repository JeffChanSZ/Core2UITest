package au.edu.swin.sdmd.picturethis

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RatingBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_food.*

class Food : AppCompatActivity() {

//    lateinit var foodEditText: EditText
//    private var foodImageView: ImageView? = null
//    private var foodEditText: EditText? = null
//    private var cuisineEditText: EditText? = null
//    private var dateEditText: EditText? = null
//    private var ratingBar: RatingBar? = null
//    private var updateButton: Button? = null
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
        val updateButton = findViewById<Button>(R.id.updateButton) as Button


        val intent = intent;
        val requestCode = intent.getIntExtra("Request Code", 0)
        val food = intent.getParcelableExtra<FoodDetails>("Food Details");

        when (requestCode) {
            1 -> {
                foodImageView.setImageResource(R.drawable.chickenrice)
                resultCode = 1
            }
            2 -> {
                foodImageView.setImageResource(R.drawable.nasilemak)
                resultCode = 2
            }
            3 -> {
                foodImageView.setImageResource(R.drawable.meegoreng)
                resultCode = 3
            }
            4 -> {
                foodImageView.setImageResource(R.drawable.satay)
                resultCode = 4
            }
        }

        foodEditText.setText(food?.foodName)
        cuisineEditText.setText(food?.cuisine)
        dateEditText.setText(food?.date)
        ratingBar.rating = food?.rating!!

    }

         fun onUpdate(view: View) {

             foodDetails = FoodDetails(foodEditText.text.toString(), cuisineEditText.text.toString(), dateEditText.text.toString(),
                 ratingBar.rating
             )

             val intent = Intent()
                intent.putExtra("Food Return", foodDetails)
                setResult(resultCode, intent)
             finish()
        }
}