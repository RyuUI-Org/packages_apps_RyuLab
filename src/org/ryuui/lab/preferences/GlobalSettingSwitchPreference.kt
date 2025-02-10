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

import android.content.Context
import android.util.AttributeSet
import androidx.preference.SwitchPreference

class GlobalSettingSwitchPreference : SwitchPreference {

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        preferenceDataStore = GlobalSettingsStore(context.contentResolver)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        preferenceDataStore = GlobalSettingsStore(context.contentResolver)
    }

    constructor(context: Context) : super(context) {
        preferenceDataStore = GlobalSettingsStore(context.contentResolver)
    }

    override fun onSetInitialValue(restoreValue: Boolean, defaultValue: Any?) {
        isChecked = if (restoreValue) {
            getPersistedBoolean(defaultValue as? Boolean ?: false)
        } else {
            defaultValue as? Boolean ?: false
        }
    }
}