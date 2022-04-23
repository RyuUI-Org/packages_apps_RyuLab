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

package org.ryuui.lab.fragments

import android.content.ContentResolver
import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.provider.Settings
import androidx.preference.Preference
import androidx.preference.Preference.OnPreferenceChangeListener
import androidx.preference.PreferenceScreen
import com.android.internal.logging.nano.MetricsProto
import com.android.settings.R
import com.android.settings.SettingsPreferenceFragment

class Miscellaneous : SettingsPreferenceFragment(), OnPreferenceChangeListener {

    override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)
        val context: Context = requireContext()
        val resources: Resources = context.resources
        addPreferencesFromResource(R.xml.misc_section)
        val resolver: ContentResolver = requireActivity().contentResolver
        val prefScreen: PreferenceScreen = preferenceScreen
    }

    override fun onPreferenceChange(preference: Preference, newValue: Any?): Boolean {
        return false
    }

    override fun getMetricsCategory(): Int {
        return MetricsProto.MetricsEvent.RYUUI
    }
}