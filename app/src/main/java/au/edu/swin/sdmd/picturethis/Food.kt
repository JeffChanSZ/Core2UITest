package au.edu.swin.sdmd.picturethis

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RatingBar
import androidx.appcompat.app.AppCompatActivity

class Food : AppCompatActivity() {

    private var foodName: String? = null
    private var imageView: ImageView? = null
    private var imageName: EditText? = null
    private var cuisine: EditText? = null
    private var date: EditText? = null
    private var ratingBar: RatingBar? = null
    private var updateButton: Button? = null
    private var food: Image? = null

    private var pname: String? = null
    private var pcuisine: String? = null
    private var pdate: String? = null

    private var w: String? = null
    private var x: String? = null
    private var z: String? = null
    private var r: Float? = null

    private var food1: Image? = null
    private var food2: Image? = null
    private var food3: Image? = null
    private var food4: Image? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        val foodImageView = findViewById<ImageView>(R.id.foodImageView)
        foodName = (findViewById<EditText>(R.id.foodEditText)).toString()
        cuisine = findViewById<EditText>(R.id.cuisineEditText)
        date = findViewById<EditText>(R.id.dateEditText)
        ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        updateButton = findViewById<Button>(R.id.updateButton)

        val intent = this.intent.also {

            foodName = it.getStringExtra("Food")
            pname = it.getStringExtra("foodName")
            pcuisine = it.getStringExtra("cuisine")
            pdate = it.getStringExtra("date")
        }



        when (foodName) {
            "chickenrice" -> {
                food1 = intent.getParcelableExtra("food1")
                imageView?.setImageResource(R.drawable.chickenrice)
                imageName.setText(food1.getImageName())
                cuisine.setText(food1.getCuisine())
                date.setText(food1.getDate())
            }
            "nasilemak" -> {
                food2 = intent.getParcelableExtra("food2")
                imageView?.setImageResource(R.drawable.nasilemak)
                imageName.setText(food2.getImageName())
                cuisine.setText(food2.getCuisine())
                date.setText(food2.getDate())
            }
            "friednoodle" -> {
                food3 = intent.getParcelableExtra("food3")
                imageView?.setImageResource(R.drawable.meegoreng)
                imageName.setText(food3.getImageName())
                cuisine.setText(food3.getCuisine())
                date.setText(food3.getDate()))
            }
            "satay" -> {
                food4 = intent.getParcelableExtra("food4")
                imageView?.setImageResource(R.drawable.satay)
                imageName.setText(food4.getImageName())
                cuisine.setText(food4.getCuisine())
                date.setText(food4.getDate())
            }
        }

        updateButton.setOnClickListener(View.OnClickListener {
            w = imageName.getText().toString()
            x = cuisine.getText().toString()
            z = date.getText().toString()
            r = ratingBar.getRating()
            food = Image(w, x, z, r)


            // Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            val intent = Intent()

            //intent.putExtra("Food", image);
            intent.putExtra("abc", food)
            intent.putExtra("food", foodName)
            // intent.putExtra("name", w);
            //intent.putExtra("date", z);

            //startActivity(intent);
            setResult(0, intent)
            finish()
        })

    }

}