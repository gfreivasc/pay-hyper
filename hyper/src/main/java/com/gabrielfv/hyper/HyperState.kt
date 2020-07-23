package com.gabrielfv.hyper

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

interface HyperState : Parcelable {

    @Parcelize
    object None : HyperState
}