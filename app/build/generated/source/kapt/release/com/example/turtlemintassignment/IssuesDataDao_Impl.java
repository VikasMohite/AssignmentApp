package com.example.turtlemintassignment;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class IssuesDataDao_Impl implements IssuesDataDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<IssuesData> __insertionAdapterOfIssuesData;

  private final EntityInsertionAdapter<CommentsData> __insertionAdapterOfCommentsData;

  public IssuesDataDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfIssuesData = new EntityInsertionAdapter<IssuesData>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `tbl_issues` (`id`,`issueId`,`commentId`,`title`,`updated_at`,`body`,`username`,`avatar_url`,`comment_url`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, IssuesData value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getIssueId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getIssueId());
        }
        if (value.getCommentId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getCommentId());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTitle());
        }
        if (value.getUpdated_at() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUpdated_at());
        }
        if (value.getBody() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getBody());
        }
        if (value.getUsername() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUsername());
        }
        if (value.getAvatar_url() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getAvatar_url());
        }
        if (value.getComment_url() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getComment_url());
        }
      }
    };
    this.__insertionAdapterOfCommentsData = new EntityInsertionAdapter<CommentsData>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `tbl_comments` (`id`,`issueId`,`body`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CommentsData value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getIssueId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getIssueId());
        }
        if (value.getBody() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getBody());
        }
      }
    };
  }

  @Override
  public void insertIssues(final IssuesData issuesData) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfIssuesData.insert(issuesData);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertComments(final CommentsData commentsData) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCommentsData.insert(commentsData);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<IssuesData> getIssuesData() {
    final String _sql = "SELECT * FROM tbl_issues";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfIssueId = CursorUtil.getColumnIndexOrThrow(_cursor, "issueId");
      final int _cursorIndexOfCommentId = CursorUtil.getColumnIndexOrThrow(_cursor, "commentId");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
      final int _cursorIndexOfBody = CursorUtil.getColumnIndexOrThrow(_cursor, "body");
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final int _cursorIndexOfAvatarUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "avatar_url");
      final int _cursorIndexOfCommentUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "comment_url");
      final List<IssuesData> _result = new ArrayList<IssuesData>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final IssuesData _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final Integer _tmpIssueId;
        if (_cursor.isNull(_cursorIndexOfIssueId)) {
          _tmpIssueId = null;
        } else {
          _tmpIssueId = _cursor.getInt(_cursorIndexOfIssueId);
        }
        final Integer _tmpCommentId;
        if (_cursor.isNull(_cursorIndexOfCommentId)) {
          _tmpCommentId = null;
        } else {
          _tmpCommentId = _cursor.getInt(_cursorIndexOfCommentId);
        }
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpUpdated_at;
        _tmpUpdated_at = _cursor.getString(_cursorIndexOfUpdatedAt);
        final String _tmpBody;
        _tmpBody = _cursor.getString(_cursorIndexOfBody);
        final String _tmpUsername;
        _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        final String _tmpAvatar_url;
        _tmpAvatar_url = _cursor.getString(_cursorIndexOfAvatarUrl);
        final String _tmpComment_url;
        _tmpComment_url = _cursor.getString(_cursorIndexOfCommentUrl);
        _item = new IssuesData(_tmpId,_tmpIssueId,_tmpCommentId,_tmpTitle,_tmpUpdated_at,_tmpBody,_tmpUsername,_tmpAvatar_url,_tmpComment_url);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<IssuesData> getIssueById(final Integer issueId) {
    final String _sql = "SELECT * FROM tbl_issues WHERE issueId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (issueId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, issueId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfIssueId = CursorUtil.getColumnIndexOrThrow(_cursor, "issueId");
      final int _cursorIndexOfCommentId = CursorUtil.getColumnIndexOrThrow(_cursor, "commentId");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
      final int _cursorIndexOfBody = CursorUtil.getColumnIndexOrThrow(_cursor, "body");
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final int _cursorIndexOfAvatarUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "avatar_url");
      final int _cursorIndexOfCommentUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "comment_url");
      final List<IssuesData> _result = new ArrayList<IssuesData>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final IssuesData _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final Integer _tmpIssueId;
        if (_cursor.isNull(_cursorIndexOfIssueId)) {
          _tmpIssueId = null;
        } else {
          _tmpIssueId = _cursor.getInt(_cursorIndexOfIssueId);
        }
        final Integer _tmpCommentId;
        if (_cursor.isNull(_cursorIndexOfCommentId)) {
          _tmpCommentId = null;
        } else {
          _tmpCommentId = _cursor.getInt(_cursorIndexOfCommentId);
        }
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpUpdated_at;
        _tmpUpdated_at = _cursor.getString(_cursorIndexOfUpdatedAt);
        final String _tmpBody;
        _tmpBody = _cursor.getString(_cursorIndexOfBody);
        final String _tmpUsername;
        _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        final String _tmpAvatar_url;
        _tmpAvatar_url = _cursor.getString(_cursorIndexOfAvatarUrl);
        final String _tmpComment_url;
        _tmpComment_url = _cursor.getString(_cursorIndexOfCommentUrl);
        _item = new IssuesData(_tmpId,_tmpIssueId,_tmpCommentId,_tmpTitle,_tmpUpdated_at,_tmpBody,_tmpUsername,_tmpAvatar_url,_tmpComment_url);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<CommentsData> getCommentsById(final Integer issueId) {
    final String _sql = "SELECT * FROM tbl_comments WHERE issueId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (issueId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, issueId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfIssueId = CursorUtil.getColumnIndexOrThrow(_cursor, "issueId");
      final int _cursorIndexOfBody = CursorUtil.getColumnIndexOrThrow(_cursor, "body");
      final List<CommentsData> _result = new ArrayList<CommentsData>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CommentsData _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final Integer _tmpIssueId;
        if (_cursor.isNull(_cursorIndexOfIssueId)) {
          _tmpIssueId = null;
        } else {
          _tmpIssueId = _cursor.getInt(_cursorIndexOfIssueId);
        }
        final String _tmpBody;
        _tmpBody = _cursor.getString(_cursorIndexOfBody);
        _item = new CommentsData(_tmpId,_tmpIssueId,_tmpBody);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
