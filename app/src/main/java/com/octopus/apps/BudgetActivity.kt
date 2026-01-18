package com.octopus.apps

import android.os.Bundle

class BudgetActivity : BaseWebViewActivity() {
    
    override fun getUrl(): String {
        val serverUrl = getServerUrl().trimEnd('/')
        val port = getPreferences().getString("budget_port", getString(R.string.budget_port_default)) ?: "3001"
        return "$serverUrl:$port"
    }
    
    override fun getToolbarTitle(): String {
        return getString(R.string.budget_tracker)
    }
}
