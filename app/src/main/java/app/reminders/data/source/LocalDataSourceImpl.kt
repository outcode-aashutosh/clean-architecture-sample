package app.reminders.data.source

import app.reminders.data.database.AppDao
import app.reminders.data.database.entities.ReminderEntity
import kotlinx.coroutines.flow.Flow

class LocalDataSourceImpl(private val appDao: AppDao) : LocalDataSource {
    override suspend fun getAllReminders(): Flow<List<ReminderEntity>> {
        return appDao.getAllReminders()
    }

    override suspend fun addReminder(entity: ReminderEntity) {
        appDao.addReminder(entity)
    }

    override suspend fun editReminder(id: String, title: String, dueDate: String) {
        appDao.updateReminder(queryTitle = title, queryDueDate = dueDate, queryId = id)
    }

    override suspend fun deleteReminder(id: String) {
        appDao.deleteReminder(queryId = id)
    }

}