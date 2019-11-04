package org.wit.dog.main

import android.app.Application
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.wit.dog.models.DogMemStore

class MainApp : Application(), AnkoLogger {

  val dogs = DogMemStore()

  override fun onCreate() {
    super.onCreate()
    info("Dog started")
  }
}