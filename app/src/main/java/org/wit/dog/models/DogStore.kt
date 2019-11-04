package org.wit.dog.models

interface DogStore {
  fun findAll(): List<DogModel>
  fun create(dog: DogModel)
  fun update(dog: DogModel)
}