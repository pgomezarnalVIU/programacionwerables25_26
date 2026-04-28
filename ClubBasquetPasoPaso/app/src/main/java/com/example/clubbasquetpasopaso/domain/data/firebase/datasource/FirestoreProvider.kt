package com.example.clubbasquetpasopaso.domain.data.firebase.datasource

import com.google.firebase.firestore.FirebaseFirestore

object FirestoreProvider {

    val instance: FirebaseFirestore by lazy {
        FirebaseFirestore.getInstance()
    }
}