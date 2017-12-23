package h.radoslav.au.news.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class TimeUtil {

    companion object {

        private val TIME_FORMAT_PATTERN: String = "HH:mm:ss a  dd-MMM-yy"
        private val TIME_FORMAT_RECEIVED: String = "yyyy-MM-dd'T'HH:mm:ss'Z'"

        private val formatTo: SimpleDateFormat = SimpleDateFormat(TIME_FORMAT_PATTERN, Locale.getDefault())
        private val formatFrom: SimpleDateFormat = SimpleDateFormat(TIME_FORMAT_RECEIVED, Locale.getDefault())

        fun timeFormat(time: String?): String {
            return try {
                formatTo.format(formatFrom.parse(time))
            } catch (e: ParseException) {
                ""
            } catch (e: NullPointerException) {
                ""
            }
        }
    }

}