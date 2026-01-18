package com.octopus.apps

import android.os.Bundle
import android.webkit.CookieManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.google.android.material.appbar.MaterialToolbar

class SettingsActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.settings)
        
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.settings_container, SettingsFragment())
                .commit()
        }
    }
    
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    
    class SettingsFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.preferences, rootKey)
            
            // Handle clear cache preference
            findPreference<Preference>("clear_cache")?.setOnPreferenceClickListener {
                clearCache()
                true
            }
        }
        
        private fun clearCache() {
            // Clear WebView cache
            requireActivity().applicationContext.cacheDir.deleteRecursively()
            
            // Clear cookies
            CookieManager.getInstance().removeAllCookies(null)
            CookieManager.getInstance().flush()
            
            Toast.makeText(
                requireContext(),
                R.string.cache_cleared,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
