package com.example.asemtemp2.model

import android.os.Parcel
import android.os.Parcelable

data class Child(val name: String?, val age: String?, val gender: String?, val selectedAvatarName: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(age)
        parcel.writeString(gender)
        parcel.writeString(selectedAvatarName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Child> {
        override fun createFromParcel(parcel: Parcel): Child {
            return Child(parcel)
        }

        override fun newArray(size: Int): Array<Child?> {
            return arrayOfNulls(size)
        }
    }
}

