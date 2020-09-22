package au.edu.swin.sdmd.picturethis

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_food.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //Declare global variable


    private var foodRating1 = 0
    private var foodTextView2 = 0
    private var foodTextView3 = 0
    private var foodTextView4 = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val chickenrice = findViewById<ImageView>(R.id.chickenrice)
        val nasilemak = findViewById<ImageView>(R.id.nasilemak)
        val friednoodle = findViewById<ImageView>(R.id.friednoodle)
        val satay = findViewById<ImageView>(R.id.satay)

        val foodRating1 = findViewById<TextView>(R.id.foodRating1)
        val foodRating2 = findViewById<TextView>(R.id.foodRating2)
        val foodRating3 = findViewById<TextView>(R.id.foodRating3)
        val foodRating4 = findViewById<TextView>(R.id.foodRating4)

        intent = Intent(applicationContext, Food::class.java)
        currentFood = intent.getStringExtra("Food")
        //collect our intent
        //collect our intent
        val intent = intent
        image = intent.getParcelableExtra("Deta")
        foodName = intent.getStringExtra("food")

        chickenrice = Image("chickenrice", "default", "default", "default", 1.0.toFloat())
        nasilemak = Image("nasilemak", "default", "default", "default", 1.0.toFloat())
        friednoodle = Image("friednoodle", "default", "default", "default", 1.0.toFloat())
        satay = Image("satay", "default", "default", "default", 1.0.toFloat())

    }




    fun onClick(view: View) {
        //getIntent().removeExtra("Food");
        intent.putExtra("Food Name", foodEditText)
        intent.putExtra("Date", dateEditText)
        intent.putExtra("Cuisine", cuisineEditText)
        intent.putExtra("Rating", ratingBar)
        when (view.id == R.id.chickenrice) {
            intent.putExtra("Food", "Chicken Rice")
            intent.putExtra("img1", chickenrice)
            startActivityForResult(intent, 1)
        }
        when (view.id == R.id.nasilemak) {
            intent.putExtra("Food", "Nasi Lemak")
            intent.putExtra("img2", nasilemak)
            // startActivity(intent);
            startActivityForResult(intent, 2)
        }
        when (view.id == R.id.friednoodle) {
            intent.putExtra("Food", "Fried Noodle")
            intent.putExtra("img3", friednoodle)
            // startActivity(intent);
            startActivityForResult(intent, 3)
        }
        when (view.id == R.id.satay) {
            intent.putExtra("Food", "Satay")
            intent.putExtra("img4", satay)
            //startActivity(intent);
            startActivityForResult(intent, 4)
        }
    }

}