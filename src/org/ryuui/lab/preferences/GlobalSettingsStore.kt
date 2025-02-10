/*
 * Copyright (C) 2025 Ryu-UI Org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ryuui.lab.preferences

import android.content.ContentResolver
import android.provider.Settings
import androidx.preference.PreferenceDataStore

class GlobalSettingsStore(private val contentResolver: ContentResolver) : PreferenceDataStore() {

    override fun getBoolean(key: String, defValue: Boolean): Boolean {
        return getInt(key, if (defValue) 1 else 0) != 0
    }

    override fun getFloat(key: String, defValue: Float): Float {
        return Settings.Global.getFloat(contentResolver, key, defValue)
    }

    override fun getInt(key: String, defValue: Int): Int {
        return Settings.Global.getInt(contentResolver, key, defValue)
    }

    override fun getLong(key: String, defValue: Long): Long {
        return Settings.Global.getLong(contentResolver, key, defValue)
    }

    override fun getString(key: String, defValue: String?): String? {
        return Settings.Global.getString(contentResolver, key) ?: defValue
    }

    override fun putBoolean(key: String, value: Boolean) {
        putInt(key, if (value) 1 else 0)
    }

    override fun putFloat(key: String, value: Float) {
        Settings.Global.putFloat(contentResolver, key, value)
    }

    override fun putInt(key: String, value: Int) {
        Settings.Global.putInt(contentResolver, key, value)
    }

    override fun putLong(key: String, value: Long) {
        Settings.Global.putLong(contentResolver, key, value)
    }

    override fun putString(key: String, value: String?) {
        Settings.Global.putString(contentResolver, key, value)
    }
}
