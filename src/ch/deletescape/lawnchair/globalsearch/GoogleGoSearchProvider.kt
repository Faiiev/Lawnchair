package ch.deletescape.lawnchair.globalsearch

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.support.annotation.Keep
import com.android.launcher3.R
import com.android.launcher3.util.PackageManagerHelper

@Keep
class GoogleGoSearchProvider(context: Context) : SearchProvider(context) {

    private val PACKAGE = "com.google.android.apps.searchlite"

    override val name = context.getString(R.string.search_provider_google_go)!!
    override val supportsVoiceSearch = true
    override val supportsAssistant = false
    override val isAvailable: Boolean
        get() = PackageManagerHelper.isAppEnabled(context.packageManager, PACKAGE, 0)

    override fun startSearch(callback: (intent: Intent) -> Unit) = callback(Intent("com.google.android.apps.searchlite.SEARCH").putExtra("showKeyboard", true).putExtra("com.google.android.apps.searchlite.SKIP_BYPASS_AND_ONBOARDING", true).setPackage(PACKAGE))
    override fun startVoiceSearch(callback: (intent: Intent) -> Unit) = callback(Intent("com.google.android.apps.searchlite.SEARCH").putExtra("openMic", true).putExtra("com.google.android.apps.searchlite.SKIP_BYPASS_AND_ONBOARDING", true).setPackage(PACKAGE))

    override fun getIcon(colored: Boolean): Drawable = context.getDrawable(if (colored) {
        R.drawable.ic_super_g_color
    } else {
        R.drawable.ic_super_g_shadow
    })

    override fun getVoiceIcon(colored: Boolean): Drawable = context.getDrawable(if (colored) {
        R.drawable.ic_mic_color
    } else {
        R.drawable.ic_mic_shadow
    })
}