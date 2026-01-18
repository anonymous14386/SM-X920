package com.octopus.apps

import android.os.Bundle

class HealthActivity : BaseWebViewActivity() {
    
    override fun getUrl(): String {
        val serverUrl = getServerUrl().trimEnd('/')
        val port = getPreferences().getString("health_port", getString(R.string.health_port_default)) ?: "3002"
        return "$serverUrl:$port"
    }
    
    override fun getToolbarTitle(): String {
        return getString(R.string.health_tracker)
    }
}
