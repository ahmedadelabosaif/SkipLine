
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor


class DarkMode {
    var pref: SharedPreferences? = null
    var editor: Editor? = null

    private val IS_NIGHT_MODE = "IsNightMode"


    fun setDarkMode(isFirstTime: Boolean) {
        editor!!.putBoolean(IS_NIGHT_MODE, isFirstTime)
        editor!!.commit()
    }

    fun isNightMode(): Boolean {
        return pref!!.getBoolean(IS_NIGHT_MODE, true)
    }

}