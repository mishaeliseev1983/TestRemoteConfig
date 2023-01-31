package com.melyseev.testremoteconfig.presentation


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.melyseev.testremoteconfig.App
import com.melyseev.testremoteconfig.R
import com.melyseev.testremoteconfig.presentation.dummy_fragment.DummyFragment
import com.melyseev.testremoteconfig.presentation.message_fragment.MessageFragment
import com.melyseev.testremoteconfig.presentation.webview_fragment.WebViewFragment
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModuleFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }

    private val daggerApplicationComponent by lazy {
        (application as App).component
    }


    val TAG = "MainActivity Log"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        daggerApplicationComponent.inject(this)
        viewModel.liveData.observe(this) {
            if (it.isEmpty())
                showRemoteUrlOrDUMMY()
            else
                showLocalUrlOrNotInternet(it)
        }
        viewModel.readLocalUrl()
    }


    fun showRemoteUrlOrDUMMY() {
        val remoteConfig = Firebase.remoteConfig
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 90
        }

        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)
        remoteConfig.fetchAndActivate()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val updated = task.result

                    val remoteUrl = remoteConfig.getString("url")

                    if (remoteUrl.isEmpty()) {
                        val dummyFragment = DummyFragment()
                        supportFragmentManager.beginTransaction()
                            .add(R.id.container, dummyFragment).commit()
                    } else {
                        viewModel.writeUrl(remoteUrl)
                        val fragmentWebView = WebViewFragment.newInstance(remoteUrl)
                        supportFragmentManager.beginTransaction()
                            .add(R.id.container, fragmentWebView).commit()
                    }

                    Log.d(TAG, "Config params updated: $updated")
                    /* Toast.makeText(
                         this, "Fetch and activate succeeded",
                         Toast.LENGTH_SHORT
                     ).show()

                      */
                } else {
                    Toast.makeText(
                        this, "Fetch failed",
                        Toast.LENGTH_SHORT
                    ).show()
                }


            }
    }

    fun showLocalUrlOrNotInternet(urlLocal: String) {
        if (isDeviceOnline(applicationContext)) {
            val webViewFragment = WebViewFragment.newInstance(urlLocal)
            supportFragmentManager.beginTransaction()
                .add(R.id.container, webViewFragment).commit()
        } else {
            val messageFragment = MessageFragment.newInstance(getString(R.string.no_internet))
            supportFragmentManager.beginTransaction().add(R.id.container, messageFragment).commit()
        }
    }

    private fun isDeviceOnline(context: Context): Boolean {
        return true
    }

}