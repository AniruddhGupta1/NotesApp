package id.muhariananda.notemarks

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import id.muhariananda.notemarks.data.todo.TodoDao

@Database(
    entities = [Note::class, Todo::class],
    version = 3,
    exportSchema = false
)
@TypeConverters(DatabaseConverter::class)
abstract class AppNotesDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
    abstract fun toDoDao(): TodoDao
}