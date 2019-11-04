package org.wit.dog.models

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

var lastId = 0L

internal fun getId(): Long {
  return lastId++
}

class DogMemStore : DogStore, AnkoLogger {

  val dogs = ArrayList<DogModel>()

  override fun findAll(): List<DogModel> {
    return dogs
  }

  override fun create(dog: DogModel) {
    dog.id = getId()
    dogs.add(dog)
    logAll()
  }

  override fun update(dog: DogModel) {
    var foundDog: DogModel? = dogs.find { p -> p.id == dog.id }
    if (foundDog != null) {
      foundDog.title = dog.title
      foundDog.description = dog.description
    }
  }

  internal fun logAll() {
    dogs.forEach { info("${it}") }
  }
}