package h.radoslav.au.news

import android.app.Application
import com.squareup.leakcanary.LeakCanary
import h.radoslav.au.news.di.AppModule
import h.radoslav.au.news.di.Components
import h.radoslav.au.news.di.DaggerComponents
import h.radoslav.au.news.di.RestModule
import timber.log.Timber
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

class NewsApplication : Application() {

	companion object {
		lateinit var COMPONENTS: Components
	}

	override fun onCreate() {
		super.onCreate()
		if (!LeakCanary.isInAnalyzerProcess(this)) {
			LeakCanary.install(this)
			initTimber()
			initFabric()
			initComponents()
		}
	}

	private fun initTimber() {
		Timber.plant(Timber.DebugTree())
		Timber.d("Timber initialized")
	}

	private fun initFabric() {
		Fabric.with(this@NewsApplication, Crashlytics())
		Timber.d("Crashlytics initialized")
	}

	private fun initComponents() {
		COMPONENTS = DaggerComponents.builder()
				.appModule(AppModule(this))
				.restModule(RestModule())
				.build()
		Timber.d("COMPONENTS initialized")
	}

}