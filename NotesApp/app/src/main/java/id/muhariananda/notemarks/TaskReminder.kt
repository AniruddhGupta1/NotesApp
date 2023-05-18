package id.muhariananda.notemarks

import android.app.Application
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class TaskReminder @Inject constructor(
    private val application: Application
) {

    private val workManager = WorkManager.getInstance(application)

    fun setTaskReminder(task: String, duration: Long) {
        val data = workDataOf(
            Constant.KEY_TASK to task
        )

        val workRequest = OneTimeWorkRequestBuilder<TodoWorker>()
            .setInputData(data)
            .addTag(task)
            .setInitialDelay(duration, TimeUnit.SECONDS)
            .build()

        workManager.enqueue(workRequest)
    }

    fun cancelTaskReminder(task: String) {
        workManager.cancelAllWorkByTag(task)
    }

}