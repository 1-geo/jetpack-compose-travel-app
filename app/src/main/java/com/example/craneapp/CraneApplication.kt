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

package com.example.craneapp

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.imageLoader
import com.example.craneapp.utils.UnsplashSizingInterceptor

class CraneApplication : Application(), ImageLoaderFactory {

    val imageloader = ImageLoader.Builder(this)
        .components {
            add(UnsplashSizingInterceptor)
        }
        .build()

    /**
     * Create the singleton [ImageLoader].
     * Note: This is used by [rememberImagePainter] to load images in the app.
     * thru some Local magic it gets passed into, need to learn
     */
    override fun newImageLoader(): ImageLoader {
        return imageLoader
    }
}
