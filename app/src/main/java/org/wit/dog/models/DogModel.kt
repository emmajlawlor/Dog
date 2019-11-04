package org.wit.dog.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DogModel(var id: Long = 0,
                          var title: String = "",
                          var description: String = "") : Parcelable

