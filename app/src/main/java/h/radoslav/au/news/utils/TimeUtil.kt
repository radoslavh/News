package h.radoslav.au.news.utils

import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*

object TimeUtil {

	private const val TIME_FORMAT_PATTERN = "HH:mm:ss a  dd-MMM-yy"
	private const val TIME_FORMAT_RECEIVED = "yyyy-MM-dd'T'HH:mm:ss'Z'"

	private val formatTo: SimpleDateFormat = SimpleDateFormat(TIME_FORMAT_PATTERN, Locale.getDefault())
	private val formatFrom: SimpleDateFormat = SimpleDateFormat(TIME_FORMAT_RECEIVED, Locale.getDefault())

	fun timeFormat(time: String?): String {
		return try {
			formatTo.format(formatFrom.parse(time))
		} catch (e: Throwable){
			Timber.d(e)
			""
		}
	}
}