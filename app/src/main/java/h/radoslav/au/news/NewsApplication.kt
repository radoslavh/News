package h.radoslav.au.news

import android.app.Application
import com.squareup.leakcanary.LeakCanary
import h.radoslav.au.news.di.AppModule
import h.radoslav.au.news.di.Components
import h.radoslav.au.news.di.DaggerComponents
import h.radoslav.au.news.di.RestModule
import timber.log.Timber

class NewsApplication : Application() {

	companion object {
		lateinit var COMPONENTS: Components
	}

	override fun onCreate() {
		super.onCreate()
		if (!LeakCanary.isInAnalyzerProcess(this)) {
			LeakCanary.install(this)
			initTimber()
			initComponents()
		}
	}

	private fun initTimber() {
		Timber.plant(Timber.DebugTree())
	}

	private fun initComponents() {
		COMPONENTS = DaggerComponents.builder()
				.appModule(AppModule(this))
				.restModule(RestModule())
				.build()
	}
}