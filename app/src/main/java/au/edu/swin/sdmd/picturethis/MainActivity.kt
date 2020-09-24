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


        var chickenrice = findViewById<ImageView>(R.id.chickenrice)
        var nasilemak = findViewById<ImageView>(R.id.nasilemak)
        var friednoodle = findViewById<ImageView>(R.id.friednoodle)
        var satay = findViewById<ImageView>(R.id.satay)

        val foodRating1 = findViewById<TextView>(R.id.foodRating1)
        val foodRating2 = findViewById<TextView>(R.id.foodRating2)
        val foodRating3 = findViewById<TextView>(R.id.foodRating3)
        val foodRating4 = findViewById<TextView>(R.id.foodRating4)

        intent = Intent(applicationContext, Food::class.java)
        currentFood = intent.getStringExtra("Food")

        //collect our intent
        val intent = intent
        food = intent.getParcelableExtra("Deta")
        foodName = intent.getStringExtra("food")

        chickenrice = Image("chickenrice", "default", "default", "default", 1.0.toFloat())
        nasilemak = Image("nasilemak", "default", "default", "default", 1.0.toFloat())
        friednoodle = Image("friednoodle", "default", "default", "default", 1.0.toFloat())
        satay = Image("satay", "default", "default", "default", 1.0.toFloat())

    }

    fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        @Nullable data: Intent
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        foodName = data.getStringExtra("food")
        if (foodName != null) {
            if (resultCode == 0) {
                if (requestCode == 1 && foodName == "chickenrice") {
                    foodTextView1 = data.getParcelableExtra("abc")
                    imageName = foodTextView1.getImageName()
                    date = foodTextView1.getDate()
                    textView7.setText(imageName + "\n" + date)
                }
                if (requestCode == 2 && foodName == "friedrice") {
                    img2 = data.getParcelableExtra("abc")
                    imageName = img2.getImageName()
                    date = img2.getDate()
                    textView11.setText(imageName + "\n" + date)
                }
                if (requestCode == 3 && foodName == "burger") {
                    img3 = intent.getParcelableExtra("burger")
                    imageName = img3.getImageName()
                    date = img3.getDate()
                    textView12.setText(imageName + "\n" + date)
                }
                if (requestCode == 4 && foodName == "pizza") {
                    img4 = intent.getParcelableExtra("pizza")
                    imageName = img4.getImageName()
                    date = img4.getDate()
                    textView13.setText(imageName + "\n" + date)
                }
            }
        }
        //now collect all property values
        if (image != null && foodName != null) {
            imageName = image.getImageName()
            url = image.getUrl()
            owner = image.getOwner()
            date = image.getDate()
            rating = image.getRating()
            when (foodName) {
                "pancake" -> {
                    textView7.setText(imageName + "\n" + date)
                    img1.setName(image.getImageName())
                    img1.setUrl(image.getUrl())
                    img1.setDate(image.getDate())
                    img1.setOwner(image.getOwner())
                }
                "friedrice" -> {
                    textView11.setText(imageName + "\n" + date)
                    img2.setName(image.getImageName())
                    img2.setUrl(image.getUrl())
                    img2.setDate(image.getDate())
                    img2.setOwner(image.getOwner())
                }
                "burger" -> {
                    textView12.setText(imageName + "\n" + date)
                    img3.setName(image.getImageName())
                    img3.setUrl(image.getUrl())
                    img3.setDate(image.getDate())
                    img3.setOwner(image.getOwner())
                }
                "pizza" -> {
                    textView13.setText(imageName + "\n" + date)
                    img4.setName(image.getImageName())
                    img4.setUrl(image.getUrl())
                    img4.setDate(image.getDate())
                    img4.setOwner(image.getOwner())
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
            intent.putExtra("Food", "Chicken Rice")
            intent.putExtra("food1", chickenrice) {
                startActivityForResult(intent, 1)
            }
        }
        when (view.id == R.id.nasilemak) {
            intent.putExtra("Food", "Nasi Lemak")
            intent.putExtra("food2", nasilemak) {
                // startActivity(intent);
                startActivityForResult(intent, 2)
            }
        }
        when (view.id == R.id.friednoodle) {
            intent.putExtra("Food", "Fried Noodle")
            intent.putExtra("food3", friednoodle) {
                // startActivity(intent);
                startActivityForResult(intent, 3)
            }
        }
        when (view.id == R.id.satay) {
            intent.putExtra("Food", "Satay")
            intent.putExtra("food4", satay) {
                //startActivity(intent);
                startActivityForResult(intent, 4)
            }
        }
    }

}