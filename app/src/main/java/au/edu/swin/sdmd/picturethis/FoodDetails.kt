package au.edu.swin.sdmd.picturethis

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FoodDetails(val foodName: String, val cuisine: String, val date: String, val rating: Float): Parcelable{
}
