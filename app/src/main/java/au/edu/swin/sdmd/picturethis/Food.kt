package au.edu.swin.sdmd.picturethis

import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_food.view.*
import kotlinx.android.synthetic.main.activity_main.*

class Food : AppCompatActivity() {

    private var foodImageView: ImageView? = null
//    lateinit var foodEditText: EditText
//    private var foodEditText: EditText? = null
//    private var cuisineEditText: EditText? = null
//    private var dateEditText: EditText? = null
    private var ratingBar: RatingBar? = null
    private var updateButton: Button? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        foodImageView = findViewById<ImageView>(R.id.foodImageView)
        val foodEditText = findViewById<EditText>(R.id.foodEditText) as EditText
        val cuisineEditText = findViewById<EditText>(R.id.cuisineEditText) as EditText
        val dateEditText = findViewById<EditText>(R.id.dateEditText) as EditText
        ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        updateButton = findViewById<Button>(R.id.updateButton)


        val intent = intent;
        val food = intent.getParcelableExtra<FoodDetails>("Food Details");
        foodEditText.setText(food?.foodName)
        cuisineEditText.setText(food?.cuisine)
        dateEditText.setText(food?.date)


    }


}