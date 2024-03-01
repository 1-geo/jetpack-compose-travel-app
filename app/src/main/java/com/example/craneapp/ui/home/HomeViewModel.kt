/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.craneapp.ui.home

import androidx.compose.samples.crane.data.DestinationsLocalDataSource
import androidx.compose.samples.crane.data.DestinationsRepository
import androidx.compose.samples.crane.data.ExploreModel
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher

class HomeViewModel (
) : ViewModel() {
    private val destinationsRepository = DestinationsRepository(DestinationsLocalDataSource())

    val hotels: List<ExploreModel> = destinationsRepository.hotels
    val restaurants: List<ExploreModel> = destinationsRepository.restaurants
    val destinations: List<ExploreModel> = destinationsRepository.destinations

    fun updatePeople(people: Int) { }

    fun toDestinationChanged(newDestination: String) { }
}
