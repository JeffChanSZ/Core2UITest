package au.edu.swin.sdmd.picturethis

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_food.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //Declare global variable

    private var chickenrice: ImageView? = null
    private var nasilemak: ImageView? = null
    private var friednoodle: ImageView? = null
    private var satay: ImageView? = null
    
    private var intent: Intent? = null
    private var currentFood: String? = null
    private var foodName: String? = null
    private var imageName: String? = null
    private var cuisine: String? = null
    private var date: String? = null
    private var rating: Float? = null
    private var food: Image? = null

    private var foodTextView1: TextView? = null
    private var foodTextView2: TextView? = null
    private var foodTextView3: TextView? = null
    private var foodTextView4: TextView? = null

    private var food1: Image? = null
    private var food2: Image? = null
    private var food3: Image? = null
    private var food4: Image? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var chickenrice = findViewById<ImageView>(R.id.chickenrice)
        var nasilemak = findViewById<ImageView>(R.id.nasilemak)
        var friednoodle = findViewById<ImageView>(R.id.friednoodle)
        var satay = findViewById<ImageView>(R.id.satay)
        
        val foodRating1 = findViewById<TextView>(R.id.foodRating1)
        val foodRating2 = findViewById<TextView>(R.id.foodRating2)
        val foodRating3 = findViewById<TextView>(R.id.foodRating3)
        val foodRating4 = findViewById<TextView>(R.id.foodRating4)

        intent = Intent(applicationContext, Food::class.java)
        currentFood = intent.getStringExtra("Current Food")

        //collect our intent
        val intent = intent
        if (intent != null) {
            food = intent.getParcelableExtra("Food")
        }
        if (intent != null) {
            foodName = intent.getStringExtra("Food Name")
        }

        chickenrice = Image("chickenrice", "default", "default", 1.0.toFloat())
        nasilemak = Image("nasilemak", "default", "default", 1.0.toFloat())
        friednoodle = Image("friednoodle", "default", "default", 1.0.toFloat())
        satay = Image("satay", "default", "default", 1.0.toFloat())

    }

    fun onActivityResult(requestCode: Int, resultCode: Int, @Nullable data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        foodName = data.getStringExtra("food")
        if (foodName != null) {
            if (resultCode == 0) {
                if (requestCode == 1 && foodName == "chickenrice") {
                    food1 = data.getParcelableExtra("chickenrice")
                    imageName = food1.getImageName()
                    rating = food1.getRating()
                    foodTextView1?.text = imageName + "\n" + rating
                }
                if (requestCode == 2 && foodName == "nasilemak") {
                    food2 = data.getParcelableExtra("friedrice")
                    imageName = food2.getImageName()
                    rating = food2.getRating()
                    foodTextView2?.text = imageName + "\n" + rating
                }
                if (requestCode == 3 && foodName == "friednoodle") {
                    food3 = intent.getParcelableExtra("friednoodle")
                    imageName = food3.getImageName()
                    rating = food3.getRating()
                    foodTextView3?.text = imageName + "\n" + rating
                }
                if (requestCode == 4 && foodName == "satay") {
                    food4 = intent.getParcelableExtra("satay")
                    imageName = food4.getImageName()
                    rating = food4.getDate()
                    foodTextView4?.text = imageName + "\n" + rating
                }
            }
        }
        //now collect all property values
        if (food != null && foodName != null) {
            imageName = food.getImageName()
            cuisine = food.getCuisine()
            date = food.getDate()
            rating = food.getRating()
            when (foodName) {
                "chickenrice" -> {
                    foodTextView1?.text = imageName + "\n" + rating
                    food1.setName(image.getImageName())
                    food1.setCuisine(image.getCuisine())
                    food1.setDate(image.getDate())
                    food1.setRating(image.getRating())
                }
                "nasilemak" -> {
                    foodTextView2?.text = imageName + "\n" + rating
                    food2.setName(image.getImageName())
                    food2.setCuisine(image.getCuisine())
                    food2.setDate(image.getDate())
                    food2.setRating(image.getRating())
                }
                "friednoodle" -> {
                    foodTextView3?.text = imageName + "\n" + rating
                    food3.setName(image.getImageName())
                    food3.setCuisine(image.getCuisine())
                    food3.setDate(image.getDate())
                    food3.setRating(image.getRating())
                }
                "satay" -> {
                    foodTextView4?.text = imageName + "\n" + rating
                    food4.setName(image.getImageName())
                    food4.setCuisine(image.getCuisine())
                    food4.setDate(image.getDate())
                    food4.setRating(image.getRating())
                }
            }
        }
    }


    fun onClick(view: View) {
        //getIntent().removeExtra("Food");
        intent.putExtra("Food Name", foodEditText)
        intent.putExtra("Date", dateEditText)
        intent.putExtra("Cuisine", cuisineEditText)
        intent.putExtra("Rating", ratingBar)
        when (view.id == R.id.chickenrice) {
            (intent?.putExtra("Food", "Chicken Rice") ?: )
            intent.putExtra("food1", chickenrice) {
                startActivityForResult(intent, 1)
            }
        }
        when (view.id == R.id.nasilemak) {
            (intent?.putExtra("Food", "Nasi Lemak") ?: )
            intent.putExtra("food2", nasilemak) {
                // startActivity(intent);
                startActivityForResult(intent, 2)
            }
        }
        when (view.id == R.id.friednoodle) {
            (intent?.putExtra("Food", "Fried Noodle") ?: )
            intent.putExtra("food3", friednoodle) {
                // startActivity(intent);
                startActivityForResult(intent, 3)
            }
        }
        when (view.id == R.id.satay) {
            (intent?.putExtra("Food", "Satay") ?: )
            intent.putExtra("food4", satay) {
                //startActivity(intent);
                startActivityForResult(intent, 4)
            }
        }
    }

}