package com.example.turtlemintassignment;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile IssuesDataDao _issuesDataDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `tbl_issues` (`id` INTEGER, `issueId` INTEGER, `commentId` INTEGER, `title` TEXT, `updated_at` TEXT, `body` TEXT, `username` TEXT, `avatar_url` TEXT, `comment_url` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `tbl_comments` (`id` INTEGER, `issueId` INTEGER, `body` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '3e13527e5420e5fa044823ced0ef2eb2')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `tbl_issues`");
        _db.execSQL("DROP TABLE IF EXISTS `tbl_comments`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsTblIssues = new HashMap<String, TableInfo.Column>(9);
        _columnsTblIssues.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblIssues.put("issueId", new TableInfo.Column("issueId", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblIssues.put("commentId", new TableInfo.Column("commentId", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblIssues.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblIssues.put("updated_at", new TableInfo.Column("updated_at", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblIssues.put("body", new TableInfo.Column("body", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblIssues.put("username", new TableInfo.Column("username", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblIssues.put("avatar_url", new TableInfo.Column("avatar_url", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblIssues.put("comment_url", new TableInfo.Column("comment_url", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTblIssues = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTblIssues = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTblIssues = new TableInfo("tbl_issues", _columnsTblIssues, _foreignKeysTblIssues, _indicesTblIssues);
        final TableInfo _existingTblIssues = TableInfo.read(_db, "tbl_issues");
        if (! _infoTblIssues.equals(_existingTblIssues)) {
          return new RoomOpenHelper.ValidationResult(false, "tbl_issues(com.example.turtlemintassignment.IssuesData).\n"
                  + " Expected:\n" + _infoTblIssues + "\n"
                  + " Found:\n" + _existingTblIssues);
        }
        final HashMap<String, TableInfo.Column> _columnsTblComments = new HashMap<String, TableInfo.Column>(3);
        _columnsTblComments.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblComments.put("issueId", new TableInfo.Column("issueId", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblComments.put("body", new TableInfo.Column("body", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTblComments = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTblComments = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTblComments = new TableInfo("tbl_comments", _columnsTblComments, _foreignKeysTblComments, _indicesTblComments);
        final TableInfo _existingTblComments = TableInfo.read(_db, "tbl_comments");
        if (! _infoTblComments.equals(_existingTblComments)) {
          return new RoomOpenHelper.ValidationResult(false, "tbl_comments(com.example.turtlemintassignment.CommentsData).\n"
                  + " Expected:\n" + _infoTblComments + "\n"
                  + " Found:\n" + _existingTblComments);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "3e13527e5420e5fa044823ced0ef2eb2", "f4cc803b0c50e42dfa45b45cb9621607");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "tbl_issues","tbl_comments");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `tbl_issues`");
      _db.execSQL("DELETE FROM `tbl_comments`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public IssuesDataDao issueDao() {
    if (_issuesDataDao != null) {
      return _issuesDataDao;
    } else {
      synchronized(this) {
        if(_issuesDataDao == null) {
          _issuesDataDao = new IssuesDataDao_Impl(this);
        }
        return _issuesDataDao;
      }
    }
  }
}
